// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.actionbarsherlock.app.ActionBar;
import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;

// Referenced classes of package com.appyet.c:
//            k

final class p extends WebChromeClient
{

    final k a;
    private ApplicationContext b;
    private View c;
    private FrameLayout d;
    private FrameLayout e;
    private android.webkit.WebChromeClient.CustomViewCallback f;
    private MainActivity g;
    private ProgressBar h;
    private final android.widget.FrameLayout.LayoutParams i = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);

    public p(k k, MainActivity mainactivity)
    {
        a = k;
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
