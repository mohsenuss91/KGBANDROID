// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, md, ma, lz, 
//            mi, mf

public final class m extends mb
{

    private static volatile amY fm[];
    public int fn[];
    public int fo[];
    public int fp[];
    public int fq[];
    public int fr[];
    public int fs[];
    public int ft[];
    public int fu[];
    public int fv[];
    public int fw[];

    public static m[] l()
    {
        if (fm == null)
        {
            synchronized (md.amX)
            {
                if (fm == null)
                {
                    fm = new fm[0];
                }
            }
        }
        return fm;
    }

    public final void a(ma ma1)
    {
        if (fn != null && fn.length > 0)
        {
            for (int l2 = 0; l2 < fn.length; l2++)
            {
                ma1.p(1, fn[l2]);
            }

        }
        if (fo != null && fo.length > 0)
        {
            for (int k2 = 0; k2 < fo.length; k2++)
            {
                ma1.p(2, fo[k2]);
            }

        }
        if (fp != null && fp.length > 0)
        {
            for (int j2 = 0; j2 < fp.length; j2++)
            {
                ma1.p(3, fp[j2]);
            }

        }
        if (fq != null && fq.length > 0)
        {
            for (int i2 = 0; i2 < fq.length; i2++)
            {
                ma1.p(4, fq[i2]);
            }

        }
        if (fr != null && fr.length > 0)
        {
            for (int l1 = 0; l1 < fr.length; l1++)
            {
                ma1.p(5, fr[l1]);
            }

        }
        if (fs != null && fs.length > 0)
        {
            for (int k1 = 0; k1 < fs.length; k1++)
            {
                ma1.p(6, fs[k1]);
            }

        }
        if (ft != null && ft.length > 0)
        {
            for (int j1 = 0; j1 < ft.length; j1++)
            {
                ma1.p(7, ft[j1]);
            }

        }
        if (fu != null && fu.length > 0)
        {
            for (int i1 = 0; i1 < fu.length; i1++)
            {
                ma1.p(8, fu[i1]);
            }

        }
        if (fv != null && fv.length > 0)
        {
            for (int k = 0; k < fv.length; k++)
            {
                ma1.p(9, fv[k]);
            }

        }
        if (fw != null)
        {
            int i = fw.length;
            int j = 0;
            if (i > 0)
            {
                for (; j < fw.length; j++)
                {
                    ma1.p(10, fw[j]);
                }

            }
        }
        super.a(ma1);
    }

    public final mf b(lz lz1)
    {
        return h(lz1);
    }

