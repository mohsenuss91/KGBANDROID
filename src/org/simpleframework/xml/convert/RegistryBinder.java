// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.convert;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.convert:
//            ConverterFactory, Converter

class RegistryBinder
{

    private final Cache cache = new ConcurrentCache();
    private final ConverterFactory factory = new ConverterFactory();

    public RegistryBinder()
    {
    }

    private Converter create(Class class1)
    {
        return factory.getInstance(class1);
    }

    public void bind(Class class1, Class class2)
    {
        cache.cache(class1, class2);
    }

    public Converter lookup(Class class1)
    {
        Class class2 = (Class)cache.fetch(class1);
        if (class2 != null)
        {
            return create(class2);
        } else
        {
            return null;
        }
    }
}
