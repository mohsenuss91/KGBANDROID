// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.JsonSyntaxException;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class TimeTypeAdapter extends TypeAdapter
{

    public static final TypeAdapterFactory FACTORY = new _cls1();
    private final DateFormat format = new SimpleDateFormat("hh:mm:ss a");

    public TimeTypeAdapter()
    {
    }

    public final volatile Object read(JsonReader jsonreader)
    {
        return read(jsonreader);
    }

    public final Time read(JsonReader jsonreader)
    {
        this;
        JVM INSTR monitorenter ;
        if (jsonreader.peek() != JsonToken.NULL) goto _L2; else goto _L1
_L1:
        jsonreader.nextNull();
        Time time = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return time;
_L2:
        time = new Time(format.parse(jsonreader.nextString()).getTime());
        if (true) goto _L4; else goto _L3
_L3:
        ParseException parseexception;
        parseexception;
        throw new JsonSyntaxException(parseexception);
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final volatile void write(JsonWriter jsonwriter, Object obj)
    {
        write(jsonwriter, (Time)obj);
    }

    public final void write(JsonWriter jsonwriter, Time time)
    {
        this;
        JVM INSTR monitorenter ;
        if (time != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        jsonwriter.value(s1);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        String s = format.format(time);
        s1 = s;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }


    private class _cls1
        implements TypeAdapterFactory
    {

        public final TypeAdapter create(Gson gson, TypeToken typetoken)
        {
            if (typetoken.getRawType() == java/sql/Time)
            {
                return new TimeTypeAdapter();
            } else
            {
                return null;
            }
        }

        _cls1()
        {
        }
    }

}
