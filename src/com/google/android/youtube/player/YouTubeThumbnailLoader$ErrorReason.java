// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;


public final class  extends Enum
{

    public static final a INTERNAL_ERROR;
    public static final a NETWORK_ERROR;
    public static final a UNKNOWN;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/android/youtube/player/YouTubeThumbnailLoader$ErrorReason, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        NETWORK_ERROR = new <init>("NETWORK_ERROR", 0);
        INTERNAL_ERROR = new <init>("INTERNAL_ERROR", 1);
        UNKNOWN = new <init>("UNKNOWN", 2);
        n_3B_.clone aclone[] = new <init>[3];
        aclone[0] = NETWORK_ERROR;
        aclone[1] = INTERNAL_ERROR;
        aclone[2] = UNKNOWN;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
