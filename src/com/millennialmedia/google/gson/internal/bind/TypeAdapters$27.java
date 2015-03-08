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

    final TypeToken val$type;
    final TypeAdapter val$typeAdapter;

    public final TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        if (typetoken.equals(val$type))
        {
            return val$typeAdapter;
        } else
        {
            return null;
        }
    }

    ()
    {
        val$type = typetoken;
        val$typeAdapter = typeadapter;
        super();
    }
}
