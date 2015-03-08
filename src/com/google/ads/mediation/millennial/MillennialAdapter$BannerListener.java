// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;

import com.google.ads.b;
import com.google.ads.mediation.d;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.RequestListener;

// Referenced classes of package com.google.ads.mediation.millennial:
//            MillennialAdapter

class <init>
    implements RequestListener
{

    final MillennialAdapter this$0;

    public void MMAdOverlayLaunched(MMAd mmad)
    {
        MillennialAdapter.access$2(MillennialAdapter.this).onPresentScreen(MillennialAdapter.this);
    }

    public void MMAdRequestIsCaching(MMAd mmad)
    {
    }

    public void requestCompleted(MMAd mmad)
    {
        MillennialAdapter.access$2(MillennialAdapter.this).onReceivedAd(MillennialAdapter.this);
    }

    public void requestFailed(MMAd mmad, MMException mmexception)
    {
        if (11 == mmexception.getCode())
        {
            MillennialAdapter.access$2(MillennialAdapter.this).onFailedToReceiveAd(MillennialAdapter.this, b.c);
            return;
        } else
        {
            MillennialAdapter.access$2(MillennialAdapter.this).onFailedToReceiveAd(MillennialAdapter.this, b.b);
            return;
        }
    }

    private ()
    {
        this$0 = MillennialAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
