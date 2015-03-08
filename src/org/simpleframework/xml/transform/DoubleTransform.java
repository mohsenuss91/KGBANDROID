// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;


// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class DoubleTransform
    implements Transform
{

    DoubleTransform()
    {
    }

    public Double read(String s)
    {
        return Double.valueOf(s);
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public String write(Double double1)
    {
        return double1.toString();
    }

    public volatile String write(Object obj)
    {
        return write((Double)obj);
    }
}
