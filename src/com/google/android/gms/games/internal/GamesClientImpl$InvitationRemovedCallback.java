// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

final class NN extends com.google.android.gms.internal.lback
{

    final GamesClientImpl NB;
    private final String NN;

    protected final void b(OnInvitationReceivedListener oninvitationreceivedlistener)
    {
        oninvitationreceivedlistener.onInvitationRemoved(NN);
    }

    protected final void d(Object obj)
    {
        b((OnInvitationReceivedListener)obj);
    }

    protected final void fp()
    {
    }

    (GamesClientImpl gamesclientimpl, OnInvitationReceivedListener oninvitationreceivedlistener, String s)
    {
        NB = gamesclientimpl;
        super(gamesclientimpl, oninvitationreceivedlistener);
        NN = s;
    }
}
