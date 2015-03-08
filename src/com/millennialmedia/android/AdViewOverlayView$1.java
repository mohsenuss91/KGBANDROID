// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.View;

// Referenced classes of package com.millennialmedia.android:
//            AdViewOverlayView

class this._cls0
    implements android.view.
{

    final AdViewOverlayView this$0;

    public void onClick(View view)
    {
        com.millennialmedia.android.this._mth0("Close button clicked.");
        finishOverlayWithAnimation();
    }

    ()
    {
        this$0 = AdViewOverlayView.this;
        super();
    }
}
