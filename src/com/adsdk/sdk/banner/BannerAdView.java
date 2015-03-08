// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.adsdk.sdk.AdListener;
import com.adsdk.sdk.AdResponse;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.data.ClickType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;

// Referenced classes of package com.adsdk.sdk.banner:
//            InAppWebView

public class BannerAdView extends RelativeLayout
{

    public static final int LIVE = 0;
    public static final int TEST = 1;
    private static Field mWebView_LAYER_TYPE_SOFTWARE;
    private static Method mWebView_SetLayerType;
    private AdListener adListener;
    private boolean animation;
    private Animation fadeInAnimation;
    private int height;
    private boolean isInternalBrowser;
    private Context mContext;
    protected boolean mIsInForeground;
    private AdResponse response;
    private final Handler updateHandler = new Handler();
    private boolean wasUserAction;
    private WebSettings webSettings;
    private WebView webView;
    private int width;

    public BannerAdView(Context context, AdResponse adresponse, int i, int j, boolean flag, AdListener adlistener)
    {
        super(context);
        isInternalBrowser = false;
        wasUserAction = false;
        fadeInAnimation = null;
        mContext = null;
        mContext = context;
        response = adresponse;
        width = i;
        height = j;
        animation = flag;
        adListener = adlistener;
        initialize(context);
    }

