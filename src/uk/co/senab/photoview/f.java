// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.Log;

// Referenced classes of package uk.co.senab.photoview:
//            l, k, b, j, 
//            a

final class f
    implements Runnable
{

    final b a;
    private final j b;
    private int c;
    private int d;

    public f(b b1, Context context)
    {
        a = b1;
        super();
        Object obj;
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            obj = new l(context);
        } else
        {
            obj = new k(context);
        }
        b = ((j) (obj));
    }

    public final void a()
    {
        if (b.a)
        {
            Log.d("PhotoViewAttacher", "Cancel Fling");
        }
        b.b();
    }

    public final void a(int i, int i1, int j1, int k1)
    {
        RectF rectf = a.b();
        if (rectf != null)
        {
            int l1 = Math.round(-rectf.left);
            int i2;
            int j2;
            int k2;
            int l2;
            int i3;
            if ((float)i < rectf.width())
            {
                j2 = Math.round(rectf.width() - (float)i);
                i2 = 0;
            } else
            {
                i2 = l1;
                j2 = l1;
            }
            k2 = Math.round(-rectf.top);
            if ((float)i1 < rectf.height())
            {
                i3 = Math.round(rectf.height() - (float)i1);
                l2 = 0;
            } else
            {
                l2 = k2;
                i3 = k2;
            }
            c = l1;
            d = k2;
            if (b.a)
            {
                Log.d("PhotoViewAttacher", (new StringBuilder("fling. StartX:")).append(l1).append(" StartY:").append(k2).append(" MaxX:").append(j2).append(" MaxY:").append(i3).toString());
            }
            if (l1 != j2 || k2 != i3)
            {
                b.a(l1, k2, j1, k1, i2, j2, l2, i3);
                return;
            }
        }
    }

    public final void run()
    {
        android.widget.ImageView imageview = a.c();
        if (imageview != null && b.a())
        {
            int i = b.c();
            int i1 = b.d();
            if (b.a)
            {
                Log.d("PhotoViewAttacher", (new StringBuilder("fling run(). CurrentX:")).append(c).append(" CurrentY:").append(d).append(" NewX:").append(i).append(" NewY:").append(i1).toString());
            }
            uk.co.senab.photoview.b.c(a).postTranslate(c - i, d - i1);
            uk.co.senab.photoview.b.a(a, a.j());
            c = i;
            d = i1;
            uk.co.senab.photoview.a.a(imageview, this);
        }
    }
}
