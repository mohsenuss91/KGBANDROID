// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.net;

import android.content.Context;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.IMAIConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.impl.imai.IMAIClickEventList;
import com.inmobi.androidsdk.impl.imai.db.ClickData;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.androidsdk.impl.net:
//            RequestResponseManager, HttpRequestCallback

class b
    implements Runnable
{

    final Context a;
    final HttpRequestCallback b;
    final RequestResponseManager c;

    public void run()
    {
_L10:
        if (RequestResponseManager.isSynced.get())
        {
            break MISSING_BLOCK_LABEL_647;
        }
        RequestResponseManager.isSynced.set(true);
        if (RequestResponseManager.mNetworkQueue != null && !RequestResponseManager.mNetworkQueue.isEmpty())
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (RequestResponseManager.mDBWriterQueue == null && RequestResponseManager.mDBWriterQueue.isEmpty())
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Click event list empty");
            c.deinit();
            return;
        }
        RequestResponseManager.mNetworkQueue.addAll(RequestResponseManager.mDBWriterQueue);
        RequestResponseManager.mDBWriterQueue.clear();
_L5:
        ClickData clickdata;
        String s;
        int i;
        boolean flag;
        boolean flag1;
        int j;
        if (RequestResponseManager.mNetworkQueue.isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        clickdata = (ClickData)RequestResponseManager.mNetworkQueue.remove(0);
        s = clickdata.getClickUrl();
        i = clickdata.getRetryCount();
        flag = clickdata.isPingWv();
        flag1 = clickdata.isFollowRedirects();
        j = Initializer.getConfigParams().getImai().getRetryInterval();
        if (InternalSDKUtil.checkNetworkAvailibility(a))
        {
            break MISSING_BLOCK_LABEL_222;
        }
        Log.internal("[InMobi]-[Network]-4.4.1", "Cannot process click. Network Not available");
        if (i <= 1)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        RequestResponseManager.mDBWriterQueue.add(clickdata);
        Exception exception;
        Exception exception1;
        if (b != null)
        {
            b.notifyResult(1, null);
        }
        c.deinit();
        return;
        int k = Initializer.getConfigParams().getImai().getMaxRetry();
        if (RequestResponseManager.a().get() || i >= k)
        {
            break MISSING_BLOCK_LABEL_299;
        }
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Retrying to ping in background after ")).append(j / 1000).append(" secs").toString());
        Thread thread = RequestResponseManager.a;
        thread;
        JVM INSTR monitorenter ;
        RequestResponseManager.a.wait(j);
_L6:
        try
        {
            Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Processing click in background: ")).append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception1)
        {
            try
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Exception pinging click in background", exception1);
                c.deinit();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Exception ping to server ", exception);
            }
            return;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (!c.processClickUrlInWebview(s)) goto _L4; else goto _L3
_L3:
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Ping in webview successful: ")).append(s).toString());
        if (b != null)
        {
            b.notifyResult(0, null);
        }
_L7:
        if (RequestResponseManager.mDBWriterQueue.size() > Initializer.getConfigParams().getImai().getmDefaultEventsBatch())
        {
            RequestResponseManager.mDBWriterQueue.saveClickEvents();
            RequestResponseManager.mDBWriterQueue.clear();
        }
          goto _L5
        InterruptedException interruptedexception;
        interruptedexception;
        Log.internal("[InMobi]-[Network]-4.4.1", "Network thread wait failure", interruptedexception);
          goto _L6
        Exception exception2;
        exception2;
        thread;
        JVM INSTR monitorexit ;
        throw exception2;
_L4:
        clickdata.setRetryCount(i - 1);
        if (i <= 1)
        {
            break MISSING_BLOCK_LABEL_458;
        }
        RequestResponseManager.mDBWriterQueue.add(clickdata);
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Ping in webview failed: ")).append(s).toString());
        if (b != null)
        {
            b.notifyResult(1, null);
        }
          goto _L7
_L2:
label0:
        {
            if (!c.processClickHttpClient(s, flag1))
            {
                break label0;
            }
            Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Ping successful: ")).append(s).toString());
            if (b != null)
            {
                b.notifyResult(0, null);
            }
        }
          goto _L7
        clickdata.setRetryCount(i - 1);
        if (i <= 1)
        {
            break MISSING_BLOCK_LABEL_582;
        }
        RequestResponseManager.mDBWriterQueue.add(clickdata);
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Ping  failed: ")).append(s).toString());
        if (b != null)
        {
            b.notifyResult(1, null);
        }
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Ping failed: ")).append(s).toString());
          goto _L7
        c.deinit();
        return;
        if (true) goto _L5; else goto _L8
_L8:
        if (true) goto _L10; else goto _L9
_L9:
    }

    (RequestResponseManager requestresponsemanager, Context context, HttpRequestCallback httprequestcallback)
    {
        c = requestresponsemanager;
        a = context;
        b = httprequestcallback;
        super();
    }
}
