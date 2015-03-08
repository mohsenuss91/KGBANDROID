// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.d.e;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.manager.bw;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataApplication;
import com.appyet.metadata.MetadataTheme;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Locale;

// Referenced classes of package com.appyet.activity:
//            g, h, f

public class DisqusCommentActivity extends SherlockActivity
    implements com.actionbarsherlock.widget.ShareActionProvider.OnShareTargetSelectedListener
{

    boolean a;
    boolean b;
    private ApplicationContext c;
    private WebView d;
    private String e;
    private String f;
    private String g;
    private String h;
    private ProgressBar i;
    private Drawable j;
    private int k;

    public DisqusCommentActivity()
    {
        e = "appyet";
        a = true;
        b = false;
        j = null;
    }

    private Intent a()
    {
        Intent intent;
        intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        if (f != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        intent.putExtra("android.intent.extra.SUBJECT", g);
        intent.putExtra("android.intent.extra.TEXT", g);
        return intent;
        try
        {
            intent.putExtra("android.intent.extra.SUBJECT", f);
            intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(f).append(" ").append(g).toString());
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return null;
        }
        return intent;
    }

    static ProgressBar a(DisqusCommentActivity disquscommentactivity)
    {
        return disquscommentactivity.i;
    }

    private String b()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder("<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\" /><title>")).append(TextUtils.htmlEncode(f)).append("</title>").toString());
        stringbuilder.append("</head><body>");
        stringbuilder.append("<div id=\"disqus_thread\"></div><script type=\"text/javascript\">var disqus_shortname = \"").append(e).append("\";");
        if (!TextUtils.isEmpty(h))
        {
            stringbuilder.append("var disqus_identifier = \"").append(h.replace("\"", "\\\"")).append("\";");
        }
        if (!TextUtils.isEmpty(g))
        {
            stringbuilder.append("var disqus_url = \"").append(g.replace("\"", "\\\"")).append("\";");
        }
        if (!TextUtils.isEmpty(f))
        {
            stringbuilder.append("var disqus_title = \"").append(f.replace("\"", "\\\"")).append("\";");
        }
        stringbuilder.append((new StringBuilder("var disqus_config = function () {this.language = \"")).append(c()).append("\";};").toString());
        stringbuilder.append("(function() {var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;dsq.src = 'http://' + disqus_shortname + '.disqus.com/embed.js';(document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);})();</script><noscript>Please enable JavaScript to view comments</a></noscript>");
        stringbuilder.append("</body></html>");
        return stringbuilder.toString();
    }

    static void b(DisqusCommentActivity disquscommentactivity)
    {
        disquscommentactivity.d.loadDataWithBaseURL("http://base", disquscommentactivity.b(), "text/html", "UTF-8", "http://comment");
    }

    static ApplicationContext c(DisqusCommentActivity disquscommentactivity)
    {
        return disquscommentactivity.c;
    }

    private static String c()
    {
        String s;
        String s1;
        String s2;
        s = Locale.getDefault().getLanguage();
        s1 = Locale.getDefault().getCountry();
        s2 = null;
        if (s == null) goto _L2; else goto _L1
_L1:
        s2 = null;
        if (s1 == null) goto _L2; else goto _L3
_L3:
        boolean flag;
        flag = s.equalsIgnoreCase("zh");
        s2 = null;
        if (!flag) goto _L2; else goto _L4
_L4:
        if (!s1.equalsIgnoreCase("HK")) goto _L6; else goto _L5
_L5:
        s2 = "TW";
_L2:
        if (s2 != null)
        {
            s = (new StringBuilder()).append(s).append("_").append(s2).toString();
        }
        return s;
_L6:
        boolean flag1 = s1.equalsIgnoreCase("TW");
        s2 = null;
        if (flag1)
        {
            s2 = "TW";
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    static WebView d(DisqusCommentActivity disquscommentactivity)
    {
        return disquscommentactivity.d;
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
        c = (ApplicationContext)getApplicationContext();
        c.m.a(this);
        super.onCreate(bundle);
        setContentView(0x7f030066);
        setTitle(0x7f0800c3);
        int l;
        ColorDrawable colordrawable;
        l = Color.parseColor(c.m.a.ActionBarBgColor);
        colordrawable = new ColorDrawable(l);
        if (!c.m.a.ActionBarFgColor) goto _L2; else goto _L1
_L1:
        Drawable drawable = getResources().getDrawable(0x7f020072);
_L9:
        LayerDrawable layerdrawable = new LayerDrawable(new Drawable[] {
            colordrawable, drawable
        });
        if (j != null) goto _L4; else goto _L3
_L3:
        getSupportActionBar().setBackgroundDrawable(layerdrawable);
_L10:
        j = layerdrawable;
        k = l;
        i = (ProgressBar)findViewById(0x7f0a00ec);
        i.setMax(100);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);
        d = (WebView)findViewById(0x7f0a00eb);
        if (android.os.Build.VERSION.SDK_INT >= 7)
        {
            d.getSettings().setDomStorageEnabled(true);
        }
        d.getSettings().setJavaScriptEnabled(true);
        d.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        d.getSettings().setSupportMultipleWindows(false);
        d.getSettings().setSupportZoom(true);
        d.getSettings().setBuiltInZoomControls(true);
        d.getSettings().setAppCacheEnabled(false);
        d.getSettings().setCacheMode(2);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            d.getSettings().setDisplayZoomControls(false);
        }
        d.getSettings().setUseWideViewPort(true);
        d.getSettings().setUserAgentString(c.v);
        d.setScrollBarStyle(0);
        d.setWebChromeClient(new g(this, this));
        d.setWebViewClient(new h(this));
        d.requestFocus(130);
        d.setOnTouchListener(new f(this));
        Bundle bundle1 = getIntent().getExtras();
        String s = null;
        if (bundle1 == null) goto _L6; else goto _L5
_L5:
        if (!bundle1.containsKey("ArticleUrl")) goto _L8; else goto _L7
_L7:
        s = bundle1.getString("ArticleUrl");
_L11:
        if (bundle1.containsKey("ArticleTitle"))
        {
            f = bundle1.getString("ArticleTitle");
        }
        if (bundle1.containsKey("DisQusShortName"))
        {
            e = bundle1.getString("DisQusShortName");
        }
_L6:
        h = com.appyet.d.e.a(s);
        g = (new StringBuilder("http://www.appyet.com/Handler/Disqus.ashx?guid=")).append(c.q.MetadataApplication.Guid).append("&id=").append(h).append("&shortname=").append(e).append("&locale=").append(c()).append("&title=").append(URLEncoder.encode(f, "UTF-8")).append("&url=").append(URLEncoder.encode(s, "UTF-8")).toString();
_L12:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_743;
        }
        d.restoreState(bundle);
