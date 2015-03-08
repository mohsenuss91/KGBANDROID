// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            AdProperties, MMSDK, MMLayout

class this._cls0 extends AdProperties
{

    final MMLayout this$0;

    String getAdDpiIndependentHeight()
    {
        float f = MMSDK.getDensity(getContext());
        return String.valueOf((int)((float)getHeight() / f));
    }

    String getAdDpiIndependentWidth()
    {
        float f = MMSDK.getDensity(getContext());
        return String.valueOf((int)((float)getWidth() / f));
    }

    (Context context)
    {
        this$0 = MMLayout.this;
        super(context);
    }
}
