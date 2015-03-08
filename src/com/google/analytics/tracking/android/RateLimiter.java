// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;


interface RateLimiter
{

    public static final int DEFAULT_MAX_TOKEN_COUNT = 60;
    public static final long DEFAULT_MILLISECONDS_PER_TOKEN = 2000L;

    public abstract boolean tokenAvailable();
}
