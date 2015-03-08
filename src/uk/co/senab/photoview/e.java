// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.graphics.Matrix;

// Referenced classes of package uk.co.senab.photoview:
//            b, a

final class e
    implements Runnable
{

    final b a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;

    public e(b b1, float f, float f1, float f2, float f3)
    {
        a = b1;
        super();
        d = f1;
        b = f2;
        c = f3;
        if (f < f1)
        {
            e = 1.07F;
            return;
        } else
        {
            e = 0.93F;
            return;
        }
    }

    public final void run()
    {
        float f;
label0:
        {
            android.widget.ImageView imageview = a.c();
            if (imageview != null)
            {
                uk.co.senab.photoview.b.c(a).postScale(e, e, b, c);
                uk.co.senab.photoview.b.d(a);
                f = a.g();
                if ((e <= 1.0F || f >= d) && (e >= 1.0F || d >= f))
                {
                    break label0;
                }
                uk.co.senab.photoview.a.a(imageview, this);
            }
            return;
        }
        float f1 = d / f;
        uk.co.senab.photoview.b.c(a).postScale(f1, f1, b, c);
        uk.co.senab.photoview.b.d(a);
    }
}
