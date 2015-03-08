// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.internal.hn;

// Referenced classes of package com.google.android.gms.wallet:
//            k, Address, InstrumentInfo, OfferWalletObject, 
//            LoyaltyWalletObject

public final class MaskedWallet
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new k();
    String aiN;
    String aiO;
    String aiQ;
    Address aiR;
    Address aiS;
    String aiT[];
    UserAddress aiU;
    UserAddress aiV;
    InstrumentInfo aiW[];
    OfferWalletObject ajA[];
    LoyaltyWalletObject ajz[];
    private final int xJ;

    private MaskedWallet()
    {
        xJ = 2;
    }

    MaskedWallet(int i, String s, String s1, String as[], String s2, Address address, Address address1, 
            LoyaltyWalletObject aloyaltywalletobject[], OfferWalletObject aofferwalletobject[], UserAddress useraddress, UserAddress useraddress1, InstrumentInfo ainstrumentinfo[])
    {
        xJ = i;
        aiN = s;
        aiO = s1;
        aiT = as;
        aiQ = s2;
        aiR = address;
        aiS = address1;
        ajz = aloyaltywalletobject;
        ajA = aofferwalletobject;
        aiU = useraddress;
        aiV = useraddress1;
        aiW = ainstrumentinfo;
    }

    public static Builder nb()
    {
        MaskedWallet maskedwallet = new MaskedWallet();
        maskedwallet.getClass();
        return maskedwallet. new Builder(null);
    }

    public static Builder newBuilderFrom(MaskedWallet maskedwallet)
    {
        hn.f(maskedwallet);
        return nb().setGoogleTransactionId(maskedwallet.getGoogleTransactionId()).setMerchantTransactionId(maskedwallet.getMerchantTransactionId()).setPaymentDescriptions(maskedwallet.getPaymentDescriptions()).setInstrumentInfos(maskedwallet.getInstrumentInfos()).setEmail(maskedwallet.getEmail()).setLoyaltyWalletObjects(maskedwallet.getLoyaltyWalletObjects()).setOfferWalletObjects(maskedwallet.getOfferWalletObjects()).setBuyerBillingAddress(maskedwallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedwallet.getBuyerShippingAddress());
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Address getBillingAddress()
    {
        return aiR;
    }

    public final UserAddress getBuyerBillingAddress()
    {
        return aiU;
    }

    public final UserAddress getBuyerShippingAddress()
    {
        return aiV;
    }

    public final String getEmail()
    {
        return aiQ;
    }

    public final String getGoogleTransactionId()
    {
        return aiN;
    }

    public final InstrumentInfo[] getInstrumentInfos()
    {
        return aiW;
    }

    public final LoyaltyWalletObject[] getLoyaltyWalletObjects()
    {
        return ajz;
    }

    public final String getMerchantTransactionId()
    {
        return aiO;
    }

    public final OfferWalletObject[] getOfferWalletObjects()
    {
        return ajA;
    }

    public final String[] getPaymentDescriptions()
    {
        return aiT;
    }

    public final Address getShippingAddress()
    {
        return aiS;
    }

    public final int getVersionCode()
    {
        return xJ;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        k.a(this, parcel, i);
    }


    private class Builder
    {

        final MaskedWallet ajB;

        public final MaskedWallet build()
        {
            return ajB;
        }

        public final Builder setBillingAddress(Address address)
        {
            ajB.aiR = address;
            return this;
        }

        public final Builder setBuyerBillingAddress(UserAddress useraddress)
        {
            ajB.aiU = useraddress;
            return this;
        }

        public final Builder setBuyerShippingAddress(UserAddress useraddress)
        {
            ajB.aiV = useraddress;
            return this;
        }

        public final Builder setEmail(String s)
        {
            ajB.aiQ = s;
            return this;
        }

        public final Builder setGoogleTransactionId(String s)
        {
            ajB.aiN = s;
            return this;
        }

        public final Builder setInstrumentInfos(InstrumentInfo ainstrumentinfo[])
        {
            ajB.aiW = ainstrumentinfo;
            return this;
        }

        public final Builder setLoyaltyWalletObjects(LoyaltyWalletObject aloyaltywalletobject[])
        {
            ajB.ajz = aloyaltywalletobject;
            return this;
        }

        public final Builder setMerchantTransactionId(String s)
        {
            ajB.aiO = s;
            return this;
        }

        public final Builder setOfferWalletObjects(OfferWalletObject aofferwalletobject[])
        {
            ajB.ajA = aofferwalletobject;
            return this;
        }

        public final Builder setPaymentDescriptions(String as[])
        {
            ajB.aiT = as;
            return this;
        }

        public final Builder setShippingAddress(Address address)
        {
            ajB.aiS = address;
            return this;
        }

        private Builder()
        {
            ajB = MaskedWallet.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}
