// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            h

public final class InstrumentInfo
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new h();
    private String aiZ;
    private String aja;
    private final int xJ;

    InstrumentInfo(int i, String s, String s1)
    {
        xJ = i;
        aiZ = s;
        aja = s1;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String getInstrumentDetails()
    {
        return aja;
    }

    public final String getInstrumentType()
    {
        return aiZ;
    }

    public final int getVersionCode()
    {
        return xJ;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        h.a(this, parcel, i);
    }

}
