// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            cf

public class ce
    implements android.os.Parcelable.Creator
{

    public ce()
    {
    }

    static void a(cf cf1, Parcel parcel, int j)
    {
        int k = b.C(parcel);
        b.c(parcel, 1, cf1.versionCode);
        b.a(parcel, 2, cf1.nY, false);
        b.a(parcel, 3, cf1.nZ, false);
        b.a(parcel, 4, cf1.mimeType, false);
        b.a(parcel, 5, cf1.packageName, false);
        b.a(parcel, 6, cf1.oa, false);
        b.a(parcel, 7, cf1.ob, false);
        b.a(parcel, 8, cf1.oc, false);
        b.G(parcel, k);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return e(parcel);
    }

    public cf e(Parcel parcel)
    {
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        int k = 0;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        String s6 = null;
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
                    s6 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, l);
                    break;

                case 3: // '\003'
                    s5 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, l);
                    break;

                case 4: // '\004'
                    s4 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, l);
                    break;

                case 5: // '\005'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, l);
                    break;

                case 6: // '\006'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, l);
                    break;

                case 7: // '\007'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, l);
                    break;

                case 8: // '\b'
                    s = com.google.android.gms.common.internal.safeparcel.a.o(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new cf(k, s6, s5, s4, s3, s2, s1, s);
            }
        } while (true);
    }

    public cf[] i(int j)
    {
        return new cf[j];
    }

    public Object[] newArray(int j)
    {
        return i(j);
    }
}
