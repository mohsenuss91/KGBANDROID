// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;

public final class SnapshotsImpl
    implements Snapshots
{

    public SnapshotsImpl()
    {
    }

    public final PendingResult commitAndClose(GoogleApiClient googleapiclient, Snapshot snapshot, SnapshotMetadataChange snapshotmetadatachange)
    {
        return googleapiclient.b(new _cls3(snapshot, snapshotmetadatachange));
    }

    public final PendingResult delete(GoogleApiClient googleapiclient, SnapshotMetadata snapshotmetadata)
    {
        return googleapiclient.b(new _cls4(snapshotmetadata));
    }

    public final void discardAndClose(GoogleApiClient googleapiclient, Snapshot snapshot)
    {
        Games.c(googleapiclient).a(snapshot);
    }

    public final int getMaxCoverImageSize(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).hp();
    }

    public final int getMaxDataSize(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).ho();
    }

    public final Intent getSelectSnapshotIntent(GoogleApiClient googleapiclient, String s, boolean flag, boolean flag1, int i)
    {
        return Games.c(googleapiclient).a(s, flag, flag1, i);
    }

    public final SnapshotMetadata getSnapshotFromBundle(Bundle bundle)
    {
        if (bundle == null || !bundle.containsKey("com.google.android.gms.games.SNAPSHOT_METADATA"))
        {
            return null;
        } else
        {
            return (SnapshotMetadata)bundle.getParcelable("com.google.android.gms.games.SNAPSHOT_METADATA");
        }
    }

    public final PendingResult load(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.a(new _cls1(flag));
    }

    public final PendingResult open(GoogleApiClient googleapiclient, SnapshotMetadata snapshotmetadata)
    {
        return open(googleapiclient, snapshotmetadata.getUniqueName(), false);
    }

    public final PendingResult open(GoogleApiClient googleapiclient, String s, boolean flag)
    {
        return googleapiclient.b(new _cls2(s, flag));
    }

    public final PendingResult resolveConflict(GoogleApiClient googleapiclient, String s, Snapshot snapshot)
    {
        SnapshotMetadata snapshotmetadata = snapshot.getMetadata();
        SnapshotMetadataChange snapshotmetadatachange = (new com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder()).fromMetadata(snapshotmetadata).build();
        return resolveConflict(googleapiclient, s, snapshotmetadata.getSnapshotId(), snapshotmetadatachange, snapshot.getContents());
    }

    public final PendingResult resolveConflict(GoogleApiClient googleapiclient, String s, String s1, SnapshotMetadataChange snapshotmetadatachange, Contents contents)
    {
        return googleapiclient.b(new _cls5(s, s1, snapshotmetadatachange, contents));
    }

    private class _cls3 extends CommitImpl
    {
        private class CommitImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
        {

            public com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult Z(Status status)
            {
                class _cls1
                    implements com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult
                {

                    final CommitImpl QN;
                    final Status yG;

                    public SnapshotMetadata getSnapshotMetadata()
                    {
                        return null;
                    }

                    public Status getStatus()
                    {
                        return yG;
                    }

                    _cls1(Status status)
                    {
                        QN = CommitImpl.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls1(status);
            }

            public Result c(Status status)
            {
                return Z(status);
            }

            private CommitImpl()
            {
            }

            CommitImpl(_cls1 _pcls1)
            {
                this();
            }
        }


        final SnapshotsImpl QF;
        final Snapshot QI;
        final SnapshotMetadataChange QJ;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.a(this, QI, QJ);
        }

        _cls3(Snapshot snapshot, SnapshotMetadataChange snapshotmetadatachange)
        {
            QF = SnapshotsImpl.this;
            QI = snapshot;
            QJ = snapshotmetadatachange;
            super(null);
        }
    }


    private class _cls4 extends DeleteImpl
    {
        private class DeleteImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
        {

            public com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult aa(Status status)
            {
                class _cls1
                    implements com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult
                {

                    final DeleteImpl QO;
                    final Status yG;

                    public String getSnapshotId()
                    {
                        return null;
                    }

                    public Status getStatus()
                    {
                        return yG;
                    }

                    _cls1(Status status)
                    {
                        QO = DeleteImpl.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls1(status);
            }

            public Result c(Status status)
            {
                return aa(status);
            }

            private DeleteImpl()
            {
            }

            DeleteImpl(_cls1 _pcls1)
            {
                this();
            }
        }


        final SnapshotsImpl QF;
        final SnapshotMetadata QK;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.j(this, QK.getSnapshotId());
        }

        _cls4(SnapshotMetadata snapshotmetadata)
        {
            QF = SnapshotsImpl.this;
            QK = snapshotmetadata;
            super(null);
        }
    }


    private class _cls1 extends LoadImpl
    {
        private class LoadImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
        {

            public com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult ab(Status status)
            {
                class _cls1
                    implements com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult
                {

                    final LoadImpl QP;
                    final Status yG;

                    public SnapshotMetadataBuffer getSnapshots()
                    {
                        return new SnapshotMetadataBuffer(DataHolder.af(14));
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
                        QP = LoadImpl.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls1(status);
            }

            public Result c(Status status)
            {
                return ab(status);
            }

            private LoadImpl()
            {
            }

            LoadImpl(_cls1 _pcls1)
            {
                this();
            }
        }


        final boolean Pb;
        final SnapshotsImpl QF;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.e(this, Pb);
        }

        _cls1(boolean flag)
        {
            QF = SnapshotsImpl.this;
            Pb = flag;
            super(null);
        }
    }


    private class _cls2 extends OpenImpl
    {
        private class OpenImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
        {

            public com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult ac(Status status)
            {
                class _cls1
                    implements com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
                {

                    final OpenImpl QQ;
                    final Status yG;

                    public String getConflictId()
                    {
                        return null;
                    }

                    public Snapshot getConflictingSnapshot()
                    {
                        return null;
                    }

                    public Contents getResolutionContents()
                    {
                        return null;
                    }

                    public Snapshot getSnapshot()
                    {
                        return null;
                    }

                    public Status getStatus()
                    {
                        return yG;
                    }

                    _cls1(Status status)
                    {
                        QQ = OpenImpl.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls1(status);
            }

            public Result c(Status status)
            {
                return ac(status);
            }

            private OpenImpl()
            {
            }

            OpenImpl(_cls1 _pcls1)
            {
                this();
            }
        }


        final SnapshotsImpl QF;
        final String QG;
        final boolean QH;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.b(this, QG, QH);
        }

        _cls2(String s, boolean flag)
        {
            QF = SnapshotsImpl.this;
            QG = s;
            QH = flag;
            super(null);
        }
    }


    private class _cls5 extends OpenImpl
    {

        final Contents IJ;
        final SnapshotsImpl QF;
        final SnapshotMetadataChange QJ;
        final String QL;
        final String QM;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.a(this, QL, QM, QJ, IJ);
        }

        _cls5(String s, String s1, SnapshotMetadataChange snapshotmetadatachange, Contents contents)
        {
            QF = SnapshotsImpl.this;
            QL = s;
            QM = s1;
            QJ = snapshotmetadatachange;
            IJ = contents;
            super(null);
        }
    }

}
