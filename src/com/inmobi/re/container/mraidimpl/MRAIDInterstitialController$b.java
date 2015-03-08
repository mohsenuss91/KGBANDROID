// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.view.KeyEvent;
import android.view.View;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDInterstitialController

class a
    implements android.view.rstitialController.b
{

    final MRAIDInterstitialController a;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        int j = keyevent.getKeyCode();
        boolean flag = false;
        if (4 == j)
        {
            int k = keyevent.getAction();
            flag = false;
            if (k == 0)
            {
                Log.debug("[InMobi]-[RE]-4.4.1", "Back Button pressed while Interstitial ad is in active state ");
                a.handleInterstitialClose();
                int l = MRAIDInterstitialController.b(a) != 0L;
                flag = false;
                if (l > 0)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    (MRAIDInterstitialController mraidinterstitialcontroller)
    {
        a = mraidinterstitialcontroller;
        super();
    }
}
