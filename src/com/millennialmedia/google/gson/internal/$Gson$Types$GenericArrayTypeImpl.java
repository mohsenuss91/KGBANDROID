// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class componentType
    implements Serializable, GenericArrayType
{

    private static final long serialVersionUID;
    private final Type componentType;

    public final boolean equals(Object obj)
    {
        return (obj instanceof GenericArrayType) && componentType(this, (GenericArrayType)obj);
    }

    public final Type getGenericComponentType()
    {
        return componentType;
    }

    public final int hashCode()
    {
        return componentType.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder()).append(componentType(componentType)).append("[]").toString();
    }

    public (Type type)
    {
        componentType = componentType(type);
    }
}
