// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


final class mCommand extends Enum
{

    public static final ENUM.VALUES CLOSE;
    public static final ENUM.VALUES CREATE_CALENDAR_EVENT;
    private static final ENUM.VALUES ENUM$VALUES[];
    public static final ENUM.VALUES EXPAND;
    public static final ENUM.VALUES GET_CURRENT_POSITION;
    public static final ENUM.VALUES GET_DEFAULT_POSITION;
    public static final ENUM.VALUES GET_MAX_SIZE;
    public static final ENUM.VALUES GET_RESIZE_PROPERTIES;
    public static final ENUM.VALUES GET_SCREEN_SIZE;
    public static final ENUM.VALUES OPEN;
    public static final ENUM.VALUES PLAY_VIDEO;
    public static final ENUM.VALUES RESIZE;
    public static final ENUM.VALUES SET_RESIZE_PROPERTIES;
    public static final ENUM.VALUES STORE_PICTURE;
    public static final ENUM.VALUES UNSPECIFIED;
    public static final ENUM.VALUES USECUSTOMCLOSE;
    private String mCommand;

    private static mCommand fromString(String s)
    {
        mCommand amcommand[];
        int i;
        int j;
        amcommand = values();
        i = amcommand.length;
        j = 0;
_L6:
        if (j < i) goto _L2; else goto _L1
_L1:
        mCommand mcommand = UNSPECIFIED;
_L4:
        return mcommand;
_L2:
        mcommand = amcommand[j];
        if (mcommand.mCommand.equals(s)) goto _L4; else goto _L3
_L3:
        j++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static mCommand valueOf(String s)
    {
        return (mCommand)Enum.valueOf(com/adsdk/sdk/mraid/MraidCommandFactory$MraidJavascriptCommand, s);
    }

    public static mCommand[] values()
    {
        mCommand amcommand[] = ENUM$VALUES;
        int i = amcommand.length;
        mCommand amcommand1[] = new ENUM.VALUES[i];
        System.arraycopy(amcommand, 0, amcommand1, 0, i);
        return amcommand1;
    }

    final String getCommand()
    {
        return mCommand;
    }

    static 
    {
        CLOSE = new <init>("CLOSE", 0, "close");
        EXPAND = new <init>("EXPAND", 1, "expand");
        USECUSTOMCLOSE = new <init>("USECUSTOMCLOSE", 2, "usecustomclose");
        OPEN = new <init>("OPEN", 3, "open");
        RESIZE = new <init>("RESIZE", 4, "resize");
        GET_RESIZE_PROPERTIES = new <init>("GET_RESIZE_PROPERTIES", 5, "getResizeProperties");
        SET_RESIZE_PROPERTIES = new <init>("SET_RESIZE_PROPERTIES", 6, "setResizeProperties");
        PLAY_VIDEO = new <init>("PLAY_VIDEO", 7, "playVideo");
        STORE_PICTURE = new <init>("STORE_PICTURE", 8, "storePicture");
        GET_CURRENT_POSITION = new <init>("GET_CURRENT_POSITION", 9, "getCurrentPosition");
        GET_DEFAULT_POSITION = new <init>("GET_DEFAULT_POSITION", 10, "getDefaultPosition");
        GET_MAX_SIZE = new <init>("GET_MAX_SIZE", 11, "getMaxSize");
        GET_SCREEN_SIZE = new <init>("GET_SCREEN_SIZE", 12, "getScreenSize");
        CREATE_CALENDAR_EVENT = new <init>("CREATE_CALENDAR_EVENT", 13, "createCalendarEvent");
        UNSPECIFIED = new <init>("UNSPECIFIED", 14, "");
        mCommand amcommand[] = new <init>[15];
        amcommand[0] = CLOSE;
        amcommand[1] = EXPAND;
        amcommand[2] = USECUSTOMCLOSE;
        amcommand[3] = OPEN;
        amcommand[4] = RESIZE;
        amcommand[5] = GET_RESIZE_PROPERTIES;
        amcommand[6] = SET_RESIZE_PROPERTIES;
        amcommand[7] = PLAY_VIDEO;
        amcommand[8] = STORE_PICTURE;
        amcommand[9] = GET_CURRENT_POSITION;
        amcommand[10] = GET_DEFAULT_POSITION;
        amcommand[11] = GET_MAX_SIZE;
        amcommand[12] = GET_SCREEN_SIZE;
        amcommand[13] = CREATE_CALENDAR_EVENT;
        amcommand[14] = UNSPECIFIED;
        ENUM$VALUES = amcommand;
    }


    private (String s, int i, String s1)
    {
        super(s, i);
        mCommand = s1;
    }
}
