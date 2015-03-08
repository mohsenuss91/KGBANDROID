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
//            t, x, ai, ar, 
//            as, at, au, av, 
//            aw, ax, y, z, 
//            aa, ab, ac, ad, 
//            ae, af, ag, ah, 
//            aj, ak, al, am, 
//            an, ao, ap, aq, 
//            u

public final class w extends t
{

    public w(ApplicationContext applicationcontext)
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
            e = new RootElement("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "RDF");
            Element element = e.getChild("http://purl.org/rss/1.0/", "channel");
            element.getChild("http://purl.org/rss/1.0/", "title").setEndTextElementListener(new x(this));
            element.getChild("http://purl.org/rss/1.0/", "link").setEndTextElementListener(new ai(this));
            element.getChild("http://purl.org/rss/1.0/", "pubDate").setEndTextElementListener(new ar(this));
            element.getChild("http://purl.org/dc/elements/1.1/", "date").setEndTextElementListener(new as(this));
            element.getChild("http://purl.org/rss/1.0/", "lastBuildDate").setEndTextElementListener(new at(this));
            FeedItem feeditem = new FeedItem();
            g = new ArrayList();
            Element element1 = e.getChild("http://purl.org/rss/1.0/", "item");
            element1.setEndElementListener(new au(this, feeditem));
            element1.getChild("http://purl.org/rss/1.0/", "title").setEndTextElementListener(new av(this, feeditem));
            element1.getChild("http://purl.org/rss/1.0/", "link").setEndTextElementListener(new aw(this, feeditem));
            element1.getChild("http://purl.org/rss/1.0/", "description").setEndTextElementListener(new ax(this, feeditem));
            element1.getChild("guid").setEndTextElementListener(new y(this, feeditem));
            element1.getChild("http://www.itunes.com/dtds/podcast-1.0.dtd", "summary").setEndTextElementListener(new z(this, feeditem));
            element1.getChild("http://wellformedweb.org/CommentAPI/", "commentRss").setEndTextElementListener(new aa(this, feeditem));
            element1.getChild("http://wellformedweb.org/CommentAPI/", "commentRSS").setEndTextElementListener(new ab(this, feeditem));
            element1.getChild("http://purl.org/rss/1.0/modules/slash/", "comments").setEndTextElementListener(new ac(this, feeditem));
            element1.getChild("comments").setEndTextElementListener(new ad(this, feeditem));
            element1.getChild("http://purl.org/rss/1.0/", "enclosure").setStartElementListener(new ae(this, feeditem));
            element1.getChild("http://search.yahoo.com/mrss/", "content").setStartElementListener(new af(this, feeditem));
            element1.getChild("http://search.yahoo.com/mrss/", "thumbnail").setStartElementListener(new ag(this, feeditem));
            element1.getChild("http://www.itunes.com/dtds/podcast-1.0.dtd", "duration").setEndTextElementListener(new ah(this, feeditem));
            element1.getChild("http://purl.org/rss/1.0/", "pubDate").setEndTextElementListener(new aj(this, feeditem));
            element1.getChild("http://purl.org/dc/elements/1.1/", "date").setEndTextElementListener(new ak(this, feeditem));
            element1.getChild("http://purl.org/dc/elements/1.1/", "creator").setEndTextElementListener(new al(this, feeditem));
            element1.getChild("http://purl.org/rss/1.0/modules/syndication/", "updateBase").setEndTextElementListener(new am(this, feeditem));
            element1.getChild("http://purl.org/rss/1.0/modules/content/", "encoded").setEndTextElementListener(new an(this, feeditem));
            Element element2 = element1.getChild("http://search.yahoo.com/mrss/", "group");
            element2.getChild("http://search.yahoo.com/mrss/", "thumbnail").setStartElementListener(new ao(this, feeditem));
            element2.getChild("http://search.yahoo.com/mrss/", "description").setEndTextElementListener(new ap(this, feeditem));
            element2.getChild("http://gdata.youtube.com/schemas/2007", "uploaded").setEndTextElementListener(new aq(this, feeditem));
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
