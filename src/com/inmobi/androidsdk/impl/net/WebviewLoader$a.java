// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.net;

import android.webkit.WebView;
import com.inmobi.commons.internal.Log;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.androidsdk.impl.net:
//            WebviewLoader

class a
    implements Runnable
{

    final WebviewLoader a;

    public void run()
    {
        try
        {
            if (WebviewLoader.a(a) != null)
            {
                WebviewLoader.b.set(false);
            }
            WebviewLoader.a(a).stopLoading();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Exception stop loading", exception);
        }
    }

    (WebviewLoader webviewloader)
    {
        a = webviewloader;
        super();
    }
}
