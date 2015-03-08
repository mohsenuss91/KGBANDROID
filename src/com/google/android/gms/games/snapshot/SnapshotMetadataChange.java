// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hn;

// Referenced classes of package com.google.android.gms.games.snapshot:
//            SnapshotMetadataChangeCreator

public final class SnapshotMetadataChange
    implements SafeParcelable
{

    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChange();
    private final String Mm;
    private final Long Ud;
    private final Uri Ue;
    private a Uf;
    private final int xJ;

    SnapshotMetadataChange()
    {
        this(4, null, null, null, null);
    }

    SnapshotMetadataChange(int i, String s, Long long1, a a1, Uri uri)
    {
        boolean flag = true;
        super();
        xJ = i;
        Mm = s;
        Ud = long1;
        Uf = a1;
        Ue = uri;
        if (Uf != null)
        {
            if (Ue != null)
            {
                flag = false;
            }
            hn.a(flag, "Cannot set both a URI and an image");
        } else
        if (Ue != null)
        {
            if (Uf != null)
            {
                flag = false;
            }
            hn.a(flag, "Cannot set both a URI and an image");
            return;
        }
    }

    SnapshotMetadataChange(String s, Long long1, a a1, Uri uri)
    {
        this(4, s, long1, a1, uri);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Bitmap getCoverImage()
    {
        if (Uf == null)
        {
            return null;
        } else
        {
            return Uf.eN();
        }
    }

    public final Uri getCoverImageUri()
    {
        return Ue;
    }

    public final String getDescription()
    {
        return Mm;
    }

    public final Long getPlayedTimeMillis()
    {
        return Ud;
    }

    public final int getVersionCode()
    {
        return xJ;
    }

    public final a iI()
    {
        return Uf;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.games.snapshot.SnapshotMetadataChangeCreator.a(this, parcel, i);
    }

}
