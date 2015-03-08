// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;

import com.google.a.b.ag;
import com.google.a.d.d;
import java.io.IOException;
import java.io.StringWriter;

// Referenced classes of package com.google.a:
//            t, z, ab, y

public abstract class w
{

    public w()
    {
    }

    public Number a()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String b()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double c()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long d()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int e()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean f()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final boolean g()
    {
        return this instanceof t;
    }

    public final boolean h()
    {
        return this instanceof z;
    }

    public final boolean i()
    {
        return this instanceof ab;
    }

    public final boolean j()
    {
        return this instanceof y;
    }

    public final z k()
    {
        if (this instanceof z)
        {
            return (z)this;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Not a JSON Object: ")).append(this).toString());
        }
    }

    public final t l()
    {
        if (this instanceof t)
        {
            return (t)this;
        } else
        {
            throw new IllegalStateException("This is not a JSON Array.");
        }
    }

    public final ab m()
    {
        if (this instanceof ab)
        {
            return (ab)this;
        } else
        {
            throw new IllegalStateException("This is not a JSON Primitive.");
        }
    }

    public String toString()
    {
        String s;
        try
        {
            StringWriter stringwriter = new StringWriter();
            d d1 = new d(stringwriter);
            d1.g();
            ag.a(this, d1);
            s = stringwriter.toString();
        }
        catch (IOException ioexception)
        {
            throw new AssertionError(ioexception);
        }
        return s;
    }
}
