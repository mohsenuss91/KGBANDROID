// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.identity.intents.model:
//            CountrySpecification

public class a
    implements android.os.Parcelable.Creator
{

    public a()
    {
    }

    static void a(CountrySpecification countryspecification, Parcel parcel, int i)
    {
        int j = b.C(parcel);
        b.c(parcel, 1, countryspecification.getVersionCode());
        b.a(parcel, 2, countryspecification.rc, false);
        b.G(parcel, j);
    }

    public CountrySpecification bq(Parcel parcel)
    {
        int i = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        int j = 0;
        String s = null;
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
                    s = com.google.android.gms.common.internal.safeparcel.a.o(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != i)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a((new StringBuilder("Overread allowed size end=")).append(i).toString(), parcel);
            } else
            {
                return new CountrySpecification(j, s);
            }
        } while (true);
    }

    public CountrySpecification[] cD(int i)
    {
        return new CountrySpecification[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return bq(parcel);
    }

    public Object[] newArray(int i)
    {
        return cD(i);
    }
}
