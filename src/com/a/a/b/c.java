// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.a.a.b.a.g;
import com.a.a.b.c.a;
import com.a.a.c.d;
import java.lang.ref.Reference;

// Referenced classes of package com.a.a.b:
//            k, d, i

final class c
    implements Runnable
{

    boolean a;
    private final Bitmap b;
    private final String c;
    private final Reference d;
    private final String e;
    private final a f;
    private final com.a.a.b.a.d g;
    private final i h;
    private final g i;

    public c(Bitmap bitmap, k k1, i j, g g1)
    {
        b = bitmap;
        c = k1.a;
        d = k1.c;
        e = k1.b;
        f = k1.e.m;
        g = k1.f;
        h = j;
        i = g1;
    }

    public final void run()
    {
        ImageView imageview = (ImageView)d.get();
        if (imageview == null)
        {
            if (a)
            {
                Object aobj2[] = new Object[1];
                aobj2[0] = e;
                com.a.a.c.d.a("ImageView was collected by GC. Task is cancelled. [%s]", aobj2);
            }
            com.a.a.b.a.d _tmp = g;
            String _tmp1 = c;
            return;
        }
        String s = h.a(imageview);
        boolean flag;
        if (!e.equals(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (a)
            {
                Object aobj1[] = new Object[1];
                aobj1[0] = e;
                com.a.a.c.d.a("ImageView is reused for another image. Task is cancelled. [%s]", aobj1);
            }
            com.a.a.b.a.d _tmp2 = g;
            String _tmp3 = c;
            return;
        }
        if (a)
        {
            Object aobj[] = new Object[2];
            aobj[0] = i;
            aobj[1] = e;
            com.a.a.c.d.a("Display image in ImageView (loaded from %1$s) [%2$s]", aobj);
        }
        a a1 = f;
        Bitmap bitmap = b;
        g _tmp4 = i;
        Bitmap bitmap1 = a1.a(bitmap, imageview);
        g.a(c, imageview, bitmap1);
        h.b(imageview);
    }
}
