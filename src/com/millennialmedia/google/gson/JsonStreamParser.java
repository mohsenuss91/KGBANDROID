// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.internal.Streams;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.millennialmedia.google.gson:
//            JsonSyntaxException, JsonIOException, JsonParseException, JsonElement

public final class JsonStreamParser
    implements Iterator
{

    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(Reader reader)
    {
        parser = new JsonReader(reader);
        parser.setLenient(true);
        lock = new Object();
    }

    public JsonStreamParser(String s)
    {
        this(((Reader) (new StringReader(s))));
    }

    public final boolean hasNext()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        JsonToken jsontoken;
        JsonToken jsontoken1;
        jsontoken = parser.peek();
        jsontoken1 = JsonToken.END_DOCUMENT;
        IOException ioexception;
        Exception exception;
        MalformedJsonException malformedjsonexception;
        boolean flag;
        if (jsontoken != jsontoken1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        malformedjsonexception;
        throw new JsonSyntaxException(malformedjsonexception);
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        ioexception;
        throw new JsonIOException(ioexception);
    }

    public final JsonElement next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException();
        }
        JsonElement jsonelement;
        try
        {
            jsonelement = Streams.parse(parser);
        }
        catch (StackOverflowError stackoverflowerror)
        {
            throw new JsonParseException("Failed parsing JSON source to Json", stackoverflowerror);
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            throw new JsonParseException("Failed parsing JSON source to Json", outofmemoryerror);
        }
        catch (Object obj)
        {
            if (((JsonParseException) (obj)).getCause() instanceof EOFException)
            {
                obj = new NoSuchElementException();
            }
            throw obj;
        }
        return jsonelement;
    }

    public final volatile Object next()
    {
        return next();
    }

    public final void remove()
    {
        throw new UnsupportedOperationException();
    }
}
