// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import java.util.Map;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidCommandClose, MraidCommandExpand, MraidCommandUseCustomClose, MraidCommandOpen, 
//            MraidCommandResize, MraidCommandGetResizeProperties, MraidCommandSetResizeProperties, MraidCommandPlayVideo, 
//            MraidCommandStorePicture, MraidCommandGetCurrentPosition, MraidCommandGetDefaultPosition, MraidCommandGetMaxSize, 
//            MraidCommandGetScreenSize, MraidCommandCreateCalendarEvent, MraidView, MraidCommand

class MraidCommandFactory
{

    private static int $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidCommandFactory$MraidJavascriptCommand[];
    protected static MraidCommandFactory instance = new MraidCommandFactory();

    static int[] $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidCommandFactory$MraidJavascriptCommand()
    {
        int ai[] = $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidCommandFactory$MraidJavascriptCommand;
        if (ai != null)
        {
            return ai;
        }
        int ai1[] = new int[MraidJavascriptCommand.values().length];
        try
        {
            ai1[MraidJavascriptCommand.CLOSE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            ai1[MraidJavascriptCommand.CREATE_CALENDAR_EVENT.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai1[MraidJavascriptCommand.EXPAND.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai1[MraidJavascriptCommand.GET_CURRENT_POSITION.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai1[MraidJavascriptCommand.GET_DEFAULT_POSITION.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai1[MraidJavascriptCommand.GET_MAX_SIZE.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai1[MraidJavascriptCommand.GET_RESIZE_PROPERTIES.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai1[MraidJavascriptCommand.GET_SCREEN_SIZE.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            ai1[MraidJavascriptCommand.OPEN.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            ai1[MraidJavascriptCommand.PLAY_VIDEO.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            ai1[MraidJavascriptCommand.RESIZE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            ai1[MraidJavascriptCommand.SET_RESIZE_PROPERTIES.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            ai1[MraidJavascriptCommand.STORE_PICTURE.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            ai1[MraidJavascriptCommand.UNSPECIFIED.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            ai1[MraidJavascriptCommand.USECUSTOMCLOSE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidCommandFactory$MraidJavascriptCommand = ai1;
        return ai1;
    }

    MraidCommandFactory()
    {
    }

    public static MraidCommand create(String s, Map map, MraidView mraidview)
    {
        return instance.internalCreate(s, map, mraidview);
    }

    public static void setInstance(MraidCommandFactory mraidcommandfactory)
    {
        instance = mraidcommandfactory;
    }

    protected MraidCommand internalCreate(String s, Map map, MraidView mraidview)
    {
        MraidJavascriptCommand mraidjavascriptcommand = MraidJavascriptCommand.fromString(s);
        switch ($SWITCH_TABLE$com$adsdk$sdk$mraid$MraidCommandFactory$MraidJavascriptCommand()[mraidjavascriptcommand.ordinal()])
        {
        case 15: // '\017'
        default:
            return null;

        case 1: // '\001'
            return new MraidCommandClose(map, mraidview);

        case 2: // '\002'
            return new MraidCommandExpand(map, mraidview);

        case 3: // '\003'
            return new MraidCommandUseCustomClose(map, mraidview);

        case 4: // '\004'
            return new MraidCommandOpen(map, mraidview);

        case 5: // '\005'
            return new MraidCommandResize(map, mraidview);

        case 6: // '\006'
            return new MraidCommandGetResizeProperties(map, mraidview);

        case 7: // '\007'
            return new MraidCommandSetResizeProperties(map, mraidview);

        case 8: // '\b'
            return new MraidCommandPlayVideo(map, mraidview);

        case 9: // '\t'
            return new MraidCommandStorePicture(map, mraidview);

        case 10: // '\n'
            return new MraidCommandGetCurrentPosition(map, mraidview);

        case 11: // '\013'
            return new MraidCommandGetDefaultPosition(map, mraidview);

        case 12: // '\f'
            return new MraidCommandGetMaxSize(map, mraidview);

        case 13: // '\r'
            return new MraidCommandGetScreenSize(map, mraidview);

        case 14: // '\016'
            return new MraidCommandCreateCalendarEvent(map, mraidview);
        }
    }


    private class MraidJavascriptCommand extends Enum
    {

        public static final MraidJavascriptCommand CLOSE;
        public static final MraidJavascriptCommand CREATE_CALENDAR_EVENT;
        private static final MraidJavascriptCommand ENUM$VALUES[];
        public static final MraidJavascriptCommand EXPAND;
        public static final MraidJavascriptCommand GET_CURRENT_POSITION;
        public static final MraidJavascriptCommand GET_DEFAULT_POSITION;
        public static final MraidJavascriptCommand GET_MAX_SIZE;
        public static final MraidJavascriptCommand GET_RESIZE_PROPERTIES;
        public static final MraidJavascriptCommand GET_SCREEN_SIZE;
        public static final MraidJavascriptCommand OPEN;
        public static final MraidJavascriptCommand PLAY_VIDEO;
        public static final MraidJavascriptCommand RESIZE;
        public static final MraidJavascriptCommand SET_RESIZE_PROPERTIES;
        public static final MraidJavascriptCommand STORE_PICTURE;
        public static final MraidJavascriptCommand UNSPECIFIED;
        public static final MraidJavascriptCommand USECUSTOMCLOSE;
        private String mCommand;

        private static MraidJavascriptCommand fromString(String s)
        {
            MraidJavascriptCommand amraidjavascriptcommand[];
            int i;
            int j;
            amraidjavascriptcommand = values();
            i = amraidjavascriptcommand.length;
            j = 0;
_L6:
            if (j < i) goto _L2; else goto _L1
_L1:
            MraidJavascriptCommand mraidjavascriptcommand = UNSPECIFIED;
_L4:
            return mraidjavascriptcommand;
_L2:
            mraidjavascriptcommand = amraidjavascriptcommand[j];
            if (mraidjavascriptcommand.mCommand.equals(s)) goto _L4; else goto _L3
_L3:
            j++;
            if (true) goto _L6; else goto _L5
_L5:
        }

        public static MraidJavascriptCommand valueOf(String s)
        {
            return (MraidJavascriptCommand)Enum.valueOf(com/adsdk/sdk/mraid/MraidCommandFactory$MraidJavascriptCommand, s);
        }

        public static MraidJavascriptCommand[] values()
        {
            MraidJavascriptCommand amraidjavascriptcommand[] = ENUM$VALUES;
            int i = amraidjavascriptcommand.length;
            MraidJavascriptCommand amraidjavascriptcommand1[] = new MraidJavascriptCommand[i];
            System.arraycopy(amraidjavascriptcommand, 0, amraidjavascriptcommand1, 0, i);
            return amraidjavascriptcommand1;
        }

        final String getCommand()
        {
            return mCommand;
        }

        static 
        {
            CLOSE = new MraidJavascriptCommand("CLOSE", 0, "close");
            EXPAND = new MraidJavascriptCommand("EXPAND", 1, "expand");
            USECUSTOMCLOSE = new MraidJavascriptCommand("USECUSTOMCLOSE", 2, "usecustomclose");
            OPEN = new MraidJavascriptCommand("OPEN", 3, "open");
            RESIZE = new MraidJavascriptCommand("RESIZE", 4, "resize");
            GET_RESIZE_PROPERTIES = new MraidJavascriptCommand("GET_RESIZE_PROPERTIES", 5, "getResizeProperties");
            SET_RESIZE_PROPERTIES = new MraidJavascriptCommand("SET_RESIZE_PROPERTIES", 6, "setResizeProperties");
            PLAY_VIDEO = new MraidJavascriptCommand("PLAY_VIDEO", 7, "playVideo");
            STORE_PICTURE = new MraidJavascriptCommand("STORE_PICTURE", 8, "storePicture");
            GET_CURRENT_POSITION = new MraidJavascriptCommand("GET_CURRENT_POSITION", 9, "getCurrentPosition");
            GET_DEFAULT_POSITION = new MraidJavascriptCommand("GET_DEFAULT_POSITION", 10, "getDefaultPosition");
            GET_MAX_SIZE = new MraidJavascriptCommand("GET_MAX_SIZE", 11, "getMaxSize");
            GET_SCREEN_SIZE = new MraidJavascriptCommand("GET_SCREEN_SIZE", 12, "getScreenSize");
            CREATE_CALENDAR_EVENT = new MraidJavascriptCommand("CREATE_CALENDAR_EVENT", 13, "createCalendarEvent");
            UNSPECIFIED = new MraidJavascriptCommand("UNSPECIFIED", 14, "");
            MraidJavascriptCommand amraidjavascriptcommand[] = new MraidJavascriptCommand[15];
            amraidjavascriptcommand[0] = CLOSE;
            amraidjavascriptcommand[1] = EXPAND;
            amraidjavascriptcommand[2] = USECUSTOMCLOSE;
            amraidjavascriptcommand[3] = OPEN;
            amraidjavascriptcommand[4] = RESIZE;
            amraidjavascriptcommand[5] = GET_RESIZE_PROPERTIES;
            amraidjavascriptcommand[6] = SET_RESIZE_PROPERTIES;
            amraidjavascriptcommand[7] = PLAY_VIDEO;
            amraidjavascriptcommand[8] = STORE_PICTURE;
            amraidjavascriptcommand[9] = GET_CURRENT_POSITION;
            amraidjavascriptcommand[10] = GET_DEFAULT_POSITION;
            amraidjavascriptcommand[11] = GET_MAX_SIZE;
            amraidjavascriptcommand[12] = GET_SCREEN_SIZE;
            amraidjavascriptcommand[13] = CREATE_CALENDAR_EVENT;
            amraidjavascriptcommand[14] = UNSPECIFIED;
            ENUM$VALUES = amraidjavascriptcommand;
        }


        private MraidJavascriptCommand(String s, int i, String s1)
        {
            super(s, i);
            mCommand = s1;
        }
    }

}
