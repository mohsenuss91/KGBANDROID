// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hy
    implements android.os.Parcelable.Creator
{

    public hy()
    {
    }

    static void a(hw.a a1, Parcel parcel, int i)
    {
        int j = b.C(parcel);
        b.c(parcel, 1, a1.versionCode);
        b.a(parcel, 2, a1.GW, false);
        b.c(parcel, 3, a1.GX);
        b.G(parcel, j);
    }

    public hw.a G(Parcel parcel)
    {
        int i = 0;
        int j = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        String s = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.ar(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.o(parcel, l);
                    break;

                case 3: // '\003'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new hw.a(k, s, i);
            }
        } while (true);
    }

    public hw.a[] av(int i)
    {
        return new hw.a[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return G(parcel);
    }

    public Object[] newArray(int i)
    {
        return av(i);
    }
}
