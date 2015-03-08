// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.InputStream;
import java.io.OutputStream;

final class RealTimeSocketImpl
    implements RealTimeSocket
{

    private ParcelFileDescriptor Fg;
    private final String On;
    private final LocalSocket Pa;

    RealTimeSocketImpl(LocalSocket localsocket, String s)
    {
        Pa = localsocket;
        On = s;
    }

    public final void close()
    {
        Pa.close();
    }

    public final InputStream getInputStream()
    {
        return Pa.getInputStream();
    }

    public final OutputStream getOutputStream()
    {
        return Pa.getOutputStream();
    }

    public final ParcelFileDescriptor getParcelFileDescriptor()
    {
        if (Fg == null && !isClosed())
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeFileDescriptor(Pa.getFileDescriptor());
            parcel.setDataPosition(0);
            Fg = parcel.readFileDescriptor();
        }
        return Fg;
    }

    public final boolean isClosed()
    {
        return !Pa.isConnected() && !Pa.isBound();
    }
}
