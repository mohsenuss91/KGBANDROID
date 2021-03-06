// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.internal.LinkedHashTreeMap;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ObjectTypeAdapter extends TypeAdapter
{

    public static final TypeAdapterFactory FACTORY = new _cls1();
    private final Gson gson;

    private ObjectTypeAdapter(Gson gson1)
    {
        gson = gson1;
    }

    ObjectTypeAdapter(Gson gson1, _cls1 _pcls1)
    {
        this(gson1);
    }

    public final Object read(JsonReader jsonreader)
    {
        JsonToken jsontoken = jsonreader.peek();
        switch (_cls2..SwitchMap.com.millennialmedia.google.gson.stream.JsonToken[jsontoken.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            ArrayList arraylist = new ArrayList();
            jsonreader.beginArray();
            for (; jsonreader.hasNext(); arraylist.add(read(jsonreader))) { }
            jsonreader.endArray();
            return arraylist;

        case 2: // '\002'
            LinkedHashTreeMap linkedhashtreemap = new LinkedHashTreeMap();
            jsonreader.beginObject();
            for (; jsonreader.hasNext(); linkedhashtreemap.put(jsonreader.nextName(), read(jsonreader))) { }
            jsonreader.endObject();
            return linkedhashtreemap;

        case 3: // '\003'
            return jsonreader.nextString();

        case 4: // '\004'
            return Double.valueOf(jsonreader.nextDouble());

        case 5: // '\005'
            return Boolean.valueOf(jsonreader.nextBoolean());

        case 6: // '\006'
            jsonreader.nextNull();
            return null;
        }
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        if (obj == null)
        {
            jsonwriter.nullValue();
            return;
        }
        TypeAdapter typeadapter = gson.getAdapter(obj.getClass());
        if (typeadapter instanceof ObjectTypeAdapter)
        {
            jsonwriter.beginObject();
            jsonwriter.endObject();
            return;
        } else
        {
            typeadapter.write(jsonwriter, obj);
            return;
        }
    }


    private class _cls2
    {

        static final int $SwitchMap$com$millennialmedia$google$gson$stream$JsonToken[];

        static 
        {
            $SwitchMap$com$millennialmedia$google$gson$stream$JsonToken = new int[JsonToken.values().length];
            try
            {
                $SwitchMap$com$millennialmedia$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                $SwitchMap$com$millennialmedia$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$millennialmedia$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$millennialmedia$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$millennialmedia$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$millennialmedia$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror5)
            {
                return;
            }
        }
    }


    private class _cls1
        implements TypeAdapterFactory
    {

        public final TypeAdapter create(Gson gson1, TypeToken typetoken)
        {
            if (typetoken.getRawType() == java/lang/Object)
            {
                return new ObjectTypeAdapter(gson1, null);
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
