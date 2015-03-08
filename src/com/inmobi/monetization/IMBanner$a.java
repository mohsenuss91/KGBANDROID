// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.monetization:
//            IMBanner

class a extends Handler
{

    private final WeakReference a;

    public void handleMessage(Message message)
    {
        IMBanner imbanner = (IMBanner)a.get();
        if (imbanner != null)
        {
            switch (message.what)
            {
            default:
                return;

            case 100: // 'd'
                break;
            }
            if (IMBanner.e(imbanner) != -1)
            {
                if (!imbanner.d.hasWindowFocus())
                {
                    Log.debug("[InMobi]-[Network]-4.4.1", "Activity is not in the foreground. New ad will not be loaded.");
                    return;
                }
                if (MRAIDInterstitialController.isInterstitialDisplayed.get())
                {
                    Log.debug("[InMobi]-[Network]-4.4.1", "Ad cannot be loaded.Interstitial Ad is displayed.");
                    return;
                } else
                {
                    IMBanner.a(imbanner, false);
                    return;
                }
            }
        }
    }

    public oolean(IMBanner imbanner)
    {
        a = new WeakReference(imbanner);
    }
}
