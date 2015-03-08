// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl
    implements Achievements
{

    public AchievementsImpl()
    {
    }

    public final Intent getAchievementsIntent(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).gZ();
    }

    public final void increment(GoogleApiClient googleapiclient, String s, int i)
    {
        googleapiclient.b(new _cls6(s, s, i));
    }

    public final PendingResult incrementImmediate(GoogleApiClient googleapiclient, String s, int i)
    {
        return googleapiclient.b(new _cls7(s, s, i));
    }

    public final PendingResult load(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.a(new _cls1(flag));
    }

    public final void reveal(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient.b(new _cls2(s, s));
    }

    public final PendingResult revealImmediate(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new _cls3(s, s));
    }

    public final void setSteps(GoogleApiClient googleapiclient, String s, int i)
    {
        googleapiclient.b(new _cls8(s, s, i));
    }

    public final PendingResult setStepsImmediate(GoogleApiClient googleapiclient, String s, int i)
    {
        return googleapiclient.b(new _cls9(s, s, i));
    }

    public final void unlock(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient.b(new _cls4(s, s));
    }

    public final PendingResult unlockImmediate(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new _cls5(s, s));
    }

    private class _cls6 extends UpdateImpl
    {
        private class UpdateImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
        {

            private final String xD;

            static String a(UpdateImpl updateimpl)
            {
                return updateimpl.xD;
            }

            public Result c(Status status)
            {
                return w(status);
            }

            public com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult w(Status status)
            {
                class _cls1
                    implements com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
                {

                    final UpdateImpl Pi;
                    final Status yG;

                    public String getAchievementId()
                    {
                        return UpdateImpl.a(Pi);
                    }

                    public Status getStatus()
                    {
                        return yG;
                    }

                    _cls1(Status status)
                    {
                        Pi = UpdateImpl.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls1(status);
            }

            public UpdateImpl(String s)
            {
                xD = s;
            }
        }


        final AchievementsImpl Pc;
        final String Pf;
        final int Pg;

        public volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        public void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.a(null, Pf, Pg);
        }

        _cls6(String s, String s1, int i)
        {
            Pc = AchievementsImpl.this;
            Pf = s1;
            Pg = i;
            super(s);
        }
    }


    private class _cls7 extends UpdateImpl
    {

        final AchievementsImpl Pc;
        final String Pf;
        final int Pg;

        public volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        public void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.a(this, Pf, Pg);
        }

        _cls7(String s, String s1, int i)
        {
            Pc = AchievementsImpl.this;
            Pf = s1;
            Pg = i;
            super(s);
        }
    }


    private class _cls1 extends LoadImpl
    {
        private class LoadImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
        {

            public Result c(Status status)
            {
                return v(status);
            }

            public com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult v(Status status)
            {
                class _cls1
                    implements com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
                {

                    final LoadImpl Ph;
                    final Status yG;

                    public AchievementBuffer getAchievements()
                    {
                        return new AchievementBuffer(DataHolder.af(14));
                    }

                    public Status getStatus()
                    {
                        return yG;
                    }

                    public void release()
                    {
                    }

                    _cls1(Status status)
                    {
                        Ph = LoadImpl.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls1(status);
            }

            private LoadImpl()
            {
            }

            LoadImpl(_cls1 _pcls1)
            {
                this();
            }
        }


        final boolean Pb;
        final AchievementsImpl Pc;

        public volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        public void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.c(this, Pb);
        }

        _cls1(boolean flag)
        {
            Pc = AchievementsImpl.this;
            Pb = flag;
            super(null);
        }
    }


    private class _cls2 extends UpdateImpl
    {

        final AchievementsImpl Pc;
        final String Pf;

        public volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        public void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.b(null, Pf);
        }

        _cls2(String s, String s1)
        {
            Pc = AchievementsImpl.this;
            Pf = s1;
            super(s);
        }
    }


    private class _cls3 extends UpdateImpl
    {

        final AchievementsImpl Pc;
        final String Pf;

        public volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        public void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.b(this, Pf);
        }

        _cls3(String s, String s1)
        {
            Pc = AchievementsImpl.this;
            Pf = s1;
            super(s);
        }
    }


    private class _cls8 extends UpdateImpl
    {

        final AchievementsImpl Pc;
        final String Pf;
        final int Pg;

        public volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        public void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.b(null, Pf, Pg);
        }

        _cls8(String s, String s1, int i)
        {
            Pc = AchievementsImpl.this;
            Pf = s1;
            Pg = i;
            super(s);
        }
    }


    private class _cls9 extends UpdateImpl
    {

        final AchievementsImpl Pc;
        final String Pf;
        final int Pg;

        public volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        public void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.b(this, Pf, Pg);
        }

        _cls9(String s, String s1, int i)
        {
            Pc = AchievementsImpl.this;
            Pf = s1;
            Pg = i;
            super(s);
        }
    }


    private class _cls4 extends UpdateImpl
    {

        final AchievementsImpl Pc;
        final String Pf;

        public volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        public void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.c(null, Pf);
        }

        _cls4(String s, String s1)
        {
            Pc = AchievementsImpl.this;
            Pf = s1;
            super(s);
        }
    }


    private class _cls5 extends UpdateImpl
    {

        final AchievementsImpl Pc;
        final String Pf;

        public volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        public void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.c(this, Pf);
        }

        _cls5(String s, String s1)
        {
            Pc = AchievementsImpl.this;
            Pf = s1;
            super(s);
        }
    }

}
