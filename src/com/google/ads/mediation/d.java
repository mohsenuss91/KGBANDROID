// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import com.google.ads.b;

// Referenced classes of package com.google.ads.mediation:
//            c

public interface d
{

    public abstract void onClick(c c);

    public abstract void onDismissScreen(c c);

    public abstract void onFailedToReceiveAd(c c, b b);

    public abstract void onLeaveApplication(c c);

    public abstract void onPresentScreen(c c);

    public abstract void onReceivedAd(c c);
}
