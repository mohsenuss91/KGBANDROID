// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class xD extends com.google.android.gms.games.celMatchImpl
{

    private final String xD;

    static String a(xD xd)
    {
        return xd.xD;
    }

    public com.google.android.gms.games.multiplayer.turnbased.q ad(Status status)
    {
        class _cls1
            implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
        {

            final TurnBasedMultiplayerImpl.CancelMatchImpl QZ;
            final Status yG;

            public String getMatchId()
            {
                return TurnBasedMultiplayerImpl.CancelMatchImpl.a(QZ);
            }

            public Status getStatus()
            {
                return yG;
            }

            _cls1(Status status)
            {
                QZ = TurnBasedMultiplayerImpl.CancelMatchImpl.this;
                yG = status;
                super();
            }
        }

        return new _cls1(status);
    }

    public Result c(Status status)
    {
        return ad(status);
    }

    public Result(String s)
    {
        xD = s;
    }
}
