// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.b;


// Referenced classes of package org.a.a.a.b:
//            g

public final class c extends g
{

    public c()
    {
    }

    protected final int a(byte abyte0[], int i)
    {
        int j = 0xff & abyte0[i];
        if (j >= 161)
        {
            return -161 + ((0xff & abyte0[i + 1]) + 94 * (j - 161));
        } else
        {
            return -1;
        }
    }
}
