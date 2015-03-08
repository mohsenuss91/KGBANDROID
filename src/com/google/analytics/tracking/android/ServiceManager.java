// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;


public abstract class ServiceManager
{

    public ServiceManager()
    {
    }

    public abstract void dispatchLocalHits();

    abstract void onRadioPowered();

    public abstract void setForceLocalDispatch();

    public abstract void setLocalDispatchPeriod(int i);

    abstract void updateConnectivityStatus(boolean flag);
}
