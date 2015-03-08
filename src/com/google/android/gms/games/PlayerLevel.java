// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hn;

// Referenced classes of package com.google.android.gms.games:
//            PlayerLevelCreator

public final class PlayerLevel
    implements SafeParcelable
{

    public static final PlayerLevelCreator CREATOR = new PlayerLevelCreator();
    private final int MW;
    private final long MX;
    private final long MY;
    private final int xJ;

    PlayerLevel(int i, int j, long l, long l1)
    {
        boolean flag = true;
        super();
        boolean flag1;
        if (l >= 0L)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        hn.a(flag1, "Min XP must be positive!");
        if (l1 <= l)
        {
            flag = false;
        }
        hn.a(flag, "Max XP must be more than min XP!");
        xJ = i;
        MW = j;
        MX = l;
        MY = l1;
    }

    public PlayerLevel(int i, long l, long l1)
    {
        this(1, i, l, l1);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof PlayerLevel)
        {
            if (this == obj)
            {
                return true;
            }
            PlayerLevel playerlevel = (PlayerLevel)obj;
            if (hl.equal(Integer.valueOf(playerlevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && hl.equal(Long.valueOf(playerlevel.getMinXp()), Long.valueOf(getMinXp())) && hl.equal(Long.valueOf(playerlevel.getMaxXp()), Long.valueOf(getMaxXp())))
            {
                return true;
            }
        }
        return false;
    }

    public final int getLevelNumber()
    {
        return MW;
    }

    public final long getMaxXp()
    {
        return MY;
    }

    public final long getMinXp()
    {
        return MX;
    }

    public final int getVersionCode()
    {
        return xJ;
    }

    public final int hashCode()
    {
        Object aobj[] = new Object[3];
        aobj[0] = Integer.valueOf(MW);
        aobj[1] = Long.valueOf(MX);
        aobj[2] = Long.valueOf(MY);
        return hl.hashCode(aobj);
    }

    public final String toString()
    {
        return hl.e(this).a("LevelNumber", Integer.valueOf(getLevelNumber())).a("MinXp", Long.valueOf(getMinXp())).a("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        PlayerLevelCreator.a(this, parcel, i);
    }

}
