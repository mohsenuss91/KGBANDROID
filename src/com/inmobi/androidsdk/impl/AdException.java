// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl;


public final class AdException extends Exception
{

    public static final int INTERNAL_ERROR = 200;
    public static final int INVALID_APP_ID = 400;
    public static final int INVALID_REQUEST = 300;
    public static final int NO_FILL = 100;
    private static final long serialVersionUID = 0xc98aff0d8d9fbfedL;
    private int a;
    private String b;
    private int c;

    public AdException(String s, int i, String s1, int j)
    {
        super(s);
        a = 300;
        b = null;
        c = 599;
        a = i;
        b = s1;
        c = j;
    }

    public AdException(String s, Exception exception, int i, String s1)
    {
        super(s, exception);
        a = 300;
        b = null;
        c = 599;
        a = i;
        b = s1;
    }

    public final int getCode()
    {
        return a;
    }

    public final com.inmobi.androidsdk.AdRequest.ErrorCode getErrorCode()
    {
        switch (a)
        {
        default:
            return com.inmobi.androidsdk.AdRequest.ErrorCode.INTERNAL_ERROR;

        case 200: 
            return com.inmobi.androidsdk.AdRequest.ErrorCode.INTERNAL_ERROR;

        case 400: 
            return com.inmobi.androidsdk.AdRequest.ErrorCode.INVALID_APP_ID;

        case 300: 
            return com.inmobi.androidsdk.AdRequest.ErrorCode.INVALID_REQUEST;

        case 100: // 'd'
            return com.inmobi.androidsdk.AdRequest.ErrorCode.NO_FILL;
        }
    }

    public final int getHttpCode()
    {
        return c;
    }

    public final String getImpressionId()
    {
        return b;
    }

    public final void setCode(int i)
    {
        a = i;
    }
}
