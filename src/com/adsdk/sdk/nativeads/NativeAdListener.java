// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;


// Referenced classes of package com.adsdk.sdk.nativeads:
//            NativeAd

public interface NativeAdListener
{

    public abstract void adClicked();

    public abstract void adFailedToLoad();

    public abstract void adLoaded(NativeAd nativead);

    public abstract void impression();
}
