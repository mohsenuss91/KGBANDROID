// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;

// Referenced classes of package com.appyet.manager:
//            b

final class c extends AdListener
{

    final ViewGroup a;
    final b b;

    c(b b1, ViewGroup viewgroup)
    {
        b = b1;
        a = viewgroup;
        super();
    }

    public final void onAdLoaded()
    {
        a.setVisibility(0);
        super.onAdLoaded();
    }
}
