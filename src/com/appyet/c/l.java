// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;

// Referenced classes of package com.appyet.c:
//            k

final class l
    implements android.view.View.OnTouchListener
{

    final k a;

    l(k k1)
    {
        a = k1;
        super();
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        if (!k.a(a).isVerticalScrollBarEnabled())
        {
            k.a(a).setVerticalScrollBarEnabled(true);
        }
        return false;
    }
}
