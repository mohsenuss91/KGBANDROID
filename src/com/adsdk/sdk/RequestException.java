// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;


public class RequestException extends Exception
{

    private static final long serialVersionUID = 1L;

    public RequestException()
    {
    }

    public RequestException(String s)
    {
        super(s);
    }

    public RequestException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public RequestException(Throwable throwable)
    {
        super(throwable);
    }
}
