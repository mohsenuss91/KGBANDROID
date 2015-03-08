// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public class Dips
{

    public Dips()
    {
    }

    public static float asFloatPixels(float f, Context context)
    {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int asIntPixels(float f, Context context)
    {
        return (int)(0.5F + asFloatPixels(f, context));
    }
}
