// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

// Referenced classes of package com.adsdk.sdk.mraid:
//            Drawables

public class MraidBrowser extends Activity
{

    public static final int INNER_LAYOUT_ID = 1;
    public static final String URL_EXTRA = "extra_url";
    private ImageButton mBackButton;
    private ImageButton mCloseButton;
    private ImageButton mForwardButton;
    private ImageButton mRefreshButton;
    private WebView mWebView;

    public MraidBrowser()
    {
    }

    private void enableCookies()
    {
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    private ImageButton getButton(Drawable drawable)
    {
        ImageButton imagebutton = new ImageButton(this);
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2, 1.0F);
        layoutparams.gravity = 16;
        imagebutton.setLayoutParams(layoutparams);
        imagebutton.setImageDrawable(drawable);
        return imagebutton;
    }

    private View getMraidBrowserView()
    {
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        linearlayout.setOrientation(1);
        RelativeLayout relativelayout = new RelativeLayout(this);
        relativelayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        linearlayout.addView(relativelayout);
        LinearLayout linearlayout1 = new LinearLayout(this);
        linearlayout1.setId(1);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutparams.addRule(12);
        linearlayout1.setLayoutParams(layoutparams);
        linearlayout1.setBackgroundDrawable(Drawables.BACKGROUND.decodeImage(this));
        relativelayout.addView(linearlayout1);
        mBackButton = getButton(Drawables.LEFT_ARROW.decodeImage(this));
        mForwardButton = getButton(Drawables.RIGHT_ARROW.decodeImage(this));
        mRefreshButton = getButton(Drawables.REFRESH.decodeImage(this));
        mCloseButton = getButton(Drawables.CLOSE.decodeImage(this));
        linearlayout1.addView(mBackButton);
        linearlayout1.addView(mForwardButton);
        linearlayout1.addView(mRefreshButton);
        linearlayout1.addView(mCloseButton);
        mWebView = new WebView(this);
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams1.addRule(2, 1);
        mWebView.setLayoutParams(layoutparams1);
        relativelayout.addView(mWebView);
        return linearlayout;
    }

    private void initializeButtons()
    {
        mBackButton.setBackgroundColor(0);
        mBackButton.setOnClickListener(new _cls3());
        mForwardButton.setBackgroundColor(0);
        mForwardButton.setOnClickListener(new _cls4());
        mRefreshButton.setBackgroundColor(0);
        mRefreshButton.setOnClickListener(new _cls5());
        mCloseButton.setBackgroundColor(0);
        mCloseButton.setOnClickListener(new _cls6());
    }

    private void initializeWebView(Intent intent)
    {
        WebSettings websettings = mWebView.getSettings();
        websettings.setJavaScriptEnabled(true);
        websettings.setSupportZoom(true);
        websettings.setBuiltInZoomControls(true);
        websettings.setUseWideViewPort(true);
        mWebView.loadUrl(intent.getStringExtra("extra_url"));
        mWebView.setWebViewClient(new _cls1());
        mWebView.setWebChromeClient(new _cls2());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        setContentView(getMraidBrowserView());
        initializeWebView(getIntent());
        initializeButtons();
        enableCookies();
    }

    protected void onPause()
    {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }

    protected void onResume()
    {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }




    private class _cls3
        implements android.view.View.OnClickListener
    {

        final MraidBrowser this$0;

        public void onClick(View view)
        {
            if (mWebView.canGoBack())
            {
                mWebView.goBack();
            }
        }

        _cls3()
        {
            this$0 = MraidBrowser.this;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final MraidBrowser this$0;

        public void onClick(View view)
        {
            if (mWebView.canGoForward())
            {
                mWebView.goForward();
            }
        }

        _cls4()
        {
            this$0 = MraidBrowser.this;
            super();
        }
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final MraidBrowser this$0;

        public void onClick(View view)
        {
            mWebView.reload();
        }

        _cls5()
        {
            this$0 = MraidBrowser.this;
            super();
        }
    }


    private class _cls6
        implements android.view.View.OnClickListener
    {

        final MraidBrowser this$0;

        public void onClick(View view)
        {
            finish();
        }

        _cls6()
        {
            this$0 = MraidBrowser.this;
            super();
        }
    }


    private class _cls1 extends WebViewClient
    {

        final MraidBrowser this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            android.graphics.drawable.BitmapDrawable bitmapdrawable;
            android.graphics.drawable.BitmapDrawable bitmapdrawable1;
            if (webview.canGoBack())
            {
                bitmapdrawable = Drawables.LEFT_ARROW.decodeImage(MraidBrowser.this);
            } else
            {
                bitmapdrawable = Drawables.UNLEFT_ARROW.decodeImage(MraidBrowser.this);
            }
            mBackButton.setImageDrawable(bitmapdrawable);
            if (webview.canGoForward())
            {
                bitmapdrawable1 = Drawables.RIGHT_ARROW.decodeImage(MraidBrowser.this);
            } else
            {
                bitmapdrawable1 = Drawables.UNRIGHT_ARROW.decodeImage(MraidBrowser.this);
            }
            mForwardButton.setImageDrawable(bitmapdrawable1);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            super.onPageStarted(webview, s, bitmap);
            mForwardButton.setImageDrawable(Drawables.UNRIGHT_ARROW.decodeImage(MraidBrowser.this));
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            Toast.makeText((Activity)webview.getContext(), (new StringBuilder("MRAID error: ")).append(s).toString(), 0).show();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (s != null)
            {
                String s1 = Uri.parse(s).getHost();
                if (!s.startsWith("http:") && !s.startsWith("https:") || "play.google.com".equals(s1) || "market.android.com".equals(s1))
                {
                    try
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                    }
                    catch (ActivityNotFoundException activitynotfoundexception)
                    {
                        Log.w("MoPub", (new StringBuilder("Unable to start activity for ")).append(s).append(". Ensure that your phone can handle this intent.").toString());
                    }
                    finish();
                    return true;
                }
            }
            return false;
        }

        _cls1()
        {
            this$0 = MraidBrowser.this;
            super();
        }
    }


    private class _cls2 extends WebChromeClient
    {

        final MraidBrowser this$0;

        public void onProgressChanged(WebView webview, int i)
        {
            Activity activity = (Activity)webview.getContext();
            activity.setTitle("Loading...");
            activity.setProgress(i * 100);
            if (i == 100)
            {
                activity.setTitle(webview.getUrl());
            }
        }

        _cls2()
        {
            this$0 = MraidBrowser.this;
            super();
        }
    }

}
