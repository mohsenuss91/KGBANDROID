// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import com.inmobi.re.container.IMWebView;

// Referenced classes of package com.inmobi.androidsdk:
//            IMBrowserActivity

class a
    implements android.view.tivity.a
{

    final IMBrowserActivity a;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
        {
            if (IMBrowserActivity.c() != null)
            {
                IMBrowserActivity.c().close();
            }
            a.finish();
            IMBrowserActivity.b().finish();
        }
        return false;
    }

    (IMBrowserActivity imbrowseractivity)
    {
        a = imbrowseractivity;
        super();
    }
}
