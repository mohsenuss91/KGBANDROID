// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.data;


public final class ClickType extends Enum
{

    public static final ClickType BROWSER;
    private static final ClickType ENUM$VALUES[];
    public static final ClickType INAPP;

    private ClickType(String s, int i)
    {
        super(s, i);
    }

    public static ClickType getValue(String s)
    {
        ClickType aclicktype[];
        int i;
        int j;
        aclicktype = values();
        i = aclicktype.length;
        j = 0;
_L6:
        if (j < i) goto _L2; else goto _L1
_L1:
        ClickType clicktype = null;
_L4:
        return clicktype;
_L2:
        clicktype = aclicktype[j];
        if (clicktype.name().equalsIgnoreCase(s)) goto _L4; else goto _L3
_L3:
        j++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static ClickType valueOf(String s)
    {
        return (ClickType)Enum.valueOf(com/adsdk/sdk/data/ClickType, s);
    }

    public static ClickType[] values()
    {
        ClickType aclicktype[] = ENUM$VALUES;
        int i = aclicktype.length;
        ClickType aclicktype1[] = new ClickType[i];
        System.arraycopy(aclicktype, 0, aclicktype1, 0, i);
        return aclicktype1;
    }

    static 
    {
        INAPP = new ClickType("INAPP", 0);
        BROWSER = new ClickType("BROWSER", 1);
        ClickType aclicktype[] = new ClickType[2];
        aclicktype[0] = INAPP;
        aclicktype[1] = BROWSER;
        ENUM$VALUES = aclicktype;
    }
}
