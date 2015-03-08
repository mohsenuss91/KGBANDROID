// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;


// Referenced classes of package net.simonvt.menudrawer:
//            a

final class c
    implements Runnable
{

    final a a;

    c(a a1)
    {
        a = a1;
        super();
    }

    public final void run()
    {
        if (net.simonvt.menudrawer.a.b(a) && (a.getLayerType() != 2 || net.simonvt.menudrawer.a.c(a)))
        {
            net.simonvt.menudrawer.a.d(a);
            a.setLayerType(2, null);
            a.buildLayer();
            a.setLayerType(0, null);
        }
    }
}
