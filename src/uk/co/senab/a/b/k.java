// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.b;

import android.view.ViewGroup;

// Referenced classes of package uk.co.senab.a.b:
//            j

final class k
    implements Runnable
{

    final ViewGroup a;
    final j b;

    k(j j1, ViewGroup viewgroup)
    {
        b = j1;
        a = viewgroup;
        super();
    }

    public final void run()
    {
        if (a.getWindowToken() != null)
        {
            b.a(b.d);
            return;
        } else
        {
            a.post(this);
            return;
        }
    }
}
