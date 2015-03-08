// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;


// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class BooleanTransform
    implements Transform
{

    BooleanTransform()
    {
    }

    public Boolean read(String s)
    {
        return Boolean.valueOf(s);
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public String write(Boolean boolean1)
    {
        return boolean1.toString();
    }

    public volatile String write(Object obj)
    {
        return write((Boolean)obj);
    }
}
