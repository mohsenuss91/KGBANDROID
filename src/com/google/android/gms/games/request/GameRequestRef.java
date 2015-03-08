// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.games.request:
//            GameRequest, GameRequestEntity

public final class GameRequestRef extends d
    implements GameRequest
{

    private final int RD;

    public GameRequestRef(DataHolder dataholder, int i, int j)
    {
        super(dataholder, i);
        RD = j;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        return GameRequestEntity.a(this, obj);
    }

    public final GameRequest freeze()
    {
        return new GameRequestEntity(this);
    }

    public final volatile Object freeze()
    {
        return freeze();
    }

    public final long getCreationTimestamp()
    {
        return getLong("creation_timestamp");
    }

    public final byte[] getData()
    {
        return getByteArray("data");
    }

    public final long getExpirationTimestamp()
    {
        return getLong("expiration_timestamp");
    }

    public final Game getGame()
    {
        return new GameRef(DD, Ez);
    }

    public final int getRecipientStatus(String s)
    {
        for (int i = Ez; i < Ez + RD; i++)
        {
            int j = DD.ae(i);
            if (DD.c("recipient_external_player_id", i, j).equals(s))
            {
                return DD.b("recipient_status", i, j);
            }
        }

        return -1;
    }

    public final List getRecipients()
    {
        ArrayList arraylist = new ArrayList(RD);
        for (int i = 0; i < RD; i++)
        {
            arraylist.add(new PlayerRef(DD, i + Ez, "recipient_"));
        }

        return arraylist;
    }

    public final String getRequestId()
    {
        return getString("external_request_id");
    }

    public final Player getSender()
    {
        return new PlayerRef(DD, eQ(), "sender_");
    }

    public final int getStatus()
    {
        return getInteger("status");
    }

    public final int getType()
    {
        return getInteger("type");
    }

    public final int hashCode()
    {
        return GameRequestEntity.a(this);
    }

    public final boolean isConsumed(String s)
    {
        return getRecipientStatus(s) == 1;
    }

    public final String toString()
    {
        return GameRequestEntity.c(this);
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        ((GameRequestEntity)freeze()).writeToParcel(parcel, i);
    }
}
