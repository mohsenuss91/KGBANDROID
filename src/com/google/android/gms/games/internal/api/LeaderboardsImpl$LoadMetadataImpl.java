// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class <init> extends com.google.android.gms.games.MetadataImpl
{

    public com.google.android.gms.games.leaderboard.sult G(Status status)
    {
        class _cls1
            implements com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult
        {

            final LeaderboardsImpl.LoadMetadataImpl PO;
            final Status yG;

            public LeaderboardBuffer getLeaderboards()
            {
                return new LeaderboardBuffer(DataHolder.af(14));
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
                PO = LeaderboardsImpl.LoadMetadataImpl.this;
                yG = status;
                super();
            }
        }

        return new _cls1(status);
    }

    public Result c(Status status)
    {
        return G(status);
    }

    private ult()
    {
    }

    ult(ult ult)
    {
        this();
    }
}
