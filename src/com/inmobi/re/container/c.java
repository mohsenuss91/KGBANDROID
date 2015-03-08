// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.app.Activity;
import android.media.MediaPlayer;
import android.widget.FrameLayout;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.re.container:
//            IMWebView

class c
    implements android.media.MediaPlayer.OnCompletionListener
{

    final IMWebView a;

    c(IMWebView imwebview)
    {
        a = imwebview;
        super();
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        try
        {
            mediaplayer.stop();
            IMWebView.i(a).setVisibility(8);
            IMWebView.l(a);
            IMWebView.h(a).setContentView(IMWebView.n(a));
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "Media Player onCompletion", exception);
        }
    }
}
