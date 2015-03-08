// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            InlineVideoView, MMLayout

class this._cls1
    implements android.view.iaController._cls1
{

    final is._cls0 this$1;

    public void onClick(View view)
    {
        MMLayout mmlayout = (MMLayout)mmLayoutRef.get();
        if (mmlayout == null) goto _L2; else goto _L1
_L1:
        tBackgroundColor(0xff000000);
        if (isPlaying())
        {
            inlineParams.ntPosition = getCurrentPosition();
        }
        if (!inlineParams.FullScreen) goto _L4; else goto _L3
_L3:
        inlineParams.FullScreen = false;
        if (inlineParams.nalOrientation != 1) goto _L6; else goto _L5
_L5:
        Activity activity1 = (Activity)tContext();
        if (activity1 != null)
        {
            activity1.setRequestedOrientation(1);
        }
_L2:
        return;
_L6:
        boolean flag1 = isPlaying();
        stopPlayback();
        mmlayout.repositionVideoLayout();
        InlineVideoView.access$500(_fld0, flag1);
        return;
_L4:
        inlineParams.nalOrientation = tContext().getResources().getConfiguration().orientation;
        inlineParams.FullScreen = true;
        if (inlineParams.nalOrientation != 2)
        {
            Activity activity = (Activity)tContext();
            if (activity != null)
            {
                activity.setRequestedOrientation(0);
                return;
            }
        } else
        {
            boolean flag = isPlaying();
            stopPlayback();
            mmlayout.fullScreenVideoLayout();
            InlineVideoView.access$500(_fld0, flag);
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
