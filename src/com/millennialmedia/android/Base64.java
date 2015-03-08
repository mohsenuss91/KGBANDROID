// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.util.Arrays;

class Base64
{

    private static final char CA[];
    private static final int IA[];

    Base64()
    {
    }

    public static final byte[] decode(String s)
    {
        int i;
        if (s != null)
        {
            i = s.length();
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            return new byte[0];
        }
        int j = 0;
        int k = 0;
        for (; j < i; j++)
        {
            if (IA[s.charAt(j)] < 0)
            {
                k++;
            }
        }

        if ((i - k) % 4 != 0)
        {
            return null;
        }
        int l = i;
        int i1 = 0;
        do
        {
            if (l <= 1)
            {
                break;
            }
            int ai1[] = IA;
            l--;
            if (ai1[s.charAt(l)] > 0)
            {
                break;
            }
            if (s.charAt(l) == '=')
            {
                i1++;
            }
        } while (true);
        int j1 = (6 * (i - k) >> 3) - i1;
        byte abyte0[] = new byte[j1];
        int k1 = 0;
        int l1 = 0;
        while (k1 < j1) 
        {
            int i2 = 0;
            int j2 = l1;
            int k2 = 0;
            while (k2 < 4) 
            {
                int ai[] = IA;
                int j3 = j2 + 1;
                int k3 = ai[s.charAt(j2)];
                if (k3 >= 0)
                {
                    i2 |= k3 << 18 - k2 * 6;
                } else
                {
                    k2--;
                }
                k2++;
                j2 = j3;
            }
            int l2 = k1 + 1;
            abyte0[k1] = (byte)(i2 >> 16);
            if (l2 < j1)
            {
                int i3 = l2 + 1;
                abyte0[l2] = (byte)(i2 >> 8);
                if (i3 < j1)
                {
                    l2 = i3 + 1;
                    abyte0[i3] = (byte)i2;
                } else
                {
                    l2 = i3;
                }
            }
            k1 = l2;
            l1 = j2;
        }
        return abyte0;
    }

    public static final byte[] decode(byte abyte0[])
    {
        int i = abyte0.length;
        int j = 0;
        int k = 0;
        for (; j < i; j++)
        {
            if (IA[0xff & abyte0[j]] < 0)
            {
                k++;
            }
        }

        if ((i - k) % 4 != 0)
        {
            return null;
        }
        int l = i;
        int i1 = 0;
        do
        {
            if (l <= 1)
            {
                break;
            }
            int ai1[] = IA;
            l--;
            if (ai1[0xff & abyte0[l]] > 0)
            {
                break;
            }
            if (abyte0[l] == 61)
            {
                i1++;
            }
        } while (true);
        int j1 = (6 * (i - k) >> 3) - i1;
        byte abyte1[] = new byte[j1];
        int k1 = 0;
        int l1 = 0;
        while (k1 < j1) 
        {
            int i2 = 0;
            int j2 = l1;
            int k2 = 0;
            while (k2 < 4) 
            {
                int ai[] = IA;
                int j3 = j2 + 1;
                int k3 = ai[0xff & abyte0[j2]];
                if (k3 >= 0)
                {
                    i2 |= k3 << 18 - k2 * 6;
                } else
                {
                    k2--;
                }
                k2++;
                j2 = j3;
            }
            int l2 = k1 + 1;
            abyte1[k1] = (byte)(i2 >> 16);
            if (l2 < j1)
            {
                int i3 = l2 + 1;
                abyte1[l2] = (byte)(i2 >> 8);
                if (i3 < j1)
                {
                    l2 = i3 + 1;
                    abyte1[i3] = (byte)i2;
                } else
                {
                    l2 = i3;
                }
            }
            k1 = l2;
            l1 = j2;
        }
        return abyte1;
    }

    public static final char[] encodeToChar(byte abyte0[], boolean flag)
    {
        int i;
        if (abyte0 != null)
        {
            i = abyte0.length;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            return new char[0];
        }
        int j = 3 * (i / 3);
        int k = 1 + (i - 1) / 3 << 2;
        int l;
        int i1;
        char ac[];
        int j1;
        int k1;
        int l1;
        if (flag)
        {
            l = (k - 1) / 76 << 1;
        } else
        {
            l = 0;
        }
        i1 = k + l;
        ac = new char[i1];
        j1 = 0;
        k1 = 0;
        l1 = 0;
        do
        {
            if (l1 >= j)
            {
                break;
            }
            int j3 = l1 + 1;
            int k3 = (0xff & abyte0[l1]) << 16;
            int l3 = j3 + 1;
            int i4 = k3 | (0xff & abyte0[j3]) << 8;
            l1 = l3 + 1;
            int j4 = i4 | 0xff & abyte0[l3];
            int k4 = k1 + 1;
            ac[k1] = CA[0x3f & j4 >>> 18];
            int l4 = k4 + 1;
            ac[k4] = CA[0x3f & j4 >>> 12];
            int i5 = l4 + 1;
            ac[l4] = CA[0x3f & j4 >>> 6];
            k1 = i5 + 1;
            ac[i5] = CA[j4 & 0x3f];
            if (flag && ++j1 == 19 && k1 < i1 - 2)
            {
                int j5 = k1 + 1;
                ac[k1] = '\r';
                int k5 = j5 + 1;
                ac[j5] = '\n';
                k1 = k5;
                j1 = 0;
            }
        } while (true);
        int i2 = i - j;
        if (i2 > 0)
        {
            int j2 = (0xff & abyte0[j]) << 10;
            int k2 = 0;
            if (i2 == 2)
            {
                k2 = (0xff & abyte0[i - 1]) << 2;
            }
            int l2 = k2 | j2;
            ac[i1 - 4] = CA[l2 >> 12];
            ac[i1 - 3] = CA[0x3f & l2 >>> 6];
            int i3 = i1 - 2;
            char c;
            if (i2 == 2)
            {
                c = CA[l2 & 0x3f];
            } else
            {
                c = '=';
            }
            ac[i3] = c;
            ac[i1 - 1] = '=';
        }
        return ac;
    }

    public static final String encodeToString(byte abyte0[], boolean flag)
    {
        return new String(encodeToChar(abyte0, flag));
    }

    static 
    {
        CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        int ai[] = new int[256];
        IA = ai;
        Arrays.fill(ai, -1);
        int i = CA.length;
        for (int j = 0; j < i; j++)
        {
            IA[CA[j]] = j;
        }

        IA[61] = 0;
    }
}
