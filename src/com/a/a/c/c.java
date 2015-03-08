// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.c;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public final class c
{

    public static void a(Closeable closeable)
    {
        try
        {
            closeable.close();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public static void a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[32768];
        do
        {
            int i = inputstream.read(abyte0, 0, 32768);
            if (i != -1)
            {
                outputstream.write(abyte0, 0, i);
            } else
            {
                return;
            }
        } while (true);
    }
}
