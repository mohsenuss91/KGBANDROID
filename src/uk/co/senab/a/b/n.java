// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.WeakHashMap;
import uk.co.senab.a.b.a.a;
import uk.co.senab.a.b.b.c;

// Referenced classes of package uk.co.senab.a.b:
//            o, g, j, h, 
//            f

public class n extends FrameLayout
{

    private j a;

    public n(Context context)
    {
        this(context, (byte)0);
    }

    private n(Context context, byte byte0)
    {
        this(context, '\0');
    }

    private n(Context context, char c1)
    {
        super(context, null, 0);
    }

    private void a(View view)
    {
        if (a == null) goto _L2; else goto _L1
_L1:
        j j1 = a;
        if (view == null || !(view.getLayoutParams() instanceof o)) goto _L4; else goto _L3
_L3:
        String s = ((o)view.getLayoutParams()).a();
        if (TextUtils.isEmpty(s)) goto _L4; else goto _L5
_L5:
        int i = s.indexOf('.');
        if (i != -1) goto _L7; else goto _L6
_L6:
        s = (new StringBuilder()).append(getContext().getPackageName()).append(".").append(s).toString();
_L11:
        c c1 = (c)uk.co.senab.a.b.g.a(getContext(), s);
_L9:
        if (!j1.f())
        {
            if (view != null)
            {
                break; /* Loop/switch isn't completed */
            }
            Log.i("PullToRefreshAttacher", "Refreshable View is null.");
        }
_L2:
        return;
_L7:
        if (i == 0)
        {
            s = (new StringBuilder()).append(getContext().getPackageName()).append(s).toString();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        c1 = null;
        if (true) goto _L9; else goto _L8
_L8:
        if (c1 == null)
        {
            c1 = uk.co.senab.a.b.g.a(view);
        }
        j1.m.put(view, c1);
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private void c()
    {
        if (a == null)
        {
            throw new IllegalStateException("You need to setup the PullToRefreshLayout before using it");
        } else
        {
            return;
        }
    }

    protected j a(Activity activity, h h1)
    {
        if (h1 == null)
        {
            h1 = new h();
        }
        return new j(activity, h1);
    }

    public final void a()
    {
        c();
        a.a(false, false);
    }

    final void a(int ai[])
    {
        int i = 0;
        for (int k = ai.length; i < k; i++)
        {
            if (findViewById(ai[i]) != null)
            {
                a(findViewById(ai[i]));
            }
        }

    }

    final void a(View aview[])
    {
        int i = 0;
        for (int k = aview.length; i < k; i++)
        {
            if (aview[i] != null)
            {
                a(aview[i]);
            }
        }

    }

    final void b()
    {
        c();
        int i = 0;
        for (int k = getChildCount(); i < k; i++)
        {
            a(getChildAt(i));
        }

    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new o(getContext(), attributeset);
    }

    public f getHeaderTransformer()
    {
        c();
        return a.a;
    }

    public final View getHeaderView()
    {
        c();
        return a.d;
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        if (a != null)
        {
            j j1 = a;
            j1.a.a(j1.c);
        }
        super.onConfigurationChanged(configuration);
    }

    protected void onDetachedFromWindow()
    {
        if (a != null)
        {
            a.c();
        }
        super.onDetachedFromWindow();
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (isEnabled() && a != null && getChildCount() > 0)
        {
            return a.a(motionevent);
        } else
        {
            return false;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!isEnabled() || a == null) goto _L2; else goto _L1
_L1:
        j j1;
        j1 = a;
        if (motionevent.getAction() == 0)
        {
            j1.k = true;
        }
        if (!j1.k || j1.i) goto _L4; else goto _L3
_L3:
        j1.a(motionevent);
_L8:
        boolean flag = true;
_L6:
        return flag;
_L4:
        View view;
        view = j1.l;
        flag = false;
        if (view == null) goto _L6; else goto _L5
_L5:
        boolean flag1;
        switch (motionevent.getAction())
        {
        default:
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
        case 3: // '\003'
            View view1 = j1.l;
            if (j1.i && j1.n && view1 != null && j1.g - j1.h >= j1.d(view1))
            {
                j1.a(true, true);
            }
            if (j1.i)
            {
                j1.e();
            }
            j1.d();
            continue; /* Loop/switch isn't completed */

        case 2: // '\002'
            flag1 = j1.j;
            flag = false;
            break;
        }
        if (flag1) goto _L6; else goto _L7
_L7:
        float f1 = motionevent.getY();
        if (j1.i && f1 != j1.g)
        {
            float f2 = f1 - j1.g;
            if (f2 >= (float)(-j1.f))
            {
                float f3 = j1.d(j1.l);
                float f4 = f1 - j1.h;
                if (f4 < f3)
                {
                    j1.a.a(f4 / f3);
                } else
                if (j1.n)
                {
                    j1.a.g();
                } else
                {
                    j1.a(true, true);
                }
                if (f2 > 0.0F)
                {
                    j1.g = f1;
                }
            } else
            {
                j1.e();
                j1.d();
            }
        }
        if (true) goto _L8; else goto _L2
_L2:
        return super.onTouchEvent(motionevent);
    }

    public final void setHeaderViewListener(a a1)
    {
        c();
        a.e = a1;
    }

    void setPullToRefreshAttacher(j j1)
    {
        if (a != null)
        {
            a.c();
        }
        a = j1;
    }

    public final void setRefreshing(boolean flag)
    {
        c();
        a.a(flag, false);
    }
}
