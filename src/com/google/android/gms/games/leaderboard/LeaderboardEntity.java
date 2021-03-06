// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.il;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            Leaderboard, LeaderboardVariant, LeaderboardVariantEntity

public final class LeaderboardEntity
    implements Leaderboard
{

    private final String Lk;
    private final Uri Mo;
    private final String Mz;
    private final String Sm;
    private final int Sn;
    private final ArrayList So;
    private final Game Sp;

    public LeaderboardEntity(Leaderboard leaderboard)
    {
        Sm = leaderboard.getLeaderboardId();
        Lk = leaderboard.getDisplayName();
        Mo = leaderboard.getIconImageUri();
        Mz = leaderboard.getIconImageUrl();
        Sn = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        Object obj;
        ArrayList arraylist;
        int i;
        if (game == null)
        {
            obj = null;
        } else
        {
            obj = new GameEntity(game);
        }
        Sp = ((Game) (obj));
        arraylist = leaderboard.getVariants();
        i = arraylist.size();
        So = new ArrayList(i);
        for (int j = 0; j < i; j++)
        {
            So.add((LeaderboardVariantEntity)(LeaderboardVariantEntity)((LeaderboardVariant)arraylist.get(j)).freeze());
        }

    }

    static int a(Leaderboard leaderboard)
    {
        Object aobj[] = new Object[5];
        aobj[0] = leaderboard.getLeaderboardId();
        aobj[1] = leaderboard.getDisplayName();
        aobj[2] = leaderboard.getIconImageUri();
        aobj[3] = Integer.valueOf(leaderboard.getScoreOrder());
        aobj[4] = leaderboard.getVariants();
        return hl.hashCode(aobj);
    }

    static boolean a(Leaderboard leaderboard, Object obj)
    {
        if (obj instanceof Leaderboard)
        {
            if (leaderboard == obj)
            {
                return true;
            }
            Leaderboard leaderboard1 = (Leaderboard)obj;
            if (hl.equal(leaderboard1.getLeaderboardId(), leaderboard.getLeaderboardId()) && hl.equal(leaderboard1.getDisplayName(), leaderboard.getDisplayName()) && hl.equal(leaderboard1.getIconImageUri(), leaderboard.getIconImageUri()) && hl.equal(Integer.valueOf(leaderboard1.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && hl.equal(leaderboard1.getVariants(), leaderboard.getVariants()))
            {
                return true;
            }
        }
        return false;
    }

    static String b(Leaderboard leaderboard)
    {
        return hl.e(leaderboard).a("LeaderboardId", leaderboard.getLeaderboardId()).a("DisplayName", leaderboard.getDisplayName()).a("IconImageUri", leaderboard.getIconImageUri()).a("IconImageUrl", leaderboard.getIconImageUrl()).a("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).a("Variants", leaderboard.getVariants()).toString();
    }

    public final boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public final Object freeze()
    {
        return iu();
    }

    public final String getDisplayName()
    {
        return Lk;
    }

    public final void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        il.b(Lk, chararraybuffer);
    }

    public final Game getGame()
    {
        return Sp;
    }

    public final Uri getIconImageUri()
    {
        return Mo;
    }

    public final String getIconImageUrl()
    {
        return Mz;
    }

    public final String getLeaderboardId()
    {
        return Sm;
    }

    public final int getScoreOrder()
    {
        return Sn;
    }

    public final ArrayList getVariants()
    {
        return new ArrayList(So);
    }

    public final int hashCode()
    {
        return a(this);
    }

    public final boolean isDataValid()
    {
        return true;
    }

    public final Leaderboard iu()
    {
        return this;
    }

    public final String toString()
    {
        return b(this);
    }
}
