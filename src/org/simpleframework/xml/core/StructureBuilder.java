// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.strategy.Type;

// Referenced classes of package org.simpleframework.xml.core:
//            ExpressionBuilder, ModelAssembler, InstantiatorBuilder, TreeModel, 
//            LabelMap, Expression, Model, Support, 
//            Label, PersistenceException, TextException, AttributeException, 
//            ElementException, Scanner, Contact, UnionException, 
//            Structure, Instantiator, Detail

class StructureBuilder
{

    private ModelAssembler assembler;
    private LabelMap attributes;
    private ExpressionBuilder builder;
    private LabelMap elements;
    private Instantiator factory;
    private boolean primitive;
    private InstantiatorBuilder resolver;
    private Model root;
    private Scanner scanner;
    private Support support;
    private Label text;
    private LabelMap texts;
    private Label version;

    public StructureBuilder(Scanner scanner1, Detail detail, Support support1)
    {
        builder = new ExpressionBuilder(detail, support1);
        assembler = new ModelAssembler(builder, detail, support1);
        resolver = new InstantiatorBuilder(scanner1, detail);
        root = new TreeModel(scanner1, detail);
        attributes = new LabelMap(scanner1);
        elements = new LabelMap(scanner1);
        texts = new LabelMap(scanner1);
        scanner = scanner1;
        support = support1;
    }

    private Model create(Expression expression)
    {
        Model model = root;
        do
        {
            if (model == null)
            {
                break;
            }
            String s = expression.getPrefix();
            String s1 = expression.getFirst();
            int i = expression.getIndex();
            if (s1 != null)
            {
                model = model.register(s1, s, i);
            }
            if (!expression.isPath())
            {
                break;
            }
            expression = expression.getPath(1);
        } while (true);
        return model;
    }

    private boolean isAttribute(String s)
    {
        Expression expression = builder.build(s);
        Model model = lookup(expression);
        if (model != null)
        {
            String s1 = expression.getLast();
            if (!expression.isPath())
            {
                return model.isAttribute(s);
            } else
            {
                return model.isAttribute(s1);
            }
        } else
        {
            return false;
        }
    }

