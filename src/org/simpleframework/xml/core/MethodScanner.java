// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Transient;
import org.simpleframework.xml.Version;

// Referenced classes of package org.simpleframework.xml.core:
//            ContactList, MethodPartFactory, MethodPart, MethodContact, 
//            MethodException, Support, Contact, Detail, 
//            MethodDetail, MethodType

class MethodScanner extends ContactList
{

    private final Detail detail;
    private final MethodPartFactory factory;
    private final PartMap read = new PartMap(null);
    private final Support support;
    private final PartMap write = new PartMap(null);

    public MethodScanner(Detail detail1, Support support1)
    {
        factory = new MethodPartFactory(detail1, support1);
        support = support1;
        detail = detail1;
        scan(detail1);
    }

    private void build()
    {
        Iterator iterator = read.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            MethodPart methodpart = (MethodPart)read.get(s);
            if (methodpart != null)
            {
                build(methodpart, s);
            }
        } while (true);
    }

    private void build(MethodPart methodpart)
    {
        add(new MethodContact(methodpart));
    }

    private void build(MethodPart methodpart, String s)
    {
        MethodPart methodpart1 = write.take(s);
        if (methodpart1 != null)
        {
            build(methodpart, methodpart1);
            return;
        } else
        {
            build(methodpart);
            return;
        }
    }

    private void build(MethodPart methodpart, MethodPart methodpart1)
    {
        Annotation annotation = methodpart.getAnnotation();
        String s = methodpart.getName();
        if (!methodpart1.getAnnotation().equals(annotation))
        {
            Object aobj[] = new Object[2];
            aobj[0] = s;
            aobj[1] = detail;
            throw new MethodException("Annotations do not match for '%s' in %s", aobj);
        }
        Class class1 = methodpart.getType();
        if (class1 != methodpart1.getType())
        {
            throw new MethodException("Method types do not match for %s in %s", new Object[] {
                s, class1
            });
        } else
        {
            add(new MethodContact(methodpart, methodpart1));
            return;
        }
    }

    private void extend(Class class1, DefaultType defaulttype)
    {
        for (Iterator iterator = support.getMethods(class1, defaulttype).iterator(); iterator.hasNext(); process((MethodContact)(Contact)iterator.next())) { }
    }

    private void extract(Detail detail1)
    {
        for (Iterator iterator = detail1.getMethods().iterator(); iterator.hasNext();)
        {
            MethodDetail methoddetail = (MethodDetail)iterator.next();
            Annotation aannotation[] = methoddetail.getAnnotations();
            Method method = methoddetail.getMethod();
            int i = aannotation.length;
            int j = 0;
            while (j < i) 
            {
                scan(method, aannotation[j], aannotation);
                j++;
            }
        }

    }

    private void extract(Detail detail1, DefaultType defaulttype)
    {
        List list = detail1.getMethods();
        if (defaulttype == DefaultType.PROPERTY)
        {
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                MethodDetail methoddetail = (MethodDetail)iterator.next();
                Annotation aannotation[] = methoddetail.getAnnotations();
                Method method = methoddetail.getMethod();
                if (factory.getType(method) != null)
                {
                    process(method, aannotation);
                }
            } while (true);
        }
    }

    private void insert(MethodPart methodpart, PartMap partmap)
    {
        String s = methodpart.getName();
        MethodPart methodpart1 = (MethodPart)partmap.remove(s);
        if (methodpart1 != null && isText(methodpart))
        {
            methodpart = methodpart1;
        }
        partmap.put(s, methodpart);
    }

    private boolean isText(MethodPart methodpart)
    {
        return methodpart.getAnnotation() instanceof Text;
    }

    private void process(Method method, Annotation annotation, Annotation aannotation[])
    {
        MethodPart methodpart = factory.getInstance(method, annotation, aannotation);
        MethodType methodtype = methodpart.getMethodType();
        if (methodtype == MethodType.GET)
        {
            process(methodpart, read);
        }
        if (methodtype == MethodType.IS)
        {
            process(methodpart, read);
        }
        if (methodtype == MethodType.SET)
        {
            process(methodpart, write);
        }
    }

    private void process(Method method, Annotation aannotation[])
    {
        MethodPart methodpart = factory.getInstance(method, aannotation);
        MethodType methodtype = methodpart.getMethodType();
        if (methodtype == MethodType.GET)
        {
            process(methodpart, read);
        }
        if (methodtype == MethodType.IS)
        {
            process(methodpart, read);
        }
        if (methodtype == MethodType.SET)
        {
            process(methodpart, write);
        }
    }

    private void process(MethodContact methodcontact)
    {
        MethodPart methodpart = methodcontact.getRead();
        MethodPart methodpart1 = methodcontact.getWrite();
        if (methodpart1 != null)
        {
            insert(methodpart1, write);
        }
        insert(methodpart, read);
    }

    private void process(MethodPart methodpart, PartMap partmap)
    {
        String s = methodpart.getName();
        if (s != null)
        {
            partmap.put(s, methodpart);
        }
    }

    private void remove(Method method, Annotation annotation, Annotation aannotation[])
    {
        MethodPart methodpart = factory.getInstance(method, annotation, aannotation);
        MethodType methodtype = methodpart.getMethodType();
        if (methodtype == MethodType.GET)
        {
            remove(methodpart, read);
        }
        if (methodtype == MethodType.IS)
        {
            remove(methodpart, read);
        }
        if (methodtype == MethodType.SET)
        {
            remove(methodpart, write);
        }
    }

    private void remove(MethodPart methodpart, PartMap partmap)
    {
        String s = methodpart.getName();
        if (s != null)
        {
            partmap.remove(s);
        }
    }

    private void scan(Method method, Annotation annotation, Annotation aannotation[])
    {
        if (annotation instanceof Attribute)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof ElementUnion)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof ElementListUnion)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof ElementMapUnion)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof ElementList)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof ElementArray)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof ElementMap)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof Element)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof Version)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof Text)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof Transient)
        {
            remove(method, annotation, aannotation);
        }
    }

    private void scan(Detail detail1)
    {
        DefaultType defaulttype = detail1.getOverride();
        DefaultType defaulttype1 = detail1.getAccess();
        Class class1 = detail1.getSuper();
        if (class1 != null)
        {
            extend(class1, defaulttype);
        }
        extract(detail1, defaulttype1);
        extract(detail1);
        build();
        validate();
    }

    private void validate()
    {
        Iterator iterator = write.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            MethodPart methodpart = (MethodPart)write.get(s);
            if (methodpart != null)
            {
                validate(methodpart, s);
            }
        } while (true);
    }

    private void validate(MethodPart methodpart, String s)
    {
        MethodPart methodpart1 = read.take(s);
        Method method = methodpart.getMethod();
        if (methodpart1 == null)
        {
            Object aobj[] = new Object[2];
            aobj[0] = method;
            aobj[1] = detail;
            throw new MethodException("No matching get method for %s in %s", aobj);
        } else
        {
            return;
        }
    }

    private class PartMap extends LinkedHashMap
        implements Iterable
    {

        public Iterator iterator()
        {
            return keySet().iterator();
        }

        public MethodPart take(String s)
        {
            return (MethodPart)remove(s);
        }

        private PartMap()
        {
        }

        PartMap(_cls1 _pcls1)
        {
            this();
        }
    }

}
