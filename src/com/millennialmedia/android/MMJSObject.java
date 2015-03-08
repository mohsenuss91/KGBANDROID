// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.millennialmedia.android:
//            MMWebView, MMActivity, AdViewOverlayActivity, MMSDK, 
//            MMJSResponse

class MMJSObject
{

    protected WeakReference contextRef;
    protected WeakReference mmWebViewRef;

    MMJSObject()
    {
    }

    long getAdImplId(String s)
    {
        if (s != null)
        {
            return (long)Float.parseFloat(s);
        } else
        {
            return -4L;
        }
    }

    AdViewOverlayActivity getBaseActivity()
    {
        MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
        if (mmwebview != null)
        {
            android.app.Activity activity = mmwebview.getActivity();
            if (activity instanceof MMActivity)
            {
                MMBaseActivity mmbaseactivity = ((MMActivity)activity).getWrappedActivity();
                if (mmbaseactivity instanceof AdViewOverlayActivity)
                {
                    return (AdViewOverlayActivity)mmbaseactivity;
                }
            }
        }
        return null;
    }

    MMJSResponse runOnUiThreadFuture(Callable callable)
    {
        FutureTask futuretask;
        futuretask = new FutureTask(callable);
        MMSDK.runOnUiThread(futuretask);
        MMJSResponse mmjsresponse = (MMJSResponse)futuretask.get();
        return mmjsresponse;
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception.printStackTrace();
_L2:
        return null;
        ExecutionException executionexception;
        executionexception;
        executionexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    void setContext(Context context)
    {
        contextRef = new WeakReference(context);
    }

    void setMMWebView(MMWebView mmwebview)
    {
        mmWebViewRef = new WeakReference(mmwebview);
    }
}
