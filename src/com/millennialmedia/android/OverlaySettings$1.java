// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Parcel;

// Referenced classes of package com.millennialmedia.android:
//            OverlaySettings

final class 
    implements android.os.
{

    public final OverlaySettings createFromParcel(Parcel parcel)
    {
        return new OverlaySettings(parcel);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final OverlaySettings[] newArray(int i)
    {
        return new OverlaySettings[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
