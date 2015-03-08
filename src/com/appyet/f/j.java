// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;


public final class j
{

    private static final String a = System.getProperty("line.separator");
    private static char b[];
    private static byte c[];

    public static String a(byte abyte0[])
    {
        int i = abyte0.length;
        String s = a;
        int k = (-1 + (i + 57)) / 57;
        StringBuilder stringbuilder = new StringBuilder(4 * ((i + 2) / 3) + k * s.length());
        int i1;
        for (int l = 0; l < i; l += i1)
        {
            i1 = Math.min(i - l, 57);
            stringbuilder.append(a(abyte0, l + 0, i1));
            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }

    public static byte[] a(String s)
    {
        int i = 0;
        char ac[] = new char[s.length()];
        int k = 0;
        int l = 0;
        for (; k < s.length(); k++)
        {
            char c5 = s.charAt(k);
            if (c5 != ' ' && c5 != '\r' && c5 != '\n' && c5 != '\t')
            {
                int k4 = l + 1;
                ac[l] = c5;
                l = k4;
            }
        }

        if (l % 4 != 0)
        {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        for (; l > 0 && ac[-1 + (l + 0)] == '='; l--) { }
        int i1 = (l * 3) / 4;
        byte abyte0[] = new byte[i1];
        int j1 = l + 0;
        int k1 = 0;
        while (i < j1) 
        {
            int l1 = i + 1;
            char c1 = ac[i];
            int i2 = l1 + 1;
            char c2 = ac[l1];
            char c3;
            int j2;
            char c4;
            if (i2 < j1)
            {
                int j4 = i2 + 1;
                c3 = ac[i2];
                i2 = j4;
            } else
            {
                c3 = 'A';
            }
            if (i2 < j1)
            {
                int i4 = i2 + 1;
                c4 = ac[i2];
                j2 = i4;
            } else
            {
                j2 = i2;
                c4 = 'A';
            }
            if (c1 > '\177' || c2 > '\177' || c3 > '\177' || c4 > '\177')
            {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte byte0 = c[c1];
            byte byte1 = c[c2];
            byte byte2 = c[c3];
            byte byte3 = c[c4];
            if (byte0 < 0 || byte1 < 0 || byte2 < 0 || byte3 < 0)
            {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int k2 = byte0 << 2 | byte1 >>> 4;
            int l2 = (byte1 & 0xf) << 4 | byte2 >>> 2;
            int i3 = byte3 | (byte2 & 3) << 6;
            int j3 = k1 + 1;
            abyte0[k1] = (byte)k2;
            int k3;
            int l3;
            if (j3 < i1)
            {
                k3 = j3 + 1;
                abyte0[j3] = (byte)l2;
            } else
            {
                k3 = j3;
            }
            if (k3 < i1)
            {
                l3 = k3 + 1;
                abyte0[k3] = (byte)i3;
            } else
            {
                l3 = k3;
            }
            k1 = l3;
            i = j2;
        }
        return abyte0;
    }

    private static char[] a(byte abyte0[], int i, int k)
    {
        int l = (2 + k * 4) / 3;
        char ac[] = new char[4 * ((k + 2) / 3)];
        int i1 = i + k;
        int j1 = 0;
        while (i < i1) 
        {
            int k1 = i + 1;
            int l1 = 0xff & abyte0[i];
            int i2;
            int j2;
            int k2;
            int l2;
            int i3;
            int j3;
            int k3;
            int l3;
            int i4;
            char c1;
            int j4;
            char c2;
            int k4;
            if (k1 < i1)
            {
                int l4 = k1 + 1;
                i2 = 0xff & abyte0[k1];
                k1 = l4;
            } else
            {
                i2 = 0;
            }
            if (k1 < i1)
            {
                j2 = k1 + 1;
                k2 = 0xff & abyte0[k1];
            } else
            {
                j2 = k1;
                k2 = 0;
            }
            l2 = l1 >>> 2;
            i3 = (l1 & 3) << 4 | i2 >>> 4;
            j3 = (i2 & 0xf) << 2 | k2 >>> 6;
            k3 = k2 & 0x3f;
            l3 = j1 + 1;
            ac[j1] = b[l2];
            i4 = l3 + 1;
            ac[l3] = b[i3];
            if (i4 < l)
            {
                c1 = b[j3];
            } else
            {
                c1 = '=';
            }
            ac[i4] = c1;
            j4 = i4 + 1;
            if (j4 < l)
            {
                c2 = b[k3];
            } else
            {
                c2 = '=';
            }
            ac[j4] = c2;
            k4 = j4 + 1;
            i = j2;
            j1 = k4;
        }
        return ac;
    }

    public static String b(String s)
    {
        return new String(b(s.getBytes()));
    }

    private static char[] b(byte abyte0[])
    {
        return a(abyte0, 0, abyte0.length);
    }

    static 
    {
        b = new char[64];
        char c1 = 'A';
        int i;
        int i2;
        for (i = 0; c1 <= 'Z'; i = i2)
        {
            char ac3[] = b;
            i2 = i + 1;
            ac3[i] = c1;
            c1++;
        }

        for (char c2 = 'a'; c2 <= 'z';)
        {
            char ac2[] = b;
            int l1 = i + 1;
            ac2[i] = c2;
            c2++;
            i = l1;
        }

        for (char c3 = '0'; c3 <= '9';)
        {
            char ac1[] = b;
            int k1 = i + 1;
            ac1[i] = c3;
            c3++;
            i = k1;
        }

        char ac[] = b;
        int k = i + 1;
        ac[i] = '+';
        b[k] = '/';
        c = new byte[128];
        int l = 0;
        int j1;
        do
        {
            int i1 = c.length;
            j1 = 0;
            if (l >= i1)
            {
                break;
            }
            c[l] = -1;
            l++;
        } while (true);
        for (; j1 < 64; j1++)
        {
            c[b[j1]] = (byte)j1;
        }

    }
}
