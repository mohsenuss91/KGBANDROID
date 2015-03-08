// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.convert;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.convert:
//            RegistryBinder, Converter

public class Registry
{

    private final RegistryBinder binder = new RegistryBinder();
    private final Cache cache = new ConcurrentCache();

    public Registry()
    {
    }

    private Converter create(Class class1)
    {
        Converter converter = binder.lookup(class1);
        if (converter != null)
        {
            cache.cache(class1, converter);
        }
        return converter;
    }

    public Registry bind(Class class1, Class class2)
    {
        if (class1 != null)
        {
            binder.bind(class1, class2);
        }
        return this;
    }

    public Registry bind(Class class1, Converter converter)
    {
        if (class1 != null)
        {
            cache.cache(class1, converter);
        }
        return this;
    }

    public Converter lookup(Class class1)
    {
        Converter converter = (Converter)cache.fetch(class1);
        if (converter == null)
        {
            converter = create(class1);
        }
        return converter;
    }
}
