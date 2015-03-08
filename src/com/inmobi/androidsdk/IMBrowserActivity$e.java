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
        if (motionevent.getAction() != 1) goto _L2; else goto _L1
_L1:
        view.setBackgroundColor(0xff888888);
        if (!IMBrowserActivity.a(a).canGoBack()) goto _L4; else goto _L3
_L3:
        IMBrowserActivity.a(a).goBack();
_L6:
        return true;
_L4:
        a.finish();
        return true;
_L2:
        if (motionevent.getAction() == 0)
        {
            view.setBackgroundColor(0xff00ffff);
            return true;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    (IMBrowserActivity imbrowseractivity)
    {
        a = imbrowseractivity;
        super();
    }
}