_L13:
        c.e.a("DisQusComment");
        return;
_L2:
        Drawable adrawable[];
        TransitionDrawable transitiondrawable;
        try
        {
            drawable = getResources().getDrawable(0x7f020073);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
          goto _L9
_L4:
        adrawable = new Drawable[2];
        adrawable[0] = j;
        adrawable[1] = layerdrawable;
        transitiondrawable = new TransitionDrawable(adrawable);
        getSupportActionBar().setBackgroundDrawable(transitiondrawable);
        transitiondrawable.startTransition(200);
          goto _L10
_L8:
        finish();
        s = null;
          goto _L11
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
          goto _L12
        d.loadDataWithBaseURL("http://base", b(), "text/html", "UTF-8", "http://comment");
          goto _L13
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f000e, menu);
        ShareActionProvider shareactionprovider = (ShareActionProvider)menu.findItem(0x7f0a00f3).getActionProvider();
        shareactionprovider.setShareHistoryFileName("share_history.xml");
        shareactionprovider.setOnShareTargetSelectedListener(this);
        shareactionprovider.setShareIntent(a());
        MenuItem menuitem = menu.findItem(0x7f0a00f5);
        MenuItem menuitem1 = menu.findItem(0x7f0a0117);
        MenuItem menuitem2 = menu.findItem(0x7f0a0119);
        MenuItem menuitem3 = menu.findItem(0x7f0a0118);
        if (c.m.a.PrimaryBgColor.equals("DARK"))
        {
            menuitem.setIcon(0x7f0200c7);
            menuitem1.setIcon(0x7f0200c5);
            menuitem2.setIcon(0x7f0200c6);
            menuitem3.setIcon(0x7f0200c4);
        } else
        {
            menuitem.setIcon(0x7f0200d9);
            menuitem1.setIcon(0x7f0200d7);
            menuitem2.setIcon(0x7f0200d8);
            menuitem3.setIcon(0x7f0200d6);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onKeyDown(int l, KeyEvent keyevent)
    {
        if (l == 4 && d.canGoBack())
        {
            d.goBack();
            return true;
        } else
        {
            return super.onKeyDown(l, keyevent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int l = menuitem.getItemId();
        l;
        JVM INSTR lookupswitch 7: default 76
    //                   16908332: 82
    //                   2131362037: 131
    //                   2131362068: 187
    //                   2131362071: 145
    //                   2131362072: 173
    //                   2131362073: 159
    //                   2131362074: 97;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        try
        {
            finish();
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
          goto _L1
_L8:
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(g));
        startActivity(intent);
          goto _L1
_L3:
        d.reload();
        supportInvalidateOptionsMenu();
          goto _L1
_L5:
        d.stopLoading();
        supportInvalidateOptionsMenu();
          goto _L1
_L7:
        d.goForward();
        supportInvalidateOptionsMenu();
          goto _L1
_L6:
        d.goBack();
        supportInvalidateOptionsMenu();
          goto _L1
_L4:
        ((ClipboardManager)c.getSystemService("clipboard")).setText(g);
        ApplicationContext applicationcontext = c;
        String s = getString(0x7f080082);
        Object aobj[] = new Object[1];
        aobj[0] = g.toString();
        Toast.makeText(applicationcontext, String.format(s, aobj), 1).show();
          goto _L1
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
          goto _L1
        Error error;
        error;
        com.appyet.d.d.a(error);
          goto _L1
    }

    public void onPause()
    {
label0:
        {
            super.onPause();
            if (d != null)
            {
                if (android.os.Build.VERSION.SDK_INT < 11)
                {
                    break label0;
                }
                d.onPause();
            }
            return;
        }
        try
        {
            Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(d, null);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if (d.canGoBack())
        {
            menu.findItem(0x7f0a0118).setVisible(true);
        } else
        {
            menu.findItem(0x7f0a0118).setVisible(false);
        }
        if (d.canGoForward())
        {
            menu.findItem(0x7f0a0119).setVisible(true);
        } else
        {
            menu.findItem(0x7f0a0119).setVisible(false);
        }
        if (a && !b)
        {
            menu.findItem(0x7f0a0117).setVisible(false);
            menu.findItem(0x7f0a00f5).setVisible(true);
        } else
        {
            menu.findItem(0x7f0a0117).setVisible(true);
            menu.findItem(0x7f0a00f5).setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    protected void onResume()
    {
        ar.a(this);
        if (d != null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                d.onResume();
            } else
            {
                try
                {
                    Class.forName("android.webkit.WebView").getMethod("onResume", null).invoke(d, null);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        d.saveState(bundle);
    }

    public boolean onShareTargetSelected(ShareActionProvider shareactionprovider, Intent intent)
    {
        if (c.y == 3 || c.y == 4)
        {
            return false;
        } else
        {
            c.startActivity(intent);
            c.e.a("Share", intent.getAction(), "WebLink");
            return true;
        }
    }
}
