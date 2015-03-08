// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, md, ma, lz, 
//            mi, mf

public final class e extends mb
{

    private static volatile amU eG[];
    public int eH[];
    public int eI;
    public boolean eJ;
    public boolean eK;
    public int name;

    public static e[] d()
    {
        if (eG == null)
        {
            synchronized (md.amX)
            {
                if (eG == null)
                {
                    eG = new eG[0];
                }
            }
        }
        return eG;
    }

    public final void a(ma ma1)
    {
        if (eK)
        {
            ma1.a(1, eK);
        }
        ma1.p(2, eI);
        if (eH != null && eH.length > 0)
        {
            for (int i = 0; i < eH.length; i++)
            {
                ma1.p(3, eH[i]);
            }

        }
        if (name != 0)
        {
            ma1.p(4, name);
        }
        if (eJ)
        {
            ma1.a(6, eJ);
        }
        super.a(ma1);
    }

    public final mf b(lz lz1)
    {
        return c(lz1);
    }

    protected final int c()
    {
        int i = 0;
        int j = super.c();
        if (eK)
        {
            j += ma.b(1, eK);
        }
        int k = j + ma.r(2, eI);
        int l;
        if (eH != null && eH.length > 0)
        {
            for (int i1 = 0; i1 < eH.length; i1++)
            {
                i += ma.eE(eH[i1]);
            }

            l = k + i + 1 * eH.length;
        } else
        {
            l = k;
        }
        if (name != 0)
        {
            l += ma.r(4, name);
        }
        if (eJ)
        {
            l += ma.b(6, eJ);
        }
        return l;
    }

    public final eJ c(lz lz1)
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
                eK = lz1.nA();
                break;

            case 16: // '\020'
                eI = lz1.nz();
                break;

            case 24: // '\030'
                int j1 = mi.b(lz1, 24);
                int k1;
                int ai1[];
                if (eH == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = eH.length;
                }
                ai1 = new int[j1 + k1];
                if (k1 != 0)
                {
                    System.arraycopy(eH, 0, ai1, 0, k1);
                }
                for (; k1 < -1 + ai1.length; k1++)
                {
                    ai1[k1] = lz1.nz();
                    lz1.nw();
                }

                ai1[k1] = lz1.nz();
                eH = ai1;
                break;

            case 26: // '\032'
                int j = lz1.ex(lz1.nD());
                int k = lz1.getPosition();
                int l;
                for (l = 0; lz1.nI() > 0; l++)
                {
                    lz1.nz();
                }

                lz1.ez(k);
                int i1;
                int ai[];
                if (eH == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = eH.length;
                }
                ai = new int[l + i1];
                if (i1 != 0)
                {
                    System.arraycopy(eH, 0, ai, 0, i1);
                }
                for (; i1 < ai.length; i1++)
                {
                    ai[i1] = lz1.nz();
                }

                eH = ai;
                lz1.ey(j);
                break;

            case 32: // ' '
                name = lz1.nz();
                break;

            case 48: // '0'
                eJ = lz1.nA();
                break;
            }
        } while (true);
    }

    public final A e()
    {
        eH = mi.ana;
        eI = 0;
        name = 0;
        eJ = false;
        eK = false;
        amU = null;
        amY = -1;
        return this;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof amY))
            {
                return false;
            }
            amY amy = (amY)obj;
            if (!md.equals(eH, amy.eH))
            {
                return false;
            }
            if (eI != amy.eI)
            {
                return false;
            }
            if (name != amy.name)
            {
                return false;
            }
            if (eJ != amy.eJ)
            {
                return false;
            }
            if (eK != amy.eK)
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (amy.amU != null && !amy.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(amy.amU);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        char c1 = '\u04CF';
        int i = 31 * (31 * (31 * (527 + md.hashCode(eH)) + eI) + name);
        char c2;
        int j;
        int k;
        int l;
        if (eJ)
        {
            c2 = c1;
        } else
        {
            c2 = '\u04D5';
        }
        j = 31 * (c2 + i);
        if (!eK)
        {
            c1 = '\u04D5';
        }
        k = 31 * (j + c1);
        if (amU == null || amU.isEmpty())
        {
            l = 0;
        } else
        {
            l = amU.hashCode();
        }
        return l + k;
    }

    public ()
    {
        e();
    }
}
