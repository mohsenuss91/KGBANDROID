// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;


public final class  extends Enum
{

    private static final .VALUES $VALUES[];
    public static final .VALUES DownloadCompleted;
    public static final .VALUES DownloadPending;
    public static final .VALUES None;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/appyet/data/FeedItem$EnclosureStatusEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        DownloadPending = new <init>("DownloadPending", 1);
        DownloadCompleted = new <init>("DownloadCompleted", 2);
        m_3B_.clone aclone[] = new <init>[3];
        aclone[0] = None;
        aclone[1] = DownloadPending;
        aclone[2] = DownloadCompleted;
        $VALUES = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
