// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import uk.co.senab.a.b.b.c;

// Referenced classes of package uk.co.senab.a.b:
//            n, j, h

public final class b
{

    public h a;
    public uk.co.senab.a.b.a.b b;
    public ViewGroup c;
    public HashMap d;
    private final Activity e;
    private int f[];
    private View g[];

    private b(Activity activity)
    {
        e = activity;
    }

    b(Activity activity, byte byte0)
    {
        this(activity);
    }

    public final transient b a(int ai[])
    {
        f = ai;
        g = null;
        return this;
    }

    public final void a(n n1)
    {
        j j1 = n1.a(e, a);
        j1.b = b;
        if (c != null)
        {
            ViewGroup viewgroup = c;
            for (View view1 = viewgroup.getChildAt(0); view1 != null; view1 = viewgroup.getChildAt(0))
            {
                viewgroup.removeViewAt(0);
                n1.addView(view1);
            }

            viewgroup.addView(n1, -1, -1);
        }
        n1.setPullToRefreshAttacher(j1);
        if (f != null)
        {
            n1.a(f);
        } else
        if (g != null)
        {
            n1.a(g);
        } else
        {
            n1.b();
        }
        if (d != null)
        {
            for (Iterator iterator = d.entrySet().iterator(); iterator.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                Class class1 = (Class)entry.getKey();
                c c1 = (c)entry.getValue();
                Iterator iterator1 = j1.m.keySet().iterator();
                while (iterator1.hasNext()) 
                {
                    View view = (View)iterator1.next();
                    if (class1.isInstance(view))
                    {
                        j1.m.put(view, c1);
                    }
                }
            }

        }
    }
}
