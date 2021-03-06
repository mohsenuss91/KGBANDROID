// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.av;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest, AdSize, AdListener

public final class AdView extends ViewGroup
{

    private final av kv;

    public AdView(Context context)
    {
        super(context);
        kv = new av(this);
    }

    public AdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        kv = new av(this, attributeset, false);
    }

    public AdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        kv = new av(this, attributeset, false);
    }

    public final void destroy()
    {
        kv.destroy();
    }

    public final AdListener getAdListener()
    {
        return kv.getAdListener();
    }

    public final AdSize getAdSize()
    {
        return kv.getAdSize();
    }

    public final String getAdUnitId()
    {
        return kv.getAdUnitId();
    }

    public final InAppPurchaseListener getInAppPurchaseListener()
    {
        return kv.getInAppPurchaseListener();
    }

    public final void loadAd(AdRequest adrequest)
    {
        kv.a(adrequest.O());
    }

    protected final void onLayout(boolean flag, int i, int j, int k, int l)
    {
        View view = getChildAt(0);
        if (view != null && view.getVisibility() != 8)
        {
            int i1 = view.getMeasuredWidth();
            int j1 = view.getMeasuredHeight();
            int k1 = (k - i - i1) / 2;
            int l1 = (l - j - j1) / 2;
            view.layout(k1, l1, i1 + k1, j1 + l1);
        }
    }

    protected final void onMeasure(int i, int j)
    {
        View view = getChildAt(0);
        AdSize adsize = getAdSize();
        int k;
        int l;
        int i1;
        int j1;
        if (view != null && view.getVisibility() != 8)
        {
            measureChild(view, i, j);
            l = view.getMeasuredWidth();
            k = view.getMeasuredHeight();
        } else
        if (adsize != null)
        {
            Context context = getContext();
            l = adsize.getWidthInPixels(context);
            k = adsize.getHeightInPixels(context);
        } else
        {
            k = 0;
            l = 0;
        }
        i1 = Math.max(l, getSuggestedMinimumWidth());
        j1 = Math.max(k, getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSize(i1, i), View.resolveSize(j1, j));
    }

    public final void pause()
    {
        kv.pause();
    }

    public final void resume()
    {
        kv.resume();
    }

    public final void setAdListener(AdListener adlistener)
    {
        kv.setAdListener(adlistener);
    }

    public final void setAdSize(AdSize adsize)
    {
        kv.setAdSizes(new AdSize[] {
            adsize
        });
    }

    public final void setAdUnitId(String s)
    {
        kv.setAdUnitId(s);
    }

    public final void setInAppPurchaseListener(InAppPurchaseListener inapppurchaselistener)
    {
        kv.setInAppPurchaseListener(inapppurchaselistener);
    }

    public final void setPlayStorePurchaseParams(PlayStorePurchaseListener playstorepurchaselistener, String s)
    {
        kv.setPlayStorePurchaseParams(playstorepurchaselistener, s);
    }
}
