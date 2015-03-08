// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import com.google.ads.b;

// Referenced classes of package com.google.ads.mediation:
//            e

public interface f
{

    public abstract void onDismissScreen(e e);

    public abstract void onFailedToReceiveAd(e e, b b);

    public abstract void onLeaveApplication(e e);

    public abstract void onPresentScreen(e e);

    public abstract void onReceivedAd(e e);
}
