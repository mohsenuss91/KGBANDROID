// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hn;

// Referenced classes of package com.google.android.gms.games:
//            PlayerLevelInfoCreator, PlayerLevel

public final class PlayerLevelInfo
    implements SafeParcelable
{

    public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
    private final long MZ;
    private final long Na;
    private final PlayerLevel Nb;
    private final PlayerLevel Nc;
    private final int xJ;

    PlayerLevelInfo(int i, long l, long l1, PlayerLevel playerlevel, PlayerLevel playerlevel1)
    {
        boolean flag;
        if (l != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hn.A(flag);
        hn.f(playerlevel);
        hn.f(playerlevel1);
        xJ = i;
        MZ = l;
        Na = l1;
        Nb = playerlevel;
        Nc = playerlevel1;
    }

    public PlayerLevelInfo(long l, long l1, PlayerLevel playerlevel, PlayerLevel playerlevel1)
    {
        this(1, l, l1, playerlevel, playerlevel1);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof PlayerLevelInfo)
        {
            if (obj == this)
            {
                return true;
            }
            PlayerLevelInfo playerlevelinfo = (PlayerLevelInfo)obj;
            if (hl.equal(Long.valueOf(MZ), Long.valueOf(playerlevelinfo.MZ)) && hl.equal(Long.valueOf(Na), Long.valueOf(playerlevelinfo.Na)) && hl.equal(Nb, playerlevelinfo.Nb) && hl.equal(Nc, playerlevelinfo.Nc))
            {
                return true;
            }
        }
        return false;
    }

    public final PlayerLevel getCurrentLevel()
    {
        return Nb;
    }

    public final long getCurrentXpTotal()
    {
        return MZ;
    }

    public final long getLastLevelUpTimestamp()
    {
        return Na;
    }

    public final PlayerLevel getNextLevel()
    {
        return Nc;
    }

    public final int getVersionCode()
    {
        return xJ;
    }

    public final int hashCode()
    {
        Object aobj[] = new Object[4];
        aobj[0] = Long.valueOf(MZ);
        aobj[1] = Long.valueOf(Na);
        aobj[2] = Nb;
        aobj[3] = Nc;
        return hl.hashCode(aobj);
    }

    public final boolean isMaxLevel()
    {
        return Nb.equals(Nc);
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        PlayerLevelInfoCreator.a(this, parcel, i);
    }

}
