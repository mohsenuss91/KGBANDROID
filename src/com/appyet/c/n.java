// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.content.Intent;
import android.widget.ProgressBar;
import com.appyet.activity.ImageViewerActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import com.appyet.d.e;
import com.appyet.data.FeedItem;
import com.appyet.data.FileCache;
import com.appyet.f.a;
import com.appyet.f.aa;
import com.appyet.manager.al;
import com.appyet.manager.bp;
import com.appyet.manager.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.c:
//            k

final class n extends a
{

    String a;
    final k b;

    public n(k k1, String s)
    {
        b = k1;
        super();
        a = s;
    }

    private transient Void f()
    {
        int i = 0;
        String s1;
        String s3;
        String s = a;
        s1 = s.substring(3 + s.indexOf("///"));
        if (!s1.startsWith("http://") && !s1.startsWith("https://") && s1.startsWith("//"))
        {
            s1 = (new StringBuilder("http:")).append(s1).toString();
        }
        if (!s1.startsWith("/") || s1.startsWith("//"))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        s3 = aa.a(a);
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        s1 = (new StringBuilder()).append(s3).append(s1).toString();
        String s2;
        FeedItem feeditem;
        ArrayList arraylist;
        Iterator iterator;
        s2 = e.a(s1);
        feeditem = (FeedItem)k.c(b).n.b.get(k.j(b));
        List list = k.c(b).h.a(feeditem.getCacheGuid());
        arraylist = new ArrayList();
        iterator = list.iterator();
        int j = 0;
_L2:
        FileCache filecache;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        filecache = (FileCache)iterator.next();
        if (!k.c(b).j.a(filecache.getFileCacheName(), k.c(b).d.B()))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (s2.equals(filecache.getFileCacheName()))
        {
            i = j;
        }
        j++;
        arraylist.add(filecache.getFileLink());
        Exception exception;
        if (true) goto _L2; else goto _L1
_L4:
        return null;
_L1:
        if (j > 0)
        {
            try
            {
                Intent intent = new Intent(k.c(b), com/appyet/activity/ImageViewerActivity);
                intent.putExtra("SHARE_TITLE", feeditem.getTitle());
                intent.putExtra("SHARE_URL", feeditem.getLink());
                intent.putExtra("SELECTED_POSITION", i);
                intent.putStringArrayListExtra("IMAGE_LINKS", arraylist);
                k.c(b).startActivity(intent);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                com.appyet.d.d.a(exception);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final void a()
    {
        k.i(b).setVisibility(0);
    }

    protected final void a(Object obj)
    {
        super.a((Void)obj);
        k.i(b).setVisibility(8);
    }

    protected final Object b()
    {
        return f();
    }
}
