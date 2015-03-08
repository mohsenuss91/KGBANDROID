// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.Map;

// Referenced classes of package com.google.analytics.tracking.android:
//            GAThread, GoogleAnalytics, GAUsage, MapBuilder, 
//            HitBuilder, ServiceProxy

class val.hitCopy
    implements Runnable
{

    final GAThread this$0;
    final Map val$hitCopy;

    public void run()
    {
        if (TextUtils.isEmpty((CharSequence)val$hitCopy.get("&cid")))
        {
            val$hitCopy.put("&cid", GAThread.access$000(GAThread.this));
        }
        if (GoogleAnalytics.getInstance(GAThread.access$100(GAThread.this)).getAppOptOut() || GAThread.access$200(GAThread.this, val$hitCopy))
        {
            return;
        }
        if (!TextUtils.isEmpty(GAThread.access$300(GAThread.this)))
        {
            GAUsage.getInstance().setDisableUsage(true);
            val$hitCopy.putAll((new MapBuilder()).setCampaignParamsFromUrl(GAThread.access$300(GAThread.this)).build());
            GAUsage.getInstance().setDisableUsage(false);
            GAThread.access$302(GAThread.this, null);
        }
        GAThread.access$400(GAThread.this, val$hitCopy);
        Map map = HitBuilder.generateHitParams(val$hitCopy);
        GAThread.access$700(GAThread.this).putHit(map, Long.valueOf((String)val$hitCopy.get("&ht")).longValue(), GAThread.access$500(GAThread.this, val$hitCopy), GAThread.access$600(GAThread.this));
    }

    y()
    {
        this$0 = final_gathread;
        val$hitCopy = Map.this;
        super();
    }
}
