// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class d
    implements Closeable, Flushable
{

    private static final String c[];
    private static final String d[];
    public boolean a;
    public boolean b;
    private final Writer e;
    private int f[];
    private int g;
    private String h;
    private String i;
    private boolean j;
    private String k;

    public d(Writer writer)
    {
        f = new int[32];
        g = 0;
        a(6);
        i = ":";
        b = true;
        if (writer == null)
        {
            throw new NullPointerException("out == null");
        } else
        {
            e = writer;
            return;
        }
    }

    private int a()
    {
        if (g == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            return f[-1 + g];
        }
    }

    private d a(int l, int i1, String s)
    {
        int j1 = a();
        if (j1 != i1 && j1 != l)
        {
            throw new IllegalStateException("Nesting problem.");
        }
        if (k != null)
        {
            throw new IllegalStateException((new StringBuilder("Dangling name: ")).append(k).toString());
        }
        g = -1 + g;
        if (j1 == i1)
        {
            i();
        }
        e.write(s);
        return this;
    }

    private d a(int l, String s)
    {
        b(true);
        a(l);
        e.write(s);
        return this;
    }

    private void a(int l)
    {
        if (g == f.length)
        {
            int ai1[] = new int[2 * g];
            System.arraycopy(f, 0, ai1, 0, g);
            f = ai1;
        }
        int ai[] = f;
        int i1 = g;
        g = i1 + 1;
        ai[i1] = l;
    }

    private void b(int l)
    {
        f[-1 + g] = l;
    }

    private void b(boolean flag)
    {
        switch (a())
        {
        case 3: // '\003'
        case 5: // '\005'
        default:
            throw new IllegalStateException("Nesting problem.");

        case 7: // '\007'
            if (!a)
            {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
            // fall through

        case 6: // '\006'
            if (!a && !flag)
            {
                throw new IllegalStateException("JSON must start with an array or an object.");
            } else
            {
                b(7);
                return;
            }

        case 1: // '\001'
            b(2);
            i();
            return;

        case 2: // '\002'
            e.append(',');
            i();
            return;

        case 4: // '\004'
            e.append(i);
            b(5);
            return;
        }
    }

    private void c(String s)
    {
        int l;
        int i1;
        int j1;
        char c1;
        String s1;
        l = 0;
        String as[];
        if (j)
        {
            as = d;
        } else
        {
            as = c;
        }
        e.write("\"");
        i1 = s.length();
        j1 = 0;
        if (j1 >= i1)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        c1 = s.charAt(j1);
        if (c1 >= '\200') goto _L2; else goto _L1
_L1:
        s1 = as[c1];
        if (s1 != null) goto _L4; else goto _L3
_L3:
        j1++;
        break MISSING_BLOCK_LABEL_31;
_L2:
        if (c1 != '\u2028')
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = "\\u2028";
_L4:
        if (l < j1)
        {
            e.write(s, l, j1 - l);
        }
        e.write(s1);
        l = j1 + 1;
        if (true) goto _L3; else goto _L5
_L5:
        if (c1 != '\u2029') goto _L3; else goto _L6
_L6:
        s1 = "\\u2029";
          goto _L4
        if (l < i1)
        {
            e.write(s, l, i1 - l);
        }
        e.write("\"");
        return;
    }

    private void h()
    {
        if (k != null)
        {
            int l = a();
            if (l == 5)
            {
                e.write(44);
            } else
            if (l != 3)
            {
                throw new IllegalStateException("Nesting problem.");
            }
            i();
            b(4);
            c(k);
            k = null;
        }
    }

    private void i()
    {
        if (h != null)
        {
            e.write("\n");
            int l = 1;
            int i1 = g;
            while (l < i1) 
            {
                e.write(h);
                l++;
            }
        }
    }

    public d a(long l)
    {
        h();
        b(false);
        e.write(Long.toString(l));
        return this;
    }

    public d a(Number number)
    {
        if (number == null)
        {
            return f();
        }
        h();
        String s = number.toString();
        if (!a && (s.equals("-Infinity") || s.equals("Infinity") || s.equals("NaN")))
        {
            throw new IllegalArgumentException((new StringBuilder("Numeric values must be finite, but was ")).append(number).toString());
        } else
        {
            b(false);
            e.append(s);
            return this;
        }
    }

    public d a(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("name == null");
        }
        if (k != null)
        {
            throw new IllegalStateException();
        }
        if (g == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            k = s;
            return this;
        }
    }

    public d a(boolean flag)
    {
        h();
        b(false);
        Writer writer = e;
        String s;
        if (flag)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        writer.write(s);
        return this;
    }

    public d b()
    {
        h();
        return a(1, "[");
    }

    public d b(String s)
    {
        if (s == null)
        {
            return f();
        } else
        {
            h();
            b(false);
            c(s);
            return this;
        }
    }

    public d c()
    {
        return a(1, 2, "]");
    }

    public void close()
    {
        e.close();
        int l = g;
        if (l > 1 || l == 1 && f[l - 1] != 7)
        {
            throw new IOException("Incomplete document");
        } else
        {
            g = 0;
            return;
        }
    }

    public d d()
    {
        h();
        return a(3, "{");
    }

    public d e()
    {
        return a(3, 5, "}");
    }

    public d f()
    {
label0:
        {
            if (k != null)
            {
                if (!b)
                {
                    break label0;
                }
                h();
            }
            b(false);
            e.write("null");
            return this;
        }
        k = null;
        return this;
    }

    public void flush()
    {
        if (g == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            e.flush();
            return;
        }
    }

    public final void g()
    {
        a = true;
    }

    static 
    {
        c = new String[128];
        for (int l = 0; l <= 31; l++)
        {
            String as1[] = c;
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(l);
            as1[l] = String.format("\\u%04x", aobj);
        }

        c[34] = "\\\"";
        c[92] = "\\\\";
        c[9] = "\\t";
        c[8] = "\\b";
        c[10] = "\\n";
        c[13] = "\\r";
        c[12] = "\\f";
        String as[] = (String[])c.clone();
        d = as;
        as[60] = "\\u003c";
        d[62] = "\\u003e";
        d[38] = "\\u0026";
        d[61] = "\\u003d";
        d[39] = "\\u0027";
    }
}
