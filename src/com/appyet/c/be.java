// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.data.Module;
import com.appyet.data.Web;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.manager.b;
import com.appyet.manager.bk;
import com.appyet.manager.bw;
import com.appyet.manager.d;
import com.appyet.metadata.MetadataModuleWeb;
import com.appyet.metadata.MetadataTheme;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.appyet.c:
//            bh, bi, bf, bg

public final class be extends SherlockFragment
{

    boolean a;
    boolean b;
    private ApplicationContext c;
    private WebView d;
    private Long e;
    private Module f;
    private Web g;
    private ProgressBar h;
    private String i;
    private String j;
    private ValueCallback k;

    public be()
    {
        a = true;
        b = false;
        i = "http://APPYET_BASE";
    }

    static ProgressBar a(be be1)
    {
        return be1.h;
    }

    static String a(be be1, String s)
    {
        be1.j = s;
        return s;
    }

    static ApplicationContext b(be be1)
    {
        return be1.c;
    }

    static String c(be be1)
    {
        return be1.j;
    }

    static Web d(be be1)
    {
        return be1.g;
    }

    static String e(be be1)
    {
        return be1.i;
    }

    static WebView f(be be1)
    {
        return be1.d;
    }

    public final void onActivityResult(int l, int i1, Intent intent)
    {
        if (l != 1 || k == null)
        {
            return;
        }
        android.net.Uri uri;
        if (intent == null || i1 != -1)
        {
            uri = null;
        } else
        {
            uri = intent.getData();
        }
        k.onReceiveValue(uri);
        k = null;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        c = (ApplicationContext)getSherlockActivity().getApplicationContext();
        e = Long.valueOf(getArguments().getLong("ModuleId"));
        g = c.h.h(e.longValue());
        f = c.h.g(e.longValue());
        getSherlockActivity().getSupportActionBar().setTitle(0x7f080116);
        if (f.getIcon() == null) goto _L2; else goto _L1
_L1:
        InputStream inputstream = null;
        InputStream inputstream2 = getResources().getAssets().open((new StringBuilder("module/")).append(f.getIcon()).toString());
        InputStream inputstream1 = inputstream2;
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream1);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int l = bitmap.getWidth();
        int i1 = bitmap.getHeight();
        float f1 = displaymetrics.scaledDensity;
        float f2 = displaymetrics.scaledDensity;
        Matrix matrix = new Matrix();
        matrix.postScale(f1, f2);
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, l, i1, matrix, true);
        BitmapDrawable bitmapdrawable = new BitmapDrawable(getResources(), bitmap1);
        getSherlockActivity().getSupportActionBar().setIcon(bitmapdrawable);
        if (inputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        inputstream1.close();
_L4:
        setHasOptionsMenu(true);
        return;
        IOException ioexception1;
        ioexception1;
_L7:
        com.appyet.d.d.a(ioexception1);
        getSherlockActivity().getSupportActionBar().setIcon(0x7f0200dd);
        if (inputstream == null) goto _L4; else goto _L3
_L3:
        inputstream.close();
          goto _L4
        IOException ioexception2;
        ioexception2;
        ActionBar actionbar;
        com.appyet.d.d.a(ioexception2);
        actionbar = getSherlockActivity().getSupportActionBar();
_L5:
        actionbar.setIcon(0x7f0200dd);
          goto _L4
        Exception exception;
        exception;
        inputstream1 = null;
_L6:
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            catch (IOException ioexception)
            {
                com.appyet.d.d.a(ioexception);
                getSherlockActivity().getSupportActionBar().setIcon(0x7f0200dd);
            }
        }
        throw exception;
_L2:
        getSherlockActivity().getSupportActionBar().setIcon(0x7f0200dd);
          goto _L4
        IOException ioexception3;
        ioexception3;
        com.appyet.d.d.a(ioexception3);
        actionbar = getSherlockActivity().getSupportActionBar();
          goto _L5
        exception;
          goto _L6
        exception;
        inputstream1 = inputstream;
          goto _L6
        ioexception1;
        inputstream = inputstream1;
          goto _L7
    }

    public final void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f0f000d, menu);
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030066, null);
    }

    public final void onDestroy()
    {
        c.f.c();
        super.onDestroy();
    }

    public final boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 4: default 48
    //                   2131362037: 54
    //                   2131362071: 71
    //                   2131362072: 105
    //                   2131362073: 88;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        d.reload();
        getSherlockActivity().supportInvalidateOptionsMenu();
        continue; /* Loop/switch isn't completed */
