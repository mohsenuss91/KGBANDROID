// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

final class NV extends b
    implements com.google.android.gms.games.multiplayer.
{

    private final InvitationBuffer NV;

    public final InvitationBuffer getInvitations()
    {
        return NV;
    }

    (DataHolder dataholder)
    {
        super(dataholder);
        NV = new InvitationBuffer(dataholder);
    }
}
