// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c.a;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.f.h;
import com.appyet.manager.ar;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataTheme;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

// Referenced classes of package com.appyet.c.a:
//            n, m, p, q, 
//            o

public final class l extends SherlockFragment
{

    private int a;
    private ApplicationContext b;
    private WebView c;
    private TextView d;
    private FrameLayout e;
    private ProgressBar f;
    private String g;
    private String h;
    private String i;
    private String j;
    private Long k;
    private n l;

    public l()
    {
        g = "http://APPYET_BASE";
        h = "IMG_APPYET";
        i = "COMMENT_APPYET";
        j = null;
    }

    static WebView a(l l1)
    {
        return l1.c;
    }

    private void a()
    {
label0:
        {
            if (c != null)
            {
                if (android.os.Build.VERSION.SDK_INT < 11)
                {
                    break label0;
                }
                c.onPause();
            }
            return;
        }
        try
        {
            Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(c, null);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    static Long b(l l1)
    {
        return l1.k;
    }

    private String b()
    {
        InputStream inputstream;
        ByteArrayOutputStream bytearrayoutputstream;
        int i1;
        int j1;
        try
        {
            inputstream = getResources().getAssets().open("html/forum/forum_template.html");
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return null;
        }
        bytearrayoutputstream = new ByteArrayOutputStream();
        i1 = inputstream.read();
_L2:
        if (i1 == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        bytearrayoutputstream.write(i1);
        j1 = inputstream.read();
        i1 = j1;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            inputstream.close();
        }
        catch (IOException ioexception1)
        {
            ioexception1.printStackTrace();
        }
        return bytearrayoutputstream.toString();
    }

    static ApplicationContext c(l l1)
    {
        return l1.b;
    }

    static int d(l l1)
    {
        return l1.a;
    }

    static TextView e(l l1)
    {
        return l1.d;
    }

    static ProgressBar f(l l1)
    {
        return l1.f;
    }

    static String g(l l1)
    {
        return l1.g;
    }

    public final void a(int i1)
    {
        a = i1;
    }

    public final void a(Long long1)
    {
        k = long1;
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        if (c != null)
        {
            c.restoreState(bundle);
        }
        return;
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        return;
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public final void onCreate(Bundle bundle)
    {
        if (bundle != null && bundle.containsKey("position"))
        {
            a = bundle.getInt("position", 0);
        }
        b = (ApplicationContext)getActivity().getApplicationContext();
        j = b();
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03004a, null);
    }

    public final void onDestroy()
    {
        super.onDestroy();
    }

    public final void onPause()
    {
        try
        {
            if (l != null && (l.d() == h.a || l.d() == h.b))
            {
                l.e();
                f.setVisibility(8);
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        a();
        super.onPause();
    }

    public final void onResume()
    {
        ar.a(getActivity());
        if (c != null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                c.onResume();
            } else
            {
                try
                {
                    Class.forName("android.webkit.WebView").getMethod("onResume", null).invoke(c, null);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }
        super.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("position", a);
        if (c != null)
        {
            c.saveState(bundle);
        }
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        View view1;
        view1 = getView();
        d = (TextView)view1.findViewById(0x7f0a00a7);
        d.setVisibility(8);
        if (c != null)
        {
            a();
            c.stopLoading();
            c.destroy();
        }
        c = new WebView(getSherlockActivity());
        if (!b.m.a.PrimaryBgColor.equals("DARK")) goto _L2; else goto _L1
_L1:
        c.setBackgroundColor(getResources().getColor(0x7f09003d));
        d.setTextColor(getResources().getColor(0x7f09003f));
_L3:
        f = (ProgressBar)view1.findViewById(0x7f0a0073);
        c.setFocusableInTouchMode(true);
        c.setFocusable(true);
        c.setVerticalScrollBarEnabled(false);
        c.setOnTouchListener(new m(this));
        if (android.os.Build.VERSION.SDK_INT >= 7)
        {
            c.getSettings().setDomStorageEnabled(true);
        }
        c.setHorizontalScrollBarEnabled(false);
        c.setWebChromeClient(new p(this, (MainActivity)getActivity()));
        c.setWebViewClient(new q(this, (MainActivity)getActivity()));
        c.setScrollBarStyle(0);
        c.addJavascriptInterface(new o(this, getActivity()), "AppYet");
        WebSettings websettings = c.getSettings();
        websettings.setSaveFormData(false);
        websettings.setSavePassword(false);
        websettings.setUserAgentString(b.v);
        websettings.setJavaScriptEnabled(true);
        websettings.setPluginState(android.webkit.WebSettings.PluginState.OFF);
        websettings.setJavaScriptCanOpenWindowsAutomatically(false);
        websettings.setSupportMultipleWindows(false);
        websettings.setSupportZoom(false);
        websettings.setUseWideViewPort(false);
        websettings.setLoadWithOverviewMode(false);
        websettings.setGeolocationEnabled(false);
        websettings.setCacheMode(-1);
        e = (FrameLayout)view.findViewById(0x7f0a0088);
        e.removeAllViews();
        e.addView(c);
        l = new n(this, c, view1);
        l.a(new Void[0]);
_L4:
        super.onViewCreated(view, bundle);
        return;
_L2:
        c.setBackgroundColor(getResources().getColor(0x7f09003c));
        d.setTextColor(getResources().getColor(0x7f09003e));
          goto _L3
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
          goto _L4
    }
}
