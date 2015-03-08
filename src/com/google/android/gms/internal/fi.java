// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            fh, fl

public class fi
    implements android.os.Parcelable.Creator
{

    public fi()
    {
    }

    static void a(fh fh1, Parcel parcel, int i)
    {
        int j = b.C(parcel);
        b.a(parcel, 1, fh1.xK, i, false);
        b.c(parcel, 1000, fh1.xJ);
        b.a(parcel, 2, fh1.xL, false);
        b.a(parcel, 3, fh1.xM);
        b.G(parcel, j);
    }

    public fh[] D(int i)
    {
        return new fh[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return l(parcel);
    }

    public fh l(Parcel parcel)
    {
        int i = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        String s = null;
        fl afl[] = null;
        int j = 0;
        boolean flag = false;
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
                    afl = (fl[])com.google.android.gms.common.internal.safeparcel.a.b(parcel, k, fl.CREATOR);
                    break;

                case 1000: 
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.o(parcel, k);
                    break;

                case 3: // '\003'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != i)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(i).toString(), parcel);
            } else
            {
                return new fh(j, afl, s, flag);
            }
        } while (true);
    }

    public Object[] newArray(int i)
    {
        return D(i);
    }
}
