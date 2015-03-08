// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.app.Activity;
import android.view.View;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity

public class WebChromeClient extends android.webkit.WebChromeClient
{

    private RichMediaActivity mActivity;

    public WebChromeClient(Activity activity)
    {
        if (activity instanceof RichMediaActivity)
        {
            mActivity = (RichMediaActivity)activity;
        }
    }

    public void onHideCustomView()
    {
        Log.d("WebChromeClient onHideCustomView");
        if (mActivity == null)
        {
            super.onHideCustomView();
            return;
        } else
        {
            mActivity.onHideCustomView();
            return;
        }
    }

    public void onShowCustomView(View view, android.webkit.CustomViewCallback customviewcallback)
    {
        Log.d("WebChromeClient onShowCustomView");
        if (mActivity == null)
        {
            super.onShowCustomView(view, customviewcallback);
            return;
        } else
        {
            mActivity.onShowCustomView(view, customviewcallback);
            return;
        }
    }
}
