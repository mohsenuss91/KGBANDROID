// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeInitializationResult;
import java.util.ArrayList;

// Referenced classes of package com.google.android.youtube.player.internal:
//            t, ac, i

public abstract class r
    implements t
{

    final Handler a;
    private final Context b;
    private IInterface c;
    private ArrayList d;
    private final ArrayList e = new ArrayList();
    private boolean f;
    private ArrayList g;
    private boolean h;
    private final ArrayList i = new ArrayList();
    private ServiceConnection j;
    private boolean k;

    protected r(Context context, t.a a1, t.b b1)
    {
        f = false;
        h = false;
        k = false;
        if (Looper.getMainLooper().getThread() != Thread.currentThread())
        {
            throw new IllegalStateException("Clients must be created on the UI thread.");
        } else
        {
            b = (Context)ac.a(context);
            d = new ArrayList();
            d.add(ac.a(a1));
            g = new ArrayList();
            g.add(ac.a(b1));
            a = new a();
            return;
        }
    }

    static IInterface a(r r1, IInterface iinterface)
    {
        r1.c = iinterface;
        return iinterface;
    }

    static YouTubeInitializationResult a(String s)
    {
        return b(s);
    }

    static ArrayList a(r r1)
    {
        return r1.d;
    }

    private static YouTubeInitializationResult b(String s)
    {
        YouTubeInitializationResult youtubeinitializationresult;
        try
        {
            youtubeinitializationresult = YouTubeInitializationResult.valueOf(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
        catch (NullPointerException nullpointerexception)
        {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
        return youtubeinitializationresult;
    }

    static boolean b(r r1)
    {
        return r1.k;
    }

    static ArrayList c(r r1)
    {
        return r1.i;
    }

    static IInterface d(r r1)
    {
        return r1.c;
    }

    static ServiceConnection e(r r1)
    {
        return r1.j;
    }

    static Context f(r r1)
    {
        return r1.b;
    }

    static ServiceConnection g(r r1)
    {
        r1.j = null;
        return null;
    }

    protected abstract IInterface a(IBinder ibinder);

    protected final void a(YouTubeInitializationResult youtubeinitializationresult)
    {
        a.removeMessages(4);
        ArrayList arraylist = g;
        arraylist;
        JVM INSTR monitorenter ;
        ArrayList arraylist1;
        int l;
        h = true;
        arraylist1 = g;
        l = arraylist1.size();
        int i1 = 0;
_L2:
        if (i1 >= l)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if (k)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        arraylist;
        JVM INSTR monitorexit ;
        return;
        if (g.contains(arraylist1.get(i1)))
        {
            ((t.b)arraylist1.get(i1)).a(youtubeinitializationresult);
        }
        break MISSING_BLOCK_LABEL_102;
        h = false;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected abstract void a(i l, d d1);

    protected abstract String b();

    protected final void b(IBinder ibinder)
    {
        try
        {
            a(com.google.android.youtube.player.internal.i.a.a(ibinder), new d());
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("YouTubeClient", "service died");
        }
    }

    protected abstract String c();

    public void d()
    {
        h();
        k = false;
        ArrayList arraylist = i;
        arraylist;
        JVM INSTR monitorenter ;
        int l = i.size();
        int i1 = 0;
_L2:
        if (i1 >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        ((b)i.get(i1)).b();
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        i.clear();
        arraylist;
        JVM INSTR monitorexit ;
        c = null;
        if (j != null)
        {
            b.unbindService(j);
            j = null;
        }
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void e()
    {
        k = true;
        YouTubeInitializationResult youtubeinitializationresult = YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(b);
        if (youtubeinitializationresult != YouTubeInitializationResult.SUCCESS)
        {
            a.sendMessage(a.obtainMessage(3, youtubeinitializationresult));
        } else
        {
            Intent intent = new Intent(c());
            if (j != null)
            {
                Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
                c = null;
                b.unbindService(j);
            }
            j = new e();
            if (!b.bindService(intent, j, 129))
            {
                a.sendMessage(a.obtainMessage(3, YouTubeInitializationResult.ERROR_CONNECTING_TO_SERVICE));
                return;
            }
        }
    }

    public final boolean f()
    {
        return c != null;
    }

    protected final void g()
    {
        boolean flag = true;
        ArrayList arraylist = d;
        arraylist;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag1;
        ArrayList arraylist1;
        int l;
        int i1;
        if (!f)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        ac.a(flag1);
        a.removeMessages(4);
        f = true;
        if (e.size() != 0)
        {
            flag = false;
        }
        ac.a(flag);
        arraylist1 = d;
        l = arraylist1.size();
        i1 = 0;
_L2:
        if (i1 >= l)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        if (k && f())
        {
            e.size();
            if (!e.contains(arraylist1.get(i1)))
            {
                ((t.a)arraylist1.get(i1)).a();
            }
            break MISSING_BLOCK_LABEL_151;
        }
        e.clear();
        f = false;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected final void h()
    {
        a.removeMessages(4);
        ArrayList arraylist = d;
        arraylist;
        JVM INSTR monitorenter ;
        ArrayList arraylist1;
        int l;
        f = true;
        arraylist1 = d;
        l = arraylist1.size();
        int i1 = 0;
_L2:
        if (i1 >= l)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        if (k)
        {
            if (d.contains(arraylist1.get(i1)))
            {
                ((t.a)arraylist1.get(i1)).b();
            }
            break MISSING_BLOCK_LABEL_94;
        }
        f = false;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected final void i()
    {
        if (!f())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        } else
        {
            return;
        }
    }

    protected final IInterface j()
    {
        i();
        return c;
    }

    private class a extends Handler
    {

        final r a;

        public final void handleMessage(Message message)
        {
            if (message.what == 3)
            {
                a.a((YouTubeInitializationResult)message.obj);
            } else
            {
                if (message.what == 4)
                {
                    synchronized (r.a(a))
                    {
                        if (r.b(a) && a.f() && r.a(a).contains(message.obj))
                        {
                            ((t.a)message.obj).a();
                        }
                    }
                    return;
                }
                if ((message.what != 2 || a.f()) && (message.what == 2 || message.what == 1))
                {
                    ((b)message.obj).a();
                    return;
                }
            }
        }

        a()
        {
            a = r.this;
            super();
        }
    }


    private class d extends c.a
    {

        final r a;

        public final void a(String s, IBinder ibinder)
        {
            a.a.sendMessage(a.a.obtainMessage(1, a. new c(s, ibinder)));
        }

        protected d()
        {
            a = r.this;
            super();
        }

        private class c extends b
        {

            public final YouTubeInitializationResult b;
            public final IBinder c;
            final r d;

            protected final void a(Object obj)
            {
label0:
                {
                    if ((Boolean)obj != null)
                    {
                        switch (_cls1.a[b.ordinal()])
                        {
                        default:
                            d.a(b);
                            break;

                        case 1: // '\001'
                            break label0;
                        }
                    }
                    return;
                }
                try
                {
                    String s = c.getInterfaceDescriptor();
                    if (d.b().equals(s))
                    {
                        r.a(d, d.a(c));
                        if (r.d(d) != null)
                        {
                            d.g();
                            return;
                        }
                    }
                }
                catch (RemoteException remoteexception) { }
                r.f(d).unbindService(r.e(d));
                r.g(d);
                r.a(d, null);
                d.a(YouTubeInitializationResult.INTERNAL_ERROR);
            }

            public c(String s, IBinder ibinder)
            {
                d = r.this;
                super(Boolean.valueOf(true));
                b = r.a(s);
                c = ibinder;
            }

            private class _cls1
            {

                static final int a[];

                static 
                {
                    a = new int[YouTubeInitializationResult.values().length];
                    try
                    {
                        a[YouTubeInitializationResult.SUCCESS.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                }
            }

        }

    }


    private class b
    {

        final r a;
        private Object b;

        public final void a()
        {
            this;
            JVM INSTR monitorenter ;
            Object obj = b;
            this;
            JVM INSTR monitorexit ;
            a(obj);
            return;
            Exception exception;
            exception;
            throw exception;
        }

        protected abstract void a(Object obj);

        public final void b()
        {
            this;
            JVM INSTR monitorenter ;
            b = null;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public b(Object obj)
        {
            a = r.this;
            super();
            b = obj;
            synchronized (r.c(r.this))
            {
                r.c(r.this).add(this);
            }
        }
    }


    private class e
        implements ServiceConnection
    {

        final r a;

        public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            a.b(ibinder);
        }

        public final void onServiceDisconnected(ComponentName componentname)
        {
            r.a(a, null);
            a.h();
        }

        e()
        {
            a = r.this;
            super();
        }
    }

}
