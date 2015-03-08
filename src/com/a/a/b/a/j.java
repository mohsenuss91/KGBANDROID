// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.a;

import android.widget.AbsListView;
import com.a.a.b.f;

public class j
    implements android.widget.AbsListView.OnScrollListener
{

    private f a;
    private final boolean b;
    private final boolean c;
    private final android.widget.AbsListView.OnScrollListener d;

    public j(f f1, boolean flag, boolean flag1)
    {
        this(f1, flag, flag1, (byte)0);
    }

    private j(f f1, boolean flag, boolean flag1, byte byte0)
    {
        a = f1;
        b = flag;
        c = flag1;
        d = null;
    }

    public void onScroll(AbsListView abslistview, int i, int k, int l)
    {
        if (d != null)
        {
            d.onScroll(abslistview, i, k, l);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 47
    //                   1 57
    //                   2 74;
           goto _L1 _L2 _L3 _L4
_L1:
        if (d != null)
        {
            d.onScrollStateChanged(abslistview, i);
        }
        return;
_L2:
        a.d();
        continue; /* Loop/switch isn't completed */
_L3:
        if (b)
        {
            a.c();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (c)
        {
            a.c();
        }
        if (true) goto _L1; else goto _L5
_L5:
    }
}
