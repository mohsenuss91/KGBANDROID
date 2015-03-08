// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;


// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class StringTransform
    implements Transform
{

    StringTransform()
    {
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public String read(String s)
    {
        return s;
    }

    public volatile String write(Object obj)
    {
        return write((String)obj);
    }

    public String write(String s)
    {
        return s;
    }
}
