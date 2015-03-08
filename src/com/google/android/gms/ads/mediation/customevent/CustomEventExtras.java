// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.j;
import java.util.HashMap;

public final class CustomEventExtras
    implements j
{

    private final HashMap sX = new HashMap();

    public CustomEventExtras()
    {
    }

    public final Object getExtra(String s)
    {
        return sX.get(s);
    }

    public final void setExtra(String s, Object obj)
    {
        sX.put(s, obj);
    }
}
