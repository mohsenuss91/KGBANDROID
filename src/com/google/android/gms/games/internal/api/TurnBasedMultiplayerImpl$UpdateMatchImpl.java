// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class <init> extends com.google.android.gms.games.ateMatchImpl
{

    public com.google.android.gms.games.multiplayer.turnbased.Q ai(Status status)
    {
        class _cls1
            implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult
        {

            final TurnBasedMultiplayerImpl.UpdateMatchImpl Re;
            final Status yG;

            public TurnBasedMatch getMatch()
            {
                return null;
            }

            public Status getStatus()
            {
                return yG;
            }

            _cls1(Status status)
            {
                Re = TurnBasedMultiplayerImpl.UpdateMatchImpl.this;
                yG = status;
                super();
            }
        }

        return new _cls1(status);
    }

    public Result c(Status status)
    {
        return ai(status);
    }

    private Result()
    {
    }

    Result(Result result)
    {
        this();
    }
}
