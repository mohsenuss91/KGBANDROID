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
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.ValueCallback;
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
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataTheme;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.appyet.activity:
//            an, ao, am

public class WebBrowserActivity extends SherlockActivity
    implements com.actionbarsherlock.widget.ShareActionProvider.OnShareTargetSelectedListener
{

    boolean a;
    boolean b;
    private ApplicationContext c;
    private WebView d;
    private String e;
    private String f;
    private ProgressBar g;
    private ValueCallback h;
    private Drawable i;
    private int j;

    public WebBrowserActivity()
    {
        a = true;
        b = false;
        i = null;
    }

    private Intent a()
    {
        Intent intent;
        intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        if (e != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        intent.putExtra("android.intent.extra.SUBJECT", f);
        intent.putExtra("android.intent.extra.TEXT", f);
        return intent;
        try
        {
            intent.putExtra("android.intent.extra.SUBJECT", e);
            intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(e).append(" ").append(f).toString());
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return null;
        }
        return intent;
    }

    static ProgressBar a(WebBrowserActivity webbrowseractivity)
    {
        return webbrowseractivity.g;
    }

    static ApplicationContext b(WebBrowserActivity webbrowseractivity)
    {
        return webbrowseractivity.c;
    }

    static String c(WebBrowserActivity webbrowseractivity)
    {
        return webbrowseractivity.f;
    }

    static WebView d(WebBrowserActivity webbrowseractivity)
    {
        return webbrowseractivity.d;
    }

    public void onActivityResult(int k, int l, Intent intent)
    {
        if (k != 1 || h == null)
        {
            return;
        }
        Uri uri;
        if (intent == null || l != -1)
        {
            uri = null;
        } else
        {
            uri = intent.getData();
        }
        h.onReceiveValue(uri);
        h = null;
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
        int k;
        ColorDrawable colordrawable;
        getWindow().getDecorView().findViewById(0x1020002);
        k = Color.parseColor(c.m.a.ActionBarBgColor);
        colordrawable = new ColorDrawable(k);
        if (!c.m.a.ActionBarFgColor) goto _L2; else goto _L1
_L1:
        Drawable drawable = getResources().getDrawable(0x7f020072);
_L9:
        LayerDrawable layerdrawable = new LayerDrawable(new Drawable[] {
            colordrawable, drawable
        });
        if (i != null) goto _L4; else goto _L3
_L3:
        getSupportActionBar().setBackgroundDrawable(layerdrawable);
_L10:
        i = layerdrawable;
        j = k;
        g = (ProgressBar)findViewById(0x7f0a00ec);
        g.setMax(100);
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
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            d.getSettings().setDisplayZoomControls(false);
        }
        d.getSettings().setUseWideViewPort(true);
        d.getSettings().setUserAgentString(c.v);
        d.setScrollBarStyle(0);
        d.setWebChromeClient(new an(this, this));
        d.setWebViewClient(new ao(this));
        d.requestFocus(130);
        d.setOnTouchListener(new am(this));
        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 == null) goto _L6; else goto _L5
_L5:
        if (!bundle1.containsKey("URL")) goto _L8; else goto _L7
_L7:
        f = bundle1.getString("URL");
_L11:
        if (bundle1.containsKey("TITLE"))
        {
            e = bundle1.getString("TITLE");
        }
_L6:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_587;
        }
        d.restoreState(bundle);
_L12:
        c.e.a("WebBrowser");
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
        adrawable[0] = i;
        adrawable[1] = layerdrawable;
        transitiondrawable = new TransitionDrawable(adrawable);
        getSupportActionBar().setBackgroundDrawable(transitiondrawable);
        transitiondrawable.startTransition(200);
          goto _L10
_L8:
        finish();
          goto _L11
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
          goto _L6
        HashMap hashmap = new HashMap();
        hashmap.put("Accept-Language", ar.c(c));
        d.loadUrl(f, hashmap);
          goto _L12
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

    public boolean onKeyDown(int k, KeyEvent keyevent)
    {
        if (k == 4 && d.canGoBack())
        {
            d.goBack();
            return true;
        } else
        {
            return super.onKeyDown(k, keyevent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int k = menuitem.getItemId();
        k;
        JVM INSTR lookupswitch 7: default 76
    //                   16908332: 82
    //                   2131362037: 134
    //                   2131362068: 190
    //                   2131362071: 148
    //                   2131362072: 176
    //                   2131362073: 162
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
        intent.setData(Uri.parse(d.getUrl()));
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
        ((ClipboardManager)c.getSystemService("clipboard")).setText(d.getUrl().toString());
        ApplicationContext applicationcontext = c;
        String s = getString(0x7f080082);
        Object aobj[] = new Object[1];
        aobj[0] = d.getUrl().toString();
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
