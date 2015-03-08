// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AspectRatioImageViewWidth extends ImageView
{

    public AspectRatioImageViewWidth(Context context)
    {
        super(context);
    }

    public AspectRatioImageViewWidth(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public AspectRatioImageViewWidth(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        setMeasuredDimension(android.view.View.MeasureSpec.getSize(i), android.view.View.MeasureSpec.getSize(j));
    }
}
