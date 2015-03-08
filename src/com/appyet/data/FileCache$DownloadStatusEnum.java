// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;


public final class  extends Enum
{

    private static final .VALUES $VALUES[];
    public static final .VALUES Failed;
    public static final .VALUES Ignore;
    public static final .VALUES Pending;
    public static final .VALUES Success;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/appyet/data/FileCache$DownloadStatusEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Pending = new <init>("Pending", 0);
        Failed = new <init>("Failed", 1);
        Success = new <init>("Success", 2);
        Ignore = new <init>("Ignore", 3);
        m_3B_.clone aclone[] = new <init>[4];
        aclone[0] = Pending;
        aclone[1] = Failed;
        aclone[2] = Success;
        aclone[3] = Ignore;
        $VALUES = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
