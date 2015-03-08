// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.viewpagerindicator;

import android.os.Parcel;

final class r
    implements android.os.Parcelable.Creator
{

    r()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new UnderlinePageIndicator.SavedState(parcel, (byte)0);
    }

    public final volatile Object[] newArray(int i)
    {
        return new UnderlinePageIndicator.SavedState[i];
    }
}
