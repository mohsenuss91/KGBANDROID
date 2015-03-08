// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.abstraction;

import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;

public interface INativeAdListener
{

    public abstract void onNativeRequestFailed(IMErrorCode imerrorcode);

    public abstract void onNativeRequestSucceeded(IMNative imnative);
}
