// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;

// Referenced classes of package com.inmobi.monetization.internal:
//            TrackerView

class a extends WebViewClient
{

    final TrackerView a;

    a(TrackerView trackerview)
    {
        a = trackerview;
        super();
    }

    public void onPageFinished(WebView webview, String s)
    {
        Log.internal("[InMobi]-[Monetization]", "Native ad context code loaded");
        TrackerView.a(a, true);
        if (TrackerView.a(a) != null && !TrackerView.a(a).isEmpty())
        {
            for (int i = 0; i < TrackerView.a(a).size(); i++)
            {
                a.injectJavaScript((String)TrackerView.a(a).get(i));
            }

            TrackerView.a(a).clear();
            TrackerView.a(a, null);
        }
    }
}
