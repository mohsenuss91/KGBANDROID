// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.event.EventBuffer;

final class NR extends b
    implements com.google.android.gms.games.event.pl
{

    private final EventBuffer NR;

    public final EventBuffer getEvents()
    {
        return NR;
    }

    (DataHolder dataholder)
    {
        super(dataholder);
        NR = new EventBuffer(dataholder);
    }
}
