// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gb;
import com.google.android.gms.internal.hn;

public final class AppStateManager
{

    public static final Api API;
    public static final Scope SCOPE_APP_STATE;
    static final com.google.android.gms.common.api.Api.c yE;
    private static final com.google.android.gms.common.api.Api.b yF;

    private AppStateManager()
    {
    }

    public static gb a(GoogleApiClient googleapiclient)
    {
        boolean flag = true;
        boolean flag1;
        gb gb1;
        if (googleapiclient != null)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        hn.b(flag1, "GoogleApiClient parameter is required.");
        hn.a(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        gb1 = (gb)googleapiclient.a(yE);
        if (gb1 == null)
        {
            flag = false;
        }
        hn.a(flag, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return gb1;
    }

    public static PendingResult delete(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.b(new _cls5(i));
    }

    private static StateResult e(Status status)
    {
        return new _cls2(status);
    }

    static StateResult f(Status status)
    {
        return e(status);
    }

    public static int getMaxNumKeys(GoogleApiClient googleapiclient)
    {
        return a(googleapiclient).dQ();
    }

    public static int getMaxStateSize(GoogleApiClient googleapiclient)
    {
        return a(googleapiclient).dP();
    }

    public static PendingResult list(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new _cls7());
    }

    public static PendingResult load(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.a(new _cls6(i));
    }

    public static PendingResult resolve(GoogleApiClient googleapiclient, int i, String s, byte abyte0[])
    {
        return googleapiclient.b(new _cls8(i, s, abyte0));
    }

    public static PendingResult signOut(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new _cls9());
    }

    public static void update(GoogleApiClient googleapiclient, int i, byte abyte0[])
    {
        googleapiclient.b(new _cls3(i, abyte0));
    }

    public static PendingResult updateImmediate(GoogleApiClient googleapiclient, int i, byte abyte0[])
    {
        return googleapiclient.b(new _cls4(i, abyte0));
    }

    static 
    {
        yE = new com.google.android.gms.common.api.Api.c();
        yF = new _cls1();
        SCOPE_APP_STATE = new Scope("https://www.googleapis.com/auth/appstate");
        com.google.android.gms.common.api.Api.b b = yF;
        com.google.android.gms.common.api.Api.c c = yE;
        Scope ascope[] = new Scope[1];
        ascope[0] = SCOPE_APP_STATE;
        API = new Api(b, c, ascope);
    }

    private class _cls5 extends b
    {
        private class b extends a
        {
            private class a extends com.google.android.gms.common.api.a.b
            {

                public a()
                {
                    super(AppStateManager.yE);
                }
            }


            private b()
            {
            }

            b(_cls1 _pcls1)
            {
                this();
            }
        }


        final int yH;

        protected final volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gb)a1);
        }

        protected final void a(gb gb1)
        {
            gb1.a(this, yH);
        }

        public final Result c(Status status)
        {
            return g(status);
        }

        public final StateDeletedResult g(Status status)
        {
            class _cls1
                implements StateDeletedResult
            {

                final Status yG;
                final _cls5 yJ;

                public int getStateKey()
                {
                    return yJ.yH;
                }

                public Status getStatus()
                {
                    return yG;
                }

                _cls1(Status status)
                {
                    yJ = _cls5.this;
                    yG = status;
                    super();
                }
            }

            return new _cls1(status);
        }

        _cls5(int i)
        {
            yH = i;
            super(null);
        }
    }


    private class _cls2
        implements StateResult
    {

        final Status yG;

        public final StateConflictResult getConflictResult()
        {
            return null;
        }

        public final StateLoadedResult getLoadedResult()
        {
            return null;
        }

        public final Status getStatus()
        {
            return yG;
        }

        public final void release()
        {
        }

        _cls2(Status status)
        {
            yG = status;
            super();
        }
    }


    private class _cls7 extends c
    {
        private class c extends a
        {

            public Result c(Status status)
            {
                return h(status);
            }

            public StateListResult h(Status status)
            {
                class _cls1
                    implements StateListResult
                {

                    final Status yG;
                    final c yM;

                    public AppStateBuffer getStateBuffer()
                    {
                        return new AppStateBuffer(null);
                    }

                    public Status getStatus()
                    {
                        return yG;
                    }

                    _cls1(Status status)
                    {
                        yM = c.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls1(status);
            }

            private c()
            {
            }

            c(_cls1 _pcls1)
            {
                this();
            }
        }


        protected final volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            ((gb)a1).a(this);
        }

        protected final void a(gb gb1)
        {
            gb1.a(this);
        }

        _cls7()
        {
            super(null);
        }
    }


    private class _cls6 extends e
    {
        private class e extends a
        {

            public Result c(Status status)
            {
                return i(status);
            }

            public StateResult i(Status status)
            {
                return AppStateManager.f(status);
            }

            private e()
            {
            }

            e(_cls1 _pcls1)
            {
                this();
            }
        }


        final int yH;

        protected final volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gb)a1);
        }

        protected final void a(gb gb1)
        {
            gb1.b(this, yH);
        }

        _cls6(int i)
        {
            yH = i;
            super(null);
        }
    }


    private class _cls8 extends e
    {

        final int yH;
        final String yK;
        final byte yL[];

        protected final volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gb)a1);
        }

        protected final void a(gb gb1)
        {
            gb1.a(this, yH, yK, yL);
        }

        _cls8(int i, String s, byte abyte0[])
        {
            yH = i;
            yK = s;
            yL = abyte0;
            super(null);
        }
    }


    private class _cls9 extends d
    {
        private class d extends a
        {

            public Result c(Status status)
            {
                return d(status);
            }

            public Status d(Status status)
            {
                return status;
            }

            private d()
            {
            }

            d(_cls1 _pcls1)
            {
                this();
            }
        }


        protected final void a(com.google.android.gms.common.api.Api.a a1)
        {
            ((gb)a1).b(this);
        }

        protected final void a(gb gb1)
        {
            gb1.b(this);
        }

        _cls9()
        {
            super(null);
        }
    }


    private class _cls3 extends e
    {

        final int yH;
        final byte yI[];

        protected final volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gb)a1);
        }

        protected final void a(gb gb1)
        {
            gb1.a(null, yH, yI);
        }

        _cls3(int i, byte abyte0[])
        {
            yH = i;
            yI = abyte0;
            super(null);
        }
    }


    private class _cls4 extends e
    {

        final int yH;
        final byte yI[];

        protected final volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gb)a1);
        }

        protected final void a(gb gb1)
        {
            gb1.a(this, yH, yI);
        }

        _cls4(int i, byte abyte0[])
        {
            yH = i;
            yI = abyte0;
            super(null);
        }
    }


    private class _cls1
        implements com.google.android.gms.common.api.Api.b
    {

        public final com.google.android.gms.common.api.Api.a a(Context context, Looper looper, gz gz1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return b(context, looper, gz1, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final gb b(Context context, Looper looper, gz gz1, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new gb(context, looper, connectioncallbacks, onconnectionfailedlistener, gz1.fe(), (String[])gz1.fg().toArray(new String[0]));
        }

        public final int getPriority()
        {
            return 0x7fffffff;
        }

        _cls1()
        {
        }
    }

}
