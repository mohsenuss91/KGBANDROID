// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


public final class VersionCode extends Enum
{

    public static final VersionCode BASE;
    public static final VersionCode BASE_1_1;
    public static final VersionCode CUPCAKE;
    public static final VersionCode CUR_DEVELOPMENT;
    public static final VersionCode DONUT;
    public static final VersionCode ECLAIR;
    public static final VersionCode ECLAIR_0_1;
    public static final VersionCode ECLAIR_MR1;
    private static final VersionCode ENUM$VALUES[];
    public static final VersionCode FROYO;
    public static final VersionCode GINGERBREAD;
    public static final VersionCode GINGERBREAD_MR1;
    public static final VersionCode HONEYCOMB;
    public static final VersionCode HONEYCOMB_MR1;
    public static final VersionCode HONEYCOMB_MR2;
    public static final VersionCode ICE_CREAM_SANDWICH;
    public static final VersionCode ICE_CREAM_SANDWICH_MR1;
    public static final VersionCode JELLY_BEAN;
    public static final VersionCode JELLY_BEAN_MR1;
    public static final VersionCode JELLY_BEAN_MR2;
    private int mApiLevel;

    private VersionCode(String s, int i, int j)
    {
        super(s, i);
        mApiLevel = j;
    }

    public static VersionCode currentApiLevel()
    {
        return forApiLevel(android.os.Build.VERSION.SDK_INT);
    }

    private static VersionCode forApiLevel(int i)
    {
        VersionCode aversioncode[];
        int j;
        int k;
        aversioncode = values();
        j = aversioncode.length;
        k = 0;
_L6:
        if (k < j) goto _L2; else goto _L1
_L1:
        VersionCode versioncode = CUR_DEVELOPMENT;
_L4:
        return versioncode;
_L2:
        versioncode = aversioncode[k];
        if (versioncode.getApiLevel() == i) goto _L4; else goto _L3
_L3:
        k++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static VersionCode valueOf(String s)
    {
        return (VersionCode)Enum.valueOf(com/adsdk/sdk/mraid/VersionCode, s);
    }

    public static VersionCode[] values()
    {
        VersionCode aversioncode[] = ENUM$VALUES;
        int i = aversioncode.length;
        VersionCode aversioncode1[] = new VersionCode[i];
        System.arraycopy(aversioncode, 0, aversioncode1, 0, i);
        return aversioncode1;
    }

    public final int getApiLevel()
    {
        return mApiLevel;
    }

    public final boolean isAtLeast(VersionCode versioncode)
    {
        return getApiLevel() >= versioncode.getApiLevel();
    }

    public final boolean isAtMost(VersionCode versioncode)
    {
        return getApiLevel() <= versioncode.getApiLevel();
    }

    public final boolean isBelow(VersionCode versioncode)
    {
        return getApiLevel() < versioncode.getApiLevel();
    }

    static 
    {
        BASE = new VersionCode("BASE", 0, 1);
        BASE_1_1 = new VersionCode("BASE_1_1", 1, 2);
        CUPCAKE = new VersionCode("CUPCAKE", 2, 3);
        DONUT = new VersionCode("DONUT", 3, 4);
        ECLAIR = new VersionCode("ECLAIR", 4, 5);
        ECLAIR_0_1 = new VersionCode("ECLAIR_0_1", 5, 6);
        ECLAIR_MR1 = new VersionCode("ECLAIR_MR1", 6, 7);
        FROYO = new VersionCode("FROYO", 7, 8);
        GINGERBREAD = new VersionCode("GINGERBREAD", 8, 9);
        GINGERBREAD_MR1 = new VersionCode("GINGERBREAD_MR1", 9, 10);
        HONEYCOMB = new VersionCode("HONEYCOMB", 10, 11);
        HONEYCOMB_MR1 = new VersionCode("HONEYCOMB_MR1", 11, 12);
        HONEYCOMB_MR2 = new VersionCode("HONEYCOMB_MR2", 12, 13);
        ICE_CREAM_SANDWICH = new VersionCode("ICE_CREAM_SANDWICH", 13, 14);
        ICE_CREAM_SANDWICH_MR1 = new VersionCode("ICE_CREAM_SANDWICH_MR1", 14, 15);
        JELLY_BEAN = new VersionCode("JELLY_BEAN", 15, 16);
        JELLY_BEAN_MR1 = new VersionCode("JELLY_BEAN_MR1", 16, 17);
        JELLY_BEAN_MR2 = new VersionCode("JELLY_BEAN_MR2", 17, 18);
        CUR_DEVELOPMENT = new VersionCode("CUR_DEVELOPMENT", 18, 10000);
        VersionCode aversioncode[] = new VersionCode[19];
        aversioncode[0] = BASE;
        aversioncode[1] = BASE_1_1;
        aversioncode[2] = CUPCAKE;
        aversioncode[3] = DONUT;
        aversioncode[4] = ECLAIR;
        aversioncode[5] = ECLAIR_0_1;
        aversioncode[6] = ECLAIR_MR1;
        aversioncode[7] = FROYO;
        aversioncode[8] = GINGERBREAD;
        aversioncode[9] = GINGERBREAD_MR1;
        aversioncode[10] = HONEYCOMB;
        aversioncode[11] = HONEYCOMB_MR1;
        aversioncode[12] = HONEYCOMB_MR2;
        aversioncode[13] = ICE_CREAM_SANDWICH;
        aversioncode[14] = ICE_CREAM_SANDWICH_MR1;
        aversioncode[15] = JELLY_BEAN;
        aversioncode[16] = JELLY_BEAN_MR1;
        aversioncode[17] = JELLY_BEAN_MR2;
        aversioncode[18] = CUR_DEVELOPMENT;
        ENUM$VALUES = aversioncode;
    }
}
