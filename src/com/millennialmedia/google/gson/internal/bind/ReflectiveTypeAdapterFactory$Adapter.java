// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.JsonSyntaxException;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.internal.ObjectConstructor;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class <init> extends TypeAdapter
{

    private final Map boundFields;
    private final ObjectConstructor constructor;

    public final Object read(JsonReader jsonreader)
    {
        Object obj;
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        obj = constructor.construct();
        jsonreader.beginObject();
_L1:
        ld ld;
        if (!jsonreader.hasNext())
        {
            break MISSING_BLOCK_LABEL_111;
        }
        String s = jsonreader.nextName();
        ld = (ld)boundFields.get(s);
        if (ld == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (ld.deserialized)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        IllegalStateException illegalstateexception;
        jsonreader.skipValue();
          goto _L1
        try
        {
            ld.read(jsonreader, obj);
        }
        // Misplaced declaration of an exception variable
        catch (IllegalStateException illegalstateexception)
        {
            throw new JsonSyntaxException(illegalstateexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new AssertionError(illegalaccessexception);
        }
          goto _L1
        jsonreader.endObject();
        return obj;
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        if (obj == null)
        {
            jsonwriter.nullValue();
            return;
        }
        jsonwriter.beginObject();
        try
        {
            Iterator iterator = boundFields.values().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ld ld = (ld)iterator.next();
                if (ld.serialized)
                {
                    jsonwriter.name(ld.name);
                    ld.write(jsonwriter, obj);
                }
            } while (true);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new AssertionError();
        }
        jsonwriter.endObject();
    }

    private ld(ObjectConstructor objectconstructor, Map map)
    {
        constructor = objectconstructor;
        boundFields = map;
    }

    boundFields(ObjectConstructor objectconstructor, Map map, boundFields boundfields)
    {
        this(objectconstructor, map);
    }
}
