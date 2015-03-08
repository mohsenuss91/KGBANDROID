// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.il;

// Referenced classes of package com.google.android.gms.games:
//            Player, PlayerEntityCreator, PlayerLevelInfo

public final class PlayerEntity extends GamesDowngradeableSafeParcel
    implements Player
{

    public static final android.os.Parcelable.Creator CREATOR = new PlayerEntityCreatorCompat();
    private final String HV;
    private final String Lk;
    private final String MA;
    private final String MP;
    private final long MQ;
    private final int MR;
    private final long MS;
    private final MostRecentGameInfoEntity MT;
    private final PlayerLevelInfo MU;
    private final boolean MV;
    private final Uri Mo;
    private final Uri Mp;
    private final String Mz;
    private final int xJ;

    PlayerEntity(int i, String s, String s1, Uri uri, Uri uri1, long l, 
            int j, long l1, String s2, String s3, String s4, MostRecentGameInfoEntity mostrecentgameinfoentity, 
            PlayerLevelInfo playerlevelinfo, boolean flag)
    {
        xJ = i;
        MP = s;
        Lk = s1;
        Mo = uri;
        Mz = s2;
        Mp = uri1;
        MA = s3;
        MQ = l;
        MR = j;
        MS = l1;
        HV = s4;
        MV = flag;
        MT = mostrecentgameinfoentity;
        MU = playerlevelinfo;
    }

    public PlayerEntity(Player player)
    {
        xJ = 10;
        MP = player.getPlayerId();
        Lk = player.getDisplayName();
        Mo = player.getIconImageUri();
        Mz = player.getIconImageUrl();
        Mp = player.getHiResImageUri();
        MA = player.getHiResImageUrl();
        MQ = player.getRetrievedTimestamp();
        MR = player.gN();
        MS = player.getLastPlayedWithTimestamp();
        HV = player.getTitle();
        MV = player.gO();
        MostRecentGameInfo mostrecentgameinfo = player.gP();
        MostRecentGameInfoEntity mostrecentgameinfoentity;
        boolean flag;
        if (mostrecentgameinfo == null)
        {
            mostrecentgameinfoentity = null;
        } else
        {
            mostrecentgameinfoentity = new MostRecentGameInfoEntity(mostrecentgameinfo);
        }
        MT = mostrecentgameinfoentity;
        MU = player.getLevelInfo();
        gy.c(MP);
        gy.c(Lk);
        if (MQ > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        gy.A(flag);
    }

    static int a(Player player)
    {
        Object aobj[] = new Object[7];
        aobj[0] = player.getPlayerId();
        aobj[1] = player.getDisplayName();
        aobj[2] = player.getIconImageUri();
        aobj[3] = player.getHiResImageUri();
        aobj[4] = Long.valueOf(player.getRetrievedTimestamp());
        aobj[5] = player.getTitle();
        aobj[6] = player.getLevelInfo();
        return hl.hashCode(aobj);
    }

    static boolean a(Player player, Object obj)
    {
        if (obj instanceof Player)
        {
            if (player == obj)
            {
                return true;
            }
            Player player1 = (Player)obj;
            if (hl.equal(player1.getPlayerId(), player.getPlayerId()) && hl.equal(player1.getDisplayName(), player.getDisplayName()) && hl.equal(player1.getIconImageUri(), player.getIconImageUri()) && hl.equal(player1.getHiResImageUri(), player.getHiResImageUri()) && hl.equal(Long.valueOf(player1.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && hl.equal(player1.getTitle(), player.getTitle()) && hl.equal(player1.getLevelInfo(), player.getLevelInfo()))
            {
                return true;
            }
        }
        return false;
    }

    static boolean aQ(String s)
    {
        return aA(s);
    }

    static String b(Player player)
    {
        return hl.e(player).a("PlayerId", player.getPlayerId()).a("DisplayName", player.getDisplayName()).a("IconImageUri", player.getIconImageUri()).a("IconImageUrl", player.getIconImageUrl()).a("HiResImageUri", player.getHiResImageUri()).a("HiResImageUrl", player.getHiResImageUrl()).a("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).a("Title", player.getTitle()).a("LevelInfo", player.getLevelInfo()).toString();
    }

    static boolean b(Integer integer)
    {
        return c(integer);
    }

    static Integer gM()
    {
        return fl();
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public final Player freeze()
    {
        return this;
    }

    public final volatile Object freeze()
    {
        return freeze();
    }

    public final int gN()
    {
        return MR;
    }

    public final boolean gO()
    {
        return MV;
    }

    public final MostRecentGameInfo gP()
    {
        return MT;
    }

    public final String getDisplayName()
    {
        return Lk;
    }

    public final void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        il.b(Lk, chararraybuffer);
    }

    public final Uri getHiResImageUri()
    {
        return Mp;
    }

    public final String getHiResImageUrl()
    {
        return MA;
    }

    public final Uri getIconImageUri()
    {
        return Mo;
    }

    public final String getIconImageUrl()
    {
        return Mz;
    }

    public final long getLastPlayedWithTimestamp()
    {
        return MS;
    }

    public final PlayerLevelInfo getLevelInfo()
    {
        return MU;
    }

    public final String getPlayerId()
    {
        return MP;
    }

    public final long getRetrievedTimestamp()
    {
        return MQ;
    }

    public final String getTitle()
    {
        return HV;
    }

    public final void getTitle(CharArrayBuffer chararraybuffer)
    {
        il.b(HV, chararraybuffer);
    }

    public final int getVersionCode()
    {
        return xJ;
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
        return a(this);
    }

    public final boolean isDataValid()
    {
        return true;
    }

    public final String toString()
    {
        return b(this);
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        if (!fm())
        {
            PlayerEntityCreator.a(this, parcel, i);
            return;
        }
        parcel.writeString(MP);
        parcel.writeString(Lk);
        String s;
        Uri uri;
        String s1;
        if (Mo == null)
        {
            s = null;
        } else
        {
            s = Mo.toString();
        }
        parcel.writeString(s);
        uri = Mp;
        s1 = null;
        if (uri != null)
        {
            s1 = Mp.toString();
        }
        parcel.writeString(s1);
        parcel.writeLong(MQ);
    }


    private class PlayerEntityCreatorCompat extends PlayerEntityCreator
    {

        public final PlayerEntity be(Parcel parcel)
        {
            if (PlayerEntity.b(PlayerEntity.gM()) || PlayerEntity.aQ(com/google/android/gms/games/PlayerEntity.getCanonicalName()))
            {
                return super.be(parcel);
            }
            String s = parcel.readString();
            String s1 = parcel.readString();
            String s2 = parcel.readString();
            String s3 = parcel.readString();
            Uri uri;
            Uri uri1;
            if (s2 == null)
            {
                uri = null;
            } else
            {
                uri = Uri.parse(s2);
            }
            if (s3 == null)
            {
                uri1 = null;
            } else
            {
                uri1 = Uri.parse(s3);
            }
            return new PlayerEntity(10, s, s1, uri, uri1, parcel.readLong(), -1, -1L, null, null, null, null, null, true);
        }

        public final Object createFromParcel(Parcel parcel)
        {
            return be(parcel);
        }

        PlayerEntityCreatorCompat()
        {
        }
    }

}
