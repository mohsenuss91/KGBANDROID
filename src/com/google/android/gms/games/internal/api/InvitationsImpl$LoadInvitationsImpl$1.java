// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

class yG
    implements com.google.android.gms.games.multiplayer.
{

    final yG PE;
    final Status yG;

    public InvitationBuffer getInvitations()
    {
        return new InvitationBuffer(DataHolder.af(14));
    }

    public Status getStatus()
    {
        return yG;
    }

    public void release()
    {
    }

    ( , Status status)
    {
        PE = ;
        yG = status;
        super();
    }
}
