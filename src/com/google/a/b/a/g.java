// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ab;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.t;
import com.google.a.y;
import com.google.a.z;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.a.b.a:
//            h

public final class g extends a
{

    private static final Reader b = new h();
    private static final Object c = new Object();
    private final List d;

    private void a(c c1)
    {
        if (f() != c1)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(c1).append(" but was ").append(f()).toString());
        } else
        {
            return;
        }
    }

    private Object q()
    {
        return d.get(-1 + d.size());
    }

    private Object r()
    {
        return d.remove(-1 + d.size());
    }

    public final void a()
    {
        a(c.a);
        t t1 = (t)q();
        d.add(t1.iterator());
    }

    public final void b()
    {
        a(c.b);
        r();
        r();
    }

    public final void c()
    {
        a(c.c);
        z z1 = (z)q();
        d.add(z1.n().iterator());
    }

    public final void close()
    {
        d.clear();
        d.add(c);
    }

    public final void d()
    {
        a(c.d);
        r();
        r();
    }

    public final boolean e()
    {
        c c1 = f();
        return c1 != c.d && c1 != c.b;
    }

    public final c f()
    {
        Object obj;
        do
        {
            if (d.isEmpty())
            {
                return c.j;
            }
            obj = q();
            if (!(obj instanceof Iterator))
            {
                break;
            }
            boolean flag = d.get(-2 + d.size()) instanceof z;
            Iterator iterator = (Iterator)obj;
            if (iterator.hasNext())
            {
                if (flag)
                {
                    return c.e;
                }
                d.add(iterator.next());
            } else
            if (flag)
            {
                return c.d;
            } else
            {
                return c.b;
            }
        } while (true);
        if (obj instanceof z)
        {
            return c.c;
        }
        if (obj instanceof t)
        {
            return c.a;
        }
        if (obj instanceof ab)
        {
            ab ab1 = (ab)obj;
            if (ab1.p())
            {
                return c.f;
            }
            if (ab1.n())
            {
                return c.h;
            }
            if (ab1.o())
            {
                return c.g;
            } else
            {
                throw new AssertionError();
            }
        }
        if (obj instanceof y)
        {
            return c.i;
        }
        if (obj == c)
        {
            throw new IllegalStateException("JsonReader is closed");
        } else
        {
            throw new AssertionError();
        }
    }

    public final String g()
    {
        a(c.e);
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator)q()).next();
        d.add(entry.getValue());
        return (String)entry.getKey();
    }

    public final String h()
    {
        c c1 = f();
        if (c1 != c.f && c1 != c.g)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(c.f).append(" but was ").append(c1).toString());
        } else
        {
            return ((ab)r()).b();
        }
    }

    public final boolean i()
    {
        a(c.h);
        return ((ab)r()).f();
    }

    public final void j()
    {
        a(c.i);
        r();
    }

    public final double k()
    {
        c c1 = f();
        if (c1 != c.g && c1 != c.f)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(c.g).append(" but was ").append(c1).toString());
        }
        double d1 = ((ab)q()).c();
        if (!super.a && (Double.isNaN(d1) || Double.isInfinite(d1)))
        {
            throw new NumberFormatException((new StringBuilder("JSON forbids NaN and infinities: ")).append(d1).toString());
        } else
        {
            r();
            return d1;
        }
    }

    public final long l()
    {
        c c1 = f();
        if (c1 != c.g && c1 != c.f)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(c.g).append(" but was ").append(c1).toString());
        } else
        {
            long l1 = ((ab)q()).d();
            r();
            return l1;
        }
    }

    public final int m()
    {
        c c1 = f();
        if (c1 != c.g && c1 != c.f)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(c.g).append(" but was ").append(c1).toString());
        } else
        {
            int i1 = ((ab)q()).e();
            r();
            return i1;
        }
    }

    public final void n()
    {
        if (f() == c.e)
        {
            g();
            return;
        } else
        {
            r();
            return;
        }
    }

    public final void o()
    {
        a(c.e);
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator)q()).next();
        d.add(entry.getValue());
        d.add(new ab((String)entry.getKey()));
    }

    public final String toString()
    {
        return getClass().getSimpleName();
    }

}
