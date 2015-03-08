// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Parcel;

// Referenced classes of package com.millennialmedia.android:
//            HttpMMHeaders

final class 
    implements android.os.or
{

    public final HttpMMHeaders createFromParcel(Parcel parcel)
    {
        return new HttpMMHeaders(parcel);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final HttpMMHeaders[] newArray(int i)
    {
        return new HttpMMHeaders[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
