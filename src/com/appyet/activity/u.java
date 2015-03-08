// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import com.appyet.c.ay;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.bp;
import net.simonvt.menudrawer.o;

// Referenced classes of package com.appyet.activity:
//            MainActivity

final class u
    implements o
{

    final MainActivity a;

    u(MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }

    public final void a(int i)
    {
        i;
        JVM INSTR lookupswitch 3: default 36
    //                   0: 37
    //                   1: 36
    //                   8: 70;
           goto _L1 _L2 _L1 _L3
_L1:
        return;
_L2:
        MainActivity.c(a);
        if (MainActivity.d(a) > 3)
        {
            MainActivity.b(a).d.T();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        MainActivity.c(a);
        if (MainActivity.e(a) != null)
        {
            MainActivity.e(a).a();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }
}
