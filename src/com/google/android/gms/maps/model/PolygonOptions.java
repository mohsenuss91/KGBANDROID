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
//            PolygonOptionsCreator, LatLng, g

public final class PolygonOptions
    implements SafeParcelable
{

    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
    private final List aaU;
    private final List aaV;
    private boolean aaW;
    private float aar;
    private int aas;
    private int aat;
    private float aau;
    private boolean aav;
    private final int xJ;

    public PolygonOptions()
    {
        aar = 10F;
        aas = 0xff000000;
        aat = 0;
        aau = 0.0F;
        aav = true;
        aaW = false;
        xJ = 1;
        aaU = new ArrayList();
        aaV = new ArrayList();
    }

    PolygonOptions(int i, List list, List list1, float f, int j, int k, float f1, 
            boolean flag, boolean flag1)
    {
        aar = 10F;
        aas = 0xff000000;
        aat = 0;
        aau = 0.0F;
        aav = true;
        aaW = false;
        xJ = i;
        aaU = list;
        aaV = list1;
        aar = f;
        aas = j;
        aat = k;
        aau = f1;
        aav = flag;
        aaW = flag1;
    }

    public final PolygonOptions add(LatLng latlng)
    {
        aaU.add(latlng);
        return this;
    }

    public final transient PolygonOptions add(LatLng alatlng[])
    {
        aaU.addAll(Arrays.asList(alatlng));
        return this;
    }

    public final PolygonOptions addAll(Iterable iterable)
    {
        LatLng latlng;
        for (Iterator iterator = iterable.iterator(); iterator.hasNext(); aaU.add(latlng))
        {
            latlng = (LatLng)iterator.next();
        }

        return this;
    }

    public final PolygonOptions addHole(Iterable iterable)
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = iterable.iterator(); iterator.hasNext(); arraylist.add((LatLng)iterator.next())) { }
        aaV.add(arraylist);
        return this;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final PolygonOptions fillColor(int i)
    {
        aat = i;
        return this;
    }

    public final PolygonOptions geodesic(boolean flag)
    {
        aaW = flag;
        return this;
    }

    public final int getFillColor()
    {
        return aat;
    }

    public final List getHoles()
    {
        return aaV;
    }

    public final List getPoints()
    {
        return aaU;
    }

    public final int getStrokeColor()
    {
        return aas;
    }

    public final float getStrokeWidth()
    {
        return aar;
    }

    final int getVersionCode()
    {
        return xJ;
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

    final List jK()
    {
        return aaV;
    }

    public final PolygonOptions strokeColor(int i)
    {
        aas = i;
        return this;
    }

    public final PolygonOptions strokeWidth(float f)
    {
        aar = f;
        return this;
    }

    public final PolygonOptions visible(boolean flag)
    {
        aav = flag;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        if (v.jG())
        {
            g.a(this, parcel, i);
            return;
        } else
        {
            PolygonOptionsCreator.a(this, parcel, i);
            return;
        }
    }

    public final PolygonOptions zIndex(float f)
    {
        aau = f;
        return this;
    }

}
