// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDInterstitialController

class a
    implements android.view.rstitialController.a
{

    final MRAIDInterstitialController a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 1: default 28
    //                   0 30
    //                   1 38;
           goto _L1 _L2 _L3
_L1:
        return false;
_L2:
        view.requestFocus();
        continue; /* Loop/switch isn't completed */
_L3:
        view.requestFocus();
        if (true) goto _L1; else goto _L4
_L4:
    }

    (MRAIDInterstitialController mraidinterstitialcontroller)
    {
        a = mraidinterstitialcontroller;
        super();
    }
}
