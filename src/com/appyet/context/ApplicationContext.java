// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.context;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.a.a.a.b.a.c;
import com.a.a.b.f;
import com.a.a.b.h;
import com.appyet.d.d;
import com.appyet.d.e;
import com.appyet.data.DatabaseHelper;
import com.appyet.manager.a;
import com.appyet.manager.af;
import com.appyet.manager.al;
import com.appyet.manager.am;
import com.appyet.manager.an;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.manager.as;
import com.appyet.manager.b;
import com.appyet.manager.bk;
import com.appyet.manager.bl;
import com.appyet.manager.bp;
import com.appyet.manager.bq;
import com.appyet.manager.bw;
import com.appyet.manager.bx;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataAppSync;
import com.appyet.metadata.MetadataApplication;
import com.appyet.receiver.AlarmReceiver;
import com.google.a.k;
import com.google.a.r;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package com.appyet.context:
//            f, g

public class ApplicationContext extends Application
{

    private static int B = 0;
    public static String b = "app.yet";
    public int A;
    public boolean a;
    public as c;
    public bp d;
    public ap e;
    public b f;
    public bl g;
    public com.appyet.manager.d h;
    public bk i;
    public al j;
    public al k;
    public af l;
    public bw m;
    public com.appyet.context.f n;
    public g o;
    public an p;
    public Metadata q;
    public MetadataAppSync r;
    public a s;
    public bq t;
    public bx u;
    public String v;
    public String w;
    public String x;
    public int y;
    public int z;

    public ApplicationContext()
    {
        a = false;
    }

    public static boolean a()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static void d()
    {
        System.gc();
    }

    private void j()
    {
        while (!a()) 
        {
            try
            {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
        j = new al(this);
        j.a(am.b);
        j.h("Image/");
        k = new al(this);
        k.a(am.b);
        k.h("FavIcon/");
    }

    private void k()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        z = displaymetrics.widthPixels;
        A = displaymetrics.heightPixels;
        y = 0xf & getResources().getConfiguration().screenLayout;
    }

    public final void a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        B = i1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final String b()
    {
        String s1;
        try
        {
            s1 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            com.appyet.d.d.a(namenotfoundexception);
            return "";
        }
        return s1;
    }

    public final int c()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = B;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean e()
    {
        Date date = new Date();
        long l1 = d.a();
        int i1 = d.i();
        if (i1 >= 0)
        {
            long l2 = i1 * 0x5265c00;
            if (l1 <= 0L)
            {
                return true;
            }
            if (date.getTime() - l1 > l2)
            {
                return true;
            }
        }
        return false;
    }

    public final boolean f()
    {
        if (d.h())
        {
            Date date = new Date();
            long l1 = d.k();
            long l2 = 60000 * d.l();
            if (l1 <= 0L)
            {
                return true;
            }
            if (date.getTime() - l1 > l2)
            {
                return true;
            }
        }
        return false;
    }

    public final void g()
    {
        try
        {
            String s1 = com.appyet.d.e.a(q.MetadataApplication.AppSyncUrl);
            if (k.g(s1))
            {
                String s2 = k.b(s1, "UTF8");
                r r1 = new r();
                r1.a = "yyyy-MM-dd'T'HH:mm:ss";
                r = (MetadataAppSync)r1.a().a(s2, com/appyet/metadata/MetadataAppSync);
            }
            return;
        }
        catch (Exception exception)
        {
            r = null;
            com.appyet.d.d.a(exception);
            return;
        }
    }

    public final void h()
    {
        long l1 = 1000L;
        AlarmManager alarmmanager;
        PendingIntent pendingintent1;
        Calendar calendar;
        long l2;
        alarmmanager = (AlarmManager)getSystemService("alarm");
        if (!d.h())
        {
            break MISSING_BLOCK_LABEL_118;
        }
        pendingintent1 = PendingIntent.getBroadcast(this, 0, new Intent(this, com/appyet/receiver/AlarmReceiver), 0);
        calendar = Calendar.getInstance();
        l2 = (d.k() + (long)(60000 * d.l())) - calendar.getTimeInMillis();
        PendingIntent pendingintent;
        Exception exception1;
        if (l2 >= l1)
        {
            l1 = l2;
        }
        try
        {
            calendar.add(14, (int)l1);
            alarmmanager.setRepeating(0, calendar.getTimeInMillis(), 60000 * d.l(), pendingintent1);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        break MISSING_BLOCK_LABEL_158;
        pendingintent = PendingIntent.getBroadcast(this, 0, new Intent(this, com/appyet/receiver/AlarmReceiver), 0);
        alarmmanager.cancel(pendingintent);
        return;
        exception1;
        com.appyet.d.d.a(exception1);
        return;
    }

    public final void i()
    {
        if (d.g() == null || d.g().equals(""))
        {
            WebView webview = new WebView(this);
            v = webview.getSettings().getUserAgentString();
            webview.destroy();
            return;
        } else
        {
            v = d.g();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        k();
        super.onConfigurationChanged(configuration);
    }

    public void onCreate()
    {
        super.onCreate();
        k();
        f = new b(this);
        d = new bp(this);
        ar.a(this);
        h = new com.appyet.manager.d(this);
        g = new bl(this);
        t = new bq(this);
        m = new bw(this);
        s = new a(this);
        u = new bx(this);
        c = new as(this);
        n = new com.appyet.context.f(this);
        o = new g(this);
        p = new an(this);
        l = new af(this);
        i = new bk(this);
        w = (new StringBuilder()).append(getPackageName()).append(".intent.action.Ui2Service").toString();
        x = (new StringBuilder()).append(getPackageName()).append(".intent.action.Service2Ui").toString();
        j();
        i();
        com.appyet.manager.d d1 = h;
        d1.b = (DatabaseHelper)OpenHelperManager.getHelper(d1.a, com/appyet/data/DatabaseHelper);
        m.b();
        h();
        c.a();
        g();
        e = new ap(this);
        android.content.Context context = getApplicationContext();
        int i1 = (int)(Runtime.getRuntime().maxMemory() / 8L);
        Object obj;
        com.a.a.b.g g1;
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            obj = new c(i1);
        } else
        {
            obj = new com.a.a.a.b.a.b(i1);
        }
        g1 = (new h(context)).a().a(((com.a.a.a.b.c) (obj))).b().a(new com.a.a.a.a.a.c(j.a(), new com.appyet.e.a())).a(com.a.a.b.a.k.b).c();
        com.a.a.b.f.a().a(g1);
    }

    public void onLowMemory()
    {
        System.gc();
        super.onLowMemory();
    }

    public void onTerminate()
    {
        if (c != null)
        {
            c.b();
        }
        if (h != null)
        {
            com.appyet.manager.d _tmp = h;
            OpenHelperManager.releaseHelper();
        }
        super.onTerminate();
    }

    public void startActivity(Intent intent)
    {
        intent.addFlags(0x10000000);
        super.startActivity(intent);
    }

}
