// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.wallet:
//            Cart, LineItem

public final class <init>
{

    final Cart aiK;

    public final <init> addLineItem(LineItem lineitem)
    {
        aiK.aiJ.add(lineitem);
        return this;
    }

    public final Cart build()
    {
        return aiK;
    }

    public final aiK setCurrencyCode(String s)
    {
        aiK.aiI = s;
        return this;
    }

    public final aiK setLineItems(List list)
    {
        aiK.aiJ.clear();
        aiK.aiJ.addAll(list);
        return this;
    }

    public final aiK setTotalPrice(String s)
    {
        aiK.aiH = s;
        return this;
    }

    private (Cart cart)
    {
        aiK = cart;
        super();
    }

    aiK(Cart cart, aiK aik)
    {
        this(cart);
    }
}
