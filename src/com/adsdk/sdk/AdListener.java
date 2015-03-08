// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;


// Referenced classes of package com.adsdk.sdk:
//            Ad

public interface AdListener
{

    public abstract void adClicked();

    public abstract void adClosed(Ad ad, boolean flag);

    public abstract void adLoadSucceeded(Ad ad);

    public abstract void adShown(Ad ad, boolean flag);

    public abstract void noAdFound();
}
