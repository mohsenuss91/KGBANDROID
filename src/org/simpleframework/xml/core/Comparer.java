// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class Comparer
{

    private static final String NAME = "name";
    private final String ignore[];

    public Comparer()
    {
        this(new String[] {
            "name"
        });
    }

    public transient Comparer(String as[])
    {
        ignore = as;
    }

    private boolean isIgnore(Method method)
    {
        String s;
        String as[];
        boolean flag;
        s = method.getName();
        as = ignore;
        flag = false;
        if (as == null) goto _L2; else goto _L1
_L1:
        String as1[];
        int i;
        int j;
        as1 = ignore;
        i = as1.length;
        j = 0;
_L7:
        flag = false;
        if (j >= i) goto _L2; else goto _L3
_L3:
        if (!s.equals(as1[j])) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        j++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean equals(Annotation annotation, Annotation annotation1)
    {
        Class class1;
        Class class2;
        Method amethod[];
        class1 = annotation.annotationType();
        class2 = annotation1.annotationType();
        amethod = class1.getDeclaredMethods();
        if (!class1.equals(class2)) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = amethod.length;
        j = 0;
_L5:
        Method method;
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        method = amethod[j];
        if (isIgnore(method) || method.invoke(annotation, new Object[0]).equals(method.invoke(annotation1, new Object[0]))) goto _L3; else goto _L2
_L2:
        return false;
_L3:
        j++;
        if (true) goto _L5; else goto _L4
_L4:
        return true;
    }
}
