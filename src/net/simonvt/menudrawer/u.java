// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;


// Referenced classes of package net.simonvt.menudrawer:
//            t, v, x

final class u
    implements Runnable
{

    final t a;

    u(t t1)
    {
        a = t1;
        super();
    }

    public final void run()
    {
        a.g();
        v.a[a.getPosition().ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 64
    //                   2 64;
           goto _L1 _L2 _L2
_L1:
        int i = t.a(a);
_L4:
        a.a(i, 250);
        return;
_L2:
        i = -t.a(a);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
