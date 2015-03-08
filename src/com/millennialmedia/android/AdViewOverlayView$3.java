// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.view.animation.Animation;
import android.widget.Button;

// Referenced classes of package com.millennialmedia.android:
//            AdViewOverlayView

class this._cls0
    implements android.view.animation.istener
{

    final AdViewOverlayView this$0;

    public void onAnimationEnd(Animation animation)
    {
        Activity activity = (Activity)getContext();
        tContext("Finishing overlay this is in w/ anim finishOverLayWithAnim()");
        attachWebViewToLink();
        activity.finish();
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        if (AdViewOverlayView.access$300(AdViewOverlayView.this) != null)
        {
            AdViewOverlayView.access$300(AdViewOverlayView.this).setVisibility(8);
        }
    }

    er()
    {
        this$0 = AdViewOverlayView.this;
        super();
    }
}
