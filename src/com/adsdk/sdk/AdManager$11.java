// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;


// Referenced classes of package com.adsdk.sdk:
//            AdManager, AdListener, AdResponse

class val.ok
    implements Runnable
{

    final AdManager this$0;
    private final AdResponse val$ad;
    private final boolean val$ok;

    public void run()
    {
        AdManager.access$24(AdManager.this).adClosed(val$ad, val$ok);
    }

    ()
    {
        this$0 = final_admanager;
        val$ad = adresponse;
        val$ok = Z.this;
        super();
    }
}
