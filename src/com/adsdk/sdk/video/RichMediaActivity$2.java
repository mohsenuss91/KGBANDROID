// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity, VideoData, MediaController

class this._cls0
    implements android.view.
{

    final RichMediaActivity this$0;

    public void onClick(View view)
    {
        if (RichMediaActivity.access$1(RichMediaActivity.this).overlayClickThrough != null)
        {
            if (RichMediaActivity.access$1(RichMediaActivity.this).overlayClickTracking != null)
            {
                RichMediaActivity.access$2(RichMediaActivity.this, RichMediaActivity.access$1(RichMediaActivity.this).overlayClickTracking);
            }
            String s = RichMediaActivity.access$1(RichMediaActivity.this).overlayClickThrough.trim();
            RichMediaActivity.access$3(RichMediaActivity.this);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
            startActivity(intent);
        }
        Log.d("ADSDK", "RichMediaActivity mOverlayClickListener");
        if (RichMediaActivity.access$4(RichMediaActivity.this) != null)
        {
            RichMediaActivity.access$4(RichMediaActivity.this).toggle();
        }
    }

    ()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
