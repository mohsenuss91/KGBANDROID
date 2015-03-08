// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.media.MediaPlayer;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity

class this._cls0
    implements android.media.istener
{

    final RichMediaActivity this$0;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        Log.w((new StringBuilder("Cannot play video/ Error: ")).append(i).append(" Extra: ").append(j).toString());
        finish();
        return false;
    }

    r()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
