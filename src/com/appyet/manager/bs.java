// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.a.d;
import com.appyet.context.ApplicationContext;
import com.appyet.context.b;
import com.appyet.d.c;
import com.appyet.d.e;
import com.appyet.d.f;
import com.appyet.data.DatabaseHelper;
import com.appyet.data.FeedItem;
import com.appyet.data.FileCache;
import com.appyet.f.z;
import com.j256.ormlite.misc.TransactionManager;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.appyet.manager:
//            bq, bl, bo, d, 
//            ProgressNotificationManager, bp, i, q

final class bs
    implements Runnable
{

    final bq a;
    private final FeedItem b;
    private ApplicationContext c;

    bs(bq bq1, ApplicationContext applicationcontext, FeedItem feeditem)
    {
        a = bq1;
        super();
        c = applicationcontext;
        b = feeditem;
    }

    public final void run()
    {
        com.appyet.a.f f1;
        f1 = null;
        break MISSING_BLOCK_LABEL_2;
_L4:
        do
        {
            return;
        } while (bq.a(a) || c.g.a() == bo.a);
        if (b.getLink() != null) goto _L2; else goto _L1
_L1:
        c.h.a(b.getFeedItemId(), com.appyet.data.FeedItem.ArticleStatusEnum.None);
        com.appyet.manager.bl.b(null);
        com.appyet.manager.bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L4; else goto _L3
_L3:
        ProgressNotificationManager progressnotificationmanager;
        int j;
        String s;
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        j = com.appyet.manager.bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080057)).append(" (").append(com.appyet.manager.bq.c(a).get()).append("/").append(com.appyet.manager.bq.e(a).get()).append(") ").append(f.a((float)com.appyet.manager.bq.c(a).get() / (float)com.appyet.manager.bq.e(a).get())).toString();
_L11:
        progressnotificationmanager.a(j, s);
        return;
_L2:
        d d1 = new d();
        if (c.d.z() != b.b) goto _L6; else goto _L5
_L5:
        d1.a = (new StringBuilder("http://www.google.com/gwt/x?u=")).append(URLEncoder.encode(b.getLink(), "UTF-8")).toString();
_L12:
        com.appyet.a.f f3 = c.g.a(d1);
        com.appyet.a.f f2 = f3;
        if (f2 == null) goto _L8; else goto _L7
_L7:
        int i1 = f2.f;
        if (i1 != 504) goto _L8; else goto _L9
_L9:
        com.appyet.manager.bl.b(f2);
        com.appyet.manager.bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L4; else goto _L10
_L10:
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        j = com.appyet.manager.bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080057)).append(" (").append(com.appyet.manager.bq.c(a).get()).append("/").append(com.appyet.manager.bq.e(a).get()).append(") ").append(f.a((float)com.appyet.manager.bq.c(a).get() / (float)com.appyet.manager.bq.e(a).get())).toString();
          goto _L11
_L6:
        d1.a = (new StringBuilder("http://www.instapaper.com/m?u=")).append(URLEncoder.encode(b.getLink(), "UTF-8")).toString();
          goto _L12
        Exception exception1;
        exception1;
_L46:
        c.h.a(b.getFeedItemId(), com.appyet.data.FeedItem.ArticleStatusEnum.None);
        com.appyet.d.d.a(exception1);
        com.appyet.manager.bl.b(f1);
        com.appyet.manager.bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L4; else goto _L13
_L13:
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        j = com.appyet.manager.bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080057)).append(" (").append(com.appyet.manager.bq.c(a).get()).append("/").append(com.appyet.manager.bq.e(a).get()).append(") ").append(f.a((float)com.appyet.manager.bq.c(a).get() / (float)com.appyet.manager.bq.e(a).get())).toString();
          goto _L11
_L8:
        c.g;
        if (!bl.a(f2)) goto _L15; else goto _L14
_L14:
        if (!f2.c.contains("text/html")) goto _L17; else goto _L16
_L16:
        byte abyte0[];
        abyte0 = com.appyet.d.b.a(f2.b);
        com.appyet.manager.bl.b(f2);
        if (f2.d == null || f2.d.equals("")) goto _L19; else goto _L18
_L18:
        String s1 = f2.d;
_L33:
        String s2 = com.appyet.d.b.a(abyte0, s1);
        if (s2 == null) goto _L15; else goto _L20
_L20:
        int k;
        int l;
        k = s2.indexOf("<div id=\"story\">");
        l = s2.indexOf("<div id=\"footer\">");
        if (k < 0) goto _L22; else goto _L21
_L21:
        if (k >= s2.length() || l < 0) goto _L22; else goto _L23
_L23:
        if (l >= s2.length() || k >= l) goto _L22; else goto _L24
_L24:
        String s3 = s2.substring(k, l);
_L34:
        if (s3 == null) goto _L26; else goto _L25
_L25:
        com.appyet.manager.d d2;
        FeedItem feeditem;
        d2 = c.h;
        feeditem = b;
        TransactionManager.callInTransaction(d2.b.getConnectionSource(), new i(d2, s3, feeditem));
_L35:
        ArrayList arraylist1;
        Iterator iterator;
        ArrayList arraylist = com.appyet.d.c.a(s3);
        arraylist1 = new ArrayList();
        iterator = arraylist.iterator();
_L38:
        if (!iterator.hasNext()) goto _L28; else goto _L27
