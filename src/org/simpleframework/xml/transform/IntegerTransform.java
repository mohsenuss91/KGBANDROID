// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;


// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class IntegerTransform
    implements Transform
{

    IntegerTransform()
    {
    }

    public Integer read(String s)
    {
        return Integer.valueOf(s);
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public String write(Integer integer)
    {
        return integer.toString();
    }

    public volatile String write(Object obj)
    {
        return write((Integer)obj);
    }
}
