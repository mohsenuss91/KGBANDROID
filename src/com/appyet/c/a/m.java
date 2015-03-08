// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c.a;

import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;

// Referenced classes of package com.appyet.c.a:
//            l

final class m
    implements android.view.View.OnTouchListener
{

    final l a;

    m(l l1)
    {
        a = l1;
        super();
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        if (!l.a(a).isVerticalScrollBarEnabled())
        {
            l.a(a).setVerticalScrollBarEnabled(true);
        }
        return false;
    }
}
