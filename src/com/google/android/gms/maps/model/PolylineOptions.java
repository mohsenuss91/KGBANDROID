// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps.model:
//            PolylineOptionsCreator, LatLng, h

public final class PolylineOptions
    implements SafeParcelable
{

    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
    private int Dg;
    private final List aaU;
    private boolean aaW;
    private float aau;
    private boolean aav;
    private float aaz;
    private final int xJ;

    public PolylineOptions()
    {
        aaz = 10F;
        Dg = 0xff000000;
        aau = 0.0F;
        aav = true;
        aaW = false;
        xJ = 1;
        aaU = new ArrayList();
    }

    PolylineOptions(int i, List list, float f, int j, float f1, boolean flag, boolean flag1)
    {
        aaz = 10F;
        Dg = 0xff000000;
        aau = 0.0F;
        aav = true;
        aaW = false;
        xJ = i;
        aaU = list;
        aaz = f;
        Dg = j;
        aau = f1;
        aav = flag;
        aaW = flag1;
    }

    public final PolylineOptions add(LatLng latlng)
    {
        aaU.add(latlng);
        return this;
    }

    public final transient PolylineOptions add(LatLng alatlng[])
    {
        aaU.addAll(Arrays.asList(alatlng));
        return this;
    }

    public final PolylineOptions addAll(Iterable iterable)
    {
        LatLng latlng;
        for (Iterator iterator = iterable.iterator(); iterator.hasNext(); aaU.add(latlng))
        {
            latlng = (LatLng)iterator.next();
        }

        return this;
    }

    public final PolylineOptions color(int i)
    {
        Dg = i;
        return this;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final PolylineOptions geodesic(boolean flag)
    {
        aaW = flag;
        return this;
    }

    public final int getColor()
    {
        return Dg;
    }

    public final List getPoints()
    {
        return aaU;
    }

    final int getVersionCode()
    {
        return xJ;
    }

    public final float getWidth()
    {
        return aaz;
    }

    public final float getZIndex()
    {
        return aau;
    }

    public final boolean isGeodesic()
    {
        return aaW;
    }

    public final boolean isVisible()
    {
        return aav;
    }

    public final PolylineOptions visible(boolean flag)
    {
        aav = flag;
        return this;
    }

    public final PolylineOptions width(float f)
    {
        aaz = f;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        if (v.jG())
        {
            h.a(this, parcel, i);
            return;
        } else
        {
            PolylineOptionsCreator.a(this, parcel, i);
            return;
        }
    }

    public final PolylineOptions zIndex(float f)
    {
        aau = f;
        return this;
    }

}
