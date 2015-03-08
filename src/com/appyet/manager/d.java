// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.context.ApplicationContext;
import com.appyet.context.e;
import com.appyet.data.DatabaseHelper;
import com.appyet.data.Feed;
import com.appyet.data.FeedItem;
import com.appyet.data.FileCache;
import com.appyet.data.Forum;
import com.appyet.data.Module;
import com.appyet.data.Web;
import com.appyet.data.Widget;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataModule;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.manager:
//            bp, y, ad, e, 
//            u, p, o, j, 
//            n, z, v, t, 
//            m, aa, ab, g, 
//            w, ac, x

public final class d
{

    public ApplicationContext a;
    public DatabaseHelper b;
    private String c[] = {
        "Author", "CommentsLink", "EnclosureCurrentPosition", "EnclosureDuration", "EnclosureLength", "EnclosureLink", "EnclosureType", "FeedId", "FeedItemId", "IsDeleted", 
        "IsRead", "IsStar", "Link", "PubDate", "Snippet", "Thumbnail", "Title", "UniqueKey", "ArticleStatus", "EnclosureStatus", 
        "IsQueued", "QueueOrder", "CacheGuid", "CommentsCount", "CommentsWebLink"
    };
    private String d[] = {
        "FeedId", "FeedItemId", "IsDeleted", "IsRead", "IsStar", "UniqueKey", "ArticleStatus", "EnclosureStatus", "IsQueued", "CommentsCount"
    };

    public d(ApplicationContext applicationcontext)
    {
        a = applicationcontext;
    }

