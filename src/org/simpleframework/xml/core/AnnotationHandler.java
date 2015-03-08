// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Referenced classes of package org.simpleframework.xml.core:
//            Comparer, PersistenceException

class AnnotationHandler
    implements InvocationHandler
{

    private static final String ATTRIBUTE = "attribute";
    private static final String CLASS = "annotationType";
    private static final String EQUAL = "equals";
    private static final String REQUIRED = "required";
    private static final String STRING = "toString";
    private final boolean attribute;
    private final Comparer comparer;
    private final boolean required;
    private final Class type;

    public AnnotationHandler(Class class1)
    {
        this(class1, true);
    }

    public AnnotationHandler(Class class1, boolean flag)
    {
        this(class1, flag, false);
    }

    public AnnotationHandler(Class class1, boolean flag, boolean flag1)
    {
        comparer = new Comparer();
        attribute = flag1;
        required = flag;
        type = class1;
    }

    private void attributes(StringBuilder stringbuilder)
    {
        Method amethod[] = type.getDeclaredMethods();
        for (int i = 0; i < amethod.length; i++)
        {
            String s = amethod[i].getName();
            Object obj = value(amethod[i]);
            if (i > 0)
            {
                stringbuilder.append(',');
                stringbuilder.append(' ');
            }
            stringbuilder.append(s);
            stringbuilder.append('=');
            stringbuilder.append(obj);
        }

        stringbuilder.append(')');
    }

    private boolean equals(Object obj, Object aobj[])
    {
        Annotation annotation = (Annotation)obj;
        Annotation annotation1 = (Annotation)aobj[0];
        if (annotation.annotationType() != annotation1.annotationType())
        {
            throw new PersistenceException("Annotation %s is not the same as %s", new Object[] {
                annotation, annotation1
            });
        } else
        {
            return comparer.equals(annotation, annotation1);
        }
    }

    private void name(StringBuilder stringbuilder)
    {
        String s = type.getName();
        if (s != null)
        {
            stringbuilder.append('@');
            stringbuilder.append(s);
            stringbuilder.append('(');
        }
    }

    private Object value(Method method)
    {
        String s = method.getName();
        if (s.equals("required"))
        {
            return Boolean.valueOf(required);
        }
        if (s.equals("attribute"))
        {
            return Boolean.valueOf(attribute);
        } else
        {
            return method.getDefaultValue();
        }
    }

    public Object invoke(Object obj, Method method, Object aobj[])
    {
        String s = method.getName();
        if (s.equals("toString"))
        {
            return toString();
        }
        if (s.equals("equals"))
        {
            return Boolean.valueOf(equals(obj, aobj));
        }
        if (s.equals("annotationType"))
        {
            return type;
        }
        if (s.equals("required"))
        {
            return Boolean.valueOf(required);
        }
        if (s.equals("attribute"))
        {
            return Boolean.valueOf(attribute);
        } else
        {
            return method.getDefaultValue();
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (type != null)
        {
            name(stringbuilder);
            attributes(stringbuilder);
        }
        return stringbuilder.toString();
    }
}
