// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            Leaderboard, LeaderboardEntity, LeaderboardVariantRef

public final class LeaderboardRef extends d
    implements Leaderboard
{

    private final int RD;
    private final Game Sp;

    LeaderboardRef(DataHolder dataholder, int i, int j)
    {
        super(dataholder, i);
        RD = j;
        Sp = new GameRef(dataholder, i);
    }

    public final boolean equals(Object obj)
    {
        return LeaderboardEntity.a(this, obj);
    }

    public final Object freeze()
    {
        return iu();
    }

    public final String getDisplayName()
    {
        return getString("name");
    }

    public final void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        a("name", chararraybuffer);
    }

    public final Game getGame()
    {
        return Sp;
    }

    public final Uri getIconImageUri()
    {
        return aw("board_icon_image_uri");
    }

    public final String getIconImageUrl()
    {
        return getString("board_icon_image_url");
    }

    public final String getLeaderboardId()
    {
        return getString("external_leaderboard_id");
    }

    public final int getScoreOrder()
    {
        return getInteger("score_order");
    }

    public final ArrayList getVariants()
    {
        ArrayList arraylist = new ArrayList(RD);
        for (int i = 0; i < RD; i++)
        {
            arraylist.add(new LeaderboardVariantRef(DD, i + Ez));
        }

        return arraylist;
    }

    public final int hashCode()
    {
        return LeaderboardEntity.a(this);
    }

    public final Leaderboard iu()
    {
        return new LeaderboardEntity(this);
    }

    public final String toString()
    {
        return LeaderboardEntity.b(this);
    }
}
