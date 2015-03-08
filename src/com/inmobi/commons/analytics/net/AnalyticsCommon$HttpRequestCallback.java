// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.net;


public interface 
{

    public static final int HTTP_FAILURE = 1;
    public static final int HTTP_SUCCESS;

    public abstract void notifyResult(int i, Object obj);
}
