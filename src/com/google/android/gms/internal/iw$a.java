// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, ma, md, lz, 
//            mi, mf

public final class iL extends mb
{

    public a Uv[];

    public final void a(ma ma1)
    {
        if (Uv != null && Uv.length > 0)
        {
            for (int i = 0; i < Uv.length; i++)
            {
                a a1 = Uv[i];
                if (a1 != null)
                {
                    ma1.a(1, a1);
                }
            }

        }
        super.a(ma1);
    }

    public final mf b(lz lz1)
    {
        return n(lz1);
    }

    protected final int c()
    {
        int i = super.c();
        if (Uv != null && Uv.length > 0)
        {
            for (int j = 0; j < Uv.length; j++)
            {
                a a1 = Uv[j];
                if (a1 != null)
                {
                    i += ma.b(1, a1);
                }
            }

        }
        return i;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof Uv))
            {
                return false;
            }
            Uv uv = (Uv)obj;
            if (!md.equals(Uv, uv.Uv))
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (uv.amU != null && !uv.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(uv.amU);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int i = 31 * (527 + md.hashCode(Uv));
        int j;
        if (amU == null || amU.isEmpty())
        {
            j = 0;
        } else
        {
            j = amU.hashCode();
        }
        return j + i;
    }

    public final amU iL()
    {
        class a extends mb
        {

            private static volatile a Uw[];
            public String Ux;
            public String Uy;
            public int viewId;

            public static a[] iM()
            {
                if (Uw == null)
                {
                    synchronized (md.amX)
                    {
                        if (Uw == null)
                        {
                            Uw = new a[0];
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
                    if (!(obj instanceof a))
                    {
                        return false;
                    }
                    a a1 = (a)obj;
                    if (Ux == null)
                    {
                        if (a1.Ux != null)
                        {
                            return false;
                        }
                    } else
                    if (!Ux.equals(a1.Ux))
                    {
                        return false;
                    }
                    if (Uy == null)
                    {
                        if (a1.Uy != null)
                        {
                            return false;
                        }
                    } else
                    if (!Uy.equals(a1.Uy))
                    {
                        return false;
                    }
                    if (viewId != a1.viewId)
                    {
                        return false;
                    }
                    if (amU == null || amU.isEmpty())
                    {
                        if (a1.amU != null && !a1.amU.isEmpty())
                        {
                            return false;
                        }
                    } else
                    {
                        return amU.equals(a1.amU);
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

            public final a iN()
            {
                Ux = "";
                Uy = "";
                viewId = 0;
                amU = null;
                amY = -1;
                return this;
            }

            public final a o(lz lz1)
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

            public a()
            {
                iN();
            }
        }

        Uv = a.iM();
        amU = null;
        amY = -1;
        return this;
    }

    public final amY n(lz lz1)
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
                int k;
                a aa[];
                if (Uv == null)
                {
                    k = 0;
                } else
                {
                    k = Uv.length;
                }
                aa = new a[j + k];
                if (k != 0)
                {
                    System.arraycopy(Uv, 0, aa, 0, k);
                }
                for (; k < -1 + aa.length; k++)
                {
                    aa[k] = new a();
                    lz1.a(aa[k]);
                    lz1.nw();
                }

                aa[k] = new a();
                lz1.a(aa[k]);
                Uv = aa;
                break;
            }
        } while (true);
    }

    public a()
    {
        iL();
    }
}
