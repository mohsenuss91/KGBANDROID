// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataTheme;

// Referenced classes of package com.appyet.c:
//            be

final class bh extends WebChromeClient
{

    final be a;
    private ApplicationContext b;
    private View c;
    private FrameLayout d;
    private FrameLayout e;
    private android.webkit.WebChromeClient.CustomViewCallback f;
    private MainActivity g;
    private ProgressBar h;
    private final android.widget.FrameLayout.LayoutParams i = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);

    public bh(be be1, MainActivity mainactivity)
    {
        a = be1;
        super();
        g = mainactivity;
        b = (ApplicationContext)g.getApplicationContext();
    }

    public final View getVideoLoadingProgressView()
    {
        if (h == null)
        {
            h = new ProgressBar(b);
        }
        return h;
    }

    public final void onHideCustomView()
    {
        if (c == null)
        {
            return;
        } else
        {
            c.setVisibility(8);
            e.removeView(c);
            c = null;
            e.setVisibility(8);
            f.onCustomViewHidden();
            d.setVisibility(0);
            g.getSupportActionBar().show();
            g.setRequestedOrientation(-1);
            g.getWindow().clearFlags(1024);
            return;
        }
    }

    public final void onProgressChanged(WebView webview, int j)
    {
        if (j < 100)
        {
            be.a(a).setVisibility(0);
            be.a(a).setProgress(j);
            return;
        } else
        {
            be.a(a).setVisibility(8);
            be.a(a).setProgress(0);
            return;
        }
    }

    public final void onReceivedTitle(WebView webview, String s)
    {
        super.onReceivedTitle(webview, s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        int j;
        if (s.length() <= 0 || a.getSherlockActivity() == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        a.getSherlockActivity().getSupportActionBar().setTitle(s);
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        if (j == 0)
        {
            j = 0x7f0a0041;
        }
        TextView textview;
        textview = (TextView)a.getSherlockActivity().getWindow().findViewById(j);
        textview.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        textview.setSelected(true);
        textview.setMarqueeRepeatLimit(-1);
        if (b.m.a.PrimaryBgColor.equals("DARK"))
        {
            textview.setTextColor(a.getResources().getColor(0x7f09004d));
            return;
        }
        try
        {
            textview.setTextColor(a.getResources().getColor(0x7f09004f));
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        if (c != null)
        {
            customviewcallback.onCustomViewHidden();
            return;
        } else
        {
            d = (FrameLayout)g.findViewById(0x7f0a00c2);
            e = (FrameLayout)g.findViewById(0x7f0a00c3);
            e.addView(view, i);
            c = view;
            f = customviewcallback;
            d.setVisibility(8);
            g.getSupportActionBar().hide();
            g.setRequestedOrientation(0);
            g.getWindow().addFlags(1024);
            e.setVisibility(0);
            e.bringToFront();
            return;
        }
    }
}
