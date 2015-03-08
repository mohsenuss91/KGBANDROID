// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.internal.gq;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast:
//            Cast, RemoteMediaPlayer

class Bk
    implements gq
{

    final RemoteMediaPlayer AX;
    private GoogleApiClient Bj;
    private long Bk;

    public void a(String s, String s1, long l, String s2)
    {
        if (Bj == null)
        {
            throw new IOException("No GoogleApiClient available");
        } else
        {
            class a
                implements ResultCallback
            {

                private final long Bl;
                final RemoteMediaPlayer.a Bm;

                public final void k(Status status)
                {
                    if (!status.isSuccess())
                    {
                        RemoteMediaPlayer.e(Bm.AX).a(Bl, status.getStatusCode());
                    }
                }

                public final void onResult(Result result)
                {
                    k((Status)result);
                }

            a(long l)
            {
                Bm = RemoteMediaPlayer.a.this;
                super();
                Bl = l;
            }
            }

            Cast.CastApi.sage(Bj, s, s1).setResultCallback(new a(l));
            return;
        }
    }

    public void b(GoogleApiClient googleapiclient)
    {
        Bj = googleapiclient;
    }

    public long dW()
    {
        long l = 1L + Bk;
        Bk = l;
        return l;
    }

    public t(RemoteMediaPlayer remotemediaplayer)
    {
        AX = remotemediaplayer;
        super();
        Bk = 0L;
    }
}
