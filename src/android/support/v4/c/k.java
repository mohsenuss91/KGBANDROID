// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.c;

import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package android.support.v4.c:
//            f, g

final class k
    implements Collection
{

    final f a;

    k(f f1)
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
        throw new UnsupportedOperationException();
    }

    public final void clear()
    {
        a.c();
    }

    public final boolean contains(Object obj)
    {
        return a.b(obj) >= 0;
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

    public final boolean isEmpty()
    {
        return a.a() == 0;
    }

    public final Iterator iterator()
    {
        return new g(a, 1);
    }

    public final boolean remove(Object obj)
    {
        int i = a.b(obj);
        if (i >= 0)
        {
            a.a(i);
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean removeAll(Collection collection)
    {
        int i = 0;
        int j = a.a();
        boolean flag = false;
        for (; i < j; i++)
        {
            if (collection.contains(a.a(i, 1)))
            {
                a.a(i);
                i--;
                j--;
                flag = true;
            }
        }

        return flag;
    }

    public final boolean retainAll(Collection collection)
    {
        int i = 0;
        int j = a.a();
        boolean flag = false;
        for (; i < j; i++)
        {
            if (!collection.contains(a.a(i, 1)))
            {
                a.a(i);
                i--;
                j--;
                flag = true;
            }
        }

        return flag;
    }

    public final int size()
    {
        return a.a();
    }

    public final Object[] toArray()
    {
        return a.b(1);
    }

    public final Object[] toArray(Object aobj[])
    {
        return a.a(aobj, 1);
    }
}
