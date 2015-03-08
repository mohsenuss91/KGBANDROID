// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.os.Handler;
import com.appyet.d.d;

// Referenced classes of package com.appyet.manager:
//            as

final class ba
    implements Runnable
{

    final as a;

    ba(as as1)
    {
        a = as1;
        super();
    }

    public final void run()
    {
        try
        {
            as.c(a).removeCallbacks(as.b(a));
            com.appyet.manager.as.d(a);
            a.d();
            as _tmp = a;
            as.e();
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
    }
}
