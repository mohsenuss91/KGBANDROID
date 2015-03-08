// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class AtomicIntegerTransform
    implements Transform
{

    AtomicIntegerTransform()
    {
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public AtomicInteger read(String s)
    {
        return new AtomicInteger(Integer.valueOf(s).intValue());
    }

    public volatile String write(Object obj)
    {
        return write((AtomicInteger)obj);
    }

    public String write(AtomicInteger atomicinteger)
    {
        return atomicinteger.toString();
    }
}
