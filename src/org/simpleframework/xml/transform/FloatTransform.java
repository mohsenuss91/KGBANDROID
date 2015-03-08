// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;


// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class FloatTransform
    implements Transform
{

    FloatTransform()
    {
    }

    public Float read(String s)
    {
        return Float.valueOf(s);
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public String write(Float float1)
    {
        return float1.toString();
    }

    public volatile String write(Object obj)
    {
        return write((Float)obj);
    }
}
