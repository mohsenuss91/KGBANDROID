// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.wifi;


// Referenced classes of package com.inmobi.commons.thinICE.wifi:
//            WifiScanner, WifiScanListener

final class b
    implements Runnable
{

    b()
    {
    }

    public final void run()
    {
        WifiScanListener wifiscanlistener = WifiScanner.a();
        WifiScanner.b();
        if (wifiscanlistener != null)
        {
            wifiscanlistener.onTimeout();
        }
    }
}
