// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;

final class Ob extends b
    implements com.google.android.gms.games.leaderboard._11__08__88__BB__11__08__11_
{

    private final LeaderboardEntity Oa = null;
    private final LeaderboardScoreBuffer Ob;

    public final Leaderboard getLeaderboard()
    {
        return Oa;
    }

    public final LeaderboardScoreBuffer getScores()
    {
        return Ob;
    }

    (DataHolder dataholder, DataHolder dataholder1)
    {
        LeaderboardBuffer leaderboardbuffer;
        super(dataholder1);
        leaderboardbuffer = new LeaderboardBuffer(dataholder);
        if (leaderboardbuffer.getCount() <= 0) goto _L2; else goto _L1
_L1:
        Oa = (LeaderboardEntity)((Leaderboard)leaderboardbuffer.get(0)).freeze();
_L4:
        leaderboardbuffer.close();
        Ob = new LeaderboardScoreBuffer(dataholder1);
        return;
_L2:
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        leaderboardbuffer.close();
        throw exception;
    }
}
