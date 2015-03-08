// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


// Referenced classes of package com.adsdk.sdk.mraid:
//            Base64

class count extends count
{

    static final boolean $assertionsDisabled = false;
    private static final byte ENCODE[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte ENCODE_WEBSAFE[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    public static final int LINE_GROUPS = 19;
    private final byte alphabet[];
    private int count;
    public final boolean do_cr;
    public final boolean do_newline;
    public final boolean do_padding;
    private final byte tail[] = new byte[2];
    int tailLen;

    public int maxOutputSize(int i)
    {
        return 10 + (i * 8) / 5;
    }

    public boolean process(byte abyte0[], int i, int j, boolean flag)
    {
        byte abyte1[];
        byte abyte2[];
        int k;
        int l;
        abyte1 = alphabet;
        abyte2 = output;
        k = count;
        l = j + i;
        tailLen;
        JVM INSTR tableswitch 0 2: default 52
    //                   0 378
    //                   1 387
    //                   2 465;
           goto _L1 _L2 _L3 _L4
_L1:
        int j1;
        int l1;
        l1 = -1;
        j1 = i;
_L12:
        int i2;
        int j2;
        if (l1 != -1)
        {
            abyte2[0] = abyte1[0x3f & l1 >> 18];
            abyte2[1] = abyte1[0x3f & l1 >> 12];
            abyte2[2] = abyte1[0x3f & l1 >> 6];
            byte byte3 = 4;
            abyte2[3] = abyte1[l1 & 0x3f];
            int i9 = k - 1;
            int i1;
            int k1;
            int k2;
            int l2;
            int i3;
            int j3;
            int k3;
            byte abyte3[];
            int l3;
            byte abyte4[];
            int i4;
            byte abyte5[];
            int j4;
            int k4;
            int l4;
            byte byte0;
            int i5;
            int j5;
            int k5;
            byte byte1;
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
            byte abyte8[];
            int j9;
            int k9;
            int l9;
            int i10;
            int j10;
            if (i9 == 0)
            {
                if (do_cr)
                {
                    byte3 = 5;
                    abyte2[4] = 13;
                }
                j2 = byte3 + 1;
                abyte2[byte3] = 10;
                i2 = 19;
            } else
            {
                i2 = i9;
                j2 = byte3;
            }
        } else
        {
            i2 = k;
            j2 = 0;
        }
_L15:
        if (j1 + 3 <= l) goto _L6; else goto _L5
_L5:
        if (!flag) goto _L8; else goto _L7
_L7:
        if (j1 - tailLen != l - 1) goto _L10; else goto _L9
_L9:
label0:
        {
            if (tailLen > 0)
            {
                abyte8 = tail;
                l7 = 1;
                byte2 = abyte8[0];
            } else
            {
                k7 = j1 + 1;
                byte2 = abyte0[j1];
                j1 = k7;
                l7 = 0;
            }
            i8 = (byte2 & 0xff) << 4;
            tailLen = tailLen - l7;
            j8 = j2 + 1;
            abyte2[j2] = abyte1[0x3f & i8 >> 6];
            l6 = j8 + 1;
            abyte2[j8] = abyte1[i8 & 0x3f];
            if (do_padding)
            {
                l8 = l6 + 1;
                abyte2[l6] = 61;
                l6 = l8 + 1;
                abyte2[l8] = 61;
            }
            if (do_newline)
            {
                if (do_cr)
                {
                    k8 = l6 + 1;
                    abyte2[l6] = 13;
                    l6 = k8;
                }
                j2 = l6 + 1;
                abyte2[l6] = 10;
                break label0;
            }
        }
          goto _L11
_L2:
        l1 = -1;
        j1 = i;
          goto _L12
_L3:
        if (i + 2 > l) goto _L1; else goto _L13
_L13:
        j9 = (0xff & tail[0]) << 16;
        k9 = i + 1;
        l9 = j9 | (0xff & abyte0[i]) << 8;
        i10 = k9 + 1;
        j10 = l9 | 0xff & abyte0[k9];
        tailLen = 0;
        l1 = j10;
        j1 = i10;
          goto _L12
_L4:
        if (i + 1 > l) goto _L1; else goto _L14
_L14:
        i1 = (0xff & tail[0]) << 16 | (0xff & tail[1]) << 8;
        j1 = i + 1;
        k1 = i1 | 0xff & abyte0[i];
        tailLen = 0;
        l1 = k1;
          goto _L12
_L6:
        k2 = (0xff & abyte0[j1]) << 16 | (0xff & abyte0[j1 + 1]) << 8 | 0xff & abyte0[j1 + 2];
        abyte2[j2] = abyte1[0x3f & k2 >> 18];
        abyte2[j2 + 1] = abyte1[0x3f & k2 >> 12];
        abyte2[j2 + 2] = abyte1[0x3f & k2 >> 6];
        abyte2[j2 + 3] = abyte1[k2 & 0x3f];
        l2 = j1 + 3;
        i3 = j2 + 4;
        j3 = i2 - 1;
        if (j3 == 0)
        {
            if (do_cr)
            {
                k3 = i3 + 1;
                abyte2[i3] = 13;
            } else
            {
                k3 = i3;
            }
            j2 = k3 + 1;
            abyte2[k3] = 10;
            j1 = l2;
            i2 = 19;
        } else
        {
            i2 = j3;
            j2 = i3;
            j1 = l2;
        }
          goto _L15
_L10:
        if (j1 - tailLen != l - 2) goto _L17; else goto _L16
_L16:
        if (tailLen > 1)
        {
            abyte7 = tail;
            i5 = 1;
            byte0 = abyte7[0];
        } else
        {
            l4 = j1 + 1;
            byte0 = abyte0[j1];
            j1 = l4;
            i5 = 0;
        }
        j5 = (byte0 & 0xff) << 10;
        if (tailLen > 0)
        {
            abyte6 = tail;
            j7 = i5 + 1;
            byte1 = abyte6[i5];
            i5 = j7;
        } else
        {
            k5 = j1 + 1;
            byte1 = abyte0[j1];
            j1 = k5;
        }
        l5 = j5 | (byte1 & 0xff) << 2;
        tailLen = tailLen - i5;
        i6 = j2 + 1;
        abyte2[j2] = abyte1[0x3f & l5 >> 12];
        j6 = i6 + 1;
        abyte2[i6] = abyte1[0x3f & l5 >> 6];
        k6 = j6 + 1;
        abyte2[j6] = abyte1[l5 & 0x3f];
        if (do_padding)
        {
            l6 = k6 + 1;
            abyte2[k6] = 61;
        } else
        {
            l6 = k6;
        }
        if (do_newline)
        {
            if (do_cr)
            {
                i7 = l6 + 1;
                abyte2[l6] = 13;
                l6 = i7;
            }
            j2 = l6 + 1;
            abyte2[l6] = 10;
            continue; /* Loop/switch isn't completed */
        }
          goto _L11
_L17:
        if (do_newline && j2 > 0 && i2 != 19)
        {
            if (do_cr)
            {
                k4 = j2 + 1;
                abyte2[j2] = 13;
            } else
            {
                k4 = j2;
            }
            j2 = k4 + 1;
            abyte2[k4] = 10;
        }
_L22:
        if (!$assertionsDisabled && tailLen != 0)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && j1 != l)
        {
            throw new AssertionError();
        }
          goto _L18
_L8:
        if (j1 != l - 1) goto _L20; else goto _L19
_L19:
        abyte5 = tail;
        j4 = tailLen;
        tailLen = j4 + 1;
        abyte5[j4] = abyte0[j1];
_L18:
        op = j2;
        count = i2;
        return true;
_L20:
        if (j1 == l - 2)
        {
            abyte3 = tail;
            l3 = tailLen;
            tailLen = l3 + 1;
            abyte3[l3] = abyte0[j1];
            abyte4 = tail;
            i4 = tailLen;
            tailLen = i4 + 1;
            abyte4[i4] = abyte0[j1 + 1];
        }
        if (true) goto _L18; else goto _L11
_L11:
        j2 = l6;
        if (true) goto _L22; else goto _L21
_L21:
          goto _L15
    }

    static 
    {
        boolean flag;
        if (!com/adsdk/sdk/mraid/Base64.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

    public (int i, byte abyte0[])
    {
        boolean flag = true;
        super();
        output = abyte0;
        boolean flag1;
        boolean flag2;
        byte abyte1[];
        int j;
        if ((i & 1) == 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        do_padding = flag1;
        if ((i & 2) == 0)
        {
            flag2 = flag;
        } else
        {
            flag2 = false;
        }
        do_newline = flag2;
        if ((i & 4) == 0)
        {
            flag = false;
        }
        do_cr = flag;
        if ((i & 8) == 0)
        {
            abyte1 = ENCODE;
        } else
        {
            abyte1 = ENCODE_WEBSAFE;
        }
        alphabet = abyte1;
        tailLen = 0;
        if (do_newline)
        {
            j = 19;
        } else
        {
            j = -1;
        }
        count = j;
    }
}
