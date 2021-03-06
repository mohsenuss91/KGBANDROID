// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.hn;

public final class RealTimeMessage
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE;
    private final String Te;
    private final byte Tf[];
    private final int Tg;

    private RealTimeMessage(Parcel parcel)
    {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    RealTimeMessage(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public RealTimeMessage(String s, byte abyte0[], int i)
    {
        Te = (String)hn.f(s);
        Tf = (byte[])((byte[])hn.f(abyte0)).clone();
        Tg = i;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final byte[] getMessageData()
    {
        return Tf;
    }

    public final String getSenderParticipantId()
    {
        return Te;
    }

    public final boolean isReliable()
    {
        return Tg == 1;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(Te);
        parcel.writeByteArray(Tf);
        parcel.writeInt(Tg);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final RealTimeMessage bn(Parcel parcel)
        {
            return new RealTimeMessage(parcel, null);
        }

        public final Object createFromParcel(Parcel parcel)
        {
            return bn(parcel);
        }

        public final RealTimeMessage[] cz(int i)
        {
            return new RealTimeMessage[i];
        }

        public final Object[] newArray(int i)
        {
            return cz(i);
        }

        _cls1()
        {
        }
    }

}
