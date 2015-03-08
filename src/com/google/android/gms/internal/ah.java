// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

public final class ah extends aq.a
{

    private final AdListener lO;

    public ah(AdListener adlistener)
    {
        lO = adlistener;
    }

    public final void onAdClosed()
    {
        lO.onAdClosed();
    }

    public final void onAdFailedToLoad(int i)
    {
        lO.onAdFailedToLoad(i);
    }

    public final void onAdLeftApplication()
    {
        lO.onAdLeftApplication();
    }

    public final void onAdLoaded()
    {
        lO.onAdLoaded();
    }

    public final void onAdOpened()
    {
        lO.onAdOpened();
    }
}
