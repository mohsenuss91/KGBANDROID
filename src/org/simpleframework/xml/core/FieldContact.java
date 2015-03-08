// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.core:
//            Contact, Reflector

class FieldContact
    implements Contact
{

    private final Cache cache = new ConcurrentCache();
    private final Field field;
    private final Annotation label;
    private final Annotation list[];
    private final int modifier;
    private final String name;

    public FieldContact(Field field1, Annotation annotation, Annotation aannotation[])
    {
        modifier = field1.getModifiers();
        name = field1.getName();
        label = annotation;
        field = field1;
        list = aannotation;
    }

    private Annotation getCache(Class class1)
    {
        if (cache.isEmpty())
        {
            Annotation aannotation[] = list;
            int i = aannotation.length;
            for (int j = 0; j < i; j++)
            {
                Annotation annotation = aannotation[j];
                Class class2 = annotation.annotationType();
                cache.cache(class2, annotation);
            }

        }
        return (Annotation)cache.fetch(class1);
    }

    public Object get(Object obj)
    {
        return field.get(obj);
    }

    public Annotation getAnnotation()
    {
        return label;
    }

    public Annotation getAnnotation(Class class1)
    {
        if (class1 == label.annotationType())
        {
            return label;
        } else
        {
            return getCache(class1);
        }
    }

    public Class getDeclaringClass()
    {
        return field.getDeclaringClass();
    }

    public Class getDependent()
    {
        return Reflector.getDependent(field);
    }

    public Class[] getDependents()
    {
        return Reflector.getDependents(field);
    }

    public String getName()
    {
        return name;
    }

    public Class getType()
    {
        return field.getType();
    }

    public boolean isFinal()
    {
        return Modifier.isFinal(modifier);
    }

    public boolean isReadOnly()
    {
        return !isStatic() && isFinal();
    }

    public boolean isStatic()
    {
        return Modifier.isStatic(modifier);
    }

    public void set(Object obj, Object obj1)
    {
        if (!isFinal())
        {
            field.set(obj, obj1);
        }
    }

    public String toString()
    {
        Object aobj[] = new Object[2];
        aobj[0] = getName();
        aobj[1] = field.toString();
        return String.format("field '%s' %s", aobj);
    }
}
