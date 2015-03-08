// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;


// Referenced classes of package com.google.android.gms.wallet:
//            FullWalletRequest, Cart

public final class <init>
{

    final FullWalletRequest aiY;

    public final FullWalletRequest build()
    {
        return aiY;
    }

    public final aiY setCart(Cart cart)
    {
        aiY.aiX = cart;
        return this;
    }

    public final aiY setGoogleTransactionId(String s)
    {
        aiY.aiN = s;
        return this;
    }

    public final aiY setMerchantTransactionId(String s)
    {
        aiY.aiO = s;
        return this;
    }

    private (FullWalletRequest fullwalletrequest)
    {
        aiY = fullwalletrequest;
        super();
    }

    aiY(FullWalletRequest fullwalletrequest, aiY aiy)
    {
        this(fullwalletrequest);
    }
}
