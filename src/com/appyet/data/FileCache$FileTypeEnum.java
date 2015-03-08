// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;


public final class  extends Enum
{

    private static final .VALUES $VALUES[];
    public static final .VALUES FavIcon;
    public static final .VALUES Image;
    public static final .VALUES Podcast;
    public static final .VALUES Thumbnail;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/appyet/data/FileCache$FileTypeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Image = new <init>("Image", 0);
        Podcast = new <init>("Podcast", 1);
        FavIcon = new <init>("FavIcon", 2);
        Thumbnail = new <init>("Thumbnail", 3);
        m_3B_.clone aclone[] = new <init>[4];
        aclone[0] = Image;
        aclone[1] = Podcast;
        aclone[2] = FavIcon;
        aclone[3] = Thumbnail;
        $VALUES = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
