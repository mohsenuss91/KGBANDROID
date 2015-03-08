// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


final class mUrl extends Enum
{

    private static final ENUM.VALUES ENUM$VALUES[];
    public static final ENUM.VALUES WEB_VIEW_DID_APPEAR;
    public static final ENUM.VALUES WEB_VIEW_DID_CLOSE;
    private String mUrl;

    public static mUrl valueOf(String s)
    {
        return (mUrl)Enum.valueOf(com/adsdk/sdk/mraid/BaseInterstitialActivity$JavaScriptWebViewCallbacks, s);
    }

    public static mUrl[] values()
    {
        mUrl amurl[] = ENUM$VALUES;
        int i = amurl.length;
        mUrl amurl1[] = new ENUM.VALUES[i];
        System.arraycopy(amurl, 0, amurl1, 0, i);
        return amurl1;
    }

    protected final String getUrl()
    {
        return mUrl;
    }

    static 
    {
        WEB_VIEW_DID_APPEAR = new <init>("WEB_VIEW_DID_APPEAR", 0, "javascript:webviewDidAppear();");
        WEB_VIEW_DID_CLOSE = new <init>("WEB_VIEW_DID_CLOSE", 1, "javascript:webviewDidClose();");
        mUrl amurl[] = new <init>[2];
        amurl[0] = WEB_VIEW_DID_APPEAR;
        amurl[1] = WEB_VIEW_DID_CLOSE;
        ENUM$VALUES = amurl;
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mUrl = s1;
    }
}
