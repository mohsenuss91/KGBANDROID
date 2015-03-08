// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.FieldNamingStrategy;
import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.annotations.SerializedName;
import com.millennialmedia.google.gson.internal.ConstructorConstructor;
import com.millennialmedia.google.gson.internal.Excluder;
import com.millennialmedia.google.gson.internal.Primitives;
import com.millennialmedia.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory
    implements TypeAdapterFactory
{

    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorconstructor, FieldNamingStrategy fieldnamingstrategy, Excluder excluder1)
    {
        constructorConstructor = constructorconstructor;
        fieldNamingPolicy = fieldnamingstrategy;
        excluder = excluder1;
    }

    private BoundField createBoundField(final Gson context, Field field, final String final_s, TypeToken typetoken, final boolean final_flag, final boolean final_flag1)
    {
        return new _cls1(typetoken, field, Primitives.isPrimitive(typetoken.getRawType()));
    }

    private Map getBoundFields(Gson gson, TypeToken typetoken, Class class1)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        if (class1.isInterface())
        {
            return linkedhashmap;
        }
        java.lang.reflect.Type type = typetoken.getType();
        for (; class1 != java/lang/Object; class1 = typetoken.getRawType())
        {
            Field afield[] = class1.getDeclaredFields();
            int i = afield.length;
            for (int j = 0; j < i; j++)
            {
                Field field = afield[j];
                boolean flag = excludeField(field, true);
                boolean flag1 = excludeField(field, false);
                if (!flag && !flag1)
                {
                    continue;
                }
                field.setAccessible(true);
                java.lang.reflect.Type type1 = com.millennialmedia.google.gson.internal..Gson.Types.resolve(typetoken.getType(), class1, field.getGenericType());
                BoundField boundfield = createBoundField(gson, field, getFieldName(field), TypeToken.get(type1), flag, flag1);
                BoundField boundfield1 = (BoundField)linkedhashmap.put(boundfield.name, boundfield);
                if (boundfield1 != null)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append(type).append(" declares multiple JSON fields named ").append(boundfield1.name).toString());
                }
            }

            typetoken = TypeToken.get(com.millennialmedia.google.gson.internal..Gson.Types.resolve(typetoken.getType(), class1, class1.getGenericSuperclass()));
        }

        return linkedhashmap;
    }

    private String getFieldName(Field field)
    {
        SerializedName serializedname = (SerializedName)field.getAnnotation(com/millennialmedia/google/gson/annotations/SerializedName);
        if (serializedname == null)
        {
            return fieldNamingPolicy.translateName(field);
        } else
        {
            return serializedname.value();
        }
    }

    public final TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        Class class1 = typetoken.getRawType();
        if (!java/lang/Object.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            return new Adapter(constructorConstructor.get(typetoken), getBoundFields(gson, typetoken, class1), null);
        }
    }

    public final boolean excludeField(Field field, boolean flag)
    {
        return !excluder.excludeClass(field.getType(), flag) && !excluder.excludeField(field, flag);
    }

    private class _cls1 extends BoundField
    {
        private class BoundField
        {

            final boolean deserialized;
            final String name;
            final boolean serialized;

            abstract void read(JsonReader jsonreader, Object obj);

            abstract void write(JsonWriter jsonwriter, Object obj);

            protected BoundField(String s, boolean flag, boolean flag1)
            {
                name = s;
                serialized = flag;
                deserialized = flag1;
            }
        }


        final ReflectiveTypeAdapterFactory this$0;
        final TypeAdapter typeAdapter;
        final Gson val$context;
        final Field val$field;
        final TypeToken val$fieldType;
        final boolean val$isPrimitive;

        void read(JsonReader jsonreader, Object obj)
        {
            Object obj1 = typeAdapter.read(jsonreader);
            if (obj1 != null || !isPrimitive)
            {
                field.set(obj, obj1);
            }
        }

        void write(JsonWriter jsonwriter, Object obj)
        {
            Object obj1 = field.get(obj);
            (new TypeAdapterRuntimeTypeWrapper(context, typeAdapter, fieldType.getType())).write(jsonwriter, obj1);
        }

        _cls1(TypeToken typetoken, Field field1, 
                boolean flag2)
        {
            this$0 = ReflectiveTypeAdapterFactory.this;
            context = gson;
            fieldType = typetoken;
            field = field1;
            isPrimitive = flag2;
            super(final_s, final_flag, final_flag1);
            typeAdapter = context.getAdapter(fieldType);
        }
    }


    private class Adapter extends TypeAdapter
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
            BoundField boundfield;
            if (!jsonreader.hasNext())
            {
                break MISSING_BLOCK_LABEL_111;
            }
            String s = jsonreader.nextName();
            boundfield = (BoundField)boundFields.get(s);
            if (boundfield == null)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            if (boundfield.deserialized)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            IllegalStateException illegalstateexception;
            jsonreader.skipValue();
              goto _L1
            try
            {
                boundfield.read(jsonreader, obj);
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
                    BoundField boundfield = (BoundField)iterator.next();
                    if (boundfield.serialized)
                    {
                        jsonwriter.name(boundfield.name);
                        boundfield.write(jsonwriter, obj);
                    }
                } while (true);
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                throw new AssertionError();
            }
            jsonwriter.endObject();
        }

        private Adapter(ObjectConstructor objectconstructor, Map map)
        {
            constructor = objectconstructor;
            boundFields = map;
        }

        Adapter(ObjectConstructor objectconstructor, Map map, _cls1 _pcls1)
        {
            this(objectconstructor, map);
        }
    }

}
