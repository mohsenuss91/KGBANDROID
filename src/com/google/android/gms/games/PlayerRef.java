// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

// Referenced classes of package com.google.android.gms.games:
//            Player, PlayerLevel, PlayerLevelInfo, PlayerEntity

public final class PlayerRef extends d
    implements Player
{

    private final PlayerLevelInfo MU;
    private final PlayerColumnNames Nd;
    private final MostRecentGameInfoRef Ne;

    public PlayerRef(DataHolder dataholder, int i)
    {
        this(dataholder, i, null);
    }

    public PlayerRef(DataHolder dataholder, int i, String s)
    {
        super(dataholder, i);
        Nd = new PlayerColumnNames(s);
        Ne = new MostRecentGameInfoRef(dataholder, i, Nd);
        if (gQ())
        {
            int j = getInteger(Nd.RV);
            int k = getInteger(Nd.RY);
            PlayerLevel playerlevel = new PlayerLevel(j, getLong(Nd.RW), getLong(Nd.RX));
            PlayerLevel playerlevel1;
            if (j != k)
            {
                playerlevel1 = new PlayerLevel(k, getLong(Nd.RX), getLong(Nd.RZ));
            } else
            {
                playerlevel1 = playerlevel;
            }
            MU = new PlayerLevelInfo(getLong(Nd.RU), getLong(Nd.Sa), playerlevel, playerlevel1);
            return;
        } else
        {
            MU = null;
            return;
        }
    }

    private boolean gQ()
    {
        while (ax(Nd.RU) || getLong(Nd.RU) == -1L) 
        {
            return false;
        }
        return true;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        return PlayerEntity.a(this, obj);
    }

    public final Player freeze()
    {
        return new PlayerEntity(this);
    }

    public final volatile Object freeze()
    {
        return freeze();
    }

    public final int gN()
    {
        return getInteger(Nd.RS);
    }

    public final boolean gO()
    {
        return getBoolean(Nd.Sc);
    }

    public final MostRecentGameInfo gP()
    {
        if (ax(Nd.Sd))
        {
            return null;
        } else
        {
            return Ne;
        }
    }

    public final String getDisplayName()
    {
        return getString(Nd.RM);
    }

    public final void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        a(Nd.RM, chararraybuffer);
    }

    public final Uri getHiResImageUri()
    {
        return aw(Nd.RP);
    }

    public final String getHiResImageUrl()
    {
        return getString(Nd.RQ);
    }

    public final Uri getIconImageUri()
    {
        return aw(Nd.RN);
    }

    public final String getIconImageUrl()
    {
        return getString(Nd.RO);
    }

    public final long getLastPlayedWithTimestamp()
    {
        if (!av(Nd.RT) || ax(Nd.RT))
        {
            return -1L;
        } else
        {
            return getLong(Nd.RT);
        }
    }

    public final PlayerLevelInfo getLevelInfo()
    {
        return MU;
    }

    public final String getPlayerId()
    {
        return getString(Nd.RL);
    }

    public final long getRetrievedTimestamp()
    {
        return getLong(Nd.RR);
    }

    public final String getTitle()
    {
        return getString(Nd.Sb);
    }

    public final void getTitle(CharArrayBuffer chararraybuffer)
    {
        a(Nd.Sb, chararraybuffer);
    }

    public final boolean hasHiResImage()
    {
        return getHiResImageUri() != null;
    }

    public final boolean hasIconImage()
    {
        return getIconImageUri() != null;
    }

    public final int hashCode()
    {
        return PlayerEntity.a(this);
    }

    public final String toString()
    {
        return PlayerEntity.b(this);
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        ((PlayerEntity)freeze()).writeToParcel(parcel, i);
    }
}
