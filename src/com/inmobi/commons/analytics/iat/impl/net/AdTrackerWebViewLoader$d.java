// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerWebViewLoader

class a
    implements Runnable
{

    final AdTrackerWebViewLoader a;

    public void run()
    {
        AdTrackerWebViewLoader.a(new AtomicBoolean(false));
        AdTrackerWebViewLoader.a(new WebView(InternalSDKUtil.getContext()));
        AdTrackerWebViewLoader.a().setWebViewClient(new WebViewClient(a));
        AdTrackerWebViewLoader.a().getSettings().setJavaScriptEnabled(true);
        AdTrackerWebViewLoader.a().getSettings().setCacheMode(2);
        AdTrackerWebViewLoader.a().addJavascriptInterface(new Interface(), "iatsdk");
    }

    Interface(AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        a = adtrackerwebviewloader;
        super();
    }
}
