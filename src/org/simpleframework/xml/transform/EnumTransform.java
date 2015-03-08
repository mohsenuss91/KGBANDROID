// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;


// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class EnumTransform
    implements Transform
{

    private final Class type;

    public EnumTransform(Class class1)
    {
        type = class1;
    }

    public Enum read(String s)
    {
        return Enum.valueOf(type, s);
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public String write(Enum enum)
    {
        return enum.name();
    }

    public volatile String write(Object obj)
    {
        return write((Enum)obj);
    }
}
