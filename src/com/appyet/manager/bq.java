// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.PowerManager;
import android.text.Html;
import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.context.b;
import com.appyet.d.c;
import com.appyet.d.d;
import com.appyet.d.e;
import com.appyet.d.f;
import com.appyet.data.DatabaseHelper;
import com.appyet.data.Feed;
import com.appyet.data.FeedItem;
import com.appyet.data.FileCache;
import com.appyet.f.aa;
import com.appyet.f.p;
import com.appyet.f.z;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataAppSync;
import com.appyet.metadata.MetadataApplication;
import com.appyet.service.SyncService;
import com.google.a.k;
import com.google.a.r;
import com.j256.ormlite.misc.TransactionManager;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.appyet.manager:
//            br, d, s, r, 
//            bl, al, bp, ProgressNotificationManager, 
//            bs, bo, bt, bu, 
//            bv, ar, ap, by, 
//            a

public final class bq
{

    public static String a = "fe4232*fed";
    private static final ThreadFactory b = new br();
    private ApplicationContext c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private ThreadPoolExecutor j;
    private ArrayBlockingQueue k;
    private AtomicInteger l;
    private AtomicInteger m;
    private Intent n;
    private ProgressNotificationManager o;

    public bq(ApplicationContext applicationcontext)
    {
        j = null;
        k = null;
        l = new AtomicInteger(0);
        m = new AtomicInteger(0);
        c = applicationcontext;
    }

    private static Feed a(List list, long l1)
    {
        if (list == null)
        {
            return null;
        }
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Feed feed = (Feed)iterator.next();
            if (feed.getFeedId().longValue() == l1)
            {
                return feed;
            }
        }

