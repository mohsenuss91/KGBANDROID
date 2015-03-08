// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.MediaPlayer;
import android.os.Handler;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            InlineVideoView, MMLayout

class this._cls0
    implements android.media.rListener
{

    final InlineVideoView this$0;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        if (videoHandler != null && videoHandler.hasMessages(2))
        {
            videoHandler.removeMessages(2);
        }
        MMLayout mmlayout = (MMLayout)mmLayoutRef.get();
        if (mmlayout == null)
        {
            LayoutRef("MMLayout weak reference broken");
            return false;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("javascript:MMJS.setError(");
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(i);
            aobj[1] = Integer.valueOf(j);
            mmlayout.loadUrl(stringbuilder.append(String.format("Error while playing, %d - %d", aobj)).append(");").toString());
            return true;
        }
    }

    ()
    {
        this$0 = InlineVideoView.this;
        super();
    }
}
