// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;

class <init> extends android.view.iew.SavedState
{

    public static final android.os.yView.SavedState._cls1 CREATOR = new _cls1();
    public Object customInlineLayoutParams;
    String gson;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.rcel(parcel, i);
        parcel.writeString(gson);
    }


    private _cls1(Parcel parcel)
    {
        super(parcel);
        gson = parcel.readString();
    }

    gson(Parcel parcel, gson gson1)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable)
    {
        super(parcelable);
    }

    class _cls1
        implements android.os.Parcelable.Creator
    {

        public final AdViewOverlayView.SavedState createFromParcel(Parcel parcel)
        {
            return new AdViewOverlayView.SavedState(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final AdViewOverlayView.SavedState[] newArray(int i)
        {
            return new AdViewOverlayView.SavedState[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

            _cls1()
            {
            }
    }

}
