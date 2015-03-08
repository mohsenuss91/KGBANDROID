// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import java.util.List;

interface Dispatcher
{

    public abstract void close();

    public abstract int dispatchHits(List list);

    public abstract boolean okToDispatch();

    public abstract void overrideHostUrl(String s);
}
