// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.convert;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.convert:
//            ConvertException, Converter, Convert

class ConverterFactory
{

    private final Cache cache = new ConcurrentCache();

    public ConverterFactory()
    {
    }

    private Constructor getConstructor(Class class1)
    {
        Constructor constructor = class1.getDeclaredConstructor(new Class[0]);
        if (!constructor.isAccessible())
        {
            constructor.setAccessible(true);
        }
        return constructor;
    }

    private Converter getConverter(Class class1)
    {
        Constructor constructor = getConstructor(class1);
        if (constructor == null)
        {
            throw new ConvertException("No default constructor for %s", new Object[] {
                class1
            });
        } else
        {
            return getConverter(class1, constructor);
        }
    }

    private Converter getConverter(Class class1, Constructor constructor)
    {
        Converter converter = (Converter)constructor.newInstance(new Object[0]);
        if (converter != null)
        {
            cache.cache(class1, converter);
        }
        return converter;
    }

    public Converter getInstance(Class class1)
    {
        Converter converter = (Converter)cache.fetch(class1);
        if (converter == null)
        {
            converter = getConverter(class1);
        }
        return converter;
    }

    public Converter getInstance(Convert convert)
    {
        Class class1 = convert.value();
        if (class1.isInterface())
        {
            throw new ConvertException("Can not instantiate %s", new Object[] {
                class1
            });
        } else
        {
            return getInstance(class1);
        }
    }
}
