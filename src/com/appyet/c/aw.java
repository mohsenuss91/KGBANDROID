// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.view.View;
import android.view.Window;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.appyet.d.d;

// Referenced classes of package com.appyet.c:
//            at

final class aw
    implements Runnable
{

    final at a;

    aw(at at1)
    {
        a = at1;
        super();
    }

    public final void run()
    {
        try
        {
            if (!com.appyet.c.at.d(a))
            {
                if (a != null)
                {
                    a.getSherlockActivity().getSupportActionBar().hide();
                }
                a.getSherlockActivity().getWindow().getDecorView().setSystemUiVisibility(1);
            }
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
    }
}
