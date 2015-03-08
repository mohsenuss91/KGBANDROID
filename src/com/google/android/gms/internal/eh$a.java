// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

final class rL
{

    private long rK;
    private long rL;

    public final void bA()
    {
        rL = SystemClock.elapsedRealtime();
    }

    public final void bB()
    {
        rK = SystemClock.elapsedRealtime();
    }

    public final long bz()
    {
        return rL;
    }

    public final Bundle toBundle()
    {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", rK);
        bundle.putLong("tclose", rL);
        return bundle;
    }

    public ()
    {
        rK = -1L;
        rL = -1L;
    }
}
