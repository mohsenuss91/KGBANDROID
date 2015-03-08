// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;


public final class  extends Enum
{

    public static final a AD_CLICK_IN_PROGRESS;
    public static final a AD_DOWNLOAD_IN_PROGRESS;
    public static final a AD_FETCH_TIMEOUT;
    public static final a AD_RENDERING_TIMEOUT;
    public static final a INTERNAL_ERROR;
    public static final a INVALID_APP_ID;
    public static final a INVALID_REQUEST;
    public static final a NETWORK_ERROR;
    public static final a NO_FILL;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/androidsdk/AdRequest$ErrorCode, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    public final int getErrorCode()
    {
        byte byte0 = 3;
        if (this == AD_FETCH_TIMEOUT)
        {
            byte0 = 1;
        }
        if (this == NETWORK_ERROR)
        {
            byte0 = 2;
        }
        return byte0;
    }

    static 
    {
        INVALID_REQUEST = new <init>("INVALID_REQUEST", 0);
        AD_DOWNLOAD_IN_PROGRESS = new <init>("AD_DOWNLOAD_IN_PROGRESS", 1);
        AD_CLICK_IN_PROGRESS = new <init>("AD_CLICK_IN_PROGRESS", 2);
        AD_FETCH_TIMEOUT = new <init>("AD_FETCH_TIMEOUT", 3);
        AD_RENDERING_TIMEOUT = new <init>("AD_RENDERING_TIMEOUT", 4);
        NETWORK_ERROR = new <init>("NETWORK_ERROR", 5);
        INTERNAL_ERROR = new <init>("INTERNAL_ERROR", 6);
        NO_FILL = new <init>("NO_FILL", 7);
        INVALID_APP_ID = new <init>("INVALID_APP_ID", 8);
        NETWORK_ERROR anetwork_error[] = new <init>[9];
        anetwork_error[0] = INVALID_REQUEST;
        anetwork_error[1] = AD_DOWNLOAD_IN_PROGRESS;
        anetwork_error[2] = AD_CLICK_IN_PROGRESS;
        anetwork_error[3] = AD_FETCH_TIMEOUT;
        anetwork_error[4] = AD_RENDERING_TIMEOUT;
        anetwork_error[5] = NETWORK_ERROR;
        anetwork_error[6] = INTERNAL_ERROR;
        anetwork_error[7] = NO_FILL;
        anetwork_error[8] = INVALID_APP_ID;
        a = anetwork_error;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
