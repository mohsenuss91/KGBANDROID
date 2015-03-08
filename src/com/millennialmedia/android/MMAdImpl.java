// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            MMAd, AdProperties, BannerWebViewClient, MMSDK, 
//            MMRequest, HandShake, MMAdImplController, MMWebView, 
//            MMWebViewClient, RequestListener

abstract class MMAdImpl
    implements MMAd
{

    private static long nextAdViewId = 1L;
    AdProperties adProperties;
    String adType;
    String apid;
    WeakReference contextRef;
    MMAdImplController controller;
    boolean ignoreDensityScaling;
    long internalId;
    boolean isFinishing;
    long lastAdRequest;
    long linkForExpansionId;
    protected MMRequest mmRequest;
    MMWebViewClient mmWebViewClient;
    MMWebViewClient.MMWebViewClientListener mmWebViewClientListener;
    JSONObject obj;
    RequestListener requestListener;
    String userData;
    boolean xmlLayout;

    public MMAdImpl(Context context)
    {
        ignoreDensityScaling = false;
        apid = "28911";
        xmlLayout = false;
        contextRef = new WeakReference(context);
        mmWebViewClientListener = new BasicMMWebViewClientListener();
        com/millennialmedia/android/MMAdImpl;
        JVM INSTR monitorenter ;
        internalId = nextAdViewId;
        nextAdViewId = 1L + nextAdViewId;
        Object aobj[] = new Object[1];
        aobj[0] = Long.valueOf(internalId);
        MMSDK.Log.v("Assigning MMAdImpl internal id: %d", aobj);
        com/millennialmedia/android/MMAdImpl;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        com/millennialmedia/android/MMAdImpl;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static String[] getAdTypes()
    {
        return (new String[] {
            "b", "i"
        });
    }

    void addView(MMWebView mmwebview, android.widget.RelativeLayout.LayoutParams layoutparams)
    {
    }

    void animateTransition()
    {
    }

    JSONObject getAdProperties()
    {
        if (adProperties != null)
        {
            return adProperties.getAdProperties();
        } else
        {
            return null;
        }
    }

    public String getApid()
    {
        return apid;
    }

    String getCachedName()
    {
        if (adType != null && apid != null)
        {
            return (new StringBuilder()).append(adType).append("_").append(apid).toString();
        } else
        {
            return null;
        }
    }

    abstract MMAd getCallingAd();

    Context getContext()
    {
        if (contextRef != null)
        {
            return (Context)contextRef.get();
        } else
        {
            return null;
        }
    }

    int getId()
    {
        return -1;
    }

    public boolean getIgnoresDensityScaling()
    {
        return ignoreDensityScaling;
    }

    public RequestListener getListener()
    {
        return requestListener;
    }

    public MMRequest getMMRequest()
    {
        return mmRequest;
    }

    MMWebViewClient getMMWebViewClient()
    {
        MMSDK.Log.d((new StringBuilder("Returning a client for user: DefaultWebViewClient, adimpl=")).append(this).toString());
        return new BannerWebViewClient(mmWebViewClientListener, new MMAdImplRedirectionListenerImpl());
    }

    String getReqType()
    {
        return "fetch";
    }

    String getRequestCompletedAction()
    {
        return "millennialmedia.action.ACTION_FETCH_SUCCEEDED";
    }

    String getRequestFailedAction()
    {
        return "millennialmedia.action.ACTION_FETCH_FAILED";
    }

    public boolean hasCachedVideoSupport()
    {
        return true;
    }

    void insertUrlAdMetaValues(Map map)
    {
        Context context = getContext();
        map.put("ar", "manual");
        map.put("sdkapid", apid);
        map.put("do", MMSDK.getOrientation(context));
        map.put("olock", MMSDK.getOrientationLocked(context));
        if (!hasCachedVideoSupport())
        {
            map.put("cachedvideo", "false");
        }
        map.put("reqtype", getReqType());
        if (mmRequest != null)
        {
            mmRequest.getUrlParams(map);
        }
        if (HandShake.sharedHandShake(context).canRequestVideo(context, adType))
        {
            map.put("video", "true");
        } else
        {
            map.put("video", "false");
        }
        if (adType != null)
        {
            if (adType.equals("b") || adType.equals("i"))
            {
                map.put("at", adType);
                return;
            } else
            {
                MMSDK.Log.e((new StringBuilder("******* ERROR: INCORRECT AD TYPE IN MMADVIEW OBJECT PARAMETERS (")).append(adType).append(") **********").toString());
                return;
            }
        } else
        {
            MMSDK.Log.e("******* SDK DEFAULTED TO MMBannerAdBottom. THIS MAY AFFECT THE ADS YOU RECIEVE!!! **********");
            map.put("at", "b");
            return;
        }
    }

    public boolean isBanner()
    {
        return false;
    }

    boolean isLifecycleObservable()
    {
        return false;
    }

    boolean isRefreshable()
    {
        if (MMSDK.disableAdMinRefresh)
        {
            MMSDK.Log.d("Requesting of ads disabled by server");
            return false;
        }
        long l = System.currentTimeMillis();
        int i = (int)((l - lastAdRequest) / 1000L);
        if ((long)i >= HandShake.sharedHandShake(getContext()).adRefreshSecs)
        {
            lastAdRequest = l;
            return true;
        } else
        {
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(i);
            aobj[1] = Integer.valueOf(15 - i);
            MMSDK.Log.d("Cannot request ad. Last ad request was %d seconds ago. Next ad can be requested in %d seconds.", aobj);
            return false;
        }
    }

    boolean isTransitionAnimated()
    {
        return false;
    }

    boolean isUpdatingMraid()
    {
        return controller != null && controller.webView != null && !controller.webView.isExpanding;
    }

    void prepareTransition(Bitmap bitmap)
    {
    }

    void removeView(MMWebView mmwebview)
    {
    }

    void requestAd()
    {
        MMAdImplController.assignAdViewController(this);
        if (controller != null)
        {
            controller.requestAd();
        }
    }

    public void setApid(String s)
    {
        if (HandShake.apid == null || HandShake.apid.equals("28911"))
        {
            HandShake.apid = apid;
        }
        apid = s;
    }

    void setBackgroundColor(int i)
    {
    }

    void setClickable(boolean flag)
    {
    }

    public void setIgnoresDensityScaling(boolean flag)
    {
        ignoreDensityScaling = flag;
    }

    public void setListener(RequestListener requestlistener)
    {
        requestListener = requestlistener;
    }

    public void setMMRequest(MMRequest mmrequest)
    {
        mmRequest = mmrequest;
    }

    public String toString()
    {
        return (new StringBuilder("AdType[(")).append(adType).append(") InternalId(").append(internalId).append(") LinkedId(").append(linkForExpansionId).append(") isFinishing(").append(isFinishing).append(")]").toString();
    }

    void unresizeToDefault()
    {
        if (controller != null)
        {
            controller.unresizeToDefault();
        }
    }


    private class BasicMMWebViewClientListener extends MMWebViewClient.MMWebViewClientListener
    {

        final MMAdImpl this$0;

        public void onPageFinished(String s)
        {
            setClickable(true);
            if (controller == null || controller.webView == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            MMWebView mmwebview = controller.webView;
            mmwebview;
            JVM INSTR monitorenter ;
            if (!controller.webView.hasWindowFocus())
            {
                break MISSING_BLOCK_LABEL_76;
            }
            controller.webView.setMraidViewableVisible();
_L2:
            return;
            controller.webView.setMraidViewableHidden();
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        void onPageStarted(String s)
        {
            setClickable(false);
        }

        BasicMMWebViewClientListener()
        {
            this$0 = MMAdImpl.this;
            super();
        }
    }


    private class MMAdImplRedirectionListenerImpl extends HttpRedirection.RedirectionListenerImpl
    {

        final MMAdImpl this$0;

        public JSONObject getAdProperties()
        {
            return MMAdImpl.this.getAdProperties();
        }

        public boolean isActivityStartable(Uri uri)
        {
            Context context = getContext();
            return context == null || !(context instanceof Activity) || !((Activity)context).isFinishing();
        }

        public void startingActivity(Uri uri)
        {
            super.startingActivity(uri);
            if (uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https"))
            {
                MMSDK.Event.overlayOpened(MMAdImpl.this);
            }
        }

        public void updateLastVideoViewedTime()
        {
            if (adType != null)
            {
                HandShake.sharedHandShake(getContext()).updateLastVideoViewedTime(getContext(), adType);
            }
        }

        public MMAdImplRedirectionListenerImpl()
        {
            this$0 = MMAdImpl.this;
            super();
            creatorAdImplInternalId = internalId;
        }
    }

}
