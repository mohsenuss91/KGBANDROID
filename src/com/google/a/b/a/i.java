// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ab;
import com.google.a.d.d;
import com.google.a.t;
import com.google.a.w;
import com.google.a.y;
import com.google.a.z;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.a.b.a:
//            j

public final class i extends d
{

    private static final Writer c = new j();
    private static final ab d = new ab("closed");
    private final List e = new ArrayList();
    private String f;
    private w g;

    public i()
    {
        super(c);
        g = y.a;
    }

    private void a(w w1)
    {
        if (f != null)
        {
            if (!w1.j() || super.b)
            {
                ((z)h()).a(f, w1);
            }
            f = null;
            return;
        }
        if (e.isEmpty())
        {
            g = w1;
            return;
        }
        w w2 = h();
        if (w2 instanceof t)
        {
            ((t)w2).a(w1);
            return;
        } else
        {
            throw new IllegalStateException();
        }
    }

    private w h()
    {
        return (w)e.get(-1 + e.size());
    }

    public final d a(long l)
    {
        a(((w) (new ab(Long.valueOf(l)))));
        return this;
    }

    public final d a(Number number)
    {
        if (number == null)
        {
            return f();
        }
        if (!super.a)
        {
            double d1 = number.doubleValue();
            if (Double.isNaN(d1) || Double.isInfinite(d1))
            {
                throw new IllegalArgumentException((new StringBuilder("JSON forbids NaN and infinities: ")).append(number).toString());
            }
        }
        a(((w) (new ab(number))));
        return this;
    }

    public final d a(String s)
    {
        if (e.isEmpty() || f != null)
        {
            throw new IllegalStateException();
        }
        if (h() instanceof z)
        {
            f = s;
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final d a(boolean flag)
    {
        a(((w) (new ab(Boolean.valueOf(flag)))));
        return this;
    }

    public final w a()
    {
        if (!e.isEmpty())
        {
            throw new IllegalStateException((new StringBuilder("Expected one JSON element but was ")).append(e).toString());
        } else
        {
            return g;
        }
    }

    public final d b()
    {
        t t1 = new t();
        a(t1);
        e.add(t1);
        return this;
    }

    public final d b(String s)
    {
        if (s == null)
        {
            return f();
        } else
        {
            a(new ab(s));
            return this;
        }
    }

    public final d c()
    {
        if (e.isEmpty() || f != null)
        {
            throw new IllegalStateException();
        }
        if (h() instanceof t)
        {
            e.remove(-1 + e.size());
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final void close()
    {
        if (!e.isEmpty())
        {
            throw new IOException("Incomplete document");
        } else
        {
            e.add(d);
            return;
        }
    }

    public final d d()
    {
        z z1 = new z();
        a(z1);
        e.add(z1);
        return this;
    }

    public final d e()
    {
        if (e.isEmpty() || f != null)
        {
            throw new IllegalStateException();
        }
        if (h() instanceof z)
        {
            e.remove(-1 + e.size());
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final d f()
    {
        a(y.a);
        return this;
    }

    public final void flush()
    {
    }

}
