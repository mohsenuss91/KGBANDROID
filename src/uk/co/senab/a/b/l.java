// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.b;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;

// Referenced classes of package uk.co.senab.a.b:
//            e, j

final class l
    implements e
{

    final j a;

    l(j j)
    {
        a = j;
        super();
    }

    public final Context a(Activity activity)
    {
        int i = android.os.Build.VERSION.SDK_INT;
        Context context = null;
        if (i >= 14)
        {
            ActionBar actionbar = activity.getActionBar();
            context = null;
            if (actionbar != null)
            {
                context = actionbar.getThemedContext();
            }
        }
        if (context == null)
        {
            return activity;
        } else
        {
            return context;
        }
    }
}
