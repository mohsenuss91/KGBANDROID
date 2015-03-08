// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.support.v4.app.FragmentActivity;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import com.appyet.data.Feed;
import com.appyet.data.FeedItem;
import com.appyet.data.Module;
import com.appyet.f.a;
import com.appyet.manager.d;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataModuleFeed;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.c:
//            r, z, ao, ae

final class an extends a
{

    final r a;
    private List b;

    an(r r1)
    {
        a = r1;
        super();
    }

    private transient Void f()
    {
        if (a.c != null)
        {
            a.a.n.a = a.a.h.g(a.c.longValue());
        }
        com.appyet.c.z.a[a.a.n.g.ordinal()];
        JVM INSTR tableswitch 1 4: default 96
    //                   1 363
    //                   2 411
    //                   3 452
    //                   4 506;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        List list;
        com.appyet.c.r.d(a, b.size());
        list = a.a.h.d();
        a.a.n.e = list;
        if (a.a.n.c == null)
        {
            a.a.n.c = new Hashtable();
        }
        if (a.a.n.d == null)
        {
            a.a.n.d = new Hashtable();
        }
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_547;
        }
        try
        {
            Iterator iterator = list.iterator();
label0:
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Feed feed = (Feed)iterator.next();
                a.a.n.c.put(feed.getFeedId(), feed);
                Iterator iterator1 = a.a.q.MetadataModuleFeeds.iterator();
                MetadataModuleFeed metadatamodulefeed;
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    metadatamodulefeed = (MetadataModuleFeed)iterator1.next();
                } while (!metadatamodulefeed.Guid.equals(feed.getGuid()));
                a.a.n.d.put(feed.getFeedId(), metadatamodulefeed);
            } while (true);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
_L6:
        return null;
_L2:
        b = a.a.h.a(a.c, 100L * (long)(1 + a.a.n.i), 0L);
          goto _L1
_L3:
        b = a.a.h.a(100L * (long)(1 + a.a.n.i), 0L);
          goto _L1
_L4:
        b = a.a.h.a(a.a.n.h, 100L * (long)(1 + a.a.n.i), 0L);
          goto _L1
_L5:
        b = a.a.n.a(100L * (long)(1 + a.a.n.i), 0L);
          goto _L1
        a.a.n.c.clear();
          goto _L6
    }

    protected final void a()
    {
        super.a();
        com.appyet.c.r.d(a).setVisibility(8);
        r.c(a);
    }

    protected final void a(Object obj)
    {
        int i;
        i = 0;
        super.a((Void)obj);
        ao ao1 = com.appyet.c.r.a(a, b);
        if (ao1 == null) goto _L2; else goto _L1
_L1:
        if (com.appyet.c.r.a(a) == null || ao1.c != 1) goto _L2; else goto _L3
_L3:
        FeedItem feeditem2;
        for (Iterator iterator = ao1.a.iterator(); iterator.hasNext(); com.appyet.c.r.a(a).add(feeditem2))
        {
            feeditem2 = (FeedItem)iterator.next();
        }

          goto _L4
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
_L11:
        r.j(a);
        return;
_L4:
        FeedItem feeditem1;
        for (Iterator iterator1 = ao1.b.iterator(); iterator1.hasNext(); com.appyet.c.r.a(a).remove(feeditem1))
        {
            feeditem1 = (FeedItem)iterator1.next();
        }

_L2:
        if (com.appyet.c.r.a(a) != null && !com.appyet.c.r.a(a).isEmpty()) goto _L6; else goto _L5
_L5:
        com.appyet.c.r.d(a).setVisibility(0);
        com.appyet.c.r.d(a).setText(a.getString(0x7f08005b));
        r.e(a).setVisibility(8);
        com.appyet.c.r.f(a).setVisibility(8);
_L10:
        if (a.a.n.b != null) goto _L8; else goto _L7
_L7:
        a.a.n.b = new ArrayList();
_L9:
        if (i >= com.appyet.c.r.a(a).getCount())
        {
            break MISSING_BLOCK_LABEL_518;
        }
        FeedItem feeditem = (FeedItem)com.appyet.c.r.a(a).getItem(i);
        feeditem.setFlag(com.appyet.data.FeedItem.FlagEnum.None);
        a.a.n.b.add(feeditem);
        i++;
          goto _L9
_L6:
label0:
        {
            com.appyet.c.r.d(a).setVisibility(8);
            if (a.a.n.a == null || a.a.n.a.getLayout() == null || !a.a.n.a.getLayout().equals("GRID"))
            {
                break label0;
            }
            r.e(a).setVisibility(8);
            com.appyet.c.r.f(a).setVisibility(0);
            com.appyet.c.r.f(a).setAdapter(com.appyet.c.r.a(a));
        }
          goto _L10
        r.e(a).setVisibility(0);
        com.appyet.c.r.f(a).setVisibility(8);
        r.e(a).setAdapter(com.appyet.c.r.a(a));
          goto _L10
_L8:
        a.a.n.b.clear();
        i = 0;
          goto _L9
        a.a();
        r.b(a);
        com.appyet.c.r.a(a, a.getActivity().getIntent());
        r.g(a);
        if ((long)a.a.n.b.size() >= 100L)
        {
            break MISSING_BLOCK_LABEL_621;
        }
        a.a.n.j = true;
_L12:
        r.h(a);
        r.i(a);
        a.d();
          goto _L11
        a.a.n.j = false;
          goto _L12
    }

    protected final Object b()
    {
        return f();
    }
}
