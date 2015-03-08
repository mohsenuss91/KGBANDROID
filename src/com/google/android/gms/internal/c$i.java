// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, md, ma, lz, 
//            mf

public final class p extends mb
{

    private static volatile amY fG[];
    public amY fH;
    public amY fI;
    public String name;

    public static p[] o()
    {
        if (fG == null)
        {
            synchronized (md.amX)
            {
                if (fG == null)
                {
                    fG = new fG[0];
                }
            }
        }
        return fG;
    }

    public final void a(ma ma1)
    {
        if (!name.equals(""))
        {
            ma1.b(1, name);
        }
        if (fH != null)
        {
            ma1.a(2, fH);
        }
        if (fI != null)
        {
            ma1.a(3, fI);
        }
        super.a(ma1);
    }

    public final mf b(lz lz1)
    {
        return j(lz1);
    }

    protected final int c()
    {
        int i = super.c();
        if (!name.equals(""))
        {
            i += ma.h(1, name);
        }
        if (fH != null)
        {
            i += ma.b(2, fH);
        }
        if (fI != null)
        {
            i += ma.b(3, fI);
        }
        return i;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof fI))
            {
                return false;
            }
            fI fi = (fI)obj;
            if (name == null)
            {
                if (fi.name != null)
                {
                    return false;
                }
            } else
            if (!name.equals(fi.name))
            {
                return false;
            }
            if (fH == null)
            {
                if (fi.fH != null)
                {
                    return false;
                }
            } else
            if (!fH.equals(fi.fH))
            {
                return false;
            }
            if (fI == null)
            {
                if (fi.fI != null)
                {
                    return false;
                }
            } else
            if (!fI.equals(fi.fI))
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (fi.amU != null && !fi.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(fi.amU);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int i;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        List list;
        int l1;
        if (name == null)
        {
            i = 0;
        } else
        {
            i = name.hashCode();
        }
        k = 31 * (i + 527);
        if (fH == null)
        {
            l = 0;
        } else
        {
            l = fH.hashCode();
        }
        i1 = 31 * (l + k);
        if (fI == null)
        {
            j1 = 0;
        } else
        {
            j1 = fI.hashCode();
        }
        k1 = 31 * (j1 + i1);
        list = amU;
        l1 = 0;
        if (list != null)
        {
            boolean flag = amU.isEmpty();
            l1 = 0;
            if (!flag)
            {
                l1 = amU.hashCode();
            }
        }
        return k1 + l1;
    }

    public final amU j(lz lz1)
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
                name = lz1.readString();
                break;

            case 18: // '\022'
                if (fH == null)
                {
                    fH = new <init>();
                }
                lz1.a(fH);
                break;

            case 26: // '\032'
                if (fI == null)
                {
                    fI = new <init>();
                }
                lz1.a(fI);
                break;
            }
        } while (true);
    }

    public final fI p()
    {
        name = "";
        fH = null;
        fI = null;
        amU = null;
        amY = -1;
        return this;
    }

    public ()
    {
        p();
    }
}
