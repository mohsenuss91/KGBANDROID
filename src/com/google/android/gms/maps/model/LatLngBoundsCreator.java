// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLngBounds, LatLng

public class LatLngBoundsCreator
    implements android.os.Parcelable.Creator
{

    public static final int CONTENT_DESCRIPTION;

    public LatLngBoundsCreator()
    {
    }

    static void a(LatLngBounds latlngbounds, Parcel parcel, int i)
    {
        int j = b.C(parcel);
        b.c(parcel, 1, latlngbounds.getVersionCode());
        b.a(parcel, 2, latlngbounds.southwest, i, false);
        b.a(parcel, 3, latlngbounds.northeast, i, false);
        b.G(parcel, j);
    }

    public LatLngBounds createFromParcel(Parcel parcel)
    {
        int i = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        LatLng latlng = null;
        int j = 0;
        LatLng latlng1 = null;
        do
        {
            if (parcel.dataPosition() < i)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.ar(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    latlng = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    latlng1 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, LatLng.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != i)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(i).toString(), parcel);
            } else
            {
                return new LatLngBounds(j, latlng, latlng1);
            }
        } while (true);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public LatLngBounds[] newArray(int i)
    {
        return new LatLngBounds[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}
