// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;


public final class A extends Enum
{

    public static final a AUTOPLAY_DISABLED;
    public static final a BLOCKED_FOR_APP;
    public static final a EMBEDDING_DISABLED;
    public static final a EMPTY_PLAYLIST;
    public static final a INTERNAL_ERROR;
    public static final a NETWORK_ERROR;
    public static final a NOT_PLAYABLE;
    public static final a PLAYER_VIEW_TOO_SMALL;
    public static final a UNAUTHORIZED_OVERLAY;
    public static final a UNEXPECTED_SERVICE_DISCONNECTION;
    public static final a UNKNOWN;
    public static final a USER_DECLINED_HIGH_BANDWIDTH;
    public static final a USER_DECLINED_RESTRICTED_CONTENT;
    private static final a a[];

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/google/android/youtube/player/YouTubePlayer$ErrorReason, s);
    }

    public static A[] values()
    {
        return (A[])a.clone();
    }

    static 
    {
        EMBEDDING_DISABLED = new <init>("EMBEDDING_DISABLED", 0);
        BLOCKED_FOR_APP = new <init>("BLOCKED_FOR_APP", 1);
        NOT_PLAYABLE = new <init>("NOT_PLAYABLE", 2);
        NETWORK_ERROR = new <init>("NETWORK_ERROR", 3);
        UNAUTHORIZED_OVERLAY = new <init>("UNAUTHORIZED_OVERLAY", 4);
        PLAYER_VIEW_TOO_SMALL = new <init>("PLAYER_VIEW_TOO_SMALL", 5);
        EMPTY_PLAYLIST = new <init>("EMPTY_PLAYLIST", 6);
        AUTOPLAY_DISABLED = new <init>("AUTOPLAY_DISABLED", 7);
        USER_DECLINED_RESTRICTED_CONTENT = new <init>("USER_DECLINED_RESTRICTED_CONTENT", 8);
        USER_DECLINED_HIGH_BANDWIDTH = new <init>("USER_DECLINED_HIGH_BANDWIDTH", 9);
        UNEXPECTED_SERVICE_DISCONNECTION = new <init>("UNEXPECTED_SERVICE_DISCONNECTION", 10);
        INTERNAL_ERROR = new <init>("INTERNAL_ERROR", 11);
        UNKNOWN = new <init>("UNKNOWN", 12);
        n_3B_.clone aclone[] = new <init>[13];
        aclone[0] = EMBEDDING_DISABLED;
        aclone[1] = BLOCKED_FOR_APP;
        aclone[2] = NOT_PLAYABLE;
        aclone[3] = NETWORK_ERROR;
        aclone[4] = UNAUTHORIZED_OVERLAY;
        aclone[5] = PLAYER_VIEW_TOO_SMALL;
        aclone[6] = EMPTY_PLAYLIST;
        aclone[7] = AUTOPLAY_DISABLED;
        aclone[8] = USER_DECLINED_RESTRICTED_CONTENT;
        aclone[9] = USER_DECLINED_HIGH_BANDWIDTH;
        aclone[10] = UNEXPECTED_SERVICE_DISCONNECTION;
        aclone[11] = INTERNAL_ERROR;
        aclone[12] = UNKNOWN;
        a = aclone;
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
