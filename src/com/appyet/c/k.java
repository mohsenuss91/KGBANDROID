// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import com.appyet.d.d;
import com.appyet.data.Feed;
import com.appyet.data.FeedItem;
import com.appyet.f.aa;
import com.appyet.manager.ar;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataModuleFeed;
import com.appyet.metadata.MetadataTheme;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.appyet.c:
//            l, p, q, o, 
//            m

public final class k extends SherlockFragment
{

    private int a;
    private ApplicationContext b;
    private WebView c;
    private FrameLayout d;
    private ProgressBar e;
    private String f;
    private String g;
    private String h;
    private MetadataModuleFeed i;
    private FeedItem j;
    private Feed k;

    public k()
    {
        f = "http://APPYET_BASE";
        g = "IMG_APPYET";
        h = "COMMENT_APPYET";
    }

    static WebView a(k k1)
    {
        return k1.c;
    }

    public static String a(String s, String s1)
    {
        StringBuffer stringbuffer;
        Matcher matcher;
        try
        {
            stringbuffer = new StringBuffer();
            String s3;
            String s4;
            for (matcher = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>").matcher(s); matcher.find(); matcher.appendReplacement(stringbuffer, (new StringBuilder("<a href=\"")).append(s1).append("///").append(s4).append("\">").append(s3).append("</a><br>").toString()))
            {
                s3 = matcher.group(0);
                s4 = matcher.group(1);
            }

        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return s;
        }
        String s2;
        matcher.appendTail(stringbuffer);
        s2 = stringbuffer.toString();
        return s2;
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

    public static boolean a(Context context, String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        android.content.pm.ResolveInfo resolveinfo = context.getPackageManager().resolveActivity(intent, 0);
        boolean flag = false;
        if (resolveinfo != null)
        {
            flag = true;
        }
        return flag;
    }

    static FeedItem b(k k1)
    {
        return k1.j;
    }

    static ApplicationContext c(k k1)
    {
        return k1.b;
    }

    static MetadataModuleFeed d(k k1)
    {
        return k1.i;
    }

    static Feed e(k k1)
    {
        return k1.k;
    }

    static String f(k k1)
    {
        return k1.g;
    }

    static String g(k k1)
    {
        return k1.h;
    }

    static String h(k k1)
    {
        return k1.f;
    }

    static ProgressBar i(k k1)
    {
        return k1.e;
    }

    static int j(k k1)
    {
        return k1.a;
    }

    public final void a(int i1)
    {
        a = i1;
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
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03003f, null);
    }

    public final void onDestroy()
    {
        super.onDestroy();
    }

    public final void onPause()
    {
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
        String s;
        view1 = getView();
        if (c != null)
        {
            a();
            c.stopLoading();
            c.destroy();
        }
        j = (FeedItem)b.n.b.get(a);
        s = aa.a(j.getLink());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        f = s;
        k = (Feed)b.n.c.get(j.getFeed().getFeedId());
        i = (MetadataModuleFeed)b.n.d.get(j.getFeed().getFeedId());
        c = new WebView(getSherlockActivity());
        if (!b.m.a.PrimaryBgColor.equals("DARK")) goto _L2; else goto _L1
_L1:
        c.setBackgroundColor(getResources().getColor(0x7f09003d));
_L3:
        e = (ProgressBar)view1.findViewById(0x7f0a0073);
        c.setFocusableInTouchMode(true);
        c.setFocusable(true);
        c.setVerticalScrollBarEnabled(false);
        c.setOnTouchListener(new l(this));
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
        d = (FrameLayout)view.findViewById(0x7f0a0088);
        d.removeAllViews();
        d.addView(c);
        (new m(this, c, view1)).a(new Void[0]);
_L4:
        super.onViewCreated(view, bundle);
        return;
_L2:
        c.setBackgroundColor(getResources().getColor(0x7f09003c));
          goto _L3
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
          goto _L4
    }
}
