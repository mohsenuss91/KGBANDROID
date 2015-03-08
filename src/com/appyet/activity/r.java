// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import net.simonvt.menudrawer.MenuDrawer;

// Referenced classes of package com.appyet.activity:
//            MainActivity

final class r
    implements Runnable
{

    final MainActivity a;

    r(MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }

    public final void run()
    {
        MainActivity.a(a).o();
    }
}
