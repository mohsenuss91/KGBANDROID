// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

// Referenced classes of package com.google.android.gms.drive.internal:
//            v

public class s extends v
    implements DriveFile
{

    public s(DriveId driveid)
    {
        super(driveid);
    }

    public PendingResult commitAndCloseContents(GoogleApiClient googleapiclient, Contents contents)
    {
        if (contents == null)
        {
            throw new IllegalArgumentException("Contents must be provided.");
        } else
        {
            return googleapiclient.b(new _cls2(contents));
        }
    }

    public PendingResult commitAndCloseContents(GoogleApiClient googleapiclient, Contents contents, MetadataChangeSet metadatachangeset)
    {
        if (contents == null)
        {
            throw new IllegalArgumentException("Contents must be provided.");
        } else
        {
            return googleapiclient.b(new _cls3(contents, metadatachangeset));
        }
    }

    public PendingResult discardContents(GoogleApiClient googleapiclient, Contents contents)
    {
        return Drive.DriveApi.discardContents(googleapiclient, contents);
    }

    public PendingResult openContents(GoogleApiClient googleapiclient, int i, com.google.android.gms.drive.DriveFile.DownloadProgressListener downloadprogresslistener)
    {
        if (i != 0x10000000 && i != 0x20000000 && i != 0x30000000)
        {
            throw new IllegalArgumentException("Invalid mode provided.");
        } else
        {
            return googleapiclient.a(new _cls1(i, downloadprogresslistener));
        }
    }

    private class _cls2 extends b
    {
        private class b extends q
        {

            final s IZ;

            public Result c(Status status)
            {
                return d(status);
            }

            public Status d(Status status)
            {
                return status;
            }

            private b()
            {
                IZ = s.this;
                super();
            }

            b(_cls1 _pcls1)
            {
                this();
            }
        }


        final Contents IJ;
        final s IZ;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((r)a1);
        }

        protected void a(r r1)
        {
            IJ.close();
            r1.gk().a(new CloseContentsRequest(IJ, true), new aw(this));
        }

        _cls2(Contents contents)
        {
            IZ = s.this;
            IJ = contents;
            super(null);
        }
    }


    private class _cls3 extends a
    {
        private class a extends q
        {

            final s IZ;

            public Result c(Status status)
            {
                return d(status);
            }

            public Status d(Status status)
            {
                return status;
            }

            private a()
            {
                IZ = s.this;
                super();
            }

            a(_cls1 _pcls1)
            {
                this();
            }
        }


        final Contents IJ;
        final s IZ;
        final MetadataChangeSet Ja;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((r)a1);
        }

        protected void a(r r1)
        {
            IJ.close();
            r1.gk().a(new CloseContentsAndUpdateMetadataRequest(IZ.Hw, Ja.gh(), IJ, false, null), new aw(this));
        }

        _cls3(Contents contents, MetadataChangeSet metadatachangeset)
        {
            IZ = s.this;
            IJ = contents;
            Ja = metadatachangeset;
            super(null);
        }
    }


    private class _cls1 extends d
    {
        private class d extends q
        {

            final s IZ;

            public Result c(Status status)
            {
                return q(status);
            }

            public com.google.android.gms.drive.DriveApi.ContentsResult q(Status status)
            {
                return new p.a(status, null);
            }

            private d()
            {
                IZ = s.this;
                super();
            }

            d(_cls1 _pcls1)
            {
                this();
            }
        }


        final int IX;
        final com.google.android.gms.drive.DriveFile.DownloadProgressListener IY;
        final s IZ;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((r)a1);
        }

        protected void a(r r1)
        {
            r1.gk().a(new OpenContentsRequest(IZ.getDriveId(), IX), new c(this, IY));
        }

        _cls1(int i, com.google.android.gms.drive.DriveFile.DownloadProgressListener downloadprogresslistener)
        {
            IZ = s.this;
            IX = i;
            IY = downloadprogresslistener;
            super(null);
        }

        private class c extends com.google.android.gms.drive.internal.c
        {

            private final com.google.android.gms.drive.DriveFile.DownloadProgressListener Jb;
            private final com.google.android.gms.common.api.a.d yO;

            public void a(OnContentsResponse oncontentsresponse)
            {
                yO.a(new p.a(Status.Ek, oncontentsresponse.go()));
            }

            public void a(OnDownloadProgressResponse ondownloadprogressresponse)
            {
                if (Jb != null)
                {
                    Jb.onProgress(ondownloadprogressresponse.gp(), ondownloadprogressresponse.gq());
                }
            }

            public void o(Status status)
            {
                yO.a(new p.a(status, null));
            }

            public c(com.google.android.gms.common.api.a.d d1, com.google.android.gms.drive.DriveFile.DownloadProgressListener downloadprogresslistener)
            {
                yO = d1;
                Jb = downloadprogresslistener;
            }
        }

    }

}
