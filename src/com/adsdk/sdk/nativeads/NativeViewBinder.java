// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NativeViewBinder
{

    private int adLayoutId;
    private Map imageAssetsBidings;
    private Map textAssetsBidings;

    public NativeViewBinder(int i)
    {
        adLayoutId = i;
        textAssetsBidings = new HashMap();
        imageAssetsBidings = new HashMap();
    }

    public void bindImageAsset(String s, int i)
    {
        imageAssetsBidings.put(s, Integer.valueOf(i));
    }

    public void bindTextAsset(String s, int i)
    {
        textAssetsBidings.put(s, Integer.valueOf(i));
    }

    public int getAdLayoutId()
    {
        return adLayoutId;
    }

    public int getIdForImageAsset(String s)
    {
        Integer integer = (Integer)imageAssetsBidings.get(s);
        if (integer != null)
        {
            return integer.intValue();
        } else
        {
            return 0;
        }
    }

    public int getIdForTextAsset(String s)
    {
        Integer integer = (Integer)textAssetsBidings.get(s);
        if (integer != null)
        {
            return integer.intValue();
        } else
        {
            return 0;
        }
    }

    public Set getImageAssetsBindingsKeySet()
    {
        return imageAssetsBidings.keySet();
    }

    public Set getTextAssetsBindingsKeySet()
    {
        return textAssetsBidings.keySet();
    }
}
