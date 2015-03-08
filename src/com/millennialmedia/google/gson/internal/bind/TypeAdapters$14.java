// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.JsonSyntaxException;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.math.BigDecimal;

final class  extends TypeAdapter
{

    public final volatile Object read(JsonReader jsonreader)
    {
        return read(jsonreader);
    }

    public final BigDecimal read(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        BigDecimal bigdecimal;
        try
        {
            bigdecimal = new BigDecimal(jsonreader.nextString());
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new JsonSyntaxException(numberformatexception);
        }
        return bigdecimal;
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        jsonwriter.value((BigDecimal)obj);
    }

    public final void write(JsonWriter jsonwriter, BigDecimal bigdecimal)
    {
        jsonwriter.value(bigdecimal);
    }

    ()
    {
    }
}
