// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.c;


// Referenced classes of package android.support.v4.c:
//            c

public final class m
    implements Cloneable
{

    private static final Object a = new Object();
    private boolean b;
    private int c[];
    private Object d[];
    private int e;

    public m()
    {
        this((byte)0);
    }

    private m(byte byte0)
    {
        b = false;
        int i = android.support.v4.c.c.a(10);
        c = new int[i];
        d = new Object[i];
        e = 0;
    }

    private m c()
    {
        m m1;
        try
        {
            m1 = (m)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            return null;
        }
        try
        {
            m1.c = (int[])c.clone();
            m1.d = (Object[])((Object []) (d)).clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception1)
        {
            return m1;
        }
        return m1;
    }

    private void d()
    {
        int i = e;
        int ai[] = c;
        Object aobj[] = d;
        int j = 0;
        int k = 0;
        for (; j < i; j++)
        {
            Object obj = aobj[j];
            if (obj == a)
            {
                continue;
            }
            if (j != k)
            {
                ai[k] = ai[j];
                aobj[k] = obj;
                aobj[j] = null;
            }
            k++;
        }

        b = false;
        e = k;
    }

    public final int a()
    {
        if (b)
        {
            d();
        }
        return e;
    }

    public final Object a(int i)
    {
        int j = android.support.v4.c.c.a(c, e, i);
        if (j < 0 || d[j] == a)
        {
            return null;
        } else
        {
            return d[j];
        }
    }

    public final void a(int i, Object obj)
    {
        int j = android.support.v4.c.c.a(c, e, i);
        if (j >= 0)
        {
            d[j] = obj;
            return;
        }
        int k = ~j;
        if (k < e && d[k] == a)
        {
            c[k] = i;
            d[k] = obj;
            return;
        }
        if (b && e >= c.length)
        {
            d();
            k = -1 ^ android.support.v4.c.c.a(c, e, i);
        }
        if (e >= c.length)
        {
            int l = android.support.v4.c.c.a(1 + e);
            int ai[] = new int[l];
            Object aobj[] = new Object[l];
            System.arraycopy(c, 0, ai, 0, c.length);
            System.arraycopy(((Object) (d)), 0, ((Object) (aobj)), 0, d.length);
            c = ai;
            d = aobj;
        }
        if (e - k != 0)
        {
            System.arraycopy(c, k, c, k + 1, e - k);
            System.arraycopy(((Object) (d)), k, ((Object) (d)), k + 1, e - k);
        }
        c[k] = i;
        d[k] = obj;
        e = 1 + e;
    }

    public final void b()
    {
        int i = e;
        Object aobj[] = d;
        for (int j = 0; j < i; j++)
        {
            aobj[j] = null;
        }

        e = 0;
        b = false;
    }

    public final void b(int i)
    {
        int j = android.support.v4.c.c.a(c, e, i);
        if (j >= 0 && d[j] != a)
        {
            d[j] = a;
            b = true;
        }
    }

    public final void c(int i)
    {
        if (d[i] != a)
        {
            d[i] = a;
            b = true;
        }
    }

    public final Object clone()
    {
        return c();
    }

    public final int d(int i)
    {
        if (b)
        {
            d();
        }
        return c[i];
    }

    public final Object e(int i)
    {
        if (b)
        {
            d();
        }
        return d[i];
    }

    public final int f(int i)
    {
        if (b)
        {
            d();
        }
        return android.support.v4.c.c.a(c, e, i);
    }

    public final String toString()
    {
        if (a() <= 0)
        {
            return "{}";
        }
        StringBuilder stringbuilder = new StringBuilder(28 * e);
        stringbuilder.append('{');
        int i = 0;
        while (i < e) 
        {
            if (i > 0)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(d(i));
            stringbuilder.append('=');
            Object obj = e(i);
            if (obj != this)
            {
                stringbuilder.append(obj);
            } else
            {
                stringbuilder.append("(this Map)");
            }
            i++;
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

}
