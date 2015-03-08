// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;


// Referenced classes of package com.inmobi.monetization:
//            IMErrorCode, IMNative

public interface IMNativeListener
{

    public abstract void onNativeRequestFailed(IMErrorCode imerrorcode);

    public abstract void onNativeRequestSucceeded(IMNative imnative);
}
