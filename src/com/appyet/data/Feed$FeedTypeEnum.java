// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;


public final class  extends Enum
{

    private static final .VALUES $VALUES[];
    public static final .VALUES ATOM;
    public static final .VALUES RDF;
    public static final .VALUES RSS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/appyet/data/Feed$FeedTypeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RSS = new <init>("RSS", 0);
        ATOM = new <init>("ATOM", 1);
        RDF = new <init>("RDF", 2);
        m_3B_.clone aclone[] = new <init>[3];
        aclone[0] = RSS;
        aclone[1] = ATOM;
        aclone[2] = RDF;
        $VALUES = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
