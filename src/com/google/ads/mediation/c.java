// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import android.app.Activity;
import android.view.View;
import com.google.ads.d;

// Referenced classes of package com.google.ads.mediation:
//            b, d, g, a, 
//            j

public interface c
    extends b
{

    public abstract View getBannerView();

    public abstract void requestBannerAd(com.google.ads.mediation.d d, Activity activity, g g, d d1, a a, j j);
}
