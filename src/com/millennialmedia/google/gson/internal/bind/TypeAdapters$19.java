// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.JsonIOException;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.net.URI;
import java.net.URISyntaxException;

final class  extends TypeAdapter
{

    public final volatile Object read(JsonReader jsonreader)
    {
        return read(jsonreader);
    }

    public final URI read(JsonReader jsonreader)
    {
        if (jsonreader.peek() != JsonToken.NULL) goto _L2; else goto _L1
_L1:
        jsonreader.nextNull();
_L4:
        return null;
_L2:
        String s = jsonreader.nextString();
        if ("null".equals(s)) goto _L4; else goto _L3
_L3:
        URI uri = new URI(s);
        return uri;
        URISyntaxException urisyntaxexception;
        urisyntaxexception;
        throw new JsonIOException(urisyntaxexception);
    }

    public final volatile void write(JsonWriter jsonwriter, Object obj)
    {
        write(jsonwriter, (URI)obj);
    }

    public final void write(JsonWriter jsonwriter, URI uri)
    {
        String s;
        if (uri == null)
        {
            s = null;
        } else
        {
            s = uri.toASCIIString();
        }
        jsonwriter.value(s);
    }

    ()
    {
    }
}
