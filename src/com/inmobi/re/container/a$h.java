// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.view.KeyEvent;
import android.view.View;
import android.widget.VideoView;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.re.container:
//            a, IMWebView

class a
    implements android.view..OnKeyListener
{

    final a a;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", "Back Button pressed when html5 video is playing");
            IMWebView.j(a.a).stopPlayback();
            IMWebView.l(a.a);
        }
        return false;
    }

    bView(a a1)
    {
        a = a1;
        super();
    }
}
