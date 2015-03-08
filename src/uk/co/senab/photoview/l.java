// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.content.Context;
import android.widget.Scroller;

// Referenced classes of package uk.co.senab.photoview:
//            j

final class l extends j
{

    private Scroller a;

    public l(Context context)
    {
        a = new Scroller(context);
    }

    public final void a(int i, int k, int i1, int j1, int k1, int l1, int i2, 
            int j2)
    {
        a.fling(i, k, i1, j1, k1, l1, i2, j2);
    }

    public final boolean a()
    {
        return a.computeScrollOffset();
    }

    public final void b()
    {
        a.forceFinished(true);
    }

    public final int c()
    {
        return a.getCurrX();
    }

    public final int d()
    {
        return a.getCurrY();
    }
}
