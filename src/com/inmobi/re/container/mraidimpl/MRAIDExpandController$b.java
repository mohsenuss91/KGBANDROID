// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDExpandController

class a
    implements android.view.IDExpandController.b
{

    final MRAIDExpandController a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return true;
    }

    (MRAIDExpandController mraidexpandcontroller)
    {
        a = mraidexpandcontroller;
        super();
    }
}
