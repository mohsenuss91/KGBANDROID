// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl
    implements Players
{

    public PlayersImpl()
    {
    }

    public final Player getCurrentPlayer(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).gW();
    }

    public final String getCurrentPlayerId(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).gV();
    }

    public final Intent getPlayerSearchIntent(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).hg();
    }

    public final PendingResult loadConnectedPlayers(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.a(new _cls9(flag));
    }

    public final PendingResult loadInvitablePlayers(GoogleApiClient googleapiclient, int i, boolean flag)
    {
        return googleapiclient.a(new _cls3(i, flag));
    }

    public final PendingResult loadMoreInvitablePlayers(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.a(new _cls4(i));
    }

    public final PendingResult loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.a(new _cls6(i));
    }

    public final PendingResult loadPlayer(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.a(new _cls1(s));
    }

    public final PendingResult loadRecentlyPlayedWithPlayers(GoogleApiClient googleapiclient, int i, boolean flag)
    {
        return googleapiclient.a(new _cls5(i, flag));
    }

    private class _cls9 extends LoadPlayersImpl
    {
        private class LoadPlayersImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
        {

            public com.google.android.gms.games.Players.LoadPlayersResult P(Status status)
            {
                class _cls1
                    implements com.google.android.gms.games.Players.LoadPlayersResult
                {

                    final LoadPlayersImpl Qh;
                    final Status yG;

                    public PlayerBuffer getPlayers()
                    {
                        return new PlayerBuffer(DataHolder.af(14));
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
                        Qh = LoadPlayersImpl.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls1(status);
            }

            public Result c(Status status)
            {
                return P(status);
            }

            private LoadPlayersImpl()
            {
            }

            LoadPlayersImpl(_cls1 _pcls1)
            {
                this();
            }
        }


        final boolean Pb;
        final PlayersImpl Qa;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.a(this, Pb);
        }

        _cls9(boolean flag)
        {
            Qa = PlayersImpl.this;
            Pb = flag;
            super(null);
        }
    }


    private class _cls3 extends LoadPlayersImpl
    {

        final boolean Pb;
        final int Ps;
        final PlayersImpl Qa;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.a(this, Ps, false, Pb);
        }

        _cls3(int i, boolean flag)
        {
            Qa = PlayersImpl.this;
            Ps = i;
            Pb = flag;
            super(null);
        }
    }


    private class _cls4 extends LoadPlayersImpl
    {

        final int Ps;
        final PlayersImpl Qa;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.a(this, Ps, true, false);
        }

        _cls4(int i)
        {
            Qa = PlayersImpl.this;
            Ps = i;
            super(null);
        }
    }


    private class _cls6 extends LoadPlayersImpl
    {

        final int Ps;
        final PlayersImpl Qa;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.a(this, "played_with", Ps, true, false);
        }

        _cls6(int i)
        {
            Qa = PlayersImpl.this;
            Ps = i;
            super(null);
        }
    }


    private class _cls1 extends LoadPlayersImpl
    {

        final String Pd;
        final PlayersImpl Qa;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.a(this, Pd);
        }

        _cls1(String s)
        {
            Qa = PlayersImpl.this;
            Pd = s;
            super(null);
        }
    }


    private class _cls5 extends LoadPlayersImpl
    {

        final boolean Pb;
        final int Ps;
        final PlayersImpl Qa;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.a(this, "played_with", Ps, false, Pb);
        }

        _cls5(int i, boolean flag)
        {
            Qa = PlayersImpl.this;
            Ps = i;
            Pb = flag;
            super(null);
        }
    }

}
