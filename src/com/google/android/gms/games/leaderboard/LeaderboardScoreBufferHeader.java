// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.os.Bundle;

public final class LeaderboardScoreBufferHeader
{

    private final Bundle HJ;

    public LeaderboardScoreBufferHeader(Bundle bundle)
    {
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        HJ = bundle;
    }

    public final Bundle iw()
    {
        return HJ;
    }
}
