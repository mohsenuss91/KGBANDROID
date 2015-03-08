// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.appyet.c.a;
import com.appyet.c.a.e;
import com.appyet.c.a.i;
import com.appyet.c.a.r;
import com.appyet.c.a.w;
import com.appyet.c.ak;
import com.appyet.c.ay;
import com.appyet.c.be;
import com.appyet.c.bj;
import com.appyet.context.ApplicationContext;
import com.appyet.data.Feed;
import com.appyet.data.FeedItem;
import com.appyet.data.Module;
import com.appyet.f.k;
import com.appyet.manager.al;
import com.appyet.manager.an;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.manager.bk;
import com.appyet.manager.bp;
import com.appyet.manager.bq;
import com.appyet.manager.bw;
import com.appyet.manager.d;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataApplication;
import com.appyet.metadata.MetadataModuleWeb;
import com.appyet.metadata.MetadataSetting;
import com.appyet.metadata.MetadataTheme;
import com.appyet.receiver.b;
import com.appyet.receiver.c;
import com.google.analytics.tracking.android.Tracker;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.o;
import net.simonvt.menudrawer.x;

// Referenced classes of package com.appyet.activity:
//            u, DownloadActivity, o, SettingsActivity, 
//            p, q, WebBrowserActivity, r, 
//            s, t, CustomizeActivity, WhatsNewActivity, 
//            n

