// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;

public class lr
    implements Payments
{

    public lr()
    {
    }

    public void changeMaskedWallet(GoogleApiClient googleapiclient, String s, String s1, int i)
    {
        googleapiclient.a(new _cls4(s, s1, i));
    }

    public void checkForPreAuthorization(GoogleApiClient googleapiclient, int i)
    {
        googleapiclient.a(new _cls1(i));
    }

    public void loadFullWallet(GoogleApiClient googleapiclient, FullWalletRequest fullwalletrequest, int i)
    {
        googleapiclient.a(new _cls3(fullwalletrequest, i));
    }

    public void loadMaskedWallet(GoogleApiClient googleapiclient, MaskedWalletRequest maskedwalletrequest, int i)
    {
        googleapiclient.a(new _cls2(maskedwalletrequest, i));
    }

    public void notifyTransactionStatus(GoogleApiClient googleapiclient, NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        googleapiclient.a(new _cls5(notifytransactionstatusrequest));
    }

    private class _cls4 extends com.google.android.gms.wallet.Wallet.b
    {

        final int UA;
        final lr akD;
        final String akG;
        final String akH;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((ls)a1);
        }

        protected void a(ls ls1)
        {
            ls1.d(akG, akH, UA);
            b(Status.Ek);
        }

        _cls4(String s, String s1, int i)
        {
            akD = lr.this;
            akG = s;
            akH = s1;
            UA = i;
            super();
        }
    }


    private class _cls1 extends com.google.android.gms.wallet.Wallet.b
    {

        final int UA;
        final lr akD;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((ls)a1);
        }

        protected void a(ls ls1)
        {
            ls1.dQ(UA);
            b(Status.Ek);
        }

        _cls1(int i)
        {
            akD = lr.this;
            UA = i;
            super();
        }
    }


    private class _cls3 extends com.google.android.gms.wallet.Wallet.b
    {

        final int UA;
        final lr akD;
        final FullWalletRequest akF;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((ls)a1);
        }

        protected void a(ls ls1)
        {
            ls1.a(akF, UA);
            b(Status.Ek);
        }

        _cls3(FullWalletRequest fullwalletrequest, int i)
        {
            akD = lr.this;
            akF = fullwalletrequest;
            UA = i;
            super();
        }
    }


    private class _cls2 extends com.google.android.gms.wallet.Wallet.b
    {

        final int UA;
        final lr akD;
        final MaskedWalletRequest akE;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((ls)a1);
        }

        protected void a(ls ls1)
        {
            ls1.a(akE, UA);
            b(Status.Ek);
        }

        _cls2(MaskedWalletRequest maskedwalletrequest, int i)
        {
            akD = lr.this;
            akE = maskedwalletrequest;
            UA = i;
            super();
        }
    }


    private class _cls5 extends com.google.android.gms.wallet.Wallet.b
    {

        final lr akD;
        final NotifyTransactionStatusRequest akI;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((ls)a1);
        }

        protected void a(ls ls1)
        {
            ls1.a(akI);
            b(Status.Ek);
        }

        _cls5(NotifyTransactionStatusRequest notifytransactionstatusrequest)
        {
            akD = lr.this;
            akI = notifytransactionstatusrequest;
            super();
        }
    }

}
