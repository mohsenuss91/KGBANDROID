// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.b;


// Referenced classes of package uk.co.senab.a.b:
//            j, f

final class m
    implements Runnable
{

    final j a;

    m(j j1)
    {
        a = j1;
        super();
    }

    public final void run()
    {
        j j1 = a;
        if (!j1.f())
        {
            j1.a.c();
            if (j1.e != null)
            {
                uk.co.senab.a.b.a.a _tmp = j1.e;
                android.view.View _tmp1 = j1.d;
            }
        }
    }
}
