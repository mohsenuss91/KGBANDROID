// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.appyet.activity.MediaPlayerActivity;
import com.appyet.activity.VideoPlayerActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.data.FeedItem;
import com.appyet.receiver.CommonReceiver;
import com.appyet.wrapper.AudioFocusChangeListenerWrapper;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.appyet.manager:
//            at, ba, bb, bc, 
//            bd, be, bf, bg, 
//            bh, au, av, aw, 
//            ax, ay, az, MediaProgressNotification, 
//            af, bi, bj

public class as
{

    private static boolean l;
    private static Method m;
    private static Method n;
    private android.media.MediaPlayer.OnSeekCompleteListener A;
    private android.media.MediaPlayer.OnVideoSizeChangedListener B;
    private android.view.View.OnClickListener C;
    private android.view.View.OnClickListener D;
    private android.view.View.OnClickListener E;
    private android.view.View.OnClickListener F;
    private android.view.View.OnClickListener G;
    private android.widget.SeekBar.OnSeekBarChangeListener H;
    private boolean I;
    private MediaPlayer a;
    private AudioManager b;
    private Intent c;
    private ApplicationContext d;
    private FeedItem e;
    private String f;
    private String g;
    private Handler h;
    private Handler i;
    private MediaPlayerActivity j;
    private MediaProgressNotification k;
    private ComponentName o;
    private CommonReceiver p;
    private boolean q;
    private bj r;
    private boolean s;
    private Runnable t;
    private Runnable u;
    private android.media.MediaPlayer.OnPreparedListener v;
    private android.media.MediaPlayer.OnBufferingUpdateListener w;
    private android.media.MediaPlayer.OnCompletionListener x;
    private android.media.MediaPlayer.OnErrorListener y;
    private android.media.MediaPlayer.OnInfoListener z;

    public as(ApplicationContext applicationcontext)
    {
        h = new Handler();
        i = new Handler();
        t = new at(this);
        u = new ba(this);
        v = new bb(this);
        w = new bc(this);
        x = new bd(this);
        y = new be(this);
        z = new bf(this);
        A = new bg(this);
        B = new bh(this);
        C = new au(this);
        D = new av(this);
        E = new aw(this);
        F = new ax(this);
        G = new ay(this);
        H = new az(this);
        d = applicationcontext;
    }

    static Intent a(as as1, Intent intent)
    {
        as1.c = intent;
        return intent;
    }

    static Handler a(as as1)
    {
        return as1.h;
    }

    static MediaProgressNotification a(as as1, MediaProgressNotification mediaprogressnotification)
    {
        as1.k = mediaprogressnotification;
        return mediaprogressnotification;
    }

    static Runnable b(as as1)
    {
        return as1.u;
    }

    static Handler c(as as1)
    {
        return as1.i;
    }

    static boolean d(as as1)
    {
        as1.q = false;
        return false;
    }

    public static void e()
    {
    }

    static boolean e(as as1)
    {
        as1.s = false;
        return false;
    }

    static MediaPlayer f(as as1)
    {
        return as1.a;
    }

    static ApplicationContext g(as as1)
    {
        return as1.d;
    }

    static FeedItem h(as as1)
    {
        return as1.e;
    }

    static String i(as as1)
    {
        return as1.g;
    }

    static MediaPlayerActivity j(as as1)
    {
        return as1.j;
    }

    static void k(as as1)
    {
        as1.u();
    }

    static void l(as as1)
    {
        as1.p();
    }

    static void m(as as1)
    {
        as1.s();
    }

    static Intent n(as as1)
    {
        return as1.c;
    }

    private void n()
    {
        if (j != null)
        {
            ProgressBar progressbar = (ProgressBar)j.findViewById(0x7f0a00cc);
            ImageButton imagebutton = (ImageButton)j.findViewById(0x7f0a00cb);
            progressbar.setVisibility(0);
            imagebutton.setVisibility(8);
        }
    }

    private void o()
    {
        if (j != null)
        {
            ProgressBar progressbar = (ProgressBar)j.findViewById(0x7f0a00cc);
            ImageButton imagebutton = (ImageButton)j.findViewById(0x7f0a00cb);
            progressbar.setVisibility(8);
            imagebutton.setVisibility(0);
        }
    }

    static void o(as as1)
    {
        as1.o();
    }

    private void p()
    {
        if (k != null && a != null)
        {
            String s1;
            if (e != null)
            {
                s1 = e.getTitle();
            } else
            if (f != null)
            {
                s1 = f;
            } else
            {
                s1 = "";
            }
            k.a(a.getCurrentPosition(), s1);
        }
    }

    static void p(as as1)
    {
        as1.q();
    }

    private void q()
    {
        ImageButton imagebutton = (ImageButton)j.findViewById(0x7f0a00cb);
        if (g())
        {
            imagebutton.setImageResource(0x7f0200ea);
            return;
        } else
        {
            imagebutton.setImageResource(0x7f0200eb);
            return;
        }
    }

