// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.content.Context;
import android.view.MotionEvent;

// Referenced classes of package uk.co.senab.photoview:
//            n

class o extends n
{

    private int f;
    private int g;

    public o(Context context)
    {
        super(context);
        f = -1;
        g = 0;
    }

    public boolean a(MotionEvent motionevent)
    {
        0xff & motionevent.getAction();
        JVM INSTR tableswitch 0 6: default 52
    //                   0 89
    //                   1 101
    //                   2 52
    //                   3 101
    //                   4 52
    //                   5 52
    //                   6 109;
           goto _L1 _L2 _L3 _L1 _L3 _L1 _L1 _L4
_L1:
        int k = f;
        int l = 0;
        if (k != -1)
        {
            l = f;
        }
        g = motionevent.findPointerIndex(l);
        return super.a(motionevent);
_L2:
        f = motionevent.getPointerId(0);
        continue; /* Loop/switch isn't completed */
_L3:
        f = -1;
        continue; /* Loop/switch isn't completed */
_L4:
        int i = (0xff00 & motionevent.getAction()) >> 8;
        if (motionevent.getPointerId(i) == f)
        {
            int j;
            if (i == 0)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            f = motionevent.getPointerId(j);
            b = motionevent.getX(j);
            c = motionevent.getY(j);
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    final float b(MotionEvent motionevent)
    {
        float f1;
        try
        {
            f1 = motionevent.getX(g);
        }
        catch (Exception exception)
        {
            return motionevent.getX();
        }
        return f1;
    }

    final float c(MotionEvent motionevent)
    {
        float f1;
        try
        {
            f1 = motionevent.getY(g);
        }
        catch (Exception exception)
        {
            return motionevent.getY();
        }
        return f1;
    }
}
