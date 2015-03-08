// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.os.Parcel;

final class q
    implements android.os.Parcelable.Creator
{

    q()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new MenuDrawer.SavedState(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new MenuDrawer.SavedState[i];
    }
}
