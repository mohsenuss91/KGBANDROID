// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.a.a;

import java.io.UnsupportedEncodingException;

// Referenced classes of package com.google.b.a.a:
//            h, k, c

public final class b
{

    final int a;
    int b;
    private final byte c[];

    private b(byte abyte0[], int i, int j)
    {
        c = abyte0;
        b = i;
        a = i + j;
    }

    public static int a(long l)
    {
        if ((-128L & l) == 0L)
        {
            return 1;
        }
        if ((-16384L & l) == 0L)
        {
            return 2;
        }
        if ((0xffffffffffe00000L & l) == 0L)
        {
            return 3;
        }
        if ((0xfffffffff0000000L & l) == 0L)
        {
            return 4;
        }
        if ((0xfffffff800000000L & l) == 0L)
        {
            return 5;
        }
        if ((0xfffffc0000000000L & l) == 0L)
        {
            return 6;
        }
        if ((0xfffe000000000000L & l) == 0L)
        {
            return 7;
        }
        if ((0xff00000000000000L & l) == 0L)
        {
            return 8;
        }
        return (0x8000000000000000L & l) != 0L ? 10 : 9;
    }

    public static b a(byte abyte0[], int i, int j)
    {
        return new b(abyte0, i, j);
    }

    public static int b(int i)
    {
        if (i >= 0)
        {
            return f(i);
        } else
        {
            return 10;
        }
    }

    public static int b(int i, int j)
    {
        return d(i) + b(j);
    }

    public static int b(int i, long l)
    {
        return d(i) + a(l);
    }

    public static int b(int i, h h1)
    {
        int j = d(i);
        int l = h1.getSerializedSize();
        return j + (l + f(l));
    }

    public static int b(int i, String s)
    {
        return d(i) + b(s);
    }

    public static int b(String s)
    {
        int i;
        int j;
        try
        {
            byte abyte0[] = s.getBytes("UTF-8");
            i = f(abyte0.length);
            j = abyte0.length;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException("UTF-8 not supported.");
        }
        return j + i;
    }

    public static int d(int i)
    {
        return f(k.a(i, 0));
    }

    public static int f(int i)
    {
        if ((i & 0xffffff80) == 0)
        {
            return 1;
        }
        if ((i & 0xffffc000) == 0)
        {
            return 2;
        }
        if ((0xffe00000 & i) == 0)
        {
            return 3;
        }
        return (0xf0000000 & i) != 0 ? 5 : 4;
    }

    public final void a(float f1)
    {
        int i = Float.floatToIntBits(f1);
        c(i & 0xff);
        c(0xff & i >> 8);
        c(0xff & i >> 16);
        c(0xff & i >> 24);
    }

    public final void a(int i)
    {
        if (i >= 0)
        {
            e(i);
            return;
        } else
        {
            b(i);
            return;
        }
    }

    public final void a(int i, int j)
    {
        c(i, 0);
        a(j);
    }

    public final void a(int i, long l)
    {
        c(i, 0);
        b(l);
    }

    public final void a(int i, h h1)
    {
        c(i, 2);
        e(h1.getCachedSize());
        h1.writeTo(this);
    }

    public final void a(int i, String s)
    {
        c(i, 2);
        a(s);
    }

    public final void a(int i, boolean flag)
    {
        c(i, 0);
        a(flag);
    }

    public final void a(String s)
    {
        byte abyte0[] = s.getBytes("UTF-8");
        e(abyte0.length);
        a(abyte0);
    }

    public final void a(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        c(i);
    }

    public final void a(byte abyte0[])
    {
        int i = abyte0.length;
        if (a - b >= i)
        {
            System.arraycopy(abyte0, 0, c, b, i);
            b = i + b;
            return;
        } else
        {
            throw new c(b, a);
        }
    }

    public final void b(long l)
    {
        do
        {
            if ((-128L & l) == 0L)
            {
                c((int)l);
                return;
            }
            c(0x80 | 0x7f & (int)l);
            l >>>= 7;
        } while (true);
    }

    public final void c(int i)
    {
        byte byte0 = (byte)i;
        if (b == a)
        {
            throw new c(b, a);
        } else
        {
            byte abyte0[] = c;
            int j = b;
            b = j + 1;
            abyte0[j] = byte0;
            return;
        }
    }

    public final void c(int i, int j)
    {
        e(k.a(i, j));
    }

    public final void e(int i)
    {
        do
        {
            if ((i & 0xffffff80) == 0)
            {
                c(i);
                return;
            }
            c(0x80 | i & 0x7f);
            i >>>= 7;
        } while (true);
    }
}
