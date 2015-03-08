// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            b, WalletFragmentStyle

public final class WalletFragmentOptions
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new b();
    private int Hv;
    private int ajY;
    private WalletFragmentStyle akz;
    private int mTheme;
    final int xJ;

    private WalletFragmentOptions()
    {
        xJ = 1;
    }

    WalletFragmentOptions(int i, int j, int k, WalletFragmentStyle walletfragmentstyle, int l)
    {
        xJ = i;
        ajY = j;
        mTheme = k;
        akz = walletfragmentstyle;
        Hv = l;
    }

    static int a(WalletFragmentOptions walletfragmentoptions, int i)
    {
        walletfragmentoptions.ajY = i;
        return i;
    }

    public static WalletFragmentOptions a(Context context, AttributeSet attributeset)
    {
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.google.android.gms.R.styleable.WalletFragmentOptions);
        int i = typedarray.getInt(0, 0);
        int j = typedarray.getInt(1, 1);
        int k = typedarray.getResourceId(2, 0);
        int l = typedarray.getInt(3, 1);
        typedarray.recycle();
        WalletFragmentOptions walletfragmentoptions = new WalletFragmentOptions();
        walletfragmentoptions.mTheme = i;
        walletfragmentoptions.ajY = j;
        walletfragmentoptions.akz = (new WalletFragmentStyle()).setStyleResourceId(k);
        walletfragmentoptions.akz.N(context);
        walletfragmentoptions.Hv = l;
        return walletfragmentoptions;
    }

    static WalletFragmentStyle a(WalletFragmentOptions walletfragmentoptions, WalletFragmentStyle walletfragmentstyle)
    {
        walletfragmentoptions.akz = walletfragmentstyle;
        return walletfragmentstyle;
    }

    static int b(WalletFragmentOptions walletfragmentoptions, int i)
    {
        walletfragmentoptions.mTheme = i;
        return i;
    }

    static int c(WalletFragmentOptions walletfragmentoptions, int i)
    {
        walletfragmentoptions.Hv = i;
        return i;
    }

    public static Builder newBuilder()
    {
        WalletFragmentOptions walletfragmentoptions = new WalletFragmentOptions();
        walletfragmentoptions.getClass();
        return walletfragmentoptions. new Builder(null);
    }

    public final void N(Context context)
    {
        if (akz != null)
        {
            akz.N(context);
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    public final int getEnvironment()
    {
        return ajY;
    }

    public final WalletFragmentStyle getFragmentStyle()
    {
        return akz;
    }

    public final int getMode()
    {
        return Hv;
    }

    public final int getTheme()
    {
        return mTheme;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.wallet.fragment.b.a(this, parcel, i);
    }


    private class Builder
    {

        final WalletFragmentOptions akA;

        public final WalletFragmentOptions build()
        {
            return akA;
        }

        public final Builder setEnvironment(int i)
        {
            WalletFragmentOptions.a(akA, i);
            return this;
        }

        public final Builder setFragmentStyle(int i)
        {
            WalletFragmentOptions.a(akA, (new WalletFragmentStyle()).setStyleResourceId(i));
            return this;
        }

        public final Builder setFragmentStyle(WalletFragmentStyle walletfragmentstyle)
        {
            WalletFragmentOptions.a(akA, walletfragmentstyle);
            return this;
        }

        public final Builder setMode(int i)
        {
            WalletFragmentOptions.c(akA, i);
            return this;
        }

        public final Builder setTheme(int i)
        {
            WalletFragmentOptions.b(akA, i);
            return this;
        }

        private Builder()
        {
            akA = WalletFragmentOptions.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}