    protected final int c()
    {
        int i = 0;
        int j = super.c();
        int k;
        if (fn != null && fn.length > 0)
        {
            int j5 = 0;
            int k5 = 0;
            for (; j5 < fn.length; j5++)
            {
                k5 += ma.eE(fn[j5]);
            }

            k = j + k5 + 1 * fn.length;
        } else
        {
            k = j;
        }
        if (fo != null && fo.length > 0)
        {
            int l4 = 0;
            int i5 = 0;
            for (; l4 < fo.length; l4++)
            {
                i5 += ma.eE(fo[l4]);
            }

            k = k + i5 + 1 * fo.length;
        }
        if (fp != null && fp.length > 0)
        {
            int j4 = 0;
            int k4 = 0;
            for (; j4 < fp.length; j4++)
            {
                k4 += ma.eE(fp[j4]);
            }

            k = k + k4 + 1 * fp.length;
        }
        if (fq != null && fq.length > 0)
        {
            int l3 = 0;
            int i4 = 0;
            for (; l3 < fq.length; l3++)
            {
                i4 += ma.eE(fq[l3]);
            }

            k = k + i4 + 1 * fq.length;
        }
        if (fr != null && fr.length > 0)
        {
            int j3 = 0;
            int k3 = 0;
            for (; j3 < fr.length; j3++)
            {
                k3 += ma.eE(fr[j3]);
            }

            k = k + k3 + 1 * fr.length;
        }
        if (fs != null && fs.length > 0)
        {
            int l2 = 0;
            int i3 = 0;
            for (; l2 < fs.length; l2++)
            {
                i3 += ma.eE(fs[l2]);
            }

            k = k + i3 + 1 * fs.length;
        }
        if (ft != null && ft.length > 0)
        {
            int j2 = 0;
            int k2 = 0;
            for (; j2 < ft.length; j2++)
            {
                k2 += ma.eE(ft[j2]);
            }

            k = k + k2 + 1 * ft.length;
        }
        if (fu != null && fu.length > 0)
        {
            int l1 = 0;
            int i2 = 0;
            for (; l1 < fu.length; l1++)
            {
                i2 += ma.eE(fu[l1]);
            }

            k = k + i2 + 1 * fu.length;
        }
        if (fv != null && fv.length > 0)
        {
            int j1 = 0;
            int k1 = 0;
            for (; j1 < fv.length; j1++)
            {
                k1 += ma.eE(fv[j1]);
            }

            k = k + k1 + 1 * fv.length;
        }
        if (fw != null && fw.length > 0)
        {
            int i1 = 0;
            for (; i < fw.length; i++)
            {
                i1 += ma.eE(fw[i]);
            }

            k = k + i1 + 1 * fw.length;
        }
        return k;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof fw))
            {
                return false;
            }
            fw fw1 = (fw)obj;
            if (!md.equals(fn, fw1.fn))
            {
                return false;
            }
            if (!md.equals(fo, fw1.fo))
            {
                return false;
            }
            if (!md.equals(fp, fw1.fp))
            {
                return false;
            }
            if (!md.equals(fq, fw1.fq))
            {
                return false;
            }
            if (!md.equals(fr, fw1.fr))
            {
                return false;
            }
            if (!md.equals(fs, fw1.fs))
            {
                return false;
            }
            if (!md.equals(ft, fw1.ft))
            {
                return false;
            }
            if (!md.equals(fu, fw1.fu))
            {
                return false;
            }
            if (!md.equals(fv, fw1.fv))
            {
                return false;
            }
            if (!md.equals(fw, fw1.fw))
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (fw1.amU != null && !fw1.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(fw1.amU);
            }
        }
        return true;
    }

    public final amU h(lz lz1)
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
                int i15 = mi.b(lz1, 8);
                int j15;
                int ai19[];
                if (fn == null)
                {
                    j15 = 0;
                } else
                {
                    j15 = fn.length;
                }
                ai19 = new int[i15 + j15];
                if (j15 != 0)
                {
                    System.arraycopy(fn, 0, ai19, 0, j15);
                }
                for (; j15 < -1 + ai19.length; j15++)
                {
                    ai19[j15] = lz1.nz();
                    lz1.nw();
                }

                ai19[j15] = lz1.nz();
                fn = ai19;
                break;

            case 10: // '\n'
                int i14 = lz1.ex(lz1.nD());
                int j14 = lz1.getPosition();
                int k14;
                for (k14 = 0; lz1.nI() > 0; k14++)
                {
                    lz1.nz();
                }

                lz1.ez(j14);
                int l14;
                int ai18[];
                if (fn == null)
                {
                    l14 = 0;
                } else
                {
                    l14 = fn.length;
                }
                ai18 = new int[k14 + l14];
                if (l14 != 0)
                {
                    System.arraycopy(fn, 0, ai18, 0, l14);
                }
                for (; l14 < ai18.length; l14++)
                {
                    ai18[l14] = lz1.nz();
                }

                fn = ai18;
                lz1.ey(i14);
                break;

            case 16: // '\020'
                int k13 = mi.b(lz1, 16);
                int l13;
                int ai17[];
                if (fo == null)
                {
                    l13 = 0;
                } else
                {
                    l13 = fo.length;
                }
                ai17 = new int[k13 + l13];
                if (l13 != 0)
                {
                    System.arraycopy(fo, 0, ai17, 0, l13);
                }
                for (; l13 < -1 + ai17.length; l13++)
                {
                    ai17[l13] = lz1.nz();
                    lz1.nw();
                }

                ai17[l13] = lz1.nz();
                fo = ai17;
                break;

            case 18: // '\022'
                int k12 = lz1.ex(lz1.nD());
                int l12 = lz1.getPosition();
                int i13;
                for (i13 = 0; lz1.nI() > 0; i13++)
                {
                    lz1.nz();
                }

                lz1.ez(l12);
                int j13;
                int ai16[];
                if (fo == null)
                {
                    j13 = 0;
                } else
                {
                    j13 = fo.length;
                }
                ai16 = new int[i13 + j13];
                if (j13 != 0)
                {
                    System.arraycopy(fo, 0, ai16, 0, j13);
                }
                for (; j13 < ai16.length; j13++)
                {
                    ai16[j13] = lz1.nz();
                }

                fo = ai16;
                lz1.ey(k12);
                break;

            case 24: // '\030'
                int i12 = mi.b(lz1, 24);
                int j12;
                int ai15[];
                if (fp == null)
                {
                    j12 = 0;
                } else
                {
                    j12 = fp.length;
                }
                ai15 = new int[i12 + j12];
                if (j12 != 0)
                {
                    System.arraycopy(fp, 0, ai15, 0, j12);
                }
                for (; j12 < -1 + ai15.length; j12++)
                {
                    ai15[j12] = lz1.nz();
                    lz1.nw();
                }

                ai15[j12] = lz1.nz();
                fp = ai15;
                break;

            case 26: // '\032'
                int i11 = lz1.ex(lz1.nD());
                int j11 = lz1.getPosition();
                int k11;
                for (k11 = 0; lz1.nI() > 0; k11++)
                {
                    lz1.nz();
                }

                lz1.ez(j11);
                int l11;
                int ai14[];
                if (fp == null)
                {
                    l11 = 0;
                } else
                {
                    l11 = fp.length;
                }
                ai14 = new int[k11 + l11];
                if (l11 != 0)
                {
                    System.arraycopy(fp, 0, ai14, 0, l11);
                }
                for (; l11 < ai14.length; l11++)
                {
                    ai14[l11] = lz1.nz();
                }

                fp = ai14;
                lz1.ey(i11);
                break;

            case 32: // ' '
                int k10 = mi.b(lz1, 32);
                int l10;
                int ai13[];
                if (fq == null)
                {
                    l10 = 0;
                } else
                {
                    l10 = fq.length;
                }
                ai13 = new int[k10 + l10];
                if (l10 != 0)
                {
                    System.arraycopy(fq, 0, ai13, 0, l10);
                }
                for (; l10 < -1 + ai13.length; l10++)
                {
                    ai13[l10] = lz1.nz();
                    lz1.nw();
                }

                ai13[l10] = lz1.nz();
                fq = ai13;
                break;

            case 34: // '"'
                int k9 = lz1.ex(lz1.nD());
                int l9 = lz1.getPosition();
                int i10;
                for (i10 = 0; lz1.nI() > 0; i10++)
                {
                    lz1.nz();
                }

                lz1.ez(l9);
                int j10;
                int ai12[];
                if (fq == null)
                {
                    j10 = 0;
                } else
                {
                    j10 = fq.length;
                }
                ai12 = new int[i10 + j10];
                if (j10 != 0)
                {
                    System.arraycopy(fq, 0, ai12, 0, j10);
                }
                for (; j10 < ai12.length; j10++)
                {
                    ai12[j10] = lz1.nz();
                }

                fq = ai12;
                lz1.ey(k9);
                break;

            case 40: // '('
                int i9 = mi.b(lz1, 40);
                int j9;
                int ai11[];
                if (fr == null)
                {
                    j9 = 0;
                } else
                {
                    j9 = fr.length;
                }
                ai11 = new int[i9 + j9];
                if (j9 != 0)
                {
                    System.arraycopy(fr, 0, ai11, 0, j9);
                }
                for (; j9 < -1 + ai11.length; j9++)
                {
                    ai11[j9] = lz1.nz();
                    lz1.nw();
                }

                ai11[j9] = lz1.nz();
                fr = ai11;
                break;

            case 42: // '*'
                int i8 = lz1.ex(lz1.nD());
                int j8 = lz1.getPosition();
                int k8;
                for (k8 = 0; lz1.nI() > 0; k8++)
                {
                    lz1.nz();
                }

                lz1.ez(j8);
                int l8;
                int ai10[];
                if (fr == null)
                {
                    l8 = 0;
                } else
                {
                    l8 = fr.length;
                }
                ai10 = new int[k8 + l8];
                if (l8 != 0)
                {
                    System.arraycopy(fr, 0, ai10, 0, l8);
                }
                for (; l8 < ai10.length; l8++)
                {
                    ai10[l8] = lz1.nz();
                }

                fr = ai10;
                lz1.ey(i8);
                break;

            case 48: // '0'
                int k7 = mi.b(lz1, 48);
                int l7;
                int ai9[];
                if (fs == null)
                {
                    l7 = 0;
                } else
                {
                    l7 = fs.length;
                }
                ai9 = new int[k7 + l7];
                if (l7 != 0)
                {
                    System.arraycopy(fs, 0, ai9, 0, l7);
                }
                for (; l7 < -1 + ai9.length; l7++)
                {
                    ai9[l7] = lz1.nz();
                    lz1.nw();
                }

                ai9[l7] = lz1.nz();
                fs = ai9;
                break;

            case 50: // '2'
                int k6 = lz1.ex(lz1.nD());
                int l6 = lz1.getPosition();
                int i7;
                for (i7 = 0; lz1.nI() > 0; i7++)
                {
                    lz1.nz();
                }

                lz1.ez(l6);
                int j7;
                int ai8[];
                if (fs == null)
                {
                    j7 = 0;
                } else
                {
                    j7 = fs.length;
                }
                ai8 = new int[i7 + j7];
                if (j7 != 0)
                {
                    System.arraycopy(fs, 0, ai8, 0, j7);
                }
                for (; j7 < ai8.length; j7++)
                {
                    ai8[j7] = lz1.nz();
                }

                fs = ai8;
                lz1.ey(k6);
                break;

            case 56: // '8'
                int i6 = mi.b(lz1, 56);
                int j6;
                int ai7[];
                if (ft == null)
                {
                    j6 = 0;
                } else
                {
                    j6 = ft.length;
                }
                ai7 = new int[i6 + j6];
                if (j6 != 0)
                {
                    System.arraycopy(ft, 0, ai7, 0, j6);
                }
                for (; j6 < -1 + ai7.length; j6++)
                {
                    ai7[j6] = lz1.nz();
                    lz1.nw();
                }

                ai7[j6] = lz1.nz();
                ft = ai7;
                break;

            case 58: // ':'
                int i5 = lz1.ex(lz1.nD());
                int j5 = lz1.getPosition();
                int k5;
                for (k5 = 0; lz1.nI() > 0; k5++)
                {
                    lz1.nz();
                }

                lz1.ez(j5);
                int l5;
                int ai6[];
                if (ft == null)
                {
                    l5 = 0;
                } else
                {
                    l5 = ft.length;
                }
                ai6 = new int[k5 + l5];
                if (l5 != 0)
                {
                    System.arraycopy(ft, 0, ai6, 0, l5);
                }
                for (; l5 < ai6.length; l5++)
                {
                    ai6[l5] = lz1.nz();
                }

                ft = ai6;
                lz1.ey(i5);
                break;

            case 64: // '@'
                int k4 = mi.b(lz1, 64);
                int l4;
                int ai5[];
                if (fu == null)
                {
                    l4 = 0;
                } else
                {
                    l4 = fu.length;
                }
                ai5 = new int[k4 + l4];
                if (l4 != 0)
                {
                    System.arraycopy(fu, 0, ai5, 0, l4);
                }
                for (; l4 < -1 + ai5.length; l4++)
                {
                    ai5[l4] = lz1.nz();
                    lz1.nw();
                }

                ai5[l4] = lz1.nz();
                fu = ai5;
                break;

            case 66: // 'B'
                int k3 = lz1.ex(lz1.nD());
                int l3 = lz1.getPosition();
                int i4;
                for (i4 = 0; lz1.nI() > 0; i4++)
                {
                    lz1.nz();
                }

                lz1.ez(l3);
                int j4;
                int ai4[];
                if (fu == null)
                {
                    j4 = 0;
                } else
                {
                    j4 = fu.length;
                }
                ai4 = new int[i4 + j4];
                if (j4 != 0)
                {
                    System.arraycopy(fu, 0, ai4, 0, j4);
                }
                for (; j4 < ai4.length; j4++)
                {
                    ai4[j4] = lz1.nz();
                }

                fu = ai4;
                lz1.ey(k3);
                break;

            case 72: // 'H'
                int i3 = mi.b(lz1, 72);
                int j3;
                int ai3[];
                if (fv == null)
                {
                    j3 = 0;
                } else
                {
                    j3 = fv.length;
                }
                ai3 = new int[i3 + j3];
                if (j3 != 0)
                {
                    System.arraycopy(fv, 0, ai3, 0, j3);
                }
                for (; j3 < -1 + ai3.length; j3++)
                {
                    ai3[j3] = lz1.nz();
                    lz1.nw();
                }

                ai3[j3] = lz1.nz();
                fv = ai3;
                break;

            case 74: // 'J'
                int i2 = lz1.ex(lz1.nD());
                int j2 = lz1.getPosition();
                int k2;
                for (k2 = 0; lz1.nI() > 0; k2++)
                {
                    lz1.nz();
                }

                lz1.ez(j2);
                int l2;
                int ai2[];
                if (fv == null)
                {
                    l2 = 0;
                } else
                {
                    l2 = fv.length;
                }
                ai2 = new int[k2 + l2];
                if (l2 != 0)
                {
                    System.arraycopy(fv, 0, ai2, 0, l2);
                }
                for (; l2 < ai2.length; l2++)
                {
                    ai2[l2] = lz1.nz();
                }

                fv = ai2;
                lz1.ey(i2);
                break;

            case 80: // 'P'
                int k1 = mi.b(lz1, 80);
                int l1;
                int ai1[];
                if (fw == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = fw.length;
                }
                ai1 = new int[k1 + l1];
                if (l1 != 0)
                {
                    System.arraycopy(fw, 0, ai1, 0, l1);
                }
                for (; l1 < -1 + ai1.length; l1++)
                {
                    ai1[l1] = lz1.nz();
                    lz1.nw();
                }

                ai1[l1] = lz1.nz();
                fw = ai1;
                break;

            case 82: // 'R'
                int j = lz1.ex(lz1.nD());
                int k = lz1.getPosition();
                int i1;
                for (i1 = 0; lz1.nI() > 0; i1++)
                {
                    lz1.nz();
                }

                lz1.ez(k);
                int j1;
                int ai[];
                if (fw == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = fw.length;
                }
                ai = new int[i1 + j1];
                if (j1 != 0)
                {
                    System.arraycopy(fw, 0, ai, 0, j1);
                }
                for (; j1 < ai.length; j1++)
                {
                    ai[j1] = lz1.nz();
                }

                fw = ai;
                lz1.ey(j);
                break;
            }
        } while (true);
    }

    public final int hashCode()
    {
        int i = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + md.hashCode(fn)) + md.hashCode(fo)) + md.hashCode(fp)) + md.hashCode(fq)) + md.hashCode(fr)) + md.hashCode(fs)) + md.hashCode(ft)) + md.hashCode(fu)) + md.hashCode(fv)) + md.hashCode(fw));
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

    public final amU m()
    {
        fn = mi.ana;
        fo = mi.ana;
        fp = mi.ana;
        fq = mi.ana;
        fr = mi.ana;
        fs = mi.ana;
        ft = mi.ana;
        fu = mi.ana;
        fv = mi.ana;
        fw = mi.ana;
        amU = null;
        amY = -1;
        return this;
    }

    public ()
    {
        m();
    }
}
