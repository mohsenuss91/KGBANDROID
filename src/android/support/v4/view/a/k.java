// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.a;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v4.view.a:
//            q, h, a, j

final class k
    implements q
{

    final h a;
    final j b;

    k(j j, h h1)
    {
        b = j;
        a = h1;
        super();
    }

    public final boolean a()
    {
        h _tmp = a;
        return h.c();
    }

    public final List b()
    {
        h _tmp = a;
        h.d();
        ArrayList arraylist = new ArrayList();
        int i = null.size();
        for (int j = 0; j < i; j++)
        {
            arraylist.add(((a)null.get(j)).a());
        }

        return arraylist;
    }

    public final Object c()
    {
        h _tmp = a;
        h.b();
        return null;
    }
}
