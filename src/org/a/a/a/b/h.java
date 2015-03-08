// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.b;


// Referenced classes of package org.a.a.a.b:
//            g

public final class h extends g
{

    public h()
    {
    }

    protected final int a(byte abyte0[], int i)
    {
        int j = 0xff & abyte0[i];
        int k;
        int l;
        int i1;
        if (j >= 129 && j <= 159)
        {
            k = 188 * (j - 129);
        } else
        if (j >= 224 && j <= 239)
        {
            k = 188 * (31 + (j - 224));
        } else
        {
            return -1;
        }
        l = 0xff & abyte0[i + 1];
        i1 = k + (l - 64);
        if (l >= 128)
        {
            i1--;
        }
        return i1;
    }
}
