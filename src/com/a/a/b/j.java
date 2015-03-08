// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b;

import com.a.a.a.a.b;
import java.io.File;
import java.util.concurrent.Executor;

// Referenced classes of package com.a.a.b:
//            i, g, l

final class j
    implements Runnable
{

    final l a;
    final i b;

    j(i k, l l1)
    {
        b = k;
        a = l1;
        super();
    }

    public final void run()
    {
        boolean flag = b.a.q.a(a.a).exists();
        b.a();
        if (flag)
        {
            b.c.execute(a);
            return;
        } else
        {
            b.b.execute(a);
            return;
        }
    }
}
