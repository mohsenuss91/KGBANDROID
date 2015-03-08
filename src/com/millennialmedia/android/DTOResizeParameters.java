// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


class DTOResizeParameters
{

    boolean allowOffScreen;
    String customClosePosition;
    int height;
    int offsetX;
    int offsetY;
    int width;
    int xMax;
    int yMax;

    DTOResizeParameters(float f, int i, int j, String s, int k, int l, boolean flag, 
            int i1, int j1)
    {
        width = (int)(f * (float)i);
        height = (int)(f * (float)j);
        customClosePosition = s;
        offsetX = (int)(f * (float)k);
        offsetY = (int)(f * (float)l);
        allowOffScreen = flag;
        xMax = i1;
        yMax = j1;
    }

    public String toString()
    {
        Object aobj[] = new Object[8];
        aobj[0] = Integer.valueOf(width);
        aobj[1] = Integer.valueOf(height);
        aobj[2] = Integer.valueOf(offsetX);
        aobj[3] = Integer.valueOf(offsetY);
        aobj[4] = Boolean.valueOf(allowOffScreen);
        aobj[5] = customClosePosition;
        aobj[6] = Integer.valueOf(xMax);
        aobj[7] = Integer.valueOf(yMax);
        return String.format("width[%d] height[%d] offsetX[%d] offsetY[%d] allowOffScreen[%b] customClosePosition[%s] maxX[%d] maxY[%d]", aobj);
    }
}
