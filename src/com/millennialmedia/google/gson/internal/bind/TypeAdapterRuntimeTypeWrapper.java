// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.reflect.TypeToken;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeAdapterRuntimeTypeWrapper extends TypeAdapter
{

    private final Gson context;
    private final TypeAdapter _flddelegate;
    private final Type type;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter typeadapter, Type type1)
    {
        context = gson;
        _flddelegate = typeadapter;
        type = type1;
    }

    private Type getRuntimeTypeIfMoreSpecific(Type type1, Object obj)
    {
        if (obj != null && (type1 == java/lang/Object || (type1 instanceof TypeVariable) || (type1 instanceof Class)))
        {
            type1 = obj.getClass();
        }
        return type1;
    }

    public final Object read(JsonReader jsonreader)
    {
        return _flddelegate.read(jsonreader);
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        TypeAdapter typeadapter = _flddelegate;
        Type type1 = getRuntimeTypeIfMoreSpecific(type, obj);
        if (type1 != type)
        {
            typeadapter = context.getAdapter(TypeToken.get(type1));
            if ((typeadapter instanceof ReflectiveTypeAdapterFactory.Adapter) && !(_flddelegate instanceof ReflectiveTypeAdapterFactory.Adapter))
            {
                typeadapter = _flddelegate;
            }
        }
        typeadapter.write(jsonwriter, obj);
    }
}
