// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.Element;
import android.sax.RootElement;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.data.Feed;
import com.appyet.data.FeedItem;
import java.util.ArrayList;

// Referenced classes of package com.appyet.b.a:
//            t, b, l, m, 
//            n, o, p, q, 
//            r, s, c, d, 
//            e, f, g, h, 
//            i, j, k, u

public final class a extends t
{

    public a(ApplicationContext applicationcontext)
    {
        super(applicationcontext);
    }

    public final u a(Feed feed)
    {
        u u;
        try
        {
            f = new Feed();
            f.setLink(feed.getLink());
            f.setEncoding(feed.getEncoding());
            f.setStreamHash(feed.getStreamHash());
            f.setHTTPETag(feed.getHTTPETag());
            f.setHTTPLastModified(feed.getHTTPLastModified());
            e = new RootElement("http://www.w3.org/2005/Atom", "feed");
            e.getChild("http://www.w3.org/2005/Atom", "title").setEndTextElementListener(new b(this));
            e.getChild("http://www.w3.org/2005/Atom", "link").setStartElementListener(new l(this));
            e.getChild("http://www.w3.org/2005/Atom", "updated").setEndTextElementListener(new m(this));
            FeedItem feeditem = new FeedItem();
            g = new ArrayList();
            Element element = e.getChild("http://www.w3.org/2005/Atom", "entry");
            element.setEndElementListener(new n(this, feeditem));
            element.getChild("http://www.w3.org/2005/Atom", "title").setEndTextElementListener(new o(this, feeditem));
            element.getChild("http://www.w3.org/2005/Atom", "id").setEndTextElementListener(new p(this, feeditem));
            element.getChild("http://www.w3.org/2005/Atom", "summary").setEndTextElementListener(new q(this, feeditem));
            element.getChild("http://www.w3.org/2005/Atom", "link").setStartElementListener(new r(this, feeditem));
            element.getChild("http://search.yahoo.com/mrss/", "content").setStartElementListener(new s(this, feeditem));
            element.getChild("http://search.yahoo.com/mrss/", "thumbnail").setStartElementListener(new c(this, feeditem));
            element.getChild("http://www.itunes.com/dtds/podcast-1.0.dtd", "duration").setEndTextElementListener(new com.appyet.b.a.d(this, feeditem));
            element.getChild("http://www.w3.org/2005/Atom", "content").setEndTextElementListener(new e(this, feeditem));
            element.getChild("http://www.itunes.com/dtds/podcast-1.0.dtd", "summary").setEndTextElementListener(new f(this, feeditem));
            element.getChild("http://www.w3.org/2005/Atom", "updated").setEndTextElementListener(new g(this, feeditem));
            element.getChild("http://www.w3.org/2005/Atom", "published").setEndTextElementListener(new h(this, feeditem));
            Element element1 = element.getChild("http://search.yahoo.com/mrss/", "group");
            element1.getChild("http://search.yahoo.com/mrss/", "thumbnail").setStartElementListener(new i(this, feeditem));
            element1.getChild("http://search.yahoo.com/mrss/", "description").setEndTextElementListener(new j(this, feeditem));
            element1.getChild("http://gdata.youtube.com/schemas/2007", "uploaded").setEndTextElementListener(new k(this, feeditem));
            u = a();
        }
        catch (Exception exception)
        {
            d.a(exception);
            return null;
        }
        return u;
    }
}
