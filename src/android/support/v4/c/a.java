// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v4.c:
//            l, b, f, h, 
//            i, k

public class a extends l
    implements Map
{

    f a;

    public a()
    {
    }

    private f b()
    {
        if (a == null)
        {
            a = new b(this);
        }
        return a;
    }

    public Set entrySet()
    {
        f f1 = b();
        if (f1.b == null)
        {
            f1.b = new h(f1);
        }
        return f1.b;
    }

    public Set keySet()
    {
        f f1 = b();
        if (f1.c == null)
        {
            f1.c = new i(f1);
        }
        return f1.c;
    }

    public void putAll(Map map)
    {
        int j = h + map.size();
        if (super.f.length < j)
        {
            int ai[] = super.f;
            Object aobj[] = super.g;
            super.a(j);
            if (super.h > 0)
            {
                System.arraycopy(ai, 0, super.f, 0, super.h);
                System.arraycopy(((Object) (aobj)), 0, ((Object) (super.g)), 0, super.h << 1);
            }
            l.a(ai, aobj, super.h);
        }
        java.util.Map.Entry entry;
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

    }

    public Collection values()
    {
        f f1 = b();
        if (f1.d == null)
        {
            f1.d = new k(f1);
        }
        return f1.d;
    }
}
