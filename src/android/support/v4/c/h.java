// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package android.support.v4.c:
//            f, c, j

final class h
    implements Set
{

    final f a;

    h(f f1)
    {
        a = f1;
        super();
    }

    public final boolean add(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection)
    {
        int i = a.a();
        java.util.Map.Entry entry;
        for (Iterator iterator1 = collection.iterator(); iterator1.hasNext(); a.a(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator1.next();
        }

        return i != a.a();
    }

    public final void clear()
    {
        a.c();
    }

    public final boolean contains(Object obj)
    {
        if (obj instanceof java.util.Map.Entry)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)obj;
            int i = a.a(entry.getKey());
            if (i >= 0)
            {
                return c.a(a.a(i, 1), entry.getValue());
            }
        }
        return false;
    }

    public final boolean containsAll(Collection collection)
    {
        for (Iterator iterator1 = collection.iterator(); iterator1.hasNext();)
        {
            if (!contains(iterator1.next()))
            {
                return false;
            }
        }

        return true;
    }

    public final boolean equals(Object obj)
    {
        return f.a(this, obj);
    }

    public final int hashCode()
    {
        int i = -1 + a.a();
        int k = 0;
        while (i >= 0) 
        {
            Object obj = a.a(i, 0);
            Object obj1 = a.a(i, 1);
            int l;
            int i1;
            int j1;
            if (obj == null)
            {
                l = 0;
            } else
            {
                l = obj.hashCode();
            }
            if (obj1 == null)
            {
                i1 = 0;
            } else
            {
                i1 = obj1.hashCode();
            }
            j1 = k + (i1 ^ l);
            i--;
            k = j1;
        }
        return k;
    }

    public final boolean isEmpty()
    {
        return a.a() == 0;
    }

    public final Iterator iterator()
    {
        return new j(a);
    }

    public final boolean remove(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final int size()
    {
        return a.a();
    }

    public final Object[] toArray()
    {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray(Object aobj[])
    {
        throw new UnsupportedOperationException();
    }
}
