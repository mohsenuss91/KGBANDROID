// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import java.util.Locale;

// Referenced classes of package com.appyet.data:
//            Feed, FeedItem, FileCache, Forum, 
//            Module, Web, Widget

public class DatabaseHelper extends OrmLiteSqliteOpenHelper
{

    public static final String DATABASE_NAME = "data2.db";
    private static final int DATABASE_VERSION = 7;
    private static final String OPTIMIZATION_SQL = "PRAGMA count_changes=OFF; VACUUM;";
    private Dao mFeedDao;
    private Dao mFeedItemDao;
    private Dao mFileCacheDao;
    private Dao mForumDao;
    private Dao mModuleDao;
    private Dao mWebDao;
    private Dao mWidgetDao;

    public DatabaseHelper(Context context)
    {
        super(context, "data2.db", null, 7, 0x7f060001);
    }

    private void upgradeDB(SQLiteDatabase sqlitedatabase, int i)
    {
        if (i < 2)
        {
            sqlitedatabase.execSQL("ALTER TABLE Module ADD COLUMN 'Layout' VARCHAR;");
        }
        if (i < 3)
        {
            sqlitedatabase.execSQL("ALTER TABLE Module ADD COLUMN 'IsHidden' SMALLINT;");
        }
        if (i < 4)
        {
            sqlitedatabase.execSQL("CREATE TABLE Widget ('WidgetId' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 'ModuleId' INTEGER, 'Position' INTEGER);");
        }
        if (i < 5)
        {
            sqlitedatabase.execSQL("ALTER TABLE Feed ADD COLUMN 'ArticleNumberLimit' INTEGER;");
        }
        if (i < 6)
        {
            sqlitedatabase.execSQL("CREATE TABLE Forum (ForumId INTEGER PRIMARY KEY AUTOINCREMENT , ModuleId INTEGER , Guid VARCHAR, Type VARCHAR , Link VARCHAR);");
        }
        if (i < 7)
        {
            sqlitedatabase.execSQL("ALTER TABLE FeedItem ADD COLUMN 'CommentsCount' INTEGER;");
            sqlitedatabase.execSQL("ALTER TABLE FeedItem ADD COLUMN 'CommentsWebLink' INTEGER;");
        }
    }

    public Dao getFeedDao()
    {
        if (mFeedDao == null)
        {
            mFeedDao = getDao(com/appyet/data/Feed);
        }
        return mFeedDao;
    }

    public Dao getFeedItemDao()
    {
        if (mFeedItemDao == null)
        {
            mFeedItemDao = getDao(com/appyet/data/FeedItem);
        }
        return mFeedItemDao;
    }

    public Dao getFileCacheDao()
    {
        if (mFileCacheDao == null)
        {
            mFileCacheDao = getDao(com/appyet/data/FileCache);
        }
        return mFileCacheDao;
    }

    public Dao getForumDao()
    {
        if (mForumDao == null)
        {
            mForumDao = getDao(com/appyet/data/Forum);
        }
        return mForumDao;
    }

    public Dao getModuleDao()
    {
        if (mModuleDao == null)
        {
            mModuleDao = getDao(com/appyet/data/Module);
        }
        return mModuleDao;
    }

    public Dao getWebDao()
    {
        if (mWebDao == null)
        {
            mWebDao = getDao(com/appyet/data/Web);
        }
        return mWebDao;
    }

    public Dao getWidgetDao()
    {
        if (mWidgetDao == null)
        {
            mWidgetDao = getDao(com/appyet/data/Widget);
        }
        return mWidgetDao;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource)
    {
        sqlitedatabase.execSQL("CREATE TABLE Module (ModuleId INTEGER PRIMARY KEY AUTOINCREMENT , Guid VARCHAR, Type VARCHAR , Name VARCHAR , GroupName VARCHAR , StatusLabel VARCHAR , Icon VARCHAR , SortOrder INTEGER);");
        sqlitedatabase.execSQL("CREATE TABLE Feed (FeedId INTEGER PRIMARY KEY AUTOINCREMENT , Guid VARCHAR, ModuleId INTEGER , Encoding VARCHAR , FavIcon VARCHAR , ImageLink VARCHAR, FeedType VARCHAR , Link VARCHAR NOT NULL , PubDate BIGINT , Title VARCHAR , TotalCount INTEGER DEFAULT 0 , UnreadCount INTEGER DEFAULT 0 , WebLink VARCHAR, StreamHash VARCHAR, SyncDate BIGINT, IsAutoMobilize SMALLINT, MobilizeProvider VARCHAR, IsDownloadNewEnclosure SMALLINT, CacheGuid VARCHAR, HTTPLastModified VARCHAR, HTTPETag VARCHAR);");
        sqlitedatabase.execSQL("CREATE TABLE FeedItem (FeedItemId INTEGER PRIMARY KEY AUTOINCREMENT , FeedId INTEGER , Author VARCHAR , CommentsLink VARCHAR , Description VARCHAR , EnclosureCurrentPosition INTEGER , EnclosureDuration INTEGER , EnclosureLength INTEGER , EnclosureLink VARCHAR , EnclosureType VARCHAR , Title VARCHAR , Thumbnail VARCHAR , Snippet VARCHAR , PubDate BIGINT NOT NULL , UniqueKey VARCHAR , Link VARCHAR , IsStar SMALLINT , IsRead SMALLINT , IsDeleted SMALLINT , IsQueued SMALLINT, QueueOrder INTEGER, ArticleStatus SMALLINT, EnclosureStatus SMALLINT, Article VARCHAR, CacheGuid VARCHAR, CreatedDate INTEGER);");
        sqlitedatabase.execSQL("CREATE TABLE Web (WebId INTEGER PRIMARY KEY AUTOINCREMENT , ModuleId INTEGER , Guid VARCHAR, Type VARCHAR , Data VARCHAR);");
        sqlitedatabase.execSQL("CREATE TABLE FileCache(FileCacheId INTEGER PRIMARY KEY AUTOINCREMENT , DownloadAttempt INTEGER DEFAULT 0 NOT NULL , DownloadStatus VARCHAR NOT NULL , FileCacheName VARCHAR NOT NULL , FileLink VARCHAR NOT NULL , FileType VARCHAR NOT NULL, CacheGuid VARCHAR);");
        sqlitedatabase.execSQL("CREATE INDEX IDX_FeedItem_FeedId ON FeedItem(FeedId);");
        upgradeDB(sqlitedatabase, 0);
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.setLocale(Locale.getDefault());
        super.onOpen(sqlitedatabase);
        sqlitedatabase.execSQL("PRAGMA count_changes=OFF; VACUUM;");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int i, int j)
    {
        upgradeDB(sqlitedatabase, i);
    }
}
