// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, md, ma, lz, 
//            mf

public final class ns extends mb
{

    private static volatile amq amp[];
    public a amq;
    public String name;

    public static ns[] nr()
    {
        if (amp == null)
        {
            synchronized (md.amX)
            {
                if (amp == null)
                {
                    amp = new amp[0];
                }
            }
        }
        return amp;
    }

    public final void a(ma ma1)
    {
        ma1.b(1, name);
        if (amq != null)
        {
            ma1.a(2, amq);
        }
        super.a(ma1);
    }

    public final mf b(lz lz1)
    {
        return r(lz1);
    }

    protected final int c()
    {
        int i = super.c() + ma.h(1, name);
        if (amq != null)
        {
            i += ma.b(2, amq);
        }
        return i;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof a.nu))
            {
                return false;
            }
            a.nu nu = (a.nu)obj;
            if (name == null)
            {
                if (nu.name != null)
                {
                    return false;
                }
            } else
            if (!name.equals(nu.name))
            {
                return false;
            }
            class a extends mb
            {

                private static volatile a amr[];
                public a ams;
                public int type;

                public static a[] nt()
                {
                    if (amr == null)
                    {
                        synchronized (md.amX)
                        {
                            if (amr == null)
                            {
                                amr = new a[0];
                            }
                        }
                    }
                    return amr;
                }

                public final void a(ma ma1)
                {
                    ma1.p(1, type);
                    if (ams != null)
                    {
                        ma1.a(2, ams);
                    }
                    super.a(ma1);
                }

                public final mf b(lz lz1)
                {
                    return s(lz1);
                }

                protected final int c()
                {
                    int i = super.c() + ma.r(1, type);
                    if (ams != null)
                    {
                        i += ma.b(2, ams);
                    }
                    return i;
                }

                public final boolean equals(Object obj1)
                {
                    if (obj1 != this)
                    {
                        if (!(obj1 instanceof a))
                        {
                            return false;
                        }
                        a a1 = (a)obj1;
                        if (type != a1.type)
                        {
                            return false;
                        }
                        class a extends mb
                        {

                            public boolean amA;
                            public lx.a amB[];
                            public a amC[];
                            public String amD[];
                            public long amE[];
                            public float amF[];
                            public long amG;
                            public byte amt[];
                            public String amu;
                            public double amv;
                            public float amw;
                            public long amx;
                            public int amy;
                            public int amz;

                            public final void a(ma ma1)
                            {
                                if (!Arrays.equals(amt, mi.anh))
                                {
                                    ma1.a(1, amt);
                                }
                                if (!amu.equals(""))
                                {
                                    ma1.b(2, amu);
                                }
                                if (Double.doubleToLongBits(amv) != Double.doubleToLongBits(0.0D))
                                {
                                    ma1.a(3, amv);
                                }
                                if (Float.floatToIntBits(amw) != Float.floatToIntBits(0.0F))
                                {
                                    ma1.b(4, amw);
                                }
                                if (amx != 0L)
                                {
                                    ma1.b(5, amx);
                                }
                                if (amy != 0)
                                {
                                    ma1.p(6, amy);
                                }
                                if (amz != 0)
                                {
                                    ma1.q(7, amz);
                                }
                                if (amA)
                                {
                                    ma1.a(8, amA);
                                }
                                if (amB != null && amB.length > 0)
                                {
                                    for (int j1 = 0; j1 < amB.length; j1++)
                                    {
                                        lx.a a3 = amB[j1];
                                        if (a3 != null)
                                        {
                                            ma1.a(9, a3);
                                        }
                                    }

                                }
                                if (amC != null && amC.length > 0)
                                {
                                    for (int i1 = 0; i1 < amC.length; i1++)
                                    {
                                        a a2 = amC[i1];
                                        if (a2 != null)
                                        {
                                            ma1.a(10, a2);
                                        }
                                    }

                                }
                                if (amD != null && amD.length > 0)
                                {
                                    for (int l = 0; l < amD.length; l++)
                                    {
                                        String s1 = amD[l];
                                        if (s1 != null)
                                        {
                                            ma1.b(11, s1);
                                        }
                                    }

                                }
                                if (amE != null && amE.length > 0)
                                {
                                    for (int k = 0; k < amE.length; k++)
                                    {
                                        ma1.b(12, amE[k]);
                                    }

                                }
                                if (amG != 0L)
                                {
                                    ma1.b(13, amG);
                                }
                                if (amF != null)
                                {
                                    int i = amF.length;
                                    int j = 0;
                                    if (i > 0)
                                    {
                                        for (; j < amF.length; j++)
                                        {
                                            ma1.b(14, amF[j]);
                                        }

                                    }
                                }
                                super.a(ma1);
                            }

                            public final mf b(lz lz1)
                            {
                                return t(lz1);
                            }

                            protected final int c()
                            {
                                int i = 0;
                                int j = super.c();
                                if (!Arrays.equals(amt, mi.anh))
                                {
                                    j += ma.b(1, amt);
                                }
                                if (!amu.equals(""))
                                {
                                    j += ma.h(2, amu);
                                }
                                if (Double.doubleToLongBits(amv) != Double.doubleToLongBits(0.0D))
                                {
                                    j += ma.b(3, amv);
                                }
                                if (Float.floatToIntBits(amw) != Float.floatToIntBits(0.0F))
                                {
                                    j += ma.c(4, amw);
                                }
                                if (amx != 0L)
                                {
                                    j += ma.d(5, amx);
                                }
                                if (amy != 0)
                                {
                                    j += ma.r(6, amy);
                                }
                                if (amz != 0)
                                {
                                    j += ma.s(7, amz);
                                }
                                if (amA)
                                {
                                    j += ma.b(8, amA);
                                }
                                if (amB != null && amB.length > 0)
                                {
                                    int i2 = j;
                                    for (int j2 = 0; j2 < amB.length; j2++)
                                    {
                                        lx.a a3 = amB[j2];
                                        if (a3 != null)
                                        {
                                            i2 += ma.b(9, a3);
                                        }
                                    }

                                    j = i2;
                                }
                                if (amC != null && amC.length > 0)
                                {
                                    int k1 = j;
                                    for (int l1 = 0; l1 < amC.length; l1++)
                                    {
                                        a a2 = amC[l1];
                                        if (a2 != null)
                                        {
                                            k1 += ma.b(10, a2);
                                        }
                                    }

                                    j = k1;
                                }
                                if (amD != null && amD.length > 0)
                                {
                                    int l = 0;
                                    int i1 = 0;
                                    int j1 = 0;
                                    for (; l < amD.length; l++)
                                    {
                                        String s1 = amD[l];
                                        if (s1 != null)
                                        {
                                            j1++;
                                            i1 += ma.cz(s1);
                                        }
                                    }

                                    j = j + i1 + j1 * 1;
                                }
                                if (amE != null && amE.length > 0)
                                {
                                    int k = 0;
                                    for (; i < amE.length; i++)
                                    {
                                        k += ma.D(amE[i]);
                                    }

                                    j = j + k + 1 * amE.length;
                                }
                                if (amG != 0L)
                                {
                                    j += ma.d(13, amG);
                                }
                                if (amF != null && amF.length > 0)
                                {
                                    j = j + 4 * amF.length + 1 * amF.length;
                                }
                                return j;
                            }

                            public final boolean equals(Object obj2)
                            {
                                if (obj2 != this)
                                {
                                    if (!(obj2 instanceof a))
                                    {
                                        return false;
                                    }
                                    a a2 = (a)obj2;
                                    if (!Arrays.equals(amt, a2.amt))
                                    {
                                        return false;
                                    }
                                    if (amu == null)
                                    {
                                        if (a2.amu != null)
                                        {
                                            return false;
                                        }
                                    } else
                                    if (!amu.equals(a2.amu))
                                    {
                                        return false;
                                    }
                                    if (Double.doubleToLongBits(amv) != Double.doubleToLongBits(a2.amv))
                                    {
                                        return false;
                                    }
                                    if (Float.floatToIntBits(amw) != Float.floatToIntBits(a2.amw))
                                    {
                                        return false;
                                    }
                                    if (amx != a2.amx)
                                    {
                                        return false;
                                    }
                                    if (amy != a2.amy)
                                    {
                                        return false;
                                    }
                                    if (amz != a2.amz)
                                    {
                                        return false;
                                    }
                                    if (amA != a2.amA)
                                    {
                                        return false;
                                    }
                                    if (!md.equals(amB, a2.amB))
                                    {
                                        return false;
                                    }
                                    if (!md.equals(amC, a2.amC))
                                    {
                                        return false;
                                    }
                                    if (!md.equals(amD, a2.amD))
                                    {
                                        return false;
                                    }
                                    if (!md.equals(amE, a2.amE))
                                    {
                                        return false;
                                    }
                                    if (!md.equals(amF, a2.amF))
                                    {
                                        return false;
                                    }
                                    if (amG != a2.amG)
                                    {
                                        return false;
                                    }
                                    if (amU == null || amU.isEmpty())
                                    {
                                        if (a2.amU != null && !a2.amU.isEmpty())
                                        {
                                            return false;
                                        }
                                    } else
                                    {
                                        return amU.equals(a2.amU);
                                    }
                                }
                                return true;
                            }

                            public final int hashCode()
                            {
                                int i = 31 * (527 + Arrays.hashCode(amt));
                                int j;
                                int k;
                                long l;
                                int i1;
                                char c1;
                                int j1;
                                List list;
                                int k1;
                                if (amu == null)
                                {
                                    j = 0;
                                } else
                                {
                                    j = amu.hashCode();
                                }
                                k = j + i;
                                l = Double.doubleToLongBits(amv);
                                i1 = 31 * (31 * (31 * (31 * (31 * (k * 31 + (int)(l ^ l >>> 32)) + Float.floatToIntBits(amw)) + (int)(amx ^ amx >>> 32)) + amy) + amz);
                                if (amA)
                                {
                                    c1 = '\u04CF';
                                } else
                                {
                                    c1 = '\u04D5';
                                }
                                j1 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (c1 + i1) + md.hashCode(amB)) + md.hashCode(amC)) + md.hashCode(amD)) + md.hashCode(amE)) + md.hashCode(amF)) + (int)(amG ^ amG >>> 32));
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

                            public final a nv()
                            {
                                amt = mi.anh;
                                amu = "";
                                amv = 0.0D;
                                amw = 0.0F;
                                amx = 0L;
                                amy = 0;
                                amz = 0;
                                amA = false;
                                amB = lx.a.nr();
                                amC = a.nt();
                                amD = mi.anf;
                                amE = mi.anb;
                                amF = mi.anc;
                                amG = 0L;
                                amU = null;
                                amY = -1;
                                return this;
                            }

                            public final a t(lz lz1)
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
                                        amt = lz1.readBytes();
                                        break;

                                    case 18: // '\022'
                                        amu = lz1.readString();
                                        break;

                                    case 25: // '\031'
                                        amv = lz1.readDouble();
                                        break;

                                    case 37: // '%'
                                        amw = lz1.readFloat();
                                        break;

                                    case 40: // '('
                                        amx = lz1.ny();
                                        break;

                                    case 48: // '0'
                                        amy = lz1.nz();
                                        break;

                                    case 56: // '8'
                                        amz = lz1.nB();
                                        break;

                                    case 64: // '@'
                                        amA = lz1.nA();
                                        break;

                                    case 74: // 'J'
                                        int j4 = mi.b(lz1, 74);
                                        int k4;
                                        lx.a aa1[];
                                        if (amB == null)
                                        {
                                            k4 = 0;
                                        } else
                                        {
                                            k4 = amB.length;
                                        }
                                        aa1 = new lx.a[j4 + k4];
                                        if (k4 != 0)
                                        {
                                            System.arraycopy(amB, 0, aa1, 0, k4);
                                        }
                                        for (; k4 < -1 + aa1.length; k4++)
                                        {
                                            aa1[k4] = new lx.a();
                                            lz1.a(aa1[k4]);
                                            lz1.nw();
                                        }

                                        aa1[k4] = new lx.a();
                                        lz1.a(aa1[k4]);
                                        amB = aa1;
                                        break;

                                    case 82: // 'R'
                                        int l3 = mi.b(lz1, 82);
                                        int i4;
                                        a aa[];
                                        if (amC == null)
                                        {
                                            i4 = 0;
                                        } else
                                        {
                                            i4 = amC.length;
                                        }
                                        aa = new a[l3 + i4];
                                        if (i4 != 0)
                                        {
                                            System.arraycopy(amC, 0, aa, 0, i4);
                                        }
                                        for (; i4 < -1 + aa.length; i4++)
                                        {
                                            aa[i4] = new a();
                                            lz1.a(aa[i4]);
                                            lz1.nw();
                                        }

                                        aa[i4] = new a();
                                        lz1.a(aa[i4]);
                                        amC = aa;
                                        break;

                                    case 90: // 'Z'
                                        int j3 = mi.b(lz1, 90);
                                        int k3;
                                        String as[];
                                        if (amD == null)
                                        {
                                            k3 = 0;
                                        } else
                                        {
                                            k3 = amD.length;
                                        }
                                        as = new String[j3 + k3];
                                        if (k3 != 0)
                                        {
                                            System.arraycopy(amD, 0, as, 0, k3);
                                        }
                                        for (; k3 < -1 + as.length; k3++)
                                        {
                                            as[k3] = lz1.readString();
                                            lz1.nw();
                                        }

                                        as[k3] = lz1.readString();
                                        amD = as;
                                        break;

                                    case 96: // '`'
                                        int l2 = mi.b(lz1, 96);
                                        int i3;
                                        long al1[];
                                        if (amE == null)
                                        {
                                            i3 = 0;
                                        } else
                                        {
                                            i3 = amE.length;
                                        }
                                        al1 = new long[l2 + i3];
                                        if (i3 != 0)
                                        {
                                            System.arraycopy(amE, 0, al1, 0, i3);
                                        }
                                        for (; i3 < -1 + al1.length; i3++)
                                        {
                                            al1[i3] = lz1.ny();
                                            lz1.nw();
                                        }

                                        al1[i3] = lz1.ny();
                                        amE = al1;
                                        break;

                                    case 98: // 'b'
                                        int l1 = lz1.ex(lz1.nD());
                                        int i2 = lz1.getPosition();
                                        int j2;
                                        for (j2 = 0; lz1.nI() > 0; j2++)
                                        {
                                            lz1.ny();
                                        }

                                        lz1.ez(i2);
                                        int k2;
                                        long al[];
                                        if (amE == null)
                                        {
                                            k2 = 0;
                                        } else
                                        {
                                            k2 = amE.length;
                                        }
                                        al = new long[j2 + k2];
                                        if (k2 != 0)
                                        {
                                            System.arraycopy(amE, 0, al, 0, k2);
                                        }
                                        for (; k2 < al.length; k2++)
                                        {
                                            al[k2] = lz1.ny();
                                        }

                                        amE = al;
                                        lz1.ey(l1);
                                        break;

                                    case 104: // 'h'
                                        amG = lz1.ny();
                                        break;

                                    case 117: // 'u'
                                        int j1 = mi.b(lz1, 117);
                                        int k1;
                                        float af1[];
                                        if (amF == null)
                                        {
                                            k1 = 0;
                                        } else
                                        {
                                            k1 = amF.length;
                                        }
                                        af1 = new float[j1 + k1];
                                        if (k1 != 0)
                                        {
                                            System.arraycopy(amF, 0, af1, 0, k1);
                                        }
                                        for (; k1 < -1 + af1.length; k1++)
                                        {
                                            af1[k1] = lz1.readFloat();
                                            lz1.nw();
                                        }

                                        af1[k1] = lz1.readFloat();
                                        amF = af1;
                                        break;

                                    case 114: // 'r'
                                        int j = lz1.nD();
                                        int k = lz1.ex(j);
                                        int l = j / 4;
                                        int i1;
                                        float af[];
                                        if (amF == null)
                                        {
                                            i1 = 0;
                                        } else
                                        {
                                            i1 = amF.length;
                                        }
                                        af = new float[l + i1];
                                        if (i1 != 0)
                                        {
                                            System.arraycopy(amF, 0, af, 0, i1);
                                        }
                                        for (; i1 < af.length; i1++)
                                        {
                                            af[i1] = lz1.readFloat();
                                        }

                                        amF = af;
                                        lz1.ey(k);
                                        break;
                                    }
                                } while (true);
                            }

                            public a()
                            {
                                nv();
                            }
                        }

                        if (ams == null)
                        {
                            if (a1.ams != null)
                            {
                                return false;
                            }
                        } else
                        if (!ams.equals(a1.ams))
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
                    int i = 31 * (527 + type);
                    int j;
                    int k;
                    List list;
                    int l;
                    if (ams == null)
                    {
                        j = 0;
                    } else
                    {
                        j = ams.hashCode();
                    }
                    k = 31 * (j + i);
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

                public final a nu()
                {
                    type = 1;
                    ams = null;
                    amU = null;
                    amY = -1;
                    return this;
                }

                public final a s(lz lz1)
                {
_L5:
                    int i = lz1.nw();
                    i;
                    JVM INSTR lookupswitch 3: default 40
                //                               0: 49
                //                               8: 51
                //                               18: 143;
                       goto _L1 _L2 _L3 _L4
_L1:
                    if (a(lz1, i)) goto _L5; else goto _L2
_L2:
                    return this;
_L3:
                    int j = lz1.nz();
                    switch (j)
                    {
                    case 1: // '\001'
                    case 2: // '\002'
                    case 3: // '\003'
                    case 4: // '\004'
                    case 5: // '\005'
                    case 6: // '\006'
                    case 7: // '\007'
                    case 8: // '\b'
                    case 9: // '\t'
                    case 10: // '\n'
                    case 11: // '\013'
                    case 12: // '\f'
                    case 13: // '\r'
                    case 14: // '\016'
                    case 15: // '\017'
                        type = j;
                        break;
                    }
                    continue; /* Loop/switch isn't completed */
_L4:
                    if (ams == null)
                    {
                        ams = new a();
                    }
                    lz1.a(ams);
                    if (true) goto _L5; else goto _L6
_L6:
                }

            public a()
            {
                nu();
            }
            }

            if (amq == null)
            {
                if (nu.amq != null)
                {
                    return false;
                }
            } else
            if (!amq.equals(nu.amq))
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (nu.amU != null && !nu.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(nu.amU);
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
        if (name == null)
        {
            i = 0;
        } else
        {
            i = name.hashCode();
        }
        j = 31 * (i + 527);
        if (amq == null)
        {
            k = 0;
        } else
        {
            k = amq.hashCode();
        }
        l = 31 * (k + j);
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

    public final amU ns()
    {
        name = "";
        amq = null;
        amU = null;
        amY = -1;
        return this;
    }

    public final amY r(lz lz1)
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
                if (amq == null)
                {
                    amq = new a();
                }
                lz1.a(amq);
                break;
            }
        } while (true);
    }

    public a()
    {
        ns();
    }
}
