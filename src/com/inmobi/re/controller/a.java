// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.os.Parcel;

final class a
    implements android.os.Parcelable.Creator
{

    a()
    {
    }

    public final JSController.ResizeProperties a(Parcel parcel)
    {
        return new JSController.ResizeProperties(parcel);
    }

    public final JSController.ResizeProperties[] a(int i)
    {
        return new JSController.ResizeProperties[i];
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
