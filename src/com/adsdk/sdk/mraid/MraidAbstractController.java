// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidView

class MraidAbstractController
{

    private final MraidView mMraidView;

    MraidAbstractController(MraidView mraidview)
    {
        mMraidView = mraidview;
    }

    public MraidView getMraidView()
    {
        return mMraidView;
    }
}
