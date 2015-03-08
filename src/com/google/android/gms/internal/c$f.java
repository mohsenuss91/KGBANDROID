// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, mf, ma, md, 
//            lz, mi

public final class k extends mb
{

    public String eV[];
    public String eW[];
    public amY eX[];
    public amY eY[];
    public amY eZ[];
    public amY fa[];
    public amY fb[];
    public amY fc[];
    public String fd;
    public String fe;
    public String ff;
    public String fg;
    public amY fh;
    public float fi;
    public boolean fj;
    public String fk[];
    public int fl;

    public static k a(byte abyte0[])
    {
        return (k)mf.a(new <init>(), abyte0);
    }

    public final void a(ma ma1)
    {
        if (eW != null && eW.length > 0)
        {
            for (int k2 = 0; k2 < eW.length; k2++)
            {
                String s2 = eW[k2];
                if (s2 != null)
                {
                    ma1.b(1, s2);
                }
            }

        }
        if (eX != null && eX.length > 0)
        {
            for (int j2 = 0; j2 < eX.length; j2++)
            {
                <init> <init>6 = eX[j2];
                if (<init>6 != null)
                {
                    ma1.a(2, <init>6);
                }
            }

        }
        if (eY != null && eY.length > 0)
        {
            for (int i2 = 0; i2 < eY.length; i2++)
            {
                <init> <init>5 = eY[i2];
                if (<init>5 != null)
                {
                    ma1.a(3, <init>5);
                }
            }

        }
        if (eZ != null && eZ.length > 0)
        {
            for (int l1 = 0; l1 < eZ.length; l1++)
            {
                <init> <init>4 = eZ[l1];
                if (<init>4 != null)
                {
                    ma1.a(4, <init>4);
                }
            }

        }
        if (fa != null && fa.length > 0)
        {
            for (int k1 = 0; k1 < fa.length; k1++)
            {
                <init> <init>3 = fa[k1];
                if (<init>3 != null)
                {
                    ma1.a(5, <init>3);
                }
            }

        }
        if (fb != null && fb.length > 0)
        {
            for (int j1 = 0; j1 < fb.length; j1++)
            {
                <init> <init>2 = fb[j1];
                if (<init>2 != null)
                {
                    ma1.a(6, <init>2);
                }
            }

        }
        if (fc != null && fc.length > 0)
        {
            for (int i1 = 0; i1 < fc.length; i1++)
            {
                <init> <init>1 = fc[i1];
                if (<init>1 != null)
                {
                    ma1.a(7, <init>1);
                }
            }

        }
        if (!fd.equals(""))
        {
            ma1.b(9, fd);
        }
        if (!fe.equals(""))
        {
            ma1.b(10, fe);
        }
        if (!ff.equals("0"))
        {
            ma1.b(12, ff);
        }
        if (!fg.equals(""))
        {
            ma1.b(13, fg);
        }
        if (fh != null)
        {
            ma1.a(14, fh);
        }
        if (Float.floatToIntBits(fi) != Float.floatToIntBits(0.0F))
        {
            ma1.b(15, fi);
        }
        if (fk != null && fk.length > 0)
        {
            for (int l = 0; l < fk.length; l++)
            {
                String s1 = fk[l];
                if (s1 != null)
                {
                    ma1.b(16, s1);
                }
            }

        }
        if (fl != 0)
        {
            ma1.p(17, fl);
        }
        if (fj)
        {
            ma1.a(18, fj);
        }
        if (eV != null)
        {
            int i = eV.length;
            int j = 0;
            if (i > 0)
            {
                for (; j < eV.length; j++)
                {
                    String s = eV[j];
                    if (s != null)
                    {
                        ma1.b(19, s);
                    }
                }

            }
        }
        super.a(ma1);
    }

    public final mf b(lz lz1)
    {
        return g(lz1);
    }

