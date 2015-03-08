// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.RootElement;
import android.util.Xml;
import com.appyet.a.d;
import com.appyet.a.f;
import com.appyet.context.ApplicationContext;
import com.appyet.d.b;
import com.appyet.d.e;
import com.appyet.data.Feed;
import com.appyet.data.FeedItem;
import com.appyet.manager.bl;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.b.a:
//            u, v

public abstract class t
{

    public static String a = "[^\t\r\n -\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF]";
    public static String b = "[^\001-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF]+";
    public static String c = "JGH386S4WFaqy1khW";
    protected ApplicationContext d;
    protected RootElement e;
    protected Feed f;
    protected List g;
    protected List h;

    protected t(ApplicationContext applicationcontext)
    {
        d = applicationcontext;
        h = new ArrayList();
    }

    protected final u a()
    {
        u u1;
        f f1;
        u1 = new u();
        f1 = null;
        d d1 = new d();
        d1.a = URLDecoder.decode(f.getLink(), "UTF-8");
        d1.e = f.getHTTPETag();
        d1.d = f.getHTTPLastModified();
        f1 = d.g.a(d1);
        d.g;
        if (bl.a(f1))
        {
            break MISSING_BLOCK_LABEL_96;
        }
        u1.a = com.appyet.b.a.v.b;
        bl.b(f1);
        return u1;
        byte abyte0[];
        String s;
        abyte0 = com.appyet.d.b.a(f1.b);
        bl.b(f1);
        s = com.appyet.d.e.a(abyte0);
        if (f.getStreamHash() == null || !f.getStreamHash().equals(s))
        {
            break MISSING_BLOCK_LABEL_154;
        }
        u1.a = v.c;
        bl.b(f1);
        return u1;
        if (f.getEncoding() == null || f.getEncoding().trim().equals(""))
        {
            if (f1.d == null || f1.d.equals(""))
            {
                break MISSING_BLOCK_LABEL_275;
            }
            f.setEncoding(f1.d);
        }
_L1:
        String s1;
        f.setStreamHash(s);
        f.setHTTPLastModified(f1.g);
        f.setHTTPETag(f1.h);
        s1 = com.appyet.d.b.a(abyte0, f.getEncoding());
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        u1.a = com.appyet.b.a.v.b;
        bl.b(f1);
        return u1;
        f.setEncoding(com.appyet.d.b.a(abyte0));
        if (f.getEncoding() == null || f.getEncoding().equals(""))
        {
            f.setEncoding("utf-8");
        }
          goto _L1
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        u1.a = com.appyet.b.a.v.b;
        bl.b(f1);
        return u1;
        Xml.parse(s1.replaceAll(a, ""), e.getContentHandler());
        bl.b(f1);
        Iterator iterator = g.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FeedItem feeditem = (FeedItem)iterator.next();
            if (feeditem.getUniqueKey() == null || feeditem.getUniqueKey().trim().equals(""))
            {
                feeditem.setUniqueKey(feeditem.buildUniqueKey());
            }
        } while (true);
        break MISSING_BLOCK_LABEL_447;
        Exception exception;
        exception;
        bl.b(f1);
        throw exception;
        f.setFeedItems(g);
        u1.b = f;
        u1.a = v.a;
        return u1;
    }

    public final String a(String s)
    {
        if (f.getLink().startsWith("https://www.facebook.com/feeds") || f.getLink().startsWith("http://www.facebook.com/feeds"))
        {
            s = s.replaceAll("_s.jpg\" alt=\"\" />", "_n.jpg\" alt=\"\" />");
        } else
        {
            if (f.getLink().startsWith("http://api.flickr.com/services/feeds"))
            {
                return s.replaceAll("_m.jpg\"", "_b.jpg\"");
            }
            if (f.getLink().startsWith("http://pinterest.com") && f.getLink().endsWith("rss") || f.getLink().startsWith("https://pinterest.com") && f.getLink().endsWith("rss"))
            {
                return s.replaceAll("/192x/", "/736x/");
            }
            if (f.getLink().startsWith("https://photos.googleapis.com/data/feed") || f.getLink().startsWith("http://photos.googleapis.com/data/feed"))
            {
                return s.replaceAll("/s288/", "/s800/");
            }
        }
        return s;
    }

}
