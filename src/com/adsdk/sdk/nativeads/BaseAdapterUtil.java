// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;


public class BaseAdapterUtil
{

    private int adPositionInterval;
    private int firstAdPosition;

    public BaseAdapterUtil(int i, int j)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("First ad position cannot be negative!");
        }
        if (j <= 0)
        {
            throw new IllegalArgumentException("Number of rows of original content between ads cannot be lower than 1.");
        } else
        {
            firstAdPosition = i;
            adPositionInterval = j + 1;
            return;
        }
    }

    private int adsAlreadyShown(int i)
    {
        if (i <= firstAdPosition)
        {
            return 0;
        } else
        {
            return 1 + (int)Math.floor((double)(i - firstAdPosition) / (double)adPositionInterval);
        }
    }

    private int countAdsWithinContent(int i)
    {
        if (i <= firstAdPosition)
        {
            return 0;
        }
        int j = -1 + adPositionInterval;
        if ((i - firstAdPosition) % j == 0)
        {
            return (i - firstAdPosition) / j;
        } else
        {
            return 1 + (int)Math.floor((double)(i - firstAdPosition) / (double)j);
        }
    }

    public int calculateShiftedCount(int i)
    {
        return i + countAdsWithinContent(i);
    }

    public int calculateShiftedPosition(int i)
    {
        return i - adsAlreadyShown(i);
    }

    public boolean isAdPosition(int i)
    {
        while (i < firstAdPosition || (i - firstAdPosition) % adPositionInterval != 0) 
        {
            return false;
        }
        return true;
    }
}
