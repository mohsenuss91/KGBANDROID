// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import java.io.InputStream;

public class Strings
{

    public Strings()
    {
    }

    public static String fromStream(InputStream inputstream)
    {
        StringBuffer stringbuffer = new StringBuffer();
        byte abyte0[] = new byte[4096];
        int i = 0;
        do
        {
            if (i == -1)
            {
                inputstream.close();
                return stringbuffer.toString();
            }
            stringbuffer.append(new String(abyte0, 0, i));
            i = inputstream.read(abyte0);
        } while (true);
    }

    public static boolean isEmpty(String s)
    {
        while (s == null || s.length() != 0) 
        {
            return false;
        }
        return true;
    }
}
