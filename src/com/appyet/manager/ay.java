// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.view.View;
import com.appyet.activity.MediaPlayerActivity;
import com.appyet.d.d;

// Referenced classes of package com.appyet.manager:
//            as

final class ay
    implements android.view.View.OnClickListener
{

    final as a;

    ay(as as1)
    {
        a = as1;
        super();
    }

    public final void onClick(View view)
    {
        try
        {
            if (as.f(a) != null)
            {
                a.d();
                as _tmp = a;
                as.e();
            }
            if (as.j(a) != null)
            {
                as.j(a).finish();
            }
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
    }
}