    static long a(d d1, List list, int l)
    {
        Iterator iterator = d1.a.q.MetadataModules.iterator();
        Module module;
label0:
        do
        {
            if (iterator.hasNext())
            {
                MetadataModule metadatamodule = (MetadataModule)iterator.next();
                if (metadatamodule.Id != l)
                {
                    continue;
                }
                Iterator iterator1 = list.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    module = (Module)iterator1.next();
                } while (!module.getGuid().equals(metadatamodule.Guid));
                break;
            } else
            {
                return -1L;
            }
        } while (true);
        return module.getModuleId().longValue();
    }

    static void a(d d1)
    {
        d1.b.getFeedDao().updateRaw("UPDATE Feed SET UnreadCount = (SELECT COUNT(1) FROM FeedItem WHERE FeedItem.FeedId = Feed.FeedId and IsRead = 0 and IsDeleted = 0), TotalCount = (SELECT COUNT(1) FROM FeedItem WHERE FeedItem.FeedId = Feed.FeedId AND IsDeleted = 0)", new String[0]);
    }

    static void a(d d1, long l)
    {
        Dao dao = d1.b.getFeedDao();
        String as[] = new String[3];
        as[0] = String.valueOf(l);
        as[1] = String.valueOf(l);
        as[2] = String.valueOf(l);
        dao.updateRaw("UPDATE Feed SET UnreadCount = (SELECT COUNT(1) FROM FeedItem WHERE FeedId = ? and IsRead = 0 and IsDeleted = 0), TotalCount = (SELECT COUNT(1) FROM FeedItem WHERE FeedId = ? AND IsDeleted = 0) WHERE FeedId = ?", as);
    }

    private void a(QueryBuilder querybuilder)
    {
        if (a.d.d())
        {
            switch (y.a[a.d.f().ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                querybuilder.orderByRaw("IsStar DESC, IsRead ASC, PubDate DESC");
                return;

            case 2: // '\002'
                querybuilder.orderByRaw("IsStar DESC, IsRead DESC, PubDate DESC");
                return;

            case 3: // '\003'
                querybuilder.orderByRaw("IsStar DESC, PubDate ASC");
                return;

            case 4: // '\004'
                querybuilder.orderByRaw("IsStar DESC, PubDate DESC");
                return;

            case 5: // '\005'
                querybuilder.orderByRaw("IsStar DESC, CreatedDate ASC");
                return;

            case 6: // '\006'
                querybuilder.orderByRaw("IsStar DESC, CreatedDate DESC");
                return;

            case 7: // '\007'
                querybuilder.orderByRaw("IsStar DESC, Title ASC, PubDate DESC");
                break;
            }
            return;
        }
        switch (y.a[a.d.f().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            querybuilder.orderByRaw("IsRead ASC, PubDate DESC");
            return;

        case 2: // '\002'
            querybuilder.orderByRaw("IsRead DESC, PubDate DESC");
            return;

        case 3: // '\003'
            querybuilder.orderByRaw("PubDate ASC");
            return;

        case 4: // '\004'
            querybuilder.orderByRaw("PubDate DESC");
            return;

        case 5: // '\005'
            querybuilder.orderByRaw("CreatedDate ASC");
            return;

        case 6: // '\006'
            querybuilder.orderByRaw("CreatedDate DESC");
            return;

        case 7: // '\007'
            querybuilder.orderByRaw("Title ASC, PubDate DESC");
            break;
        }
    }

    private void a(Where where)
    {
        if (!a.d.c())
        {
            break MISSING_BLOCK_LABEL_27;
        }
        where.and().eq("IsRead", Boolean.valueOf(false));
        return;
        SQLException sqlexception;
        sqlexception;
        com.appyet.d.d.a(sqlexception);
        return;
    }

    public final int a(int l, int i1, boolean flag)
    {
        int j1;
        ad ad1 = new ad(this);
        TransactionManager.callInTransaction(b.getConnectionSource(), new com.appyet.manager.e(this, l, flag, ad1, i1));
        j1 = ad1.a;
        return j1;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        return 0;
        Exception exception;
        exception;
        throw exception;
    }

    public final Feed a(long l)
    {
        Feed feed;
        try
        {
            feed = (Feed)b.getFeedDao().queryForId(Long.valueOf(l));
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return feed;
    }

    public final FeedItem a(FeedItem feeditem)
    {
        FeedItem feeditem1;
        try
        {
            feeditem1 = (FeedItem)b.getFeedItemDao().queryForId(feeditem.getFeedItemId());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        if (feeditem1 == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        feeditem.setDescription(feeditem1.getDescription());
        feeditem.setArticle(feeditem1.getArticle());
        return feeditem;
    }

    public final List a(long l, long l1)
    {
        List list;
        try
        {
            Dao dao = b.getFeedItemDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            Where where = querybuilder.where();
            where.eq("IsDeleted", Boolean.valueOf(false));
            querybuilder.selectColumns(c);
            querybuilder.limit(Long.valueOf(l));
            querybuilder.offset(Long.valueOf(l1));
            a(querybuilder);
            a(where);
            list = dao.query(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final List a(Feed feed)
    {
        List list;
        try
        {
            Dao dao = b.getFeedItemDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            querybuilder.selectColumns(d);
            querybuilder.where().eq("FeedId", feed.getFeedId());
            querybuilder.orderByRaw("CreatedDate DESC, PubDate DESC");
            list = dao.query(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final List a(Long long1)
    {
        List list;
        try
        {
            Dao dao = b.getFeedItemDao();
            QueryBuilder querybuilder = b.getFeedDao().queryBuilder();
            querybuilder.selectColumns(new String[] {
                "FeedId"
            });
            querybuilder.where().eq("ModuleId", long1);
            QueryBuilder querybuilder1 = dao.queryBuilder();
            Where where = querybuilder1.where();
            where.eq("ArticleStatus", com.appyet.data.FeedItem.ArticleStatusEnum.DownloadPending);
            where.and().eq("IsDeleted", Boolean.valueOf(false));
            where.and().in("FeedId", querybuilder);
            list = dao.query(querybuilder1.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final List a(Long long1, long l, long l1)
    {
        ArrayList arraylist;
        try
        {
            Dao dao = b.getFeedDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            querybuilder.where().eq("ModuleId", long1);
            List list = dao.query(querybuilder.prepare());
            arraylist = new ArrayList();
            for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(((Feed)iterator.next()).getFeedId())) { }
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        List list1;
        Dao dao1 = b.getFeedItemDao();
        QueryBuilder querybuilder1 = dao1.queryBuilder();
        Where where = querybuilder1.where();
        where.eq("IsDeleted", Boolean.valueOf(false));
        where.and().in("FeedId", arraylist);
        querybuilder1.selectColumns(c);
        querybuilder1.limit(Long.valueOf(l));
        querybuilder1.offset(Long.valueOf(l1));
        a(querybuilder1);
        a(where);
        list1 = dao1.query(querybuilder1.prepare());
        return list1;
    }

    public final List a(String s)
    {
        List list;
        try
        {
            Dao dao = b.getFileCacheDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            querybuilder.where().eq("CacheGuid", s);
            list = dao.query(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final List a(String s, long l, long l1)
    {
        List list;
        try
        {
            Dao dao = b.getFeedItemDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            Where where = querybuilder.where();
            where.eq("IsDeleted", Boolean.valueOf(false));
            where.and().like("Description", (new StringBuilder("%")).append(s).append("%").toString());
            querybuilder.selectColumns(c);
            querybuilder.limit(Long.valueOf(l));
            querybuilder.offset(Long.valueOf(l1));
            a(querybuilder);
            a(where);
            list = dao.query(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final void a(long l, String s)
    {
        try
        {
            TransactionManager.callInTransaction(b.getConnectionSource(), new u(this, l, s));
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void a(long l, boolean flag)
    {
        TransactionManager.callInTransaction(b.getConnectionSource(), new p(this, flag, l));
        return;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(FeedItem feeditem, boolean flag)
    {
        try
        {
            TransactionManager.callInTransaction(b.getConnectionSource(), new o(this, flag, feeditem));
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void a(Long long1, com.appyet.data.FeedItem.ArticleStatusEnum articlestatusenum)
    {
        TransactionManager.callInTransaction(b.getConnectionSource(), new j(this, articlestatusenum, long1));
        return;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean a()
    {
        TransactionManager.callInTransaction(b.getConnectionSource(), new n(this));
        return true;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        return false;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean a(FileCache filecache)
    {
        if (filecache == null)
        {
            return false;
        }
        TransactionManager.callInTransaction(b.getConnectionSource(), new z(this, filecache));
        return true;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        return false;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean a(Widget widget)
    {
        try
        {
            TransactionManager.callInTransaction(b.getConnectionSource(), new v(this, widget));
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return false;
        }
        return true;
    }

    public final boolean a(List list)
    {
        TransactionManager.callInTransaction(b.getConnectionSource(), new t(this, list));
        return true;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        return false;
        Exception exception;
        exception;
        throw exception;
    }

    public final long b(String s)
    {
        long l;
        try
        {
            String s1 = s.replace("[NOW]", String.valueOf((new Date()).getTime()));
            Dao dao = b.getFeedItemDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            Where where = querybuilder.where();
            where.raw(s1, new ArgumentHolder[0]);
            where.and().eq("IsRead", Boolean.valueOf(false));
            querybuilder.setCountOf(true);
            querybuilder.selectColumns(c);
            a(querybuilder);
            a(where);
            l = dao.countOf(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return 0L;
        }
        return l;
    }

    public final List b()
    {
        List list;
        try
        {
            Dao dao = b.getFeedItemDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            Where where = querybuilder.where();
            where.eq("ArticleStatus", com.appyet.data.FeedItem.ArticleStatusEnum.DownloadPending);
            where.and().eq("IsDeleted", Boolean.valueOf(false));
            list = dao.query(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final List b(long l)
    {
        List list;
        try
        {
            list = b.getFeedDao().queryForEq("ModuleId", Long.valueOf(l));
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final List b(Long long1)
    {
        List list;
        try
        {
            Dao dao = b.getFeedItemDao();
            QueryBuilder querybuilder = b.getFeedDao().queryBuilder();
            querybuilder.selectColumns(new String[] {
                "FeedId"
            });
            querybuilder.where().eq("ModuleId", long1);
            QueryBuilder querybuilder1 = dao.queryBuilder();
            Where where = querybuilder1.where();
            where.eq("EnclosureStatus", com.appyet.data.FeedItem.EnclosureStatusEnum.DownloadPending);
            where.and().eq("IsDeleted", Boolean.valueOf(false));
            where.and().in("FeedId", querybuilder);
            list = dao.query(querybuilder1.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final List b(String s, long l, long l1)
    {
        List list;
        try
        {
            String s1 = s.replace("[NOW]", String.valueOf((new Date()).getTime()));
            Dao dao = b.getFeedItemDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            querybuilder.limit(Long.valueOf(l));
            querybuilder.offset(Long.valueOf(l1));
            Where where = querybuilder.where();
            where.raw(s1, new ArgumentHolder[0]);
            querybuilder.selectColumns(c);
            a(querybuilder);
            a(where);
            list = dao.query(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final void b(FeedItem feeditem)
    {
        try
        {
            TransactionManager.callInTransaction(b.getConnectionSource(), new m(this, feeditem));
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final boolean b(Feed feed)
    {
        int l;
        try
        {
            l = b.getFeedDao().update(feed);
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return false;
        }
        return l == 1;
    }

    public final boolean b(FileCache filecache)
    {
        int l;
        try
        {
            l = b.getFileCacheDao().update(filecache);
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return false;
        }
        return l == 1;
    }

    public final boolean b(Widget widget)
    {
        int l;
        try
        {
            Dao dao = b.getWidgetDao();
            UpdateBuilder updatebuilder = dao.updateBuilder();
            updatebuilder.where().eq("WidgetId", widget.getWidgetId());
            updatebuilder.updateColumnValue("Position", widget.getPosition());
            l = dao.update(updatebuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return false;
        }
        return l == 1;
    }

    public final boolean b(List list)
    {
        if (list == null || list.size() == 0)
        {
            return false;
        }
        TransactionManager.callInTransaction(b.getConnectionSource(), new aa(this, list));
        return true;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        return false;
        Exception exception;
        exception;
        throw exception;
    }

    public final FeedItem c(long l)
    {
        FeedItem feeditem;
        try
        {
            feeditem = (FeedItem)b.getFeedItemDao().queryForId(Long.valueOf(l));
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return feeditem;
    }

    public final List c()
    {
        List list;
        try
        {
            Dao dao = b.getFeedItemDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            Where where = querybuilder.where();
            where.eq("EnclosureStatus", com.appyet.data.FeedItem.EnclosureStatusEnum.DownloadPending);
            where.and().eq("IsDeleted", Boolean.valueOf(false));
            list = dao.query(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final List c(String s)
    {
        List list;
        try
        {
            String s1 = s.replace("[NOW]", String.valueOf((new Date()).getTime()));
            Dao dao = b.getFeedItemDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            querybuilder.limit(Long.valueOf(100L));
            Where where = querybuilder.where();
            where.raw(s1, new ArgumentHolder[0]);
            where.and().eq("IsRead", Boolean.valueOf(false));
            querybuilder.selectColumns(c);
            a(querybuilder);
            list = dao.query(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final boolean c(List list)
    {
        TransactionManager.callInTransaction(b.getConnectionSource(), new ab(this, list));
        return true;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        return false;
        Exception exception;
        exception;
        throw exception;
    }

    public final List d()
    {
        List list;
        try
        {
            list = b.getFeedDao().queryForAll();
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final List d(long l)
    {
        ArrayList arraylist;
        List list;
        int i1;
        String as1[];
        FileCache filecache;
        try
        {
            Dao dao = b.getFileCacheDao();
            String as[] = new String[1];
            as[0] = String.valueOf(l);
            list = dao.queryRaw("SELECT FileCache.FileCacheId, FileCache.CacheGuid, FileCache.DownloadAttempt, FileCache.DownloadStatus, FileCache.FileLink, FileCache.FileType, FileCache.FileCacheName FROM FileCache INNER JOIN FeedItem ON FileCache.CacheGuid = FeedItem.CacheGuid INNER JOIN Feed ON Feed.FeedId = FeedItem.FeedId WHERE FileCache.DownloadStatus = 'Pending' AND FeedItem.IsDeleted = 0 AND Feed.ModuleId = ?", as).getResults();
            arraylist = new ArrayList();
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        i1 = 0;
_L3:
        if (i1 >= list.size())
        {
            break MISSING_BLOCK_LABEL_207;
        }
        as1 = (String[])list.get(i1);
        filecache = new FileCache();
        filecache.setFileCacheId(Long.valueOf(Long.parseLong(as1[0])));
        filecache.setCacheGuid(as1[1]);
        if (as1[2] == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        filecache.setDownloadAttempt(Integer.valueOf(Integer.parseInt(as1[2])));
_L1:
        filecache.setDownloadStatus(as1[3]);
        filecache.setFileLink(as1[4]);
        filecache.setFileType(as1[5]);
        filecache.setFileCacheName(as1[6]);
        arraylist.add(filecache);
        i1++;
        continue; /* Loop/switch isn't completed */
        filecache.setDownloadAttempt(Integer.valueOf(0));
          goto _L1
        return arraylist;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public final void d(List list)
    {
        if (list == null || list.size() == 0)
        {
            return;
        }
        try
        {
            TransactionManager.callInTransaction(b.getConnectionSource(), new g(this, list));
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final List e()
    {
        List list;
        try
        {
            list = b.getFileCacheDao().queryForAll();
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final List e(long l)
    {
        List list;
        try
        {
            Dao dao = b.getFeedItemDao();
            QueryBuilder querybuilder = b.getFeedDao().queryBuilder();
            querybuilder.selectColumns(new String[] {
                "FeedId"
            });
            querybuilder.where().eq("ModuleId", Long.valueOf(l));
            QueryBuilder querybuilder1 = dao.queryBuilder();
            Where where = querybuilder1.where();
            where.eq("IsDeleted", Boolean.valueOf(false));
            where.and().eq("IsRead", Boolean.valueOf(false));
            where.and().in("FeedId", querybuilder);
            querybuilder1.selectColumns(c);
            a(querybuilder1);
            querybuilder1.limit(Long.valueOf(100L));
            com.j256.ormlite.stmt.PreparedQuery preparedquery = querybuilder1.prepare();
            querybuilder1.orderByRaw("CreatedDate DESC");
            list = dao.query(preparedquery);
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final boolean e(List list)
    {
        TransactionManager.callInTransaction(b.getConnectionSource(), new w(this, list));
        return true;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        return false;
        Exception exception;
        exception;
        throw exception;
    }

    public final List f()
    {
        List list;
        try
        {
            Dao dao = b.getFileCacheDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            querybuilder.where().eq("DownloadStatus", com.appyet.data.FileCache.DownloadStatusEnum.Pending);
            list = dao.query(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final boolean f(long l)
    {
        TransactionManager.callInTransaction(b.getConnectionSource(), new ac(this, l));
        return true;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        return false;
        Exception exception;
        exception;
        throw exception;
    }

    public final Module g(long l)
    {
        Module module;
        try
        {
            module = (Module)b.getModuleDao().queryForId(Long.valueOf(l));
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return module;
    }

    public final List g()
    {
        List list;
        try
        {
            Dao dao = b.getModuleDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            querybuilder.orderByRaw("SortOrder ASC, GroupName ASC, Name ASC");
            list = dao.query(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final Module h()
    {
        Module module;
        try
        {
            Dao dao = b.getModuleDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            querybuilder.where().eq("Type", "Downloads");
            module = (Module)dao.queryForFirst(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return module;
    }

    public final Web h(long l)
    {
        Web web;
        try
        {
            Dao dao = b.getWebDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            querybuilder.where().eq("ModuleId", Long.valueOf(l));
            web = (Web)dao.queryForFirst(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return web;
    }

    public final Forum i(long l)
    {
        Forum forum;
        try
        {
            Dao dao = b.getForumDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            querybuilder.where().eq("ModuleId", Long.valueOf(l));
            forum = (Forum)dao.queryForFirst(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return forum;
    }

    public final Module i()
    {
        Module module;
        try
        {
            Dao dao = b.getModuleDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            querybuilder.where().eq("Type", "Customize");
            module = (Module)dao.queryForFirst(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return module;
    }

    public final Widget j(long l)
    {
        Widget widget;
        try
        {
            Dao dao = b.getWidgetDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            querybuilder.where().eq("WidgetId", Long.valueOf(l));
            widget = (Widget)dao.queryForFirst(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return widget;
    }

    public final List j()
    {
        List list;
        try
        {
            Dao dao = b.getModuleDao();
            QueryBuilder querybuilder = dao.queryBuilder();
            querybuilder.orderByRaw("SortOrder ASC, GroupName ASC, Name ASC");
            querybuilder.where().eq("IsHidden", Boolean.valueOf(false));
            list = dao.query(querybuilder.prepare());
        }
        catch (SQLException sqlexception)
        {
            com.appyet.d.d.a(sqlexception);
            return null;
        }
        return list;
    }

    public final boolean k()
    {
        TransactionManager.callInTransaction(b.getConnectionSource(), new x(this));
        return true;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        return false;
        Exception exception;
        exception;
        throw exception;
    }
}
