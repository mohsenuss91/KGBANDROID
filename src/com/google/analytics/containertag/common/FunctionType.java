// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.common;


public final class FunctionType extends Enum
{

    private static final FunctionType $VALUES[];
    public static final FunctionType ADROLL_SMART_PIXEL;
    public static final FunctionType ADVERTISER_ID;
    public static final FunctionType ADVERTISING_TRACKING_ENABLED;
    public static final FunctionType ADWORDS_CLICK_REFERRER;
    public static final FunctionType ADWORDS_CONVERSION;
    public static final FunctionType AJAX_SUBMIT_LISTENER;
    public static final FunctionType APP_ID;
    public static final FunctionType APP_NAME;
    public static final FunctionType APP_VERSION;
    public static final FunctionType ARBITRARY_HTML;
    public static final FunctionType ARBITRARY_JAVASCRIPT;
    public static final FunctionType ARBITRARY_PIXEL;
    public static final FunctionType BIZO_INSIGHT;
    public static final FunctionType CLICK_LISTENER;
    public static final FunctionType CLICK_TALE_STANDARD;
    public static final FunctionType COMSCORE_MEASUREMENT;
    public static final FunctionType CONFIGURATION_VALUE;
    public static final FunctionType CONSTANT;
    public static final FunctionType CONTAINER_VERSION;
    public static final FunctionType CONTAINS;
    public static final FunctionType COOKIE;
    public static final FunctionType CRITEO;
    public static final FunctionType CUSTOM_VAR;
    public static final FunctionType DATA_LAYER_WRITE;
    public static final FunctionType DEBUG_MODE;
    public static final FunctionType DEVICE_ID;
    public static final FunctionType DEVICE_NAME;
    public static final FunctionType DEVICE_TYPE;
    public static final FunctionType DOM_ELEMENT;
    public static final FunctionType ELEMENT_TEXT;
    public static final FunctionType ENCODE;
    public static final FunctionType ENDS_WITH;
    public static final FunctionType EQUALS;
    public static final FunctionType EVENT;
    public static final FunctionType FLOODLIGHT_COUNTER;
    public static final FunctionType FLOODLIGHT_SALES;
    public static final FunctionType FORM_SUBMIT_LISTENER;
    public static final FunctionType FUNCTION_CALL;
    public static final FunctionType GOOGLE_AFFILIATE_NETWORK;
    public static final FunctionType GOOGLE_ANALYTICS;
    public static final FunctionType GOOGLE_TAG_MANAGER;
    public static final FunctionType GREATER_EQUALS;
    public static final FunctionType GREATER_THAN;
    public static final FunctionType GTM_VERSION;
    public static final FunctionType HASH;
    public static final FunctionType HISTORY_LISTENER;
    public static final FunctionType INSTALL_REFERRER;
    public static final FunctionType JOINER;
    public static final FunctionType JS_ERROR_LISTENER;
    public static final FunctionType JS_GLOBAL;
    public static final FunctionType LANGUAGE;
    public static final FunctionType LESS_EQUALS;
    public static final FunctionType LESS_THAN;
    public static final FunctionType LINK_CLICK_LISTENER;
    public static final FunctionType MARIN_SOFTWARE;
    public static final FunctionType MEDIA6DEGREES_UNIVERSAL_PIXEL;
    public static final FunctionType MEDIAPLEX_MCT;
    public static final FunctionType MEDIAPLEX_ROI;
    public static final FunctionType MOBILE_ADWORDS_UNIQUE_ID;
    public static final FunctionType OS_VERSION;
    public static final FunctionType PLATFORM;
    public static final FunctionType QUANTCAST_MEASUREMENT;
    public static final FunctionType RANDOM;
    public static final FunctionType REFERRER;
    public static final FunctionType REGEX;
    public static final FunctionType REGEX_GROUP;
    public static final FunctionType RESOLUTION;
    public static final FunctionType RUNTIME_VERSION;
    public static final FunctionType SDK_VERSION;
    public static final FunctionType SIMPLE_MAP;
    public static final FunctionType SMART_PIXEL;
    public static final FunctionType STARTS_WITH;
    public static final FunctionType TARGUS_ADVISOR;
    public static final FunctionType TIME;
    public static final FunctionType TIMER_LISTENER;
    public static final FunctionType TRUSTED_STORES;
    public static final FunctionType TURN_CONVERSION;
    public static final FunctionType TURN_DATA_COLLECTION;
    public static final FunctionType UNIVERSAL_ANALYTICS;
    public static final FunctionType URL;
    public static final FunctionType VISUAL_DNA_CONVERSION;
    private final String name;

