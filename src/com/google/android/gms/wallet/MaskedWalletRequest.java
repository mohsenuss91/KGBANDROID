// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.wallet:
//            l, Cart, CountrySpecification

public final class MaskedWalletRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new l();
    String aiI;
    String aiO;
    Cart aiX;
    boolean ajC;
    boolean ajD;
    boolean ajE;
    String ajF;
    String ajG;
    boolean ajH;
    boolean ajI;
    com.google.android.gms.wallet.CountrySpecification ajJ[];
    boolean ajK;
    boolean ajL;
    ArrayList ajM;
    private final int xJ;

    MaskedWalletRequest()
    {
        xJ = 3;
        ajK = true;
        ajL = true;
    }

    MaskedWalletRequest(int i, String s, boolean flag, boolean flag1, boolean flag2, String s1, String s2, 
            String s3, Cart cart, boolean flag3, boolean flag4, CountrySpecification acountryspecification[], boolean flag5, boolean flag6, 
            ArrayList arraylist)
    {
        xJ = i;
        aiO = s;
        ajC = flag;
        ajD = flag1;
        ajE = flag2;
        ajF = s1;
        aiI = s2;
        ajG = s3;
        aiX = cart;
        ajH = flag3;
        ajI = flag4;
        ajJ = acountryspecification;
        ajK = flag5;
        ajL = flag6;
        ajM = arraylist;
    }

    public static Builder newBuilder()
    {
        MaskedWalletRequest maskedwalletrequest = new MaskedWalletRequest();
        maskedwalletrequest.getClass();
        return maskedwalletrequest. new Builder(null);
    }

    public final boolean allowDebitCard()
    {
        return ajL;
    }

    public final boolean allowPrepaidCard()
    {
        return ajK;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final ArrayList getAllowedCountrySpecificationsForShipping()
    {
        return ajM;
    }

    public final com.google.android.gms.wallet.CountrySpecification[] getAllowedShippingCountrySpecifications()
    {
        return ajJ;
    }

    public final Cart getCart()
    {
        return aiX;
    }

    public final String getCurrencyCode()
    {
        return aiI;
    }

    public final String getEstimatedTotalPrice()
    {
        return ajF;
    }

    public final String getMerchantName()
    {
        return ajG;
    }

    public final String getMerchantTransactionId()
    {
        return aiO;
    }

    public final int getVersionCode()
    {
        return xJ;
    }

    public final boolean isBillingAgreement()
    {
        return ajI;
    }

    public final boolean isPhoneNumberRequired()
    {
        return ajC;
    }

    public final boolean isShippingAddressRequired()
    {
        return ajD;
    }

    public final boolean shouldRetrieveWalletObjects()
    {
        return ajH;
    }

    public final boolean useMinimalBillingAddress()
    {
        return ajE;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        l.a(this, parcel, i);
    }


    private class Builder
    {

        final MaskedWalletRequest ajN;

        public final Builder addAllowedCountrySpecificationForShipping(CountrySpecification countryspecification)
        {
            if (ajN.ajM == null)
            {
                ajN.ajM = new ArrayList();
            }
            ajN.ajM.add(countryspecification);
            return this;
        }

        public final Builder addAllowedCountrySpecificationsForShipping(Collection collection)
        {
            if (collection != null)
            {
                if (ajN.ajM == null)
                {
                    ajN.ajM = new ArrayList();
                }
                ajN.ajM.addAll(collection);
            }
            return this;
        }

        public final MaskedWalletRequest build()
        {
            return ajN;
        }

        public final Builder setAllowDebitCard(boolean flag)
        {
            ajN.ajL = flag;
            return this;
        }

        public final Builder setAllowPrepaidCard(boolean flag)
        {
            ajN.ajK = flag;
            return this;
        }

        public final Builder setCart(Cart cart)
        {
            ajN.aiX = cart;
            return this;
        }

        public final Builder setCurrencyCode(String s)
        {
            ajN.aiI = s;
            return this;
        }

        public final Builder setEstimatedTotalPrice(String s)
        {
            ajN.ajF = s;
            return this;
        }

        public final Builder setIsBillingAgreement(boolean flag)
        {
            ajN.ajI = flag;
            return this;
        }

        public final Builder setMerchantName(String s)
        {
            ajN.ajG = s;
            return this;
        }

        public final Builder setMerchantTransactionId(String s)
        {
            ajN.aiO = s;
            return this;
        }

        public final Builder setPhoneNumberRequired(boolean flag)
        {
            ajN.ajC = flag;
            return this;
        }

        public final Builder setShippingAddressRequired(boolean flag)
        {
            ajN.ajD = flag;
            return this;
        }

        public final Builder setShouldRetrieveWalletObjects(boolean flag)
        {
            ajN.ajH = flag;
            return this;
        }

        public final Builder setUseMinimalBillingAddress(boolean flag)
        {
            ajN.ajE = flag;
            return this;
        }

        private Builder()
        {
            ajN = MaskedWalletRequest.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}
