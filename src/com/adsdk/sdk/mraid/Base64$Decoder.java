// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


class value extends value
{

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
    //                   0 286
    //                   1 319
    //                   2 358
    //                   3 434
    //                   4 553
    //                   5 584;
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
    //                   0 636
    //                   1 650
    //                   2 658
    //                   3 681
    //                   4 717;
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

    public (int i, byte abyte0[])
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
