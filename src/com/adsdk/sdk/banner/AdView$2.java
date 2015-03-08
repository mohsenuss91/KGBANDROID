// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.banner:
//            AdView

class ver extends BroadcastReceiver
{

    final AdView this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (!intent.getAction().equals("android.intent.action.SCREEN_OFF")) goto _L2; else goto _L1
_L1:
        if (!mIsInForeground) goto _L4; else goto _L3
_L3:
        Log.d("ADSDK", "Screen sleep with ad in foreground, disable refresh");
        pause();
_L6:
        return;
_L4:
        Log.d("ADSDK", "Screen sleep but ad in background; refresh should already be disabled");
        return;
_L2:
        if (intent.getAction().equals("android.intent.action.USER_PRESENT"))
        {
            if (mIsInForeground)
            {
                resume();
                Log.d("ADSDK", "Screen wake / ad in foreground, reset refresh");
                return;
            } else
            {
                Log.d("ADSDK", "Screen wake but ad in background; don't enable refresh");
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    ver()
    {
        this$0 = AdView.this;
        super();
    }
}
