// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.internal.hn;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

final class yO extends AbstractGamesCallbacks
{

    final GamesClientImpl NB;
    private final com.google.android.gms.common.api.init> yO;

    public final void a(int i, String s, boolean flag)
    {
        yO.yO(new >(i, s, flag));
    }

    (GamesClientImpl gamesclientimpl, com.google.android.gms.common.api.ack ack)
    {
        NB = gamesclientimpl;
        super();
        yO = (com.google.android.gms.common.api.ack.yO)hn.b(ack, "Holder must not be null");
    }
}
