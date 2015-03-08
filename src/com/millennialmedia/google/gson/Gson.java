// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.internal.ConstructorConstructor;
import com.millennialmedia.google.gson.internal.Excluder;
import com.millennialmedia.google.gson.internal.Primitives;
import com.millennialmedia.google.gson.internal.Streams;
import com.millennialmedia.google.gson.internal.bind.ArrayTypeAdapter;
import com.millennialmedia.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.millennialmedia.google.gson.internal.bind.DateTypeAdapter;
import com.millennialmedia.google.gson.internal.bind.JsonTreeReader;
import com.millennialmedia.google.gson.internal.bind.JsonTreeWriter;
import com.millennialmedia.google.gson.internal.bind.MapTypeAdapterFactory;
import com.millennialmedia.google.gson.internal.bind.ObjectTypeAdapter;
import com.millennialmedia.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.millennialmedia.google.gson.internal.bind.SqlDateTypeAdapter;
import com.millennialmedia.google.gson.internal.bind.TimeTypeAdapter;
import com.millennialmedia.google.gson.internal.bind.TypeAdapters;
import com.millennialmedia.google.gson.reflect.TypeToken;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import com.millennialmedia.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.millennialmedia.google.gson:
//            FieldNamingPolicy, LongSerializationPolicy, JsonIOException, JsonSyntaxException, 
//            TypeAdapter, TypeAdapterFactory, JsonNull, JsonDeserializationContext, 
//            JsonSerializationContext, FieldNamingStrategy, JsonElement

public final class Gson
{

    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private final ThreadLocal calls;
    private final ConstructorConstructor constructorConstructor;
    final JsonDeserializationContext deserializationContext;
    private final List factories;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final boolean prettyPrinting;
    final JsonSerializationContext serializationContext;
    private final boolean serializeNulls;
    private final Map typeTokenCache;

