// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;


// Referenced classes of package com.inmobi.monetization:
//            IMBanner, IMBannerListener, IMErrorCode

class a
    implements Runnable
{

    final IMErrorCode a;
    final IMBanner b;

    public void run()
    {
        if (IMBanner.a(b) != null)
        {
            IMBanner.a(b).onBannerRequestFailed(b, a);
        }
    }

    (IMBanner imbanner, IMErrorCode imerrorcode)
    {
        b = imbanner;
        a = imerrorcode;
        super();
    }
}
