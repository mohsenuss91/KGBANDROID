// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;


// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class ByteTransform
    implements Transform
{

    ByteTransform()
    {
    }

    public Byte read(String s)
    {
        return Byte.valueOf(s);
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public String write(Byte byte1)
    {
        return byte1.toString();
    }

    public volatile String write(Object obj)
    {
        return write((Byte)obj);
    }
}