    public Gson()
    {
        this(Excluder.DEFAULT, ((FieldNamingStrategy) (FieldNamingPolicy.IDENTITY)), Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldnamingstrategy, Map map, boolean flag, boolean flag1, boolean flag2, boolean flag3, 
            boolean flag4, boolean flag5, LongSerializationPolicy longserializationpolicy, List list)
    {
        calls = new ThreadLocal();
        typeTokenCache = Collections.synchronizedMap(new HashMap());
        deserializationContext = new _cls1();
        serializationContext = new _cls2();
        constructorConstructor = new ConstructorConstructor(map);
        serializeNulls = flag;
        generateNonExecutableJson = flag2;
        htmlSafe = flag3;
        prettyPrinting = flag4;
        ArrayList arraylist = new ArrayList();
        arraylist.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arraylist.add(ObjectTypeAdapter.FACTORY);
        arraylist.add(excluder);
        arraylist.addAll(list);
        arraylist.add(TypeAdapters.STRING_FACTORY);
        arraylist.add(TypeAdapters.INTEGER_FACTORY);
        arraylist.add(TypeAdapters.BOOLEAN_FACTORY);
        arraylist.add(TypeAdapters.BYTE_FACTORY);
        arraylist.add(TypeAdapters.SHORT_FACTORY);
        arraylist.add(TypeAdapters.newFactory(Long.TYPE, java/lang/Long, longAdapter(longserializationpolicy)));
        arraylist.add(TypeAdapters.newFactory(Double.TYPE, java/lang/Double, doubleAdapter(flag5)));
        arraylist.add(TypeAdapters.newFactory(Float.TYPE, java/lang/Float, floatAdapter(flag5)));
        arraylist.add(TypeAdapters.NUMBER_FACTORY);
        arraylist.add(TypeAdapters.CHARACTER_FACTORY);
        arraylist.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arraylist.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arraylist.add(TypeAdapters.newFactory(java/math/BigDecimal, TypeAdapters.BIG_DECIMAL));
        arraylist.add(TypeAdapters.newFactory(java/math/BigInteger, TypeAdapters.BIG_INTEGER));
        arraylist.add(TypeAdapters.URL_FACTORY);
        arraylist.add(TypeAdapters.URI_FACTORY);
        arraylist.add(TypeAdapters.UUID_FACTORY);
        arraylist.add(TypeAdapters.LOCALE_FACTORY);
        arraylist.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arraylist.add(TypeAdapters.BIT_SET_FACTORY);
        arraylist.add(DateTypeAdapter.FACTORY);
        arraylist.add(TypeAdapters.CALENDAR_FACTORY);
        arraylist.add(TimeTypeAdapter.FACTORY);
        arraylist.add(SqlDateTypeAdapter.FACTORY);
        arraylist.add(TypeAdapters.TIMESTAMP_FACTORY);
        arraylist.add(ArrayTypeAdapter.FACTORY);
        arraylist.add(TypeAdapters.ENUM_FACTORY);
        arraylist.add(TypeAdapters.CLASS_FACTORY);
        arraylist.add(new CollectionTypeAdapterFactory(constructorConstructor));
        arraylist.add(new MapTypeAdapterFactory(constructorConstructor, flag1));
        arraylist.add(new ReflectiveTypeAdapterFactory(constructorConstructor, fieldnamingstrategy, excluder));
        factories = Collections.unmodifiableList(arraylist);
    }

    private static void assertFullConsumption(Object obj, JsonReader jsonreader)
    {
        if (obj != null)
        {
            try
            {
                if (jsonreader.peek() != JsonToken.END_DOCUMENT)
                {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            }
            catch (MalformedJsonException malformedjsonexception)
            {
                throw new JsonSyntaxException(malformedjsonexception);
            }
            catch (IOException ioexception)
            {
                throw new JsonIOException(ioexception);
            }
        }
    }

    private void checkValidFloatingPoint(double d)
    {
        if (Double.isNaN(d) || Double.isInfinite(d))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(d).append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.").toString());
        } else
        {
            return;
        }
    }

    private TypeAdapter doubleAdapter(boolean flag)
    {
        if (flag)
        {
            return TypeAdapters.DOUBLE;
        } else
        {
            return new _cls3();
        }
    }

    private TypeAdapter floatAdapter(boolean flag)
    {
        if (flag)
        {
            return TypeAdapters.FLOAT;
        } else
        {
            return new _cls4();
        }
    }

    private TypeAdapter longAdapter(LongSerializationPolicy longserializationpolicy)
    {
        if (longserializationpolicy == LongSerializationPolicy.DEFAULT)
        {
            return TypeAdapters.LONG;
        } else
        {
            return new _cls5();
        }
    }

    private JsonWriter newJsonWriter(Writer writer)
    {
        if (generateNonExecutableJson)
        {
            writer.write(")]}'\n");
        }
        JsonWriter jsonwriter = new JsonWriter(writer);
        if (prettyPrinting)
        {
            jsonwriter.setIndent("  ");
        }
        jsonwriter.setSerializeNulls(serializeNulls);
        return jsonwriter;
    }

    public final Object fromJson(JsonElement jsonelement, Class class1)
    {
        Object obj = fromJson(jsonelement, ((Type) (class1)));
        return Primitives.wrap(class1).cast(obj);
    }

    public final Object fromJson(JsonElement jsonelement, Type type)
    {
        if (jsonelement == null)
        {
            return null;
        } else
        {
            return fromJson(((JsonReader) (new JsonTreeReader(jsonelement))), type);
        }
    }

    public final Object fromJson(JsonReader jsonreader, Type type)
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = jsonreader.isLenient();
        jsonreader.setLenient(flag);
        jsonreader.peek();
        flag = false;
        Object obj = getAdapter(TypeToken.get(type)).read(jsonreader);
        jsonreader.setLenient(flag1);
        return obj;
        EOFException eofexception;
        eofexception;
        if (flag)
        {
            jsonreader.setLenient(flag1);
            return null;
        }
        throw new JsonSyntaxException(eofexception);
        Exception exception;
        exception;
        jsonreader.setLenient(flag1);
        throw exception;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        throw new JsonSyntaxException(illegalstateexception);
        IOException ioexception;
        ioexception;
        throw new JsonSyntaxException(ioexception);
    }

    public final Object fromJson(Reader reader, Class class1)
    {
        JsonReader jsonreader = new JsonReader(reader);
        Object obj = fromJson(jsonreader, ((Type) (class1)));
        assertFullConsumption(obj, jsonreader);
        return Primitives.wrap(class1).cast(obj);
    }

    public final Object fromJson(Reader reader, Type type)
    {
        JsonReader jsonreader = new JsonReader(reader);
        Object obj = fromJson(jsonreader, type);
        assertFullConsumption(obj, jsonreader);
        return obj;
    }

    public final Object fromJson(String s, Class class1)
    {
        Object obj = fromJson(s, ((Type) (class1)));
        return Primitives.wrap(class1).cast(obj);
    }

