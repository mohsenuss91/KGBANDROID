// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.net;


public interface HttpRequestCallback
{

    public static final int HTTP_FAILURE = 1;
    public static final int HTTP_SUCCESS;

    public abstract void notifyResult(int i, Object obj);
}
