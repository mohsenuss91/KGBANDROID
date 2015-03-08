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
//            t, az, bk, bt, 
//            bu, bv, bw, bx, 
//            by, bz, ba, bb, 
//            bc, bd, be, bf, 
//            bg, bh, bi, bj, 
//            bl, bm, bn, bo, 
//            bp, bq, br, bs, 
//            u

public final class ay extends t
{

    public ay(ApplicationContext applicationcontext)
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
            e = new RootElement("rss");
            Element element = e.getChild("channel");
            element.getChild("title").setEndTextElementListener(new az(this));
            element.getChild("link").setEndTextElementListener(new bk(this));
            element.getChild("pubDate").setEndTextElementListener(new bt(this));
            element.getChild("http://purl.org/dc/elements/1.1/", "date").setEndTextElementListener(new bu(this));
            element.getChild("lastBuildDate").setEndTextElementListener(new bv(this));
            FeedItem feeditem = new FeedItem();
            g = new ArrayList();
            Element element1 = element.getChild("item");
            element1.setEndElementListener(new bw(this, feeditem));
            element1.getChild("title").setEndTextElementListener(new bx(this, feeditem));
            element1.getChild("link").setEndTextElementListener(new by(this, feeditem));
            element1.getChild("description").setEndTextElementListener(new bz(this, feeditem));
            element1.getChild("guid").setEndTextElementListener(new ba(this, feeditem));
            element1.getChild("http://www.itunes.com/dtds/podcast-1.0.dtd", "summary").setEndTextElementListener(new bb(this, feeditem));
            element1.getChild("http://wellformedweb.org/CommentAPI/", "commentRss").setEndTextElementListener(new bc(this, feeditem));
            element1.getChild("http://wellformedweb.org/CommentAPI/", "commentRSS").setEndTextElementListener(new bd(this, feeditem));
            element1.getChild("http://purl.org/rss/1.0/modules/slash/", "comments").setEndTextElementListener(new be(this, feeditem));
            element1.getChild("comments").setEndTextElementListener(new bf(this, feeditem));
            element1.getChild("enclosure").setStartElementListener(new bg(this, feeditem));
            element1.getChild("http://search.yahoo.com/mrss/", "content").setStartElementListener(new bh(this, feeditem));
            element1.getChild("http://search.yahoo.com/mrss/", "thumbnail").setStartElementListener(new bi(this, feeditem));
            element1.getChild("http://www.itunes.com/dtds/podcast-1.0.dtd", "duration").setEndTextElementListener(new bj(this, feeditem));
            element1.getChild("pubDate").setEndTextElementListener(new bl(this, feeditem));
            element1.getChild("http://purl.org/dc/elements/1.1/", "date").setEndTextElementListener(new bm(this, feeditem));
            element1.getChild("http://purl.org/dc/elements/1.1/", "creator").setEndTextElementListener(new bn(this, feeditem));
            element1.getChild("encoded").setEndTextElementListener(new bo(this, feeditem));
            element1.getChild("http://purl.org/rss/1.0/modules/content/", "encoded").setEndTextElementListener(new bp(this, feeditem));
            Element element2 = element1.getChild("http://search.yahoo.com/mrss/", "group");
            element2.getChild("http://search.yahoo.com/mrss/", "thumbnail").setStartElementListener(new bq(this, feeditem));
            element2.getChild("http://search.yahoo.com/mrss/", "description").setEndTextElementListener(new br(this, feeditem));
            element2.getChild("http://gdata.youtube.com/schemas/2007", "uploaded").setEndTextElementListener(new bs(this, feeditem));
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
