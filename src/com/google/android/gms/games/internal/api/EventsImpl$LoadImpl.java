// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class <init> extends com.google.android.gms.games.thodImpl
{

    public com.google.android.gms.games.event.ult A(Status status)
    {
        class _cls1
            implements com.google.android.gms.games.event.Events.LoadEventsResult
        {

            final EventsImpl.LoadImpl Po;
            final Status yG;

            public EventBuffer getEvents()
            {
                return new EventBuffer(DataHolder.af(14));
            }

            public Status getStatus()
            {
                return yG;
            }

            public void release()
            {
            }

            _cls1(Status status)
            {
                Po = EventsImpl.LoadImpl.this;
                yG = status;
                super();
            }
        }

        return new _cls1(status);
    }

    public Result c(Status status)
    {
        return A(status);
    }

    private _cls1()
    {
    }

    _cls1(_cls1 _pcls1)
    {
        this();
    }
}
