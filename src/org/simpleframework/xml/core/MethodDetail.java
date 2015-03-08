// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class MethodDetail
{

    private final Annotation list[];
    private final Method method;
    private final String name;

    public MethodDetail(Method method1)
    {
        list = method1.getDeclaredAnnotations();
        name = method1.getName();
        method = method1;
    }

    public Annotation[] getAnnotations()
    {
        return list;
    }

    public Method getMethod()
    {
        return method;
    }

    public String getName()
    {
        return name;
    }
}
