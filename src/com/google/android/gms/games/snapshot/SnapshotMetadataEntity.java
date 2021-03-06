// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.il;

// Referenced classes of package com.google.android.gms.games.snapshot:
//            SnapshotMetadata, SnapshotMetadataEntityCreator

public final class SnapshotMetadataEntity
    implements SafeParcelable, SnapshotMetadata
{

    public static final SnapshotMetadataEntityCreator CREATOR = new SnapshotMetadataEntityCreator();
    private final String HV;
    private final String Mm;
    private final String NH;
    private final GameEntity Rq;
    private final Uri Ue;
    private final PlayerEntity Ui;
    private final String Uj;
    private final long Uk;
    private final long Ul;
    private final float Um;
    private final String Un;
    private final int xJ;

    SnapshotMetadataEntity(int i, GameEntity gameentity, PlayerEntity playerentity, String s, Uri uri, String s1, String s2, 
            String s3, long l, long l1, float f, String s4)
    {
        xJ = i;
        Rq = gameentity;
        Ui = playerentity;
        NH = s;
        Ue = uri;
        Uj = s1;
        Um = f;
        HV = s2;
        Mm = s3;
        Uk = l;
        Ul = l1;
        Un = s4;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotmetadata)
    {
        xJ = 3;
        Rq = new GameEntity(snapshotmetadata.getGame());
        Ui = new PlayerEntity(snapshotmetadata.getOwner());
        NH = snapshotmetadata.getSnapshotId();
        Ue = snapshotmetadata.getCoverImageUri();
        Uj = snapshotmetadata.getCoverImageUrl();
        Um = snapshotmetadata.getCoverImageAspectRatio();
        HV = snapshotmetadata.getTitle();
        Mm = snapshotmetadata.getDescription();
        Uk = snapshotmetadata.getLastModifiedTimestamp();
        Ul = snapshotmetadata.getPlayedTime();
        Un = snapshotmetadata.getUniqueName();
    }

    static int a(SnapshotMetadata snapshotmetadata)
    {
        Object aobj[] = new Object[10];
        aobj[0] = snapshotmetadata.getGame();
        aobj[1] = snapshotmetadata.getOwner();
        aobj[2] = snapshotmetadata.getSnapshotId();
        aobj[3] = snapshotmetadata.getCoverImageUri();
        aobj[4] = Float.valueOf(snapshotmetadata.getCoverImageAspectRatio());
        aobj[5] = snapshotmetadata.getTitle();
        aobj[6] = snapshotmetadata.getDescription();
        aobj[7] = Long.valueOf(snapshotmetadata.getLastModifiedTimestamp());
        aobj[8] = Long.valueOf(snapshotmetadata.getPlayedTime());
        aobj[9] = snapshotmetadata.getUniqueName();
        return hl.hashCode(aobj);
    }

    static boolean a(SnapshotMetadata snapshotmetadata, Object obj)
    {
        if (obj instanceof SnapshotMetadata)
        {
            if (snapshotmetadata == obj)
            {
                return true;
            }
            SnapshotMetadata snapshotmetadata1 = (SnapshotMetadata)obj;
            if (hl.equal(snapshotmetadata1.getGame(), snapshotmetadata.getGame()) && hl.equal(snapshotmetadata1.getOwner(), snapshotmetadata.getOwner()) && hl.equal(snapshotmetadata1.getSnapshotId(), snapshotmetadata.getSnapshotId()) && hl.equal(snapshotmetadata1.getCoverImageUri(), snapshotmetadata.getCoverImageUri()) && hl.equal(Float.valueOf(snapshotmetadata1.getCoverImageAspectRatio()), Float.valueOf(snapshotmetadata.getCoverImageAspectRatio())) && hl.equal(snapshotmetadata1.getTitle(), snapshotmetadata.getTitle()) && hl.equal(snapshotmetadata1.getDescription(), snapshotmetadata.getDescription()) && hl.equal(Long.valueOf(snapshotmetadata1.getLastModifiedTimestamp()), Long.valueOf(snapshotmetadata.getLastModifiedTimestamp())) && hl.equal(Long.valueOf(snapshotmetadata1.getPlayedTime()), Long.valueOf(snapshotmetadata.getPlayedTime())) && hl.equal(snapshotmetadata1.getUniqueName(), snapshotmetadata.getUniqueName()))
            {
                return true;
            }
        }
        return false;
    }

    static String b(SnapshotMetadata snapshotmetadata)
    {
        return hl.e(snapshotmetadata).a("Game", snapshotmetadata.getGame()).a("Owner", snapshotmetadata.getOwner()).a("SnapshotId", snapshotmetadata.getSnapshotId()).a("CoverImageUri", snapshotmetadata.getCoverImageUri()).a("CoverImageUrl", snapshotmetadata.getCoverImageUrl()).a("CoverImageAspectRatio", Float.valueOf(snapshotmetadata.getCoverImageAspectRatio())).a("Description", snapshotmetadata.getDescription()).a("LastModifiedTimestamp", Long.valueOf(snapshotmetadata.getLastModifiedTimestamp())).a("PlayedTime", Long.valueOf(snapshotmetadata.getPlayedTime())).a("UniqueName", snapshotmetadata.getUniqueName()).toString();
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public final SnapshotMetadata freeze()
    {
        return this;
    }

    public final volatile Object freeze()
    {
        return freeze();
    }

    public final float getCoverImageAspectRatio()
    {
        return Um;
    }

    public final Uri getCoverImageUri()
    {
        return Ue;
    }

    public final String getCoverImageUrl()
    {
        return Uj;
    }

    public final String getDescription()
    {
        return Mm;
    }

    public final void getDescription(CharArrayBuffer chararraybuffer)
    {
        il.b(Mm, chararraybuffer);
    }

    public final Game getGame()
    {
        return Rq;
    }

    public final long getLastModifiedTimestamp()
    {
        return Uk;
    }

    public final Player getOwner()
    {
        return Ui;
    }

    public final long getPlayedTime()
    {
        return Ul;
    }

    public final String getSnapshotId()
    {
        return NH;
    }

    public final String getTitle()
    {
        return HV;
    }

    public final String getUniqueName()
    {
        return Un;
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

    public final String toString()
    {
        return b(this);
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        SnapshotMetadataEntityCreator.a(this, parcel, i);
    }

}
