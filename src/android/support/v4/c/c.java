// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.c;


final class c
{

    static final int a[] = new int[0];
    static final long b[] = new long[0];
    static final Object c[] = new Object[0];

    public static int a(int i)
    {
        int j = i * 4;
        int k = 4;
        do
        {
label0:
            {
                if (k < 32)
                {
                    if (j > -12 + (1 << k))
                    {
                        break label0;
                    }
                    j = -12 + (1 << k);
                }
                return j / 4;
            }
            k++;
        } while (true);
    }

    static int a(int ai[], int i, int j)
    {
        int i1;
label0:
        {
            int k = i - 1;
            int l;
            for (l = 0; l <= k;)
            {
                i1 = l + k >>> 1;
                int j1 = ai[i1];
                if (j1 < j)
                {
                    l = i1 + 1;
                } else
                {
                    if (j1 <= j)
                    {
                        break label0;
                    }
                    k = i1 - 1;
                }
            }

            i1 = ~l;
        }
        return i1;
    }

    public static boolean a(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

}
