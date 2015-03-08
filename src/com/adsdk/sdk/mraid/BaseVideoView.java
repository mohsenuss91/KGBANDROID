// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.Context;
import android.widget.VideoView;

abstract class BaseVideoView extends VideoView
{

    public BaseVideoView(Context context)
    {
        super(context);
    }

    void onPause()
    {
    }

    void onResume()
    {
    }
}