    private FunctionType(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static FunctionType valueOf(String s)
    {
        return (FunctionType)Enum.valueOf(com/google/analytics/containertag/common/FunctionType, s);
    }

    public static FunctionType[] values()
    {
        return (FunctionType[])$VALUES.clone();
    }

    public final String toString()
    {
        return name;
    }

    static 
    {
        ADVERTISER_ID = new FunctionType("ADVERTISER_ID", 0, "_aid");
        ADVERTISING_TRACKING_ENABLED = new FunctionType("ADVERTISING_TRACKING_ENABLED", 1, "_ate");
        APP_ID = new FunctionType("APP_ID", 2, "_ai");
        APP_NAME = new FunctionType("APP_NAME", 3, "_an");
        APP_VERSION = new FunctionType("APP_VERSION", 4, "_av");
        ARBITRARY_JAVASCRIPT = new FunctionType("ARBITRARY_JAVASCRIPT", 5, "_jsm");
        CONSTANT = new FunctionType("CONSTANT", 6, "_c");
        COOKIE = new FunctionType("COOKIE", 7, "_k");
        CUSTOM_VAR = new FunctionType("CUSTOM_VAR", 8, "_v");
        CONTAINER_VERSION = new FunctionType("CONTAINER_VERSION", 9, "_ctv");
        DEBUG_MODE = new FunctionType("DEBUG_MODE", 10, "_dbg");
        DEVICE_NAME = new FunctionType("DEVICE_NAME", 11, "_dn");
        DEVICE_TYPE = new FunctionType("DEVICE_TYPE", 12, "_dt");
        DOM_ELEMENT = new FunctionType("DOM_ELEMENT", 13, "_d");
        ELEMENT_TEXT = new FunctionType("ELEMENT_TEXT", 14, "_et");
        EVENT = new FunctionType("EVENT", 15, "_e");
        FUNCTION_CALL = new FunctionType("FUNCTION_CALL", 16, "_func");
        JS_GLOBAL = new FunctionType("JS_GLOBAL", 17, "_j");
        LANGUAGE = new FunctionType("LANGUAGE", 18, "_l");
        OS_VERSION = new FunctionType("OS_VERSION", 19, "_ov");
        PLATFORM = new FunctionType("PLATFORM", 20, "_p");
        RANDOM = new FunctionType("RANDOM", 21, "_r");
        REFERRER = new FunctionType("REFERRER", 22, "_f");
        RESOLUTION = new FunctionType("RESOLUTION", 23, "_rs");
        RUNTIME_VERSION = new FunctionType("RUNTIME_VERSION", 24, "_rv");
        SDK_VERSION = new FunctionType("SDK_VERSION", 25, "_sv");
        SIMPLE_MAP = new FunctionType("SIMPLE_MAP", 26, "_smm");
        TIME = new FunctionType("TIME", 27, "_t");
        URL = new FunctionType("URL", 28, "_u");
        ADWORDS_CLICK_REFERRER = new FunctionType("ADWORDS_CLICK_REFERRER", 29, "_awcr");
        DEVICE_ID = new FunctionType("DEVICE_ID", 30, "_did");
        ENCODE = new FunctionType("ENCODE", 31, "_enc");
        GTM_VERSION = new FunctionType("GTM_VERSION", 32, "_gtmv");
        HASH = new FunctionType("HASH", 33, "_hsh");
        INSTALL_REFERRER = new FunctionType("INSTALL_REFERRER", 34, "_ir");
        JOINER = new FunctionType("JOINER", 35, "_jn");
        MOBILE_ADWORDS_UNIQUE_ID = new FunctionType("MOBILE_ADWORDS_UNIQUE_ID", 36, "_awid");
        REGEX_GROUP = new FunctionType("REGEX_GROUP", 37, "_reg");
        DATA_LAYER_WRITE = new FunctionType("DATA_LAYER_WRITE", 38, "_dlw");
        REGEX = new FunctionType("REGEX", 39, "_re");
        STARTS_WITH = new FunctionType("STARTS_WITH", 40, "_sw");
        ENDS_WITH = new FunctionType("ENDS_WITH", 41, "_ew");
        CONTAINS = new FunctionType("CONTAINS", 42, "_cn");
        EQUALS = new FunctionType("EQUALS", 43, "_eq");
        LESS_THAN = new FunctionType("LESS_THAN", 44, "_lt");
        LESS_EQUALS = new FunctionType("LESS_EQUALS", 45, "_le");
        GREATER_THAN = new FunctionType("GREATER_THAN", 46, "_gt");
        GREATER_EQUALS = new FunctionType("GREATER_EQUALS", 47, "_ge");
        ARBITRARY_PIXEL = new FunctionType("ARBITRARY_PIXEL", 48, "_img");
        ARBITRARY_HTML = new FunctionType("ARBITRARY_HTML", 49, "_html");
        GOOGLE_TAG_MANAGER = new FunctionType("GOOGLE_TAG_MANAGER", 50, "_gtm");
        GOOGLE_ANALYTICS = new FunctionType("GOOGLE_ANALYTICS", 51, "_ga");
        ADWORDS_CONVERSION = new FunctionType("ADWORDS_CONVERSION", 52, "_awct");
        SMART_PIXEL = new FunctionType("SMART_PIXEL", 53, "_sp");
        FLOODLIGHT_COUNTER = new FunctionType("FLOODLIGHT_COUNTER", 54, "_flc");
        FLOODLIGHT_SALES = new FunctionType("FLOODLIGHT_SALES", 55, "_fls");
        BIZO_INSIGHT = new FunctionType("BIZO_INSIGHT", 56, "_bzi");
        QUANTCAST_MEASUREMENT = new FunctionType("QUANTCAST_MEASUREMENT", 57, "_qcm");
        TARGUS_ADVISOR = new FunctionType("TARGUS_ADVISOR", 58, "_ta");
        MEDIAPLEX_ROI = new FunctionType("MEDIAPLEX_ROI", 59, "_mpr");
        COMSCORE_MEASUREMENT = new FunctionType("COMSCORE_MEASUREMENT", 60, "_csm");
        TURN_CONVERSION = new FunctionType("TURN_CONVERSION", 61, "_tc");
        TURN_DATA_COLLECTION = new FunctionType("TURN_DATA_COLLECTION", 62, "_tdc");
        MEDIA6DEGREES_UNIVERSAL_PIXEL = new FunctionType("MEDIA6DEGREES_UNIVERSAL_PIXEL", 63, "_m6d");
        UNIVERSAL_ANALYTICS = new FunctionType("UNIVERSAL_ANALYTICS", 64, "_ua");
        MEDIAPLEX_MCT = new FunctionType("MEDIAPLEX_MCT", 65, "_mpm");
        VISUAL_DNA_CONVERSION = new FunctionType("VISUAL_DNA_CONVERSION", 66, "_vdc");
        GOOGLE_AFFILIATE_NETWORK = new FunctionType("GOOGLE_AFFILIATE_NETWORK", 67, "_gan");
        MARIN_SOFTWARE = new FunctionType("MARIN_SOFTWARE", 68, "_ms");
        ADROLL_SMART_PIXEL = new FunctionType("ADROLL_SMART_PIXEL", 69, "_asp");
        CONFIGURATION_VALUE = new FunctionType("CONFIGURATION_VALUE", 70, "_cv");
        CRITEO = new FunctionType("CRITEO", 71, "_crt");
        TRUSTED_STORES = new FunctionType("TRUSTED_STORES", 72, "_ts");
        CLICK_TALE_STANDARD = new FunctionType("CLICK_TALE_STANDARD", 73, "_cts");
        LINK_CLICK_LISTENER = new FunctionType("LINK_CLICK_LISTENER", 74, "_lcl");
        FORM_SUBMIT_LISTENER = new FunctionType("FORM_SUBMIT_LISTENER", 75, "_fsl");
        TIMER_LISTENER = new FunctionType("TIMER_LISTENER", 76, "_tl");
        CLICK_LISTENER = new FunctionType("CLICK_LISTENER", 77, "_cl");
        JS_ERROR_LISTENER = new FunctionType("JS_ERROR_LISTENER", 78, "_jel");
        HISTORY_LISTENER = new FunctionType("HISTORY_LISTENER", 79, "_hl");
        AJAX_SUBMIT_LISTENER = new FunctionType("AJAX_SUBMIT_LISTENER", 80, "_ajl");
        FunctionType afunctiontype[] = new FunctionType[81];
        afunctiontype[0] = ADVERTISER_ID;
        afunctiontype[1] = ADVERTISING_TRACKING_ENABLED;
        afunctiontype[2] = APP_ID;
        afunctiontype[3] = APP_NAME;
        afunctiontype[4] = APP_VERSION;
        afunctiontype[5] = ARBITRARY_JAVASCRIPT;
        afunctiontype[6] = CONSTANT;
        afunctiontype[7] = COOKIE;
        afunctiontype[8] = CUSTOM_VAR;
        afunctiontype[9] = CONTAINER_VERSION;
        afunctiontype[10] = DEBUG_MODE;
        afunctiontype[11] = DEVICE_NAME;
        afunctiontype[12] = DEVICE_TYPE;
        afunctiontype[13] = DOM_ELEMENT;
        afunctiontype[14] = ELEMENT_TEXT;
        afunctiontype[15] = EVENT;
        afunctiontype[16] = FUNCTION_CALL;
        afunctiontype[17] = JS_GLOBAL;
        afunctiontype[18] = LANGUAGE;
        afunctiontype[19] = OS_VERSION;
        afunctiontype[20] = PLATFORM;
        afunctiontype[21] = RANDOM;
        afunctiontype[22] = REFERRER;
        afunctiontype[23] = RESOLUTION;
        afunctiontype[24] = RUNTIME_VERSION;
        afunctiontype[25] = SDK_VERSION;
        afunctiontype[26] = SIMPLE_MAP;
        afunctiontype[27] = TIME;
        afunctiontype[28] = URL;
        afunctiontype[29] = ADWORDS_CLICK_REFERRER;
        afunctiontype[30] = DEVICE_ID;
        afunctiontype[31] = ENCODE;
        afunctiontype[32] = GTM_VERSION;
        afunctiontype[33] = HASH;
        afunctiontype[34] = INSTALL_REFERRER;
        afunctiontype[35] = JOINER;
        afunctiontype[36] = MOBILE_ADWORDS_UNIQUE_ID;
        afunctiontype[37] = REGEX_GROUP;
        afunctiontype[38] = DATA_LAYER_WRITE;
        afunctiontype[39] = REGEX;
        afunctiontype[40] = STARTS_WITH;
        afunctiontype[41] = ENDS_WITH;
        afunctiontype[42] = CONTAINS;
        afunctiontype[43] = EQUALS;
        afunctiontype[44] = LESS_THAN;
        afunctiontype[45] = LESS_EQUALS;
        afunctiontype[46] = GREATER_THAN;
        afunctiontype[47] = GREATER_EQUALS;
        afunctiontype[48] = ARBITRARY_PIXEL;
        afunctiontype[49] = ARBITRARY_HTML;
        afunctiontype[50] = GOOGLE_TAG_MANAGER;
        afunctiontype[51] = GOOGLE_ANALYTICS;
        afunctiontype[52] = ADWORDS_CONVERSION;
        afunctiontype[53] = SMART_PIXEL;
        afunctiontype[54] = FLOODLIGHT_COUNTER;
        afunctiontype[55] = FLOODLIGHT_SALES;
        afunctiontype[56] = BIZO_INSIGHT;
        afunctiontype[57] = QUANTCAST_MEASUREMENT;
        afunctiontype[58] = TARGUS_ADVISOR;
        afunctiontype[59] = MEDIAPLEX_ROI;
        afunctiontype[60] = COMSCORE_MEASUREMENT;
        afunctiontype[61] = TURN_CONVERSION;
        afunctiontype[62] = TURN_DATA_COLLECTION;
        afunctiontype[63] = MEDIA6DEGREES_UNIVERSAL_PIXEL;
        afunctiontype[64] = UNIVERSAL_ANALYTICS;
        afunctiontype[65] = MEDIAPLEX_MCT;
        afunctiontype[66] = VISUAL_DNA_CONVERSION;
        afunctiontype[67] = GOOGLE_AFFILIATE_NETWORK;
        afunctiontype[68] = MARIN_SOFTWARE;
        afunctiontype[69] = ADROLL_SMART_PIXEL;
        afunctiontype[70] = CONFIGURATION_VALUE;
        afunctiontype[71] = CRITEO;
        afunctiontype[72] = TRUSTED_STORES;
        afunctiontype[73] = CLICK_TALE_STANDARD;
        afunctiontype[74] = LINK_CLICK_LISTENER;
        afunctiontype[75] = FORM_SUBMIT_LISTENER;
        afunctiontype[76] = TIMER_LISTENER;
        afunctiontype[77] = CLICK_LISTENER;
        afunctiontype[78] = JS_ERROR_LISTENER;
        afunctiontype[79] = HISTORY_LISTENER;
        afunctiontype[80] = AJAX_SUBMIT_LISTENER;
        $VALUES = afunctiontype;
    }
}
