// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            MMAd, MMAdImpl, MMException, MMSDK, 
//            MMAdImplController, MMRequest, RequestListener

public final class MMInterstitial
    implements MMAd
{

    MMAdImpl adImpl;
    int externalId;

    public MMInterstitial(Context context)
    {
        adImpl = new MMInterstitialAdImpl(context.getApplicationContext());
        adImpl.adType = "i";
    }

    private void fetchInternal()
    {
        if (isAdAvailable())
        {
            MMSDK.Log.d("Ad already fetched and ready for display...");
            MMSDK.Event.requestFailed(adImpl, new MMException(17));
            return;
        } else
        {
            MMSDK.Log.d("Fetching new ad...");
            adImpl.requestAd();
            return;
        }
    }

    public final boolean display()
    {
        return display(false);
    }

    public final boolean display(boolean flag)
    {
        if (MMSDK.isUiThread()) goto _L2; else goto _L1
_L1:
        MMSDK.Log.e(MMException.getErrorCodeMessage(3));
_L4:
        return false;
_L2:
        int i = displayInternal();
        if (i == 0 || !flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        throw new MMException(i);
        Exception exception;
        exception;
        if (!flag) goto _L4; else goto _L3
_L3:
        throw new MMException(exception);
        if (i != 0) goto _L4; else goto _L5
_L5:
        return true;
    }

    final int displayInternal()
    {
        int i;
        MMAdImplController.assignAdViewController(adImpl);
        if (adImpl.controller == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        i = adImpl.controller.display(adImpl);
        return i;
        Exception exception;
        exception;
        Object aobj[] = new Object[1];
        aobj[0] = exception.getMessage();
        MMSDK.Log.e("There was an exception displaying a cached ad. %s", aobj);
        exception.printStackTrace();
        return 100;
    }

    public final void fetch()
    {
        if (adImpl != null && adImpl.requestListener != null)
        {
            fetch(adImpl.mmRequest, adImpl.requestListener);
            return;
        } else
        {
            fetchInternal();
            return;
        }
    }

    public final void fetch(MMRequest mmrequest)
    {
        if (adImpl != null && adImpl.requestListener != null)
        {
            fetch(mmrequest, adImpl.requestListener);
            return;
        } else
        {
            fetchInternal();
            return;
        }
    }

    public final void fetch(MMRequest mmrequest, RequestListener requestlistener)
    {
        if (adImpl != null)
        {
            adImpl.mmRequest = mmrequest;
            adImpl.requestListener = requestlistener;
        }
        fetchInternal();
    }

    public final String getApid()
    {
        return adImpl.getApid();
    }

    public final boolean getIgnoresDensityScaling()
    {
        return adImpl.getIgnoresDensityScaling();
    }

    public final RequestListener getListener()
    {
        return adImpl.getListener();
    }

    public final MMRequest getMMRequest()
    {
        return adImpl.getMMRequest();
    }

    public final boolean isAdAvailable()
    {
        if (MMSDK.isUiThread()) goto _L2; else goto _L1
_L1:
        MMSDK.Log.e(MMException.getErrorCodeMessage(3));
_L4:
        return false;
_L2:
        MMAdImplController.assignAdViewController(adImpl);
        if (adImpl.controller == null) goto _L4; else goto _L3
_L3:
        int i = adImpl.controller.isAdAvailable(adImpl);
        if (i == 0)
        {
            return true;
        }
          goto _L4
        Exception exception;
        exception;
        Object aobj[] = new Object[1];
        aobj[0] = exception.getMessage();
        MMSDK.Log.e("There was an exception checking for a cached ad. %s", aobj);
        exception.printStackTrace();
        return false;
    }

    public final void setApid(String s)
    {
        adImpl.setApid(s);
    }

    public final void setIgnoresDensityScaling(boolean flag)
    {
        adImpl.setIgnoresDensityScaling(flag);
    }

    public final void setListener(RequestListener requestlistener)
    {
        adImpl.setListener(requestlistener);
    }

    public final void setMMRequest(MMRequest mmrequest)
    {
        adImpl.setMMRequest(mmrequest);
    }

    private class MMInterstitialAdImpl extends MMAdImpl
    {

        final MMInterstitial this$0;

        volatile MMAd getCallingAd()
        {
            return getCallingAd();
        }

        MMInterstitial getCallingAd()
        {
            return MMInterstitial.this;
        }

        public MMInterstitialAdImpl(Context context)
        {
            this$0 = MMInterstitial.this;
            super(context);
            adProperties = new AdProperties(getContext());
        }
    }

}
