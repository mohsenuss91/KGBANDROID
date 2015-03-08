// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;

final class >
    implements com.google.android.gms.games.multiplayer.turnbased.
{

    private final LoadMatchesResponse NW;
    private final Status yw;

    public final LoadMatchesResponse getMatches()
    {
        return NW;
    }

    public final Status getStatus()
    {
        return yw;
    }

    public final void release()
    {
        NW.close();
    }

    MatchesResult(Status status, Bundle bundle)
    {
        yw = status;
        NW = new LoadMatchesResponse(bundle);
    }
}
