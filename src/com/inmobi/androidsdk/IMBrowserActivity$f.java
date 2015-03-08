// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import android.view.MotionEvent;
import android.view.View;
import com.inmobi.re.container.IMWebView;

// Referenced classes of package com.inmobi.androidsdk:
//            IMBrowserActivity

class a
    implements android.view.
{

    final IMBrowserActivity a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            view.setBackgroundColor(0xff888888);
            if (IMBrowserActivity.a(a).canGoForward())
            {
                IMBrowserActivity.a(a).goForward();
            }
        } else
        if (motionevent.getAction() == 0)
        {
            view.setBackgroundColor(0xff00ffff);
            return true;
        }
        return true;
    }

    (IMBrowserActivity imbrowseractivity)
    {
        a = imbrowseractivity;
        super();
    }
}
