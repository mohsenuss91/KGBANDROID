// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.internal.ConstructorConstructor;
import com.millennialmedia.google.gson.reflect.TypeToken;
import java.util.Collection;

public final class CollectionTypeAdapterFactory
    implements TypeAdapterFactory
{

    private final ConstructorConstructor constructorConstructor;

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorconstructor)
    {
        constructorConstructor = constructorconstructor;
    }

    public final TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        Type type = typetoken.getType();
        Class class1 = typetoken.getRawType();
        if (!java/util/Collection.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            Type type1 = com.millennialmedia.google.gson.internal..Gson.Types.getCollectionElementType(type, class1);
            return new Adapter(gson, type1, gson.getAdapter(TypeToken.get(type1)), constructorConstructor.get(typetoken));
        }
    }

    private class Adapter extends TypeAdapter
    {

        private final ObjectConstructor constructor;
        private final TypeAdapter elementTypeAdapter;

        public final volatile Object read(JsonReader jsonreader)
        {
            return read(jsonreader);
        }

        public final Collection read(JsonReader jsonreader)
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            }
            Collection collection = (Collection)constructor.construct();
            jsonreader.beginArray();
            for (; jsonreader.hasNext(); collection.add(elementTypeAdapter.read(jsonreader))) { }
            jsonreader.endArray();
            return collection;
        }

        public final volatile void write(JsonWriter jsonwriter, Object obj)
        {
            write(jsonwriter, (Collection)obj);
        }

        public final void write(JsonWriter jsonwriter, Collection collection)
        {
            if (collection == null)
            {
                jsonwriter.nullValue();
                return;
            }
            jsonwriter.beginArray();
            Object obj;
            for (Iterator iterator = collection.iterator(); iterator.hasNext(); elementTypeAdapter.write(jsonwriter, obj))
            {
                obj = iterator.next();
            }

            jsonwriter.endArray();
        }

        public Adapter(Gson gson, Type type, TypeAdapter typeadapter, ObjectConstructor objectconstructor)
        {
            elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeadapter, type);
            constructor = objectconstructor;
        }
    }

}
