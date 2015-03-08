// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.d;

import java.security.MessageDigest;

public final class e
{

    public static String a(String s)
    {
        String s1;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes("iso-8859-1"), 0, s.length());
            s1 = b(messagedigest.digest());
        }
        catch (Exception exception)
        {
            return null;
        }
        return s1;
    }

    public static String a(byte abyte0[])
    {
        String s;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte0, 0, abyte0.length);
            s = b(messagedigest.digest());
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    private static String b(byte abyte0[])
    {
        StringBuffer stringbuffer;
        int i;
        stringbuffer = new StringBuffer();
        i = 0;
_L2:
        int j;
        int k;
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        j = 0xf & abyte0[i] >>> 4;
        k = 0;
_L3:
        int l;
        int i1;
        if (j >= 0 && j <= 9)
        {
            stringbuffer.append((char)(j + 48));
        } else
        {
            stringbuffer.append((char)(97 + (j - 10)));
        }
        l = 0xf & abyte0[i];
        i1 = k + 1;
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return stringbuffer.toString();
        k = i1;
        j = l;
          goto _L3
    }
}
