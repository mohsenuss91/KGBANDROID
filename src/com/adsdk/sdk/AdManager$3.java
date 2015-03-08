// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;

import com.adsdk.sdk.video.ResourceManager;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.adsdk.sdk:
//            Log, RequestGeneralAd, AdManager, AdResponse

class val.xml
    implements Runnable
{

    final AdManager this$0;
    private final InputStream val$xml;

    public void run()
    {
_L11:
        if (ResourceManager.isDownloading()) goto _L2; else goto _L1
_L1:
        Log.d("starting request thread");
        RequestGeneralAd requestgeneralad = new RequestGeneralAd(val$xml);
        if (!AdManager.access$0(AdManager.this) || AdManager.access$1(AdManager.this)) goto _L4; else goto _L3
_L3:
        AdManager.access$4(AdManager.this, AdManager.access$3(AdManager.this));
_L12:
        AdManager.access$13(AdManager.this, (AdResponse)requestgeneralad.sendRequest(AdManager.access$12(AdManager.this)));
        if (AdManager.access$14(AdManager.this).getType() != 2 || !AdManager.access$14(AdManager.this).getCustomEvents().isEmpty()) goto _L6; else goto _L5
_L5:
        if (!AdManager.access$6(AdManager.this) || AdManager.access$7(AdManager.this)) goto _L8; else goto _L7
_L7:
        AdManager.access$4(AdManager.this, AdManager.access$8(AdManager.this));
        AdManager.access$9(AdManager.this, true);
        AdManager.access$13(AdManager.this, (AdResponse)requestgeneralad.sendRequest(AdManager.access$12(AdManager.this)));
_L6:
        if (AdManager.access$14(AdManager.this).getType() == 2 || !AdManager.access$14(AdManager.this).getCustomEvents().isEmpty()) goto _L10; else goto _L9
_L9:
        Log.d("response OK received");
        AdManager.access$15(AdManager.this, AdManager.access$14(AdManager.this));
_L13:
        Log.d("finishing ad request thread");
        AdManager.access$11(AdManager.this, null);
        return;
_L2:
        try
        {
            Thread.sleep(200L);
        }
        catch (InterruptedException interruptedexception) { }
          goto _L11
_L4:
        Throwable throwable;
label0:
        {
            if (!AdManager.access$6(AdManager.this))
            {
                break label0;
            }
            AdManager.access$4(AdManager.this, AdManager.access$8(AdManager.this));
        }
          goto _L12
        try
        {
            Log.d("Both video and interstitial ads disabled");
            AdManager.access$10(AdManager.this);
            AdManager.access$11(AdManager.this, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            AdManager.access$13(AdManager.this, new AdResponse());
            AdManager.access$14(AdManager.this).setType(-1);
            AdManager.access$10(AdManager.this);
        }
          goto _L13
_L8:
        if (!AdManager.access$0(AdManager.this) || AdManager.access$2(AdManager.this)) goto _L6; else goto _L14
_L14:
        AdManager.access$4(AdManager.this, AdManager.access$3(AdManager.this));
        AdManager.access$5(AdManager.this, true);
        AdManager.access$13(AdManager.this, (AdResponse)requestgeneralad.sendRequest(AdManager.access$12(AdManager.this)));
          goto _L6
_L10:
label1:
        {
            if (!AdManager.access$14(AdManager.this).getCustomEvents().isEmpty())
            {
                break label1;
            }
            Log.d("response NO AD received");
            AdManager.access$10(AdManager.this);
        }
          goto _L13
        AdManager.access$16(AdManager.this);
        if (AdManager.access$17(AdManager.this) == null)
        {
            AdManager.access$14(AdManager.this).getCustomEvents().clear();
            AdManager.access$10(AdManager.this);
        }
          goto _L13
    }

    tion()
    {
        this$0 = final_admanager;
        val$xml = InputStream.this;
        super();
    }
}
