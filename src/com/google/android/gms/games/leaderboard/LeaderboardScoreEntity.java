// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.il;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            LeaderboardScore

public final class LeaderboardScoreEntity
    implements LeaderboardScore
{

    private final String SA;
    private final String SB;
    private final String SC;
    private final long Sr;
    private final String Ss;
    private final String St;
    private final long Su;
    private final long Sv;
    private final String Sw;
    private final Uri Sx;
    private final Uri Sy;
    private final PlayerEntity Sz;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardscore)
    {
        Sr = leaderboardscore.getRank();
        Ss = (String)hn.f(leaderboardscore.getDisplayRank());
        St = (String)hn.f(leaderboardscore.getDisplayScore());
        Su = leaderboardscore.getRawScore();
        Sv = leaderboardscore.getTimestampMillis();
        Sw = leaderboardscore.getScoreHolderDisplayName();
        Sx = leaderboardscore.getScoreHolderIconImageUri();
        Sy = leaderboardscore.getScoreHolderHiResImageUri();
        Player player = leaderboardscore.getScoreHolder();
        PlayerEntity playerentity;
        if (player == null)
        {
            playerentity = null;
        } else
        {
            playerentity = (PlayerEntity)player.freeze();
        }
        Sz = playerentity;
        SA = leaderboardscore.getScoreTag();
        SB = leaderboardscore.getScoreHolderIconImageUrl();
        SC = leaderboardscore.getScoreHolderHiResImageUrl();
    }

    static int a(LeaderboardScore leaderboardscore)
    {
        Object aobj[] = new Object[9];
        aobj[0] = Long.valueOf(leaderboardscore.getRank());
        aobj[1] = leaderboardscore.getDisplayRank();
        aobj[2] = Long.valueOf(leaderboardscore.getRawScore());
        aobj[3] = leaderboardscore.getDisplayScore();
        aobj[4] = Long.valueOf(leaderboardscore.getTimestampMillis());
        aobj[5] = leaderboardscore.getScoreHolderDisplayName();
        aobj[6] = leaderboardscore.getScoreHolderIconImageUri();
        aobj[7] = leaderboardscore.getScoreHolderHiResImageUri();
        aobj[8] = leaderboardscore.getScoreHolder();
        return hl.hashCode(aobj);
    }

    static boolean a(LeaderboardScore leaderboardscore, Object obj)
    {
        if (obj instanceof LeaderboardScore)
        {
            if (leaderboardscore == obj)
            {
                return true;
            }
            LeaderboardScore leaderboardscore1 = (LeaderboardScore)obj;
            if (hl.equal(Long.valueOf(leaderboardscore1.getRank()), Long.valueOf(leaderboardscore.getRank())) && hl.equal(leaderboardscore1.getDisplayRank(), leaderboardscore.getDisplayRank()) && hl.equal(Long.valueOf(leaderboardscore1.getRawScore()), Long.valueOf(leaderboardscore.getRawScore())) && hl.equal(leaderboardscore1.getDisplayScore(), leaderboardscore.getDisplayScore()) && hl.equal(Long.valueOf(leaderboardscore1.getTimestampMillis()), Long.valueOf(leaderboardscore.getTimestampMillis())) && hl.equal(leaderboardscore1.getScoreHolderDisplayName(), leaderboardscore.getScoreHolderDisplayName()) && hl.equal(leaderboardscore1.getScoreHolderIconImageUri(), leaderboardscore.getScoreHolderIconImageUri()) && hl.equal(leaderboardscore1.getScoreHolderHiResImageUri(), leaderboardscore.getScoreHolderHiResImageUri()) && hl.equal(leaderboardscore1.getScoreHolder(), leaderboardscore.getScoreHolder()) && hl.equal(leaderboardscore1.getScoreTag(), leaderboardscore.getScoreTag()))
            {
                return true;
            }
        }
        return false;
    }

    static String b(LeaderboardScore leaderboardscore)
    {
        com.google.android.gms.internal.hl.a a1 = hl.e(leaderboardscore).a("Rank", Long.valueOf(leaderboardscore.getRank())).a("DisplayRank", leaderboardscore.getDisplayRank()).a("Score", Long.valueOf(leaderboardscore.getRawScore())).a("DisplayScore", leaderboardscore.getDisplayScore()).a("Timestamp", Long.valueOf(leaderboardscore.getTimestampMillis())).a("DisplayName", leaderboardscore.getScoreHolderDisplayName()).a("IconImageUri", leaderboardscore.getScoreHolderIconImageUri()).a("IconImageUrl", leaderboardscore.getScoreHolderIconImageUrl()).a("HiResImageUri", leaderboardscore.getScoreHolderHiResImageUri()).a("HiResImageUrl", leaderboardscore.getScoreHolderHiResImageUrl());
        Player player;
        if (leaderboardscore.getScoreHolder() == null)
        {
            player = null;
        } else
        {
            player = leaderboardscore.getScoreHolder();
        }
        return a1.a("Player", player).a("ScoreTag", leaderboardscore.getScoreTag()).toString();
    }

    public final boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public final Object freeze()
    {
        return ix();
    }

    public final String getDisplayRank()
    {
        return Ss;
    }

    public final void getDisplayRank(CharArrayBuffer chararraybuffer)
    {
        il.b(Ss, chararraybuffer);
    }

    public final String getDisplayScore()
    {
        return St;
    }

    public final void getDisplayScore(CharArrayBuffer chararraybuffer)
    {
        il.b(St, chararraybuffer);
    }

    public final long getRank()
    {
        return Sr;
    }

    public final long getRawScore()
    {
        return Su;
    }

    public final Player getScoreHolder()
    {
        return Sz;
    }

    public final String getScoreHolderDisplayName()
    {
        if (Sz == null)
        {
            return Sw;
        } else
        {
            return Sz.getDisplayName();
        }
    }

    public final void getScoreHolderDisplayName(CharArrayBuffer chararraybuffer)
    {
        if (Sz == null)
        {
            il.b(Sw, chararraybuffer);
            return;
        } else
        {
            Sz.getDisplayName(chararraybuffer);
            return;
        }
    }

    public final Uri getScoreHolderHiResImageUri()
    {
        if (Sz == null)
        {
            return Sy;
        } else
        {
            return Sz.getHiResImageUri();
        }
    }

    public final String getScoreHolderHiResImageUrl()
    {
        if (Sz == null)
        {
            return SC;
        } else
        {
            return Sz.getHiResImageUrl();
        }
    }

    public final Uri getScoreHolderIconImageUri()
    {
        if (Sz == null)
        {
            return Sx;
        } else
        {
            return Sz.getIconImageUri();
        }
    }

    public final String getScoreHolderIconImageUrl()
    {
        if (Sz == null)
        {
            return SB;
        } else
        {
            return Sz.getIconImageUrl();
        }
    }

    public final String getScoreTag()
    {
        return SA;
    }

    public final long getTimestampMillis()
    {
        return Sv;
    }

    public final int hashCode()
    {
        return a(this);
    }

    public final boolean isDataValid()
    {
        return true;
    }

    public final LeaderboardScore ix()
    {
        return this;
    }

    public final String toString()
    {
        return b(this);
    }
}
