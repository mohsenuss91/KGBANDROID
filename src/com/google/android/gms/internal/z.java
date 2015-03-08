// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            eu, ev, aj, v

public final class z
{

    private final a ld;
    private final Runnable le;
    private aj lf;
    private boolean lg;
    private boolean lh;
    private long li;

    public z(v v)
    {
        this(v, new a(eu.ss));
    }

    z(v v, a a1)
    {
        lg = false;
        lh = false;
        li = 0L;
        ld = a1;
        le = new _cls1(v);
    }

    static aj a(z z1)
    {
        return z1.lf;
    }

    static boolean a(z z1, boolean flag)
    {
        z1.lg = flag;
        return flag;
    }

    public final void a(aj aj, long l)
    {
        if (lg)
        {
            ev.D("An ad refresh is already scheduled.");
        } else
        {
            lf = aj;
            lg = true;
            li = l;
            if (!lh)
            {
                ev.B((new StringBuilder("Scheduling ad refresh ")).append(l).append(" milliseconds from now.").toString());
                ld.postDelayed(le, l);
                return;
            }
        }
    }

    public final void cancel()
    {
        lg = false;
        ld.removeCallbacks(le);
    }

    public final void d(aj aj)
    {
        a(aj, 60000L);
    }

    public final void pause()
    {
        lh = true;
        if (lg)
        {
            ld.removeCallbacks(le);
        }
    }

    public final void resume()
    {
        lh = false;
        if (lg)
        {
            lg = false;
            a(lf, li);
        }
    }

    private class a
    {

        private final Handler mHandler;

        public boolean postDelayed(Runnable runnable, long l)
        {
            return mHandler.postDelayed(runnable, l);
        }

        public void removeCallbacks(Runnable runnable)
        {
            mHandler.removeCallbacks(runnable);
        }

        public a(Handler handler)
        {
            mHandler = handler;
        }
    }


    private class _cls1
        implements Runnable
    {

        private final WeakReference lj;
        final v lk;
        final z ll;

        public void run()
        {
            z.a(ll, false);
            v v1 = (v)lj.get();
            if (v1 != null)
            {
                v1.b(z.a(ll));
            }
        }

        _cls1(v v1)
        {
            ll = z.this;
            lk = v1;
            super();
            lj = new WeakReference(lk);
        }
    }

}
