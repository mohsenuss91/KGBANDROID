// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Comparer, LabelMap, SignatureCreator, Scanner, 
//            ClassInstantiator, CacheParameter, Signature, Parameter, 
//            Label, ParameterMap, ConstructorException, Creator, 
//            Contact, Instantiator, Support, Detail

class InstantiatorBuilder
{

    private LabelMap attributes;
    private Comparer comparer;
    private Detail detail;
    private LabelMap elements;
    private Instantiator factory;
    private List options;
    private Scanner scanner;
    private LabelMap texts;

    public InstantiatorBuilder(Scanner scanner1, Detail detail1)
    {
        options = new ArrayList();
        comparer = new Comparer();
        attributes = new LabelMap();
        elements = new LabelMap();
        texts = new LabelMap();
        scanner = scanner1;
        detail = detail1;
    }

    private Instantiator build(Detail detail1)
    {
        if (factory == null)
        {
            factory = create(detail1);
        }
        return factory;
    }

    private boolean contains(String as[], String s)
    {
        int i = as.length;
        for (int j = 0; j < i; j++)
        {
            for (String s1 = as[j]; s1 == s || s1.equals(s);)
            {
                return true;
            }

        }

        return false;
    }

    private Creator create(Signature signature)
    {
        SignatureCreator signaturecreator = new SignatureCreator(signature);
        if (signature != null)
        {
            options.add(signaturecreator);
        }
        return signaturecreator;
    }

    private Instantiator create(Detail detail1)
    {
        Signature signature = scanner.getSignature();
        ParameterMap parametermap = scanner.getParameters();
        SignatureCreator signaturecreator = null;
        if (signature != null)
        {
            signaturecreator = new SignatureCreator(signature);
        }
        return new ClassInstantiator(options, signaturecreator, parametermap, detail1);
    }

    private Parameter create(Parameter parameter)
    {
        Label label = resolve(parameter);
        if (label != null)
        {
            return new CacheParameter(parameter, label);
        } else
        {
            return null;
        }
    }

    private void populate(Detail detail1)
    {
        for (Iterator iterator = scanner.getSignatures().iterator(); iterator.hasNext(); populate((Signature)iterator.next())) { }
    }

    private void populate(Signature signature)
    {
        Signature signature1 = new Signature(signature);
        Iterator iterator = signature.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Parameter parameter = create((Parameter)iterator.next());
            if (parameter != null)
            {
                signature1.add(parameter);
            }
        } while (true);
        create(signature1);
    }

    private void register(Label label, LabelMap labelmap)
    {
        String s = label.getName();
        String s1 = label.getPath();
        if (labelmap.containsKey(s))
        {
            if (!((Label)labelmap.get(s)).getPath().equals(s))
            {
                labelmap.remove(s);
            }
        } else
        {
            labelmap.put(s, label);
        }
        labelmap.put(s1, label);
    }

    private Label resolve(Parameter parameter)
    {
        if (parameter.isAttribute())
        {
            return resolve(parameter, attributes);
        }
        if (parameter.isText())
        {
            return resolve(parameter, texts);
        } else
        {
            return resolve(parameter, elements);
        }
    }

    private Label resolve(Parameter parameter, LabelMap labelmap)
    {
        String s = parameter.getName();
        Label label = (Label)labelmap.get(parameter.getPath());
        if (label == null)
        {
            label = (Label)labelmap.get(s);
        }
        return label;
    }

    private void validate(Detail detail1)
    {
        Parameter parameter;
        Label label;
        for (Iterator iterator = scanner.getParameters().getAll().iterator(); iterator.hasNext(); validateParameter(label, parameter))
        {
            parameter = (Parameter)iterator.next();
            label = resolve(parameter);
            String s = parameter.getPath();
            if (label == null)
            {
                throw new ConstructorException("Parameter '%s' does not have a match in %s", new Object[] {
                    s, detail1
                });
            }
        }

        validateConstructors();
    }

    private void validateAnnotations(Label label, Parameter parameter)
    {
        Annotation annotation = label.getAnnotation();
        Annotation annotation1 = parameter.getAnnotation();
        String s = parameter.getName();
        if (!comparer.equals(annotation, annotation1))
        {
            Class class1 = annotation.annotationType();
            Class class2 = annotation1.annotationType();
            if (!class1.equals(class2))
            {
                throw new ConstructorException("Annotation %s does not match %s for '%s' in %s", new Object[] {
                    class2, class1, s, parameter
                });
            }
        }
    }

    private void validateConstructor(Label label, List list)
    {
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Signature signature = ((Creator)iterator.next()).getSignature();
            Contact contact = label.getContact();
            Object obj = label.getKey();
            if (contact.isReadOnly() && signature.get(obj) == null)
            {
                iterator.remove();
            }
        } while (true);
    }

    private void validateConstructors()
    {
        List list = factory.getCreators();
        if (factory.isDefault())
        {
            validateConstructors(elements);
            validateConstructors(attributes);
        }
        if (!list.isEmpty())
        {
            validateConstructors(elements, list);
            validateConstructors(attributes, list);
        }
    }

    private void validateConstructors(LabelMap labelmap)
    {
        for (Iterator iterator = labelmap.iterator(); iterator.hasNext();)
        {
            Label label = (Label)iterator.next();
            if (label != null && label.getContact().isReadOnly())
            {
                Object aobj[] = new Object[2];
                aobj[0] = label;
                aobj[1] = detail;
                throw new ConstructorException("Default constructor can not accept read only %s in %s", aobj);
            }
        }

    }

    private void validateConstructors(LabelMap labelmap, List list)
    {
        Iterator iterator = labelmap.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Label label = (Label)iterator.next();
            if (label != null)
            {
                validateConstructor(label, list);
            }
        } while (true);
        if (list.isEmpty())
        {
            Object aobj[] = new Object[1];
            aobj[0] = detail;
            throw new ConstructorException("No constructor accepts all read only values in %s", aobj);
        } else
        {
            return;
        }
    }

    private void validateNames(Label label, Parameter parameter)
    {
        String as[] = label.getNames();
        String s = parameter.getName();
        if (!contains(as, s))
        {
            String s1 = label.getName();
            if (s != s1)
            {
                if (s == null || s1 == null)
                {
                    throw new ConstructorException("Annotation does not match %s for '%s' in %s", new Object[] {
                        label, s, parameter
                    });
                }
                if (!s.equals(s1))
                {
                    throw new ConstructorException("Annotation does not match %s for '%s' in %s", new Object[] {
                        label, s, parameter
                    });
                }
            }
        }
    }

    private void validateParameter(Label label, Parameter parameter)
    {
        Contact contact = label.getContact();
        String s = parameter.getName();
        if (!Support.isAssignable(parameter.getType(), contact.getType()))
        {
            throw new ConstructorException("Type is not compatible with %s for '%s' in %s", new Object[] {
                label, s, parameter
            });
        } else
        {
            validateNames(label, parameter);
            validateAnnotations(label, parameter);
            return;
        }
    }

    public Instantiator build()
    {
        if (factory == null)
        {
            populate(detail);
            build(detail);
            validate(detail);
        }
        return factory;
    }

    public void register(Label label)
    {
        if (label.isAttribute())
        {
            register(label, attributes);
            return;
        }
        if (label.isText())
        {
            register(label, texts);
            return;
        } else
        {
            register(label, elements);
            return;
        }
    }
}
