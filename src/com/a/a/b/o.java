// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b;

import android.graphics.Bitmap;
import android.os.Handler;
import com.a.a.b.a.g;
import com.a.a.b.e.a;
import com.a.a.c.d;

// Referenced classes of package com.a.a.b:
//            i, g, k, d, 
//            c

final class o
    implements Runnable
{

    private final i a;
    private final Bitmap b;
    private final k c;
    private final Handler d;

    public o(i j, Bitmap bitmap, k k1, Handler handler)
    {
        a = j;
        b = bitmap;
        c = k1;
        d = handler;
    }

    public final void run()
    {
        if (a.a.u)
        {
            Object aobj[] = new Object[1];
            aobj[0] = c.b;
            com.a.a.c.d.a("PostProcess image before displaying [%s]", aobj);
        }
        a a1 = c.e.l;
        Bitmap _tmp = b;
        Bitmap bitmap = a1.a();
        d.post(new c(bitmap, c, a, g.c));
    }
}
