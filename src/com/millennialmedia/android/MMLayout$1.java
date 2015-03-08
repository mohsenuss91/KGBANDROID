// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.MotionEvent;

// Referenced classes of package com.millennialmedia.android:
//            MMSDK, MMLayout

class er extends android.view.ctor.SimpleOnGestureListener
{

    final MMLayout this$0;

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        while (motionevent == null || motionevent1 == null || Math.abs((int)(motionevent1.getX() - motionevent.getX())) <= 200 || Math.abs(f) <= Math.abs(f1)) 
        {
            return false;
        }
        if (f > 0.0F)
        {
            if (MMSDK.logLevel == 0)
            {
                ("Enabling debug and verbose logging.");
                MMSDK.logLevel = 3;
            } else
            {
                ("Disabling debug and verbose logging.");
                MMSDK.logLevel = 0;
            }
        } else
        {
            MMSDK.printDiagnostics(adImpl);
        }
        return true;
    }

    stureListener()
    {
        this$0 = MMLayout.this;
        super();
    }
}
