// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.os.Handler;
import com.appyet.d.d;

// Referenced classes of package com.appyet.manager:
//            as

final class at
    implements Runnable
{

    final as a;

    at(as as1)
    {
        a = as1;
        super();
    }

    public final void run()
    {
        try
        {
            a.l();
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
        as.a(a).postDelayed(this, 1000L);
    }
}
