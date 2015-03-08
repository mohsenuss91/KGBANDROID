// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.widget.ImageView;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity, VideoData, ResourceManager

class this._cls0
    implements entListener
{

    final RichMediaActivity this$0;

    public void onTimeEvent(int i)
    {
        Log.d((new StringBuilder("###########CAN CLOSE VIDEO:")).append(i).toString());
        RichMediaActivity.access$11(RichMediaActivity.this, true);
        if (RichMediaActivity.access$12(RichMediaActivity.this).getVisibility() != 0 && RichMediaActivity.access$1(RichMediaActivity.this).showSkipButton && RichMediaActivity.access$12(RichMediaActivity.this) != null)
        {
            RichMediaActivity.access$12(RichMediaActivity.this).setImageDrawable(RichMediaActivity.access$13(RichMediaActivity.this).getResource(RichMediaActivity.this, -18));
            RichMediaActivity.access$12(RichMediaActivity.this).setVisibility(0);
        }
    }

    entListener()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
