// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller.util;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.inmobi.re.controller.util:
//            AVPlayer

class a
    implements android.view.hListener
{

    final AVPlayer a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return false;
    }

    (AVPlayer avplayer)
    {
        a = avplayer;
        super();
    }
}
