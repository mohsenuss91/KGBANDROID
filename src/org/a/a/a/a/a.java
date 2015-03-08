// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a;


// Referenced classes of package org.a.a.a.a:
//            b

public final class a extends b
{

    public a()
    {
    }

    protected final int a(byte abyte0[], int i)
    {
        if ((0xff & abyte0[i]) == 164)
        {
            int j = 0xff & abyte0[i + 1];
            if (j >= 161 && j <= 243)
            {
                return j - 161;
            }
        }
        return -1;
    }
}
