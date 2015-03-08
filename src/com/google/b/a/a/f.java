// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.a.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class f
{

    private final Type type;

    public f()
    {
        Type type1 = getClass().getGenericSuperclass();
        if (type1 instanceof Class)
        {
            throw new RuntimeException("Missing type parameter");
        } else
        {
            type = ((ParameterizedType)type1).getActualTypeArguments()[0];
            return;
        }
    }

    private Class getListType()
    {
        return (Class)((ParameterizedType)type).getRawType();
    }

    private Class getTargetClass()
    {
        if (isList())
        {
            return (Class)((ParameterizedType)type).getActualTypeArguments()[0];
        } else
        {
            return (Class)type;
        }
    }

    private boolean isList()
    {
        return type instanceof ParameterizedType;
    }



}
