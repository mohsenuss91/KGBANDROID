// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;

final class  extends TypeAdapter
{

    public final volatile Object read(JsonReader jsonreader)
    {
        return read(jsonreader);
    }

    public final String read(JsonReader jsonreader)
    {
        JsonToken jsontoken = jsonreader.peek();
        if (jsontoken == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        if (jsontoken == JsonToken.BOOLEAN)
        {
            return Boolean.toString(jsonreader.nextBoolean());
        } else
        {
            return jsonreader.nextString();
        }
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        jsonwriter.value((String)obj);
    }

    public final void write(JsonWriter jsonwriter, String s)
    {
        jsonwriter.value(s);
    }

    ()
    {
    }
}