    private boolean isElement(String s)
    {
        Model model;
        String s1;
        int i;
        Expression expression = builder.build(s);
        model = lookup(expression);
        if (model == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        s1 = expression.getLast();
        i = expression.getIndex();
        if (!model.isElement(s1)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!model.isModel(s1))
        {
            break MISSING_BLOCK_LABEL_79;
        }
        if (!model.lookup(s1, i).isEmpty()) goto _L1; else goto _L3
_L3:
        return false;
        return false;
    }

    private boolean isEmpty()
    {
        if (text != null)
        {
            return false;
        } else
        {
            return root.isEmpty();
        }
    }

    private Model lookup(Expression expression)
    {
        Expression expression1 = expression.getPath(0, 1);
        if (expression.isPath())
        {
            return root.lookup(expression1);
        } else
        {
            return root;
        }
    }

    private void process(Contact contact, Annotation annotation, LabelMap labelmap)
    {
        Label label = support.getLabel(contact, annotation);
        String s = label.getPath();
        String s1 = label.getName();
        if (labelmap.get(s) != null)
        {
            throw new PersistenceException("Duplicate annotation of name '%s' on %s", new Object[] {
                s1, contact
            });
        } else
        {
            process(contact, label, labelmap);
            return;
        }
    }

    private void process(Contact contact, Label label, LabelMap labelmap)
    {
        Expression expression = label.getExpression();
        String s = label.getPath();
        Model model = root;
        if (!expression.isEmpty())
        {
            model = register(expression);
        }
        resolver.register(label);
        model.register(label);
        labelmap.put(s, label);
    }

    private Model register(Expression expression)
    {
        Model model = root.lookup(expression);
        if (model != null)
        {
            return model;
        } else
        {
            return create(expression);
        }
    }

    private void text(Contact contact, Annotation annotation)
    {
        Label label = support.getLabel(contact, annotation);
        Expression expression = label.getExpression();
        String s = label.getPath();
        Model model = root;
        if (!expression.isEmpty())
        {
            model = register(expression);
        }
        if (texts.get(s) != null)
        {
            throw new TextException("Multiple text annotations in %s", new Object[] {
                annotation
            });
        } else
        {
            resolver.register(label);
            model.register(label);
            texts.put(s, label);
            return;
        }
    }

    private void union(Contact contact, Annotation annotation, LabelMap labelmap)
    {
        Label label;
        for (Iterator iterator = support.getLabels(contact, annotation).iterator(); iterator.hasNext(); process(contact, label, labelmap))
        {
            label = (Label)iterator.next();
            String s = label.getPath();
            String s1 = label.getName();
            if (labelmap.get(s) != null)
            {
                throw new PersistenceException("Duplicate annotation of name '%s' on %s", new Object[] {
                    s1, label
                });
            }
        }

    }

    private void validateAttributes(Class class1, Order order)
    {
        if (order != null)
        {
            String as[] = order.attributes();
            int i = as.length;
            for (int j = 0; j < i; j++)
            {
                String s = as[j];
                if (!isAttribute(s))
                {
                    throw new AttributeException("Ordered attribute '%s' missing in %s", new Object[] {
                        s, class1
                    });
                }
            }

        }
    }

    private void validateElements(Class class1, Order order)
    {
        if (order != null)
        {
            String as[] = order.elements();
            int i = as.length;
            for (int j = 0; j < i; j++)
            {
                String s = as[j];
                if (!isElement(s))
                {
                    throw new ElementException("Ordered element '%s' missing for %s", new Object[] {
                        s, class1
                    });
                }
            }

        }
    }

    private void validateModel(Class class1)
    {
        if (!root.isEmpty())
        {
            root.validate(class1);
        }
    }

    private void validateText(Class class1)
    {
        Label label = root.getText();
        if (label != null)
        {
            if (!label.isTextList())
            {
                if (!elements.isEmpty())
                {
                    throw new TextException("Elements used with %s in %s", new Object[] {
                        label, class1
                    });
                }
                if (root.isComposite())
                {
                    throw new TextException("Paths used with %s in %s", new Object[] {
                        label, class1
                    });
                }
            }
        } else
        if (scanner.isEmpty())
        {
            primitive = isEmpty();
        }
    }

    private void validateTextList(Class class1)
    {
        Label label = root.getText();
        if (label != null && label.isTextList())
        {
            Object obj = label.getKey();
            for (Iterator iterator = elements.iterator(); iterator.hasNext();)
            {
                Label label1 = (Label)iterator.next();
                if (!label1.getKey().equals(obj))
                {
                    throw new TextException("Elements used with %s in %s", new Object[] {
                        label, class1
                    });
                }
                Class class2 = label1.getDependent().getType();
                if (class2 == java/lang/String)
                {
                    throw new TextException("Illegal entry of %s with text annotations on %s in %s", new Object[] {
                        class2, label, class1
                    });
                }
            }

            if (root.isComposite())
            {
                throw new TextException("Paths used with %s in %s", new Object[] {
                    label, class1
                });
            }
        }
    }

    private void validateUnions(Class class1)
    {
        for (Iterator iterator = elements.iterator(); iterator.hasNext();)
        {
            Label label = (Label)iterator.next();
            String as[] = label.getPaths();
            Contact contact = label.getContact();
            int i = as.length;
            int j = 0;
            while (j < i) 
            {
                String s = as[j];
                Annotation annotation = contact.getAnnotation();
                Label label1 = (Label)elements.get(s);
                if (label.isInline() != label1.isInline())
                {
                    throw new UnionException("Inline must be consistent in %s for %s", new Object[] {
                        annotation, contact
                    });
                }
                if (label.isRequired() != label1.isRequired())
                {
                    throw new UnionException("Required must be consistent in %s for %s", new Object[] {
                        annotation, contact
                    });
                }
                j++;
            }
        }

    }

    private void version(Contact contact, Annotation annotation)
    {
        Label label = support.getLabel(contact, annotation);
        if (version != null)
        {
            throw new AttributeException("Multiple version annotations in %s", new Object[] {
                annotation
            });
        } else
        {
            version = label;
            return;
        }
    }

    public void assemble(Class class1)
    {
        Order order = scanner.getOrder();
        if (order != null)
        {
            assembler.assemble(root, order);
        }
    }

    public Structure build(Class class1)
    {
        return new Structure(factory, root, version, text, primitive);
    }

    public void commit(Class class1)
    {
        if (factory == null)
        {
            factory = resolver.build();
        }
    }

    public void process(Contact contact, Annotation annotation)
    {
        if (annotation instanceof Attribute)
        {
            process(contact, annotation, attributes);
        }
        if (annotation instanceof ElementUnion)
        {
            union(contact, annotation, elements);
        }
        if (annotation instanceof ElementListUnion)
        {
            union(contact, annotation, elements);
        }
        if (annotation instanceof ElementMapUnion)
        {
            union(contact, annotation, elements);
        }
        if (annotation instanceof ElementList)
        {
            process(contact, annotation, elements);
        }
        if (annotation instanceof ElementArray)
        {
            process(contact, annotation, elements);
        }
        if (annotation instanceof ElementMap)
        {
            process(contact, annotation, elements);
        }
        if (annotation instanceof Element)
        {
            process(contact, annotation, elements);
        }
        if (annotation instanceof Version)
        {
            version(contact, annotation);
        }
        if (annotation instanceof Text)
        {
            text(contact, annotation);
        }
    }

    public void validate(Class class1)
    {
        Order order = scanner.getOrder();
        validateUnions(class1);
        validateElements(class1, order);
        validateAttributes(class1, order);
        validateModel(class1);
        validateText(class1);
        validateTextList(class1);
    }
}
