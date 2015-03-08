// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.internal.hn;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer.realtime:
//            RoomUpdateListener, RoomStatusUpdateListener, RealTimeMessageReceivedListener

public final class RoomConfig
{

    private final String NN;
    private final int SV;
    private final RoomUpdateListener Th;
    private final RoomStatusUpdateListener Ti;
    private final RealTimeMessageReceivedListener Tj;
    private final String Tk[];
    private final Bundle Tl;
    private final boolean Tm;

    private RoomConfig(Builder builder1)
    {
        Th = builder1.Th;
        Ti = builder1.Ti;
        Tj = builder1.Tj;
        NN = builder1.Tn;
        SV = builder1.SV;
        Tl = builder1.Tl;
        Tm = builder1.Tm;
        int i = builder1.To.size();
        Tk = (String[])builder1.To.toArray(new String[i]);
        if (Tj == null)
        {
            hn.a(Tm, "Must either enable sockets OR specify a message listener");
        }
    }

    RoomConfig(Builder builder1, _cls1 _pcls1)
    {
        this(builder1);
    }

    public static Builder builder(RoomUpdateListener roomupdatelistener)
    {
        return new Builder(roomupdatelistener, null);
    }

    public static Bundle createAutoMatchCriteria(int i, int j, long l)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("min_automatch_players", i);
        bundle.putInt("max_automatch_players", j);
        bundle.putLong("exclusive_bit_mask", l);
        return bundle;
    }

    public final Bundle getAutoMatchCriteria()
    {
        return Tl;
    }

    public final String getInvitationId()
    {
        return NN;
    }

    public final String[] getInvitedPlayerIds()
    {
        return Tk;
    }

    public final RealTimeMessageReceivedListener getMessageReceivedListener()
    {
        return Tj;
    }

    public final RoomStatusUpdateListener getRoomStatusUpdateListener()
    {
        return Ti;
    }

    public final RoomUpdateListener getRoomUpdateListener()
    {
        return Th;
    }

    public final int getVariant()
    {
        return SV;
    }

    public final boolean isSocketEnabled()
    {
        return Tm;
    }

    private class Builder
    {

        int SV;
        final RoomUpdateListener Th;
        RoomStatusUpdateListener Ti;
        RealTimeMessageReceivedListener Tj;
        Bundle Tl;
        boolean Tm;
        String Tn;
        ArrayList To;

        public final Builder addPlayersToInvite(ArrayList arraylist)
        {
            hn.f(arraylist);
            To.addAll(arraylist);
            return this;
        }

        public final transient Builder addPlayersToInvite(String as[])
        {
            hn.f(as);
            To.addAll(Arrays.asList(as));
            return this;
        }

        public final RoomConfig build()
        {
            return new RoomConfig(this, null);
        }

        public final Builder setAutoMatchCriteria(Bundle bundle)
        {
            Tl = bundle;
            return this;
        }

        public final Builder setInvitationIdToAccept(String s)
        {
            hn.f(s);
            Tn = s;
            return this;
        }

        public final Builder setMessageReceivedListener(RealTimeMessageReceivedListener realtimemessagereceivedlistener)
        {
            Tj = realtimemessagereceivedlistener;
            return this;
        }

        public final Builder setRoomStatusUpdateListener(RoomStatusUpdateListener roomstatusupdatelistener)
        {
            Ti = roomstatusupdatelistener;
            return this;
        }

        public final Builder setSocketCommunicationEnabled(boolean flag)
        {
            Tm = flag;
            return this;
        }

        public final Builder setVariant(int i)
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

        private Builder(RoomUpdateListener roomupdatelistener)
        {
            Tn = null;
            SV = -1;
            To = new ArrayList();
            Tm = false;
            Th = (RoomUpdateListener)hn.b(roomupdatelistener, "Must provide a RoomUpdateListener");
        }

        Builder(RoomUpdateListener roomupdatelistener, _cls1 _pcls1)
        {
            this(roomupdatelistener);
        }
    }

}