    public final Object fromJson(String s, Type type)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return fromJson(((Reader) (new StringReader(s))), type);
        }
    }

    public final TypeAdapter getAdapter(TypeToken typetoken)
    {
        Object obj = (TypeAdapter)typeTokenCache.get(typetoken);
        if (obj == null) goto _L2; else goto _L1
_L1:
        return ((TypeAdapter) (obj));
_L2:
        Map map = (Map)calls.get();
        Object obj1;
        boolean flag;
        FutureTypeAdapter futuretypeadapter;
        Exception exception;
        Iterator iterator;
        if (map == null)
        {
            HashMap hashmap = new HashMap();
            calls.set(hashmap);
            obj1 = hashmap;
            flag = true;
        } else
        {
            obj1 = map;
            flag = false;
        }
        obj = (FutureTypeAdapter)((Map) (obj1)).get(typetoken);
        if (obj != null) goto _L1; else goto _L3
_L3:
        futuretypeadapter = new FutureTypeAdapter();
        ((Map) (obj1)).put(typetoken, futuretypeadapter);
        iterator = factories.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_180;
            }
            obj = ((TypeAdapterFactory)iterator.next()).create(this, typetoken);
        } while (obj == null);
        futuretypeadapter.setDelegate(((TypeAdapter) (obj)));
        typeTokenCache.put(typetoken, obj);
        ((Map) (obj1)).remove(typetoken);
        if (!flag) goto _L1; else goto _L4
