// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnResourceIdSetResponse

public class ao
    implements android.os.Parcelable.Creator
{

    public ao()
    {
    }

    static void a(OnResourceIdSetResponse onresourceidsetresponse, Parcel parcel, int i)
    {
        int j = b.C(parcel);
        b.c(parcel, 1, onresourceidsetresponse.getVersionCode());
        b.a(parcel, 2, onresourceidsetresponse.gj(), false);
        b.G(parcel, j);
    }

    public OnResourceIdSetResponse ap(Parcel parcel)
    {
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.B(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != i)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(i).toString(), parcel);
            } else
            {
                return new OnResourceIdSetResponse(j, arraylist);
            }
        } while (true);
    }

    public OnResourceIdSetResponse[] bl(int i)
    {
        return new OnResourceIdSetResponse[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return ap(parcel);
    }

    public Object[] newArray(int i)
    {
        return bl(i);
    }
}
