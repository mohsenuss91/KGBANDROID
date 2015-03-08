// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.a.a;

import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.google.b.a.a:
//            g, a, b, i

public abstract class h
{

    protected int cachedSize;

    public h()
    {
        cachedSize = -1;
    }

    public static final h mergeFrom(h h1, byte abyte0[])
    {
        return mergeFrom(h1, abyte0, 0, abyte0.length);
    }

    public static final h mergeFrom(h h1, byte abyte0[], int j, int k)
    {
        try
        {
            a a1 = a.a(abyte0, j, k);
            h1.mergeFrom(a1);
            a1.a(0);
        }
        catch (g g1)
        {
            throw g1;
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
        return h1;
    }

    public static final boolean messageNanoEquals(h h1, h h2)
    {
        boolean flag;
        if (h1 == h2)
        {
            flag = true;
        } else
        {
            flag = false;
            if (h1 != null)
            {
                flag = false;
                if (h2 != null)
                {
                    Class class1 = h1.getClass();
                    Class class2 = h2.getClass();
                    flag = false;
                    if (class1 == class2)
                    {
                        int j = h1.getSerializedSize();
                        int k = h2.getSerializedSize();
                        flag = false;
                        if (k == j)
                        {
                            byte abyte0[] = new byte[j];
                            byte abyte1[] = new byte[j];
                            toByteArray(h1, abyte0, 0, j);
                            toByteArray(h2, abyte1, 0, j);
                            return Arrays.equals(abyte0, abyte1);
                        }
                    }
                }
            }
        }
        return flag;
    }

    public static final void toByteArray(h h1, byte abyte0[], int j, int k)
    {
        try
        {
            b b1 = b.a(abyte0, j, k);
            h1.writeTo(b1);
            if (b1.a - b1.b != 0)
            {
                throw new IllegalStateException("Did not write as much data as expected.");
            }
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", ioexception);
        }
    }

    public static final byte[] toByteArray(h h1)
    {
        byte abyte0[] = new byte[h1.getSerializedSize()];
        toByteArray(h1, abyte0, 0, abyte0.length);
        return abyte0;
    }

    public int getCachedSize()
    {
        if (cachedSize < 0)
        {
            getSerializedSize();
        }
        return cachedSize;
    }

    public int getSerializedSize()
    {
        cachedSize = 0;
        return 0;
    }

    public abstract h mergeFrom(a a1);

    public String toString()
    {
        return i.a(this);
    }

    public abstract void writeTo(b b1);
}
