// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thirdparty;


// Referenced classes of package com.inmobi.commons.thirdparty:
//            Base64

class k extends k
{

    static final boolean e;
    private static final byte h[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte i[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    int a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    private final byte j[] = new byte[2];
    private int k;
    private final byte l[];

    public boolean a(byte abyte0[], int i1, int j1, boolean flag)
    {
        byte abyte1[];
        byte abyte2[];
        int k1;
        int l1;
        abyte1 = l;
        abyte2 = f;
        k1 = k;
        l1 = j1 + i1;
        a;
        JVM INSTR tableswitch 0 2: default 52
    //                   0 349
    //                   1 358
    //                   2 436;
           goto _L1 _L2 _L3 _L4
_L1:
        int j2;
        int l2;
        l2 = -1;
        j2 = i1;
_L6:
        int i3;
        int j3;
        if (l2 != -1)
        {
            abyte2[0] = abyte1[0x3f & l2 >> 18];
            abyte2[1] = abyte1[0x3f & l2 >> 12];
            abyte2[2] = abyte1[0x3f & l2 >> 6];
            byte byte3 = 4;
            abyte2[3] = abyte1[l2 & 0x3f];
            int l10 = k1 - 1;
            int i2;
            int k2;
            byte abyte3[];
            int k3;
            byte abyte4[];
            int l3;
            byte abyte5[];
            int i4;
            int j4;
            int k4;
            byte byte0;
            int l4;
            int i5;
            int j5;
            byte byte1;
            int k5;
            int l5;
            int i6;
            int j6;
            int k6;
            int l6;
            int i7;
            byte abyte6[];
            int j7;
            byte abyte7[];
            int k7;
            byte byte2;
            int l7;
            int i8;
            int j8;
            int k8;
            int l8;
            int i9;
            int j9;
            byte abyte8[];
            int k9;
            int l9;
            int i10;
            int j10;
            int k10;
            int i11;
            int j11;
            int k11;
            int l11;
            int i12;
            if (l10 == 0)
            {
                if (d)
                {
                    byte3 = 5;
                    abyte2[4] = 13;
                }
                j3 = byte3 + 1;
                abyte2[byte3] = 10;
                i3 = 19;
            } else
            {
                i3 = l10;
                j3 = byte3;
            }
        } else
        {
            i3 = k1;
            j3 = 0;
        }
        while (j2 + 3 <= l1) 
        {
            k9 = (0xff & abyte0[j2]) << 16 | (0xff & abyte0[j2 + 1]) << 8 | 0xff & abyte0[j2 + 2];
            abyte2[j3] = abyte1[0x3f & k9 >> 18];
            abyte2[j3 + 1] = abyte1[0x3f & k9 >> 12];
            abyte2[j3 + 2] = abyte1[0x3f & k9 >> 6];
            abyte2[j3 + 3] = abyte1[k9 & 0x3f];
            l9 = j2 + 3;
            i10 = j3 + 4;
            j10 = i3 - 1;
            if (j10 == 0)
            {
                if (d)
                {
                    k10 = i10 + 1;
                    abyte2[i10] = 13;
                } else
                {
                    k10 = i10;
                }
                j3 = k10 + 1;
                abyte2[k10] = 10;
                j2 = l9;
                i3 = 19;
            } else
            {
                i3 = j10;
                j3 = i10;
                j2 = l9;
            }
        }
          goto _L5
_L2:
        l2 = -1;
        j2 = i1;
          goto _L6
_L3:
        if (i1 + 2 > l1) goto _L1; else goto _L7
_L7:
        i11 = (0xff & j[0]) << 16;
        j11 = i1 + 1;
        k11 = i11 | (0xff & abyte0[i1]) << 8;
        l11 = j11 + 1;
        i12 = k11 | 0xff & abyte0[j11];
        a = 0;
        l2 = i12;
        j2 = l11;
          goto _L6
_L4:
        if (i1 + 1 > l1) goto _L1; else goto _L8
_L8:
        i2 = (0xff & j[0]) << 16 | (0xff & j[1]) << 8;
        j2 = i1 + 1;
        k2 = i2 | 0xff & abyte0[i1];
        a = 0;
        l2 = k2;
          goto _L6
_L5:
        if (!flag) goto _L10; else goto _L9
_L9:
        if (j2 - a != l1 - 1) goto _L12; else goto _L11
_L11:
        if (a > 0)
        {
            abyte8 = j;
            l7 = 1;
            byte2 = abyte8[0];
        } else
        {
            k7 = j2 + 1;
            byte2 = abyte0[j2];
            j2 = k7;
            l7 = 0;
        }
        i8 = (byte2 & 0xff) << 4;
        a = a - l7;
        j8 = j3 + 1;
        abyte2[j3] = abyte1[0x3f & i8 >> 6];
        k8 = j8 + 1;
        abyte2[j8] = abyte1[i8 & 0x3f];
        if (b)
        {
            j9 = k8 + 1;
            abyte2[k8] = 61;
            k8 = j9 + 1;
            abyte2[j9] = 61;
        }
        if (c)
        {
            if (d)
            {
                i9 = k8 + 1;
                abyte2[k8] = 13;
                k8 = i9;
            }
            l8 = k8 + 1;
            abyte2[k8] = 10;
            k8 = l8;
        }
        j3 = k8;
_L14:
        if (!e && a != 0)
        {
            throw new AssertionError();
        }
          goto _L13
_L12:
        if (j2 - a == l1 - 2)
        {
            if (a > 1)
            {
                abyte7 = j;
                l4 = 1;
                byte0 = abyte7[0];
            } else
            {
                k4 = j2 + 1;
                byte0 = abyte0[j2];
                j2 = k4;
                l4 = 0;
            }
            i5 = (byte0 & 0xff) << 10;
            if (a > 0)
            {
                abyte6 = j;
                j7 = l4 + 1;
                byte1 = abyte6[l4];
                l4 = j7;
            } else
            {
                j5 = j2 + 1;
                byte1 = abyte0[j2];
                j2 = j5;
            }
            k5 = i5 | (byte1 & 0xff) << 2;
            a = a - l4;
            l5 = j3 + 1;
            abyte2[j3] = abyte1[0x3f & k5 >> 12];
            i6 = l5 + 1;
            abyte2[l5] = abyte1[0x3f & k5 >> 6];
            j6 = i6 + 1;
            abyte2[i6] = abyte1[k5 & 0x3f];
            if (b)
            {
                k6 = j6 + 1;
                abyte2[j6] = 61;
            } else
            {
                k6 = j6;
            }
            if (c)
            {
                if (d)
                {
                    i7 = k6 + 1;
                    abyte2[k6] = 13;
                    k6 = i7;
                }
                l6 = k6 + 1;
                abyte2[k6] = 10;
                k6 = l6;
            }
            j3 = k6;
        } else
        if (c && j3 > 0 && i3 != 19)
        {
            if (d)
            {
                j4 = j3 + 1;
                abyte2[j3] = 13;
            } else
            {
                j4 = j3;
            }
            j3 = j4 + 1;
            abyte2[j4] = 10;
        }
        if (true) goto _L14; else goto _L13
_L13:
        if (!e && j2 != l1)
        {
            throw new AssertionError();
        }
          goto _L15
_L10:
        if (j2 != l1 - 1) goto _L17; else goto _L16
_L16:
        abyte5 = j;
        i4 = a;
        a = i4 + 1;
        abyte5[i4] = abyte0[j2];
_L15:
        g = j3;
        k = i3;
        return true;
_L17:
        if (j2 == l1 - 2)
        {
            abyte3 = j;
            k3 = a;
            a = k3 + 1;
            abyte3[k3] = abyte0[j2];
            abyte4 = j;
            l3 = a;
            a = l3 + 1;
            abyte4[l3] = abyte0[j2 + 1];
        }
        if (true) goto _L15; else goto _L18
_L18:
    }

    static 
    {
        boolean flag;
        if (!com/inmobi/commons/thirdparty/Base64.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
    }

    public (int i1, byte abyte0[])
    {
        boolean flag = true;
        super();
        f = abyte0;
        boolean flag1;
        boolean flag2;
        byte abyte1[];
        int j1;
        if ((i1 & 1) == 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        b = flag1;
        if ((i1 & 2) == 0)
        {
            flag2 = flag;
        } else
        {
            flag2 = false;
        }
        c = flag2;
        if ((i1 & 4) == 0)
        {
            flag = false;
        }
        d = flag;
        if ((i1 & 8) == 0)
        {
            abyte1 = h;
        } else
        {
            abyte1 = i;
        }
        l = abyte1;
        a = 0;
        if (c)
        {
            j1 = 19;
        } else
        {
            j1 = -1;
        }
        k = j1;
    }
}