_L4:
        calls.remove();
        return ((TypeAdapter) (obj));
        throw new IllegalArgumentException((new StringBuilder("GSON cannot handle ")).append(typetoken).toString());
        exception;
        ((Map) (obj1)).remove(typetoken);
        if (flag)
        {
            calls.remove();
        }
        throw exception;
    }

    public final TypeAdapter getAdapter(Class class1)
    {
        return getAdapter(TypeToken.get(class1));
    }

    public final TypeAdapter getDelegateAdapter(TypeAdapterFactory typeadapterfactory, TypeToken typetoken)
    {
        Iterator iterator = factories.iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            TypeAdapterFactory typeadapterfactory1 = (TypeAdapterFactory)iterator.next();
            if (!flag)
            {
                if (typeadapterfactory1 == typeadapterfactory)
                {
                    flag = true;
                }
            } else
            {
                TypeAdapter typeadapter = typeadapterfactory1.create(this, typetoken);
                if (typeadapter != null)
                {
                    return typeadapter;
                }
            }
        }
        throw new IllegalArgumentException((new StringBuilder("GSON cannot serialize ")).append(typetoken).toString());
    }

    public final String toJson(JsonElement jsonelement)
    {
        StringWriter stringwriter = new StringWriter();
        toJson(jsonelement, ((Appendable) (stringwriter)));
        return stringwriter.toString();
    }

    public final String toJson(Object obj)
    {
        if (obj == null)
        {
            return toJson(((JsonElement) (JsonNull.INSTANCE)));
        } else
        {
            return toJson(obj, ((Type) (obj.getClass())));
        }
    }

    public final String toJson(Object obj, Type type)
    {
        StringWriter stringwriter = new StringWriter();
        toJson(obj, type, ((Appendable) (stringwriter)));
        return stringwriter.toString();
    }

    public final void toJson(JsonElement jsonelement, JsonWriter jsonwriter)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag = jsonwriter.isLenient();
        jsonwriter.setLenient(true);
        flag1 = jsonwriter.isHtmlSafe();
        jsonwriter.setHtmlSafe(htmlSafe);
        flag2 = jsonwriter.getSerializeNulls();
        jsonwriter.setSerializeNulls(serializeNulls);
        Streams.write(jsonelement, jsonwriter);
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        return;
        IOException ioexception;
        ioexception;
        throw new JsonIOException(ioexception);
        Exception exception;
        exception;
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        throw exception;
    }

    public final void toJson(JsonElement jsonelement, Appendable appendable)
    {
        try
        {
            toJson(jsonelement, newJsonWriter(Streams.writerForAppendable(appendable)));
            return;
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
    }

    public final void toJson(Object obj, Appendable appendable)
    {
        if (obj != null)
        {
            toJson(obj, ((Type) (obj.getClass())), appendable);
            return;
        } else
        {
            toJson(((JsonElement) (JsonNull.INSTANCE)), appendable);
            return;
        }
    }

    public final void toJson(Object obj, Type type, JsonWriter jsonwriter)
    {
        TypeAdapter typeadapter;
        boolean flag;
        boolean flag1;
        boolean flag2;
        typeadapter = getAdapter(TypeToken.get(type));
        flag = jsonwriter.isLenient();
        jsonwriter.setLenient(true);
        flag1 = jsonwriter.isHtmlSafe();
        jsonwriter.setHtmlSafe(htmlSafe);
        flag2 = jsonwriter.getSerializeNulls();
        jsonwriter.setSerializeNulls(serializeNulls);
        typeadapter.write(jsonwriter, obj);
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        return;
        IOException ioexception;
        ioexception;
        throw new JsonIOException(ioexception);
        Exception exception;
        exception;
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        throw exception;
    }

    public final void toJson(Object obj, Type type, Appendable appendable)
    {
        try
        {
            toJson(obj, type, newJsonWriter(Streams.writerForAppendable(appendable)));
            return;
        }
        catch (IOException ioexception)
        {
            throw new JsonIOException(ioexception);
        }
    }

    public final JsonElement toJsonTree(Object obj)
    {
        if (obj == null)
        {
            return JsonNull.INSTANCE;
        } else
        {
            return toJsonTree(obj, ((Type) (obj.getClass())));
        }
    }

    public final JsonElement toJsonTree(Object obj, Type type)
    {
        JsonTreeWriter jsontreewriter = new JsonTreeWriter();
        toJson(obj, type, jsontreewriter);
        return jsontreewriter.get();
    }

    public final String toString()
    {
        return (new StringBuilder("{serializeNulls:")).append(serializeNulls).append("factories:").append(factories).append(",instanceCreators:").append(constructorConstructor).append("}").toString();
    }


    private class _cls1
        implements JsonDeserializationContext
    {

        final Gson this$0;

        public Object deserialize(JsonElement jsonelement, Type type)
        {
            return fromJson(jsonelement, type);
        }

        _cls1()
        {
            this$0 = Gson.this;
            super();
        }
    }


    private class _cls2
        implements JsonSerializationContext
    {

        final Gson this$0;

        public JsonElement serialize(Object obj)
        {
            return toJsonTree(obj);
        }

        public JsonElement serialize(Object obj, Type type)
        {
            return toJsonTree(obj, type);
        }

        _cls2()
        {
            this$0 = Gson.this;
            super();
        }
    }


    private class _cls3 extends TypeAdapter
    {

        final Gson this$0;

        public Double read(JsonReader jsonreader)
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            } else
            {
                return Double.valueOf(jsonreader.nextDouble());
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
                double d = number.doubleValue();
                checkValidFloatingPoint(d);
                jsonwriter.value(number);
                return;
            }
        }

        public volatile void write(JsonWriter jsonwriter, Object obj)
        {
            write(jsonwriter, (Number)obj);
        }

        _cls3()
        {
            this$0 = Gson.this;
            super();
        }
    }


    private class _cls4 extends TypeAdapter
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
                checkValidFloatingPoint(f);
                jsonwriter.value(number);
                return;
            }
        }

        public volatile void write(JsonWriter jsonwriter, Object obj)
        {
            write(jsonwriter, (Number)obj);
        }

        _cls4()
        {
            this$0 = Gson.this;
            super();
        }
    }


    private class _cls5 extends TypeAdapter
    {

        final Gson this$0;

        public Number read(JsonReader jsonreader)
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            } else
            {
                return Long.valueOf(jsonreader.nextLong());
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
                jsonwriter.value(number.toString());
                return;
            }
        }

        public volatile void write(JsonWriter jsonwriter, Object obj)
        {
            write(jsonwriter, (Number)obj);
        }

        _cls5()
        {
            this$0 = Gson.this;
            super();
        }
    }


    private class FutureTypeAdapter extends TypeAdapter
    {

        private TypeAdapter _flddelegate;

        public Object read(JsonReader jsonreader)
        {
            if (_flddelegate == null)
            {
                throw new IllegalStateException();
            } else
            {
                return _flddelegate.read(jsonreader);
            }
        }

        public void setDelegate(TypeAdapter typeadapter)
        {
            if (_flddelegate != null)
            {
                throw new AssertionError();
            } else
            {
                _flddelegate = typeadapter;
                return;
            }
        }

        public void write(JsonWriter jsonwriter, Object obj)
        {
            if (_flddelegate == null)
            {
                throw new IllegalStateException();
            } else
            {
                _flddelegate.write(jsonwriter, obj);
                return;
            }
        }

        FutureTypeAdapter()
        {
        }
    }

}
