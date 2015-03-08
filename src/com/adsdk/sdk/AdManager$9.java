// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;


// Referenced classes of package com.adsdk.sdk:
//            AdManager, AdListener

class this._cls0
    implements Runnable
{

    final AdManager this$0;

    public void run()
    {
        AdManager.access$24(AdManager.this).adClicked();
    }

    ()
    {
        this$0 = AdManager.this;
        super();
    }
}