_L3:
        d.stopLoading();
        getSherlockActivity().supportInvalidateOptionsMenu();
        continue; /* Loop/switch isn't completed */
_L5:
        d.goForward();
        getSherlockActivity().supportInvalidateOptionsMenu();
        continue; /* Loop/switch isn't completed */
_L4:
        d.goBack();
        getSherlockActivity().supportInvalidateOptionsMenu();
        if (true) goto _L1; else goto _L6
_L6:
    }

    public final void onPause()
    {
label0:
        {
            c.f.a();
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

    public final void onPrepareOptionsMenu(Menu menu)
    {
        MenuItem menuitem;
        MenuItem menuitem1;
        MenuItem menuitem2;
        MenuItem menuitem3;
        if (d != null && d.canGoBack())
        {
            menu.findItem(0x7f0a0118).setVisible(true);
        } else
        {
            menu.findItem(0x7f0a0118).setVisible(false);
        }
        if (d != null && d.canGoForward())
        {
            menu.findItem(0x7f0a0119).setVisible(true);
        } else
        {
            menu.findItem(0x7f0a0119).setVisible(false);
        }
        menuitem = menu.findItem(0x7f0a00f5);
        menuitem1 = menu.findItem(0x7f0a0117);
        menuitem2 = menu.findItem(0x7f0a0119);
        menuitem3 = menu.findItem(0x7f0a0118);
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
        super.onPrepareOptionsMenu(menu);
    }

    public final void onResume()
    {
        j = null;
        ActionBar actionbar;
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
        actionbar = getSherlockActivity().getSupportActionBar();
        if (getResources().getBoolean(0x7f0d000d))
        {
            actionbar.setDisplayHomeAsUpEnabled(false);
            actionbar.setHomeButtonEnabled(false);
        } else
        {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeButtonEnabled(true);
        }
        super.onResume();
        c.f.b();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        d.saveState(bundle);
        super.onSaveInstanceState(bundle);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        try
        {
            h = (ProgressBar)view.findViewById(0x7f0a00ec);
            h.setMax(100);
            d = (WebView)view.findViewById(0x7f0a00eb);
            if (android.os.Build.VERSION.SDK_INT >= 7)
            {
                d.getSettings().setDomStorageEnabled(true);
            }
            d.getSettings().setSaveFormData(false);
            d.getSettings().setSavePassword(false);
            d.getSettings().setJavaScriptEnabled(true);
            d.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
            d.getSettings().setUserAgentString(c.v);
            d.getSettings().setSupportZoom(false);
            d.getSettings().setBuiltInZoomControls(false);
            d.getSettings().setPluginState(android.webkit.WebSettings.PluginState.OFF);
            d.getSettings().setSupportMultipleWindows(false);
            d.getSettings().setLoadWithOverviewMode(false);
            d.getSettings().setGeolocationEnabled(false);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                d.getSettings().setDisplayZoomControls(false);
            }
            d.getSettings().setUseWideViewPort(false);
            d.setScrollBarStyle(0);
            d.setWebChromeClient(new bh(this, (MainActivity)getSherlockActivity()));
            d.setWebViewClient(new bi(this));
            d.setFocusableInTouchMode(true);
            d.setFocusable(true);
            d.setHorizontalScrollBarEnabled(false);
            d.setOnTouchListener(new bf(this));
            d.addJavascriptInterface(new bg(this, getActivity()), "AppYet");
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        if (bundle == null) goto _L2; else goto _L1
_L1:
        d.restoreState(bundle);
_L3:
        if (c.i.a(f.getGuid()).IsShowAd)
        {
            ViewGroup viewgroup = (ViewGroup)getView().findViewById(0x7f0a00a6);
            c.f.a(getSherlockActivity(), viewgroup);
            c.e.a("Web");
            return;
        }
        break MISSING_BLOCK_LABEL_500;
_L2:
label0:
        {
            if (!g.getType().equals("Link"))
            {
                break label0;
            }
            HashMap hashmap = new HashMap();
            hashmap.put("Accept-Language", ar.c(c));
            d.loadUrl(g.getData(), hashmap);
        }
          goto _L3
        d.loadDataWithBaseURL(i, g.getData(), "text/html", "UTF-8", "");
          goto _L3
    }
}
