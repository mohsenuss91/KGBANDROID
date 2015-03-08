// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

// Referenced classes of package com.mobeta.android.dslv:
//            x, b, DragSortListView

public final class a extends x
    implements android.view.GestureDetector.OnGestureListener, android.view.View.OnTouchListener
{

    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private boolean f;
    private GestureDetector g;
    private GestureDetector h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m[];
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private float s;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private DragSortListView x;
    private int y;
    private android.view.GestureDetector.OnGestureListener z;

    public a(DragSortListView dragsortlistview, int i1, int j1, int k1, int l1, int i2)
    {
        super(dragsortlistview);
        b = 0;
        c = true;
        e = false;
        f = false;
        j = -1;
        k = -1;
        l = -1;
        m = new int[2];
        r = false;
        s = 500F;
        z = new b(this);
        x = dragsortlistview;
        g = new GestureDetector(dragsortlistview.getContext(), this);
        h = new GestureDetector(dragsortlistview.getContext(), z);
        h.setIsLongpressEnabled(false);
        i = ViewConfiguration.get(dragsortlistview.getContext()).getScaledTouchSlop();
        t = i1;
        u = l1;
        v = i2;
        d = k1;
        b = j1;
    }

    private int a(MotionEvent motionevent, int i1)
    {
        int j1 = (int)motionevent.getX();
        int k1 = (int)motionevent.getY();
        int l1 = x.pointToPosition(j1, k1);
        int i2 = x.getHeaderViewsCount();
        int j2 = x.getFooterViewsCount();
        int k2 = x.getCount();
        if (l1 != -1 && l1 >= i2 && l1 < k2 - j2)
        {
            View view = x.getChildAt(l1 - x.getFirstVisiblePosition());
            int l2 = (int)motionevent.getRawX();
            int i3 = (int)motionevent.getRawY();
            View view1;
            if (i1 == 0)
            {
                view1 = view;
            } else
            {
                view1 = view.findViewById(i1);
            }
            if (view1 != null)
            {
                view1.getLocationOnScreen(m);
                if (l2 > m[0] && i3 > m[1] && l2 < m[0] + view1.getWidth() && i3 < m[1] + view1.getHeight())
                {
                    n = view.getLeft();
                    o = view.getTop();
                    return l1;
                }
            }
        }
        return -1;
    }

    private boolean a(int i1, int j1, int k1)
    {
        boolean flag = c;
        int l1 = 0;
        if (flag)
        {
            boolean flag1 = f;
            l1 = 0;
            if (!flag1)
            {
                l1 = 12;
            }
        }
        if (e && f)
        {
            l1 = 2 | (l1 | 1);
        }
        r = x.a(i1 - x.getHeaderViewsCount(), l1, j1, k1);
        return r;
    }

    static boolean a(a a1)
    {
        return a1.e;
    }

    static boolean b(a a1)
    {
        return a1.f;
    }

    static DragSortListView c(a a1)
    {
        return a1.x;
    }

    static float d(a a1)
    {
        return a1.s;
    }

    static int e(a a1)
    {
        return a1.y;
    }

    static boolean f(a a1)
    {
        a1.f = false;
        return false;
    }

    public final void a(Point point)
    {
        if (e && f)
        {
            y = point.x;
        }
    }

    public final void a(boolean flag)
    {
        c = flag;
    }

    public final void b(boolean flag)
    {
        e = flag;
    }

    public final boolean onDown(MotionEvent motionevent)
    {
        int i1 = -1;
        if (e && d == 0)
        {
            l = a(motionevent, u);
        }
        j = a(motionevent, t);
        if (j != i1 && b == 0)
        {
            a(j, (int)motionevent.getX() - n, (int)motionevent.getY() - o);
        }
        f = false;
        w = true;
        y = 0;
        if (d == 1)
        {
            i1 = a(motionevent, v);
        }
        k = i1;
        return true;
    }

    public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
    {
        return false;
    }

    public final void onLongPress(MotionEvent motionevent)
    {
        if (j != -1 && b == 2)
        {
            x.performHapticFeedback(0);
            a(j, p - n, q - o);
        }
    }

    public final boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
    {
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        i1 = (int)motionevent.getX();
        j1 = (int)motionevent.getY();
        k1 = (int)motionevent1.getX();
        l1 = (int)motionevent1.getY();
        i2 = k1 - n;
        j2 = l1 - o;
        if (!w || r || j == -1 && k == -1) goto _L2; else goto _L1
_L1:
        if (j == -1) goto _L4; else goto _L3
_L3:
        if (b != 1 || Math.abs(l1 - j1) <= i || !c) goto _L6; else goto _L5
_L5:
        a(j, i2, j2);
_L2:
        return false;
_L6:
        if (b != 0 && Math.abs(k1 - i1) > i && e)
        {
            f = true;
            a(k, i2, j2);
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (k != -1)
        {
            if (Math.abs(k1 - i1) > i && e)
            {
                f = true;
                a(k, i2, j2);
                return false;
            }
            if (Math.abs(l1 - j1) > i)
            {
                w = false;
                return false;
            }
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public final void onShowPress(MotionEvent motionevent)
    {
    }

    public final boolean onSingleTapUp(MotionEvent motionevent)
    {
        if (e && d == 0 && l != -1)
        {
            x.a(l - x.getHeaderViewsCount());
        }
        return true;
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        if (!x.c() || x.b())
        {
            return false;
        }
        g.onTouchEvent(motionevent);
        if (e && r && d == 1)
        {
            h.onTouchEvent(motionevent);
        }
        switch (0xff & motionevent.getAction())
        {
        case 2: // '\002'
        default:
            return false;

        case 3: // '\003'
            break;

        case 0: // '\0'
            p = (int)motionevent.getX();
            q = (int)motionevent.getY();
            return false;

        case 1: // '\001'
            if (e && f)
            {
                int i1;
                if (y >= 0)
                {
                    i1 = y;
                } else
                {
                    i1 = -y;
                }
                if (i1 > x.getWidth() / 2)
                {
                    x.a(0.0F);
                }
            }
            break;
        }
        f = false;
        r = false;
        return false;
    }
}
