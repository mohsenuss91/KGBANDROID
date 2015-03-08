// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidProperty

class MraidScreenSizeProperty extends MraidProperty
{

    private final int mScreenHeight;
    private final int mScreenWidth;

    MraidScreenSizeProperty(int i, int j)
    {
        mScreenWidth = i;
        mScreenHeight = j;
    }

    public static MraidScreenSizeProperty createWithSize(int i, int j)
    {
        return new MraidScreenSizeProperty(i, j);
    }

    public String toJsonPair()
    {
        return (new StringBuilder("screenSize: { width: ")).append(mScreenWidth).append(", height: ").append(mScreenHeight).append(" }").toString();
    }
}
