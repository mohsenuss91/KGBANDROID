// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.internal.hn;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.games.multiplayer.realtime:
//            RoomUpdateListener, RoomConfig, RoomStatusUpdateListener, RealTimeMessageReceivedListener

public final class <init>
{

    int SV;
    final RoomUpdateListener Th;
    RoomStatusUpdateListener Ti;
    RealTimeMessageReceivedListener Tj;
    Bundle Tl;
    boolean Tm;
    String Tn;
    ArrayList To;

    public final <init> addPlayersToInvite(ArrayList arraylist)
    {
        hn.f(arraylist);
        To.addAll(arraylist);
        return this;
    }

    public final transient To addPlayersToInvite(String as[])
    {
        hn.f(as);
        To.addAll(Arrays.asList(as));
        return this;
    }

    public final RoomConfig build()
    {
        return new RoomConfig(this, null);
    }

    public final To setAutoMatchCriteria(Bundle bundle)
    {
        Tl = bundle;
        return this;
    }

    public final Tl setInvitationIdToAccept(String s)
    {
        hn.f(s);
        Tn = s;
        return this;
    }

    public final ivedListener setMessageReceivedListener(RealTimeMessageReceivedListener realtimemessagereceivedlistener)
    {
        Tj = realtimemessagereceivedlistener;
        return this;
    }

    public final tener setRoomStatusUpdateListener(RoomStatusUpdateListener roomstatusupdatelistener)
    {
        Ti = roomstatusupdatelistener;
        return this;
    }

    public final Ti setSocketCommunicationEnabled(boolean flag)
    {
        Tm = flag;
        return this;
    }

    public final Tm setVariant(int i)
    {
        boolean flag;
        if (i == -1 || i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hn.b(flag, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
        SV = i;
        return this;
    }

    private tener(RoomUpdateListener roomupdatelistener)
    {
        Tn = null;
        SV = -1;
        To = new ArrayList();
        Tm = false;
        Th = (RoomUpdateListener)hn.b(roomupdatelistener, "Must provide a RoomUpdateListener");
    }

    Th(RoomUpdateListener roomupdatelistener, Th th)
    {
        this(roomupdatelistener);
    }
}
