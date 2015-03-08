// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a;


// Referenced classes of package org.a.a.a.a:
//            b

public final class d extends b
{

    public d()
    {
    }

    protected final int a(byte abyte0[], int i)
    {
        if ((0xff & abyte0[i]) == 130)
        {
            int j = 0xff & abyte0[i + 1];
            if (j >= 159 && j <= 241)
            {
                return j - 159;
            }
        }
        return -1;
    }
}