    static void q(as as1)
    {
        as1.r();
    }

    private void r()
    {
        Toast.makeText(d, 0x7f08007a, 1).show();
    }

    private void s()
    {
        try
        {
            t();
            h.postDelayed(t, 1000L);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    private void t()
    {
        try
        {
            if (h != null)
            {
                h.removeCallbacks(t);
            }
            l();
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    private void u()
    {
        if (j != null && e != null && e.getTitle() != null)
        {
            ((TextView)j.findViewById(0x7f0a00c6)).setText(e.getTitle());
            return;
        }
        try
        {
            if (f != null)
            {
                ((TextView)j.findViewById(0x7f0a00c6)).setText(f);
                return;
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return;
    }

    private boolean v()
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        try
        {
            flag = l;
        }
        catch (Exception exception)
        {
            return false;
        }
        catch (Error error)
        {
            return false;
        }
        flag1 = false;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        flag2 = (new AudioFocusChangeListenerWrapper(d)).requestFocus(b);
        flag1 = flag2;
        return flag1;
    }

    private boolean w()
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        try
        {
            flag = l;
        }
        catch (Exception exception)
        {
            return false;
        }
        catch (Error error)
        {
            return false;
        }
        flag1 = false;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        flag2 = (new AudioFocusChangeListenerWrapper(d)).abandonFocus(b);
        flag1 = flag2;
        return flag1;
    }

    public final void a()
    {
        if (m == null)
        {
            return;
        }
        try
        {
            if (o != null && b != null)
            {
                Method method = m;
                AudioManager audiomanager = b;
                Object aobj[] = new Object[1];
                aobj[0] = o;
                method.invoke(audiomanager, aobj);
                return;
            }
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            Throwable throwable = invocationtargetexception.getCause();
            if (throwable instanceof RuntimeException)
            {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof Error)
            {
                throw (Error)throwable;
            } else
            {
                throw new RuntimeException(invocationtargetexception);
            }
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            com.appyet.d.d.a(illegalaccessexception);
        }
        return;
    }

    public final void a(int i1)
    {
        if (a != null)
        {
            a.seekTo(a.getCurrentPosition() + i1 * 1000);
        }
    }

    public final void a(MediaPlayerActivity mediaplayeractivity)
    {
        j = mediaplayeractivity;
        if (!s) goto _L2; else goto _L1
_L1:
        n();
_L4:
        ((SeekBar)j.findViewById(0x7f0a00c7)).setOnSeekBarChangeListener(H);
        ((ImageButton)j.findViewById(0x7f0a00cb)).setOnClickListener(C);
        ((ImageButton)j.findViewById(0x7f0a00ca)).setOnClickListener(D);
        ((ImageButton)j.findViewById(0x7f0a00cd)).setOnClickListener(E);
        ((Button)j.findViewById(0x7f0a00ce)).setOnClickListener(G);
        ((Button)j.findViewById(0x7f0a00cf)).setOnClickListener(F);
          goto _L3
_L2:
        o();
          goto _L4
_L3:
        try
        {
            u();
            l();
            if (a != null && a.isPlaying())
            {
                s();
            }
            q();
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
          goto _L3
    }

    public final void a(FeedItem feeditem)
    {
        if (feeditem == null)
        {
            return;
        }
        try
        {
            d();
            e = feeditem;
            g = null;
            f = null;
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        r();
    }

    public final void a(File file)
    {
        if (file == null)
        {
            return;
        }
        String s1;
        d();
        g = file.getAbsolutePath();
        s1 = file.getName();
        String s2 = s1;
        int i1 = s2.indexOf('_');
        if (i1 == -1)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        String s4 = s2.substring(i1 + 1);
        s2 = s4;
_L2:
        try
        {
            if (s2.length() == 0)
            {
                s2 = file.getName();
            }
            f = s2;
            e = null;
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        r();
        return;
        Exception exception1;
        exception1;
        String s3;
        com.appyet.d.d.a(exception1);
        s3 = file.getName();
        s2 = s3;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a(String s1, String s2)
    {
        if (s1 == null)
        {
            return;
        }
        try
        {
            d();
            g = s1;
            f = s2;
            e = null;
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        r();
    }

    public final void a(boolean flag)
    {
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_464;
        }
        if (e.getEnclosureType().toLowerCase().contains("video"))
        {
            Intent intent = new Intent(d, com/appyet/activity/VideoPlayerActivity);
            intent.setDataAndType(Uri.parse(e.getEnclosureLink().toString()), e.getEnclosureType());
            d.startActivity(intent);
            return;
        }
        String s1;
        try
        {
            d();
            u();
            a = new MediaPlayer();
            b = (AudioManager)d.getSystemService("audio");
            o = new ComponentName(d.getPackageName(), com/appyet/manager/as.getName());
            v();
            a();
            p = new CommonReceiver();
            d.registerReceiver(p, new IntentFilter("android.intent.action.HEADSET_PLUG"));
            s1 = d.l.a(e.getTitle(), e.getEnclosureLink(), e.getEnclosureType());
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            r();
            return;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_355;
        }
        if (d.l.c(s1))
        {
            a.setDataSource(d.l.a(s1));
            a.setOnPreparedListener(v);
            a.setOnBufferingUpdateListener(w);
            a.setOnCompletionListener(x);
            a.setOnErrorListener(y);
            a.setOnInfoListener(z);
            a.setOnSeekCompleteListener(A);
            a.setWakeMode(d, 1);
            a.prepareAsync();
            n();
            s = true;
            return;
        }
        a.setDataSource(e.getEnclosureLink());
        a.setOnPreparedListener(v);
        a.setOnBufferingUpdateListener(w);
        a.setOnCompletionListener(x);
        a.setOnErrorListener(y);
        a.setOnInfoListener(z);
        a.setOnSeekCompleteListener(A);
        a.setWakeMode(d, 1);
        a.prepareAsync();
        n();
        s = true;
        return;
        if (g != null)
        {
            d();
            u();
            a = new MediaPlayer();
            b = (AudioManager)d.getSystemService("audio");
            o = new ComponentName(d.getPackageName(), com/appyet/manager/as.getName());
            v();
            a();
            p = new CommonReceiver();
            d.registerReceiver(p, new IntentFilter("android.intent.action.HEADSET_PLUG"));
            a.setDataSource(g);
            a.setOnPreparedListener(v);
            a.setOnBufferingUpdateListener(w);
            a.setOnCompletionListener(x);
            a.setOnErrorListener(y);
            a.setOnInfoListener(z);
            a.setOnSeekCompleteListener(A);
            a.setWakeMode(d, 1);
            a.prepareAsync();
            n();
            s = true;
        }
        return;
    }

    public final void b()
    {
        if (n == null)
        {
            return;
        }
        try
        {
            if (o != null && b != null)
            {
                Method method = n;
                AudioManager audiomanager = b;
                Object aobj[] = new Object[1];
                aobj[0] = o;
                method.invoke(audiomanager, aobj);
                return;
            }
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            Throwable throwable = invocationtargetexception.getCause();
            if (throwable instanceof RuntimeException)
            {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof Error)
            {
                throw (Error)throwable;
            } else
            {
                throw new RuntimeException(invocationtargetexception);
            }
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            com.appyet.d.d.a(illegalaccessexception);
        }
        return;
    }

    public final MediaProgressNotification c()
    {
        return k;
    }

    public final void d()
    {
        try
        {
            s = false;
            I = false;
            i();
            t();
            if (a != null)
            {
                l();
                a.release();
                a = null;
            }
            if (b != null)
            {
                w();
                b = null;
            }
            if (p != null)
            {
                d.unregisterReceiver(p);
                p = null;
            }
            if (k != null)
            {
                k.b();
                k = null;
            }
            if (j != null)
            {
                ((ImageButton)j.findViewById(0x7f0a00cb)).setImageResource(0x7f0200eb);
            }
            l();
            if (c != null)
            {
                d.stopService(c);
                c = null;
            }
            o();
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final FeedItem f()
    {
        return e;
    }

    public final boolean g()
    {
        return a != null && a.isPlaying();
    }

    public final void h()
    {
        try
        {
            if (a != null && a.isPlaying())
            {
                a.pause();
            }
            I = true;
            i();
            p();
            if (j != null)
            {
                ((ImageButton)j.findViewById(0x7f0a00cb)).setImageResource(0x7f0200eb);
            }
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        r();
    }

    public final void i()
    {
        try
        {
            if (a != null && e != null)
            {
                int i1 = a.getCurrentPosition();
                (new bi(this, i1)).a(new Void[0]);
                e.setEnclosureCurrentPosition(Integer.valueOf(i1));
            }
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void j()
    {
        try
        {
            if (a != null && I)
            {
                if (a.getCurrentPosition() >= a.getDuration())
                {
                    a.seekTo(0);
                    i();
                }
                a.start();
            }
            I = false;
            p();
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        r();
    }

    public final void k()
    {
        try
        {
            j = null;
            t();
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void l()
    {
        try
        {
            if (j != null)
            {
                if (r == null)
                {
                    r = new bj();
                }
                r.a(j, a, e);
                j.runOnUiThread(r);
            }
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final boolean m()
    {
        return I;
    }

    static 
    {
        try
        {
            if (m == null)
            {
                m = com/appyet/manager/as.getMethod("registerMediaButtonEventReceiver", new Class[] {
                    android/content/ComponentName
                });
            }
            if (n == null)
            {
                n = com/appyet/manager/as.getMethod("unregisterMediaButtonEventReceiver", new Class[] {
                    android/content/ComponentName
                });
            }
        }
        catch (NoSuchMethodException nosuchmethodexception) { }
        try
        {
            AudioFocusChangeListenerWrapper.checkAvailable();
            l = true;
            return;
        }
        catch (Throwable throwable)
        {
            l = false;
        }
    }
}
