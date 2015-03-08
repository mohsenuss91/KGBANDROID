// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a;

import java.nio.ByteBuffer;
import org.a.a.b;

// Referenced classes of package org.a.a.a:
//            b, c

public final class j extends org.a.a.a.b
{

    private static final byte d[] = {
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 
        2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 
        2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 
        2, 1, 1, 1, 1, 1, 1, 3, 3, 3, 
        3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 
        3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 
        3, 3, 3, 1, 1, 1, 1, 1, 1, 0, 
        1, 7, 1, 1, 1, 1, 1, 1, 5, 1, 
        5, 0, 5, 0, 0, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 7, 1, 7, 0, 7, 5, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 4, 4, 4, 4, 4, 4, 5, 5, 
        4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 
        4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 
        4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 
        7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 
        7, 7, 6, 6, 6, 6, 6, 1, 6, 6, 
        6, 6, 6, 7, 7, 7
    };
    private static final byte e[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 
        3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 
        3, 3, 3, 3, 0, 3, 3, 3, 1, 1, 
        3, 3, 0, 3, 3, 3, 1, 2, 1, 2, 
        0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 
        1, 3, 1, 1, 1, 3, 0, 3, 1, 3, 
        1, 1, 3, 3
    };
    private c a;
    private byte b;
    private int c[];

    public j()
    {
        c = new int[4];
        d();
    }

    public final String a()
    {
        return b.r;
    }

    public final c a(byte abyte0[], int i)
    {
        int k = 0;
        ByteBuffer bytebuffer = ByteBuffer.allocate(i);
        int l = i + 0;
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;
        while (i1 < l) 
        {
            byte byte2 = abyte0[i1];
            if (byte2 == 62)
            {
                flag = false;
            } else
            if (byte2 == 60)
            {
                flag = true;
            }
            if (org.a.a.a.b.a(byte2) && org.a.a.a.b.b(byte2))
            {
                if (i1 > j1 && !flag)
                {
                    bytebuffer.put(abyte0, j1, i1 - j1);
                    bytebuffer.put((byte)32);
                }
                j1 = i1 + 1;
            }
            i1++;
        }
        if (!flag && i1 > j1)
        {
            bytebuffer.put(abyte0, j1, i1 - j1);
        }
        byte abyte1[] = bytebuffer.array();
        int k1 = bytebuffer.position();
        do
        {
            byte byte0;
            byte byte1;
label0:
            {
                if (k < k1)
                {
                    int l1 = 0xff & abyte1[k];
                    byte0 = d[l1];
                    byte1 = e[byte0 + 8 * b];
                    if (byte1 != 0)
                    {
                        break label0;
                    }
                    a = c.c;
                }
                return a;
            }
            int ai[] = c;
            ai[byte1] = 1 + ai[byte1];
            b = byte0;
            k++;
        } while (true);
    }

    public final float b()
    {
        int i = 0;
        if (a == c.c)
        {
            return 0.01F;
        }
        for (int k = 0; k < c.length; k++)
        {
            i += c[k];
        }

        float f;
        if (i <= 0)
        {
            f = 0.0F;
        } else
        {
            f = (1.0F * (float)c[3]) / (float)i - (20F * (float)c[1]) / (float)i;
        }
        if (f < 0.0F)
        {
            f = 0.0F;
        }
        return f * 0.5F;
    }

    public final c c()
    {
        return a;
    }

    public final void d()
    {
        a = c.a;
        b = 1;
        for (int i = 0; i < c.length; i++)
        {
            c[i] = 0;
        }

    }

}
