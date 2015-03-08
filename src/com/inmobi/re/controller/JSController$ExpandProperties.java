// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.os.Parcel;

// Referenced classes of package com.inmobi.re.controller:
//            f

public class le extends le
{

    public static final android.os.andProperties.currentY CREATOR = new f();
    public int actualHeightRequested;
    public int actualWidthRequested;
    public int bottomStuff;
    public int currentX;
    public int currentY;
    public int height;
    public boolean isModal;
    public boolean lockOrientation;
    public String orientation;
    public int portraitHeightRequested;
    public int portraitWidthRequested;
    public String rotationAtExpand;
    public int topStuff;
    public boolean useCustomClose;
    public int width;
    public int x;
    public int y;
    public boolean zeroWidthHeight;

    public void reinitializeExpandProperties()
    {
        width = 0;
        height = 0;
        x = -1;
        y = -1;
        useCustomClose = false;
        isModal = true;
        lockOrientation = false;
        orientation = "";
        actualWidthRequested = 0;
        actualHeightRequested = 0;
        topStuff = 0;
        bottomStuff = 0;
        portraitWidthRequested = 0;
        portraitHeightRequested = 0;
        zeroWidthHeight = false;
        rotationAtExpand = "";
        currentX = 0;
        currentY = 0;
    }


    public le()
    {
        reinitializeExpandProperties();
    }

    protected reinitializeExpandProperties(Parcel parcel)
    {
        super(parcel);
    }
}
