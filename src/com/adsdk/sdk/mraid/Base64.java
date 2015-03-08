// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import java.io.UnsupportedEncodingException;

public class Base64
{

    static final boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    private Base64()
    {
    }

    public static byte[] decode(String s, int i)
    {
        return decode(s.getBytes(), i);
    }

    public static byte[] decode(byte abyte0[], int i)
    {
        return decode(abyte0, 0, abyte0.length, i);
    }

    public static byte[] decode(byte abyte0[], int i, int j, int k)
    {
        Decoder decoder = new Decoder(k, new byte[(j * 3) / 4]);
        if (!decoder.process(abyte0, i, j, true))
        {
            throw new IllegalArgumentException("bad base-64");
        }
        if (decoder.op == decoder.output.length)
        {
            return decoder.output;
        } else
        {
            byte abyte1[] = new byte[decoder.op];
            System.arraycopy(decoder.output, 0, abyte1, 0, decoder.op);
            return abyte1;
        }
    }

    public static byte[] encode(byte abyte0[], int i)
    {
        return encode(abyte0, 0, abyte0.length, i);
    }

    public static byte[] encode(byte abyte0[], int i, int j, int k)
    {
        Encoder encoder;
        int l;
        encoder = new Encoder(k, null);
        l = 4 * (j / 3);
        if (!encoder.do_padding) goto _L2; else goto _L1
_L1:
        if (j % 3 > 0)
        {
            l += 4;
        }
_L4:
        if (encoder.do_newline && j > 0)
        {
            int i1 = 1 + (j - 1) / 57;
            byte byte0;
            if (encoder.do_cr)
            {
                byte0 = 2;
            } else
            {
                byte0 = 1;
            }
            l += byte0 * i1;
        }
        encoder.output = new byte[l];
        encoder.process(abyte0, i, j, true);
        if (!$assertionsDisabled && encoder.op != l)
        {
            throw new AssertionError();
        } else
        {
            return encoder.output;
        }
_L2:
        switch (j % 3)
        {
        case 1: // '\001'
            l += 2;
            break;

        case 2: // '\002'
            l += 3;
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String encodeToString(byte abyte0[], int i)
    {
        String s;
        try
        {
            s = new String(encode(abyte0, i), "US-ASCII");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new AssertionError(unsupportedencodingexception);
        }
        return s;
    }

    public static String encodeToString(byte abyte0[], int i, int j, int k)
    {
        String s;
        try
        {
            s = new String(encode(abyte0, i, j, k), "US-ASCII");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new AssertionError(unsupportedencodingexception);
        }
        return s;
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

    private class Decoder extends Coder
    {
        private class Coder
        {

            public int op;
            public byte output[];

            public abstract int maxOutputSize(int i);

            public abstract boolean process(byte abyte0[], int i, int j, boolean flag);

            Coder()
            {
            }
        }


        private static final int DECODE[];
        private static final int DECODE_WEBSAFE[];
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int alphabet[];
        private int state;
        private int value;

        public int maxOutputSize(int i)
        {
            return 10 + (i * 3) / 4;
        }

        public boolean process(byte abyte0[], int i, int j, boolean flag)
        {
            int k;
            int i1;
            int j1;
            byte abyte1[];
            int ai[];
            int k1;
            int l1;
            if (state == 6)
            {
                return false;
            }
            k = j + i;
            int l = state;
            i1 = value;
            j1 = 0;
            abyte1 = output;
            ai = alphabet;
            k1 = l;
            l1 = i;
_L27:
            if (l1 < k) goto _L2; else goto _L1
_L1:
            int l2;
            l2 = i1;
            if (!flag)
            {
                state = k1;
                value = l2;
                op = j1;
                return true;
            }
              goto _L3
_L2:
            if (k1 != 0)
            {
                break; /* Loop/switch isn't completed */
            }
_L14:
            if (l1 + 4 > k)
            {
                continue; /* Loop/switch isn't completed */
            }
            i1 = ai[0xff & abyte0[l1]] << 18 | ai[0xff & abyte0[l1 + 1]] << 12 | ai[0xff & abyte0[l1 + 2]] << 6 | ai[0xff & abyte0[l1 + 3]];
            if (i1 >= 0) goto _L5; else goto _L4
_L4:
            if (l1 >= k) goto _L1; else goto _L6
_L6:
            int i2;
            int j2;
            i2 = l1 + 1;
            j2 = ai[0xff & abyte0[l1]];
            k1;
            JVM INSTR tableswitch 0 5: default 236
        //                       0 286
        //                       1 319
        //                       2 358
        //                       3 434
        //                       4 553
        //                       5 584;
               goto _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L7:
            l1 = i2;
            continue; /* Loop/switch isn't completed */
_L5:
            abyte1[j1 + 2] = (byte)i1;
            abyte1[j1 + 1] = (byte)(i1 >> 8);
            abyte1[j1] = (byte)(i1 >> 16);
            j1 += 3;
            l1 += 4;
              goto _L14
_L8:
            if (j2 < 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            k1++;
            i1 = j2;
            l1 = i2;
            continue; /* Loop/switch isn't completed */
            if (j2 == -1) goto _L7; else goto _L15
_L15:
            state = 6;
            return false;
_L9:
            if (j2 < 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            i1 = j2 | i1 << 6;
            k1++;
            l1 = i2;
            continue; /* Loop/switch isn't completed */
            if (j2 == -1) goto _L7; else goto _L16
_L16:
            state = 6;
            return false;
_L10:
            if (j2 >= 0)
            {
                i1 = j2 | i1 << 6;
                k1++;
                l1 = i2;
            } else
            {
                if (j2 != -2)
                {
                    continue; /* Loop/switch isn't completed */
                }
                int k2 = j1 + 1;
                abyte1[j1] = (byte)(i1 >> 4);
                k1 = 4;
                j1 = k2;
                l1 = i2;
            }
            continue; /* Loop/switch isn't completed */
            if (j2 == -1) goto _L7; else goto _L17
_L17:
            state = 6;
            return false;
_L11:
            if (j2 >= 0)
            {
                i1 = j2 | i1 << 6;
                abyte1[j1 + 2] = (byte)i1;
                abyte1[j1 + 1] = (byte)(i1 >> 8);
                abyte1[j1] = (byte)(i1 >> 16);
                j1 += 3;
                l1 = i2;
                k1 = 0;
            } else
            {
                if (j2 != -2)
                {
                    continue; /* Loop/switch isn't completed */
                }
                abyte1[j1 + 1] = (byte)(i1 >> 2);
                abyte1[j1] = (byte)(i1 >> 10);
                j1 += 2;
                k1 = 5;
                l1 = i2;
            }
            continue; /* Loop/switch isn't completed */
            if (j2 == -1) goto _L7; else goto _L18
_L18:
            state = 6;
            return false;
_L12:
            if (j2 != -2)
            {
                continue; /* Loop/switch isn't completed */
            }
            k1++;
            l1 = i2;
            continue; /* Loop/switch isn't completed */
            if (j2 == -1) goto _L7; else goto _L19
_L19:
            state = 6;
            return false;
_L13:
            if (j2 == -1) goto _L7; else goto _L20
_L20:
            state = 6;
            return false;
_L3:
            k1;
            JVM INSTR tableswitch 0 4: default 636
        //                       0 636
        //                       1 650
        //                       2 658
        //                       3 681
        //                       4 717;
               goto _L21 _L21 _L22 _L23 _L24 _L25
_L21:
            state = k1;
            op = j1;
            return true;
_L22:
            state = 6;
            return false;
_L23:
            int j3 = j1 + 1;
            abyte1[j1] = (byte)(l2 >> 4);
            j1 = j3;
            continue; /* Loop/switch isn't completed */
_L24:
            int i3 = j1 + 1;
            abyte1[j1] = (byte)(l2 >> 10);
            j1 = i3 + 1;
            abyte1[i3] = (byte)(l2 >> 2);
            if (true) goto _L21; else goto _L25
_L25:
            state = 6;
            return false;
            if (true) goto _L27; else goto _L26
_L26:
        }

        static 
        {
            int ai[] = new int[256];
            ai[0] = -1;
            ai[1] = -1;
            ai[2] = -1;
            ai[3] = -1;
            ai[4] = -1;
            ai[5] = -1;
            ai[6] = -1;
            ai[7] = -1;
            ai[8] = -1;
            ai[9] = -1;
            ai[10] = -1;
            ai[11] = -1;
            ai[12] = -1;
            ai[13] = -1;
            ai[14] = -1;
            ai[15] = -1;
            ai[16] = -1;
            ai[17] = -1;
            ai[18] = -1;
            ai[19] = -1;
            ai[20] = -1;
            ai[21] = -1;
            ai[22] = -1;
            ai[23] = -1;
            ai[24] = -1;
            ai[25] = -1;
            ai[26] = -1;
            ai[27] = -1;
            ai[28] = -1;
            ai[29] = -1;
            ai[30] = -1;
            ai[31] = -1;
            ai[32] = -1;
            ai[33] = -1;
            ai[34] = -1;
            ai[35] = -1;
            ai[36] = -1;
            ai[37] = -1;
            ai[38] = -1;
            ai[39] = -1;
            ai[40] = -1;
            ai[41] = -1;
            ai[42] = -1;
            ai[43] = 62;
            ai[44] = -1;
            ai[45] = -1;
            ai[46] = -1;
            ai[47] = 63;
            ai[48] = 52;
            ai[49] = 53;
            ai[50] = 54;
            ai[51] = 55;
            ai[52] = 56;
            ai[53] = 57;
            ai[54] = 58;
            ai[55] = 59;
            ai[56] = 60;
            ai[57] = 61;
            ai[58] = -1;
            ai[59] = -1;
            ai[60] = -1;
            ai[61] = -2;
            ai[62] = -1;
            ai[63] = -1;
            ai[64] = -1;
            ai[66] = 1;
            ai[67] = 2;
            ai[68] = 3;
            ai[69] = 4;
            ai[70] = 5;
            ai[71] = 6;
            ai[72] = 7;
            ai[73] = 8;
            ai[74] = 9;
            ai[75] = 10;
            ai[76] = 11;
            ai[77] = 12;
            ai[78] = 13;
            ai[79] = 14;
            ai[80] = 15;
            ai[81] = 16;
            ai[82] = 17;
            ai[83] = 18;
            ai[84] = 19;
            ai[85] = 20;
            ai[86] = 21;
            ai[87] = 22;
            ai[88] = 23;
            ai[89] = 24;
            ai[90] = 25;
            ai[91] = -1;
            ai[92] = -1;
            ai[93] = -1;
            ai[94] = -1;
            ai[95] = -1;
            ai[96] = -1;
            ai[97] = 26;
            ai[98] = 27;
            ai[99] = 28;
            ai[100] = 29;
            ai[101] = 30;
            ai[102] = 31;
            ai[103] = 32;
            ai[104] = 33;
            ai[105] = 34;
            ai[106] = 35;
            ai[107] = 36;
            ai[108] = 37;
            ai[109] = 38;
            ai[110] = 39;
            ai[111] = 40;
            ai[112] = 41;
            ai[113] = 42;
            ai[114] = 43;
            ai[115] = 44;
            ai[116] = 45;
            ai[117] = 46;
            ai[118] = 47;
            ai[119] = 48;
            ai[120] = 49;
            ai[121] = 50;
            ai[122] = 51;
            ai[123] = -1;
            ai[124] = -1;
            ai[125] = -1;
            ai[126] = -1;
            ai[127] = -1;
            ai[128] = -1;
            ai[129] = -1;
            ai[130] = -1;
            ai[131] = -1;
            ai[132] = -1;
            ai[133] = -1;
            ai[134] = -1;
            ai[135] = -1;
            ai[136] = -1;
            ai[137] = -1;
            ai[138] = -1;
            ai[139] = -1;
            ai[140] = -1;
            ai[141] = -1;
            ai[142] = -1;
            ai[143] = -1;
            ai[144] = -1;
            ai[145] = -1;
            ai[146] = -1;
            ai[147] = -1;
            ai[148] = -1;
            ai[149] = -1;
            ai[150] = -1;
            ai[151] = -1;
            ai[152] = -1;
            ai[153] = -1;
            ai[154] = -1;
            ai[155] = -1;
            ai[156] = -1;
            ai[157] = -1;
            ai[158] = -1;
            ai[159] = -1;
            ai[160] = -1;
            ai[161] = -1;
            ai[162] = -1;
            ai[163] = -1;
            ai[164] = -1;
            ai[165] = -1;
            ai[166] = -1;
            ai[167] = -1;
            ai[168] = -1;
            ai[169] = -1;
            ai[170] = -1;
            ai[171] = -1;
            ai[172] = -1;
            ai[173] = -1;
            ai[174] = -1;
            ai[175] = -1;
            ai[176] = -1;
            ai[177] = -1;
            ai[178] = -1;
            ai[179] = -1;
            ai[180] = -1;
            ai[181] = -1;
            ai[182] = -1;
            ai[183] = -1;
            ai[184] = -1;
            ai[185] = -1;
            ai[186] = -1;
            ai[187] = -1;
            ai[188] = -1;
            ai[189] = -1;
            ai[190] = -1;
            ai[191] = -1;
            ai[192] = -1;
            ai[193] = -1;
            ai[194] = -1;
            ai[195] = -1;
            ai[196] = -1;
            ai[197] = -1;
            ai[198] = -1;
            ai[199] = -1;
            ai[200] = -1;
            ai[201] = -1;
            ai[202] = -1;
            ai[203] = -1;
            ai[204] = -1;
            ai[205] = -1;
            ai[206] = -1;
            ai[207] = -1;
            ai[208] = -1;
            ai[209] = -1;
            ai[210] = -1;
            ai[211] = -1;
            ai[212] = -1;
            ai[213] = -1;
            ai[214] = -1;
            ai[215] = -1;
            ai[216] = -1;
            ai[217] = -1;
            ai[218] = -1;
            ai[219] = -1;
            ai[220] = -1;
            ai[221] = -1;
            ai[222] = -1;
            ai[223] = -1;
            ai[224] = -1;
            ai[225] = -1;
            ai[226] = -1;
            ai[227] = -1;
            ai[228] = -1;
            ai[229] = -1;
            ai[230] = -1;
            ai[231] = -1;
            ai[232] = -1;
            ai[233] = -1;
            ai[234] = -1;
            ai[235] = -1;
            ai[236] = -1;
            ai[237] = -1;
            ai[238] = -1;
            ai[239] = -1;
            ai[240] = -1;
            ai[241] = -1;
            ai[242] = -1;
            ai[243] = -1;
            ai[244] = -1;
            ai[245] = -1;
            ai[246] = -1;
            ai[247] = -1;
            ai[248] = -1;
            ai[249] = -1;
            ai[250] = -1;
            ai[251] = -1;
            ai[252] = -1;
            ai[253] = -1;
            ai[254] = -1;
            ai[255] = -1;
            DECODE = ai;
            int ai1[] = new int[256];
            ai1[0] = -1;
            ai1[1] = -1;
            ai1[2] = -1;
            ai1[3] = -1;
            ai1[4] = -1;
            ai1[5] = -1;
            ai1[6] = -1;
            ai1[7] = -1;
            ai1[8] = -1;
            ai1[9] = -1;
            ai1[10] = -1;
            ai1[11] = -1;
            ai1[12] = -1;
            ai1[13] = -1;
            ai1[14] = -1;
            ai1[15] = -1;
            ai1[16] = -1;
            ai1[17] = -1;
            ai1[18] = -1;
            ai1[19] = -1;
            ai1[20] = -1;
            ai1[21] = -1;
            ai1[22] = -1;
            ai1[23] = -1;
            ai1[24] = -1;
            ai1[25] = -1;
            ai1[26] = -1;
            ai1[27] = -1;
            ai1[28] = -1;
            ai1[29] = -1;
            ai1[30] = -1;
            ai1[31] = -1;
            ai1[32] = -1;
            ai1[33] = -1;
            ai1[34] = -1;
            ai1[35] = -1;
            ai1[36] = -1;
            ai1[37] = -1;
            ai1[38] = -1;
            ai1[39] = -1;
            ai1[40] = -1;
            ai1[41] = -1;
            ai1[42] = -1;
            ai1[43] = -1;
            ai1[44] = -1;
            ai1[45] = 62;
            ai1[46] = -1;
            ai1[47] = -1;
            ai1[48] = 52;
            ai1[49] = 53;
            ai1[50] = 54;
            ai1[51] = 55;
            ai1[52] = 56;
            ai1[53] = 57;
            ai1[54] = 58;
            ai1[55] = 59;
            ai1[56] = 60;
            ai1[57] = 61;
            ai1[58] = -1;
            ai1[59] = -1;
            ai1[60] = -1;
            ai1[61] = -2;
            ai1[62] = -1;
            ai1[63] = -1;
            ai1[64] = -1;
            ai1[66] = 1;
            ai1[67] = 2;
            ai1[68] = 3;
            ai1[69] = 4;
            ai1[70] = 5;
            ai1[71] = 6;
            ai1[72] = 7;
            ai1[73] = 8;
            ai1[74] = 9;
            ai1[75] = 10;
            ai1[76] = 11;
            ai1[77] = 12;
            ai1[78] = 13;
            ai1[79] = 14;
            ai1[80] = 15;
            ai1[81] = 16;
            ai1[82] = 17;
            ai1[83] = 18;
            ai1[84] = 19;
            ai1[85] = 20;
            ai1[86] = 21;
            ai1[87] = 22;
            ai1[88] = 23;
            ai1[89] = 24;
            ai1[90] = 25;
            ai1[91] = -1;
            ai1[92] = -1;
            ai1[93] = -1;
            ai1[94] = -1;
            ai1[95] = 63;
            ai1[96] = -1;
            ai1[97] = 26;
            ai1[98] = 27;
            ai1[99] = 28;
            ai1[100] = 29;
            ai1[101] = 30;
            ai1[102] = 31;
            ai1[103] = 32;
            ai1[104] = 33;
            ai1[105] = 34;
            ai1[106] = 35;
            ai1[107] = 36;
            ai1[108] = 37;
            ai1[109] = 38;
            ai1[110] = 39;
            ai1[111] = 40;
            ai1[112] = 41;
            ai1[113] = 42;
            ai1[114] = 43;
            ai1[115] = 44;
            ai1[116] = 45;
            ai1[117] = 46;
            ai1[118] = 47;
            ai1[119] = 48;
            ai1[120] = 49;
            ai1[121] = 50;
            ai1[122] = 51;
            ai1[123] = -1;
            ai1[124] = -1;
            ai1[125] = -1;
            ai1[126] = -1;
            ai1[127] = -1;
            ai1[128] = -1;
            ai1[129] = -1;
            ai1[130] = -1;
            ai1[131] = -1;
            ai1[132] = -1;
            ai1[133] = -1;
            ai1[134] = -1;
            ai1[135] = -1;
            ai1[136] = -1;
            ai1[137] = -1;
            ai1[138] = -1;
            ai1[139] = -1;
            ai1[140] = -1;
            ai1[141] = -1;
            ai1[142] = -1;
            ai1[143] = -1;
            ai1[144] = -1;
            ai1[145] = -1;
            ai1[146] = -1;
            ai1[147] = -1;
            ai1[148] = -1;
            ai1[149] = -1;
            ai1[150] = -1;
            ai1[151] = -1;
            ai1[152] = -1;
            ai1[153] = -1;
            ai1[154] = -1;
            ai1[155] = -1;
            ai1[156] = -1;
            ai1[157] = -1;
            ai1[158] = -1;
            ai1[159] = -1;
            ai1[160] = -1;
            ai1[161] = -1;
            ai1[162] = -1;
            ai1[163] = -1;
            ai1[164] = -1;
            ai1[165] = -1;
            ai1[166] = -1;
            ai1[167] = -1;
            ai1[168] = -1;
            ai1[169] = -1;
            ai1[170] = -1;
            ai1[171] = -1;
            ai1[172] = -1;
            ai1[173] = -1;
            ai1[174] = -1;
            ai1[175] = -1;
            ai1[176] = -1;
            ai1[177] = -1;
            ai1[178] = -1;
            ai1[179] = -1;
            ai1[180] = -1;
            ai1[181] = -1;
            ai1[182] = -1;
            ai1[183] = -1;
            ai1[184] = -1;
            ai1[185] = -1;
            ai1[186] = -1;
            ai1[187] = -1;
            ai1[188] = -1;
            ai1[189] = -1;
            ai1[190] = -1;
            ai1[191] = -1;
            ai1[192] = -1;
            ai1[193] = -1;
            ai1[194] = -1;
            ai1[195] = -1;
            ai1[196] = -1;
            ai1[197] = -1;
            ai1[198] = -1;
            ai1[199] = -1;
            ai1[200] = -1;
            ai1[201] = -1;
            ai1[202] = -1;
            ai1[203] = -1;
            ai1[204] = -1;
            ai1[205] = -1;
            ai1[206] = -1;
            ai1[207] = -1;
            ai1[208] = -1;
            ai1[209] = -1;
            ai1[210] = -1;
            ai1[211] = -1;
            ai1[212] = -1;
            ai1[213] = -1;
            ai1[214] = -1;
            ai1[215] = -1;
            ai1[216] = -1;
            ai1[217] = -1;
            ai1[218] = -1;
            ai1[219] = -1;
            ai1[220] = -1;
            ai1[221] = -1;
            ai1[222] = -1;
            ai1[223] = -1;
            ai1[224] = -1;
            ai1[225] = -1;
            ai1[226] = -1;
            ai1[227] = -1;
            ai1[228] = -1;
            ai1[229] = -1;
            ai1[230] = -1;
            ai1[231] = -1;
            ai1[232] = -1;
            ai1[233] = -1;
            ai1[234] = -1;
            ai1[235] = -1;
            ai1[236] = -1;
            ai1[237] = -1;
            ai1[238] = -1;
            ai1[239] = -1;
            ai1[240] = -1;
            ai1[241] = -1;
            ai1[242] = -1;
            ai1[243] = -1;
            ai1[244] = -1;
            ai1[245] = -1;
            ai1[246] = -1;
            ai1[247] = -1;
            ai1[248] = -1;
            ai1[249] = -1;
            ai1[250] = -1;
            ai1[251] = -1;
            ai1[252] = -1;
            ai1[253] = -1;
            ai1[254] = -1;
            ai1[255] = -1;
            DECODE_WEBSAFE = ai1;
        }

        public Decoder(int i, byte abyte0[])
        {
            output = abyte0;
            int ai[];
            if ((i & 8) == 0)
            {
                ai = DECODE;
            } else
            {
                ai = DECODE_WEBSAFE;
            }
            alphabet = ai;
            state = 0;
            value = 0;
        }
    }


    private class Encoder extends Coder
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
        //                       0 378
        //                       1 387
        //                       2 465;
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

        public Encoder(int i, byte abyte0[])
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

}
