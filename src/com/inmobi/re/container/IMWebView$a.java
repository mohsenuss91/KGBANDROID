// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.re.container:
//            IMWebView

class a
    implements Runnable
{

    final IMWebView a;

    public void run()
    {
        try
        {
            a.injectJavaScript("window.mraid.broadcastEvent('vibrateComplete')");
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "Exception giviing vibration complete callback", exception);
        }
    }

    (IMWebView imwebview)
    {
        a = imwebview;
        super();
    }
}
