// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.il;

// Referenced classes of package com.google.android.gms.games:
//            Game, GameEntityCreator

public final class GameEntity extends GamesDowngradeableSafeParcel
    implements Game
{

    public static final android.os.Parcelable.Creator CREATOR = new GameEntityCreatorCompat();
    private final String Lk;
    private final String MA;
    private final String MB;
    private final boolean MC;
    private final boolean MD;
    private final boolean ME;
    private final String Mk;
    private final String Ml;
    private final String Mm;
    private final String Mn;
    private final Uri Mo;
    private final Uri Mp;
    private final Uri Mq;
    private final boolean Mr;
    private final boolean Ms;
    private final String Mt;
    private final int Mu;
    private final int Mv;
    private final int Mw;
    private final boolean Mx;
    private final boolean My;
    private final String Mz;
    private final int xJ;
    private final String zM;

    GameEntity(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            Uri uri, Uri uri1, Uri uri2, boolean flag, boolean flag1, String s6, int j, 
            int k, int l, boolean flag2, boolean flag3, String s7, String s8, String s9, 
            boolean flag4, boolean flag5, boolean flag6)
    {
        xJ = i;
        zM = s;
        Lk = s1;
        Mk = s2;
        Ml = s3;
        Mm = s4;
        Mn = s5;
        Mo = uri;
        Mz = s7;
        Mp = uri1;
        MA = s8;
        Mq = uri2;
        MB = s9;
        Mr = flag;
        Ms = flag1;
        Mt = s6;
        Mu = j;
        Mv = k;
        Mw = l;
        Mx = flag2;
        My = flag3;
        MC = flag4;
        MD = flag5;
        ME = flag6;
    }

    public GameEntity(Game game)
    {
        xJ = 4;
        zM = game.getApplicationId();
        Mk = game.getPrimaryCategory();
        Ml = game.getSecondaryCategory();
        Mm = game.getDescription();
        Mn = game.getDeveloperName();
        Lk = game.getDisplayName();
        Mo = game.getIconImageUri();
        Mz = game.getIconImageUrl();
        Mp = game.getHiResImageUri();
        MA = game.getHiResImageUrl();
        Mq = game.getFeaturedImageUri();
        MB = game.getFeaturedImageUrl();
        Mr = game.gH();
        Ms = game.gJ();
        Mt = game.gK();
        Mu = game.gL();
        Mv = game.getAchievementTotalCount();
        Mw = game.getLeaderboardCount();
        Mx = game.isRealTimeMultiplayerEnabled();
        My = game.isTurnBasedMultiplayerEnabled();
        MC = game.isMuted();
        MD = game.gI();
        ME = game.areSnapshotsEnabled();
    }

    static int a(Game game)
    {
        Object aobj[] = new Object[20];
        aobj[0] = game.getApplicationId();
        aobj[1] = game.getDisplayName();
        aobj[2] = game.getPrimaryCategory();
        aobj[3] = game.getSecondaryCategory();
        aobj[4] = game.getDescription();
        aobj[5] = game.getDeveloperName();
        aobj[6] = game.getIconImageUri();
        aobj[7] = game.getHiResImageUri();
        aobj[8] = game.getFeaturedImageUri();
        aobj[9] = Boolean.valueOf(game.gH());
        aobj[10] = Boolean.valueOf(game.gJ());
        aobj[11] = game.gK();
        aobj[12] = Integer.valueOf(game.gL());
        aobj[13] = Integer.valueOf(game.getAchievementTotalCount());
        aobj[14] = Integer.valueOf(game.getLeaderboardCount());
        aobj[15] = Boolean.valueOf(game.isRealTimeMultiplayerEnabled());
        aobj[16] = Boolean.valueOf(game.isTurnBasedMultiplayerEnabled());
        aobj[17] = Boolean.valueOf(game.isMuted());
        aobj[18] = Boolean.valueOf(game.gI());
        aobj[19] = Boolean.valueOf(game.areSnapshotsEnabled());
        return hl.hashCode(aobj);
    }

    static boolean a(Game game, Object obj)
    {
        if (obj instanceof Game)
        {
            if (game == obj)
            {
                return true;
            }
            Game game1 = (Game)obj;
            if (hl.equal(game1.getApplicationId(), game.getApplicationId()) && hl.equal(game1.getDisplayName(), game.getDisplayName()) && hl.equal(game1.getPrimaryCategory(), game.getPrimaryCategory()) && hl.equal(game1.getSecondaryCategory(), game.getSecondaryCategory()) && hl.equal(game1.getDescription(), game.getDescription()) && hl.equal(game1.getDeveloperName(), game.getDeveloperName()) && hl.equal(game1.getIconImageUri(), game.getIconImageUri()) && hl.equal(game1.getHiResImageUri(), game.getHiResImageUri()) && hl.equal(game1.getFeaturedImageUri(), game.getFeaturedImageUri()) && hl.equal(Boolean.valueOf(game1.gH()), Boolean.valueOf(game.gH())) && hl.equal(Boolean.valueOf(game1.gJ()), Boolean.valueOf(game.gJ())) && hl.equal(game1.gK(), game.gK()) && hl.equal(Integer.valueOf(game1.gL()), Integer.valueOf(game.gL())) && hl.equal(Integer.valueOf(game1.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && hl.equal(Integer.valueOf(game1.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && hl.equal(Boolean.valueOf(game1.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled())))
            {
                Boolean boolean1 = Boolean.valueOf(game1.isTurnBasedMultiplayerEnabled());
                boolean flag;
                if (game.isTurnBasedMultiplayerEnabled() && hl.equal(Boolean.valueOf(game1.isMuted()), Boolean.valueOf(game.isMuted())) && hl.equal(Boolean.valueOf(game1.gI()), Boolean.valueOf(game.gI())))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (hl.equal(boolean1, Boolean.valueOf(flag)) && hl.equal(Boolean.valueOf(game1.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())))
                {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean aQ(String s)
    {
        return aA(s);
    }

    static String b(Game game)
    {
        return hl.e(game).a("ApplicationId", game.getApplicationId()).a("DisplayName", game.getDisplayName()).a("PrimaryCategory", game.getPrimaryCategory()).a("SecondaryCategory", game.getSecondaryCategory()).a("Description", game.getDescription()).a("DeveloperName", game.getDeveloperName()).a("IconImageUri", game.getIconImageUri()).a("IconImageUrl", game.getIconImageUrl()).a("HiResImageUri", game.getHiResImageUri()).a("HiResImageUrl", game.getHiResImageUrl()).a("FeaturedImageUri", game.getFeaturedImageUri()).a("FeaturedImageUrl", game.getFeaturedImageUrl()).a("PlayEnabledGame", Boolean.valueOf(game.gH())).a("InstanceInstalled", Boolean.valueOf(game.gJ())).a("InstancePackageName", game.gK()).a("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).a("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).a("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).toString();
    }

    static boolean b(Integer integer)
    {
        return c(integer);
    }

    static Integer gM()
    {
        return fl();
    }

    public final boolean areSnapshotsEnabled()
    {
        return ME;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public final Game freeze()
    {
        return this;
    }

    public final volatile Object freeze()
    {
        return freeze();
    }

    public final boolean gH()
    {
        return Mr;
    }

    public final boolean gI()
    {
        return MD;
    }

    public final boolean gJ()
    {
        return Ms;
    }

    public final String gK()
    {
        return Mt;
    }

    public final int gL()
    {
        return Mu;
    }

    public final int getAchievementTotalCount()
    {
        return Mv;
    }

    public final String getApplicationId()
    {
        return zM;
    }

    public final String getDescription()
    {
        return Mm;
    }

    public final void getDescription(CharArrayBuffer chararraybuffer)
    {
        il.b(Mm, chararraybuffer);
    }

    public final String getDeveloperName()
    {
        return Mn;
    }

    public final void getDeveloperName(CharArrayBuffer chararraybuffer)
    {
        il.b(Mn, chararraybuffer);
    }

    public final String getDisplayName()
    {
        return Lk;
    }

    public final void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        il.b(Lk, chararraybuffer);
    }

    public final Uri getFeaturedImageUri()
    {
        return Mq;
    }

    public final String getFeaturedImageUrl()
    {
        return MB;
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

    public final int getLeaderboardCount()
    {
        return Mw;
    }

    public final String getPrimaryCategory()
    {
        return Mk;
    }

    public final String getSecondaryCategory()
    {
        return Ml;
    }

    public final int getVersionCode()
    {
        return xJ;
    }

    public final int hashCode()
    {
        return a(this);
    }

    public final boolean isDataValid()
    {
        return true;
    }

    public final boolean isMuted()
    {
        return MC;
    }

    public final boolean isRealTimeMultiplayerEnabled()
    {
        return Mx;
    }

    public final boolean isTurnBasedMultiplayerEnabled()
    {
        return My;
    }

    public final String toString()
    {
        return b(this);
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        int j = 1;
        if (!fm())
        {
            GameEntityCreator.a(this, parcel, i);
            return;
        }
        parcel.writeString(zM);
        parcel.writeString(Lk);
        parcel.writeString(Mk);
        parcel.writeString(Ml);
        parcel.writeString(Mm);
        parcel.writeString(Mn);
        String s;
        String s1;
        Uri uri;
        String s2;
        int k;
        if (Mo == null)
        {
            s = null;
        } else
        {
            s = Mo.toString();
        }
        parcel.writeString(s);
        if (Mp == null)
        {
            s1 = null;
        } else
        {
            s1 = Mp.toString();
        }
        parcel.writeString(s1);
        uri = Mq;
        s2 = null;
        if (uri != null)
        {
            s2 = Mq.toString();
        }
        parcel.writeString(s2);
        if (Mr)
        {
            k = j;
        } else
        {
            k = 0;
        }
        parcel.writeInt(k);
        if (!Ms)
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeString(Mt);
        parcel.writeInt(Mu);
        parcel.writeInt(Mv);
        parcel.writeInt(Mw);
    }


    private class GameEntityCreatorCompat extends GameEntityCreator
    {

        public final GameEntity bd(Parcel parcel)
        {
            if (GameEntity.b(GameEntity.gM()) || GameEntity.aQ(com/google/android/gms/games/GameEntity.getCanonicalName()))
            {
                return super.bd(parcel);
            }
            String s = parcel.readString();
            String s1 = parcel.readString();
            String s2 = parcel.readString();
            String s3 = parcel.readString();
            String s4 = parcel.readString();
            String s5 = parcel.readString();
            String s6 = parcel.readString();
            Uri uri;
            String s7;
            Uri uri1;
            String s8;
            Uri uri2;
            boolean flag;
            boolean flag1;
            if (s6 == null)
            {
                uri = null;
            } else
            {
                uri = Uri.parse(s6);
            }
            s7 = parcel.readString();
            if (s7 == null)
            {
                uri1 = null;
            } else
            {
                uri1 = Uri.parse(s7);
            }
            s8 = parcel.readString();
            if (s8 == null)
            {
                uri2 = null;
            } else
            {
                uri2 = Uri.parse(s8);
            }
            if (parcel.readInt() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (parcel.readInt() > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            return new GameEntity(4, s, s1, s2, s3, s4, s5, uri, uri1, uri2, flag, flag1, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false);
        }

        public final Object createFromParcel(Parcel parcel)
        {
            return bd(parcel);
        }

        GameEntityCreatorCompat()
        {
        }
    }

}
