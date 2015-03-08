// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.a.a;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import uk.co.senab.a.b.e;
import uk.co.senab.a.b.f;
import uk.co.senab.a.b.h;
import uk.co.senab.a.b.j;

// Referenced classes of package uk.co.senab.a.a.a:
//            d, a

final class c extends j
{

    private FrameLayout o;

    protected c(Activity activity, h h)
    {
        super(activity, h);
    }

    protected final e a()
    {
        return new d();
    }

    protected final void a(View view)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            super.a(view);
            return;
        } else
        {
            o = new FrameLayout(super.c);
            o.addView(view);
            super.a(o);
            return;
        }
    }

    protected final f b()
    {
        return new a();
    }

    protected final void b(View view)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            super.b(view);
            return;
        } else
        {
            super.b(o);
            return;
        }
    }

    protected final void c(View view)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            super.c(view);
        } else
        if (o != null)
        {
            super.c(o);
            o = null;
            return;
        }
    }
}
