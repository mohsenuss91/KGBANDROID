// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.viewpagerindicator;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.viewpagerindicator:
//            r

class <init> extends android.view.avedState
{

    public static final android.os..SavedState.a CREATOR = new r();
    int a;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.avedState(parcel, i);
        parcel.writeInt(a);
    }


    private (Parcel parcel)
    {
        super(parcel);
        a = parcel.readInt();
    }

    a(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    public <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}
