// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class EZ
    implements ComponentCallbacks2
{

    private final size EZ;

    public final void onConfigurationChanged(Configuration configuration)
    {
    }

    public final void onLowMemory()
    {
        EZ.evictAll();
    }

    public final void onTrimMemory(int i)
    {
        if (i >= 60)
        {
            EZ.evictAll();
        } else
        if (i >= 20)
        {
            EZ.trimToSize(EZ.size() / 2);
            return;
        }
    }

    public _cls9(_cls9 _pcls9)
    {
        EZ = _pcls9;
    }
}
