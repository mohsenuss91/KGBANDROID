// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

// Referenced classes of package org.simpleframework.xml.core:
//            Contact, MethodPart, MethodException

class MethodContact
    implements Contact
{

    private MethodPart get;
    private Class item;
    private Class items[];
    private Annotation label;
    private String name;
    private Class owner;
    private MethodPart set;
    private Class type;

    public MethodContact(MethodPart methodpart)
    {
        this(methodpart, null);
    }

    public MethodContact(MethodPart methodpart, MethodPart methodpart1)
    {
        owner = methodpart.getDeclaringClass();
        label = methodpart.getAnnotation();
        items = methodpart.getDependents();
        item = methodpart.getDependent();
        type = methodpart.getType();
        name = methodpart.getName();
        set = methodpart1;
        get = methodpart;
    }

    public Object get(Object obj)
    {
        return get.getMethod().invoke(obj, new Object[0]);
    }

    public Annotation getAnnotation()
    {
        return label;
    }

    public Annotation getAnnotation(Class class1)
    {
        Annotation annotation = get.getAnnotation(class1);
        if (class1 == label.annotationType())
        {
            annotation = label;
        } else
        if (annotation == null && set != null)
        {
            return set.getAnnotation(class1);
        }
        return annotation;
    }

    public Class getDeclaringClass()
    {
        return owner;
    }

    public Class getDependent()
    {
        return item;
    }

    public Class[] getDependents()
    {
        return items;
    }

    public String getName()
    {
        return name;
    }

    public MethodPart getRead()
    {
        return get;
    }

    public Class getType()
    {
        return type;
    }

    public MethodPart getWrite()
    {
        return set;
    }

    public boolean isReadOnly()
    {
        return set == null;
    }

    public void set(Object obj, Object obj1)
    {
        Class class1 = get.getMethod().getDeclaringClass();
        if (set == null)
        {
            Object aobj[] = new Object[2];
            aobj[0] = name;
            aobj[1] = class1;
            throw new MethodException("Property '%s' is read only in %s", aobj);
        } else
        {
            set.getMethod().invoke(obj, new Object[] {
                obj1
            });
            return;
        }
    }

    public String toString()
    {
        Object aobj[] = new Object[1];
        aobj[0] = name;
        return String.format("method '%s'", aobj);
    }
}
