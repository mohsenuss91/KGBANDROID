// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.PlayerBuffer;

final class NY extends b
    implements com.google.android.gms.games.sultImpl
{

    private final PlayerBuffer NY;

    public final PlayerBuffer getPlayers()
    {
        return NY;
    }

    Q(DataHolder dataholder)
    {
        super(dataholder);
        NY = new PlayerBuffer(dataholder);
    }
}
