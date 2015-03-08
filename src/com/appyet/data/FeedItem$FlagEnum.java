// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;


public final class  extends Enum
{

    private static final .VALUES $VALUES[];
    public static final .VALUES Article;
    public static final .VALUES Delete;
    public static final .VALUES Feed;
    public static final .VALUES None;
    public static final .VALUES Update;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/appyet/data/FeedItem$FlagEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        Update = new <init>("Update", 1);
        Delete = new <init>("Delete", 2);
        Article = new <init>("Article", 3);
        Feed = new <init>("Feed", 4);
        m_3B_.clone aclone[] = new <init>[5];
        aclone[0] = None;
        aclone[1] = Update;
        aclone[2] = Delete;
        aclone[3] = Article;
        aclone[4] = Feed;
        $VALUES = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
