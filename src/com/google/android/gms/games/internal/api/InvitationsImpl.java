// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl
    implements Invitations
{

    public InvitationsImpl()
    {
    }

    public final Intent getInvitationInboxIntent(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).hb();
    }

    public final PendingResult loadInvitations(GoogleApiClient googleapiclient)
    {
        return loadInvitations(googleapiclient, 0);
    }

    public final PendingResult loadInvitations(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.a(new _cls1(i));
    }

    public final void registerInvitationListener(GoogleApiClient googleapiclient, OnInvitationReceivedListener oninvitationreceivedlistener)
    {
        Games.c(googleapiclient).a(oninvitationreceivedlistener);
    }

    public final void unregisterInvitationListener(GoogleApiClient googleapiclient)
    {
        Games.c(googleapiclient).hc();
    }

    private class _cls1 extends LoadInvitationsImpl
    {
        private class LoadInvitationsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
        {

            public com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult F(Status status)
            {
                class _cls1
                    implements com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
                {

                    final LoadInvitationsImpl PE;
                    final Status yG;

                    public InvitationBuffer getInvitations()
                    {
                        return new InvitationBuffer(DataHolder.af(14));
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
                        PE = LoadInvitationsImpl.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls1(status);
            }

            public Result c(Status status)
            {
                return F(status);
            }

            private LoadInvitationsImpl()
            {
            }

            LoadInvitationsImpl(_cls1 _pcls1)
            {
                this();
            }
        }


        final int PB;
        final InvitationsImpl PC;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.c(this, PB);
        }

        _cls1(int i)
        {
            PC = InvitationsImpl.this;
            PB = i;
            super(null);
        }
    }

}
