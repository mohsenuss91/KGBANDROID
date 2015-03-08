// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, md, ma, lz, 
//            mf

public final class iN extends mb
{

    private static volatile viewId Uw[];
    public String Ux;
    public String Uy;
    public int viewId;

    public static iN[] iM()
    {
        if (Uw == null)
        {
            synchronized (md.amX)
            {
                if (Uw == null)
                {
                    Uw = new Uw[0];
                }
            }
        }
        return Uw;
    }

    public final void a(ma ma1)
    {
        if (!Ux.equals(""))
        {
            ma1.b(1, Ux);
        }
        if (!Uy.equals(""))
        {
            ma1.b(2, Uy);
        }
        if (viewId != 0)
        {
            ma1.p(3, viewId);
        }
        super.a(ma1);
    }

    public final mf b(lz lz1)
    {
        return o(lz1);
    }

    protected final int c()
    {
        int i = super.c();
        if (!Ux.equals(""))
        {
            i += ma.h(1, Ux);
        }
        if (!Uy.equals(""))
        {
            i += ma.h(2, Uy);
        }
        if (viewId != 0)
        {
            i += ma.r(3, viewId);
        }
        return i;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof viewId))
            {
                return false;
            }
            viewId viewid = (viewId)obj;
            if (Ux == null)
            {
                if (viewid.Ux != null)
                {
                    return false;
                }
            } else
            if (!Ux.equals(viewid.Ux))
            {
                return false;
            }
            if (Uy == null)
            {
                if (viewid.Uy != null)
                {
                    return false;
                }
            } else
            if (!Uy.equals(viewid.Uy))
            {
                return false;
            }
            if (viewId != viewid.viewId)
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (viewid.amU != null && !viewid.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(viewid.amU);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int i;
        int j;
        int k;
        int l;
        List list;
        int i1;
        if (Ux == null)
        {
            i = 0;
        } else
        {
            i = Ux.hashCode();
        }
        j = 31 * (i + 527);
        if (Uy == null)
        {
            k = 0;
        } else
        {
            k = Uy.hashCode();
        }
        l = 31 * (31 * (k + j) + viewId);
        list = amU;
        i1 = 0;
        if (list != null)
        {
            boolean flag = amU.isEmpty();
            i1 = 0;
            if (!flag)
            {
                i1 = amU.hashCode();
            }
        }
        return l + i1;
    }

    public final amU iN()
    {
        Ux = "";
        Uy = "";
        viewId = 0;
        amU = null;
        amY = -1;
        return this;
    }

    public final amY o(lz lz1)
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
                Ux = lz1.readString();
                break;

            case 18: // '\022'
                Uy = lz1.readString();
                break;

            case 24: // '\030'
                viewId = lz1.nz();
                break;
            }
        } while (true);
    }

    public ()
    {
        iN();
    }
}
