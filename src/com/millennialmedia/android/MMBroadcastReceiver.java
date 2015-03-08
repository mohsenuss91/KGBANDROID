// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

// Referenced classes of package com.millennialmedia.android:
//            MMAdImplController, MMAdImpl, MMAd

public class MMBroadcastReceiver extends BroadcastReceiver
{

    public static final String ACTION_DISPLAY_STARTED = "millennialmedia.action.ACTION_DISPLAY_STARTED";
    public static final String ACTION_FETCH_FAILED = "millennialmedia.action.ACTION_FETCH_FAILED";
    public static final String ACTION_FETCH_STARTED_CACHING = "millennialmedia.action.ACTION_FETCH_STARTED_CACHING";
    public static final String ACTION_FETCH_SUCCEEDED = "millennialmedia.action.ACTION_FETCH_SUCCEEDED";
    public static final String ACTION_GETAD_FAILED = "millennialmedia.action.ACTION_GETAD_FAILED";
    public static final String ACTION_GETAD_SUCCEEDED = "millennialmedia.action.ACTION_GETAD_SUCCEEDED";
    public static final String ACTION_INTENT_STARTED = "millennialmedia.action.ACTION_INTENT_STARTED";
    public static final String ACTION_OVERLAY_CLOSED = "millennialmedia.action.ACTION_OVERLAY_CLOSED";
    public static final String ACTION_OVERLAY_OPENED = "millennialmedia.action.ACTION_OVERLAY_OPENED";
    public static final String ACTION_OVERLAY_TAP = "millennialmedia.action.ACTION_OVERLAY_TAP";
    public static final String CATEGORY_SDK = "millennialmedia.category.CATEGORY_SDK";

    public MMBroadcastReceiver()
    {
    }

    public static IntentFilter createIntentFilter()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addCategory("millennialmedia.category.CATEGORY_SDK");
        intentfilter.addAction("millennialmedia.action.ACTION_DISPLAY_STARTED");
        intentfilter.addAction("millennialmedia.action.ACTION_FETCH_FAILED");
        intentfilter.addAction("millennialmedia.action.ACTION_FETCH_SUCCEEDED");
        intentfilter.addAction("millennialmedia.action.ACTION_FETCH_STARTED_CACHING");
        intentfilter.addAction("millennialmedia.action.ACTION_GETAD_FAILED");
        intentfilter.addAction("millennialmedia.action.ACTION_GETAD_SUCCEEDED");
        intentfilter.addAction("millennialmedia.action.ACTION_INTENT_STARTED");
        intentfilter.addAction("millennialmedia.action.ACTION_OVERLAY_CLOSED");
        intentfilter.addAction("millennialmedia.action.ACTION_OVERLAY_OPENED");
        intentfilter.addAction("millennialmedia.action.ACTION_OVERLAY_TAP");
        return intentfilter;
    }

    public void displayStarted(MMAd mmad)
    {
        MMSDK.Log.i("Millennial Media display started.");
    }

    public void fetchFailure(MMAd mmad)
    {
        MMSDK.Log.i("Millennial Media fetch failed.");
    }

    public void fetchFinishedCaching(MMAd mmad)
    {
        MMSDK.Log.i("Millennial Media fetch finished caching.");
    }

    public void fetchStartedCaching(MMAd mmad)
    {
        MMSDK.Log.i("Millennial Media fetch started caching.");
    }

    public void getAdFailure(MMAd mmad)
    {
        MMSDK.Log.i("Millennial Media ad Failure.");
    }

    public void getAdSuccess(MMAd mmad)
    {
        MMSDK.Log.i("Millennial Media ad Success.");
    }

    public void intentStarted(MMAd mmad, String s)
    {
        if (s != null)
        {
            MMSDK.Log.i((new StringBuilder("Millennial Media started intent: ")).append(s).toString());
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getAction();
        String s1 = intent.getStringExtra("packageName");
        long l = intent.getLongExtra("internalId", -4L);
        if (context.getPackageName().equals(s1))
        {
            int i = l != -4L;
            MMAd mmad = null;
            if (i != 0)
            {
                MMAdImpl mmadimpl = MMAdImplController.getAdImplWithId(l);
                mmad = null;
                if (mmadimpl != null)
                {
                    mmad = mmadimpl.getCallingAd();
                }
            }
            StringBuilder stringbuilder = new StringBuilder(" @@ Intent - Ad in receiver = ");
            String s2;
            if (mmad == null)
            {
                s2 = " null";
            } else
            {
                s2 = mmad.toString();
            }
            MMSDK.Log.v(stringbuilder.append(s2).toString());
            if (s.equals("millennialmedia.action.ACTION_OVERLAY_OPENED"))
            {
                overlayOpened(mmad);
                return;
            }
            if (s.equals("millennialmedia.action.ACTION_OVERLAY_CLOSED"))
            {
                overlayClosed(mmad);
                return;
            }
            if (s.equals("millennialmedia.action.ACTION_OVERLAY_TAP"))
            {
                overlayTap(mmad);
                return;
            }
            if (s.equals("millennialmedia.action.ACTION_DISPLAY_STARTED"))
            {
                displayStarted(mmad);
                return;
            }
            if (s.equals("millennialmedia.action.ACTION_FETCH_FAILED"))
            {
                fetchFailure(mmad);
                return;
            }
            if (s.equals("millennialmedia.action.ACTION_FETCH_SUCCEEDED"))
            {
                fetchFinishedCaching(mmad);
                return;
            }
            if (s.equals("millennialmedia.action.ACTION_FETCH_STARTED_CACHING"))
            {
                fetchStartedCaching(mmad);
                return;
            }
            if (s.equals("millennialmedia.action.ACTION_GETAD_FAILED"))
            {
                getAdFailure(mmad);
                return;
            }
            if (s.equals("millennialmedia.action.ACTION_GETAD_SUCCEEDED"))
            {
                getAdSuccess(mmad);
                return;
            }
            if (s.equals("millennialmedia.action.ACTION_INTENT_STARTED"))
            {
                intentStarted(mmad, intent.getStringExtra("intentType"));
                return;
            }
        }
    }

    public void overlayClosed(MMAd mmad)
    {
        MMSDK.Log.i("Millennial Media overlay closed.");
    }

    public void overlayOpened(MMAd mmad)
    {
        MMSDK.Log.i("Millennial Media overlay opened.");
    }

    public void overlayTap(MMAd mmad)
    {
        MMSDK.Log.i("Millennial Media overlay Tap.");
    }
}
