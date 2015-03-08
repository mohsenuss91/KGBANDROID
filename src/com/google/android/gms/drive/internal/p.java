// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;

// Referenced classes of package com.google.android.gms.drive.internal:
//            r, u, s

public class p
    implements DriveApi
{

    public p()
    {
    }

    public PendingResult discardContents(GoogleApiClient googleapiclient, Contents contents)
    {
        return googleapiclient.b(new _cls3(contents));
    }

    public PendingResult fetchDriveId(GoogleApiClient googleapiclient, String s1)
    {
        return googleapiclient.a(new _cls4(s1));
    }

    public DriveFolder getAppFolder(GoogleApiClient googleapiclient)
    {
        if (!googleapiclient.isConnected())
        {
            throw new IllegalStateException("Client must be connected");
        }
        DriveId driveid = ((r)googleapiclient.a(Drive.yE)).gm();
        if (driveid != null)
        {
            return new u(driveid);
        } else
        {
            return null;
        }
    }

    public DriveFile getFile(GoogleApiClient googleapiclient, DriveId driveid)
    {
        if (driveid == null)
        {
            throw new IllegalArgumentException("Id must be provided.");
        }
        if (!googleapiclient.isConnected())
        {
            throw new IllegalStateException("Client must be connected");
        } else
        {
            return new s(driveid);
        }
    }

    public DriveFolder getFolder(GoogleApiClient googleapiclient, DriveId driveid)
    {
        if (driveid == null)
        {
            throw new IllegalArgumentException("Id must be provided.");
        }
        if (!googleapiclient.isConnected())
        {
            throw new IllegalStateException("Client must be connected");
        } else
        {
            return new u(driveid);
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient googleapiclient)
    {
        if (!googleapiclient.isConnected())
        {
            throw new IllegalStateException("Client must be connected");
        } else
        {
            return new u(((r)googleapiclient.a(Drive.yE)).gl());
        }
    }

    public PendingResult newContents(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new _cls2());
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder()
    {
        return new CreateFileActivityBuilder();
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder()
    {
        return new OpenFileActivityBuilder();
    }

    public PendingResult query(GoogleApiClient googleapiclient, Query query1)
    {
        if (query1 == null)
        {
            throw new IllegalArgumentException("Query must be provided.");
        } else
        {
            return googleapiclient.a(new _cls1(query1));
        }
    }

    public PendingResult requestSync(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new _cls5());
    }

    private class _cls3 extends j
    {
        private class j extends q
        {

            public Result c(Status status)
            {
                return d(status);
            }

            public Status d(Status status)
            {
                return status;
            }

            j()
            {
            }
        }


        final p II;
        final Contents IJ;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((r)a1);
        }

        protected void a(r r1)
        {
            r1.gk().a(new CloseContentsRequest(IJ, false), new aw(this));
        }

        _cls3(Contents contents)
        {
            II = p.this;
            IJ = contents;
            super();
        }
    }


    private class _cls4 extends d
    {
        private class d extends q
        {

            final p II;

            public Result c(Status status)
            {
                return p(status);
            }

            public com.google.android.gms.drive.DriveApi.DriveIdResult p(Status status)
            {
                return new c(status, null);
            }

            d()
            {
                II = p.this;
                super();
            }

            private class c
                implements com.google.android.gms.drive.DriveApi.DriveIdResult
            {

                private final DriveId Hw;
                private final Status yw;

                public DriveId getDriveId()
                {
                    return Hw;
                }

                public Status getStatus()
                {
                    return yw;
                }

                public c(Status status, DriveId driveid)
                {
                    yw = status;
                    Hw = driveid;
                }
            }

        }


        final p II;
        final String IK;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((r)a1);
        }

        protected void a(r r1)
        {
            r1.gk().a(new GetMetadataRequest(DriveId.aL(IK)), new b(this));
        }

        _cls4(String s1)
        {
            II = p.this;
            IK = s1;
            super();
        }

        private class b extends com.google.android.gms.drive.internal.c
        {

            private final com.google.android.gms.common.api.a.d yO;

            public void a(OnDriveIdResponse ondriveidresponse)
            {
                yO.a(new c(Status.Ek, ondriveidresponse.getDriveId()));
            }

            public void a(OnMetadataResponse onmetadataresponse)
            {
                yO.a(new c(Status.Ek, (new com.google.android.gms.drive.internal.l(onmetadataresponse.gw())).getDriveId()));
            }

            public void o(Status status)
            {
                yO.a(new c(status, null));
            }

            public b(com.google.android.gms.common.api.a.d d1)
            {
                yO = d1;
            }
        }

    }


    private class _cls2 extends g
    {
        private class g extends q
        {

            final p II;

            public Result c(Status status)
            {
                return q(status);
            }

            public com.google.android.gms.drive.DriveApi.ContentsResult q(Status status)
            {
                return new a(status, null);
            }

            g()
            {
                II = p.this;
                super();
            }

            private class a
                implements com.google.android.gms.drive.DriveApi.ContentsResult
            {

                private final Contents HD;
                private final Status yw;

                public Contents getContents()
                {
                    return HD;
                }

                public Status getStatus()
                {
                    return yw;
                }

                public a(Status status, Contents contents)
                {
                    yw = status;
                    HD = contents;
                }
            }

        }


        final p II;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((r)a1);
        }

        protected void a(r r1)
        {
            r1.gk().a(new CreateContentsRequest(), new f(this));
        }

        _cls2()
        {
            II = p.this;
            super();
        }

        private class f extends com.google.android.gms.drive.internal.c
        {

            private final com.google.android.gms.common.api.a.d yO;

            public void a(OnContentsResponse oncontentsresponse)
            {
                yO.a(new a(Status.Ek, oncontentsresponse.go()));
            }

            public void o(Status status)
            {
                yO.a(new a(status, null));
            }

            public f(com.google.android.gms.common.api.a.d d)
            {
                yO = d;
            }
        }

    }


    private class _cls1 extends i
    {
        private class i extends q
        {

            final p II;

            public Result c(Status status)
            {
                return r(status);
            }

            public com.google.android.gms.drive.DriveApi.MetadataBufferResult r(Status status)
            {
                return new e(status, null, false);
            }

            i()
            {
                II = p.this;
                super();
            }

            private class e
                implements com.google.android.gms.drive.DriveApi.MetadataBufferResult
            {

                private final MetadataBuffer IL;
                private final boolean IM;
                private final Status yw;

                public MetadataBuffer getMetadataBuffer()
                {
                    return IL;
                }

                public Status getStatus()
                {
                    return yw;
                }

                public e(Status status, MetadataBuffer metadatabuffer, boolean flag)
                {
                    yw = status;
                    IL = metadatabuffer;
                    IM = flag;
                }
            }

        }


        final Query IH;
        final p II;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((r)a1);
        }

        protected void a(r r1)
        {
            r1.gk().a(new QueryRequest(IH), new h(this));
        }

        _cls1(Query query1)
        {
            II = p.this;
            IH = query1;
            super();
        }

        private class h extends com.google.android.gms.drive.internal.c
        {

            private final com.google.android.gms.common.api.a.d yO;

            public void a(OnListEntriesResponse onlistentriesresponse)
            {
                MetadataBuffer metadatabuffer = new MetadataBuffer(onlistentriesresponse.gt(), null);
                yO.a(new e(Status.Ek, metadatabuffer, onlistentriesresponse.gu()));
            }

            public void o(Status status)
            {
                yO.a(new e(status, null, false));
            }

            public h(com.google.android.gms.common.api.a.d d)
            {
                yO = d;
            }
        }

    }


    private class _cls5 extends l
    {
        private class l extends q
        {

            final p II;

            public Result c(Status status)
            {
                return d(status);
            }

            public Status d(Status status)
            {
                return status;
            }

            l()
            {
                II = p.this;
                super();
            }
        }


        final p II;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((r)a1);
        }

        protected void a(r r1)
        {
            r1.gk().a(new aw(this));
        }

        _cls5()
        {
            II = p.this;
            super();
        }
    }

}
