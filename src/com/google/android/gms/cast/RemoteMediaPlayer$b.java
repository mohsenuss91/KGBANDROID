// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gr;
import org.json.JSONObject;

abstract class _cls1 extends _cls1
{

    gr Bn;

    public Result c(Status status)
    {
        return l(status);
    }

    public diaChannelResult l(Status status)
    {
        class _cls2
            implements RemoteMediaPlayer.MediaChannelResult
        {

            final RemoteMediaPlayer.b Bo;
            final Status yG;

            public JSONObject getCustomData()
            {
                return null;
            }

            public Status getStatus()
            {
                return yG;
            }

            _cls2(Status status)
            {
                Bo = RemoteMediaPlayer.b.this;
                yG = status;
                super();
            }
        }

        return new _cls2(status);
    }

    _cls1.Bo()
    {
        class _cls1
            implements gr
        {

            final RemoteMediaPlayer.b Bo;

            public void a(long l1, int i, JSONObject jsonobject)
            {
                Bo.b(new RemoteMediaPlayer.c(new Status(i), jsonobject));
            }

            public void n(long l1)
            {
                Bo.b(Bo.l(new Status(4)));
            }

            _cls1()
            {
                Bo = RemoteMediaPlayer.b.this;
                super();
            }
        }

        Bn = new _cls1();
    }
}
