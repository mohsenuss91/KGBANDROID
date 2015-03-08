// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.net;

import android.webkit.WebView;
import com.inmobi.commons.internal.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.androidsdk.impl.net:
//            WebviewLoader

class b
    implements Runnable
{

    final String a;
    final HashMap b;
    final WebviewLoader c;

    public void run()
    {
        try
        {
            WebviewLoader.b.set(true);
            WebviewLoader.a(c).loadUrl(a, b);
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Exception load in webview", exception);
        }
    }

    (WebviewLoader webviewloader, String s, HashMap hashmap)
    {
        c = webviewloader;
        a = s;
        b = hashmap;
        super();
    }
}
