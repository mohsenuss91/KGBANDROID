// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

// Referenced classes of package com.google.android.gms.games.multiplayer.realtime:
//            RoomRef, Room

public final class RoomBuffer extends g
{

    public RoomBuffer(DataHolder dataholder)
    {
        super(dataholder);
    }

    protected final Object c(int i, int j)
    {
        return h(i, j);
    }

    protected final String eU()
    {
        return "external_match_id";
    }

    protected final Room h(int i, int j)
    {
        return new RoomRef(DD, i, j);
    }
}
