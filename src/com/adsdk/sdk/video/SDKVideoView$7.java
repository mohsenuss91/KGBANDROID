// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.view.SurfaceHolder;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.video:
//            SDKVideoView, MediaController

class this._cls0
    implements android.view.allback
{

    final SDKVideoView this$0;

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        Log.d("SDKVideoView surfaceChanged");
        SDKVideoView.access$14(SDKVideoView.this, j);
        SDKVideoView.access$15(SDKVideoView.this, k);
        SDKVideoView.access$6(SDKVideoView.this);
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        Log.d("Surface created");
        SDKVideoView.access$16(SDKVideoView.this, true);
        if (SDKVideoView.access$17(SDKVideoView.this))
        {
            SDKVideoView.access$18(SDKVideoView.this);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        Log.d("Surface destroyed");
        SDKVideoView.access$16(SDKVideoView.this, false);
        if (SDKVideoView.access$3(SDKVideoView.this) != null)
        {
            SDKVideoView.access$3(SDKVideoView.this).hide();
        }
        SDKVideoView.access$19(SDKVideoView.this, true);
    }

    ()
    {
        this$0 = SDKVideoView.this;
        super();
    }
}
