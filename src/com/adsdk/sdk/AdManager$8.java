// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;


// Referenced classes of package com.adsdk.sdk:
//            AdManager, AdListener, AdResponse

class val.ad
    implements Runnable
{

    final AdManager this$0;
    private final AdResponse val$ad;

    public void run()
    {
        AdManager.access$24(AdManager.this).adLoadSucceeded(val$ad);
    }

    ()
    {
        this$0 = final_admanager;
        val$ad = AdResponse.this;
        super();
    }
}
