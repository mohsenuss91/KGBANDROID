// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.graphics.drawable.Drawable;

// Referenced classes of package com.adsdk.sdk.video:
//            NavIcon

class le
    implements Runnable
{

    final estLayout this$1;
    private final Drawable val$image;

    public void run()
    {
        cess._mth0(this._cls1.this).setImageDrawable(val$image);
        cess._mth0(this._cls1.this).setVisibility(0);
        cess._mth0(this._cls1.this).requestLayout();
    }

    le()
    {
        this$1 = final_le;
        val$image = Drawable.this;
        super();
    }
}
