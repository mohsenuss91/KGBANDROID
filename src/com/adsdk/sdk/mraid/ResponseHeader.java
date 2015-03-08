// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


public final class ResponseHeader extends Enum
{

    public static final ResponseHeader AD_TIMEOUT;
    public static final ResponseHeader AD_TYPE;
    public static final ResponseHeader CLICKTHROUGH_URL;
    public static final ResponseHeader CUSTOM_EVENT_DATA;
    public static final ResponseHeader CUSTOM_EVENT_HTML_DATA;
    public static final ResponseHeader CUSTOM_EVENT_NAME;
    public static final ResponseHeader CUSTOM_SELECTOR;
    public static final ResponseHeader DSP_CREATIVE_ID;
    private static final ResponseHeader ENUM$VALUES[];
    public static final ResponseHeader FAIL_URL;
    public static final ResponseHeader FULL_AD_TYPE;
    public static final ResponseHeader HEIGHT;
    public static final ResponseHeader IMPRESSION_URL;
    public static final ResponseHeader LOCATION;
    public static final ResponseHeader NATIVE_PARAMS;
    public static final ResponseHeader NETWORK_TYPE;
    public static final ResponseHeader REDIRECT_URL;
    public static final ResponseHeader REFRESH_TIME;
    public static final ResponseHeader SCROLLABLE;
    public static final ResponseHeader USER_AGENT;
    public static final ResponseHeader WARMUP;
    public static final ResponseHeader WIDTH;
    private final String key;

    private ResponseHeader(String s, int i, String s1)
    {
        super(s, i);
        key = s1;
    }

    public static ResponseHeader valueOf(String s)
    {
        return (ResponseHeader)Enum.valueOf(com/adsdk/sdk/mraid/ResponseHeader, s);
    }

    public static ResponseHeader[] values()
    {
        ResponseHeader aresponseheader[] = ENUM$VALUES;
        int i = aresponseheader.length;
        ResponseHeader aresponseheader1[] = new ResponseHeader[i];
        System.arraycopy(aresponseheader, 0, aresponseheader1, 0, i);
        return aresponseheader1;
    }

    public final String getKey()
    {
        return key;
    }

    static 
    {
        AD_TIMEOUT = new ResponseHeader("AD_TIMEOUT", 0, "X-AdTimeout");
        AD_TYPE = new ResponseHeader("AD_TYPE", 1, "X-Adtype");
        CLICKTHROUGH_URL = new ResponseHeader("CLICKTHROUGH_URL", 2, "X-Clickthrough");
        CUSTOM_EVENT_DATA = new ResponseHeader("CUSTOM_EVENT_DATA", 3, "X-Custom-Event-Class-Data");
        CUSTOM_EVENT_NAME = new ResponseHeader("CUSTOM_EVENT_NAME", 4, "X-Custom-Event-Class-Name");
        CUSTOM_EVENT_HTML_DATA = new ResponseHeader("CUSTOM_EVENT_HTML_DATA", 5, "X-Custom-Event-Html-Data");
        DSP_CREATIVE_ID = new ResponseHeader("DSP_CREATIVE_ID", 6, "X-DspCreativeid");
        FAIL_URL = new ResponseHeader("FAIL_URL", 7, "X-Failurl");
        FULL_AD_TYPE = new ResponseHeader("FULL_AD_TYPE", 8, "X-Fulladtype");
        HEIGHT = new ResponseHeader("HEIGHT", 9, "X-Height");
        IMPRESSION_URL = new ResponseHeader("IMPRESSION_URL", 10, "X-Imptracker");
        REDIRECT_URL = new ResponseHeader("REDIRECT_URL", 11, "X-Launchpage");
        NATIVE_PARAMS = new ResponseHeader("NATIVE_PARAMS", 12, "X-Nativeparams");
        NETWORK_TYPE = new ResponseHeader("NETWORK_TYPE", 13, "X-Networktype");
        REFRESH_TIME = new ResponseHeader("REFRESH_TIME", 14, "X-Refreshtime");
        SCROLLABLE = new ResponseHeader("SCROLLABLE", 15, "X-Scrollable");
        WARMUP = new ResponseHeader("WARMUP", 16, "X-Warmup");
        WIDTH = new ResponseHeader("WIDTH", 17, "X-Width");
        LOCATION = new ResponseHeader("LOCATION", 18, "Location");
        USER_AGENT = new ResponseHeader("USER_AGENT", 19, "User-Agent");
        CUSTOM_SELECTOR = new ResponseHeader("CUSTOM_SELECTOR", 20, "X-Customselector");
        ResponseHeader aresponseheader[] = new ResponseHeader[21];
        aresponseheader[0] = AD_TIMEOUT;
        aresponseheader[1] = AD_TYPE;
        aresponseheader[2] = CLICKTHROUGH_URL;
        aresponseheader[3] = CUSTOM_EVENT_DATA;
        aresponseheader[4] = CUSTOM_EVENT_NAME;
        aresponseheader[5] = CUSTOM_EVENT_HTML_DATA;
        aresponseheader[6] = DSP_CREATIVE_ID;
        aresponseheader[7] = FAIL_URL;
        aresponseheader[8] = FULL_AD_TYPE;
        aresponseheader[9] = HEIGHT;
        aresponseheader[10] = IMPRESSION_URL;
        aresponseheader[11] = REDIRECT_URL;
        aresponseheader[12] = NATIVE_PARAMS;
        aresponseheader[13] = NETWORK_TYPE;
        aresponseheader[14] = REFRESH_TIME;
        aresponseheader[15] = SCROLLABLE;
        aresponseheader[16] = WARMUP;
        aresponseheader[17] = WIDTH;
        aresponseheader[18] = LOCATION;
        aresponseheader[19] = USER_AGENT;
        aresponseheader[20] = CUSTOM_SELECTOR;
        ENUM$VALUES = aresponseheader;
    }
}
