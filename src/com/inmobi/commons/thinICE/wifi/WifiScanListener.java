// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.wifi;

import java.util.List;

public interface WifiScanListener
{

    public abstract void onResultsReceived(List list);

    public abstract void onTimeout();
}
