// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b;

import android.widget.ImageView;
import com.a.a.b.a.a;
import com.a.a.b.a.b;
import com.a.a.b.a.d;
import java.lang.ref.Reference;

// Referenced classes of package com.a.a.b:
//            l, d

final class m
    implements Runnable
{

    final b a;
    final Throwable b;
    final l c;

    m(l l1, b b1, Throwable throwable)
    {
        c = l1;
        a = b1;
        b = throwable;
        super();
    }

    public final void run()
    {
        ImageView imageview = (ImageView)c.b.get();
        if (imageview != null)
        {
            d d1;
            boolean flag;
            if (c.c.c != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                imageview.setImageResource(c.c.c);
            }
        }
        d1 = c.d;
        String _tmp = c.a;
        d1.a(new a(a, b));
    }
}
