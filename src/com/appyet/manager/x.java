// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.content.res.AssetManager;
import android.content.res.Resources;
import com.appyet.context.ApplicationContext;
import com.appyet.data.DatabaseHelper;
import com.appyet.data.Feed;
import com.appyet.data.FeedItem;
import com.appyet.data.Forum;
import com.appyet.data.Module;
import com.appyet.data.Web;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataModule;
import com.appyet.metadata.MetadataModuleFeed;
import com.appyet.metadata.MetadataModuleForum;
import com.appyet.metadata.MetadataModuleWeb;
import com.j256.ormlite.dao.Dao;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d

final class x
    implements Callable
{

    final d a;

    x(d d1)
    {
        a = d1;
        super();
    }

    public final Object call()
    {
        Dao dao;
        Dao dao1;
        Dao dao2;
        Dao dao3;
        Dao dao4;
        List list;
        List list1;
        Iterator iterator;
        dao = a.b.getFeedDao();
        dao1 = a.b.getFeedItemDao();
        dao2 = a.b.getModuleDao();
        dao3 = a.b.getWebDao();
        dao4 = a.b.getForumDao();
        list = dao2.queryForAll();
        list1 = Arrays.asList(a.a.getResources().getAssets().list("module"));
        iterator = a.a.q.MetadataModules.iterator();
_L2:
        MetadataModule metadatamodule1;
        boolean flag7;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        metadatamodule1 = (MetadataModule)iterator.next();
        Iterator iterator18 = list.iterator();
        Module module2;
        do
        {
            if (!iterator18.hasNext())
            {
                break MISSING_BLOCK_LABEL_1912;
            }
            module2 = (Module)iterator18.next();
        } while (!module2.getGuid().equals(metadatamodule1.Guid));
        module2.setName(metadatamodule1.Name);
        module2.setType(metadatamodule1.Type);
        module2.setGroupName(metadatamodule1.GroupName);
        module2.setSortOrder(metadatamodule1.SortOrder);
        if (list1.contains((new StringBuilder("m")).append(metadatamodule1.Id).append(".png").toString()))
        {
            module2.setIcon((new StringBuilder("m")).append(metadatamodule1.Id).append(".png").toString());
        } else
        if (metadatamodule1.DefaultIcon != null && list1.contains(metadatamodule1.DefaultIcon))
        {
            module2.setIcon(metadatamodule1.DefaultIcon);
        }
        if (module2.getLayout() == null && metadatamodule1.DefaultLayout != null)
        {
            module2.setLayout(metadatamodule1.DefaultLayout);
        }
        module2.setIsHidden(metadatamodule1.IsHidden);
        dao2.update(module2);
        flag7 = true;
_L24:
        if (!flag7)
        {
            Module module1 = new Module();
            module1.setType(metadatamodule1.Type);
            module1.setName(metadatamodule1.Name);
            module1.setGroupName(metadatamodule1.GroupName);
            module1.setSortOrder(metadatamodule1.SortOrder);
            module1.setGuid(metadatamodule1.Guid);
            if (list1.contains((new StringBuilder("m")).append(metadatamodule1.Id).append(".png").toString()))
            {
                module1.setIcon((new StringBuilder("m")).append(metadatamodule1.Id).append(".png").toString());
            } else
            if (metadatamodule1.DefaultIcon != null && list1.contains(metadatamodule1.DefaultIcon))
            {
                module1.setIcon(metadatamodule1.DefaultIcon);
            }
            if (metadatamodule1.DefaultLayout != null)
            {
                module1.setLayout(metadatamodule1.DefaultLayout);
            }
            module1.setIsHidden(metadatamodule1.IsHidden);
            dao2.create(module1);
        }
        if (true) goto _L2; else goto _L1
_L1:
        Iterator iterator1 = list.iterator();
_L4:
        Module module;
        boolean flag6;
        if (!iterator1.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        module = (Module)iterator1.next();
        Iterator iterator15 = a.a.q.MetadataModules.iterator();
        MetadataModule metadatamodule;
        do
        {
            if (!iterator15.hasNext())
            {
                break MISSING_BLOCK_LABEL_1906;
            }
            metadatamodule = (MetadataModule)iterator15.next();
        } while (!module.getGuid().equals(metadatamodule.Guid));
        flag6 = true;
_L23:
        if (!flag6)
        {
            dao2.delete(module);
            for (Iterator iterator16 = dao.queryForEq("ModuleId", module.getModuleId()).iterator(); iterator16.hasNext();)
            {
                Feed feed3 = (Feed)iterator16.next();
                dao.delete(feed3);
                Iterator iterator17 = dao1.queryForEq("FeedId", feed3.getFeedId()).iterator();
                while (iterator17.hasNext()) 
                {
                    dao1.delete((FeedItem)iterator17.next());
                }
            }

            a.a();
        }
        if (true) goto _L4; else goto _L3
_L3:
        List list2;
        List list3;
        Iterator iterator2;
        list2 = dao.queryForAll();
        list3 = dao2.queryForAll();
        iterator2 = a.a.q.MetadataModuleFeeds.iterator();
_L6:
        MetadataModuleFeed metadatamodulefeed1;
        boolean flag5;
        if (!iterator2.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        metadatamodulefeed1 = (MetadataModuleFeed)iterator2.next();
        Iterator iterator14 = list2.iterator();
        Feed feed2;
        do
        {
            if (!iterator14.hasNext())
            {
                break MISSING_BLOCK_LABEL_1900;
            }
            feed2 = (Feed)iterator14.next();
        } while (!feed2.getGuid().equals(metadatamodulefeed1.Guid));
        feed2.setLink(metadatamodulefeed1.FeedUrl);
        feed2.setEncoding(metadatamodulefeed1.Encoding);
        feed2.setCacheGuid(UUID.randomUUID().toString());
        feed2.setIsAutoMobilize(metadatamodulefeed1.IsAutoMobilize);
        feed2.setArticleNumberLimit(metadatamodulefeed1.ArticleNumberLimit);
        dao.update(feed2);
        flag5 = true;
_L22:
        if (!flag5)
        {
            Feed feed1 = new Feed();
            feed1.setLink(metadatamodulefeed1.FeedUrl);
            feed1.setEncoding(metadatamodulefeed1.Encoding);
            feed1.setModuleId(d.a(a, list3, metadatamodulefeed1.ModuleId));
            feed1.setCacheGuid(UUID.randomUUID().toString());
            feed1.setGuid(metadatamodulefeed1.Guid);
            feed1.setIsAutoMobilize(metadatamodulefeed1.IsAutoMobilize);
            feed1.setArticleNumberLimit(metadatamodulefeed1.ArticleNumberLimit);
            dao.create(feed1);
        }
        if (true) goto _L6; else goto _L5
_L5:
        Iterator iterator3 = list2.iterator();
_L8:
        Feed feed;
        boolean flag4;
        if (!iterator3.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        feed = (Feed)iterator3.next();
        Iterator iterator12 = a.a.q.MetadataModuleFeeds.iterator();
        MetadataModuleFeed metadatamodulefeed;
        do
        {
            if (!iterator12.hasNext())
            {
                break MISSING_BLOCK_LABEL_1894;
            }
            metadatamodulefeed = (MetadataModuleFeed)iterator12.next();
        } while (!feed.getGuid().equals(metadatamodulefeed.Guid));
        flag4 = true;
_L21:
        if (!flag4)
        {
            dao.delete(feed);
            for (Iterator iterator13 = dao1.queryForEq("FeedId", feed.getFeedId()).iterator(); iterator13.hasNext(); dao1.delete((FeedItem)iterator13.next())) { }
            a.a();
        }
        if (true) goto _L8; else goto _L7
_L7:
        List list4;
        List list5;
        Iterator iterator4;
        list4 = dao3.queryForAll();
        list5 = dao2.queryForAll();
        iterator4 = a.a.q.MetadataModuleWebs.iterator();
_L10:
        MetadataModuleWeb metadatamoduleweb1;
        boolean flag3;
        if (!iterator4.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        metadatamoduleweb1 = (MetadataModuleWeb)iterator4.next();
        Iterator iterator11 = list4.iterator();
        Web web2;
        do
        {
            if (!iterator11.hasNext())
            {
                break MISSING_BLOCK_LABEL_1888;
            }
            web2 = (Web)iterator11.next();
        } while (!web2.getGuid().equals(metadatamoduleweb1.Guid));
        web2.setType(metadatamoduleweb1.Type);
        web2.setData(metadatamoduleweb1.Data);
        dao3.update(web2);
        flag3 = true;
_L20:
        if (!flag3)
        {
            Web web1 = new Web();
            web1.setType(metadatamoduleweb1.Type);
            web1.setData(metadatamoduleweb1.Data);
            web1.setModuleId(Long.valueOf(d.a(a, list5, metadatamoduleweb1.ModuleId)));
            web1.setGuid(metadatamoduleweb1.Guid);
            dao3.create(web1);
        }
        if (true) goto _L10; else goto _L9
_L9:
        Iterator iterator5 = list4.iterator();
_L12:
        Web web;
        boolean flag2;
        if (!iterator5.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        web = (Web)iterator5.next();
        Iterator iterator10 = a.a.q.MetadataModuleWebs.iterator();
        MetadataModuleWeb metadatamoduleweb;
        do
        {
            if (!iterator10.hasNext())
            {
                break MISSING_BLOCK_LABEL_1882;
            }
            metadatamoduleweb = (MetadataModuleWeb)iterator10.next();
        } while (!web.getGuid().equals(metadatamoduleweb.Guid));
        flag2 = true;
_L19:
        if (!flag2)
        {
            dao3.delete(web);
        }
        if (true) goto _L12; else goto _L11
_L11:
        List list6;
        List list7;
        Iterator iterator6;
        list6 = dao4.queryForAll();
        list7 = dao2.queryForAll();
        iterator6 = a.a.q.MetadataModuleForums.iterator();
_L14:
        MetadataModuleForum metadatamoduleforum1;
        boolean flag1;
        if (!iterator6.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        metadatamoduleforum1 = (MetadataModuleForum)iterator6.next();
        Iterator iterator9 = list6.iterator();
        Forum forum2;
        do
        {
            if (!iterator9.hasNext())
            {
                break MISSING_BLOCK_LABEL_1876;
            }
            forum2 = (Forum)iterator9.next();
        } while (!forum2.getGuid().equals(metadatamoduleforum1.Guid));
        forum2.setLink(metadatamoduleforum1.ForumUrl);
        dao4.update(forum2);
        flag1 = true;
_L18:
        if (!flag1)
        {
            Forum forum1 = new Forum();
            forum1.setLink(metadatamoduleforum1.ForumUrl);
            forum1.setModuleId(Long.valueOf(d.a(a, list7, metadatamoduleforum1.ModuleId)));
            forum1.setGuid(metadatamoduleforum1.Guid);
            dao4.create(forum1);
        }
        if (true) goto _L14; else goto _L13
_L13:
        Iterator iterator7 = list6.iterator();
_L16:
        Forum forum;
        boolean flag;
        if (!iterator7.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        forum = (Forum)iterator7.next();
        Iterator iterator8 = a.a.q.MetadataModuleForums.iterator();
        MetadataModuleForum metadatamoduleforum;
        do
        {
            if (!iterator8.hasNext())
            {
                break MISSING_BLOCK_LABEL_1870;
            }
            metadatamoduleforum = (MetadataModuleForum)iterator8.next();
        } while (!forum.getGuid().equals(metadatamoduleforum.Guid));
        flag = true;
_L17:
        if (!flag)
        {
            dao4.delete(forum);
        }
        if (true) goto _L16; else goto _L15
_L15:
        return null;
        flag = false;
          goto _L17
        flag1 = false;
          goto _L18
        flag2 = false;
          goto _L19
        flag3 = false;
          goto _L20
        flag4 = false;
          goto _L21
        flag5 = false;
          goto _L22
        flag6 = false;
          goto _L23
        flag7 = false;
          goto _L24
    }
}