_L27:
        String s4 = (String)iterator.next();
        if (s4 != null) goto _L30; else goto _L29
_L29:
        com.appyet.manager.bl.b(f2);
        com.appyet.manager.bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L4; else goto _L31
_L31:
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        j = com.appyet.manager.bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080057)).append(" (").append(com.appyet.manager.bq.c(a).get()).append("/").append(com.appyet.manager.bq.e(a).get()).append(") ").append(f.a((float)com.appyet.manager.bq.c(a).get() / (float)com.appyet.manager.bq.e(a).get())).toString();
          goto _L11
_L19:
        s1 = com.appyet.d.b.a(abyte0);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_1902;
        }
        if (!s1.equals("")) goto _L33; else goto _L32
_L32:
        break MISSING_BLOCK_LABEL_1902;
_L22:
        c.h.a(b.getFeedItemId(), com.appyet.data.FeedItem.ArticleStatusEnum.None);
        s3 = null;
          goto _L34
        Exception exception2;
        exception2;
        com.appyet.d.d.a(exception2);
          goto _L35
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
_L45:
        com.appyet.d.d.a(outofmemoryerror);
        com.appyet.manager.bl.b(f2);
        com.appyet.manager.bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L4; else goto _L36
_L36:
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        j = com.appyet.manager.bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080057)).append(" (").append(com.appyet.manager.bq.c(a).get()).append("/").append(com.appyet.manager.bq.e(a).get()).append(") ").append(f.a((float)com.appyet.manager.bq.c(a).get() / (float)com.appyet.manager.bq.e(a).get())).toString();
          goto _L11
_L30:
        String s5;
        s5 = z.a(s4);
        if (s5.startsWith("http://") || s5.startsWith("https://"))
        {
            break MISSING_BLOCK_LABEL_1306;
        }
        if (!s5.startsWith("//")) goto _L38; else goto _L37
_L37:
        s5 = (new StringBuilder("http:")).append(s5).toString();
        boolean flag;
        a;
        flag = bq.a(s5);
        if (!flag) goto _L38; else goto _L39
_L39:
        new URL(s5);
        FileCache filecache;
        filecache = new FileCache();
        String s6 = e.a(s5);
        filecache.setDownloadAttempt(Integer.valueOf(0));
        filecache.setDownloadStatus(com.appyet.data.FileCache.DownloadStatusEnum.Pending);
        filecache.setFileLink(s5);
        filecache.setFileType(com.appyet.data.FileCache.FileTypeEnum.Image);
        filecache.setFileCacheName(s6);
        filecache.setCacheGuid(b.getCacheGuid());
        if (b.getThumbnail() != null) goto _L41; else goto _L40
_L40:
        com.appyet.manager.d d3;
        Long long1;
        b.setThumbnail(s5);
        d3 = c.h;
        long1 = b.getFeedItemId();
        TransactionManager.callInTransaction(d3.b.getConnectionSource(), new q(d3, s5, long1));
_L42:
        filecache.setFileType(com.appyet.data.FileCache.FileTypeEnum.Thumbnail);
_L41:
        arraylist1.add(filecache);
        com.appyet.manager.bq.b(a);
          goto _L38
        Exception exception3;
        exception3;
        com.appyet.d.d.a(exception3);
          goto _L38
        Exception exception;
        exception;
_L44:
        com.appyet.manager.bl.b(f2);
        com.appyet.manager.bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) != null)
        {
            com.appyet.manager.bq.d(a).a(com.appyet.manager.bq.c(a).get(), (new StringBuilder()).append(c.getString(0x7f080057)).append(" (").append(com.appyet.manager.bq.c(a).get()).append("/").append(com.appyet.manager.bq.e(a).get()).append(") ").append(f.a((float)com.appyet.manager.bq.c(a).get() / (float)com.appyet.manager.bq.e(a).get())).toString());
        }
        throw exception;
        Exception exception6;
        exception6;
        com.appyet.d.d.a(exception6);
          goto _L38
        OutOfMemoryError outofmemoryerror1;
        outofmemoryerror1;
        com.appyet.d.d.a(outofmemoryerror1);
          goto _L38
        Exception exception5;
        exception5;
        com.appyet.d.d.a(exception5);
          goto _L42
        Exception exception4;
        exception4;
        throw exception4;
_L28:
        c.h.b(arraylist1);
_L15:
        com.appyet.manager.bl.b(f2);
        com.appyet.manager.bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L4; else goto _L43
_L43:
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        j = com.appyet.manager.bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080057)).append(" (").append(com.appyet.manager.bq.c(a).get()).append("/").append(com.appyet.manager.bq.e(a).get()).append(") ").append(f.a((float)com.appyet.manager.bq.c(a).get() / (float)com.appyet.manager.bq.e(a).get())).toString();
          goto _L11
_L26:
        c.h.a(b.getFeedItemId(), com.appyet.data.FeedItem.ArticleStatusEnum.None);
          goto _L15
_L17:
        c.h.a(b.getFeedItemId(), com.appyet.data.FeedItem.ArticleStatusEnum.None);
          goto _L15
        exception;
        f2 = null;
          goto _L44
        exception;
        f2 = f1;
          goto _L44
        outofmemoryerror;
        f2 = null;
          goto _L45
        s1 = "utf-8";
          goto _L33
        exception1;
        f1 = f2;
          goto _L46
    }
}
