// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl;


public final class I extends Enum
{

    public static final a APP_ANALYTICS_PREVIOUSLY_UPLOADED;
    public static final a APP_ANALYTICS_UPLOAD_FAILURE;
    public static final a APP_ANALYTICS_UPLOAD_SUCCESS;
    public static final a APP_CONTEXT_NULL;
    public static final a APP_NOT_CONNECTED;
    public static final a ODIN1_NULL;
    public static final a RELOAD_WEBVIEW_ERROR;
    private static final a a[];

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/inmobi/commons/analytics/iat/impl/AdTrackerConstants$StatusCode, s);
    }

    public static I[] values()
    {
        return (I[])a.clone();
    }

    static 
    {
        APP_ANALYTICS_UPLOAD_SUCCESS = new <init>("APP_ANALYTICS_UPLOAD_SUCCESS", 0);
        APP_CONTEXT_NULL = new <init>("APP_CONTEXT_NULL", 1);
        APP_ANALYTICS_PREVIOUSLY_UPLOADED = new <init>("APP_ANALYTICS_PREVIOUSLY_UPLOADED", 2);
        ODIN1_NULL = new <init>("ODIN1_NULL", 3);
        APP_ANALYTICS_UPLOAD_FAILURE = new <init>("APP_ANALYTICS_UPLOAD_FAILURE", 4);
        APP_NOT_CONNECTED = new <init>("APP_NOT_CONNECTED", 5);
        RELOAD_WEBVIEW_ERROR = new <init>("RELOAD_WEBVIEW_ERROR", 6);
        e_3B_.clone aclone[] = new <init>[7];
        aclone[0] = APP_ANALYTICS_UPLOAD_SUCCESS;
        aclone[1] = APP_CONTEXT_NULL;
        aclone[2] = APP_ANALYTICS_PREVIOUSLY_UPLOADED;
        aclone[3] = ODIN1_NULL;
        aclone[4] = APP_ANALYTICS_UPLOAD_FAILURE;
        aclone[5] = APP_NOT_CONNECTED;
        aclone[6] = RELOAD_WEBVIEW_ERROR;
        a = aclone;
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
