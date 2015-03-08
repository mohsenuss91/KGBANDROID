// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.media.MediaPlayer;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity

class this._cls0
    implements android.media.ionListener
{

    final RichMediaActivity this$0;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        Log.d(" onCompletion Video");
        onHideCustomView();
    }

    tener()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
