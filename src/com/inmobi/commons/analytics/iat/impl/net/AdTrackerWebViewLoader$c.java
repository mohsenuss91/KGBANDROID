// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.webkit.WebView;
import com.inmobi.commons.internal.Log;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerWebViewLoader, AdTrackerNetworkInterface

class a
    implements Runnable
{

    final AdTrackerWebViewLoader a;

    public void run()
    {
        AdTrackerWebViewLoader.b(a, System.currentTimeMillis());
        AdTrackerWebViewLoader.b().set(true);
        Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Load Webview: ")).append(AdTrackerNetworkInterface.b()).toString());
        AdTrackerWebViewLoader.a().loadUrl(AdTrackerNetworkInterface.b());
    }

    (AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        a = adtrackerwebviewloader;
        super();
    }
}
