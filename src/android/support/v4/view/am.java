// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            al

class am extends al
{

    am()
    {
    }

    public final void a(View view, Paint paint)
    {
        view.setLayerPaint(paint);
    }

    public final int e(View view)
    {
        return view.getLayoutDirection();
    }
}
