// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            ic

public class id
    implements android.os.Parcelable.Creator
{

    public id()
    {
    }

    static void a(ic ic1, Parcel parcel, int i)
    {
        int j = b.C(parcel);
        b.c(parcel, 1, ic1.getVersionCode());
        b.b(parcel, 2, ic1.fQ(), false);
        b.a(parcel, 3, ic1.fR(), false);
        b.G(parcel, j);
    }

    public ic J(Parcel parcel)
    {
        String s = null;
        int i = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        int j = 0;
        java.util.ArrayList arraylist = null;
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, k, ic.a.CREATOR);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.a.o(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != i)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(i).toString(), parcel);
            } else
            {
                return new ic(j, arraylist, s);
            }
        } while (true);
    }

    public ic[] ay(int i)
    {
        return new ic[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return J(parcel);
    }

    public Object[] newArray(int i)
    {
        return ay(i);
    }
}
