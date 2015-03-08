// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;


final class  extends Enum
{

    private static final .VALUES $VALUES[];
    public static final .VALUES BLOCKED;
    public static final .VALUES CONNECTED_LOCAL;
    public static final .VALUES CONNECTED_SERVICE;
    public static final .VALUES CONNECTING;
    public static final .VALUES DISCONNECTED;
    public static final .VALUES PENDING_CONNECTION;
    public static final .VALUES PENDING_DISCONNECT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/analytics/tracking/android/GAServiceProxy$ConnectState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CONNECTING = new <init>("CONNECTING", 0);
        CONNECTED_SERVICE = new <init>("CONNECTED_SERVICE", 1);
        CONNECTED_LOCAL = new <init>("CONNECTED_LOCAL", 2);
        BLOCKED = new <init>("BLOCKED", 3);
        PENDING_CONNECTION = new <init>("PENDING_CONNECTION", 4);
        PENDING_DISCONNECT = new <init>("PENDING_DISCONNECT", 5);
        DISCONNECTED = new <init>("DISCONNECTED", 6);
        e_3B_.clone aclone[] = new <init>[7];
        aclone[0] = CONNECTING;
        aclone[1] = CONNECTED_SERVICE;
        aclone[2] = CONNECTED_LOCAL;
        aclone[3] = BLOCKED;
        aclone[4] = PENDING_CONNECTION;
        aclone[5] = PENDING_DISCONNECT;
        aclone[6] = DISCONNECTED;
        $VALUES = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
