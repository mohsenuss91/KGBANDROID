// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.wallet:
//            MaskedWalletRequest, Cart

public final class <init>
{

    final MaskedWalletRequest ajN;

    public final fication addAllowedCountrySpecificationForShipping(CountrySpecification countryspecification)
    {
        if (ajN.ajM == null)
        {
            ajN.ajM = new ArrayList();
        }
        ajN.ajM.add(countryspecification);
        return this;
    }

    public final ajN addAllowedCountrySpecificationsForShipping(Collection collection)
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

    public final ajN setAllowDebitCard(boolean flag)
    {
        ajN.ajL = flag;
        return this;
    }

    public final ajN setAllowPrepaidCard(boolean flag)
    {
        ajN.ajK = flag;
        return this;
    }

    public final ajN setCart(Cart cart)
    {
        ajN.aiX = cart;
        return this;
    }

    public final ajN setCurrencyCode(String s)
    {
        ajN.aiI = s;
        return this;
    }

    public final ajN setEstimatedTotalPrice(String s)
    {
        ajN.ajF = s;
        return this;
    }

    public final ajN setIsBillingAgreement(boolean flag)
    {
        ajN.ajI = flag;
        return this;
    }

    public final ajN setMerchantName(String s)
    {
        ajN.ajG = s;
        return this;
    }

    public final ajN setMerchantTransactionId(String s)
    {
        ajN.aiO = s;
        return this;
    }

    public final ajN setPhoneNumberRequired(boolean flag)
    {
        ajN.ajC = flag;
        return this;
    }

    public final ajN setShippingAddressRequired(boolean flag)
    {
        ajN.ajD = flag;
        return this;
    }

    public final ajN setShouldRetrieveWalletObjects(boolean flag)
    {
        ajN.ajH = flag;
        return this;
    }

    public final ajN setUseMinimalBillingAddress(boolean flag)
    {
        ajN.ajE = flag;
        return this;
    }

    private fication(MaskedWalletRequest maskedwalletrequest)
    {
        ajN = maskedwalletrequest;
        super();
    }

    ajN(MaskedWalletRequest maskedwalletrequest, ajN ajn)
    {
        this(maskedwalletrequest);
    }
}
