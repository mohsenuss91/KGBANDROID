// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


final class  extends Enum
{

    private static final .VALUES $VALUES[];
    public static final .VALUES ATTRIBUTE;
    public static final .VALUES ELEMENT;
    public static final .VALUES TEXT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/simpleframework/xml/core/KeyBuilder$KeyType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TEXT = new <init>("TEXT", 0);
        ATTRIBUTE = new <init>("ATTRIBUTE", 1);
        ELEMENT = new <init>("ELEMENT", 2);
        e_3B_.clone aclone[] = new <init>[3];
        aclone[0] = TEXT;
        aclone[1] = ATTRIBUTE;
        aclone[2] = ELEMENT;
        $VALUES = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
