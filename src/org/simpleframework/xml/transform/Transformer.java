// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.transform:
//            DefaultMatcher, Transform, Matcher, TransformException

public class Transformer
{

    private final Cache cache = new ConcurrentCache();
    private final Cache error = new ConcurrentCache();
    private final Matcher matcher;

    public Transformer(Matcher matcher1)
    {
        matcher = new DefaultMatcher(matcher1);
    }

    private Transform lookup(Class class1)
    {
        if (!error.contains(class1))
        {
            Transform transform = (Transform)cache.fetch(class1);
            if (transform != null)
            {
                return transform;
            } else
            {
                return match(class1);
            }
        } else
        {
            return null;
        }
    }

    private Transform match(Class class1)
    {
        Transform transform = matcher.match(class1);
        if (transform != null)
        {
            cache.cache(class1, transform);
            return transform;
        } else
        {
            error.cache(class1, this);
            return transform;
        }
    }

    public Object read(String s, Class class1)
    {
        Transform transform = lookup(class1);
        if (transform == null)
        {
            throw new TransformException("Transform of %s not supported", new Object[] {
                class1
            });
        } else
        {
            return transform.read(s);
        }
    }

    public boolean valid(Class class1)
    {
        return lookup(class1) != null;
    }

    public String write(Object obj, Class class1)
    {
        Transform transform = lookup(class1);
        if (transform == null)
        {
            throw new TransformException("Transform of %s not supported", new Object[] {
                class1
            });
        } else
        {
            return transform.write(obj);
        }
    }
}
