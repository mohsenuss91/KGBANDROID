// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

final class OJ extends b
    implements com.google.android.gms.games.leaderboard.
{

    private final ScoreSubmissionData OJ;

    public final ScoreSubmissionData getScoreData()
    {
        return OJ;
    }

    public Q(DataHolder dataholder)
    {
        super(dataholder);
        OJ = new ScoreSubmissionData(dataholder);
        dataholder.close();
        return;
        Exception exception;
        exception;
        dataholder.close();
        throw exception;
    }
}
