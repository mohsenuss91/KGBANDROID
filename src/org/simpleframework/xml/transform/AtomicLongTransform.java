// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class AtomicLongTransform
    implements Transform
{

    AtomicLongTransform()
    {
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public AtomicLong read(String s)
    {
        return new AtomicLong(Long.valueOf(s).longValue());
    }

    public volatile String write(Object obj)
    {
        return write((AtomicLong)obj);
    }

    public String write(AtomicLong atomiclong)
    {
        return atomiclong.toString();
    }
}
