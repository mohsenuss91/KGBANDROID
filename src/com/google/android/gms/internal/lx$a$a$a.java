// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, mi, ma, md, 
//            lz, mf

public final class nv extends mb
{

    public boolean amA;
    public amF amB[];
    public amF amC[];
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
                nv nv2 = amB[j1];
                if (nv2 != null)
                {
                    ma1.a(9, nv2);
                }
            }

        }
        if (amC != null && amC.length > 0)
        {
            for (int i1 = 0; i1 < amC.length; i1++)
            {
                nv nv1 = amC[i1];
                if (nv1 != null)
                {
                    ma1.a(10, nv1);
                }
            }

        }
        if (amD != null && amD.length > 0)
        {
            for (int l = 0; l < amD.length; l++)
            {
                String s = amD[l];
                if (s != null)
                {
                    ma1.b(11, s);
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
                t t2 = amB[j2];
                if (t2 != null)
                {
                    i2 += ma.b(9, t2);
                }
            }

            j = i2;
        }
        if (amC != null && amC.length > 0)
        {
            int k1 = j;
            for (int l1 = 0; l1 < amC.length; l1++)
            {
                t t1 = amC[l1];
                if (t1 != null)
                {
                    k1 += ma.b(10, t1);
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
                String s = amD[l];
                if (s != null)
                {
                    j1++;
                    i1 += ma.cz(s);
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

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof amF))
            {
                return false;
            }
            amF amf = (amF)obj;
            if (!Arrays.equals(amt, amf.amt))
            {
                return false;
            }
            if (amu == null)
            {
                if (amf.amu != null)
                {
                    return false;
                }
            } else
            if (!amu.equals(amf.amu))
            {
                return false;
            }
            if (Double.doubleToLongBits(amv) != Double.doubleToLongBits(amf.amv))
            {
                return false;
            }
            if (Float.floatToIntBits(amw) != Float.floatToIntBits(amf.amw))
            {
                return false;
            }
            if (amx != amf.amx)
            {
                return false;
            }
            if (amy != amf.amy)
            {
                return false;
            }
            if (amz != amf.amz)
            {
                return false;
            }
            if (amA != amf.amA)
            {
                return false;
            }
            if (!md.equals(amB, amf.amB))
            {
                return false;
            }
            if (!md.equals(amC, amf.amC))
            {
                return false;
            }
            if (!md.equals(amD, amf.amD))
            {
                return false;
            }
            if (!md.equals(amE, amf.amE))
            {
                return false;
            }
            if (!md.equals(amF, amf.amF))
            {
                return false;
            }
            if (amG != amf.amG)
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (amf.amU != null && !amf.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(amf.amU);
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

    public final amU nv()
    {
        amt = mi.anh;
        amu = "";
        amv = 0.0D;
        amw = 0.0F;
        amx = 0L;
        amy = 0;
        amz = 0;
        amA = false;
        amB = amB();
        amC = ();
        amD = mi.anf;
        amE = mi.anb;
        amF = mi.anc;
        amG = 0L;
        amU = null;
        amY = -1;
        return this;
    }

    public final amY t(lz lz1)
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
                amY aamy1[];
                if (amB == null)
                {
                    k4 = 0;
                } else
                {
                    k4 = amB.length;
                }
                aamy1 = new amB[j4 + k4];
                if (k4 != 0)
                {
                    System.arraycopy(amB, 0, aamy1, 0, k4);
                }
                for (; k4 < -1 + aamy1.length; k4++)
                {
                    aamy1[k4] = new t>();
                    lz1.a(aamy1[k4]);
                    lz1.nw();
                }

                aamy1[k4] = new t>();
                lz1.a(aamy1[k4]);
                amB = aamy1;
                break;

            case 82: // 'R'
                int l3 = mi.b(lz1, 82);
                int i4;
                amY aamy[];
                if (amC == null)
                {
                    i4 = 0;
                } else
                {
                    i4 = amC.length;
                }
                aamy = new amC[l3 + i4];
                if (i4 != 0)
                {
                    System.arraycopy(amC, 0, aamy, 0, i4);
                }
                for (; i4 < -1 + aamy.length; i4++)
                {
                    aamy[i4] = new nit>();
                    lz1.a(aamy[i4]);
                    lz1.nw();
                }

                aamy[i4] = new nit>();
                lz1.a(aamy[i4]);
                amC = aamy;
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

    public ()
    {
        nv();
    }
}
