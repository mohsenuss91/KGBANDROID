// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

// Referenced classes of package com.google.android.gms.games.internal.player:
//            MostRecentGameInfo, MostRecentGameInfoEntity, PlayerColumnNames

public final class MostRecentGameInfoRef extends d
    implements MostRecentGameInfo
{

    private final PlayerColumnNames Nd;

    public MostRecentGameInfoRef(DataHolder dataholder, int i, PlayerColumnNames playercolumnnames)
    {
        super(dataholder, i);
        Nd = playercolumnnames;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        return MostRecentGameInfoEntity.a(this, obj);
    }

    public final Object freeze()
    {
        return iq();
    }

    public final int hashCode()
    {
        return MostRecentGameInfoEntity.a(this);
    }

    public final String ik()
    {
        return getString(Nd.Sd);
    }

    public final String il()
    {
        return getString(Nd.Se);
    }

    public final long im()
    {
        return getLong(Nd.Sf);
    }

    public final Uri in()
    {
        return aw(Nd.Sg);
    }

    public final Uri io()
    {
        return aw(Nd.Sh);
    }

    public final Uri ip()
    {
        return aw(Nd.Si);
    }

    public final MostRecentGameInfo iq()
    {
        return new MostRecentGameInfoEntity(this);
    }

    public final String toString()
    {
        return MostRecentGameInfoEntity.b(this);
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        ((MostRecentGameInfoEntity)iq()).writeToParcel(parcel, i);
    }
}
