// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.d;

import com.google.a.b.u;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

// Referenced classes of package com.google.a.d:
//            b, e, c

public class a
    implements Closeable
{

    private static final char b[] = ")]}'\n".toCharArray();
    public boolean a;
    private final Reader c;
    private final char d[] = new char[1024];
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private long j;
    private int k;
    private String l;
    private int m[];
    private int n;

    public a(Reader reader)
    {
        a = false;
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        m = new int[32];
        n = 0;
        int ai[] = m;
        int i1 = n;
        n = i1 + 1;
        ai[i1] = 6;
        if (reader == null)
        {
            throw new NullPointerException("in == null");
        } else
        {
            c = reader;
            return;
        }
    }

    static int a(a a1)
    {
        return a1.i;
    }

    static int a(a a1, int i1)
    {
        a1.i = i1;
        return i1;
    }

    private IOException a(String s1)
    {
        throw new e((new StringBuilder()).append(s1).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
    }

    private void a(int i1)
    {
        if (n == m.length)
        {
            int ai1[] = new int[2 * n];
            System.arraycopy(m, 0, ai1, 0, n);
            m = ai1;
        }
        int ai[] = m;
        int j1 = n;
        n = j1 + 1;
        ai[j1] = i1;
    }

    private boolean a(char c1)
    {
        switch (c1)
        {
        default:
            return true;

        case 35: // '#'
        case 47: // '/'
        case 59: // ';'
        case 61: // '='
        case 92: // '\\'
            u();
            // fall through

        case 9: // '\t'
        case 10: // '\n'
        case 12: // '\f'
        case 13: // '\r'
        case 32: // ' '
        case 44: // ','
        case 58: // ':'
        case 91: // '['
        case 93: // ']'
        case 123: // '{'
        case 125: // '}'
            return false;
        }
    }

    static int b(a a1)
    {
        return a1.o();
    }

    private int b(boolean flag)
    {
        char ac[];
        int i1;
        int j1;
        ac = d;
        i1 = e;
        j1 = f;
_L25:
        if (i1 != j1) goto _L2; else goto _L1
_L1:
        e = i1;
        if (!b(1)) goto _L4; else goto _L3
_L3:
        i1 = e;
        j1 = f;
_L2:
        int k1;
        char c1;
        k1 = i1 + 1;
        c1 = ac[i1];
        if (c1 == '\n')
        {
            g = 1 + g;
            h = k1;
            i1 = k1;
            continue; /* Loop/switch isn't completed */
        }
        if (c1 == ' ' || c1 == '\r' || c1 == '\t') goto _L6; else goto _L5
_L5:
        if (c1 != '/') goto _L8; else goto _L7
_L7:
        e = k1;
        if (k1 == j1)
        {
            e = -1 + e;
            boolean flag2 = b(2);
            e = 1 + e;
            if (!flag2)
            {
                return c1;
            }
        }
        u();
        ac[e];
        JVM INSTR lookupswitch 2: default 196
    //                   42: 199
    //                   47: 363;
           goto _L9 _L10 _L11
_L9:
        return c1;
_L10:
        e = 1 + e;
_L16:
        if (e + "*/".length() > f && !b("*/".length())) goto _L13; else goto _L12
_L12:
        if (d[e] != '\n') goto _L15; else goto _L14
_L14:
        g = 1 + g;
        h = 1 + e;
_L20:
        e = 1 + e;
          goto _L16
_L15:
        int l1 = 0;
_L21:
        if (l1 >= "*/".length()) goto _L18; else goto _L17
_L17:
        if (d[l1 + e] != "*/".charAt(l1)) goto _L20; else goto _L19
_L19:
        l1++;
          goto _L21
          goto _L20
_L18:
        boolean flag1 = true;
_L23:
        if (!flag1)
        {
            throw a("Unterminated comment");
        }
        break; /* Loop/switch isn't completed */
_L13:
        flag1 = false;
        if (true) goto _L23; else goto _L22
_L22:
        i1 = 2 + e;
        j1 = f;
        continue; /* Loop/switch isn't completed */
_L11:
        e = 1 + e;
        v();
        i1 = e;
        j1 = f;
        continue; /* Loop/switch isn't completed */
_L8:
        if (c1 == '#')
        {
            e = k1;
            u();
            v();
            i1 = e;
            j1 = f;
        } else
        {
            e = k1;
            return c1;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (flag)
        {
            throw new EOFException((new StringBuilder("End of input at line ")).append(1 + g).append(" column ").append(t()).toString());
        } else
        {
            return -1;
        }
_L6:
        i1 = k1;
        if (true) goto _L25; else goto _L24
_L24:
    }

    private String b(char c1)
    {
        char ac[] = d;
        StringBuilder stringbuilder = new StringBuilder();
label0:
        do
        {
            int i1 = e;
            int j1 = f;
            int k1;
            int l1;
            for (k1 = i1; k1 < j1; k1 = l1)
            {
                l1 = k1 + 1;
                char c2 = ac[k1];
                if (c2 == c1)
                {
                    e = l1;
                    stringbuilder.append(ac, i1, -1 + (l1 - i1));
                    return stringbuilder.toString();
                }
                if (c2 == '\\')
                {
                    e = l1;
                    stringbuilder.append(ac, i1, -1 + (l1 - i1));
                    stringbuilder.append(w());
                    continue label0;
                }
                if (c2 == '\n')
                {
                    g = 1 + g;
                    h = l1;
                }
            }

            stringbuilder.append(ac, i1, k1 - i1);
            e = k1;
            if (!b(1))
            {
                throw a("Unterminated string");
            }
        } while (true);
    }

    private boolean b(int i1)
    {
        char ac[] = d;
        h = h - e;
        boolean flag;
        if (f != e)
        {
            f = f - e;
            System.arraycopy(ac, e, ac, 0, f);
        } else
        {
            f = 0;
        }
        e = 0;
        do
        {
            int j1 = c.read(ac, f, ac.length - f);
            flag = false;
            if (j1 == -1)
            {
                break;
            }
            f = j1 + f;
            if (g == 0 && h == 0 && f > 0 && ac[0] == '\uFEFF')
            {
                e = 1 + e;
                h = 1 + h;
                i1++;
            }
            if (f < i1)
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        return flag;
    }

    static int c(a a1)
    {
        return 1 + a1.g;
    }

    private void c(char c1)
    {
        char ac[] = d;
label0:
        do
        {
            int i1 = e;
            int k1;
            for (int j1 = f; i1 < j1; i1 = k1)
            {
                k1 = i1 + 1;
                char c2 = ac[i1];
                if (c2 == c1)
                {
                    e = k1;
                    return;
                }
                if (c2 == '\\')
                {
                    e = k1;
                    w();
                    continue label0;
                }
                if (c2 == '\n')
                {
                    g = 1 + g;
                    h = k1;
                }
            }

            e = i1;
            if (!b(1))
            {
                throw a("Unterminated string");
            }
        } while (true);
    }

    static int d(a a1)
    {
        return a1.t();
    }

    private int o()
    {
        int i1 = m[-1 + n];
        if (i1 != 1) goto _L2; else goto _L1
_L1:
        m[-1 + n] = 2;
_L14:
        b(true);
        JVM INSTR lookupswitch 7: default 100
    //                   34: 759
    //                   39: 746
    //                   44: 706
    //                   59: 706
    //                   91: 780
    //                   93: 694
    //                   123: 787;
           goto _L3 _L4 _L5 _L6 _L6 _L7 _L8 _L9
_L3:
        int k1;
        e = -1 + e;
        if (n == 1)
        {
            u();
        }
        k1 = q();
        if (k1 == 0) goto _L11; else goto _L10
_L10:
        return k1;
_L2:
        if (i1 == 2)
        {
            switch (b(true))
            {
            default:
                throw a("Unterminated array");

            case 93: // ']'
                i = 4;
                return 4;

            case 59: // ';'
                u();
                break;

            case 44: // ','
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i1 == 3 || i1 == 5)
        {
            m[-1 + n] = 4;
            if (i1 == 5)
            {
                switch (b(true))
                {
                default:
                    throw a("Unterminated object");

                case 125: // '}'
                    i = 2;
                    return 2;

                case 59: // ';'
                    u();
                    break;

                case 44: // ','
                    break;
                }
            }
            int j1 = b(true);
            switch (j1)
            {
            default:
                u();
                e = -1 + e;
                if (a((char)j1))
                {
                    i = 14;
                    return 14;
                } else
                {
                    throw a("Expected name");
                }

            case 34: // '"'
                i = 13;
                return 13;

            case 39: // '\''
                u();
                i = 12;
                return 12;

            case 125: // '}'
                break;
            }
            if (i1 != 5)
            {
                i = 2;
                return 2;
            } else
            {
                throw a("Expected name");
            }
        }
        if (i1 == 4)
        {
            m[-1 + n] = 5;
            switch (b(true))
            {
            case 59: // ';'
            case 60: // '<'
            default:
                throw a("Expected ':'");

            case 61: // '='
                u();
                if ((e < f || b(1)) && d[e] == '>')
                {
                    e = 1 + e;
                }
                break;

            case 58: // ':'
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i1 == 6)
        {
label0:
            {
                if (!a)
                {
                    break label0;
                }
                b(true);
                e = -1 + e;
                if (e + b.length > f && !b(b.length))
                {
                    break label0;
                }
                for (int l1 = 0; l1 < b.length; l1++)
                {
                    if (d[l1 + e] != b[l1])
                    {
                        break label0;
                    }
                }

                e = e + b.length;
            }
            m[-1 + n] = 7;
            continue; /* Loop/switch isn't completed */
        } else
        {
            if (i1 == 7)
            {
                if (b(false) == -1)
                {
                    i = 17;
                    return 17;
                }
                u();
                e = -1 + e;
            } else
            if (i1 == 8)
            {
                throw new IllegalStateException("JsonReader is closed");
            }
            continue; /* Loop/switch isn't completed */
        }
_L8:
        if (i1 == 1)
        {
            i = 4;
            return 4;
        }
_L6:
        if (i1 == 1 || i1 == 2)
        {
            u();
            e = -1 + e;
            i = 7;
            return 7;
        } else
        {
            throw a("Unexpected value");
        }
_L5:
        u();
        i = 8;
        return 8;
_L4:
        if (n == 1)
        {
            u();
        }
        i = 9;
        return 9;
_L7:
        i = 3;
        return 3;
_L9:
        i = 1;
        return 1;
_L11:
        if ((k1 = r()) != 0) goto _L10; else goto _L12
_L12:
        if (!a(d[e]))
        {
            throw a("Expected value");
        } else
        {
            u();
            i = 10;
            return 10;
        }
        if (true) goto _L14; else goto _L13
_L13:
    }

    private int q()
    {
        char c1 = d[e];
        String s1;
        String s2;
        int i1;
        if (c1 == 't' || c1 == 'T')
        {
            s1 = "true";
            s2 = "TRUE";
            i1 = 5;
        } else
        if (c1 == 'f' || c1 == 'F')
        {
            s1 = "false";
            s2 = "FALSE";
            i1 = 6;
        } else
        if (c1 == 'n' || c1 == 'N')
        {
            s1 = "null";
            s2 = "NULL";
            i1 = 7;
        } else
        {
            return 0;
        }
        do
        {
            int j1 = s1.length();
            for (int k1 = 1; k1 < j1; k1++)
            {
                if (k1 + e >= f && !b(k1 + 1))
                {
                    return 0;
                }
                char c2 = d[k1 + e];
                if (c2 != s1.charAt(k1) && c2 != s2.charAt(k1))
                {
                    return 0;
                }
            }

            if ((j1 + e < f || b(j1 + 1)) && a(d[j1 + e]))
            {
                return 0;
            }
            e = j1 + e;
            i = i1;
            return i1;
        } while (true);
    }

    private int r()
    {
        char ac[];
        long l1;
        boolean flag;
        boolean flag1;
        int k1;
        int i2;
        int j2;
        int k2;
        ac = d;
        int i1 = e;
        int j1 = f;
        l1 = 0L;
        flag = false;
        flag1 = true;
        k1 = 0;
        i2 = 0;
        j2 = j1;
        k2 = i1;
_L7:
        char c1;
        if (k2 + i2 == j2)
        {
            if (i2 == ac.length)
            {
                return 0;
            }
            if (!b(i2 + 1))
            {
                break MISSING_BLOCK_LABEL_519;
            }
            k2 = e;
            j2 = f;
        }
        c1 = ac[k2 + i2];
        c1;
        JVM INSTR lookupswitch 5: default 140
    //                   43: 245
    //                   45: 165
    //                   46: 304
    //                   69: 272
    //                   101: 272;
           goto _L1 _L2 _L3 _L4 _L5 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        if (c1 < '0' || c1 > '9')
        {
            if (a(c1))
            {
                return 0;
            }
            break MISSING_BLOCK_LABEL_519;
        }
        break MISSING_BLOCK_LABEL_330;
_L3:
        int l2;
        boolean flag2;
        boolean flag3;
        long l3;
        boolean flag4;
        boolean flag5;
        if (k1 == 0)
        {
            l2 = 1;
            boolean flag6 = flag1;
            flag3 = true;
            flag2 = flag6;
            l3 = l1;
        } else
        if (k1 == 5)
        {
            l2 = 6;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        } else
        {
            return 0;
        }
_L8:
        i2++;
        flag4 = flag2;
        k1 = l2;
        flag5 = flag3;
        flag1 = flag4;
        l1 = l3;
        flag = flag5;
        if (true) goto _L7; else goto _L6
_L6:
        if (k1 == 5)
        {
            l2 = 6;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        } else
        {
            return 0;
        }
          goto _L8
_L5:
        if (k1 == 2 || k1 == 4)
        {
            l2 = 5;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        } else
        {
            return 0;
        }
          goto _L8
_L4:
        if (k1 == 2)
        {
            l2 = 3;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        } else
        {
            return 0;
        }
          goto _L8
        if (k1 == 1 || k1 == 0)
        {
            long l4 = -(c1 - 48);
            l2 = 2;
            flag2 = flag1;
            flag3 = flag;
            l3 = l4;
        } else
        if (k1 == 2)
        {
            if (l1 == 0L)
            {
                return 0;
            }
            long l5 = 10L * l1 - (long)(c1 - 48);
            boolean flag7;
            boolean flag8;
            int i3;
            if (l1 > 0xf333333333333334L || l1 == 0xf333333333333334L && l5 < l1)
            {
                flag7 = true;
            } else
            {
                flag7 = false;
            }
            flag8 = flag7 & flag1;
            flag3 = flag;
            l3 = l5;
            i3 = k1;
            flag2 = flag8;
            l2 = i3;
        } else
        if (k1 == 3)
        {
            l2 = 4;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        } else
        if (k1 == 5 || k1 == 6)
        {
            l2 = 7;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        } else
        {
            l2 = k1;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        }
          goto _L8
        if (k1 == 2 && flag1 && (l1 != 0x8000000000000000L || flag))
        {
            if (!flag)
            {
                l1 = -l1;
            }
            j = l1;
            e = i2 + e;
            i = 15;
            return 15;
        }
        if (k1 == 2 || k1 == 4 || k1 == 7)
        {
            k = i2;
            i = 16;
            return 16;
        } else
        {
            return 0;
        }
    }

    private String s()
    {
        StringBuilder stringbuilder;
        int i1;
        stringbuilder = null;
        i1 = 0;
_L2:
        String s1;
        if (i1 + e < f)
        {
            switch (d[i1 + e])
            {
            default:
                i1++;
                continue; /* Loop/switch isn't completed */

            case 35: // '#'
            case 47: // '/'
            case 59: // ';'
            case 61: // '='
            case 92: // '\\'
                u();
                break;

            case 9: // '\t'
            case 10: // '\n'
            case 12: // '\f'
            case 13: // '\r'
            case 32: // ' '
            case 44: // ','
            case 58: // ':'
            case 91: // '['
            case 93: // ']'
            case 123: // '{'
            case 125: // '}'
                break;
            }
        } else
        if (i1 < d.length)
        {
            if (b(i1 + 1))
            {
                continue; /* Loop/switch isn't completed */
            }
        } else
        {
label0:
            {
                if (stringbuilder == null)
                {
                    stringbuilder = new StringBuilder();
                }
                stringbuilder.append(d, e, i1);
                e = i1 + e;
                if (b(1))
                {
                    break label0;
                }
                i1 = 0;
            }
        }
        if (stringbuilder == null)
        {
            s1 = new String(d, e, i1);
        } else
        {
            stringbuilder.append(d, e, i1);
            s1 = stringbuilder.toString();
        }
        e = i1 + e;
        return s1;
        i1 = 0;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private int t()
    {
        return 1 + (e - h);
    }

    private void u()
    {
        if (!a)
        {
            throw a("Use JsonReader.setLenient(true) to accept malformed JSON");
        } else
        {
            return;
        }
    }

    private void v()
    {
        char c1;
        do
        {
            if (e < f || b(1))
            {
                char ac[] = d;
                int i1 = e;
                e = i1 + 1;
                c1 = ac[i1];
                if (c1 != '\n')
                {
                    continue;
                }
                g = 1 + g;
                h = e;
            }
            return;
        } while (c1 != '\r');
    }

    private char w()
    {
        if (e == f && !b(1))
        {
            throw a("Unterminated escape sequence");
        }
        char ac[] = d;
        int i1 = e;
        e = i1 + 1;
        char c1 = ac[i1];
        switch (c1)
        {
        default:
            return c1;

        case 117: // 'u'
            if (4 + e > f && !b(4))
            {
                throw a("Unterminated escape sequence");
            }
            int j1 = e;
            int k1 = j1 + 4;
            char c2 = '\0';
            int l1 = j1;
            while (l1 < k1) 
            {
                char c3 = d[l1];
                char c4 = (char)(c2 << 4);
                if (c3 >= '0' && c3 <= '9')
                {
                    c2 = (char)(c4 + (c3 - 48));
                } else
                if (c3 >= 'a' && c3 <= 'f')
                {
                    c2 = (char)(c4 + (10 + (c3 - 97)));
                } else
                if (c3 >= 'A' && c3 <= 'F')
                {
                    c2 = (char)(c4 + (10 + (c3 - 65)));
                } else
                {
                    throw new NumberFormatException((new StringBuilder("\\u")).append(new String(d, e, 4)).toString());
                }
                l1++;
            }
            e = 4 + e;
            return c2;

        case 116: // 't'
            return '\t';

        case 98: // 'b'
            return '\b';

        case 110: // 'n'
            return '\n';

        case 114: // 'r'
            return '\r';

        case 102: // 'f'
            return '\f';

        case 10: // '\n'
            g = 1 + g;
            h = e;
            return c1;
        }
    }

    public void a()
    {
        int i1 = i;
        if (i1 == 0)
        {
            i1 = o();
        }
        if (i1 == 3)
        {
            a(1);
            i = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected BEGIN_ARRAY but was ")).append(f()).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
        }
    }

    public final void a(boolean flag)
    {
        a = flag;
    }

    public void b()
    {
        int i1 = i;
        if (i1 == 0)
        {
            i1 = o();
        }
        if (i1 == 4)
        {
            n = -1 + n;
            i = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected END_ARRAY but was ")).append(f()).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
        }
    }

    public void c()
    {
        int i1 = i;
        if (i1 == 0)
        {
            i1 = o();
        }
        if (i1 == 1)
        {
            a(3);
            i = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected BEGIN_OBJECT but was ")).append(f()).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
        }
    }

    public void close()
    {
        i = 0;
        m[0] = 8;
        n = 1;
        c.close();
    }

    public void d()
    {
        int i1 = i;
        if (i1 == 0)
        {
            i1 = o();
        }
        if (i1 == 2)
        {
            n = -1 + n;
            i = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected END_OBJECT but was ")).append(f()).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
        }
    }

    public boolean e()
    {
        int i1 = i;
        if (i1 == 0)
        {
            i1 = o();
        }
        return i1 != 2 && i1 != 4;
    }

    public c f()
    {
        int i1 = i;
        if (i1 == 0)
        {
            i1 = o();
        }
        switch (i1)
        {
        default:
            throw new AssertionError();

        case 1: // '\001'
            return c.c;

        case 2: // '\002'
            return c.d;

        case 3: // '\003'
            return c.a;

        case 4: // '\004'
            return c.b;

        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
            return c.e;

        case 5: // '\005'
        case 6: // '\006'
            return c.h;

        case 7: // '\007'
            return c.i;

        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
            return c.f;

        case 15: // '\017'
        case 16: // '\020'
            return c.g;

        case 17: // '\021'
            return c.j;
        }
    }

    public String g()
    {
        int i1 = i;
        if (i1 == 0)
        {
            i1 = o();
        }
        String s1;
        if (i1 == 14)
        {
            s1 = s();
        } else
        if (i1 == 12)
        {
            s1 = b('\'');
        } else
        if (i1 == 13)
        {
            s1 = b('"');
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected a name but was ")).append(f()).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
        }
        i = 0;
        return s1;
    }

    public String h()
    {
        int i1 = i;
        if (i1 == 0)
        {
            i1 = o();
        }
        String s1;
        if (i1 == 10)
        {
            s1 = s();
        } else
        if (i1 == 8)
        {
            s1 = b('\'');
        } else
        if (i1 == 9)
        {
            s1 = b('"');
        } else
        if (i1 == 11)
        {
            s1 = l;
            l = null;
        } else
        if (i1 == 15)
        {
            s1 = Long.toString(j);
        } else
        if (i1 == 16)
        {
            s1 = new String(d, e, k);
            e = e + k;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected a string but was ")).append(f()).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
        }
        i = 0;
        return s1;
    }

    public boolean i()
    {
        int i1 = i;
        if (i1 == 0)
        {
            i1 = o();
        }
        if (i1 == 5)
        {
            i = 0;
            return true;
        }
        if (i1 == 6)
        {
            i = 0;
            return false;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected a boolean but was ")).append(f()).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
        }
    }

    public void j()
    {
        int i1 = i;
        if (i1 == 0)
        {
            i1 = o();
        }
        if (i1 == 7)
        {
            i = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected null but was ")).append(f()).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
        }
    }

    public double k()
    {
        int i1 = i;
        if (i1 == 0)
        {
            i1 = o();
        }
        if (i1 == 15)
        {
            i = 0;
            return (double)j;
        }
        if (i1 == 16)
        {
            l = new String(d, e, k);
            e = e + k;
        } else
        if (i1 == 8 || i1 == 9)
        {
            char c1;
            if (i1 == 8)
            {
                c1 = '\'';
            } else
            {
                c1 = '"';
            }
            l = b(c1);
        } else
        {
            if (i1 != 10)
            {
                continue;
            }
            l = s();
        }
        do
        {
            i = 11;
            double d1 = Double.parseDouble(l);
            if (!a && (Double.isNaN(d1) || Double.isInfinite(d1)))
            {
                throw new e((new StringBuilder("JSON forbids NaN and infinities: ")).append(d1).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
            } else
            {
                l = null;
                i = 0;
                return d1;
            }
        } while (i1 == 11);
        throw new IllegalStateException((new StringBuilder("Expected a double but was ")).append(f()).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
    }

    public long l()
    {
        int i1;
        i1 = i;
        if (i1 == 0)
        {
            i1 = o();
        }
        if (i1 == 15)
        {
            i = 0;
            return j;
        }
        if (i1 != 16) goto _L2; else goto _L1
_L1:
        l = new String(d, e, k);
        e = e + k;
_L3:
        i = 11;
        double d1 = Double.parseDouble(l);
        long l1 = (long)d1;
        char c1;
        NumberFormatException numberformatexception;
        long l2;
        if ((double)l1 != d1)
        {
            throw new NumberFormatException((new StringBuilder("Expected a long but was ")).append(l).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
        } else
        {
            l = null;
            i = 0;
            return l1;
        }
_L2:
        if (i1 != 8 && i1 != 9)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        if (i1 == 8)
        {
            c1 = '\'';
        } else
        {
            c1 = '"';
        }
        l = b(c1);
        l2 = Long.parseLong(l);
        i = 0;
        return l2;
        numberformatexception;
          goto _L3
        throw new IllegalStateException((new StringBuilder("Expected a long but was ")).append(f()).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
    }

    public int m()
    {
        int i1;
        i1 = i;
        if (i1 == 0)
        {
            i1 = o();
        }
        if (i1 == 15)
        {
            int l1 = (int)j;
            if (j != (long)l1)
            {
                throw new NumberFormatException((new StringBuilder("Expected an int but was ")).append(j).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
            } else
            {
                i = 0;
                return l1;
            }
        }
        if (i1 != 16) goto _L2; else goto _L1
_L1:
        l = new String(d, e, k);
        e = e + k;
_L3:
        i = 11;
        double d1 = Double.parseDouble(l);
        int j1 = (int)d1;
        char c1;
        NumberFormatException numberformatexception;
        int k1;
        if ((double)j1 != d1)
        {
            throw new NumberFormatException((new StringBuilder("Expected an int but was ")).append(l).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
        } else
        {
            l = null;
            i = 0;
            return j1;
        }
_L2:
        if (i1 != 8 && i1 != 9)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        if (i1 == 8)
        {
            c1 = '\'';
        } else
        {
            c1 = '"';
        }
        l = b(c1);
        k1 = Integer.parseInt(l);
        i = 0;
        return k1;
        numberformatexception;
          goto _L3
        throw new IllegalStateException((new StringBuilder("Expected an int but was ")).append(f()).append(" at line ").append(1 + g).append(" column ").append(t()).toString());
    }

    public void n()
    {
        int i1 = 0;
_L2:
        int j1;
        j1 = i;
        if (j1 == 0)
        {
            j1 = o();
        }
        if (j1 != 3)
        {
            break; /* Loop/switch isn't completed */
        }
        a(1);
        i1++;
_L3:
        i = 0;
        if (i1 == 0)
        {
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (j1 == 1)
        {
            a(3);
            i1++;
        } else
        if (j1 == 4)
        {
            n = -1 + n;
            i1--;
        } else
        {
label0:
            {
                if (j1 != 2)
                {
                    break label0;
                }
                n = -1 + n;
                i1--;
            }
        }
          goto _L3
        continue; /* Loop/switch isn't completed */
        if (j1 != 14 && j1 != 10)
        {
            break MISSING_BLOCK_LABEL_316;
        }
_L10:
        int k1 = 0;
_L8:
        if (k1 + e >= f)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        d[k1 + e];
        JVM INSTR lookupswitch 16: default 272
    //                   9: 282
    //                   10: 282
    //                   12: 282
    //                   13: 282
    //                   32: 282
    //                   35: 278
    //                   44: 282
    //                   47: 278
    //                   58: 282
    //                   59: 278
    //                   61: 278
    //                   91: 282
    //                   92: 278
    //                   93: 282
    //                   123: 282
    //                   125: 282;
           goto _L4 _L5 _L5 _L5 _L5 _L5 _L6 _L5 _L6 _L5 _L6 _L6 _L5 _L6 _L5 _L5 _L5
_L4:
        k1++;
        break; /* Loop/switch isn't completed */
_L6:
        u();
          goto _L5
        if (true) goto _L8; else goto _L7
_L7:
        break MISSING_BLOCK_LABEL_295;
_L5:
        e = k1 + e;
        break; /* Loop/switch isn't completed */
        e = k1 + e;
        if (b(1)) goto _L10; else goto _L9
_L9:
        continue; /* Loop/switch isn't completed */
        if (j1 == 8 || j1 == 12)
        {
            c('\'');
        } else
        if (j1 == 9 || j1 == 13)
        {
            c('"');
        } else
        if (j1 == 16)
        {
            e = e + k;
        }
        if (true) goto _L3; else goto _L11
_L11:
        if (true) goto _L2; else goto _L12
_L12:
    }

    public final boolean p()
    {
        return a;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append(" at line ").append(1 + g).append(" column ").append(t()).toString();
    }

    static 
    {
        u.a = new b();
    }
}
