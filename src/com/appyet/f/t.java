// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;


// Referenced classes of package com.appyet.f:
//            u

final class t
{

    private transient u a[];
    private transient int b;
    private int c;
    private float d;

    public t()
    {
        this((byte)0);
    }

    private t(byte byte0)
    {
        d = 0.75F;
        a = new u[20];
        c = 15;
    }

    public final Object a(int i, Object obj)
    {
        u au[] = a;
        int j = (i & 0x7fffffff) % au.length;
        for (u u1 = au[j]; u1 != null; u1 = u1.d)
        {
            if (u1.a == i)
            {
                Object obj1 = u1.c;
                u1.c = obj;
                return obj1;
            }
        }

        if (b >= c)
        {
            int k = a.length;
            u au1[] = a;
            int l = 1 + k * 2;
            u au2[] = new u[l];
            c = (int)((float)l * d);
            a = au2;
            do
            {
                int i1 = k - 1;
                if (k <= 0)
                {
                    break;
                }
                u u3;
                for (u u2 = au1[i1]; u2 != null; u2 = u3)
                {
                    u3 = u2.d;
                    int j1 = (0x7fffffff & u2.a) % l;
                    u2.d = au2[j1];
                    au2[j1] = u2;
                }

                k = i1;
            } while (true);
            au = a;
            j = (i & 0x7fffffff) % au.length;
        }
        au[j] = new u(i, i, obj, au[j]);
        b = 1 + b;
        return null;
    }
}
