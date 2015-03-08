// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.monetization:
//            IMBanner, IMErrorCode, IMBannerListener

class a
    implements Runnable
{

    final IMBanner a;

    public void run()
    {
        Log.debug("[InMobi]-[Network]-4.4.1", "AppId Not Set - Please call setAppId on the IMBanner object with a valid appId. For XML, please add \"appId\" attribute to the XML. Please refer integration guideline for more details.");
        if (IMBanner.a(a) != null)
        {
            IMBanner.a(a).onBannerRequestFailed(a, IMErrorCode.INVALID_REQUEST);
        }
        IMBanner.b(a);
    }

    tener(IMBanner imbanner)
    {
        a = imbanner;
        super();
    }
}
