// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            WalletFragmentOptions, WalletFragmentStyle

public class b
    implements android.os.Parcelable.Creator
{

    public b()
    {
    }

    static void a(WalletFragmentOptions walletfragmentoptions, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.b.C(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, walletfragmentoptions.xJ);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 2, walletfragmentoptions.getEnvironment());
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 3, walletfragmentoptions.getTheme());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, walletfragmentoptions.getFragmentStyle(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 5, walletfragmentoptions.getMode());
        com.google.android.gms.common.internal.safeparcel.b.G(parcel, j);
    }

    public WalletFragmentOptions ch(Parcel parcel)
    {
        int i = 1;
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        WalletFragmentStyle walletfragmentstyle = null;
        int l = i;
        int i1 = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int j1 = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.ar(j1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, j1);
                    break;

                case 1: // '\001'
                    i1 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;

                case 2: // '\002'
                    l = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;

                case 3: // '\003'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;

                case 4: // '\004'
                    walletfragmentstyle = (WalletFragmentStyle)com.google.android.gms.common.internal.safeparcel.a.a(parcel, j1, WalletFragmentStyle.CREATOR);
                    break;

                case 5: // '\005'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new WalletFragmentOptions(i1, l, j, walletfragmentstyle, i);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return ch(parcel);
    }

    public WalletFragmentOptions[] dO(int i)
    {
        return new WalletFragmentOptions[i];
    }

    public Object[] newArray(int i)
    {
        return dO(i);
    }
}
