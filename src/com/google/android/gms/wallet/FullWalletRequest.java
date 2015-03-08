// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            g, Cart

public final class FullWalletRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new g();
    String aiN;
    String aiO;
    Cart aiX;
    private final int xJ;

    FullWalletRequest()
    {
        xJ = 1;
    }

    FullWalletRequest(int i, String s, String s1, Cart cart)
    {
        xJ = i;
        aiN = s;
        aiO = s1;
        aiX = cart;
    }

    public static Builder newBuilder()
    {
        FullWalletRequest fullwalletrequest = new FullWalletRequest();
        fullwalletrequest.getClass();
        return fullwalletrequest. new Builder(null);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Cart getCart()
    {
        return aiX;
    }

    public final String getGoogleTransactionId()
    {
        return aiN;
    }

    public final String getMerchantTransactionId()
    {
        return aiO;
    }

    public final int getVersionCode()
    {
        return xJ;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        g.a(this, parcel, i);
    }


    private class Builder
    {

        final FullWalletRequest aiY;

        public final FullWalletRequest build()
        {
            return aiY;
        }

        public final Builder setCart(Cart cart)
        {
            aiY.aiX = cart;
            return this;
        }

        public final Builder setGoogleTransactionId(String s)
        {
            aiY.aiN = s;
            return this;
        }

        public final Builder setMerchantTransactionId(String s)
        {
            aiY.aiO = s;
            return this;
        }

        private Builder()
        {
            aiY = FullWalletRequest.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}
