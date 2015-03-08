// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.b.a.a;
import com.appyet.b.a.ay;
import com.appyet.b.a.u;
import com.appyet.b.a.v;
import com.appyet.b.a.w;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.d.f;
import com.appyet.data.Feed;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.appyet.manager:
//            bq, ProgressNotificationManager

final class bt
    implements Runnable
{

    final bq a;
    private final Feed b;
    private ApplicationContext c;

    bt(bq bq1, ApplicationContext applicationcontext, Feed feed)
    {
        a = bq1;
        super();
        c = applicationcontext;
        b = feed;
    }

    public final void run()
    {
        if (!com.appyet.manager.bq.a(a)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (b.getFeedType() != com.appyet.data.Feed.FeedTypeEnum.RSS) goto _L4; else goto _L3
_L3:
        u u1 = (new ay(c)).a(b);
_L9:
        if (u1 == null) goto _L6; else goto _L5
_L5:
        if (u1.a != v.b && u1.b != null && u1.b.getFeedItems() != null) goto _L7; else goto _L6
_L6:
        com.appyet.manager.bq.f(a);
        bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L1; else goto _L8
_L8:
        ProgressNotificationManager progressnotificationmanager;
        int i;
        String s;
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        i = bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080055)).append(" (").append(bq.c(a).get()).append("/").append(bq.e(a).get()).append(") ").append(f.a((float)bq.c(a).get() / (float)bq.e(a).get())).toString();
_L15:
        progressnotificationmanager.a(i, s);
        return;
_L4:
label0:
        {
            if (b.getFeedType() != com.appyet.data.Feed.FeedTypeEnum.ATOM)
            {
                break label0;
            }
            u1 = (new a(c)).a(b);
        }
          goto _L9
label1:
        {
            if (b.getFeedType() != com.appyet.data.Feed.FeedTypeEnum.RDF)
            {
                break label1;
            }
            u1 = (new w(c)).a(b);
        }
          goto _L9
        u1 = (new ay(c)).a(b);
        if (u1 == null)
        {
            break MISSING_BLOCK_LABEL_353;
        }
        if (u1.a == v.a)
        {
            u1.b.setFeedType(com.appyet.data.Feed.FeedTypeEnum.RSS);
        }
        if (u1 == null)
        {
            break MISSING_BLOCK_LABEL_369;
        }
        if (u1.a != v.b)
        {
            break MISSING_BLOCK_LABEL_416;
        }
        u1 = (new a(c)).a(b);
        if (u1 == null)
        {
            break MISSING_BLOCK_LABEL_416;
        }
        if (u1.a == v.a)
        {
            u1.b.setFeedType(com.appyet.data.Feed.FeedTypeEnum.ATOM);
        }
        if (u1 == null) goto _L11; else goto _L10
_L10:
        if (u1.a != v.b) goto _L9; else goto _L11
_L11:
        u1 = (new w(c)).a(b);
        if (u1 == null) goto _L9; else goto _L12
_L12:
        if (u1.a != v.a) goto _L9; else goto _L13
_L13:
        u1.b.setFeedType(com.appyet.data.Feed.FeedTypeEnum.RDF);
          goto _L9
        Exception exception1;
        exception1;
        com.appyet.manager.bq.f(a);
        d.a(exception1);
        bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L1; else goto _L14
_L14:
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        i = bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080055)).append(" (").append(bq.c(a).get()).append("/").append(bq.e(a).get()).append(") ").append(f.a((float)bq.c(a).get() / (float)bq.e(a).get())).toString();
          goto _L15
_L7:
        v v1;
        v v2;
        v1 = u1.a;
        v2 = v.c;
        if (v1 != v2)
        {
            break MISSING_BLOCK_LABEL_796;
        }
        bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L1; else goto _L16
_L16:
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        i = bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080055)).append(" (").append(bq.c(a).get()).append("/").append(bq.e(a).get()).append(") ").append(f.a((float)bq.c(a).get() / (float)bq.e(a).get())).toString();
          goto _L15
        boolean flag;
        Feed feed = u1.b;
        feed.setFeedId(b.getFeedId());
        flag = com.appyet.manager.bq.a(a, feed);
        bq.b(a, feed);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_857;
        }
        com.appyet.manager.bq.a(a, Long.valueOf(b.getModuleId()));
        bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L1; else goto _L17
_L17:
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        i = bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080055)).append(" (").append(bq.c(a).get()).append("/").append(bq.e(a).get()).append(") ").append(f.a((float)bq.c(a).get() / (float)bq.e(a).get())).toString();
          goto _L15
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        d.a(outofmemoryerror);
        bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) == null) goto _L1; else goto _L18
_L18:
        progressnotificationmanager = com.appyet.manager.bq.d(a);
        i = bq.c(a).get();
        s = (new StringBuilder()).append(c.getString(0x7f080055)).append(" (").append(bq.c(a).get()).append("/").append(bq.e(a).get()).append(") ").append(f.a((float)bq.c(a).get() / (float)bq.e(a).get())).toString();
          goto _L15
        Exception exception;
        exception;
        bq.c(a).incrementAndGet();
        if (com.appyet.manager.bq.d(a) != null)
        {
            com.appyet.manager.bq.d(a).a(bq.c(a).get(), (new StringBuilder()).append(c.getString(0x7f080055)).append(" (").append(bq.c(a).get()).append("/").append(bq.e(a).get()).append(") ").append(f.a((float)bq.c(a).get() / (float)bq.e(a).get())).toString());
        }
        throw exception;
    }
}
