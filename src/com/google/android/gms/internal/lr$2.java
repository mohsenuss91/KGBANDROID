// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.MaskedWalletRequest;

// Referenced classes of package com.google.android.gms.internal:
//            ls, lr

class b extends com.google.android.gms.wallet.t.b
{

    final int UA;
    final lr akD;
    final MaskedWalletRequest akE;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((ls));
    }

    protected void a(ls ls1)
    {
        ls1.a(akE, UA);
        b(Status.Ek);
    }

    alletRequest(lr lr, MaskedWalletRequest maskedwalletrequest, int i)
    {
        akD = lr;
        akE = maskedwalletrequest;
        UA = i;
        super();
    }
}
