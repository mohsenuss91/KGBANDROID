// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, mf, ma, md, 
//            lz, mi

public final class q extends mb
{

    public amY fJ[];
    public amY fK;
    public String fL;

    public static q b(byte abyte0[])
    {
        return (q)mf.a(new <init>(), abyte0);
    }

    public final void a(ma ma1)
    {
        if (fJ != null && fJ.length > 0)
        {
            for (int i = 0; i < fJ.length; i++)
            {
                <init> <init>1 = fJ[i];
                if (<init>1 != null)
                {
                    ma1.a(1, <init>1);
                }
            }

        }
        if (fK != null)
        {
            ma1.a(2, fK);
        }
        if (!fL.equals(""))
        {
            ma1.b(3, fL);
        }
        super.a(ma1);
    }

    public final mf b(lz lz1)
    {
        return k(lz1);
    }

    protected final int c()
    {
        int i = super.c();
        if (fJ != null && fJ.length > 0)
        {
            for (int j = 0; j < fJ.length; j++)
            {
                k k1 = fJ[j];
                if (k1 != null)
                {
                    i += ma.b(1, k1);
                }
            }

        }
        if (fK != null)
        {
            i += ma.b(2, fK);
        }
        if (!fL.equals(""))
        {
            i += ma.h(3, fL);
        }
        return i;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof fL))
            {
                return false;
            }
            fL fl = (fL)obj;
            if (!md.equals(fJ, fl.fJ))
            {
                return false;
            }
            if (fK == null)
            {
                if (fl.fK != null)
                {
                    return false;
                }
            } else
            if (!fK.equals(fl.fK))
            {
                return false;
            }
            if (fL == null)
            {
                if (fl.fL != null)
                {
                    return false;
                }
            } else
            if (!fL.equals(fl.fL))
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (fl.amU != null && !fl.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(fl.amU);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int i = 31 * (527 + md.hashCode(fJ));
        int j;
        int l;
        int i1;
        int j1;
        List list;
        int k1;
        if (fK == null)
        {
            j = 0;
        } else
        {
            j = fK.hashCode();
        }
        l = 31 * (j + i);
        if (fL == null)
        {
            i1 = 0;
        } else
        {
            i1 = fL.hashCode();
        }
        j1 = 31 * (i1 + l);
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

    public final amU k(lz lz1)
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

            case 10: // '\n'
                int j = mi.b(lz1, 10);
                int l;
                amU aamu[];
                if (fJ == null)
                {
                    l = 0;
                } else
                {
                    l = fJ.length;
                }
                aamu = new fJ[j + l];
                if (l != 0)
                {
                    System.arraycopy(fJ, 0, aamu, 0, l);
                }
                for (; l < -1 + aamu.length; l++)
                {
                    aamu[l] = new <init>();
                    lz1.a(aamu[l]);
                    lz1.nw();
                }

                aamu[l] = new <init>();
                lz1.a(aamu[l]);
                fJ = aamu;
                break;

            case 18: // '\022'
                if (fK == null)
                {
                    fK = new <init>();
                }
                lz1.a(fK);
                break;

            case 26: // '\032'
                fL = lz1.readString();
                break;
            }
        } while (true);
    }

    public final eadString q()
    {
        fJ = o();
        fK = null;
        fL = "";
        amU = null;
        amY = -1;
        return this;
    }

    public ()
    {
        q();
    }
}
