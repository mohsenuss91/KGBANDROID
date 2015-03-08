// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.content.Context;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

// Referenced classes of package uk.co.senab.photoview:
//            m, r

class n extends m
{

    float b;
    float c;
    final float d;
    final float e;
    private VelocityTracker f;
    private boolean g;

    public n(Context context)
    {
        ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
        e = viewconfiguration.getScaledMinimumFlingVelocity();
        d = viewconfiguration.getScaledTouchSlop();
    }

    public boolean a()
    {
        return false;
    }

    public boolean a(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 36
    //                   0 38
    //                   1 225
    //                   2 78
    //                   3 204;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L2:
        f = VelocityTracker.obtain();
        f.addMovement(motionevent);
        b = b(motionevent);
        c = c(motionevent);
        g = false;
        return true;
_L4:
        float f3 = b(motionevent);
        float f4 = c(motionevent);
        float f5 = f3 - b;
        float f6 = f4 - c;
        if (!g)
        {
            int i = FloatMath.sqrt(f5 * f5 + f6 * f6) != d;
            boolean flag = false;
            if (i >= 0)
            {
                flag = true;
            }
            g = flag;
        }
        if (g)
        {
            a.a(f5, f6);
            b = f3;
            c = f4;
            if (f != null)
            {
                f.addMovement(motionevent);
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (f != null)
        {
            f.recycle();
            f = null;
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (g && f != null)
        {
            b = b(motionevent);
            c = c(motionevent);
            f.addMovement(motionevent);
            f.computeCurrentVelocity(1000);
            float f1 = f.getXVelocity();
            float f2 = f.getYVelocity();
            if (Math.max(Math.abs(f1), Math.abs(f2)) >= e)
            {
                a.a(b, c, -f1, -f2);
            }
        }
        if (f != null)
        {
            f.recycle();
            f = null;
            return true;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    float b(MotionEvent motionevent)
    {
        return motionevent.getX();
    }

    float c(MotionEvent motionevent)
    {
        return motionevent.getY();
    }
}
