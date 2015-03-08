// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.a.d;
import com.appyet.a.f;
import com.appyet.context.ApplicationContext;
import com.appyet.data.FileCache;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.appyet.manager:
//            bq, bl, bo, bp, 
//            al, d, ProgressNotificationManager

final class bu
    implements Runnable
{

    final bq a;
    private final FileCache b;
    private ApplicationContext c;

    bu(bq bq1, ApplicationContext applicationcontext, FileCache filecache)
    {
        a = bq1;
        super();
        c = applicationcontext;
        b = filecache;
    }

    public final void run()
    {
_L2:
        return;
        if (bq.a(a) || c.g.a() == bo.a) goto _L2; else goto _L1
_L1:
        if (!c.d.t())
        {
            break; /* Loop/switch isn't completed */
        }
        c;
        if (!ApplicationContext.a()) goto _L2; else goto _L3
_L3:
        f f1 = null;
        boolean flag;
        b.setDownloadAttempt(Integer.valueOf(1 + b.getDownloadAttempt().intValue()));
        flag = c.j.g(b.getFileCacheName());
        f1 = null;
        if (flag) goto _L5; else goto _L4
_L4:
        d d1 = new d();
        d1.a = b.getFileLink();
        f1 = c.g.a(d1);
        c.g;
        if (!bl.a(f1)) goto _L7; else goto _L6
_L6:
        String s1 = f1.c;
        Exception exception;
        OutOfMemoryError outofmemoryerror;
        ProgressNotificationManager progressnotificationmanager;
        int i;
        String s;
        Exception exception1;
        boolean flag1;
        if (!s1.contains("image/png") && !s1.contains("image/gif") && !s1.contains("image/jpeg") && !s1.contains("image/jpg") && !s1.contains("image/x-icon"))
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        if (!flag1) goto _L9; else goto _L8
_L8:
        if (f1.e < -1L || f1.e > (long)(1024 * c.d.A())) goto _L11; else goto _L10
_L10:
        if (c.j.a(f1.b, b.getFileCacheName()))
        {
            bl.b(f1);
            b.setDownloadStatus(com.appyet.data.FileCache.DownloadStatusEnum.Success);
            if (b.getFileType() == com.appyet.data.FileCache.FileTypeEnum.Thumbnail)
            {
                a;
                b.getFileCacheName();
                bq.e();
            }
        }
_L7:
        if (b.getDownloadAttempt().intValue() > 5 && b.getDownloadStatus() == com.appyet.data.FileCache.DownloadStatusEnum.Pending)
        {
            b.setDownloadStatus(com.appyet.data.FileCache.DownloadStatusEnum.Failed);
        }
        c.h.b(b);
        bl.b(f1);
        bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L2; else goto _L12
_L12:
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        i = bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080054)).append(" (").append(bq.c(a).get()).append("/").append(bq.e(a).get()).append(") ").append(com.appyet.d.f.a((float)bq.c(a).get() / (float)bq.e(a).get())).toString();
_L14:
        progressnotificationmanager.a(i, s);
        return;
_L11:
        b.setDownloadStatus(com.appyet.data.FileCache.DownloadStatusEnum.Ignore);
          goto _L7
        exception1;
        com.appyet.d.d.a(exception1);
        bl.b(f1);
        bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L2; else goto _L13
_L13:
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        i = bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080054)).append(" (").append(bq.c(a).get()).append("/").append(bq.e(a).get()).append(") ").append(com.appyet.d.f.a((float)bq.c(a).get() / (float)bq.e(a).get())).toString();
          goto _L14
_L9:
        b.setDownloadStatus(com.appyet.data.FileCache.DownloadStatusEnum.Ignore);
          goto _L7
        outofmemoryerror;
        com.appyet.d.d.a(outofmemoryerror);
        bl.b(f1);
        bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L2; else goto _L15
_L15:
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        i = bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080054)).append(" (").append(bq.c(a).get()).append("/").append(bq.e(a).get()).append(") ").append(com.appyet.d.f.a((float)bq.c(a).get() / (float)bq.e(a).get())).toString();
          goto _L14
_L5:
        b.setDownloadStatus(com.appyet.data.FileCache.DownloadStatusEnum.Success);
        f1 = null;
          goto _L7
        exception;
        bl.b(f1);
        bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) != null)
        {
            com.appyet.manager.bq.d(a).a(bq.c(a).get(), (new StringBuilder()).append(c.getString(0x7f080054)).append(" (").append(bq.c(a).get()).append("/").append(bq.e(a).get()).append(") ").append(com.appyet.d.f.a((float)bq.c(a).get() / (float)bq.e(a).get())).toString());
        }
        throw exception;
    }
}
