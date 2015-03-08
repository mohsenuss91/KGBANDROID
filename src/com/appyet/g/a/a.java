// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g.a;

import java.util.HashMap;

public final class a
{

    private static final char a[];
    private static final HashMap b;

    private static String a(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(4 * ((2 + abyte0.length) / 3));
        byte abyte1[] = b(abyte0);
        for (int i = 0; i < abyte1.length; i++)
        {
            stringbuilder.append(a[1 + abyte1[i]]);
            if (i % 72 == 71)
            {
                stringbuilder.append("\n");
            }
        }

        return stringbuilder.toString();
    }

    public static String a(Byte abyte[])
    {
        byte abyte0[] = new byte[abyte.length];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = abyte[i].byteValue();
        }

        return a(abyte0);
    }

    public static byte[] a(String s)
    {
        String s1 = s.replaceAll("\\r|\\n", "");
        if (s1.length() % 4 != 0)
        {
            throw new IllegalArgumentException("The length of the input string must be a multiple of four.");
        }
        if (!s1.matches("^[A-Za-z0-9+/]*[=]{0,3}$"))
        {
            throw new IllegalArgumentException("The argument contains illegal characters.");
        }
        byte abyte0[] = new byte[(3 * s1.length()) / 4];
        char ac[] = s1.toCharArray();
        int i = 0;
        int j = 0;
        for (; i < ac.length; i += 4)
        {
            int k = -1 + ((Byte)b.get(Character.valueOf(ac[i]))).byteValue();
            int l = -1 + ((Byte)b.get(Character.valueOf(ac[i + 1]))).byteValue();
            int i1 = -1 + ((Byte)b.get(Character.valueOf(ac[i + 2]))).byteValue();
            int j1 = -1 + ((Byte)b.get(Character.valueOf(ac[i + 3]))).byteValue();
            int k1 = j + 1;
            abyte0[j] = (byte)(k << 2 | l >>> 4);
            int l1 = k1 + 1;
            abyte0[k1] = (byte)((l & 0xf) << 4 | i1 >>> 2);
            j = l1 + 1;
            abyte0[l1] = (byte)((i1 & 3) << 6 | j1 & 0x3f);
        }

        if (s1.endsWith("="))
        {
            byte abyte1[] = new byte[abyte0.length - (s1.length() - s1.indexOf("="))];
            System.arraycopy(abyte0, 0, abyte1, 0, abyte1.length);
            return abyte1;
        } else
        {
            return abyte0;
        }
    }

    public static String b(String s)
    {
        return a(s.getBytes());
    }

    private static byte[] b(byte abyte0[])
    {
        int i = 0;
        byte abyte1[] = new byte[4 * ((2 + abyte0.length) / 3)];
        byte abyte2[] = new byte[3 * ((2 + abyte0.length) / 3)];
        System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
        int j = 0;
        for (; i < abyte2.length; i += 3)
        {
            int l = j + 1;
            abyte1[j] = (byte)((0xff & abyte2[i]) >>> 2);
            int i1 = l + 1;
            abyte1[l] = (byte)((3 & abyte2[i]) << 4 | (0xff & abyte2[i + 1]) >>> 4);
            int j1 = i1 + 1;
            abyte1[i1] = (byte)((0xf & abyte2[i + 1]) << 2 | (0xff & abyte2[i + 2]) >>> 6);
            j = j1 + 1;
            abyte1[j1] = (byte)(0x3f & abyte2[i + 2]);
        }

        for (int k = abyte2.length - abyte0.length; k > 0; k--)
        {
            abyte1[abyte1.length - k] = -1;
        }

        return abyte1;
    }

    static 
    {
        a = "=ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        b = new HashMap();
        for (int i = 0; i < a.length; i++)
        {
            b.put(Character.valueOf(a[i]), Byte.valueOf((byte)i));
        }

    }
}
