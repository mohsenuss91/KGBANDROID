// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.os.Parcel;

final class e
    implements android.os.Parcelable.Creator
{

    e()
    {
    }

    public final JSController.Properties a(Parcel parcel)
    {
        return new JSController.Properties(parcel);
    }

    public final JSController.Properties[] a(int i)
    {
        return new JSController.Properties[i];
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
