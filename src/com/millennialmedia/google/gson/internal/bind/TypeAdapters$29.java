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

    final Class val$boxed;
    final TypeAdapter val$typeAdapter;
    final Class val$unboxed;

    public final TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        Class class1 = typetoken.getRawType();
        if (class1 == val$unboxed || class1 == val$boxed)
        {
            return val$typeAdapter;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Factory[type=")).append(val$boxed.getName()).append("+").append(val$unboxed.getName()).append(",adapter=").append(val$typeAdapter).append("]").toString();
    }

    ()
    {
        val$unboxed = class1;
        val$boxed = class2;
        val$typeAdapter = typeadapter;
        super();
    }
}
