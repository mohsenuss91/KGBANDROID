// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

// Referenced classes of package com.google.android.gms.maps:
//            StreetViewPanoramaOptionsCreator

public final class StreetViewPanoramaOptions
    implements SafeParcelable
{

    public static final StreetViewPanoramaOptionsCreator CREATOR = new StreetViewPanoramaOptionsCreator();
    private StreetViewPanoramaCamera ZS;
    private String ZT;
    private LatLng ZU;
    private Integer ZV;
    private Boolean ZW;
    private Boolean ZX;
    private Boolean ZY;
    private Boolean Zq;
    private Boolean Zw;
    private final int xJ;

    public StreetViewPanoramaOptions()
    {
        ZW = Boolean.valueOf(true);
        Zw = Boolean.valueOf(true);
        ZX = Boolean.valueOf(true);
        ZY = Boolean.valueOf(true);
        xJ = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetviewpanoramacamera, String s, LatLng latlng, Integer integer, byte byte0, byte byte1, 
            byte byte2, byte byte3, byte byte4)
    {
        ZW = Boolean.valueOf(true);
        Zw = Boolean.valueOf(true);
        ZX = Boolean.valueOf(true);
        ZY = Boolean.valueOf(true);
        xJ = i;
        ZS = streetviewpanoramacamera;
        ZU = latlng;
        ZV = integer;
        ZT = s;
        ZW = a.a(byte0);
        Zw = a.a(byte1);
        ZX = a.a(byte2);
        ZY = a.a(byte3);
        Zq = a.a(byte4);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Boolean getPanningGesturesEnabled()
    {
        return ZX;
    }

    public final String getPanoramaId()
    {
        return ZT;
    }

    public final LatLng getPosition()
    {
        return ZU;
    }

    public final Integer getRadius()
    {
        return ZV;
    }

    public final Boolean getStreetNamesEnabled()
    {
        return ZY;
    }

    public final StreetViewPanoramaCamera getStreetViewPanoramaCamera()
    {
        return ZS;
    }

    public final Boolean getUseViewLifecycleInFragment()
    {
        return Zq;
    }

    public final Boolean getUserNavigationEnabled()
    {
        return ZW;
    }

    final int getVersionCode()
    {
        return xJ;
    }

    public final Boolean getZoomGesturesEnabled()
    {
        return Zw;
    }

    final byte jA()
    {
        return a.c(ZY);
    }

    final byte jm()
    {
        return a.c(Zq);
    }

    final byte jq()
    {
        return a.c(Zw);
    }

    final byte jy()
    {
        return a.c(ZW);
    }

    final byte jz()
    {
        return a.c(ZX);
    }

    public final StreetViewPanoramaOptions panningGesturesEnabled(boolean flag)
    {
        ZX = Boolean.valueOf(flag);
        return this;
    }

    public final StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetviewpanoramacamera)
    {
        ZS = streetviewpanoramacamera;
        return this;
    }

    public final StreetViewPanoramaOptions panoramaId(String s)
    {
        ZT = s;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latlng)
    {
        ZU = latlng;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latlng, Integer integer)
    {
        ZU = latlng;
        ZV = integer;
        return this;
    }

    public final StreetViewPanoramaOptions streetNamesEnabled(boolean flag)
    {
        ZY = Boolean.valueOf(flag);
        return this;
    }

    public final StreetViewPanoramaOptions useViewLifecycleInFragment(boolean flag)
    {
        Zq = Boolean.valueOf(flag);
        return this;
    }

    public final StreetViewPanoramaOptions userNavigationEnabled(boolean flag)
    {
        ZW = Boolean.valueOf(flag);
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.maps.StreetViewPanoramaOptionsCreator.a(this, parcel, i);
    }

    public final StreetViewPanoramaOptions zoomGesturesEnabled(boolean flag)
    {
        Zw = Boolean.valueOf(flag);
        return this;
    }

}
