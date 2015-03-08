// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;


// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

final class Ot extends com.google.android.gms.internal.lback
{

    private final int CQ;
    final GamesClientImpl NB;
    private final String Ot;
    private final int Ou;

    public final void a(com.google.android.gms.games.multiplayer.realtime.ack ack)
    {
        if (ack != null)
        {
            ack.onRealTimeMessageSent(CQ, Ou, Ot);
        }
    }

    public final void d(Object obj)
    {
        a((com.google.android.gms.games.multiplayer.realtime.ack)obj);
    }

    protected final void fp()
    {
    }

    ageSentCallback(GamesClientImpl gamesclientimpl, com.google.android.gms.games.multiplayer.realtime.ack ack, int i, int j, String s)
    {
        NB = gamesclientimpl;
        super(gamesclientimpl, ack);
        CQ = i;
        Ou = j;
        Ot = s;
    }
}
