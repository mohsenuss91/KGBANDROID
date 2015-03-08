// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, mf, ma, lz

public final class na extends mb
{

    public long aiD;
    public aiE aiE;
    public aiE fK;

    public static na l(byte abyte0[])
    {
        return (na)mf.a(new <init>(), abyte0);
    }

    public final void a(ma ma1)
    {
        ma1.b(1, aiD);
        if (fK != null)
        {
            ma1.a(2, fK);
        }
        if (aiE != null)
        {
            ma1.a(3, aiE);
        }
        super.a(ma1);
    }

    public final mf b(lz lz1)
    {
        return p(lz1);
    }

    protected final int c()
    {
        int i = super.c() + ma.d(1, aiD);
        if (fK != null)
        {
            i += ma.b(2, fK);
        }
        if (aiE != null)
        {
            i += ma.b(3, aiE);
        }
        return i;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof aiE))
            {
                return false;
            }
            aiE aie = (aiE)obj;
            if (aiD != aie.aiD)
            {
                return false;
            }
            if (fK == null)
            {
                if (aie.fK != null)
                {
                    return false;
                }
            } else
            if (!fK.quals(aie.fK))
            {
                return false;
            }
            if (aiE == null)
            {
                if (aie.aiE != null)
                {
                    return false;
                }
            } else
            if (!aiE.quals(aie.aiE))
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (aie.amU != null && !aie.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(aie.amU);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int i = 31 * (527 + (int)(aiD ^ aiD >>> 32));
        int j;
        int k;
        int i1;
        int j1;
        List list;
        int k1;
        if (fK == null)
        {
            j = 0;
        } else
        {
            j = fK.ashCode();
        }
        k = 31 * (j + i);
        if (aiE == null)
        {
            i1 = 0;
        } else
        {
            i1 = aiE.ashCode();
        }
        j1 = 31 * (i1 + k);
        list = amU;
        k1 = 0;
        if (list != null)
        {
            boolean flag = amU.isEmpty();
            k1 = 0;
            if (!flag)
            {
                k1 = amU.hashCode();
            }
        }
        return j1 + k1;
    }

    public final amU na()
    {
        aiD = 0L;
        fK = null;
        aiE = null;
        amU = null;
        amY = -1;
        return this;
    }

    public final amY p(lz lz1)
    {
        do
        {
            int i = lz1.nw();
            switch (i)
            {
            default:
                if (a(lz1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                aiD = lz1.ny();
                break;

            case 18: // '\022'
                if (fK == null)
                {
                    fK = new init>();
                }
                lz1.a(fK);
                break;

            case 26: // '\032'
                if (aiE == null)
                {
                    aiE = new init>();
                }
                lz1.a(aiE);
                break;
            }
        } while (true);
    }

    public ()
    {
        na();
    }
}
