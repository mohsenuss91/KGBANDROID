// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

// Referenced classes of package uk.co.senab.photoview:
//            o, q

final class p extends o
{

    private final ScaleGestureDetector f;
    private final android.view.ScaleGestureDetector.OnScaleGestureListener g = new q(this);

    public p(Context context)
    {
        super(context);
        f = new ScaleGestureDetector(context, g);
    }

    public final boolean a()
    {
        return f.isInProgress();
    }

    public final boolean a(MotionEvent motionevent)
    {
        f.onTouchEvent(motionevent);
        return super.a(motionevent);
    }
}
