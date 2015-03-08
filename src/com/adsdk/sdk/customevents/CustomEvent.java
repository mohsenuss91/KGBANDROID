// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.customevents;


public class CustomEvent
{

    private String className;
    private String optionalParameter;
    private String pixelUrl;

    public CustomEvent(String s, String s1, String s2)
    {
        className = s;
        optionalParameter = s1;
        pixelUrl = s2;
    }

    public String getClassName()
    {
        return className;
    }

    public String getOptionalParameter()
    {
        return optionalParameter;
    }

    public String getPixelUrl()
    {
        return pixelUrl;
    }

    public void setClassName(String s)
    {
        className = s;
    }

    public void setOptionalParameter(String s)
    {
        optionalParameter = s;
    }

    public void setPixelUrl(String s)
    {
        pixelUrl = s;
    }
}
