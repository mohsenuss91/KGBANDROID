// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.internal.gp;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaInfo, MediaStatus, CastDevice, TextTrackStyle

public class RemoteMediaPlayer
    implements Cast.MessageReceivedCallback
{

    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2;
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_REPLACED = 4;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 3;
    private final gp AT = new _cls1();
    private final a AU = new a();
    private OnMetadataUpdatedListener AV;
    private OnStatusUpdatedListener AW;
    private final Object lq = new Object();

    public RemoteMediaPlayer()
    {
        AT.a(AU);
    }

    static void a(RemoteMediaPlayer remotemediaplayer)
    {
        remotemediaplayer.onStatusUpdated();
    }

    static void b(RemoteMediaPlayer remotemediaplayer)
    {
        remotemediaplayer.onMetadataUpdated();
    }

    static Object c(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.lq;
    }

    static a d(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.AU;
    }

    static gp e(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.AT;
    }

    private void onMetadataUpdated()
    {
        if (AV != null)
        {
            AV.onMetadataUpdated();
        }
    }

    private void onStatusUpdated()
    {
        if (AW != null)
        {
            AW.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition()
    {
        long l;
        synchronized (lq)
        {
            l = AT.getApproximateStreamPosition();
        }
        return l;
    }

    public MediaInfo getMediaInfo()
    {
        MediaInfo mediainfo;
        synchronized (lq)
        {
            mediainfo = AT.getMediaInfo();
        }
        return mediainfo;
    }

    public MediaStatus getMediaStatus()
    {
        MediaStatus mediastatus;
        synchronized (lq)
        {
            mediastatus = AT.getMediaStatus();
        }
        return mediastatus;
    }

    public String getNamespace()
    {
        return AT.getNamespace();
    }

    public long getStreamDuration()
    {
        long l;
        synchronized (lq)
        {
            l = AT.getStreamDuration();
        }
        return l;
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo)
    {
        return load(googleapiclient, mediainfo, true, 0L, null);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag)
    {
        return load(googleapiclient, mediainfo, flag, 0L, null);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag, long l)
    {
        return load(googleapiclient, mediainfo, flag, l, null);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag, long l, JSONObject jsonobject)
    {
        return googleapiclient.b(new _cls4(googleapiclient, mediainfo, flag, l, jsonobject));
    }

    public void onMessageReceived(CastDevice castdevice, String s, String s1)
    {
        AT.ai(s1);
    }

    public PendingResult pause(GoogleApiClient googleapiclient)
    {
        return pause(googleapiclient, null);
    }

    public PendingResult pause(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.b(new _cls5(googleapiclient, jsonobject));
    }

    public PendingResult play(GoogleApiClient googleapiclient)
    {
        return play(googleapiclient, null);
    }

    public PendingResult play(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.b(new _cls7(googleapiclient, jsonobject));
    }

    public PendingResult requestStatus(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new _cls11(googleapiclient));
    }

    public PendingResult seek(GoogleApiClient googleapiclient, long l)
    {
        return seek(googleapiclient, l, 0, null);
    }

    public PendingResult seek(GoogleApiClient googleapiclient, long l, int i)
    {
        return seek(googleapiclient, l, i, null);
    }

    public PendingResult seek(GoogleApiClient googleapiclient, long l, int i, JSONObject jsonobject)
    {
        return googleapiclient.b(new _cls8(googleapiclient, l, i, jsonobject));
    }

    public PendingResult setActiveMediaTracks(GoogleApiClient googleapiclient, long al[])
    {
        return googleapiclient.b(new _cls2(googleapiclient, al));
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onmetadataupdatedlistener)
    {
        AV = onmetadataupdatedlistener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onstatusupdatedlistener)
    {
        AW = onstatusupdatedlistener;
    }

    public PendingResult setStreamMute(GoogleApiClient googleapiclient, boolean flag)
    {
        return setStreamMute(googleapiclient, flag, null);
    }

    public PendingResult setStreamMute(GoogleApiClient googleapiclient, boolean flag, JSONObject jsonobject)
    {
        return googleapiclient.b(new _cls10(googleapiclient, flag, jsonobject));
    }

    public PendingResult setStreamVolume(GoogleApiClient googleapiclient, double d1)
    {
        return setStreamVolume(googleapiclient, d1, null);
    }

    public PendingResult setStreamVolume(GoogleApiClient googleapiclient, double d1, JSONObject jsonobject)
    {
        if (Double.isInfinite(d1) || Double.isNaN(d1))
        {
            throw new IllegalArgumentException((new StringBuilder("Volume cannot be ")).append(d1).toString());
        } else
        {
            return googleapiclient.b(new _cls9(googleapiclient, d1, jsonobject));
        }
    }

    public PendingResult setTextTrackStyle(GoogleApiClient googleapiclient, TextTrackStyle texttrackstyle)
    {
        return googleapiclient.b(new _cls3(googleapiclient, texttrackstyle));
    }

    public PendingResult stop(GoogleApiClient googleapiclient)
    {
        return stop(googleapiclient, null);
    }

    public PendingResult stop(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.b(new _cls6(googleapiclient, jsonobject));
    }

    private class a
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
                    final a Bm;

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
                    Bm = a.this;
                    super();
                    Bl = l;
                }
                }

                Cast.CastApi.sendMessage(Bj, s, s1).setResultCallback(new a(l));
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

        public a()
        {
            AX = RemoteMediaPlayer.this;
            super();
            Bk = 0L;
        }
    }


    private class _cls1 extends gp
    {

        final RemoteMediaPlayer AX;

        protected void onMetadataUpdated()
        {
            RemoteMediaPlayer.b(AX);
        }

        protected void onStatusUpdated()
        {
            RemoteMediaPlayer.a(AX);
        }

        _cls1()
        {
            AX = RemoteMediaPlayer.this;
            super();
        }
    }


    private class OnMetadataUpdatedListener
    {

        public abstract void onMetadataUpdated();
    }


    private class OnStatusUpdatedListener
    {

        public abstract void onStatusUpdated();
    }


    private class _cls4 extends b
    {
        private class b extends Cast.a
        {

            gr Bn;

            public Result c(Status status)
            {
                return l(status);
            }

            public MediaChannelResult l(Status status)
            {
                class _cls2
                    implements MediaChannelResult
                {

                    final b Bo;
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
                        Bo = b.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls2(status);
            }

            b()
            {
                class _cls1
                    implements gr
                {

                    final b Bo;

                    public void a(long l1, int i, JSONObject jsonobject)
                    {
                        Bo.b(new c(new Status(i), jsonobject));
                    }

                    public void n(long l1)
                    {
                        Bo.b(Bo.l(new Status(4)));
                    }

                    _cls1()
                    {
                        Bo = b.this;
                        super();
                    }

                    private class c
                        implements MediaChannelResult
                    {

                        private final JSONObject Ax;
                        private final Status yw;

                        public final JSONObject getCustomData()
                        {
                            return Ax;
                        }

                        public final Status getStatus()
                        {
                            return yw;
                        }

                        c(Status status, JSONObject jsonobject)
                        {
                            yw = status;
                            Ax = jsonobject;
                        }
                    }

                }

                Bn = new _cls1();
            }
        }


        final RemoteMediaPlayer AX;
        final GoogleApiClient AY;
        final MediaInfo Bb;
        final boolean Bc;
        final long Bd;
        final JSONObject Be;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gi)a1);
        }

        protected void a(gi gi1)
        {
            Object obj = RemoteMediaPlayer.c(AX);
            obj;
            JVM INSTR monitorenter ;
            RemoteMediaPlayer.d(AX).b(AY);
            RemoteMediaPlayer.e(AX).a(Bn, Bb, Bc, Bd, Be);
            RemoteMediaPlayer.d(AX).b(null);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            IOException ioexception;
            ioexception;
            b(l(new Status(1)));
            RemoteMediaPlayer.d(AX).b(null);
              goto _L1
            Exception exception;
            exception;
            throw exception;
            Exception exception1;
            exception1;
            RemoteMediaPlayer.d(AX).b(null);
            throw exception1;
        }

        _cls4(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag, long l, JSONObject jsonobject)
        {
            AX = RemoteMediaPlayer.this;
            AY = googleapiclient;
            Bb = mediainfo;
            Bc = flag;
            Bd = l;
            Be = jsonobject;
            super();
        }
    }


    private class _cls5 extends b
    {

        final RemoteMediaPlayer AX;
        final GoogleApiClient AY;
        final JSONObject Be;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gi)a1);
        }

        protected void a(gi gi1)
        {
            Object obj = RemoteMediaPlayer.c(AX);
            obj;
            JVM INSTR monitorenter ;
            RemoteMediaPlayer.d(AX).b(AY);
            RemoteMediaPlayer.e(AX).a(Bn, Be);
            RemoteMediaPlayer.d(AX).b(null);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            IOException ioexception;
            ioexception;
            b(l(new Status(1)));
            RemoteMediaPlayer.d(AX).b(null);
              goto _L1
            Exception exception;
            exception;
            throw exception;
            Exception exception1;
            exception1;
            RemoteMediaPlayer.d(AX).b(null);
            throw exception1;
        }

        _cls5(GoogleApiClient googleapiclient, JSONObject jsonobject)
        {
            AX = RemoteMediaPlayer.this;
            AY = googleapiclient;
            Be = jsonobject;
            super();
        }
    }


    private class _cls7 extends b
    {

        final RemoteMediaPlayer AX;
        final GoogleApiClient AY;
        final JSONObject Be;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gi)a1);
        }

        protected void a(gi gi1)
        {
            Object obj = RemoteMediaPlayer.c(AX);
            obj;
            JVM INSTR monitorenter ;
            RemoteMediaPlayer.d(AX).b(AY);
            RemoteMediaPlayer.e(AX).c(Bn, Be);
            RemoteMediaPlayer.d(AX).b(null);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            IOException ioexception;
            ioexception;
            b(l(new Status(1)));
            RemoteMediaPlayer.d(AX).b(null);
              goto _L1
            Exception exception;
            exception;
            throw exception;
            Exception exception1;
            exception1;
            RemoteMediaPlayer.d(AX).b(null);
            throw exception1;
        }

        _cls7(GoogleApiClient googleapiclient, JSONObject jsonobject)
        {
            AX = RemoteMediaPlayer.this;
            AY = googleapiclient;
            Be = jsonobject;
            super();
        }
    }


    private class _cls11 extends b
    {

        final RemoteMediaPlayer AX;
        final GoogleApiClient AY;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gi)a1);
        }

        protected void a(gi gi1)
        {
            Object obj = RemoteMediaPlayer.c(AX);
            obj;
            JVM INSTR monitorenter ;
            RemoteMediaPlayer.d(AX).b(AY);
            RemoteMediaPlayer.e(AX).a(Bn);
            RemoteMediaPlayer.d(AX).b(null);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            IOException ioexception;
            ioexception;
            b(l(new Status(1)));
            RemoteMediaPlayer.d(AX).b(null);
              goto _L1
            Exception exception;
            exception;
            throw exception;
            Exception exception1;
            exception1;
            RemoteMediaPlayer.d(AX).b(null);
            throw exception1;
        }

        _cls11(GoogleApiClient googleapiclient)
        {
            AX = RemoteMediaPlayer.this;
            AY = googleapiclient;
            super();
        }
    }


    private class _cls8 extends b
    {

        final RemoteMediaPlayer AX;
        final GoogleApiClient AY;
        final JSONObject Be;
        final long Bf;
        final int Bg;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gi)a1);
        }

        protected void a(gi gi1)
        {
            Object obj = RemoteMediaPlayer.c(AX);
            obj;
            JVM INSTR monitorenter ;
            RemoteMediaPlayer.d(AX).b(AY);
            RemoteMediaPlayer.e(AX).a(Bn, Bf, Bg, Be);
            RemoteMediaPlayer.d(AX).b(null);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            IOException ioexception;
            ioexception;
            b(l(new Status(1)));
            RemoteMediaPlayer.d(AX).b(null);
              goto _L1
            Exception exception;
            exception;
            throw exception;
            Exception exception1;
            exception1;
            RemoteMediaPlayer.d(AX).b(null);
            throw exception1;
        }

        _cls8(GoogleApiClient googleapiclient, long l, int i, JSONObject jsonobject)
        {
            AX = RemoteMediaPlayer.this;
            AY = googleapiclient;
            Bf = l;
            Bg = i;
            Be = jsonobject;
            super();
        }
    }


    private class _cls2 extends b
    {

        final RemoteMediaPlayer AX;
        final GoogleApiClient AY;
        final long AZ[];

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gi)a1);
        }

        protected void a(gi gi1)
        {
            Object obj = RemoteMediaPlayer.c(AX);
            obj;
            JVM INSTR monitorenter ;
            RemoteMediaPlayer.d(AX).b(AY);
            RemoteMediaPlayer.e(AX).a(Bn, AZ);
            RemoteMediaPlayer.d(AX).b(null);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            IOException ioexception;
            ioexception;
            b(l(new Status(1)));
            RemoteMediaPlayer.d(AX).b(null);
              goto _L1
            Exception exception;
            exception;
            throw exception;
            Exception exception1;
            exception1;
            RemoteMediaPlayer.d(AX).b(null);
            throw exception1;
        }

        _cls2(GoogleApiClient googleapiclient, long al[])
        {
            AX = RemoteMediaPlayer.this;
            AY = googleapiclient;
            AZ = al;
            super();
        }
    }


    private class _cls10 extends b
    {

        final RemoteMediaPlayer AX;
        final GoogleApiClient AY;
        final JSONObject Be;
        final boolean Bi;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gi)a1);
        }

        protected void a(gi gi1)
        {
            Object obj = RemoteMediaPlayer.c(AX);
            obj;
            JVM INSTR monitorenter ;
            RemoteMediaPlayer.d(AX).b(AY);
            RemoteMediaPlayer.e(AX).a(Bn, Bi, Be);
            RemoteMediaPlayer.d(AX).b(null);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            IllegalStateException illegalstateexception;
            illegalstateexception;
            b(l(new Status(1)));
            RemoteMediaPlayer.d(AX).b(null);
              goto _L1
            Exception exception;
            exception;
            throw exception;
            IOException ioexception;
            ioexception;
            b(l(new Status(1)));
            RemoteMediaPlayer.d(AX).b(null);
              goto _L1
            Exception exception1;
            exception1;
            RemoteMediaPlayer.d(AX).b(null);
            throw exception1;
        }

        _cls10(GoogleApiClient googleapiclient, boolean flag, JSONObject jsonobject)
        {
            AX = RemoteMediaPlayer.this;
            AY = googleapiclient;
            Bi = flag;
            Be = jsonobject;
            super();
        }
    }


    private class _cls9 extends b
    {

        final RemoteMediaPlayer AX;
        final GoogleApiClient AY;
        final JSONObject Be;
        final double Bh;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gi)a1);
        }

        protected void a(gi gi1)
        {
            Object obj = RemoteMediaPlayer.c(AX);
            obj;
            JVM INSTR monitorenter ;
            RemoteMediaPlayer.d(AX).b(AY);
            RemoteMediaPlayer.e(AX).a(Bn, Bh, Be);
            RemoteMediaPlayer.d(AX).b(null);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            IllegalStateException illegalstateexception;
            illegalstateexception;
            b(l(new Status(1)));
            RemoteMediaPlayer.d(AX).b(null);
              goto _L1
            Exception exception;
            exception;
            throw exception;
            IllegalArgumentException illegalargumentexception;
            illegalargumentexception;
            b(l(new Status(1)));
            RemoteMediaPlayer.d(AX).b(null);
              goto _L1
            IOException ioexception;
            ioexception;
            b(l(new Status(1)));
            RemoteMediaPlayer.d(AX).b(null);
              goto _L1
            Exception exception1;
            exception1;
            RemoteMediaPlayer.d(AX).b(null);
            throw exception1;
        }

        _cls9(GoogleApiClient googleapiclient, double d1, JSONObject jsonobject)
        {
            AX = RemoteMediaPlayer.this;
            AY = googleapiclient;
            Bh = d1;
            Be = jsonobject;
            super();
        }
    }


    private class _cls3 extends b
    {

        final RemoteMediaPlayer AX;
        final GoogleApiClient AY;
        final TextTrackStyle Ba;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gi)a1);
        }

        protected void a(gi gi1)
        {
            Object obj = RemoteMediaPlayer.c(AX);
            obj;
            JVM INSTR monitorenter ;
            RemoteMediaPlayer.d(AX).b(AY);
            RemoteMediaPlayer.e(AX).a(Bn, Ba);
            RemoteMediaPlayer.d(AX).b(null);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            IOException ioexception;
            ioexception;
            b(l(new Status(1)));
            RemoteMediaPlayer.d(AX).b(null);
              goto _L1
            Exception exception;
            exception;
            throw exception;
            Exception exception1;
            exception1;
            RemoteMediaPlayer.d(AX).b(null);
            throw exception1;
        }

        _cls3(GoogleApiClient googleapiclient, TextTrackStyle texttrackstyle)
        {
            AX = RemoteMediaPlayer.this;
            AY = googleapiclient;
            Ba = texttrackstyle;
            super();
        }
    }


    private class _cls6 extends b
    {

        final RemoteMediaPlayer AX;
        final GoogleApiClient AY;
        final JSONObject Be;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((gi)a1);
        }

        protected void a(gi gi1)
        {
            Object obj = RemoteMediaPlayer.c(AX);
            obj;
            JVM INSTR monitorenter ;
            RemoteMediaPlayer.d(AX).b(AY);
            RemoteMediaPlayer.e(AX).b(Bn, Be);
            RemoteMediaPlayer.d(AX).b(null);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            IOException ioexception;
            ioexception;
            b(l(new Status(1)));
            RemoteMediaPlayer.d(AX).b(null);
              goto _L1
            Exception exception;
            exception;
            throw exception;
            Exception exception1;
            exception1;
            RemoteMediaPlayer.d(AX).b(null);
            throw exception1;
        }

        _cls6(GoogleApiClient googleapiclient, JSONObject jsonobject)
        {
            AX = RemoteMediaPlayer.this;
            AY = googleapiclient;
            Be = jsonobject;
            super();
        }
    }

}
