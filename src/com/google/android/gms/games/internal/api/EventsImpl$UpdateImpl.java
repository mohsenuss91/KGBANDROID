// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class <init> extends com.google.android.gms.games.odImpl
{

    public Result c(Status status)
    {
        class _cls1
            implements Result
        {

            final EventsImpl.UpdateImpl Pp;
            final Status yG;

            public Status getStatus()
            {
                return yG;
            }

            _cls1(Status status)
            {
                Pp = EventsImpl.UpdateImpl.this;
                yG = status;
                super();
            }
        }

        return new _cls1(status);
    }

    private _cls1()
    {
    }

    _cls1(_cls1 _pcls1)
    {
        this();
    }
}
