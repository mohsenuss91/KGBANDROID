// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml;


public final class DefaultType extends Enum
{

    private static final DefaultType $VALUES[];
    public static final DefaultType FIELD;
    public static final DefaultType PROPERTY;

    private DefaultType(String s, int i)
    {
        super(s, i);
    }

    public static DefaultType valueOf(String s)
    {
        return (DefaultType)Enum.valueOf(org/simpleframework/xml/DefaultType, s);
    }

    public static DefaultType[] values()
    {
        return (DefaultType[])$VALUES.clone();
    }

    static 
    {
        FIELD = new DefaultType("FIELD", 0);
        PROPERTY = new DefaultType("PROPERTY", 1);
        DefaultType adefaulttype[] = new DefaultType[2];
        adefaulttype[0] = FIELD;
        adefaulttype[1] = PROPERTY;
        $VALUES = adefaulttype;
    }
}
