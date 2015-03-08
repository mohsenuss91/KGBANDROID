// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.imai;

import com.inmobi.commons.InMobi;
import com.inmobi.commons.internal.ApiStatCollector;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import com.inmobi.re.container.IMWebView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.inmobi.androidsdk.impl.imai:
//            IMAICore

public class IMAIController
{

    public static final String IMAI_BRIDGE = "imaiController";
    private transient WeakReference a;

    public IMAIController(IMWebView imwebview)
    {
        IMAICore.initialize();
        a = new WeakReference(imwebview);
    }

    public String getPlatformVersion()
    {
        Log.debug("[InMobi]-[Network]-4.4.1", "get platform version");
        return Integer.toString(android.os.Build.VERSION.SDK_INT);
    }

    public String getSdkVersion()
    {
        Log.debug("[InMobi]-[Network]-4.4.1", "get sdk version");
        return InMobi.getVersion();
    }

    public void log(String s)
    {
        Log.debug("[InMobi]-[Network]-4.4.1", s);
    }

    public void openEmbedded(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(1001), null));
        try
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "IMAI open Embedded");
            if (!IMAICore.validateURL(s))
            {
                IMAICore.fireErrorEvent(a, "Null url passed", "openEmbedded", s);
                return;
            }
        }
        catch (Exception exception)
        {
            IMAICore.fireErrorEvent(a, exception.getMessage(), "openEmbedded", s);
            Log.internal("[InMobi]-[Network]-4.4.1", "IMAI openEmbedded failed", exception);
            return;
        }
        if (s.startsWith("http") || s.startsWith("https"))
        {
            IMAICore.launchEmbeddedBrowser(a, s);
            IMAICore.fireOpenEmbeddedSuccessful(a, s);
            return;
        }
        openExternal(s);
        return;
    }

    public void openExternal(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(1002), null));
        try
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "IMAI open external");
            if (!IMAICore.validateURL(s))
            {
                IMAICore.fireErrorEvent(a, "Null url passed", "openExternal", s);
                return;
            }
        }
        catch (Exception exception)
        {
            IMAICore.fireErrorEvent(a, exception.getMessage(), "openExternal", s);
            Log.internal("[InMobi]-[Network]-4.4.1", "IMAI openExternal failed", exception);
            return;
        }
        IMAICore.launchExternalApp(s);
        IMAICore.fireOpenExternalSuccessful(a, s);
        return;
    }

    public void ping(String s, boolean flag)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(1003), null));
        try
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "IMAI ping");
            if (!IMAICore.validateURL(s))
            {
                IMAICore.fireErrorEvent(a, "Null url passed", "ping", s);
                return;
            }
        }
        catch (Exception exception)
        {
            IMAICore.fireErrorEvent(a, exception.getMessage(), "ping", s);
            Log.internal("[InMobi]-[Network]-4.4.1", "IMAI ping failed", exception);
            return;
        }
        if (s.contains("http") || s.contains("https"))
        {
            IMAICore.ping(a, s, flag);
            return;
        }
        IMAICore.fireErrorEvent(a, "Invalid url passed", "ping", s);
        return;
    }

    public void pingInWebView(String s, boolean flag)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(1004), null));
        try
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "IMAI ping in webview");
            if (!IMAICore.validateURL(s))
            {
                IMAICore.fireErrorEvent(a, "Null url passed", "pingInWebView", s);
                return;
            }
        }
        catch (Exception exception)
        {
            IMAICore.fireErrorEvent(a, exception.getMessage(), "pingInWebView", s);
            Log.internal("[InMobi]-[Network]-4.4.1", "IMAI pingInWebView failed", exception);
            return;
        }
        if (s.contains("http") || s.contains("https"))
        {
            IMAICore.pingInWebview(a, s, flag);
            return;
        }
        IMAICore.fireErrorEvent(a, "Invalid url passed", "pingInWebView", s);
        return;
    }
}