public class MainActivity extends SherlockFragmentActivity
    implements e, w, ak, b
{

    protected k a;
    private ApplicationContext b;
    private ay c;
    private int d;
    private c e;
    private MenuDrawer f;
    private Drawable g;
    private int h;
    private o i;

    public MainActivity()
    {
        d = 0;
        a = new k(this);
        g = null;
        i = new u(this);
    }

    static MenuDrawer a(MainActivity mainactivity)
    {
        return mainactivity.f;
    }

    private boolean a(Intent intent)
    {
        Module module;
        module = null;
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        boolean flag = intent.hasExtra("ACTION_WIDGET_OPEN_FEEDITEM_ID");
        module = null;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        long l = intent.getLongExtra("ACTION_WIDGET_OPEN_FEEDITEM_ID", -1L);
        int j = l != -1L;
        module = null;
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        FeedItem feeditem = b.h.c(l);
        module = null;
        if (feeditem == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        Feed feed = b.h.a(feeditem.getFeed().getFeedId().longValue());
        module = null;
        if (feed == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        module = b.h.g(feed.getModuleId());
        if (module == null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        a(module.getType(), module.getModuleId(), module.getGuid());
        return true;
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        b.e.a(exception);
        return false;
    }

    static ApplicationContext b(MainActivity mainactivity)
    {
        return mainactivity.b;
    }

    static int c(MainActivity mainactivity)
    {
        int j = mainactivity.d;
        mainactivity.d = j + 1;
        return j;
    }

    static int d(MainActivity mainactivity)
    {
        return mainactivity.d;
    }

    private void d()
    {
        long l;
        List list;
        l = b.d.Q();
        list = b.h.g();
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Module module = (Module)iterator.next();
            if (module.getModuleId().equals(Long.valueOf(l)))
            {
                a(module.getType(), module.getModuleId(), module.getGuid());
                return;
            }
        }

        try
        {
            if (list.size() > 0)
            {
                a(((Module)list.get(0)).getType(), ((Module)list.get(0)).getModuleId(), ((Module)list.get(0)).getGuid());
                return;
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            b.e.a(exception);
        }
    }

    static ay e(MainActivity mainactivity)
    {
        return mainactivity.c;
    }

    private void e()
    {
        try
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
            int j = displaymetrics.widthPixels;
            if ((float)j < getResources().getDimension(0x7f0c0025) + getResources().getDimension(0x7f0c0024))
            {
                f.setMenuSize(j - getResources().getDimensionPixelSize(0x7f0c0024));
                return;
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            b.e.a(exception);
            return;
        }
        f.setMenuSize(getResources().getDimensionPixelSize(0x7f0c0025));
        return;
    }

    public final MenuDrawer a()
    {
        return f;
    }

    public final void a(int j, Long long1)
    {
        a a1 = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_POSITION", j);
        if (long1 != null)
        {
            bundle.putLong("ARG_MODULE_ID", long1.longValue());
        }
        a1.setArguments(bundle);
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        fragmenttransaction.replace(0x7f0a00c2, a1, "FeedItemDetailFragment");
        fragmenttransaction.addToBackStack("FeedItemDetailFragment");
        fragmenttransaction.setTransition(4097);
        fragmenttransaction.commitAllowingStateLoss();
    }

    public final void a(Long long1, String s1, String s2)
    {
        com.appyet.a.a.d d1;
        com.appyet.a.a.a a1;
        d1 = b.p.a(long1.longValue());
        a1 = b.p.a(long1.longValue(), s1);
        if (a1 == null)
        {
            return;
        }
        if (a1.k) goto _L2; else goto _L1
_L1:
        Iterator iterator = d1.b.iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        if (!((com.appyet.a.a.a)iterator.next()).d.equals(s1)) goto _L5; else goto _L4
_L4:
        boolean flag = true;
_L7:
        if ((a1.k || flag) && s2 != s1)
        {
            com.appyet.c.a.a a2 = new com.appyet.c.a.a();
            Bundle bundle = new Bundle();
            bundle.putString("ForumId", s1);
            bundle.putLong("ModuleId", long1.longValue());
            a2.setArguments(bundle);
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            fragmenttransaction.replace(0x7f0a00c2, a2, "ForumBrowseFragment");
            fragmenttransaction.addToBackStack("ForumBrowseFragment");
            fragmenttransaction.setTransition(4097);
            fragmenttransaction.commitAllowingStateLoss();
            return;
        } else
        {
            r r1 = new r();
            Bundle bundle1 = new Bundle();
            bundle1.putString("ARG_FORUM_ID", s1);
            bundle1.putLong("ARG_MODULE_ID", long1.longValue());
            r1.setArguments(bundle1);
            FragmentTransaction fragmenttransaction1 = getSupportFragmentManager().beginTransaction();
            fragmenttransaction1.replace(0x7f0a00c2, r1, "ForumTopicFragment");
            fragmenttransaction1.addToBackStack("ForumTopicFragment");
            fragmenttransaction1.setTransition(4097);
            fragmenttransaction1.commitAllowingStateLoss();
            return;
        }
_L2:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void a(String s1, Long long1, String s2)
    {
        if (s1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Exception exception;
        if (!s1.equals("Sync"))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (b.c() == 0)
        {
            Toast.makeText(b, 0x7f080052, 1).show();
            b.t.a(true);
            return;
        }
        try
        {
            Toast.makeText(b, 0x7f080052, 1).show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            b.e.a(exception);
            return;
        }
        if (s1.equals("Downloads"))
        {
            Intent intent = new Intent(b, com/appyet/activity/DownloadActivity);
            b.startActivity(intent);
            return;
        }
        if (!s1.equals("Themes")) goto _L4; else goto _L3
_L3:
        if (b.q.MetadataThemes.size() == 1) goto _L1; else goto _L5
_L5:
        if (b.q.MetadataThemes.size() != 2)
        {
            break MISSING_BLOCK_LABEL_326;
        }
        if (!((MetadataTheme)b.q.MetadataThemes.get(1)).Guid.equals(b.d.F()))
        {
            break MISSING_BLOCK_LABEL_291;
        }
        b.d.b(((MetadataTheme)b.q.MetadataThemes.get(0)).Guid);
_L7:
        b.m.a();
        finish();
        Intent intent3 = new Intent(this, com/appyet/activity/MainActivity);
        intent3.addFlags(0x4000000);
        intent3.addFlags(0x10000000);
        startActivity(intent3);
        return;
        b.d.b(((MetadataTheme)b.q.MetadataThemes.get(1)).Guid);
        if (true) goto _L7; else goto _L6
_L6:
        int j = b.q.MetadataThemes.size();
        if (j < 3) goto _L1; else goto _L8
_L8:
        ArrayList arraylist = new ArrayList();
        int l;
        int i1;
        l = 0;
        i1 = 0;
_L11:
        MetadataTheme metadatatheme;
        if (i1 >= b.q.MetadataThemes.size())
        {
            break MISSING_BLOCK_LABEL_451;
        }
        metadatatheme = (MetadataTheme)b.q.MetadataThemes.get(i1);
        arraylist.add(com.appyet.f.w.b(this, metadatatheme.Name));
        int j1;
        Intent intent1;
        FragmentManager fragmentmanager;
        FragmentTransaction fragmenttransaction;
        com.appyet.c.a.a a1;
        Bundle bundle;
        FragmentManager fragmentmanager1;
        FragmentTransaction fragmenttransaction1;
        bj bj1;
        Bundle bundle1;
        MetadataModuleWeb metadatamoduleweb;
        FragmentManager fragmentmanager2;
        FragmentTransaction fragmenttransaction2;
        be be1;
        Bundle bundle2;
        Intent intent2;
        FragmentManager fragmentmanager3;
        FragmentTransaction fragmenttransaction3;
        com.appyet.c.r r1;
        Bundle bundle3;
        FragmentManager fragmentmanager4;
        FragmentTransaction fragmenttransaction4;
        com.appyet.c.r r2;
        Bundle bundle4;
        Exception exception1;
        CharSequence acharsequence[];
        android.app.AlertDialog.Builder builder;
        if (metadatatheme.Guid.equals(b.d.F()))
        {
            j1 = i1;
        } else
        {
            j1 = l;
        }
        break MISSING_BLOCK_LABEL_1545;
        acharsequence = (CharSequence[])arraylist.toArray(new CharSequence[arraylist.size()]);
        builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(0x7f0800de));
        builder.setSingleChoiceItems(acharsequence, l, new com.appyet.activity.o(this));
        builder.create().show();
        return;
        exception1;
        com.appyet.d.d.a(exception1);
        return;
_L4:
        if (s1.equals("Settings"))
        {
            startActivityForResult(new Intent(b, com/appyet/activity/SettingsActivity), 2);
            return;
        }
        if (s1.equals("Feed"))
        {
            fragmentmanager4 = getSupportFragmentManager();
            fragmenttransaction4 = fragmentmanager4.beginTransaction();
            r2 = new com.appyet.c.r();
            bundle4 = new Bundle();
            bundle4.putString("DisplayType", "Module");
            bundle4.putLong("ModuleId", long1.longValue());
            r2.setArguments(bundle4);
            r2.setRetainInstance(true);
            fragmentmanager4.popBackStack(null, 1);
            fragmenttransaction4.setCustomAnimations(0x7f04000e, 0x7f040012);
            fragmenttransaction4.replace(0x7f0a00c2, r2, "ContentFrameFragment");
            fragmenttransaction4.commitAllowingStateLoss();
            if (!getResources().getBoolean(0x7f0d000d))
            {
                (new Handler()).postDelayed(new p(this), 100L);
            }
            b.d.c(long1.longValue());
            return;
        }
        if (s1.equals("FeedQuery"))
        {
            fragmentmanager3 = getSupportFragmentManager();
            fragmenttransaction3 = fragmentmanager3.beginTransaction();
            r1 = new com.appyet.c.r();
            bundle3 = new Bundle();
            bundle3.putString("DisplayType", "FeedQuery");
            bundle3.putLong("ModuleId", long1.longValue());
            r1.setArguments(bundle3);
            r1.setRetainInstance(true);
            fragmentmanager3.popBackStack(null, 1);
            fragmenttransaction3.setCustomAnimations(0x7f04000e, 0x7f040012);
            fragmenttransaction3.replace(0x7f0a00c2, r1, "ContentFrameFragment");
            fragmenttransaction3.commitAllowingStateLoss();
            if (!getResources().getBoolean(0x7f0d000d))
            {
                (new Handler()).postDelayed(new q(this), 100L);
            }
            b.d.c(long1.longValue());
            return;
        }
        if (!s1.equals("Web"))
        {
            break MISSING_BLOCK_LABEL_1195;
        }
        metadatamoduleweb = b.i.a(s2);
        if (metadatamoduleweb == null) goto _L1; else goto _L9
_L9:
        if (metadatamoduleweb.Type == null || !metadatamoduleweb.Type.equals("Link") || metadatamoduleweb.LinkTarget == null || !metadatamoduleweb.LinkTarget.equals("NIA") && !metadatamoduleweb.LinkTarget.equals("NSD"))
        {
            break MISSING_BLOCK_LABEL_1050;
        }
        if (metadatamoduleweb.LinkTarget.equals("NIA"))
        {
            intent2 = new Intent(this, com/appyet/activity/WebBrowserActivity);
            intent2.putExtra("URL", metadatamoduleweb.Data);
            startActivity(intent2);
            return;
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(metadatamoduleweb.Data)));
        return;
        fragmentmanager2 = getSupportFragmentManager();
        fragmenttransaction2 = fragmentmanager2.beginTransaction();
        be1 = new be();
        bundle2 = new Bundle();
        bundle2.putLong("ModuleId", long1.longValue());
        be1.setArguments(bundle2);
        be1.setRetainInstance(true);
        fragmentmanager2.popBackStack(null, 1);
        fragmenttransaction2.setCustomAnimations(0x7f04000e, 0x7f040012);
        fragmenttransaction2.replace(0x7f0a00c2, be1, "ContentFrameFragment");
        fragmenttransaction2.commitAllowingStateLoss();
        if (!getResources().getBoolean(0x7f0d000d))
        {
            (new Handler()).postDelayed(new com.appyet.activity.r(this), 100L);
        }
        b.d.c(long1.longValue());
        return;
        if (s1.equals("YouTube"))
        {
            fragmentmanager1 = getSupportFragmentManager();
            fragmenttransaction1 = fragmentmanager1.beginTransaction();
            bj1 = new bj();
            bundle1 = new Bundle();
            bundle1.putLong("ModuleId", long1.longValue());
            bj1.setArguments(bundle1);
            bj1.setRetainInstance(true);
            fragmentmanager1.popBackStack(null, 1);
            fragmenttransaction1.setCustomAnimations(0x7f04000e, 0x7f040012);
            fragmenttransaction1.replace(0x7f0a00c2, bj1, "ContentFrameFragment");
            fragmenttransaction1.commitAllowingStateLoss();
            if (!getResources().getBoolean(0x7f0d000d))
            {
                (new Handler()).postDelayed(new s(this), 100L);
            }
            b.d.c(long1.longValue());
            return;
        }
        if (s1.equals("Forum"))
        {
            fragmentmanager = getSupportFragmentManager();
            fragmenttransaction = fragmentmanager.beginTransaction();
            a1 = new com.appyet.c.a.a();
            bundle = new Bundle();
            bundle.putLong("ModuleId", long1.longValue());
            a1.setArguments(bundle);
            a1.setRetainInstance(true);
            fragmentmanager.popBackStack(null, 1);
            fragmenttransaction.setCustomAnimations(0x7f04000e, 0x7f040012);
            fragmenttransaction.replace(0x7f0a00c2, a1, "ContentFrameFragment");
            fragmenttransaction.commitAllowingStateLoss();
            if (!getResources().getBoolean(0x7f0d000d))
            {
                (new Handler()).postDelayed(new t(this), 100L);
            }
            b.d.c(long1.longValue());
            return;
        }
        if (!s1.equals("Customize")) goto _L1; else goto _L10
_L10:
        intent1 = new Intent(b, com/appyet/activity/CustomizeActivity);
        b.startActivity(intent1);
        return;
        i1++;
        l = j1;
          goto _L11
    }

    public final void b()
    {
        c();
    }

    public final void b(Long long1, String s1, String s2)
    {
        i j = new i();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_TOPIC_ID", s2);
        bundle.putString("ARG_FORUM_ID", s1);
        bundle.putLong("ARG_MODULE_ID", long1.longValue());
        j.setArguments(bundle);
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        fragmenttransaction.replace(0x7f0a00c2, j, "ForumThreadFragment");
        fragmenttransaction.addToBackStack("ForumThreadFragment");
        fragmenttransaction.setTransition(4097);
        fragmenttransaction.commitAllowingStateLoss();
    }

    public final void c()
    {
        if (getResources().getBoolean(0x7f0d000d))
        {
            if (c != null)
            {
                c.a();
                return;
            }
            break MISSING_BLOCK_LABEL_58;
        }
        try
        {
            if (c != null && f.b())
            {
                c.a();
                return;
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public File getCacheDir()
    {
        return super.getCacheDir();
    }

    protected void onActivityResult(int j, int l, Intent intent)
    {
        super.onActivityResult(j, l, intent);
        switch (j)
        {
        default:
            return;

        case 2: // '\002'
            break;
        }
        try
        {
            b.m.b();
            b.i();
            b.h();
            if (ar.a == null || !ar.a.toString().equals(b.d.q()))
            {
                ar.a = null;
                ar.a(this);
                finish();
                Intent intent1 = new Intent(this, com/appyet/activity/MainActivity);
                intent1.addFlags(0x4000000);
                intent1.addFlags(0x10000000);
                startActivity(intent1);
                return;
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            b.e.a(exception);
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        e();
        super.onConfigurationChanged(configuration);
        ar.a(this);
    }

    public void onCreate(Bundle bundle)
    {
        ar.a(this);
        b = (ApplicationContext)getApplicationContext();
        if (b.d.P() != -1) goto _L2; else goto _L1
_L1:
        b.d.b(b.q.MetadataSetting.DefaultThemeGuid);
        if (b.q.MetadataSetting.DefaultUpdateInterval != -1) goto _L4; else goto _L3
_L3:
        b.d.e(false);
        b.d.b(60);
_L21:
        b.d.f(b.q.MetadataSetting.IsSyncOnStartUp);
        b.d.b(b.q.MetadataSetting.IsWiFiOnlyForArticle);
        b.d.c(b.q.MetadataSetting.IsWiFiOnlyForImage);
        b.d.d(b.q.MetadataSetting.IsWiFiOnlyForDownload);
        b.d.c(b.q.MetadataSetting.AutoCleanUpRead);
        b.d.d(b.q.MetadataSetting.AutoCleanUpUnread);
_L2:
        RelativeLayout relativelayout;
        FrameLayout framelayout;
        ap ap1;
        Uri uri;
        if (b.q.MetadataApplication.ApplicationVersionCode != b.d.P())
        {
            Exception exception;
            FragmentManager fragmentmanager;
            FragmentTransaction fragmenttransaction;
            ay ay1;
            Intent intent;
            int j;
            ColorDrawable colordrawable;
            boolean flag;
            try
            {
                String s1 = com.appyet.d.e.a(b.q.MetadataApplication.AppSyncUrl);
                if (b.k.g(s1))
                {
                    b.k.a(s1);
                    b.r = null;
                }
            }
            catch (Exception exception4)
            {
                com.appyet.d.d.a(exception4);
            }
            b.d.a(1L);
            b.d.b(0L);
            b.d.g(b.q.MetadataApplication.ApplicationVersionCode);
            try
            {
                b.h.k();
                b.t.a(true);
            }
            catch (Exception exception6)
            {
                com.appyet.d.d.a(exception6);
            }
            catch (Error error)
            {
                com.appyet.d.d.a(error);
            }
            try
            {
                if (b.q.MetadataSetting.WhatsNew != null)
                {
                    startActivity(new Intent(this, com/appyet/activity/WhatsNewActivity));
                }
            }
            catch (Exception exception5)
            {
                com.appyet.d.d.a(exception5);
            }
            catch (Error error1)
            {
                com.appyet.d.d.a(error1);
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            getWindow().setFlags(0x1000000, 0x1000000);
        }
        b.m.a(this);
        super.onCreate(bundle);
        if (getResources().getBoolean(0x7f0d000d)) goto _L6; else goto _L5
_L5:
        if (b.q.MetadataSetting.LeftMenuType == null)
        {
            b.q.MetadataSetting.LeftMenuType = "SBWWO";
        }
        if (b.q.MetadataSetting.LeftMenuType.equals("SBWWO")) goto _L8; else goto _L7
_L7:
        if (b.q.MetadataSetting.LeftMenuType.equals("SBCWO"))
        {
            f = MenuDrawer.a(this, net.simonvt.menudrawer.r.a, x.a, 0);
            f.setOffsetMenuEnabled(true);
        } else
        if (b.q.MetadataSetting.LeftMenuType.equals("SBWWOO"))
        {
            f = MenuDrawer.a(this, net.simonvt.menudrawer.r.a, x.a, 0);
            f.setOffsetMenuEnabled(false);
        } else
        if (b.q.MetadataSetting.LeftMenuType.equals("SBCWOO"))
        {
            f = MenuDrawer.a(this, net.simonvt.menudrawer.r.a, x.a, 0);
            f.setOffsetMenuEnabled(false);
        } else
        {
label0:
            {
                if (!b.q.MetadataSetting.LeftMenuType.equals("SOAW"))
                {
                    break label0;
                }
                f = MenuDrawer.a(this, net.simonvt.menudrawer.r.c, x.a, 1);
            }
        }
_L23:
        f.setContentView(0x7f030058);
        f.setMenuView(0x7f030052);
        if (b.m.a.ActionBarFgColor)
        {
            f.setSlideDrawable(0x7f0200e4);
        } else
        {
            f.setSlideDrawable(0x7f0200e3);
        }
        f.setDrawerIndicatorEnabled(true);
        e();
        f.setDropShadowSize(getResources().getDimensionPixelSize(0x7f0c0027));
        f.setDropShadow(0x7f020111);
        f.setTouchMode(2);
        f.setOnDrawerStateChangeListener(i);
        getSupportActionBar().setHomeButtonEnabled(true);
_L24:
        relativelayout = (RelativeLayout)findViewById(0x7f0a00c1);
        framelayout = (FrameLayout)findViewById(0x7f0a00c0);
        if (b.m.a.PrimaryBgColor.equals("DARK"))
        {
            relativelayout.setBackgroundColor(getResources().getColor(0x7f09003d));
            framelayout.setBackgroundColor(getResources().getColor(0x7f09003d));
        } else
        {
            relativelayout.setBackgroundColor(getResources().getColor(0x7f09003c));
            framelayout.setBackgroundColor(getResources().getColor(0x7f09003c));
        }
        fragmentmanager = getSupportFragmentManager();
        fragmenttransaction = fragmentmanager.beginTransaction();
        if (fragmentmanager.findFragmentByTag("LeftMenuFragment") == null)
        {
            ay1 = new ay();
            ay1.setRetainInstance(true);
            fragmenttransaction.replace(0x7f0a00c0, ay1, "LeftMenuFragment");
            c = ay1;
            fragmenttransaction.commitAllowingStateLoss();
        }
        if (!a(getIntent()))
        {
            d();
        }
        if (b.d.O())
        {
            b.t.a(false);
        }
        flag = getResources().getBoolean(0x7f0d000d);
        if (!flag) goto _L10; else goto _L9
_L9:
        ap1 = b.e;
        intent = getIntent();
        if (intent == null) goto _L12; else goto _L11
_L11:
        uri = intent.getData();
        if (uri == null) goto _L12; else goto _L13
_L13:
        if (ap1.a == null || uri == null) goto _L15; else goto _L14
_L14:
        if (uri.getQueryParameter("utm_source") == null) goto _L17; else goto _L16
_L16:
        ap1.a.set("&cs", uri.getPath());
_L15:
        if (ap1.b == null || uri == null) goto _L12; else goto _L18
_L18:
        if (uri.getQueryParameter("utm_source") == null) goto _L20; else goto _L19
_L19:
        ap1.b.set("&cs", uri.getPath());
_L12:
        b.e.a("Home");
        j = Color.parseColor(b.m.a.ActionBarBgColor);
        colordrawable = new ColorDrawable(j);
        Exception exception1;
        Drawable drawable;
        LayerDrawable layerdrawable;
        Exception exception2;
        Exception exception3;
        if (b.m.a.ActionBarFgColor)
        {
            drawable = getResources().getDrawable(0x7f020072);
        } else
        {
            drawable = getResources().getDrawable(0x7f020073);
        }
        layerdrawable = new LayerDrawable(new Drawable[] {
            colordrawable, drawable
        });
        if (g == null)
        {
            getSupportActionBar().setBackgroundDrawable(layerdrawable);
        } else
        {
            Drawable adrawable[] = new Drawable[2];
            adrawable[0] = g;
            adrawable[1] = layerdrawable;
            TransitionDrawable transitiondrawable = new TransitionDrawable(adrawable);
            getSupportActionBar().setBackgroundDrawable(transitiondrawable);
            transitiondrawable.startTransition(200);
        }
        g = layerdrawable;
        h = j;
        a.a();
        return;
_L4:
        b.d.e(true);
        b.d.b(b.q.MetadataSetting.DefaultUpdateInterval);
          goto _L21
        exception;
        com.appyet.d.d.a(exception);
        b.e.a(exception);
          goto _L2
        if (!b.q.MetadataSetting.LeftMenuType.equals("SOAC")) goto _L8; else goto _L22
_L22:
        f = MenuDrawer.a(this, net.simonvt.menudrawer.r.c, x.a, 0);
          goto _L23
_L8:
        f = MenuDrawer.a(this, net.simonvt.menudrawer.r.a, x.a, 1);
        f.setOffsetMenuEnabled(true);
          goto _L23
_L6:
        setContentView(0x7f030058);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
          goto _L24
_L10:
        if (b.d.S() && b.d.Q() != -1L) goto _L9; else goto _L25
_L25:
        (new Handler()).postDelayed(new n(this), 1000L);
          goto _L9
        exception1;
        com.appyet.d.d.a(exception1);
        b.e.a(exception1);
          goto _L9
_L17:
        if (uri.getQueryParameter("referrer") == null) goto _L15; else goto _L26
_L26:
        ap1.a.set("&dr", uri.getQueryParameter("referrer"));
          goto _L15
        exception2;
        com.appyet.d.d.a(exception2);
          goto _L15
_L20:
        if (uri.getQueryParameter("referrer") == null) goto _L12; else goto _L27
_L27:
        ap1.b.set("&dr", uri.getQueryParameter("referrer"));
          goto _L12
        exception3;
        com.appyet.d.d.a(exception3);
          goto _L12
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onKeyUp(int j, KeyEvent keyevent)
    {
        if (getResources().getBoolean(0x7f0d000d)) goto _L2; else goto _L1
_L1:
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (j != 4) goto _L2; else goto _L3
_L3:
        if (fragmentmanager.getBackStackEntryCount() != 0) goto _L5; else goto _L4
_L4:
        if (!f.b())
        {
            break MISSING_BLOCK_LABEL_48;
        }
        finish();
        return true;
        f.n();
        return true;
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
_L2:
        return super.onKeyUp(j, keyevent);
_L5:
        if (!f.b()) goto _L2; else goto _L6
_L6:
        f.o();
        return true;
    }

    protected void onNewIntent(Intent intent)
    {
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        long l;
        if (!intent.hasExtra("ACTION_WIDGET_OPEN_FEEDITEM_ID"))
        {
            break MISSING_BLOCK_LABEL_80;
        }
        l = intent.getLongExtra("ACTION_WIDGET_OPEN_FEEDITEM_ID", -1L);
        if (l != -1L)
        {
            try
            {
                finish();
                Intent intent1 = new Intent(this, com/appyet/activity/MainActivity);
                intent1.addFlags(0x4000000);
                intent1.addFlags(0x10000000);
                intent1.putExtra("ACTION_WIDGET_OPEN_FEEDITEM_ID", l);
                startActivity(intent1);
            }
            catch (Exception exception)
            {
                com.appyet.d.d.a(exception);
                b.e.a(exception);
            }
        }
        super.onNewIntent(intent);
        return;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int j = menuitem.getItemId();
        j;
        JVM INSTR tableswitch 16908332 16908332: default 28
    //                   16908332 34;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) goto _L4; else goto _L3
_L3:
        if (getResources().getBoolean(0x7f0d000d))
        {
            continue; /* Loop/switch isn't completed */
        }
        f.m();
        return true;
_L4:
        try
        {
            onBackPressed();
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            b.e.a(exception);
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void onPause()
    {
        unregisterReceiver(e);
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        ar.a(this);
        b.a = true;
        ((NotificationManager)getSystemService("notification")).cancel(0);
        e = new c(this);
        IntentFilter intentfilter = new IntentFilter(b.x);
        registerReceiver(e, intentfilter);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
    }
}
