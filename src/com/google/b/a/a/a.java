// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.a.a;


// Referenced classes of package com.google.b.a.a:
//            g, h, k

public final class a
{

    final byte a[];
    int b;
    int c;
    int d;
    int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    private a(byte abyte0[], int l, int i1)
    {
        e = 0x7fffffff;
        i = 64;
        j = 0x4000000;
        a = abyte0;
        b = l;
        c = l + i1;
        d = l;
    }

    public static a a(byte abyte0[], int l, int i1)
    {
        return new a(abyte0, l, i1);
    }

    private void d(int l)
    {
        if (l < 0)
        {
            throw com.google.b.a.a.g.b();
        }
        if (l + d > e)
        {
            d(e - d);
            throw com.google.b.a.a.g.a();
        }
        if (l <= c - d)
        {
            d = l + d;
            return;
        } else
        {
            throw com.google.b.a.a.g.a();
        }
    }

    private void j()
    {
        c = c + f;
        int l = c;
        if (l > e)
        {
            f = l - e;
            c = c - f;
            return;
        } else
        {
            f = 0;
            return;
        }
    }

    private byte k()
    {
        if (d == c)
        {
            throw com.google.b.a.a.g.a();
        } else
        {
            byte abyte0[] = a;
            int l = d;
            d = l + 1;
            return abyte0[l];
        }
    }

    public final int a()
    {
        boolean flag;
        if (d == c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            g = 0;
            return 0;
        }
        g = f();
        if (g == 0)
        {
            throw com.google.b.a.a.g.d();
        } else
        {
            return g;
        }
    }

    public final void a(int l)
    {
        if (g != l)
        {
            throw com.google.b.a.a.g.e();
        } else
        {
            return;
        }
    }

    public final void a(h h1)
    {
        int l = f();
        if (h >= i)
        {
            throw com.google.b.a.a.g.g();
        }
        if (l < 0)
        {
            throw com.google.b.a.a.g.b();
        }
        int i1 = l + d;
        int j1 = e;
        if (i1 > j1)
        {
            throw com.google.b.a.a.g.a();
        } else
        {
            e = i1;
            j();
            h = 1 + h;
            h1.mergeFrom(this);
            a(0);
            h = -1 + h;
            e = j1;
            j();
            return;
        }
    }

    public final long b()
    {
        int l = 0;
        long l1 = 0L;
        for (; l < 64; l += 7)
        {
            byte byte0 = k();
            l1 |= (long)(byte0 & 0x7f) << l;
            if ((byte0 & 0x80) == 0)
            {
                return l1;
            }
        }

        throw com.google.b.a.a.g.c();
    }

    public final boolean b(int l)
    {
        switch (com.google.b.a.a.k.a(l))
        {
        default:
            throw com.google.b.a.a.g.f();

        case 0: // '\0'
            f();
            return true;

        case 1: // '\001'
            h();
            return true;

        case 2: // '\002'
            d(f());
            return true;

        case 3: // '\003'
            int i1;
            do
            {
                i1 = a();
            } while (i1 != 0 && b(i1));
            a(com.google.b.a.a.k.a(com.google.b.a.a.k.b(l), 4));
            return true;

        case 4: // '\004'
            return false;

        case 5: // '\005'
            g();
            return true;
        }
    }

    public final int c()
    {
        return f();
    }

    public final byte[] c(int l)
    {
        if (l < 0)
        {
            throw com.google.b.a.a.g.b();
        }
        if (l + d > e)
        {
            d(e - d);
            throw com.google.b.a.a.g.a();
        }
        if (l <= c - d)
        {
            byte abyte0[] = new byte[l];
            System.arraycopy(a, d, abyte0, 0, l);
            d = l + d;
            return abyte0;
        } else
        {
            throw com.google.b.a.a.g.a();
        }
    }

    public final boolean d()
    {
        return f() != 0;
    }

    public final String e()
    {
        int l = f();
        if (l <= c - d && l > 0)
        {
            String s = new String(a, d, l, "UTF-8");
            d = l + d;
            return s;
        } else
        {
            return new String(c(l), "UTF-8");
        }
    }

    public final int f()
    {
        int l = k();
        if (l < 0) goto _L2; else goto _L1
_L1:
        return l;
_L2:
        int i1 = l & 0x7f;
        byte byte0 = k();
        if (byte0 >= 0)
        {
            return i1 | byte0 << 7;
        }
        int j1 = i1 | (byte0 & 0x7f) << 7;
        byte byte1 = k();
        if (byte1 >= 0)
        {
            return j1 | byte1 << 14;
        }
        int k1 = j1 | (byte1 & 0x7f) << 14;
        byte byte2 = k();
        if (byte2 >= 0)
        {
            return k1 | byte2 << 21;
        }
        int l1 = k1 | (byte2 & 0x7f) << 21;
        byte byte3 = k();
        l = l1 | byte3 << 28;
        if (byte3 < 0)
        {
            int i2 = 0;
label0:
            do
            {
label1:
                {
                    if (i2 >= 5)
                    {
                        break label1;
                    }
                    if (k() >= 0)
                    {
                        break label0;
                    }
                    i2++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        throw com.google.b.a.a.g.c();
    }

    public final int g()
    {
        byte byte0 = k();
        byte byte1 = k();
        byte byte2 = k();
        byte byte3 = k();
        return byte0 & 0xff | (byte1 & 0xff) << 8 | (byte2 & 0xff) << 16 | (byte3 & 0xff) << 24;
    }

    public final long h()
    {
        int l = k();
        int i1 = k();
        int j1 = k();
        int k1 = k();
        int l1 = k();
        int i2 = k();
        int j2 = k();
        int k2 = k();
        return 255L & (long)l | (255L & (long)i1) << 8 | (255L & (long)j1) << 16 | (255L & (long)k1) << 24 | (255L & (long)l1) << 32 | (255L & (long)i2) << 40 | (255L & (long)j2) << 48 | (255L & (long)k2) << 56;
    }

    public final int i()
    {
        return d - b;
    }
}
