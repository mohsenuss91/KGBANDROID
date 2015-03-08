// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class _cls1 extends com.google.android.gms.games.esResultImpl
{

    public com.google.android.gms.games.esResultImpl Q(Status status)
    {
        class _cls1
            implements com.google.android.gms.games.Players.LoadXpForGameCategoriesResult
        {

            final PlayersImpl.LoadXpForGameCategoriesResultImpl Qi;
            final Status yG;

            public Status getStatus()
            {
                return yG;
            }

            _cls1(Status status)
            {
                Qi = PlayersImpl.LoadXpForGameCategoriesResultImpl.this;
                yG = status;
                super();
            }
        }

        return new _cls1(status);
    }

    public Result c(Status status)
    {
        return Q(status);
    }

    private _cls1()
    {
    }
}
