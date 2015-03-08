// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.adsdk.sdk.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.adsdk.sdk.video:
//            WebViewClient, ResourceManager

public class WebFrame extends FrameLayout
{

    private static Field mWebView_LAYER_TYPE_SOFTWARE;
    private static Method mWebView_SetLayerType;
    private boolean enableZoom;
    private Activity mActivity;
    private ImageView mExitButton;
    private WebView mWebView;
    private WebViewClient mWebViewClient;

    public WebFrame(final Activity localContext, boolean flag, boolean flag1, boolean flag2)
    {
        super(localContext);
        enableZoom = true;
        initCompatibility();
        mActivity = localContext;
        mWebView = new WebView(localContext);
        mWebView.setVerticalScrollBarEnabled(flag1);
        mWebView.setHorizontalScrollBarEnabled(flag1);
        mWebView.setBackgroundColor(0);
        setLayer(mWebView);
        WebSettings websettings = mWebView.getSettings();
        websettings.setSavePassword(false);
        websettings.setSaveFormData(false);
        websettings.setJavaScriptEnabled(true);
        websettings.setPluginState(android.webkit.WebSettings.PluginState.ON);
        websettings.setSupportZoom(enableZoom);
        websettings.setBuiltInZoomControls(enableZoom);
        mWebViewClient = new WebViewClient(mActivity, flag);
        mWebView.setWebViewClient(mWebViewClient);
        if (flag2)
        {
            ImageView imageview = new ImageView(localContext);
            imageview.setBackgroundColor(0);
            addView(imageview, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
            addView(mWebView, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
            mExitButton = new ImageView(localContext);
            mExitButton.setAdjustViewBounds(false);
            mExitButton.setOnClickListener(new _cls1());
            int i = (int)TypedValue.applyDimension(1, 35F, getResources().getDisplayMetrics());
            mExitButton.setImageDrawable(ResourceManager.getStaticResource(localContext, -18));
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(i, i, 53);
            int j = (int)TypedValue.applyDimension(1, 6F, getResources().getDisplayMetrics());
            layoutparams.topMargin = j;
            layoutparams.rightMargin = j;
            addView(mExitButton, layoutparams);
            return;
        } else
        {
            addView(mWebView, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
            return;
        }
    }

    private String getUserAgentString()
    {
        return mWebView.getSettings().getUserAgentString();
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

    public WebView getWebView()
    {
        return mWebView;
    }

    public boolean isEnableZoom()
    {
        return enableZoom;
    }

    public void loadUrl(String s)
    {
        (new LoadUrlTask()).execute(new String[] {
            s
        });
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        onTouchEvent(motionevent);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        super.onTouchEvent(motionevent);
        return true;
    }

    public void setBackgroundColor(int i)
    {
        super.setBackgroundColor(i);
        mWebView.setBackgroundColor(i);
    }

    public void setEnableZoom(boolean flag)
    {
        enableZoom = flag;
        WebSettings websettings = mWebView.getSettings();
        websettings.setSupportZoom(flag);
        websettings.setBuiltInZoomControls(flag);
    }

    public void setMarkup(String s)
    {
        String s1 = Uri.encode(s);
        mWebViewClient.setAllowedUrl(null);
        mWebView.loadData(s1, "text/html", "UTF-8");
    }

    public void setOnPageLoadedListener(WebViewClient.OnPageLoadedListener onpageloadedlistener)
    {
        mWebViewClient.setOnPageLoadedListener(onpageloadedlistener);
    }

    static 
    {
        initCompatibility();
    }




    private class _cls1
        implements android.view.View.OnClickListener
    {

        final WebFrame this$0;
        private final Activity val$localContext;

        public void onClick(View view)
        {
            localContext.finish();
        }

        _cls1()
        {
            this$0 = WebFrame.this;
            localContext = activity;
            super();
        }
    }


    private class LoadUrlTask extends AsyncTask
    {

        final WebFrame this$0;
        String userAgent;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            String s = as[0];
            URL url = new URL(s);
            String s1;
            HashSet hashset;
            HttpURLConnection httpurlconnection;
            URL url1;
            Log.d((new StringBuilder("Checking URL redirect:")).append(s).toString());
            s1 = url.toString();
            hashset = new HashSet();
            hashset.add(s1);
            httpurlconnection = null;
            url1 = url;
_L7:
            HttpURLConnection httpurlconnection2 = (HttpURLConnection)url1.openConnection();
            int i;
            httpurlconnection2.setRequestProperty("User-Agent", userAgent);
            httpurlconnection2.setInstanceFollowRedirects(false);
            i = httpurlconnection2.getResponseCode();
            if (i != 200) goto _L2; else goto _L1
_L1:
            httpurlconnection2.disconnect();
_L6:
            if (httpurlconnection2 != null)
            {
                httpurlconnection2.disconnect();
            }
            s = s1;
_L4:
            return s;
            MalformedURLException malformedurlexception;
            malformedurlexception;
            if (s != null) goto _L4; else goto _L3
_L3:
            return "";
_L2:
            s1 = httpurlconnection2.getHeaderField("location");
            httpurlconnection2.disconnect();
            if (hashset.add(s1))
            {
                break MISSING_BLOCK_LABEL_178;
            }
            Log.d("URL redirect cycle detected");
            if (httpurlconnection2 != null)
            {
                httpurlconnection2.disconnect();
            }
            return "";
            URL url2 = new URL(s1);
            if (i != 302 && i != 301 && i != 307 && i != 303) goto _L6; else goto _L5
_L5:
            httpurlconnection = httpurlconnection2;
            url1 = url2;
              goto _L7
            IOException ioexception1;
            ioexception1;
            HttpURLConnection httpurlconnection1;
            String s2 = s1;
            httpurlconnection1 = httpurlconnection2;
            s = s2;
_L11:
            if (s == null)
            {
                s = "";
            }
            if (httpurlconnection1 == null) goto _L4; else goto _L8
_L8:
            httpurlconnection1.disconnect();
            return s;
            Exception exception1;
            exception1;
            Exception exception;
            httpurlconnection = httpurlconnection2;
            exception = exception1;
_L10:
            if (httpurlconnection != null)
            {
                httpurlconnection.disconnect();
            }
            throw exception;
            exception;
            if (true) goto _L10; else goto _L9
_L9:
            IOException ioexception;
            ioexception;
            s = s1;
            httpurlconnection1 = httpurlconnection;
              goto _L11
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            if (s == null || s.equals(""))
            {
                s = "about:blank";
            }
            Log.d((new StringBuilder("Show URL: ")).append(s).toString());
            mWebViewClient.setAllowedUrl(s);
            mWebView.loadUrl(s);
            requestLayout();
        }

        public LoadUrlTask()
        {
            this$0 = WebFrame.this;
            super();
            userAgent = getUserAgentString();
        }
    }

}
