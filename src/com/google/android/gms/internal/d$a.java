// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, md, ma, lz, 
//            mi, mf

public final class s extends mb
{

    private static volatile amY fM[];
    public String fN;
    public amY fO[];
    public amY fP[];
    public amY fQ[];
    public String fR;
    public String fS;
    public long fT;
    public boolean fU;
    public amY fV[];
    public int fW[];
    public boolean fX;
    public int type;

    public static s[] r()
    {
        if (fM == null)
        {
            synchronized (md.amX)
            {
                if (fM == null)
                {
                    fM = new fM[0];
                }
            }
        }
        return fM;
    }

    public final void a(ma ma1)
    {
        ma1.p(1, type);
        if (!fN.equals(""))
        {
            ma1.b(2, fN);
        }
        if (fO != null && fO.length > 0)
        {
            for (int k1 = 0; k1 < fO.length; k1++)
            {
                fM fm3 = fO[k1];
                if (fm3 != null)
                {
                    ma1.a(3, fm3);
                }
            }

        }
        if (fP != null && fP.length > 0)
        {
            for (int j1 = 0; j1 < fP.length; j1++)
            {
                fM fm2 = fP[j1];
                if (fm2 != null)
                {
                    ma1.a(4, fm2);
                }
            }

        }
        if (fQ != null && fQ.length > 0)
        {
            for (int i1 = 0; i1 < fQ.length; i1++)
            {
                fM fm1 = fQ[i1];
                if (fm1 != null)
                {
                    ma1.a(5, fm1);
                }
            }

        }
        if (!fR.equals(""))
        {
            ma1.b(6, fR);
        }
        if (!fS.equals(""))
        {
            ma1.b(7, fS);
        }
        if (fT != 0L)
        {
            ma1.b(8, fT);
        }
        if (fX)
        {
            ma1.a(9, fX);
        }
        if (fW != null && fW.length > 0)
        {
            for (int k = 0; k < fW.length; k++)
            {
                ma1.p(10, fW[k]);
            }

        }
        if (fV != null)
        {
            int i = fV.length;
            int j = 0;
            if (i > 0)
            {
                for (; j < fV.length; j++)
                {
                    fM fm = fV[j];
                    if (fm != null)
                    {
                        ma1.a(11, fm);
                    }
                }

            }
        }
        if (fU)
        {
            ma1.a(12, fU);
        }
        super.a(ma1);
    }

    public final mf b(lz lz1)
    {
        return l(lz1);
    }

