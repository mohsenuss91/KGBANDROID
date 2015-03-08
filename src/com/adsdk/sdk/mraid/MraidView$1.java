// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidView, ViewGestureDetector

class this._cls0
    implements android.view.Listener
{

    final MraidView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        MraidView.access$5(MraidView.this).sendTouchEvent(motionevent);
        motionevent.getAction();
        JVM INSTR tableswitch 0 1: default 36
    //                   0 38
    //                   1 38;
           goto _L1 _L2 _L2
_L1:
        return false;
_L2:
        if (!view.hasFocus())
        {
            view.requestFocus();
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    etector()
    {
        this$0 = MraidView.this;
        super();
    }
}
