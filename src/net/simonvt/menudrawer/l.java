// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;


// Referenced classes of package net.simonvt.menudrawer:
//            MenuDrawer

final class l
    implements Runnable
{

    final MenuDrawer a;

    l(MenuDrawer menudrawer)
    {
        a = menudrawer;
        super();
    }

    public final void run()
    {
        MenuDrawer.a(a);
    }
}