    protected final int c()
    {
        int i = super.c() + ma.r(1, type);
        if (!fN.equals(""))
        {
            i += ma.h(2, fN);
        }
        if (fO != null && fO.length > 0)
        {
            int i3 = i;
            for (int j3 = 0; j3 < fO.length; j3++)
            {
                l l4 = fO[j3];
                if (l4 != null)
                {
                    i3 += ma.b(3, l4);
                }
            }

            i = i3;
        }
        if (fP != null && fP.length > 0)
        {
            int j2 = i;
            for (int k2 = 0; k2 < fP.length; k2++)
            {
                l l3 = fP[k2];
                if (l3 != null)
                {
                    j2 += ma.b(4, l3);
                }
            }

            i = j2;
        }
        if (fQ != null && fQ.length > 0)
        {
            int k1 = i;
            for (int i2 = 0; i2 < fQ.length; i2++)
            {
                l l2 = fQ[i2];
                if (l2 != null)
                {
                    k1 += ma.b(5, l2);
                }
            }

            i = k1;
        }
        if (!fR.equals(""))
        {
            i += ma.h(6, fR);
        }
        if (!fS.equals(""))
        {
            i += ma.h(7, fS);
        }
        if (fT != 0L)
        {
            i += ma.d(8, fT);
        }
        if (fX)
        {
            i += ma.b(9, fX);
        }
        if (fW != null && fW.length > 0)
        {
            int i1 = 0;
            int j1 = 0;
            for (; i1 < fW.length; i1++)
            {
                j1 += ma.eE(fW[i1]);
            }

            i = i + j1 + 1 * fW.length;
        }
        if (fV != null)
        {
            int j = fV.length;
            int k = 0;
            if (j > 0)
            {
                for (; k < fV.length; k++)
                {
                    l l1 = fV[k];
                    if (l1 != null)
                    {
                        i += ma.b(11, l1);
                    }
                }

            }
        }
        if (fU)
        {
            i += ma.b(12, fU);
        }
        return i;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof fU))
            {
                return false;
            }
            fU fu = (fU)obj;
            if (type != fu.type)
            {
                return false;
            }
            if (fN == null)
            {
                if (fu.fN != null)
                {
                    return false;
                }
            } else
            if (!fN.equals(fu.fN))
            {
                return false;
            }
            if (!md.equals(fO, fu.fO))
            {
                return false;
            }
            if (!md.equals(fP, fu.fP))
            {
                return false;
            }
            if (!md.equals(fQ, fu.fQ))
            {
                return false;
            }
            if (fR == null)
            {
                if (fu.fR != null)
                {
                    return false;
                }
            } else
            if (!fR.equals(fu.fR))
            {
                return false;
            }
            if (fS == null)
            {
                if (fu.fS != null)
                {
                    return false;
                }
            } else
            if (!fS.equals(fu.fS))
            {
                return false;
            }
            if (fT != fu.fT)
            {
                return false;
            }
            if (fU != fu.fU)
            {
                return false;
            }
            if (!md.equals(fV, fu.fV))
            {
                return false;
            }
            if (!md.equals(fW, fu.fW))
            {
                return false;
            }
            if (fX != fu.fX)
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (fu.amU != null && !fu.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(fu.amU);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        char c1 = '\u04CF';
        int i = 31 * (527 + type);
        int j;
        int k;
        int i1;
        int j1;
        int k1;
        int l1;
        char c2;
        int i2;
        int j2;
        List list;
        int k2;
        if (fN == null)
        {
            j = 0;
        } else
        {
            j = fN.hashCode();
        }
        k = 31 * (31 * (31 * (31 * (j + i) + md.hashCode(fO)) + md.hashCode(fP)) + md.hashCode(fQ));
        if (fR == null)
        {
            i1 = 0;
        } else
        {
            i1 = fR.hashCode();
        }
        j1 = 31 * (i1 + k);
        if (fS == null)
        {
            k1 = 0;
        } else
        {
            k1 = fS.hashCode();
        }
        l1 = 31 * (31 * (k1 + j1) + (int)(fT ^ fT >>> 32));
        if (fU)
        {
            c2 = c1;
        } else
        {
            c2 = '\u04D5';
        }
        i2 = 31 * (31 * (31 * (c2 + l1) + md.hashCode(fV)) + md.hashCode(fW));
        if (!fX)
        {
            c1 = '\u04D5';
        }
        j2 = 31 * (i2 + c1);
        list = amU;
        k2 = 0;
        if (list != null)
        {
            boolean flag = amU.isEmpty();
            k2 = 0;
            if (!flag)
            {
                k2 = amU.hashCode();
            }
        }
        return j2 + k2;
    }

    public final amU l(lz lz1)
    {
_L16:
        int i = lz1.nw();
        i;
        JVM INSTR lookupswitch 14: default 128
    //                   0: 137
    //                   8: 139
    //                   18: 204
    //                   26: 215
    //                   34: 343
    //                   42: 471
    //                   50: 599
    //                   58: 610
    //                   64: 621
    //                   72: 632
    //                   80: 643
    //                   82: 897
    //                   90: 1212
    //                   96: 1338;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        if (a(lz1, i)) goto _L16; else goto _L2
_L2:
        return this;
_L3:
        int k5 = lz1.nz();
        switch (k5)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            type = k5;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        fN = lz1.readString();
        continue; /* Loop/switch isn't completed */
_L5:
        int i5 = mi.b(lz1, 26);
        int j5;
        amU aamu3[];
        if (fO == null)
        {
            j5 = 0;
        } else
        {
            j5 = fO.length;
        }
        aamu3 = new fO[i5 + j5];
        if (j5 != 0)
        {
            System.arraycopy(fO, 0, aamu3, 0, j5);
        }
        for (; j5 < -1 + aamu3.length; j5++)
        {
            aamu3[j5] = new <init>();
            lz1.a(aamu3[j5]);
            lz1.nw();
        }

        aamu3[j5] = new <init>();
        lz1.a(aamu3[j5]);
        fO = aamu3;
        continue; /* Loop/switch isn't completed */
_L6:
        int k4 = mi.b(lz1, 34);
        int l4;
        amU aamu2[];
        if (fP == null)
        {
            l4 = 0;
        } else
        {
            l4 = fP.length;
        }
        aamu2 = new fP[k4 + l4];
        if (l4 != 0)
        {
            System.arraycopy(fP, 0, aamu2, 0, l4);
        }
        for (; l4 < -1 + aamu2.length; l4++)
        {
            aamu2[l4] = new <init>();
            lz1.a(aamu2[l4]);
            lz1.nw();
        }

        aamu2[l4] = new <init>();
        lz1.a(aamu2[l4]);
        fP = aamu2;
        continue; /* Loop/switch isn't completed */
_L7:
        int i4 = mi.b(lz1, 42);
        int j4;
        amU aamu1[];
        if (fQ == null)
        {
            j4 = 0;
        } else
        {
            j4 = fQ.length;
        }
        aamu1 = new fQ[i4 + j4];
        if (j4 != 0)
        {
            System.arraycopy(fQ, 0, aamu1, 0, j4);
        }
        for (; j4 < -1 + aamu1.length; j4++)
        {
            aamu1[j4] = new <init>();
            lz1.a(aamu1[j4]);
            lz1.nw();
        }

        aamu1[j4] = new <init>();
        lz1.a(aamu1[j4]);
        fQ = aamu1;
        continue; /* Loop/switch isn't completed */
_L8:
        fR = lz1.readString();
        continue; /* Loop/switch isn't completed */
_L9:
        fS = lz1.readString();
        continue; /* Loop/switch isn't completed */
_L10:
        fT = lz1.ny();
        continue; /* Loop/switch isn't completed */
_L11:
        fX = lz1.nA();
        continue; /* Loop/switch isn't completed */
_L12:
        int k2;
        int ai1[];
        int l2;
        int i3;
        k2 = mi.b(lz1, 80);
        ai1 = new int[k2];
        l2 = 0;
        i3 = 0;
_L21:
        if (l2 >= k2) goto _L18; else goto _L17
_L17:
        int k3;
        if (l2 != 0)
        {
            lz1.nw();
        }
        k3 = lz1.nz();
        k3;
        JVM INSTR tableswitch 1 17: default 772
    //                   1 786
    //                   2 786
    //                   3 786
    //                   4 786
    //                   5 786
    //                   6 786
    //                   7 786
    //                   8 786
    //                   9 786
    //                   10 786
    //                   11 786
    //                   12 786
    //                   13 786
    //                   14 786
    //                   15 786
    //                   16 786
    //                   17 786;
           goto _L19 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20
_L19:
        int l3 = i3;
_L22:
        l2++;
        i3 = l3;
          goto _L21
_L20:
        l3 = i3 + 1;
        ai1[i3] = k3;
          goto _L22
_L18:
        if (i3 != 0)
        {
            int j3;
            if (fW == null)
            {
                j3 = 0;
            } else
            {
                j3 = fW.length;
            }
            if (j3 == 0 && i3 == ai1.length)
            {
                fW = ai1;
            } else
            {
                int ai2[] = new int[j3 + i3];
                if (j3 != 0)
                {
                    System.arraycopy(fW, 0, ai2, 0, j3);
                }
                System.arraycopy(ai1, 0, ai2, j3, i3);
                fW = ai2;
            }
        }
        continue; /* Loop/switch isn't completed */
          goto _L21
_L13:
        int i1;
        int j1;
        int k1;
        i1 = lz1.ex(lz1.nD());
        j1 = lz1.getPosition();
        k1 = 0;
_L28:
        if (lz1.nI() > 0)
        {
            switch (lz1.nz())
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
            case 16: // '\020'
            case 17: // '\021'
                k1++;
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (k1 == 0) goto _L24; else goto _L23
_L23:
        int ai[];
        lz1.ez(j1);
        int l1;
        int i2;
        int j2;
        if (fW == null)
        {
            l1 = 0;
        } else
        {
            l1 = fW.length;
        }
        ai = new int[k1 + l1];
        if (l1 != 0)
        {
            System.arraycopy(fW, 0, ai, 0, l1);
        }
_L26:
        if (lz1.nI() > 0)
        {
            i2 = lz1.nz();
            switch (i2)
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
            case 16: // '\020'
            case 17: // '\021'
                j2 = l1 + 1;
                ai[l1] = i2;
                l1 = j2;
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        fW = ai;
_L24:
        lz1.ey(i1);
        continue; /* Loop/switch isn't completed */
        if (true) goto _L26; else goto _L25
_L25:
        if (true) goto _L28; else goto _L27
_L27:
_L14:
        int j = mi.b(lz1, 90);
        int k;
        amU aamu[];
        if (fV == null)
        {
            k = 0;
        } else
        {
            k = fV.length;
        }
        aamu = new fV[j + k];
        if (k != 0)
        {
            System.arraycopy(fV, 0, aamu, 0, k);
        }
        for (; k < -1 + aamu.length; k++)
        {
            aamu[k] = new <init>();
            lz1.a(aamu[k]);
            lz1.nw();
        }

        aamu[k] = new <init>();
        lz1.a(aamu[k]);
        fV = aamu;
        continue; /* Loop/switch isn't completed */
_L15:
        fU = lz1.nA();
        if (true) goto _L16; else goto _L29
_L29:
    }

    public final A s()
    {
        type = 1;
        fN = "";
        fO = r();
        fP = r();
        fQ = r();
        fR = "";
        fS = "";
        fT = 0L;
        fU = false;
        fV = r();
        fW = mi.ana;
        fX = false;
        amU = null;
        amY = -1;
        return this;
    }

    public ()
    {
        s();
    }
}
