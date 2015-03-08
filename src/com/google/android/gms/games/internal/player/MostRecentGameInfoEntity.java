// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;

// Referenced classes of package com.google.android.gms.games.internal.player:
//            MostRecentGameInfo, MostRecentGameInfoEntityCreator

public final class MostRecentGameInfoEntity
    implements SafeParcelable, MostRecentGameInfo
{

    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
    private final String RF;
    private final String RG;
    private final long RH;
    private final Uri RI;
    private final Uri RJ;
    private final Uri RK;
    private final int xJ;

    MostRecentGameInfoEntity(int i, String s, String s1, long l, Uri uri, Uri uri1, 
            Uri uri2)
    {
        xJ = i;
        RF = s;
        RG = s1;
        RH = l;
        RI = uri;
        RJ = uri1;
        RK = uri2;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo mostrecentgameinfo)
    {
        xJ = 2;
        RF = mostrecentgameinfo.ik();
        RG = mostrecentgameinfo.il();
        RH = mostrecentgameinfo.im();
        RI = mostrecentgameinfo.in();
        RJ = mostrecentgameinfo.io();
        RK = mostrecentgameinfo.ip();
    }

    static int a(MostRecentGameInfo mostrecentgameinfo)
    {
        Object aobj[] = new Object[6];
        aobj[0] = mostrecentgameinfo.ik();
        aobj[1] = mostrecentgameinfo.il();
        aobj[2] = Long.valueOf(mostrecentgameinfo.im());
        aobj[3] = mostrecentgameinfo.in();
        aobj[4] = mostrecentgameinfo.io();
        aobj[5] = mostrecentgameinfo.ip();
        return hl.hashCode(aobj);
    }

    static boolean a(MostRecentGameInfo mostrecentgameinfo, Object obj)
    {
        if (obj instanceof MostRecentGameInfo)
        {
            if (mostrecentgameinfo == obj)
            {
                return true;
            }
            MostRecentGameInfo mostrecentgameinfo1 = (MostRecentGameInfo)obj;
            if (hl.equal(mostrecentgameinfo1.ik(), mostrecentgameinfo.ik()) && hl.equal(mostrecentgameinfo1.il(), mostrecentgameinfo.il()) && hl.equal(Long.valueOf(mostrecentgameinfo1.im()), Long.valueOf(mostrecentgameinfo.im())) && hl.equal(mostrecentgameinfo1.in(), mostrecentgameinfo.in()) && hl.equal(mostrecentgameinfo1.io(), mostrecentgameinfo.io()) && hl.equal(mostrecentgameinfo1.ip(), mostrecentgameinfo.ip()))
            {
                return true;
            }
        }
        return false;
    }

    static String b(MostRecentGameInfo mostrecentgameinfo)
    {
        return hl.e(mostrecentgameinfo).a("GameId", mostrecentgameinfo.ik()).a("GameName", mostrecentgameinfo.il()).a("ActivityTimestampMillis", Long.valueOf(mostrecentgameinfo.im())).a("GameIconUri", mostrecentgameinfo.in()).a("GameHiResUri", mostrecentgameinfo.io()).a("GameFeaturedUri", mostrecentgameinfo.ip()).toString();
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public final Object freeze()
    {
        return iq();
    }

    public final int getVersionCode()
    {
        return xJ;
    }

    public final int hashCode()
    {
        return a(this);
    }

    public final String ik()
    {
        return RF;
    }

    public final String il()
    {
        return RG;
    }

    public final long im()
    {
        return RH;
    }

    public final Uri in()
    {
        return RI;
    }

    public final Uri io()
    {
        return RJ;
    }

    public final Uri ip()
    {
        return RK;
    }

    public final MostRecentGameInfo iq()
    {
        return this;
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
        MostRecentGameInfoEntityCreator.a(this, parcel, i);
    }

}
