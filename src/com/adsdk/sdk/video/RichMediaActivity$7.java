// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity, VideoData

class this._cls0
    implements android.view.
{

    final RichMediaActivity this$0;

    public void onClick(View view)
    {
        if (RichMediaActivity.access$1(RichMediaActivity.this).videoClickThrough == null) goto _L2; else goto _L1
_L1:
        if (RichMediaActivity.access$1(RichMediaActivity.this).videoClickTracking == null) goto _L4; else goto _L3
_L3:
        Iterator iterator = RichMediaActivity.access$1(RichMediaActivity.this).videoClickTracking.iterator();
_L7:
        if (iterator.hasNext()) goto _L5; else goto _L4
_L4:
        String s = RichMediaActivity.access$1(RichMediaActivity.this).videoClickThrough.trim();
        RichMediaActivity.access$3(RichMediaActivity.this);
        mOnVideoCanCloseEventListener.onTimeEvent(0);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        startActivity(intent);
_L2:
        return;
_L5:
        String s1 = (String)iterator.next();
        RichMediaActivity.access$2(RichMediaActivity.this, s1);
        if (true) goto _L7; else goto _L6
_L6:
    }

    ventListener()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
