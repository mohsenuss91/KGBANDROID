// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.webkit.WebView;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerWebViewLoader

class a
    implements Runnable
{

    final AdTrackerWebViewLoader a;

    public void run()
    {
        if (AdTrackerWebViewLoader.a() != null)
        {
            AdTrackerWebViewLoader.a().stopLoading();
            AdTrackerWebViewLoader.a().destroy();
            AdTrackerWebViewLoader.a(null);
            AdTrackerWebViewLoader.b().set(false);
        }
    }

    (AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        a = adtrackerwebviewloader;
        super();
    }
}
