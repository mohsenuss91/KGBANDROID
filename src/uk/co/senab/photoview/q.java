// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.view.ScaleGestureDetector;

// Referenced classes of package uk.co.senab.photoview:
//            p, r

final class q
    implements android.view.ScaleGestureDetector.OnScaleGestureListener
{

    final p a;

    q(p p1)
    {
        a = p1;
        super();
    }

    public final boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        a.a.a(scalegesturedetector.getScaleFactor(), scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
        return true;
    }

    public final boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        return true;
    }

    public final void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
    }
}
