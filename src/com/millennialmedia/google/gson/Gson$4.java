// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;

// Referenced classes of package com.millennialmedia.google.gson:
//            TypeAdapter, Gson

class pter extends TypeAdapter
{

    final Gson this$0;

    public Float read(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        } else
        {
            return Float.valueOf((float)jsonreader.nextDouble());
        }
    }

    public volatile Object read(JsonReader jsonreader)
    {
        return read(jsonreader);
    }

    public void write(JsonWriter jsonwriter, Number number)
    {
        if (number == null)
        {
            jsonwriter.nullValue();
            return;
        } else
        {
            float f = number.floatValue();
            Gson.access$000(Gson.this, f);
            jsonwriter.value(number);
            return;
        }
    }

    public volatile void write(JsonWriter jsonwriter, Object obj)
    {
        write(jsonwriter, (Number)obj);
    }

    JsonWriter()
    {
        this$0 = Gson.this;
        super();
    }
}