    private void buildBannerView()
    {
        webView = createWebView(mContext);
        Log.d("ADSDK", "Create view flipper");
        float f = mContext.getResources().getDisplayMetrics().density;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if (width != 0 && height != 0)
        {
            setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)(0.5F + f * (float)width), (int)(0.5F + f * (float)height)));
        } else
        {
            setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)(0.5F + 300F * f), (int)(0.5F + f * 50F)));
        }
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        addView(webView, layoutparams);
        Log.d("ADSDK", (new StringBuilder("animation: ")).append(animation).toString());
        if (animation)
        {
            fadeInAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
            fadeInAnimation.setDuration(1000L);
            webView.setAnimation(fadeInAnimation);
        }
    }

    private WebView createWebView(Context context)
    {
        _cls1 _lcls1 = new _cls1(getContext());
        webSettings = _lcls1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportMultipleWindows(true);
        _lcls1.setBackgroundColor(0);
        setLayer(_lcls1);
        _lcls1.setWebViewClient(new _cls2());
        _lcls1.setVerticalScrollBarEnabled(false);
        _lcls1.setHorizontalScrollBarEnabled(false);
        return _lcls1;
    }

    private void doOpenUrl(String s)
    {
        notifyAdClicked();
        if (response.getClickUrl() != null && response.getSkipOverlay() == 1)
        {
            makeTrackingRequest(response.getClickUrl());
        }
        if (response.getClickType() != null && response.getClickType().equals(ClickType.INAPP) && (s.startsWith("http://") || s.startsWith("https://")))
        {
            if (s.endsWith(".mp4"))
            {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(s), "video/mp4");
                startActivity(intent);
                return;
            } else
            {
                Intent intent1 = new Intent(getContext(), com/adsdk/sdk/banner/InAppWebView);
                intent1.putExtra("REDIRECT_URI", s);
                startActivity(intent1);
                return;
            }
        } else
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
            return;
        }
    }

    private static void initCompatibility()
    {
        Method amethod[];
        int i;
        amethod = android/webkit/WebView.getMethods();
        i = amethod.length;
        int j = 0;
          goto _L1
_L3:
        Method method = amethod[j];
        SecurityException securityexception;
        if (method.getName().equals("setLayerType"))
        {
            mWebView_SetLayerType = method;
            break; /* Loop/switch isn't completed */
        }
        j++;
        continue; /* Loop/switch isn't completed */
_L2:
        try
        {
            Log.v((new StringBuilder("set layer ")).append(mWebView_SetLayerType).toString());
            mWebView_LAYER_TYPE_SOFTWARE = android/webkit/WebView.getField("LAYER_TYPE_SOFTWARE");
            Log.v((new StringBuilder("set1 layer ")).append(mWebView_LAYER_TYPE_SOFTWARE).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SecurityException securityexception)
        {
            Log.v("SecurityException");
            return;
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Log.v("NoSuchFieldException");
        }
        return;
_L1:
        if (j < i) goto _L3; else goto _L2
    }

    private void initialize(Context context)
    {
        initCompatibility();
        buildBannerView();
        showContent();
    }

    private void makeTrackingRequest(final String clickUrl)
    {
        (new _cls3()).execute(new Void[0]);
    }

    private void notifyAdClicked()
    {
        updateHandler.post(new _cls4());
    }

    private void notifyLoadAdSucceeded()
    {
        updateHandler.post(new _cls5());
    }

    private void openLink()
    {
        if (response != null && response.getClickUrl() != null)
        {
            doOpenUrl(response.getClickUrl());
        }
    }

    private static void setLayer(WebView webview)
    {
        if (mWebView_SetLayerType != null && mWebView_LAYER_TYPE_SOFTWARE != null)
        {
            try
            {
                Log.v("Set Layer is supported");
                Method method = mWebView_SetLayerType;
                Object aobj[] = new Object[2];
                aobj[0] = Integer.valueOf(mWebView_LAYER_TYPE_SOFTWARE.getInt(android/webkit/WebView));
                aobj[1] = null;
                method.invoke(webview, aobj);
                return;
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                Log.v("Set InvocationTargetException");
                return;
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.v("Set IllegalArgumentException");
                return;
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                Log.v("Set IllegalAccessException");
            }
            return;
        } else
        {
            Log.v("Set Layer is not supported");
            return;
        }
    }

    private void showContent()
    {
        if (response.getType() != 0) goto _L2; else goto _L1
_L1:
        Object aobj[] = new Object[3];
        aobj[0] = response.getImageUrl();
        aobj[1] = Integer.valueOf(response.getBannerWidth());
        aobj[2] = Integer.valueOf(response.getBannerHeight());
        String s1 = MessageFormat.format("<body style='\"'margin: 0px; padding: 0px; text-align:center;'\"'><img src='\"'{0}'\"' width='\"'{1}'dp\"' height='\"'{2}'dp\"'/></body>", aobj);
        Log.d("ADSDK", (new StringBuilder("set image: ")).append(s1).toString());
        String s2 = Uri.encode((new StringBuilder("<style>* { -webkit-tap-highlight-color: rgba(0,0,0,0);} img {width:100%;height:100%}</style>")).append(s1).toString());
        webView.loadData(s2, "text/html", "UTF-8");
        notifyLoadAdSucceeded();
_L4:
        if (animation)
        {
            webView.startAnimation(fadeInAnimation);
            return;
        }
        break MISSING_BLOCK_LABEL_235;
_L2:
        if (response.getType() == 1)
        {
            String s = Uri.encode((new StringBuilder("<style>* { -webkit-tap-highlight-color: rgba(0,0,0,0);} img {width:100%;height:100%}</style>")).append(response.getText()).toString());
            Log.d("ADSDK", (new StringBuilder("set text: ")).append(s).toString());
            webView.loadData(s, "text/html", "UTF-8");
            notifyLoadAdSucceeded();
        }
        if (true) goto _L4; else goto _L3
_L3:
        Throwable throwable;
        throwable;
        Log.e("ADSDK", "Exception in show content", throwable);
    }

    private void startActivity(Intent intent)
    {
        if (!(getContext() instanceof Activity))
        {
            intent.addFlags(0x10000000);
        }
        getContext().startActivity(intent);
    }

    public boolean isInternalBrowser()
    {
        return isInternalBrowser;
    }

    public void setAdListener(AdListener adlistener)
    {
        adListener = adlistener;
    }

    public void setInternalBrowser(boolean flag)
    {
        isInternalBrowser = flag;
    }

    static 
    {
        initCompatibility();
    }







    private class _cls1 extends WebView
    {

        final BannerAdView this$0;

        public void draw(Canvas canvas)
        {
            if (getWidth() > 0 && getHeight() > 0)
            {
                super.draw(canvas);
            }
        }

        public boolean onTouchEvent(MotionEvent motionevent)
        {
            wasUserAction = true;
            return super.onTouchEvent(motionevent);
        }

        _cls1(Context context)
        {
            this$0 = BannerAdView.this;
            super(context);
        }
    }


    private class _cls2 extends WebViewClient
    {

        final BannerAdView this$0;

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (wasUserAction)
            {
                if (response.getSkipOverlay() == 1)
                {
                    doOpenUrl(s);
                    Log.i("TouchListener", "false");
                    return true;
                } else
                {
                    Log.i("TouchListener", "default");
                    openLink();
                    return true;
                }
            } else
            {
                return false;
            }
        }

        _cls2()
        {
            this$0 = BannerAdView.this;
            super();
        }
    }


    private class _cls3 extends AsyncTask
    {

        final BannerAdView this$0;
        private final String val$clickUrl;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (clickUrl.startsWith("market"))
            {
                return null;
            }
            try
            {
                DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
                HttpGet httpget = new HttpGet();
                httpget.setHeader("User-Agent", System.getProperty("http.agent"));
                httpget.setURI(new URI(clickUrl));
                defaulthttpclient.execute(httpget);
            }
            catch (URISyntaxException urisyntaxexception)
            {
                urisyntaxexception.printStackTrace();
                return null;
            }
            catch (ClientProtocolException clientprotocolexception)
            {
                clientprotocolexception.printStackTrace();
                return null;
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
                return null;
            }
            return null;
        }

        _cls3()
        {
            this$0 = BannerAdView.this;
            clickUrl = s;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final BannerAdView this$0;

        public void run()
        {
            if (adListener != null)
            {
                Log.d("ADSDK", (new StringBuilder("notify bannerListener of ad clicked: ")).append(adListener.getClass().getName()).toString());
                adListener.adClicked();
            }
        }

        _cls4()
        {
            this$0 = BannerAdView.this;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final BannerAdView this$0;

        public void run()
        {
            if (adListener != null)
            {
                Log.d("ADSDK", (new StringBuilder("notify bannerListener of load succeeded: ")).append(adListener.getClass().getName()).toString());
                adListener.adLoadSucceeded(null);
            }
        }

        _cls5()
        {
            this$0 = BannerAdView.this;
            super();
        }
    }

}
