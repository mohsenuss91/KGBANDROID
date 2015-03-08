// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.reflect.TypeToken;

final class val.typeAdapter
    implements TypeAdapterFactory
{

    final Class val$base;
    final Class val$sub;
    final TypeAdapter val$typeAdapter;

    public final TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        Class class1 = typetoken.getRawType();
        if (class1 == val$base || class1 == val$sub)
        {
            return val$typeAdapter;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Factory[type=")).append(val$base.getName()).append("+").append(val$sub.getName()).append(",adapter=").append(val$typeAdapter).append("]").toString();
    }

    ()
    {
        val$base = class1;
        val$sub = class2;
        val$typeAdapter = typeadapter;
        super();
    }
}
