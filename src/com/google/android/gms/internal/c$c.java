// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, md, ma, lz, 
//            mf

public final class g extends mb
{

    private static volatile amU eL[];
    public String eM;
    public long eN;
    public long eO;
    public boolean eP;
    public long eQ;

    public static g[] f()
    {
        if (eL == null)
        {
            synchronized (md.amX)
            {
                if (eL == null)
                {
                    eL = new eL[0];
                }
            }
        }
        return eL;
    }

    public final void a(ma ma1)
    {
        if (!eM.equals(""))
        {
            ma1.b(1, eM);
        }
        if (eN != 0L)
        {
            ma1.b(2, eN);
        }
        if (eO != 0x7fffffffL)
        {
            ma1.b(3, eO);
        }
        if (eP)
        {
            ma1.a(4, eP);
        }
        if (eQ != 0L)
        {
            ma1.b(5, eQ);
        }
        super.a(ma1);
    }

    public final mf b(lz lz1)
    {
        return d(lz1);
    }

    protected final int c()
    {
        int i = super.c();
        if (!eM.equals(""))
        {
            i += ma.h(1, eM);
        }
        if (eN != 0L)
        {
            i += ma.d(2, eN);
        }
        if (eO != 0x7fffffffL)
        {
            i += ma.d(3, eO);
        }
        if (eP)
        {
            i += ma.b(4, eP);
        }
        if (eQ != 0L)
        {
            i += ma.d(5, eQ);
        }
        return i;
    }

    public final eQ d(lz lz1)
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
                eM = lz1.readString();
                break;

            case 16: // '\020'
                eN = lz1.ny();
                break;

            case 24: // '\030'
                eO = lz1.ny();
                break;

            case 32: // ' '
                eP = lz1.nA();
                break;

            case 40: // '('
                eQ = lz1.ny();
                break;
            }
        } while (true);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof y))
            {
                return false;
            }
            y y = (y)obj;
            if (eM == null)
            {
                if (y.eM != null)
                {
                    return false;
                }
            } else
            if (!eM.equals(y.eM))
            {
                return false;
            }
            if (eN != y.eN)
            {
                return false;
            }
            if (eO != y.eO)
            {
                return false;
            }
            if (eP != y.eP)
            {
                return false;
            }
            if (eQ != y.eQ)
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (y.amU != null && !y.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(y.amU);
            }
        }
        return true;
    }

    public final amU g()
    {
        eM = "";
        eN = 0L;
        eO = 0x7fffffffL;
        eP = false;
        eQ = 0L;
        amU = null;
        amY = -1;
        return this;
    }

    public final int hashCode()
    {
        int i;
        int j;
        char c1;
        int k;
        List list;
        int l;
        if (eM == null)
        {
            i = 0;
        } else
        {
            i = eM.hashCode();
        }
        j = 31 * (31 * (31 * (i + 527) + (int)(eN ^ eN >>> 32)) + (int)(eO ^ eO >>> 32));
        if (eP)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        k = 31 * (31 * (c1 + j) + (int)(eQ ^ eQ >>> 32));
        list = amU;
        l = 0;
        if (list != null)
        {
            boolean flag = amU.isEmpty();
            l = 0;
            if (!flag)
            {
                l = amU.hashCode();
            }
        }
        return k + l;
    }

    public ()
    {
        g();
    }
}