    protected final int c()
    {
        int i = 0;
        int j = super.c();
        int l;
        if (eW != null && eW.length > 0)
        {
            int j5 = 0;
            int k5 = 0;
            int l5 = 0;
            for (; j5 < eW.length; j5++)
            {
                String s2 = eW[j5];
                if (s2 != null)
                {
                    l5++;
                    k5 += ma.cz(s2);
                }
            }

            l = j + k5 + l5 * 1;
        } else
        {
            l = j;
        }
        if (eX != null && eX.length > 0)
        {
            int l4 = l;
            for (int i5 = 0; i5 < eX.length; i5++)
            {
                g g6 = eX[i5];
                if (g6 != null)
                {
                    l4 += ma.b(2, g6);
                }
            }

            l = l4;
        }
        if (eY != null && eY.length > 0)
        {
            int j4 = l;
            for (int k4 = 0; k4 < eY.length; k4++)
            {
                g g5 = eY[k4];
                if (g5 != null)
                {
                    j4 += ma.b(3, g5);
                }
            }

            l = j4;
        }
        if (eZ != null && eZ.length > 0)
        {
            int l3 = l;
            for (int i4 = 0; i4 < eZ.length; i4++)
            {
                g g4 = eZ[i4];
                if (g4 != null)
                {
                    l3 += ma.b(4, g4);
                }
            }

            l = l3;
        }
        if (fa != null && fa.length > 0)
        {
            int j3 = l;
            for (int k3 = 0; k3 < fa.length; k3++)
            {
                g g3 = fa[k3];
                if (g3 != null)
                {
                    j3 += ma.b(5, g3);
                }
            }

            l = j3;
        }
        if (fb != null && fb.length > 0)
        {
            int l2 = l;
            for (int i3 = 0; i3 < fb.length; i3++)
            {
                g g2 = fb[i3];
                if (g2 != null)
                {
                    l2 += ma.b(6, g2);
                }
            }

            l = l2;
        }
        if (fc != null && fc.length > 0)
        {
            int j2 = l;
            for (int k2 = 0; k2 < fc.length; k2++)
            {
                g g1 = fc[k2];
                if (g1 != null)
                {
                    j2 += ma.b(7, g1);
                }
            }

            l = j2;
        }
        if (!fd.equals(""))
        {
            l += ma.h(9, fd);
        }
        if (!fe.equals(""))
        {
            l += ma.h(10, fe);
        }
        if (!ff.equals("0"))
        {
            l += ma.h(12, ff);
        }
        if (!fg.equals(""))
        {
            l += ma.h(13, fg);
        }
        if (fh != null)
        {
            l += ma.b(14, fh);
        }
        if (Float.floatToIntBits(fi) != Float.floatToIntBits(0.0F))
        {
            l += ma.c(15, fi);
        }
        if (fk != null && fk.length > 0)
        {
            int k1 = 0;
            int l1 = 0;
            int i2 = 0;
            for (; k1 < fk.length; k1++)
            {
                String s1 = fk[k1];
                if (s1 != null)
                {
                    i2++;
                    l1 += ma.cz(s1);
                }
            }

            l = l + l1 + i2 * 2;
        }
        if (fl != 0)
        {
            l += ma.r(17, fl);
        }
        if (fj)
        {
            l += ma.b(18, fj);
        }
        if (eV != null && eV.length > 0)
        {
            int i1 = 0;
            int j1 = 0;
            for (; i < eV.length; i++)
            {
                String s = eV[i];
                if (s != null)
                {
                    j1++;
                    i1 += ma.cz(s);
                }
            }

            l = l + i1 + j1 * 2;
        }
        return l;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof z))
            {
                return false;
            }
            z z = (z)obj;
            if (!md.equals(eV, z.eV))
            {
                return false;
            }
            if (!md.equals(eW, z.eW))
            {
                return false;
            }
            if (!md.equals(eX, z.eX))
            {
                return false;
            }
            if (!md.equals(eY, z.eY))
            {
                return false;
            }
            if (!md.equals(eZ, z.eZ))
            {
                return false;
            }
            if (!md.equals(fa, z.fa))
            {
                return false;
            }
            if (!md.equals(fb, z.fb))
            {
                return false;
            }
            if (!md.equals(fc, z.fc))
            {
                return false;
            }
            if (fd == null)
            {
                if (z.fd != null)
                {
                    return false;
                }
            } else
            if (!fd.equals(z.fd))
            {
                return false;
            }
            if (fe == null)
            {
                if (z.fe != null)
                {
                    return false;
                }
            } else
            if (!fe.equals(z.fe))
            {
                return false;
            }
            if (ff == null)
            {
                if (z.ff != null)
                {
                    return false;
                }
            } else
            if (!ff.equals(z.ff))
            {
                return false;
            }
            if (fg == null)
            {
                if (z.fg != null)
                {
                    return false;
                }
            } else
            if (!fg.equals(z.fg))
            {
                return false;
            }
            if (fh == null)
            {
                if (z.fh != null)
                {
                    return false;
                }
            } else
            if (!fh.equals(z.fh))
            {
                return false;
            }
            if (Float.floatToIntBits(fi) != Float.floatToIntBits(z.fi))
            {
                return false;
            }
            if (fj != z.fj)
            {
                return false;
            }
            if (!md.equals(fk, z.fk))
            {
                return false;
            }
            if (fl != z.fl)
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (z.amU != null && !z.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(z.amU);
            }
        }
        return true;
    }

    public final amU g(lz lz1)
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
                int k4 = mi.b(lz1, 10);
                int l4;
                String as2[];
                if (eW == null)
                {
                    l4 = 0;
                } else
                {
                    l4 = eW.length;
                }
                as2 = new String[k4 + l4];
                if (l4 != 0)
                {
                    System.arraycopy(eW, 0, as2, 0, l4);
                }
                for (; l4 < -1 + as2.length; l4++)
                {
                    as2[l4] = lz1.readString();
                    lz1.nw();
                }

                as2[l4] = lz1.readString();
                eW = as2;
                break;

            case 18: // '\022'
                int i4 = mi.b(lz1, 18);
                int j4;
                amU aamu5[];
                if (eX == null)
                {
                    j4 = 0;
                } else
                {
                    j4 = eX.length;
                }
                aamu5 = new eX[i4 + j4];
                if (j4 != 0)
                {
                    System.arraycopy(eX, 0, aamu5, 0, j4);
                }
                for (; j4 < -1 + aamu5.length; j4++)
                {
                    aamu5[j4] = new <init>();
                    lz1.a(aamu5[j4]);
                    lz1.nw();
                }

                aamu5[j4] = new <init>();
                lz1.a(aamu5[j4]);
                eX = aamu5;
                break;

            case 26: // '\032'
                int k3 = mi.b(lz1, 26);
                int l3;
                amU aamu4[];
                if (eY == null)
                {
                    l3 = 0;
                } else
                {
                    l3 = eY.length;
                }
                aamu4 = new eY[k3 + l3];
                if (l3 != 0)
                {
                    System.arraycopy(eY, 0, aamu4, 0, l3);
                }
                for (; l3 < -1 + aamu4.length; l3++)
                {
                    aamu4[l3] = new <init>();
                    lz1.a(aamu4[l3]);
                    lz1.nw();
                }

                aamu4[l3] = new <init>();
                lz1.a(aamu4[l3]);
                eY = aamu4;
                break;

            case 34: // '"'
                int i3 = mi.b(lz1, 34);
                int j3;
                amU aamu3[];
                if (eZ == null)
                {
                    j3 = 0;
                } else
                {
                    j3 = eZ.length;
                }
                aamu3 = new eZ[i3 + j3];
                if (j3 != 0)
                {
                    System.arraycopy(eZ, 0, aamu3, 0, j3);
                }
                for (; j3 < -1 + aamu3.length; j3++)
                {
                    aamu3[j3] = new <init>();
                    lz1.a(aamu3[j3]);
                    lz1.nw();
                }

                aamu3[j3] = new <init>();
                lz1.a(aamu3[j3]);
                eZ = aamu3;
                break;

            case 42: // '*'
                int k2 = mi.b(lz1, 42);
                int l2;
                amU aamu2[];
                if (fa == null)
                {
                    l2 = 0;
                } else
                {
                    l2 = fa.length;
                }
                aamu2 = new fa[k2 + l2];
                if (l2 != 0)
                {
                    System.arraycopy(fa, 0, aamu2, 0, l2);
                }
                for (; l2 < -1 + aamu2.length; l2++)
                {
                    aamu2[l2] = new <init>();
                    lz1.a(aamu2[l2]);
                    lz1.nw();
                }

                aamu2[l2] = new <init>();
                lz1.a(aamu2[l2]);
                fa = aamu2;
                break;

            case 50: // '2'
                int i2 = mi.b(lz1, 50);
                int j2;
                amU aamu1[];
                if (fb == null)
                {
                    j2 = 0;
                } else
                {
                    j2 = fb.length;
                }
                aamu1 = new fb[i2 + j2];
                if (j2 != 0)
                {
                    System.arraycopy(fb, 0, aamu1, 0, j2);
                }
                for (; j2 < -1 + aamu1.length; j2++)
                {
                    aamu1[j2] = new <init>();
                    lz1.a(aamu1[j2]);
                    lz1.nw();
                }

                aamu1[j2] = new <init>();
                lz1.a(aamu1[j2]);
                fb = aamu1;
                break;

            case 58: // ':'
                int k1 = mi.b(lz1, 58);
                int l1;
                amU aamu[];
                if (fc == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = fc.length;
                }
                aamu = new fc[k1 + l1];
                if (l1 != 0)
                {
                    System.arraycopy(fc, 0, aamu, 0, l1);
                }
                for (; l1 < -1 + aamu.length; l1++)
                {
                    aamu[l1] = new <init>();
                    lz1.a(aamu[l1]);
                    lz1.nw();
                }

                aamu[l1] = new <init>();
                lz1.a(aamu[l1]);
                fc = aamu;
                break;

            case 74: // 'J'
                fd = lz1.readString();
                break;

            case 82: // 'R'
                fe = lz1.readString();
                break;

            case 98: // 'b'
                ff = lz1.readString();
                break;

            case 106: // 'j'
                fg = lz1.readString();
                break;

            case 114: // 'r'
                if (fh == null)
                {
                    fh = new <init>();
                }
                lz1.a(fh);
                break;

            case 125: // '}'
                fi = lz1.readFloat();
                break;

            case 130: 
                int i1 = mi.b(lz1, 130);
                int j1;
                String as1[];
                if (fk == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = fk.length;
                }
                as1 = new String[i1 + j1];
                if (j1 != 0)
                {
                    System.arraycopy(fk, 0, as1, 0, j1);
                }
                for (; j1 < -1 + as1.length; j1++)
                {
                    as1[j1] = lz1.readString();
                    lz1.nw();
                }

                as1[j1] = lz1.readString();
                fk = as1;
                break;

            case 136: 
                fl = lz1.nz();
                break;

            case 144: 
                fj = lz1.nA();
                break;

            case 154: 
                int j = mi.b(lz1, 154);
                int l;
                String as[];
                if (eV == null)
                {
                    l = 0;
                } else
                {
                    l = eV.length;
                }
                as = new String[j + l];
                if (l != 0)
                {
                    System.arraycopy(eV, 0, as, 0, l);
                }
                for (; l < -1 + as.length; l++)
                {
                    as[l] = lz1.readString();
                    lz1.nw();
                }

                as[l] = lz1.readString();
                eV = as;
                break;
            }
        } while (true);
    }

    public final int hashCode()
    {
        int i = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + md.hashCode(eV)) + md.hashCode(eW)) + md.hashCode(eX)) + md.hashCode(eY)) + md.hashCode(eZ)) + md.hashCode(fa)) + md.hashCode(fb)) + md.hashCode(fc));
        int j;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        char c1;
        int i3;
        List list;
        int j3;
        if (fd == null)
        {
            j = 0;
        } else
        {
            j = fd.hashCode();
        }
        l = 31 * (j + i);
        if (fe == null)
        {
            i1 = 0;
        } else
        {
            i1 = fe.hashCode();
        }
        j1 = 31 * (i1 + l);
        if (ff == null)
        {
            k1 = 0;
        } else
        {
            k1 = ff.hashCode();
        }
        l1 = 31 * (k1 + j1);
        if (fg == null)
        {
            i2 = 0;
        } else
        {
            i2 = fg.hashCode();
        }
        j2 = 31 * (i2 + l1);
        if (fh == null)
        {
            k2 = 0;
        } else
        {
            k2 = fh.hashCode();
        }
        l2 = 31 * (31 * (k2 + j2) + Float.floatToIntBits(fi));
        if (fj)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        i3 = 31 * (31 * (31 * (c1 + l2) + md.hashCode(fk)) + fl);
        list = amU;
        j3 = 0;
        if (list != null)
        {
            boolean flag = amU.isEmpty();
            j3 = 0;
            if (!flag)
            {
                j3 = amU.hashCode();
            }
        }
        return i3 + j3;
    }

    public final amU k()
    {
        eV = mi.anf;
        eW = mi.anf;
        eX = r();
        eY = i();
        eZ = d();
        fa = d();
        fb = d();
        fc = l();
        fd = "";
        fe = "";
        ff = "0";
        fg = "";
        fh = null;
        fi = 0.0F;
        fj = false;
        fk = mi.anf;
        fl = 0;
        amU = null;
        amY = -1;
        return this;
    }

    public ()
    {
        k();
    }
}
