// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.c;

import java.util.Map;

// Referenced classes of package android.support.v4.c:
//            f, a, l

final class b extends f
{

    final a a;

    b(a a1)
    {
        a = a1;
        super();
    }

    protected final int a()
    {
        return a.h;
    }

    protected final int a(Object obj)
    {
        if (obj == null)
        {
            return a.a();
        } else
        {
            return a.a(obj, obj.hashCode());
        }
    }

    protected final Object a(int i, int j)
    {
        return a.g[j + (i << 1)];
    }

    protected final Object a(int i, Object obj)
    {
        a a1 = a;
        int j = 1 + (i << 1);
        Object obj1 = ((l) (a1)).g[j];
        ((l) (a1)).g[j] = obj;
        return obj1;
    }

    protected final void a(int i)
    {
        a.c(i);
    }

    protected final void a(Object obj, Object obj1)
    {
        a.put(obj, obj1);
    }

    protected final int b(Object obj)
    {
        return a.a(obj);
    }

    protected final Map b()
    {
        return a;
    }

    protected final void c()
    {
        a.clear();
    }
}
