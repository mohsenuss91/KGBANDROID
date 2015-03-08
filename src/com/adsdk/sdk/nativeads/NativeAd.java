// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NativeAd
{

    private String clickUrl;
    private Map imageAssets;
    private Map textAssets;
    private List trackers;

    public NativeAd()
    {
        imageAssets = new HashMap();
        textAssets = new HashMap();
        trackers = new ArrayList();
    }

    public void addImageAsset(String s, ImageAsset imageasset)
    {
        imageAssets.put(s, imageasset);
    }

    public void addTextAsset(String s, String s1)
    {
        textAssets.put(s, s1);
    }

    public String getClickUrl()
    {
        return clickUrl;
    }

    public ImageAsset getImageAsset(String s)
    {
        return (ImageAsset)imageAssets.get(s);
    }

    public String getTextAsset(String s)
    {
        return (String)textAssets.get(s);
    }

    public List getTrackers()
    {
        return trackers;
    }

    public void setClickUrl(String s)
    {
        clickUrl = s;
    }

    public void setTrackers(List list)
    {
        trackers = list;
    }

    private class ImageAsset
    {

        Bitmap bitmap;
        int height;
        String url;
        int width;

        public ImageAsset()
        {
        }
    }

}
