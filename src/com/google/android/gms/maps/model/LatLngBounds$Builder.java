// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import com.google.android.gms.internal.hn;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLngBounds, LatLng

public final class aaK
{

    private double aaH;
    private double aaI;
    private double aaJ;
    private double aaK;

    private boolean d(double d1)
    {
        if (aaJ > aaK) goto _L2; else goto _L1
_L1:
        if (aaJ > d1 || d1 > aaK) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (aaJ > d1 && d1 > aaK)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public final LatLngBounds build()
    {
        boolean flag;
        if (!Double.isNaN(aaJ))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hn.a(flag, "no included points");
        return new LatLngBounds(new LatLng(aaH, aaJ), new LatLng(aaI, aaK));
    }

    public final aaK include(LatLng latlng)
    {
        double d1;
        aaH = Math.min(aaH, latlng.latitude);
        aaI = Math.max(aaI, latlng.latitude);
        d1 = latlng.longitude;
        if (!Double.isNaN(aaJ)) goto _L2; else goto _L1
_L1:
        aaJ = d1;
_L6:
        aaK = d1;
_L4:
        return this;
_L2:
        if (d(d1)) goto _L4; else goto _L3
_L3:
        if (LatLngBounds.d(aaJ, d1) < LatLngBounds.e(aaK, d1))
        {
            aaJ = d1;
            return this;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public ()
    {
        aaH = (1.0D / 0.0D);
        aaI = (-1.0D / 0.0D);
        aaJ = (0.0D / 0.0D);
        aaK = (0.0D / 0.0D);
    }
}
