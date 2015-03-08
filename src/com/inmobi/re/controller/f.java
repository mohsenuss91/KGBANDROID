// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.os.Parcel;

final class f
    implements android.os.Parcelable.Creator
{

    f()
    {
    }

    public final JSController.ExpandProperties a(Parcel parcel)
    {
        return new JSController.ExpandProperties(parcel);
    }

    public final JSController.ExpandProperties[] a(int i)
    {
        return new JSController.ExpandProperties[i];
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return a(i);
    }
}
