// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public abstract class _cls1 extends com.google.android.gms.games.mitScoreImpl
{

    public com.google.android.gms.games.leaderboard. J(Status status)
    {
        class _cls1
            implements com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
        {

            final LeaderboardsImpl.SubmitScoreImpl PR;
            final Status yG;

            public ScoreSubmissionData getScoreData()
            {
                return new ScoreSubmissionData(DataHolder.af(14));
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
                PR = LeaderboardsImpl.SubmitScoreImpl.this;
                yG = status;
                super();
            }
        }

        return new _cls1(status);
    }

    public Result c(Status status)
    {
        return J(status);
    }

    protected _cls1()
    {
    }
}
