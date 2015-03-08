// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.customevents;


// Referenced classes of package com.adsdk.sdk.customevents:
//            CustomEventFullscreen

public interface 
{

    public abstract void onFullscreenClosed();

    public abstract void onFullscreenFailed();

    public abstract void onFullscreenLeftApplication();

    public abstract void onFullscreenLoaded(CustomEventFullscreen customeventfullscreen);

    public abstract void onFullscreenOpened();
}
