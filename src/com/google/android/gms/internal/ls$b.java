// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;

// Referenced classes of package com.google.android.gms.internal:
//            ls, hn

final class FT extends FT
{

    private final int FT;
    final ls akJ;

    public final void a(int j, FullWallet fullwallet, Bundle bundle)
    {
        PendingIntent pendingintent = null;
        if (bundle != null)
        {
            pendingintent = (PendingIntent)bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
        }
        ConnectionResult connectionresult = new ConnectionResult(j, pendingintent);
        if (connectionresult.hasResolution())
        {
            try
            {
                connectionresult.startResolutionForResult(ls.b(akJ), FT);
                return;
            }
            catch (android.content.tSender.SendIntentException sendintentexception)
            {
                Log.w("WalletClientImpl", "Exception starting pending intent", sendintentexception);
            }
            return;
        }
        Intent intent = new Intent();
        byte byte0;
        PendingIntent pendingintent1;
        if (connectionresult.isSuccess())
        {
            byte0 = -1;
            intent.putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", fullwallet);
        } else
        {
            if (j == 408)
            {
                byte0 = 0;
            } else
            {
                byte0 = 1;
            }
            intent.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", j);
        }
        pendingintent1 = ls.b(akJ).createPendingResult(FT, intent, 0x40000000);
        if (pendingintent1 == null)
        {
            Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
            return;
        }
        try
        {
            pendingintent1.send(byte0);
            return;
        }
        catch (android.app.ngIntent.CanceledException canceledexception)
        {
            Log.w("WalletClientImpl", "Exception setting pending result", canceledexception);
        }
    }

    public final void a(int j, MaskedWallet maskedwallet, Bundle bundle)
    {
        PendingIntent pendingintent = null;
        if (bundle != null)
        {
            pendingintent = (PendingIntent)bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
        }
        ConnectionResult connectionresult = new ConnectionResult(j, pendingintent);
        if (connectionresult.hasResolution())
        {
            try
            {
                connectionresult.startResolutionForResult(ls.b(akJ), FT);
                return;
            }
            catch (android.content.tSender.SendIntentException sendintentexception)
            {
                Log.w("WalletClientImpl", "Exception starting pending intent", sendintentexception);
            }
            return;
        }
        Intent intent = new Intent();
        byte byte0;
        PendingIntent pendingintent1;
        if (connectionresult.isSuccess())
        {
            byte0 = -1;
            intent.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", maskedwallet);
        } else
        {
            if (j == 408)
            {
                byte0 = 0;
            } else
            {
                byte0 = 1;
            }
            intent.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", j);
        }
        pendingintent1 = ls.b(akJ).createPendingResult(FT, intent, 0x40000000);
        if (pendingintent1 == null)
        {
            Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
            return;
        }
        try
        {
            pendingintent1.send(byte0);
            return;
        }
        catch (android.app.ngIntent.CanceledException canceledexception)
        {
            Log.w("WalletClientImpl", "Exception setting pending result", canceledexception);
        }
    }

    public final void a(int j, boolean flag, Bundle bundle)
    {
        Intent intent = new Intent();
        intent.putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", flag);
        PendingIntent pendingintent = ls.b(akJ).createPendingResult(FT, intent, 0x40000000);
        if (pendingintent == null)
        {
            Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
            return;
        }
        try
        {
            pendingintent.send(-1);
            return;
        }
        catch (android.app.ngIntent.CanceledException canceledexception)
        {
            Log.w("WalletClientImpl", "Exception setting pending result", canceledexception);
        }
    }

    public final void i(int j, Bundle bundle)
    {
        hn.b(bundle, "Bundle should not be null");
        ConnectionResult connectionresult = new ConnectionResult(j, (PendingIntent)bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
        if (connectionresult.hasResolution())
        {
            try
            {
                connectionresult.startResolutionForResult(ls.b(akJ), FT);
                return;
            }
            catch (android.content.tSender.SendIntentException sendintentexception)
            {
                Log.w("WalletClientImpl", "Exception starting pending intent", sendintentexception);
            }
            return;
        }
        Log.e("WalletClientImpl", (new StringBuilder("Create Wallet Objects confirmation UI will not be shown connection result: ")).append(connectionresult).toString());
        Intent intent = new Intent();
        intent.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 413);
        PendingIntent pendingintent = ls.b(akJ).createPendingResult(FT, intent, 0x40000000);
        if (pendingintent == null)
        {
            Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
            return;
        }
        try
        {
            pendingintent.send(1);
            return;
        }
        catch (android.app.ngIntent.CanceledException canceledexception)
        {
            Log.w("WalletClientImpl", "Exception setting pending result", canceledexception);
        }
    }

    public eption(ls ls1, int j)
    {
        akJ = ls1;
        super(null);
        FT = j;
    }
}
