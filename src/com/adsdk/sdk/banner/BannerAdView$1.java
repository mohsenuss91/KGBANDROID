// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.WebView;

// Referenced classes of package com.adsdk.sdk.banner:
//            BannerAdView

class this._cls0 extends WebView
{

    final BannerAdView this$0;

    public void draw(Canvas canvas)
    {
        if (getWidth() > 0 && getHeight() > 0)
        {
            super.draw(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        BannerAdView.access$0(BannerAdView.this, true);
        return super.onTouchEvent(motionevent);
    }

    (Context context)
    {
        this$0 = BannerAdView.this;
        super(context);
    }
}
