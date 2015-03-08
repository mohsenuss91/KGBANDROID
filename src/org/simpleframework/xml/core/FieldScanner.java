// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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
//            ContactList, AnnotationFactory, ContactMap, Contact, 
//            Support, Detail, FieldDetail, Reflector, 
//            FieldContact

class FieldScanner extends ContactList
{

    private final ContactMap done = new ContactMap();
    private final AnnotationFactory factory;
    private final Support support;

    public FieldScanner(Detail detail, Support support1)
    {
        factory = new AnnotationFactory(detail, support1);
        support = support1;
        scan(detail);
    }

    private void build()
    {
        for (Iterator iterator = done.iterator(); iterator.hasNext(); add((Contact)iterator.next())) { }
    }

    private void extend(Class class1, DefaultType defaulttype)
    {
        ContactList contactlist = support.getFields(class1, defaulttype);
        if (contactlist != null)
        {
            addAll(contactlist);
        }
    }

    private void extract(Detail detail)
    {
        for (Iterator iterator = detail.getFields().iterator(); iterator.hasNext();)
        {
            FieldDetail fielddetail = (FieldDetail)iterator.next();
            Annotation aannotation[] = fielddetail.getAnnotations();
            Field field = fielddetail.getField();
            int i = aannotation.length;
            int j = 0;
            while (j < i) 
            {
                scan(field, aannotation[j], aannotation);
                j++;
            }
        }

    }

    private void extract(Detail detail, DefaultType defaulttype)
    {
        List list = detail.getFields();
        if (defaulttype == DefaultType.FIELD)
        {
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                FieldDetail fielddetail = (FieldDetail)iterator.next();
                Annotation aannotation[] = fielddetail.getAnnotations();
                Field field = fielddetail.getField();
                Class class1 = field.getType();
                if (!isStatic(field) && !isTransient(field))
                {
                    process(field, class1, aannotation);
                }
            } while (true);
        }
    }

    private void insert(Object obj, Contact contact)
    {
        Contact contact1 = (Contact)done.remove(obj);
        if (contact1 != null && isText(contact))
        {
            contact = contact1;
        }
        done.put(obj, contact);
    }

    private boolean isStatic(Field field)
    {
        return Modifier.isStatic(field.getModifiers());
    }

    private boolean isText(Contact contact)
    {
        return contact.getAnnotation() instanceof Text;
    }

    private boolean isTransient(Field field)
    {
        return Modifier.isTransient(field.getModifiers());
    }

    private void process(Field field, Class class1, Annotation aannotation[])
    {
        Class aclass[] = Reflector.getDependents(field);
        Annotation annotation = factory.getInstance(class1, aclass);
        if (annotation != null)
        {
            process(field, annotation, aannotation);
        }
    }

    private void process(Field field, Annotation annotation, Annotation aannotation[])
    {
        FieldContact fieldcontact = new FieldContact(field, annotation, aannotation);
        FieldKey fieldkey = new FieldKey(field);
        if (!field.isAccessible())
        {
            field.setAccessible(true);
        }
        insert(fieldkey, fieldcontact);
    }

    private void remove(Field field, Annotation annotation)
    {
        done.remove(new FieldKey(field));
    }

    private void scan(Field field, Annotation annotation, Annotation aannotation[])
    {
        if (annotation instanceof Attribute)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof ElementUnion)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof ElementListUnion)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof ElementMapUnion)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof ElementList)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof ElementArray)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof ElementMap)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof Element)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof Version)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof Text)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof Transient)
        {
            remove(field, annotation);
        }
    }

    private void scan(Detail detail)
    {
        DefaultType defaulttype = detail.getOverride();
        DefaultType defaulttype1 = detail.getAccess();
        Class class1 = detail.getSuper();
        if (class1 != null)
        {
            extend(class1, defaulttype);
        }
        extract(detail, defaulttype1);
        extract(detail);
        build();
    }

    private class FieldKey
    {

        private final String name;
        private final Class type;

        private boolean equals(FieldKey fieldkey)
        {
            if (fieldkey.type != type)
            {
                return false;
            } else
            {
                return fieldkey.name.equals(name);
            }
        }

        public boolean equals(Object obj)
        {
            if (obj instanceof FieldKey)
            {
                return equals((FieldKey)obj);
            } else
            {
                return false;
            }
        }

        public int hashCode()
        {
            return name.hashCode();
        }

        public FieldKey(Field field)
        {
            type = field.getDeclaringClass();
            name = field.getName();
        }
    }

}
