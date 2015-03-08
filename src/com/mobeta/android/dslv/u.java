// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.os.SystemClock;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

class u
    implements Runnable
{

    private float a;
    protected long b;
    boolean c;
    final DragSortListView d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;

    public u(DragSortListView dragsortlistview, int j)
    {
        d = dragsortlistview;
        super();
        e = 0.5F;
        a = j;
        float f1 = 1.0F / (2.0F * e * (1.0F - e));
        i = f1;
        f = f1;
        g = e / (2.0F * (e - 1.0F));
        h = 1.0F / (1.0F - e);
    }

    public void a()
    {
    }

    public void a(float f1)
    {
    }

    public void b()
    {
    }

    public final void c()
    {
        b = SystemClock.uptimeMillis();
        c = false;
        a();
        d.post(this);
    }

    public void run()
    {
        if (c)
        {
            return;
        }
        float f1 = (float)(SystemClock.uptimeMillis() - b) / a;
        if (f1 >= 1.0F)
        {
            a(1.0F);
            b();
            return;
        }
        float f2;
        if (f1 < e)
        {
            f2 = f1 * (f1 * f);
        } else
        if (f1 < 1.0F - e)
        {
            f2 = g + f1 * h;
        } else
        {
            f2 = 1.0F - i * (f1 - 1.0F) * (f1 - 1.0F);
        }
        a(f2);
        d.post(this);
    }
}