        return null;
    }

    static void a(bq bq1, Long long1)
    {
        bq1.b(long1, false);
    }

    private void a(List list)
    {
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = list.iterator();
_L14:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        FeedItem feeditem;
        Iterator iterator1;
        feeditem = (FeedItem)iterator.next();
        if (feeditem.getThumbnail() != null)
        {
            FileCache filecache = new FileCache();
            String s1 = com.appyet.d.e.a(feeditem.getThumbnail());
            filecache.setDownloadAttempt(Integer.valueOf(0));
            filecache.setDownloadStatus(com.appyet.data.FileCache.DownloadStatusEnum.Pending);
            filecache.setFileLink(feeditem.getThumbnail());
            filecache.setFileType(com.appyet.data.FileCache.FileTypeEnum.Image);
            filecache.setFileCacheName(s1);
            filecache.setCacheGuid(feeditem.getCacheGuid());
            filecache.setFileType(com.appyet.data.FileCache.FileTypeEnum.Thumbnail);
            String s2 = feeditem.getThumbnail();
            if (s2 != null)
            {
                if (s2.contains("://i.ytimg.com") || s2.contains("://i1.ytimg.com") || s2.contains("://i2.ytimg.com") || s2.contains("://i3.ytimg.com") || s2.contains("://i4.ytimg.com") || s2.contains("://img.youtube.com"))
                {
                    s2 = s2.replace("/3.jpg", "/0.jpg");
                    filecache.setFileLink(s2);
                    filecache.setFileCacheName(com.appyet.d.e.a(s2));
                }
                feeditem.setThumbnail(s2);
            }
            c.h.a(filecache);
        }
        if (feeditem.getDescription() == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        iterator1 = com.appyet.d.c.a(feeditem.getDescription()).iterator();
_L12:
        String s3;
        if (!iterator1.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        s3 = (String)iterator1.next();
        if (s3 != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        String s4 = z.a(s3);
        if (s4.startsWith("http://") || s4.startsWith("https://")) goto _L6; else goto _L5
_L5:
        if (!s4.startsWith("/") || s4.startsWith("//")) goto _L8; else goto _L7
_L7:
        String s6 = aa.a(feeditem.getLink());
        if (s6 == null) goto _L6; else goto _L9
_L9:
        s4 = (new StringBuilder()).append(s6).append(s4).toString();
_L6:
        boolean flag = a(s4);
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        Exception exception2;
        FileCache filecache1;
        String s5;
        try
        {
            new URL(s4);
        }
        catch (Exception exception3)
        {
            try
            {
                com.appyet.d.d.a(exception3);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception2)
            {
                com.appyet.d.d.a(exception2);
            }
            catch (OutOfMemoryError outofmemoryerror)
            {
                com.appyet.d.d.a(outofmemoryerror);
            }
            continue; /* Loop/switch isn't completed */
        }
        filecache1 = new FileCache();
        s5 = com.appyet.d.e.a(s4);
        filecache1.setDownloadAttempt(Integer.valueOf(0));
        filecache1.setDownloadStatus(com.appyet.data.FileCache.DownloadStatusEnum.Pending);
        filecache1.setFileLink(s4);
        filecache1.setFileType(com.appyet.data.FileCache.FileTypeEnum.Image);
        filecache1.setFileCacheName(s5);
        filecache1.setCacheGuid(feeditem.getCacheGuid());
        if (feeditem.getThumbnail() != null || s4 == null)
        {
            break MISSING_BLOCK_LABEL_578;
        }
        if (s4.contains("://i.ytimg.com") || s4.contains("://i1.ytimg.com") || s4.contains("://i2.ytimg.com") || s4.contains("://i3.ytimg.com") || s4.contains("://i4.ytimg.com") || s4.contains("://img.youtube.com"))
        {
            s4 = s4.replace("/default.jpg", "/0.jpg");
            filecache1.setFileLink(s4);
            filecache1.setFileCacheName(com.appyet.d.e.a(s4));
        }
        feeditem.setThumbnail(s4);
        filecache1.setFileType(com.appyet.data.FileCache.FileTypeEnum.Thumbnail);
        arraylist.add(filecache1);
        h = 1 + h;
        continue; /* Loop/switch isn't completed */
_L8:
label0:
        {
            if (!s4.startsWith("//"))
            {
                break label0;
            }
            s4 = (new StringBuilder("http:")).append(s4).toString();
        }
          goto _L6
        s4 = (new StringBuilder("http://")).append(s4).toString();
          goto _L6
_L2:
        com.appyet.manager.d d1;
        c.h.b(arraylist);
        d1 = c.h;
        if (list == null || list.size() == 0) goto _L3; else goto _L10
_L10:
        TransactionManager.callInTransaction(d1.b.getConnectionSource(), new s(d1, list));
        return;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        return;
        Exception exception;
        exception;
        throw exception;
        if (true) goto _L12; else goto _L11
_L11:
        if (true) goto _L14; else goto _L13
_L13:
    }

    private boolean a(Feed feed)
    {
        Feed feed1;
        Hashtable hashtable;
        List list;
        String s1;
        boolean flag;
        boolean flag1;
        Iterator iterator;
        FeedItem feeditem4;
        FileCache filecache;
        try
        {
            feed1 = c.h.a(feed.getFeedId().longValue());
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return false;
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            com.appyet.d.d.a(outofmemoryerror);
            return false;
        }
        if (feed1 == null)
        {
            return false;
        }
        s1 = feed.getStreamHash();
        flag = false;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        flag1 = feed.getStreamHash().equals(feed1.getStreamHash());
        flag = false;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        feed1.setStreamHash(feed.getStreamHash());
        flag = true;
        if (feed.getPubDateString() == null)
        {
            break MISSING_BLOCK_LABEL_489;
        }
        feed1.setPubDateString(feed.getPubDateString());
_L1:
        if (feed.getFeedType() != null && !feed.getFeedType().equals(feed1.getFeedType()))
        {
            feed1.setFeedType(feed.getFeedType());
        }
        if (feed.getEncoding() != null && !feed.getEncoding().equals(feed1.getEncoding()))
        {
            feed1.setEncoding(feed.getEncoding());
        }
        if ((feed1.getTitle() == null || feed1.getTitle().trim().equals("")) && feed.getTitle() != null && !feed.getTitle().equals(feed1.getTitle()))
        {
            feed1.setTitle(feed.getTitle());
        }
        if (feed.getWebLink() != null && !feed.getWebLink().equals(feed1.getWebLink()))
        {
            feed1.setWebLink(feed.getWebLink());
        }
        if (feed.getImageLink() != null && !feed.getWebLink().equals(feed1.getWebLink()))
        {
            feed1.setImageLink(feed.getImageLink());
            filecache = new FileCache();
            filecache.setCacheGuid(feed1.getCacheGuid());
            filecache.setDownloadAttempt(Integer.valueOf(0));
            filecache.setDownloadStatus(com.appyet.data.FileCache.DownloadStatusEnum.Pending);
            filecache.setFileCacheName(feed.getImageLinkMD5());
            filecache.setFileLink(feed.getImageLink());
            filecache.setFileType(com.appyet.data.FileCache.FileTypeEnum.Image);
            c.h.a(filecache);
        }
        feed1.setHTTPETag(feed.getHTTPETag());
        feed1.setHTTPLastModified(feed.getHTTPLastModified());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_413;
        }
        feed1.setSyncDate(new Date());
        if (feed1.getPubDate() == null)
        {
            feed1.setPubDate(new Date());
        }
        c.h.b(feed1);
        hashtable = new Hashtable();
        list = c.h.a(feed);
        for (iterator = list.iterator(); iterator.hasNext(); hashtable.put(feeditem4.getUniqueKey(), feeditem4))
        {
            feeditem4 = (FeedItem)iterator.next();
        }

        break MISSING_BLOCK_LABEL_511;
        feed1.setPubDate(new Date());
          goto _L1
        ArrayList arraylist;
        List list1;
        ArrayList arraylist1;
        Iterator iterator1;
        arraylist = new ArrayList();
        list1 = feed.getFeedItems();
        arraylist1 = new ArrayList();
        iterator1 = list1.iterator();
_L12:
        FeedItem feeditem2;
        FeedItem feeditem3;
        if (!iterator1.hasNext())
        {
            break MISSING_BLOCK_LABEL_1784;
        }
        feeditem2 = (FeedItem)iterator1.next();
        feeditem3 = (FeedItem)hashtable.get(feeditem2.getUniqueKey());
        if (feeditem3 != null)
        {
            break MISSING_BLOCK_LABEL_601;
        }
        feeditem3 = (FeedItem)hashtable.get(feeditem2.buildUniqueKeyLegacy());
        if (feeditem3 != null)
        {
            break MISSING_BLOCK_LABEL_1705;
        }
        if (feeditem2.getPubDateString() == null)
        {
            feeditem2.setPubDateString(feed.getPubDateString());
        }
        String s3 = feeditem2.getEnclosureLink();
        if (s3 != null) goto _L3; else goto _L2
_L2:
        if (feeditem2.getEnclosureLink() == null || feeditem2.getEnclosureType() == null || feeditem2.getEnclosureType().toLowerCase(Locale.US).contains("video/quicktime")) goto _L5; else goto _L4
_L4:
        if (feeditem2.getEnclosureType().toLowerCase(Locale.US).contains("video") || feeditem2.getEnclosureType().toLowerCase(Locale.US).contains("audio")) goto _L7; else goto _L6
_L6:
        if (!feeditem2.getEnclosureType().toLowerCase(Locale.US).contains("image")) goto _L9; else goto _L8
_L8:
        if (feeditem2.getDescription() == null) goto _L11; else goto _L10
_L10:
        if (!feeditem2.getDescription().contains(feeditem2.getEnclosureLink().toString()))
        {
            feeditem2.setDescription((new StringBuilder("<div><img src='")).append(feeditem2.getEnclosureLink().toString()).append("'/></div>").append(feeditem2.getDescription()).toString());
        }
_L9:
        feeditem2.setEnclosureLink(null);
        feeditem2.setEnclosureType(null);
_L7:
        if (feeditem2.getDescription() == null)
        {
            break MISSING_BLOCK_LABEL_1694;
        }
        String s2 = feeditem2.getDescription().replace('\n', ' ').replaceAll("(\\<!--.*?-->|\\<style.*?</style>|\\<.*?>)", " ").trim();
        if (s2.length() > 300)
        {
            s2 = s2.substring(0, 300);
        }
        feeditem2.setSnippet(Html.fromHtml(s2).toString().trim());
_L25:
        feeditem2.setCacheGuid(UUID.randomUUID().toString().replace("-", ""));
        if (feed1.getIsAutoMobilize())
        {
            feeditem2.setArticleStatus(com.appyet.data.FeedItem.ArticleStatusEnum.DownloadPending);
        }
        if (feed1.getIsDownloadNewEnclosure())
        {
            feeditem2.setEnclosureStatus(com.appyet.data.FeedItem.EnclosureStatusEnum.DownloadPending);
        }
        if (feeditem2.getDescription() != null)
        {
            StringBuilder stringbuilder = new StringBuilder(feeditem2.getDescription().replaceAll("(?s)<style.*?</style>", " ").replaceAll("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>", "<img src=\"$1\" />"));
            com.appyet.d.f.a(stringbuilder, "<img src=\"http://feeds.feedburner.com", "<rm src=\"");
            com.appyet.d.f.a(stringbuilder, "<a href=\"http://feedads.g.doubleclick.net", "<rm href=\"");
            com.appyet.d.f.a(stringbuilder, "<img src=\"http://feedads.g.doubleclick.net", "<rm src=\"");
            com.appyet.d.f.a(stringbuilder, "<img src=\"http://feedads.g.doubleclick.net", "<rm src=\"");
            com.appyet.d.f.a(stringbuilder, "<img src=\"http://da.feedsportal.com", "<rm src=\"");
            com.appyet.d.f.a(stringbuilder, "<img src=\"http://res3.feedsportal.com", "<rm src=\"");
            com.appyet.d.f.a(stringbuilder, "<img src=\"http://pi.feedsportal.com", "<rm src=\"");
            feeditem2.setDescription(stringbuilder.toString().trim());
        }
        feeditem2.setTitle(p.e.a(feeditem2.getTitle()));
        if (feeditem2.getPubDate() == null)
        {
            feeditem2.setPubDate(new Date());
        }
        feeditem2.setCreatedDate(new Date());
        if (feeditem2.getTitle() != null)
        {
            feeditem2.setTitle(Html.fromHtml(feeditem2.getTitle()).toString().replace("\t", "").replace("\n", ""));
        }
        arraylist.add(feeditem2);
          goto _L12
_L3:
        if (feeditem2.getEnclosureType() == null) goto _L14; else goto _L13
_L13:
        String s7 = feeditem2.getEnclosureType().trim();
        if (!s7.contains("mp3") && !s7.contains("ogg") && !s7.contains("wav") && !s7.contains("m4a") && !s7.contains("audio")) goto _L16; else goto _L15
_L15:
        feeditem2.setEnclosureType("audio/mpeg");
_L14:
        if (feeditem2.getEnclosureType() != null) goto _L2; else goto _L17
_L17:
        String s4;
        int j2;
        s4 = feeditem2.getEnclosureLink();
        j2 = s4.lastIndexOf(".");
        String s5;
        s5 = null;
        if (j2 == -1)
        {
            break MISSING_BLOCK_LABEL_1311;
        }
        s5 = s4.substring(j2 + 1, s4.length()).toLowerCase();
        String s6 = s5.trim();
        if (s6 == null) goto _L2; else goto _L18
_L18:
        if (!s6.contains("mp3") && !s6.contains("ogg") && !s6.contains("wav") && !s6.contains("m4a") && !s6.contains("audio"))
        {
            break MISSING_BLOCK_LABEL_1520;
        }
        feeditem2.setEnclosureType("audio/mpeg");
          goto _L2
        Exception exception2;
        exception2;
        com.appyet.d.d.a(exception2);
          goto _L2
_L16:
        if (!s7.contains("avi") && !s7.contains("mkv") && !s7.contains("mp4") && !s7.contains("3gp") && !s7.contains("video")) goto _L20; else goto _L19
_L19:
        feeditem2.setEnclosureType("video/avi");
          goto _L14
_L20:
        if (!s7.contains("jpg") && !s7.contains("jpeg") && !s7.contains("gif") && !s7.contains("png")) goto _L14; else goto _L21
_L21:
        feeditem2.setEnclosureType("image/png");
          goto _L14
        if (!s6.contains("avi") && !s6.contains("mkv") && !s6.contains("mp4") && !s6.contains("3gp") && !s6.contains("video")) goto _L23; else goto _L22
_L22:
        feeditem2.setEnclosureType("video/avi");
          goto _L2
_L23:
        if (!s6.contains("jpg") && !s6.contains("jpeg") && !s6.contains("gif") && !s6.contains("png")) goto _L2; else goto _L24
_L24:
        feeditem2.setEnclosureType("image/png");
          goto _L2
_L11:
        feeditem2.setDescription((new StringBuilder("<img src='")).append(feeditem2.getEnclosureLink().toString()).append("'/>").toString());
          goto _L9
_L5:
        feeditem2.setEnclosureLink(null);
        feeditem2.setEnclosureType(null);
          goto _L7
        feeditem2.setSnippet("");
          goto _L25
        hashtable.get(feeditem2.buildUniqueKey());
        feeditem2.setFeedItemId(feeditem3.getFeedItemId());
        if (feeditem2.getCommentsCount() != null && feeditem2.getCommentsCount().length() > 0 && !feeditem2.getCommentsCount().equals(feeditem3.getCommentsCount()))
        {
            feeditem3.setCommentsCount(feeditem2.getCommentsCount());
            arraylist1.add(feeditem3);
        }
          goto _L12
        int i1 = arraylist.size();
        boolean flag2;
        flag2 = false;
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_1850;
        }
        flag2 = true;
        c.h.a(arraylist);
        a(((List) (arraylist)));
        d = d + arraylist.size();
        e = arraylist.size();
        if (arraylist1.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_1909;
        }
        flag2 = true;
        com.appyet.manager.d d1;
        int j1;
        d1 = c.h;
        j1 = arraylist1.size();
        if (j1 == 0)
        {
            break MISSING_BLOCK_LABEL_1909;
        }
        TransactionManager.callInTransaction(d1.b.getConnectionSource(), new com.appyet.manager.r(d1, arraylist1));
_L27:
        Hashtable hashtable1;
        hashtable1 = new Hashtable();
        Iterator iterator2 = list1.iterator();
        do
        {
            if (!iterator2.hasNext())
            {
                break;
            }
            FeedItem feeditem1 = (FeedItem)iterator2.next();
            if (feeditem1.getFeedItemId() != null)
            {
                hashtable1.put(feeditem1.getFeedItemId(), feeditem1.getFeedItemId());
            }
        } while (true);
        break; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        if (true) goto _L27; else goto _L26
_L26:
        int k1 = 0;
        ArrayList arraylist2;
        Iterator iterator3;
        arraylist2 = new ArrayList();
        iterator3 = list.iterator();
_L33:
        if (!iterator3.hasNext()) goto _L29; else goto _L28
_L28:
        FeedItem feeditem;
        long l1;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        feeditem = (FeedItem)iterator3.next();
        l1 = feeditem.getFeedItemId().longValue();
        flag4 = feeditem.getIsStar();
        flag5 = feeditem.getIsDeleted();
        flag6 = feeditem.getIsRead();
        boolean flag3;
        boolean flag7;
        int i2;
        if (feeditem.getEnclosureStatus() == com.appyet.data.FeedItem.EnclosureStatusEnum.DownloadCompleted)
        {
            flag7 = true;
        } else
        {
            flag7 = false;
        }
        if (flag5) goto _L31; else goto _L30
_L30:
        if (flag4) goto _L33; else goto _L32
_L32:
        if (feed1.getArticleNumberLimit() == 0L && !flag6 || flag7) goto _L33; else goto _L34
_L34:
        if (feeditem.getIsQueued()) goto _L33; else goto _L31
_L31:
        if (hashtable1.contains(Long.valueOf(l1))) goto _L33; else goto _L35
_L35:
        if (feed1.getArticleNumberLimit() <= 0L)
        {
            break MISSING_BLOCK_LABEL_2180;
        }
        i2 = k1 + 1;
        if ((long)i2 <= feed1.getArticleNumberLimit() - (long)hashtable1.size())
        {
            break MISSING_BLOCK_LABEL_2271;
        }
        arraylist2.add(Long.valueOf(l1));
        k1 = i2;
          goto _L33
        arraylist2.add(Long.valueOf(l1));
        i2 = k1;
        break MISSING_BLOCK_LABEL_2271;
_L29:
        if (arraylist2.size() > 0)
        {
            flag3 = true;
        } else
        {
            flag3 = flag2;
        }
        f = arraylist2.size();
        c.h.c(arraylist2);
        c.h.f(feed.getFeedId().longValue());
        return flag3;
        k1 = i2;
          goto _L33
    }

    private boolean a(FeedItem feeditem)
    {
        if (feeditem.getEnclosureLink() == null) goto _L2; else goto _L1
_L1:
        com.appyet.a.f f2;
        String s1 = URLDecoder.decode(feeditem.getEnclosureLink(), "UTF-8");
        com.appyet.a.d d1 = new com.appyet.a.d();
        d1.a = s1;
        f2 = c.g.a(d1);
        com.appyet.a.f f1 = f2;
_L6:
        com.appyet.manager.bl.b(f1);
        return false;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
_L4:
        com.appyet.manager.bl.b(null);
        return false;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        com.appyet.d.d.a(outofmemoryerror);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        com.appyet.manager.bl.b(null);
        throw exception;
_L2:
        f1 = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static boolean a(bq bq1)
    {
        return bq1.i;
    }

    static boolean a(bq bq1, Feed feed)
    {
        return bq1.a(feed);
    }

    protected static boolean a(String s1)
    {
        return !s1.contains("feeds.feedburner.com") && !s1.contains("doubleclick.net") && !s1.contains("feedsportal.com") && !s1.contains("api.tweetmeme.com/imagebutton.gif") && !s1.contains("share-buttons/fb.jpg") && !s1.contains("share-buttons/diggme.png") && !s1.contains("share-buttons/stumbleupon.png") && !s1.contains("wordpress.com/1.0") && !s1.contains("wordpress.com/b.gif") && !s1.contains("blogger.googleusercontent.com") && !s1.contains("feeds.feedburner.com") && !s1.contains("www.assoc-amazon.com") && !s1.contains("doubleclick.net") && !s1.contains("statcounter.com") && !s1.contains("pheedo.com") && !s1.contains("feedsportal.com");
    }

    static int b(bq bq1)
    {
        int i1 = bq1.h;
        bq1.h = i1 + 1;
        return i1;
    }

    static void b(bq bq1, Feed feed)
    {
        if (bq1.c.k != null && !bq1.c.k.g(feed.getFavIconUrlMD5()) && !bq1.c.k.a(feed.getFavIconUrl(), feed.getFavIconUrlMD5()))
        {
            java.io.InputStream inputstream = bq1.c.getResources().openRawResource(0x7f020110);
            bq1.c.k.a(inputstream, feed.getFavIconUrlMD5());
            bq1.h = 1 + bq1.h;
        }
    }

    private void b(Long long1, boolean flag)
    {
        Intent intent = new Intent(c.x);
        if (long1 != null)
        {
            intent.putExtra("moduleid", long1);
            intent.putExtra("forced", flag);
        }
        c.sendBroadcast(intent);
    }

    static AtomicInteger c(bq bq1)
    {
        return bq1.l;
    }

    private void c(Long long1, boolean flag)
    {
        if (!i) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag1;
        boolean flag2;
        flag1 = c.d.n();
        flag2 = c.d.o();
        o = null;
        if (long1 != null) goto _L4; else goto _L3
_L3:
        List list = c.h.b();
_L8:
        int i1 = list.size();
        if (i1 != 0) goto _L6; else goto _L5
_L5:
        Intent intent4 = n;
        if (intent4 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        ApplicationContext applicationcontext2 = c;
        Intent intent5 = n;
        applicationcontext2.stopService(intent5);
        n = null;
        ProgressNotificationManager progressnotificationmanager4 = o;
        if (progressnotificationmanager4 == null) goto _L1; else goto _L7
_L7:
        ProgressNotificationManager progressnotificationmanager5 = o;
        progressnotificationmanager5.a();
        return;
        Exception exception2;
        exception2;
_L16:
        com.appyet.d.d.a(exception2);
        return;
_L4:
        list = c.h.a(long1);
          goto _L8
_L20:
        o = new ProgressNotificationManager(c, i1, c.getResources().getString(0x7f080116));
_L21:
        n = new Intent(c, com/appyet/service/SyncService);
        c.startService(n);
        k = new ArrayBlockingQueue(10000);
        if (c.d.z() != b.a || i1 <= 50) goto _L10; else goto _L9
_L9:
        j = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, k, b);
_L17:
        l.set(0);
        m.set(i1);
          goto _L11
_L22:
        o.a(l.get(), (new StringBuilder()).append(c.getString(0x7f080057)).append(" (").append(l.get()).append("/").append(m.get()).append(") ").append(com.appyet.d.f.a((float)l.get() / (float)m.get())).toString());
_L23:
        Iterator iterator = list.iterator();
_L15:
        if (!iterator.hasNext()) goto _L13; else goto _L12
_L12:
        FeedItem feeditem;
        boolean flag3;
        feeditem = (FeedItem)iterator.next();
        flag3 = i;
        if (flag3) goto _L13; else goto _L14
_L14:
        j.execute(new bs(this, c, feeditem));
          goto _L15
        OutOfMemoryError outofmemoryerror1;
        outofmemoryerror1;
        com.appyet.d.d.a(outofmemoryerror1);
          goto _L15
        Exception exception3;
        exception3;
        com.appyet.d.d.a(exception3);
        if (n != null)
        {
            c.stopService(n);
            n = null;
        }
        if (o != null)
        {
            o.a();
            return;
        }
          goto _L1
        exception2;
          goto _L16
_L10:
        j = new ThreadPoolExecutor(10, 10, 10L, TimeUnit.SECONDS, k, b);
          goto _L17
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        com.appyet.d.d.a(outofmemoryerror);
        Intent intent = n;
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_600;
        }
        ApplicationContext applicationcontext = c;
        Intent intent1 = n;
        applicationcontext.stopService(intent1);
        n = null;
        ProgressNotificationManager progressnotificationmanager = o;
        if (progressnotificationmanager == null) goto _L1; else goto _L18
_L18:
        ProgressNotificationManager progressnotificationmanager1 = o;
        try
        {
            progressnotificationmanager1.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception2) { }
          goto _L16
        Exception exception4;
        exception4;
        com.appyet.d.d.a(exception4);
          goto _L15
        Exception exception;
        exception;
        Intent intent2;
        ProgressNotificationManager progressnotificationmanager2;
        ProgressNotificationManager progressnotificationmanager3;
        ApplicationContext applicationcontext1;
        Intent intent3;
        try
        {
            if (n != null)
            {
                c.stopService(n);
                n = null;
            }
            if (o != null)
            {
                o.a();
            }
        }
        catch (Exception exception1)
        {
            com.appyet.d.d.a(exception1);
        }
        throw exception;
_L13:
        j.shutdown();
        j.awaitTermination(1800L, TimeUnit.SECONDS);
        j = null;
        k.clear();
        k = null;
        b(long1, flag);
        intent2 = n;
        if (intent2 == null)
        {
            break MISSING_BLOCK_LABEL_761;
        }
        applicationcontext1 = c;
        intent3 = n;
        applicationcontext1.stopService(intent3);
        n = null;
        progressnotificationmanager2 = o;
        if (progressnotificationmanager2 == null) goto _L1; else goto _L19
_L19:
        progressnotificationmanager3 = o;
        try
        {
            progressnotificationmanager3.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception2) { }
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
        exception2;
          goto _L16
_L6:
        if ((!flag1 || !flag2) && !flag) goto _L21; else goto _L20
_L11:
        if ((!flag1 || !flag2) && !flag) goto _L23; else goto _L22
    }

    static ProgressNotificationManager d(bq bq1)
    {
        return bq1.o;
    }

    private void d(Long long1, boolean flag)
    {
_L2:
        return;
        if (i || c.g.a() == bo.a) goto _L2; else goto _L1
_L1:
        boolean flag1;
        boolean flag2;
        flag1 = c.d.n();
        flag2 = c.d.o();
        o = null;
        if (long1 != null) goto _L4; else goto _L3
_L3:
        List list = c.h.c();
_L8:
        List list1;
        int i1;
        list1 = c.h.d();
        i1 = list.size();
        if (i1 != 0) goto _L6; else goto _L5
_L5:
        Intent intent4 = n;
        if (intent4 == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        ApplicationContext applicationcontext2 = c;
        Intent intent5 = n;
        applicationcontext2.stopService(intent5);
        n = null;
        ProgressNotificationManager progressnotificationmanager4 = o;
        if (progressnotificationmanager4 == null) goto _L2; else goto _L7
_L7:
        ProgressNotificationManager progressnotificationmanager5 = o;
        progressnotificationmanager5.a();
        return;
        Exception exception2;
        exception2;
_L15:
        com.appyet.d.d.a(exception2);
        return;
_L4:
        list = c.h.b(long1);
          goto _L8
_L20:
        o = new ProgressNotificationManager(c, i1, c.getResources().getString(0x7f080116));
_L21:
        Iterator iterator;
        n = new Intent(c, com/appyet/service/SyncService);
        c.startService(n);
        iterator = list.iterator();
        int j1 = 0;
_L14:
        if (!iterator.hasNext()) goto _L10; else goto _L9
_L9:
        FeedItem feeditem = (FeedItem)iterator.next();
        if (i) goto _L10; else goto _L11
_L11:
        if (!c.d.t()) goto _L13; else goto _L12
_L12:
        c;
        if (!ApplicationContext.a()) goto _L10; else goto _L13
_L22:
        o.a(j1, (new StringBuilder()).append(c.getString(0x7f080058)).append(" (").append(j1).append("/").append(i1).append(") ").toString());
_L23:
        a(list1, feeditem.getFeed().getFeedId().longValue());
        a(feeditem);
          goto _L14
        Exception exception3;
        exception3;
        com.appyet.d.d.a(exception3);
        if (n != null)
        {
            c.stopService(n);
            n = null;
        }
        if (o != null)
        {
            o.a();
            return;
        }
          goto _L2
        exception2;
          goto _L15
_L10:
        b(long1, flag);
        Intent intent2 = n;
        if (intent2 == null)
        {
            break MISSING_BLOCK_LABEL_484;
        }
        ApplicationContext applicationcontext1 = c;
        Intent intent3 = n;
        applicationcontext1.stopService(intent3);
        n = null;
        ProgressNotificationManager progressnotificationmanager2 = o;
        if (progressnotificationmanager2 == null) goto _L2; else goto _L16
_L16:
        ProgressNotificationManager progressnotificationmanager3 = o;
        try
        {
            progressnotificationmanager3.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception2) { }
          goto _L15
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        com.appyet.d.d.a(outofmemoryerror);
        Intent intent = n;
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_555;
        }
        ApplicationContext applicationcontext = c;
        Intent intent1 = n;
        applicationcontext.stopService(intent1);
        n = null;
        ProgressNotificationManager progressnotificationmanager = o;
        if (progressnotificationmanager == null) goto _L2; else goto _L17
_L17:
        ProgressNotificationManager progressnotificationmanager1 = o;
        try
        {
            progressnotificationmanager1.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception2) { }
          goto _L15
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
_L19:
        Exception exception;
        throw exception;
        exception;
        if (n != null)
        {
            c.stopService(n);
            n = null;
        }
        if (o != null)
        {
            o.a();
        }
        if (true) goto _L19; else goto _L18
_L18:
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
        exception2;
          goto _L15
_L6:
        if ((!flag1 || !flag2) && !flag) goto _L21; else goto _L20
_L13:
        j1++;
        if ((!flag1 || !flag2) && !flag) goto _L23; else goto _L22
    }

    static AtomicInteger e(bq bq1)
    {
        return bq1.m;
    }

    static void e()
    {
    }

    private void e(Long long1, boolean flag)
    {
        if (!i) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag1;
        boolean flag2;
        flag1 = c.d.n();
        flag2 = c.d.o();
        o = null;
        if (long1 != null) goto _L4; else goto _L3
_L3:
        List list = c.h.d();
_L8:
        int i1 = list.size();
        if (i1 != 0) goto _L6; else goto _L5
_L5:
        Intent intent4 = n;
        if (intent4 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        ApplicationContext applicationcontext2 = c;
        Intent intent5 = n;
        applicationcontext2.stopService(intent5);
        n = null;
        ProgressNotificationManager progressnotificationmanager4 = o;
        if (progressnotificationmanager4 == null) goto _L1; else goto _L7
_L7:
        ProgressNotificationManager progressnotificationmanager5 = o;
        progressnotificationmanager5.a();
        return;
        Exception exception2;
        exception2;
_L14:
        com.appyet.d.d.a(exception2);
        return;
_L4:
        list = c.h.b(long1.longValue());
          goto _L8
_L19:
        o = new ProgressNotificationManager(c, i1, c.getResources().getString(0x7f080116));
_L20:
        n = new Intent(c, com/appyet/service/SyncService);
        c.startService(n);
        k = new ArrayBlockingQueue(10000);
        j = new ThreadPoolExecutor(10, 10, 10L, TimeUnit.SECONDS, k, b);
        l.set(0);
        m.set(i1);
          goto _L9
_L21:
        o.a(l.get(), (new StringBuilder()).append(c.getString(0x7f080055)).append(" (").append(l).append("/").append(m).append(") ").append(com.appyet.d.f.a((float)l.get() / (float)m.get())).toString());
_L22:
        Iterator iterator = list.iterator();
_L13:
        if (!iterator.hasNext()) goto _L11; else goto _L10
_L10:
        Feed feed = (Feed)iterator.next();
        if (i) goto _L11; else goto _L12
_L12:
        e = 0;
        j.execute(new bt(this, c, feed));
          goto _L13
        OutOfMemoryError outofmemoryerror1;
        outofmemoryerror1;
        com.appyet.d.d.a(outofmemoryerror1);
          goto _L13
        Exception exception3;
        exception3;
        com.appyet.d.d.a(exception3);
        if (n != null)
        {
            c.stopService(n);
            n = null;
        }
        if (o != null)
        {
            o.a();
            return;
        }
          goto _L1
        exception2;
          goto _L14
        Exception exception4;
        exception4;
        com.appyet.d.d.a(exception4);
          goto _L13
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        com.appyet.d.d.a(outofmemoryerror);
        Intent intent = n;
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_556;
        }
        ApplicationContext applicationcontext = c;
        Intent intent1 = n;
        applicationcontext.stopService(intent1);
        n = null;
        ProgressNotificationManager progressnotificationmanager = o;
        if (progressnotificationmanager == null) goto _L1; else goto _L15
_L15:
        ProgressNotificationManager progressnotificationmanager1 = o;
        try
        {
            progressnotificationmanager1.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception2) { }
          goto _L14
_L11:
        j.shutdown();
        j.awaitTermination(1800L, TimeUnit.SECONDS);
        j = null;
        k.clear();
        k = null;
        Intent intent2 = n;
        if (intent2 == null)
        {
            break MISSING_BLOCK_LABEL_658;
        }
        ApplicationContext applicationcontext1 = c;
        Intent intent3 = n;
        applicationcontext1.stopService(intent3);
        n = null;
        ProgressNotificationManager progressnotificationmanager2 = o;
        if (progressnotificationmanager2 == null) goto _L1; else goto _L16
_L16:
        ProgressNotificationManager progressnotificationmanager3 = o;
        try
        {
            progressnotificationmanager3.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception2) { }
          goto _L14
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
_L18:
        Exception exception;
        throw exception;
        exception;
        if (n != null)
        {
            c.stopService(n);
            n = null;
        }
        if (o != null)
        {
            o.a();
        }
        if (true) goto _L18; else goto _L17
_L17:
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
_L6:
        if ((!flag1 || !flag2) && !flag) goto _L20; else goto _L19
_L9:
        if ((!flag1 || !flag2) && !flag) goto _L22; else goto _L21
    }

    static int f(bq bq1)
    {
        int i1 = bq1.g;
        bq1.g = i1 + 1;
        return i1;
    }

    private void f(Long long1, boolean flag)
    {
_L2:
        return;
        if (i || c.g.a() == bo.a) goto _L2; else goto _L1
_L1:
        boolean flag1;
        boolean flag2;
        flag1 = c.d.n();
        flag2 = c.d.o();
        o = null;
        if (long1 != null) goto _L4; else goto _L3
_L3:
        List list = c.h.f();
_L8:
        int i1 = list.size();
        if (i1 != 0) goto _L6; else goto _L5
_L5:
        Intent intent4 = n;
        if (intent4 == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        ApplicationContext applicationcontext2 = c;
        Intent intent5 = n;
        applicationcontext2.stopService(intent5);
        n = null;
        ProgressNotificationManager progressnotificationmanager4 = o;
        if (progressnotificationmanager4 == null) goto _L2; else goto _L7
_L7:
        ProgressNotificationManager progressnotificationmanager5 = o;
        progressnotificationmanager5.a();
        return;
        Exception exception2;
        exception2;
_L14:
        com.appyet.d.d.a(exception2);
        return;
_L4:
        list = c.h.d(long1.longValue());
          goto _L8
_L19:
        o = new ProgressNotificationManager(c, i1, c.getResources().getString(0x7f080116));
_L20:
        n = new Intent(c, com/appyet/service/SyncService);
        c.startService(n);
        k = new ArrayBlockingQueue(10000);
        j = new ThreadPoolExecutor(10, 10, 10L, TimeUnit.SECONDS, k, b);
        l.set(0);
        m.set(i1);
          goto _L9
_L21:
        o.a(l.get(), (new StringBuilder()).append(c.getString(0x7f080054)).append(" (").append(l).append("/").append(m).append(") ").append(com.appyet.d.f.a((float)l.get() / (float)m.get())).toString());
_L22:
        Iterator iterator = list.iterator();
_L13:
        if (!iterator.hasNext()) goto _L11; else goto _L10
_L10:
        FileCache filecache;
        boolean flag3;
        filecache = (FileCache)iterator.next();
        flag3 = i;
        if (flag3) goto _L11; else goto _L12
_L12:
        j.execute(new bu(this, c, filecache));
          goto _L13
        OutOfMemoryError outofmemoryerror1;
        outofmemoryerror1;
        com.appyet.d.d.a(outofmemoryerror1);
          goto _L13
        Exception exception3;
        exception3;
        com.appyet.d.d.a(exception3);
        if (n != null)
        {
            c.stopService(n);
            n = null;
        }
        if (o != null)
        {
            o.a();
            return;
        }
          goto _L2
        exception2;
          goto _L14
        Exception exception4;
        exception4;
        com.appyet.d.d.a(exception4);
          goto _L13
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        com.appyet.d.d.a(outofmemoryerror);
        Intent intent = n;
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_571;
        }
        ApplicationContext applicationcontext = c;
        Intent intent1 = n;
        applicationcontext.stopService(intent1);
        n = null;
        ProgressNotificationManager progressnotificationmanager = o;
        if (progressnotificationmanager == null) goto _L2; else goto _L15
_L15:
        ProgressNotificationManager progressnotificationmanager1 = o;
        try
        {
            progressnotificationmanager1.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception2) { }
          goto _L14
_L11:
        j.shutdown();
        j.awaitTermination(1800L, TimeUnit.SECONDS);
        j = null;
        k.clear();
        k = null;
        Intent intent2 = n;
        if (intent2 == null)
        {
            break MISSING_BLOCK_LABEL_673;
        }
        ApplicationContext applicationcontext1 = c;
        Intent intent3 = n;
        applicationcontext1.stopService(intent3);
        n = null;
        ProgressNotificationManager progressnotificationmanager2 = o;
        if (progressnotificationmanager2 == null) goto _L2; else goto _L16
_L16:
        ProgressNotificationManager progressnotificationmanager3 = o;
        try
        {
            progressnotificationmanager3.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception2) { }
          goto _L14
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
_L18:
        Exception exception;
        throw exception;
        exception;
        if (n != null)
        {
            c.stopService(n);
            n = null;
        }
        if (o != null)
        {
            o.a();
        }
        if (true) goto _L18; else goto _L17
_L17:
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
        exception2;
          goto _L14
_L6:
        if ((!flag1 || !flag2) && !flag) goto _L20; else goto _L19
_L9:
        if ((!flag1 || !flag2) && !flag) goto _L22; else goto _L21
    }

    static ApplicationContext g(bq bq1)
    {
        return bq1.c;
    }

    public final int a()
    {
        return d;
    }

    public final void a(long l1)
    {
        try
        {
            (new bv(this, Long.valueOf(l1), true)).a(new Void[0]);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void a(Long long1, boolean flag)
    {
        android.os.PowerManager.WakeLock wakelock = null;
        int i1;
        c.a(1 + c.c());
        d = 0;
        f = 0;
        g = 0;
        h = 0;
        Date date3 = new Date();
        c.d.b(date3.getTime());
        i1 = c.c();
        if (i1 <= 1) goto _L2; else goto _L1
_L1:
        c.a(-1 + c.c());
        if (c.c() <= 0)
        {
            i = false;
        }
        Date date6 = new Date();
        c.d.b(date6.getTime());
        if (false)
        {
            null.release();
        }
_L11:
        System.gc();
        return;
_L2:
        bo bo1;
        ar.a(c);
        wakelock = ((PowerManager)c.getSystemService("power")).newWakeLock(1, (new StringBuilder()).append(c.getPackageName()).append("_WAKE_LOCK_TAG").toString());
        wakelock.setReferenceCounted(false);
        wakelock.acquire();
        bo1 = c.g.a();
        if (!c.d.m()) goto _L4; else goto _L3
_L3:
        if (bo1 == com.appyet.manager.bo.b)
        {
            e(long1, flag);
        }
_L13:
        bo bo2 = c.g.a();
        if (!c.d.m()) goto _L6; else goto _L5
_L5:
        if (bo2 == com.appyet.manager.bo.b)
        {
            c(long1, flag);
        }
_L15:
        bo bo3 = c.g.a();
        if (!c.d.r()) goto _L8; else goto _L7
_L7:
        if (bo3 == com.appyet.manager.bo.b)
        {
            f(long1, flag);
        }
_L17:
        bo bo4 = c.g.a();
        if (!c.d.s()) goto _L10; else goto _L9
_L9:
        if (bo4 == com.appyet.manager.bo.b)
        {
            d(long1, flag);
        }
_L19:
        String s3;
        String s4;
        String s5;
        long l2;
        Date date4 = new Date();
        s3 = (new StringBuilder()).append(c.q.MetadataApplication.AppSyncUrl).append("?guid=").append(c.q.MetadataApplication.Guid).append("&pkn=").append(c.getPackageName()).append("&tvc=").append(c.q.MetadataApplication.BuildTemplateVersionCode).toString();
        s4 = com.appyet.d.e.a(c.q.MetadataApplication.AppSyncUrl);
        s5 = (new StringBuilder()).append(s4).append("0").toString();
        long l1 = c.k.c(s4);
        l2 = date4.getTime() - l1;
        if (l2 >= 0L && l2 <= 0x5265c00L)
        {
            break MISSING_BLOCK_LABEL_685;
        }
        String s6;
        if (!c.k.a(s3, s5))
        {
            break MISSING_BLOCK_LABEL_685;
        }
        if (!c.k.g(s5))
        {
            break MISSING_BLOCK_LABEL_668;
        }
        s6 = c.k.b(s5, "UTF8");
        if (s6 == null)
        {
            break MISSING_BLOCK_LABEL_668;
        }
        if (s6.length() > 0 && s6.contains("Vendor"))
        {
            r r1 = new r();
            r1.a = "yyyy-MM-dd'T'HH:mm:ss";
            if ((MetadataAppSync)r1.a().a(s6, com/appyet/metadata/MetadataAppSync) != null)
            {
                c.k.a(c.k, s5, s4);
            }
        }
        c.g();
        c.e.a();
_L20:
        if (c.a || !c.d.n() || d <= 0)
        {
            break MISSING_BLOCK_LABEL_1482;
        }
        c.d.j(c.d.X() + d);
        NotificationManager notificationmanager = (NotificationManager)c.getSystemService("notification");
        Notification notification = new Notification(0x1080027, c.getString(0x7f080116), System.currentTimeMillis());
        notification.flags = 0x10 | notification.flags;
        Intent intent = new Intent(c, com/appyet/activity/MainActivity);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        PendingIntent pendingintent = PendingIntent.getActivity(c, 0, intent, 0x10000000);
        notification.icon = 0x7f020078;
        notification.number = c.d.X();
        ApplicationContext applicationcontext = c;
        String s1 = c.getString(0x7f080116);
        String s2 = c.getString(0x7f080056);
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(c.d.X());
        notification.setLatestEventInfo(applicationcontext, s1, String.format(s2, aobj), pendingintent);
        notification.sound = Uri.parse(c.d.p());
        if (c.d.u())
        {
            notification.defaults = 2 | notification.defaults;
        }
        if (c.d.v())
        {
            notification.defaults = 4 | notification.defaults;
        }
        notificationmanager.notify(0, notification);
_L21:
        (new by(c.u)).a(new Void[0]);
        if (c.e())
        {
            c.s.a();
        }
        if (c.d.w() > 0 || c.d.y() > 0)
        {
            c.h.a(c.d.y(), c.d.w(), c.d.x());
        }
        c.a(-1 + c.c());
        if (c.c() <= 0)
        {
            i = false;
        }
        Date date5 = new Date();
        c.d.b(date5.getTime());
        if (wakelock != null)
        {
            wakelock.release();
        }
          goto _L11
_L4:
        if (bo1 == bo.a) goto _L13; else goto _L12
_L12:
        e(long1, flag);
          goto _L13
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        c.a(-1 + c.c());
        if (c.c() <= 0)
        {
            i = false;
        }
        Date date2 = new Date();
        c.d.b(date2.getTime());
        if (wakelock != null)
        {
            wakelock.release();
        }
          goto _L11
_L6:
        if (bo2 == bo.a) goto _L15; else goto _L14
_L14:
        c(long1, flag);
          goto _L15
        Error error;
        error;
        com.appyet.d.d.a(error);
        c.a(-1 + c.c());
        if (c.c() <= 0)
        {
            i = false;
        }
        Date date1 = new Date();
        c.d.b(date1.getTime());
        if (wakelock != null)
        {
            wakelock.release();
        }
          goto _L11
_L8:
        if (bo3 == bo.a) goto _L17; else goto _L16
_L16:
        f(long1, flag);
          goto _L17
        Exception exception;
        exception;
        c.a(-1 + c.c());
        if (c.c() <= 0)
        {
            i = false;
        }
        Date date = new Date();
        c.d.b(date.getTime());
        if (wakelock != null)
        {
            wakelock.release();
        }
        System.gc();
        throw exception;
_L10:
        if (bo4 == bo.a) goto _L19; else goto _L18
_L18:
        d(long1, flag);
          goto _L19
        Exception exception2;
        exception2;
        com.appyet.d.d.a(exception2);
          goto _L20
        c.d.j(d);
          goto _L21
    }

    public final void a(boolean flag)
    {
        try
        {
            (new bv(this, null, flag)).a(new Void[0]);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void b()
    {
        i = true;
    }

    public final void c()
    {
        i = true;
        while (c.c() > 0) 
        {
            try
            {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedexception)
            {
                com.appyet.d.d.a(interruptedexception);
            }
            catch (OutOfMemoryError outofmemoryerror)
            {
                com.appyet.d.d.a(outofmemoryerror);
            }
        }
        i = false;
    }

    public final ProgressNotificationManager d()
    {
        return o;
    }

}
