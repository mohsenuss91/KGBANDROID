// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.c;

import java.util.Iterator;

// Referenced classes of package android.support.v4.c:
//            f, c

final class j
    implements Iterator, java.util.Map.Entry
{

    int a;
    int b;
    boolean c;
    final f d;

    j(f f1)
    {
        d = f1;
        super();
        c = false;
        a = -1 + f1.a();
        b = -1;
    }

    public final boolean equals(Object obj)
    {
        if (!c)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        java.util.Map.Entry entry;
        if (obj instanceof java.util.Map.Entry)
        {
            if (android.support.v4.c.c.a((entry = (java.util.Map.Entry)obj).getKey(), d.a(b, 0)) && android.support.v4.c.c.a(entry.getValue(), d.a(b, 1)))
            {
                return true;
            }
        }
        return false;
    }

    public final Object getKey()
    {
        if (!c)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else
        {
            return d.a(b, 0);
        }
    }

    public final Object getValue()
    {
        if (!c)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else
        {
            return d.a(b, 1);
        }
    }

    public final boolean hasNext()
    {
        return b < a;
    }

    public final int hashCode()
    {
        if (!c)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        Object obj = d.a(b, 0);
        Object obj1 = d.a(b, 1);
        int i;
        int k;
        if (obj == null)
        {
            i = 0;
        } else
        {
            i = obj.hashCode();
        }
        k = 0;
        if (obj1 != null)
        {
            k = obj1.hashCode();
        }
        return k ^ i;
    }

    public final volatile Object next()
    {
        b = 1 + b;
        c = true;
        return this;
    }

    public final void remove()
    {
        if (!c)
        {
            throw new IllegalStateException();
        } else
        {
            d.a(b);
            b = -1 + b;
            a = -1 + a;
            c = false;
            return;
        }
    }

    public final Object setValue(Object obj)
    {
        if (!c)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else
        {
            return d.a(b, obj);
        }
    }

    public final String toString()
    {
        return (new StringBuilder()).append(getKey()).append("=").append(getValue()).toString();
    }
}
