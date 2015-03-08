// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidProperty

class MraidStateProperty extends MraidProperty
{

    private final MraidView.ViewState mViewState;

    MraidStateProperty(MraidView.ViewState viewstate)
    {
        mViewState = viewstate;
    }

    public static MraidStateProperty createWithViewState(MraidView.ViewState viewstate)
    {
        return new MraidStateProperty(viewstate);
    }

    public String toJsonPair()
    {
        return (new StringBuilder("state: '")).append(mViewState.toString().toLowerCase()).append("'").toString();
    }
}
