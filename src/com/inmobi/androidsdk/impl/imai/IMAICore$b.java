// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.imai;

import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.IMAIConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.impl.imai.db.ClickData;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.lang.ref.WeakReference;

// Referenced classes of package com.inmobi.androidsdk.impl.imai:
//            IMAIClickEventList

final class c
    implements Runnable
{

    final String a;
    final boolean b;
    final WeakReference c;

    public final void run()
    {
        try
        {
            int i = Initializer.getConfigParams().getImai().getMaxRetry();
            ClickData clickdata = new ClickData(a, b, true, i);
            RequestResponseManager requestresponsemanager = new RequestResponseManager();
            requestresponsemanager.init();
            RequestResponseManager.mNetworkQueue.add(0, clickdata);
            class a
                implements HttpRequestCallback
            {

                final IMAICore.b a;

                public void notifyResult(int j, Object obj)
                {
                    Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Got PING IN WEBVIEW callback. Status: ")).append(j).toString());
                    if (j == 0)
                    {
                        try
                        {
                            IMAICore.firePingInWebViewSuccessful(a.c, a.a);
                            return;
                        }
                        catch (Exception exception1)
                        {
                            Log.internal("[InMobi]-[Network]-4.4.1", "Exception", exception1);
                        }
                        break MISSING_BLOCK_LABEL_74;
                    }
                    IMAICore.fireErrorEvent(a.c, "IMAI Ping in webview failed", "pingInWebview", a.a);
                    return;
                }

            a()
            {
                a = IMAICore.b.this;
                super();
            }
            }

            requestresponsemanager.processClick(InternalSDKUtil.getContext(), new a());
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Exception ping in background", exception);
        }
    }

    a(String s, boolean flag, WeakReference weakreference)
    {
        a = s;
        b = flag;
        c = weakreference;
        super();
    }
}
