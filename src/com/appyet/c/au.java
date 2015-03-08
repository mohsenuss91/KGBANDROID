// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;


// Referenced classes of package com.appyet.c:
//            at

final class au
    implements com.actionbarsherlock.app.ActionBar.OnMenuVisibilityListener
{

    final at a;

    au(at at1)
    {
        a = at1;
        super();
    }

    public final void onMenuVisibilityChanged(boolean flag)
    {
        at.a(a, flag);
        if (!flag)
        {
            at.a(a);
        }
    }
}
