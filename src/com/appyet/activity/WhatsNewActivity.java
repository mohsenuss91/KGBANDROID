// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataSetting;

// Referenced classes of package com.appyet.activity:
//            ap, ar, aq

public class WhatsNewActivity extends Activity
{

    private ApplicationContext a;
    private WebView b;

    public WhatsNewActivity()
    {
    }

    static ApplicationContext a(WhatsNewActivity whatsnewactivity)
    {
        return whatsnewactivity.a;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        ar.a(this);
    }

    protected void onCreate(Bundle bundle)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            getWindow().setFlags(0x1000000, 0x1000000);
        }
        a = (ApplicationContext)getApplicationContext();
        super.onCreate(bundle);
        setContentView(0x7f030068);
        try
        {
            ((TextView)findViewById(0x7f0a0074)).setText(getString(0x7f0800e3));
            ((Button)findViewById(0x7f0a00f0)).setOnClickListener(new com.appyet.activity.ap(this));
            b = (WebView)findViewById(0x7f0a00eb);
            if (android.os.Build.VERSION.SDK_INT >= 7)
            {
                b.getSettings().setDomStorageEnabled(true);
            }
            b.getSettings().setJavaScriptEnabled(true);
            b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            b.getSettings().setSupportMultipleWindows(false);
            b.getSettings().setSupportZoom(true);
            b.getSettings().setBuiltInZoomControls(true);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                b.getSettings().setDisplayZoomControls(false);
            }
            b.getSettings().setUseWideViewPort(true);
            b.getSettings().setUserAgentString(a.v);
            b.setScrollBarStyle(0);
            b.setWebViewClient(new com.appyet.activity.ar(this));
            b.requestFocus(130);
            b.setOnTouchListener(new aq(this));
            b.loadDataWithBaseURL(null, a.q.MetadataSetting.WhatsNew, "text/html", "UTF-8", null);
            a.e.a("WhatsNew");
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && b.canGoBack())
        {
            b.goBack();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        ar.a(this);
        super.onResume();
    }
}
