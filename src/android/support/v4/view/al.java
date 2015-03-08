// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

// Referenced classes of package android.support.v4.view:
//            ak

class al extends ak
{

    al()
    {
    }

    public final void a(View view, int i, int j, int k, int l)
    {
        view.postInvalidate(i, j, k, l);
    }

    public final void a(View view, Runnable runnable)
    {
        view.postOnAnimation(runnable);
    }

    public final void b(View view)
    {
        view.postInvalidateOnAnimation();
    }

    public void b(View view, int i)
    {
        if (i == 4)
        {
            i = 2;
        }
        view.setImportantForAccessibility(i);
    }

    public final int c(View view)
    {
        return view.getImportantForAccessibility();
    }
}
