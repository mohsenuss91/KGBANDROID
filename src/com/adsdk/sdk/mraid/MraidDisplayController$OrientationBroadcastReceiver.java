// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidDisplayController

class this._cls0 extends BroadcastReceiver
{

    private Context mContext;
    private int mLastRotation;
    final MraidDisplayController this$0;

    private boolean isRegistered()
    {
        return mContext != null;
    }

    public void onReceive(Context context, Intent intent)
    {
        if (isRegistered() && intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"))
        {
            int i = MraidDisplayController.access$3(MraidDisplayController.this);
            if (i != mLastRotation)
            {
                mLastRotation = i;
                MraidDisplayController.access$4(MraidDisplayController.this, mLastRotation);
                return;
            }
        }
    }

    public void register(Context context)
    {
        mContext = context;
        context.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
    }

    public void unregister()
    {
        mContext.unregisterReceiver(this);
        mContext = null;
    }

    ()
    {
        this$0 = MraidDisplayController.this;
        super();
    }
}
