// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;


// Referenced classes of package com.inmobi.monetization:
//            IMBanner, IMErrorCode, IMBannerListener

class a
    implements Runnable
{

    final IMBanner a;

    public void run()
    {
        if (IMBanner.a(a) != null)
        {
            IMBanner.a(a).onBannerRequestFailed(a, IMErrorCode.DO_MONETIZE);
        }
    }

    tener(IMBanner imbanner)
    {
        a = imbanner;
        super();
    }
}
