// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.google.analytics.tracking.android:
//            AnalyticsStore, SimpleNetworkDispatcher, HitBuilder, Log, 
//            AnalyticsStoreStateListener, Dispatcher, Hit, Clock, 
//            GAServiceManager, NoopDispatcher

class PersistentAnalyticsStore
    implements AnalyticsStore
{

    private static final String CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[] {
        "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"
    });
    private static final String DATABASE_FILENAME = "google_analytics_v2.db";
    static final String HITS_TABLE = "hits2";
    static final String HIT_APP_ID = "hit_app_id";
    static final String HIT_ID = "hit_id";
    static final String HIT_STRING = "hit_string";
    static final String HIT_TIME = "hit_time";
    static final String HIT_URL = "hit_url";
    private Clock mClock;
    private final Context mContext;
    private final String mDatabaseName;
    private final AnalyticsDatabaseHelper mDbHelper;
    private volatile Dispatcher mDispatcher;
    private long mLastDeleteStaleHitsTime;
    private final AnalyticsStoreStateListener mListener;

    PersistentAnalyticsStore(AnalyticsStoreStateListener analyticsstorestatelistener, Context context)
    {
        this(analyticsstorestatelistener, context, "google_analytics_v2.db");
    }

    PersistentAnalyticsStore(AnalyticsStoreStateListener analyticsstorestatelistener, Context context, String s)
    {
        mContext = context.getApplicationContext();
        mDatabaseName = s;
        mListener = analyticsstorestatelistener;
        mClock = new _cls1();
        mDbHelper = new AnalyticsDatabaseHelper(mContext, mDatabaseName);
        mDispatcher = new SimpleNetworkDispatcher(new DefaultHttpClient(), mContext);
        mLastDeleteStaleHitsTime = 0L;
    }

    private void fillVersionParameter(Map map, Collection collection)
    {
label0:
        {
            String s = "&_v".substring(1);
            if (collection == null)
            {
                break label0;
            }
            Iterator iterator = collection.iterator();
            Command command;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                command = (Command)iterator.next();
            } while (!"appendVersion".equals(command.getId()));
            map.put(s, command.getValue());
        }
    }

    static String generateHitString(Map map)
    {
        ArrayList arraylist = new ArrayList(map.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); arraylist.add((new StringBuilder()).append(HitBuilder.encode((String)entry.getKey())).append("=").append(HitBuilder.encode((String)entry.getValue())).toString()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return TextUtils.join("&", arraylist);
    }

    private SQLiteDatabase getWritableDatabase(String s)
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = mDbHelper.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            Log.w(s);
            return null;
        }
        return sqlitedatabase;
    }

    private void removeOldHitIfFull()
    {
        int i = 1 + (-2000 + getNumStoredHits());
        if (i > 0)
        {
            List list = peekHitIds(i);
            Log.v((new StringBuilder("Store full, deleting ")).append(list.size()).append(" hits to make room.").toString());
            deleteHits((String[])list.toArray(new String[0]));
        }
    }

    private void writeHitToDatabase(Map map, long l, String s)
    {
        SQLiteDatabase sqlitedatabase;
        ContentValues contentvalues;
        sqlitedatabase = getWritableDatabase("Error opening database for putHit");
        if (sqlitedatabase == null)
        {
            return;
        }
        contentvalues = new ContentValues();
        contentvalues.put("hit_string", generateHitString(map));
        contentvalues.put("hit_time", Long.valueOf(l));
        if (!map.containsKey("AppUID")) goto _L2; else goto _L1
_L1:
        long l2 = Long.parseLong((String)map.get("AppUID"));
        long l1 = l2;
_L4:
        contentvalues.put("hit_app_id", Long.valueOf(l1));
        if (s == null)
        {
            s = "http://www.google-analytics.com/collect";
        }
        if (s.length() == 0)
        {
            Log.w("Empty path: not sending hit");
            return;
        }
        break; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
_L2:
        l1 = 0L;
        if (true) goto _L4; else goto _L3
_L3:
        contentvalues.put("hit_url", s);
        try
        {
            sqlitedatabase.insert("hits2", null, contentvalues);
            mListener.reportStoreIsEmpty(false);
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            Log.w("Error storing hit");
        }
        return;
    }

    public void clearHits(long l)
    {
        boolean flag = true;
        SQLiteDatabase sqlitedatabase = getWritableDatabase("Error opening database for clearHits");
        if (sqlitedatabase != null)
        {
            AnalyticsStoreStateListener analyticsstorestatelistener;
            if (l == 0L)
            {
                sqlitedatabase.delete("hits2", null, null);
            } else
            {
                String as[] = new String[flag];
                as[0] = Long.valueOf(l).toString();
                sqlitedatabase.delete("hits2", "hit_app_id = ?", as);
            }
            analyticsstorestatelistener = mListener;
            if (getNumStoredHits() != 0)
            {
                flag = false;
            }
            analyticsstorestatelistener.reportStoreIsEmpty(flag);
        }
    }

    public void close()
    {
        try
        {
            mDbHelper.getWritableDatabase().close();
            mDispatcher.close();
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            Log.w("Error opening database for close");
        }
    }

    void deleteHits(Collection collection)
    {
        if (collection == null || collection.isEmpty())
        {
            Log.w("Empty/Null collection passed to deleteHits.");
            return;
        }
        String as[] = new String[collection.size()];
        Iterator iterator = collection.iterator();
        int j;
        for (int i = 0; iterator.hasNext(); i = j)
        {
            Hit hit = (Hit)iterator.next();
            j = i + 1;
            as[i] = String.valueOf(hit.getHitId());
        }

        deleteHits(as);
    }

    void deleteHits(String as[])
    {
        boolean flag = true;
        if (as != null && as.length != 0) goto _L2; else goto _L1
_L1:
        Log.w("Empty hitIds passed to deleteHits.");
_L4:
        return;
_L2:
        SQLiteDatabase sqlitedatabase = getWritableDatabase("Error opening database for deleteHits.");
        if (sqlitedatabase == null) goto _L4; else goto _L3
_L3:
        String s;
        Object aobj[] = new Object[flag];
        aobj[0] = TextUtils.join(",", Collections.nCopies(as.length, "?"));
        s = String.format("HIT_ID in (%s)", aobj);
        AnalyticsStoreStateListener analyticsstorestatelistener;
        sqlitedatabase.delete("hits2", s, as);
        analyticsstorestatelistener = mListener;
        SQLiteException sqliteexception;
        if (getNumStoredHits() != 0)
        {
            flag = false;
        }
        analyticsstorestatelistener.reportStoreIsEmpty(flag);
        return;
        sqliteexception;
        Log.w((new StringBuilder("Error deleting hits ")).append(as).toString());
        return;
    }

    int deleteStaleHits()
    {
        boolean flag = true;
        long l = mClock.currentTimeMillis();
        if (l > 0x5265c00L + mLastDeleteStaleHitsTime)
        {
            mLastDeleteStaleHitsTime = l;
            SQLiteDatabase sqlitedatabase = getWritableDatabase("Error opening database for deleteStaleHits.");
            if (sqlitedatabase != null)
            {
                long l1 = mClock.currentTimeMillis() - 0x9a7ec800L;
                String as[] = new String[flag];
                as[0] = Long.toString(l1);
                int i = sqlitedatabase.delete("hits2", "HIT_TIME < ?", as);
                AnalyticsStoreStateListener analyticsstorestatelistener = mListener;
                if (getNumStoredHits() != 0)
                {
                    flag = false;
                }
                analyticsstorestatelistener.reportStoreIsEmpty(flag);
                return i;
            }
        }
        return 0;
    }

    public void dispatch()
    {
        Log.v("Dispatch running...");
        if (mDispatcher.okToDispatch())
        {
            List list = peekHits(40);
            if (list.isEmpty())
            {
                Log.v("...nothing to dispatch");
                mListener.reportStoreIsEmpty(true);
                return;
            }
            int i = mDispatcher.dispatchHits(list);
            Log.v((new StringBuilder("sent ")).append(i).append(" of ").append(list.size()).append(" hits").toString());
            deleteHits(list.subList(0, Math.min(i, list.size())));
            if (i == list.size() && getNumStoredHits() > 0)
            {
                GAServiceManager.getInstance().dispatchLocalHits();
                return;
            }
        }
    }

    public AnalyticsDatabaseHelper getDbHelper()
    {
        return mDbHelper;
    }

    public Dispatcher getDispatcher()
    {
        return mDispatcher;
    }

    AnalyticsDatabaseHelper getHelper()
    {
        return mDbHelper;
    }

    int getNumStoredHits()
    {
        Cursor cursor;
        SQLiteDatabase sqlitedatabase;
        int i;
        cursor = null;
        sqlitedatabase = getWritableDatabase("Error opening database for getNumStoredHits.");
        i = 0;
        if (sqlitedatabase != null) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        boolean flag;
        cursor = sqlitedatabase.rawQuery("SELECT COUNT(*) from hits2", null);
        flag = cursor.moveToFirst();
        i = 0;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        long l = cursor.getLong(0);
        i = (int)l;
        if (cursor == null) goto _L1; else goto _L3
_L3:
        cursor.close();
        return i;
        SQLiteException sqliteexception;
        sqliteexception;
        Log.w("Error getting numStoredHits");
        i = 0;
        if (cursor == null) goto _L1; else goto _L4
_L4:
        cursor.close();
        return 0;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
    }

    List peekHitIds(int i)
    {
        ArrayList arraylist;
        SQLiteDatabase sqlitedatabase;
        arraylist = new ArrayList();
        if (i <= 0)
        {
            Log.w("Invalid maxHits specified. Skipping");
            return arraylist;
        }
        sqlitedatabase = getWritableDatabase("Error opening database for peekHitIds.");
        if (sqlitedatabase == null)
        {
            return arraylist;
        }
        Cursor cursor1 = sqlitedatabase.query("hits2", new String[] {
            "hit_id"
        }, null, null, null, null, String.format("%s ASC", new Object[] {
            "hit_id"
        }), Integer.toString(i));
        Cursor cursor = cursor1;
        boolean flag;
        if (cursor.moveToFirst())
        {
            do
            {
                arraylist.add(String.valueOf(cursor.getLong(0)));
                flag = cursor.moveToNext();
            } while (flag);
        }
        if (cursor != null)
        {
            cursor.close();
        }
_L1:
        return arraylist;
        SQLiteException sqliteexception;
        sqliteexception;
        cursor = null;
_L4:
        Log.w((new StringBuilder("Error in peekHits fetching hitIds: ")).append(sqliteexception.getMessage()).toString());
        if (cursor != null)
        {
            cursor.close();
        }
          goto _L1
        Exception exception;
        exception;
        cursor = null;
_L3:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        exception;
        if (true) goto _L3; else goto _L2
_L2:
        sqliteexception;
          goto _L4
    }

    public List peekHits(int i)
    {
        ArrayList arraylist;
        SQLiteDatabase sqlitedatabase;
        arraylist = new ArrayList();
        sqlitedatabase = getWritableDatabase("Error opening database for peekHits");
        if (sqlitedatabase != null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist1 = arraylist;
_L8:
        return arraylist1;
_L2:
        Cursor cursor = null;
        Cursor cursor2 = sqlitedatabase.query("hits2", new String[] {
            "hit_id", "hit_time"
        }, null, null, null, null, String.format("%s ASC", new Object[] {
            "hit_id"
        }), Integer.toString(i));
        Cursor cursor3 = cursor2;
        ArrayList arraylist2 = new ArrayList();
        boolean flag;
        if (cursor3.moveToFirst())
        {
            do
            {
                arraylist2.add(new Hit(null, cursor3.getLong(0), cursor3.getLong(1)));
                flag = cursor3.moveToNext();
            } while (flag);
        }
        if (cursor3 != null)
        {
            cursor3.close();
        }
        Cursor cursor4 = sqlitedatabase.query("hits2", new String[] {
            "hit_id", "hit_string", "hit_url"
        }, null, null, null, null, String.format("%s ASC", new Object[] {
            "hit_id"
        }), Integer.toString(i));
        if (!cursor4.moveToFirst()) goto _L4; else goto _L3
_L3:
        int j = 0;
_L22:
        if (((SQLiteCursor)cursor4).getWindow().getNumRows() <= 0) goto _L6; else goto _L5
_L5:
        ((Hit)arraylist2.get(j)).setHitString(cursor4.getString(1));
        ((Hit)arraylist2.get(j)).setHitUrl(cursor4.getString(2));
_L9:
        int k = j + 1;
        boolean flag2 = cursor4.moveToNext();
        if (flag2)
        {
            break MISSING_BLOCK_LABEL_625;
        }
_L4:
        if (cursor4 != null)
        {
            cursor4.close();
        }
        return arraylist2;
        SQLiteException sqliteexception;
        sqliteexception;
        SQLiteException sqliteexception1;
        Cursor cursor1;
        sqliteexception1 = sqliteexception;
        cursor1 = null;
        arraylist1 = arraylist;
_L21:
        Log.w((new StringBuilder("Error in peekHits fetching hitIds: ")).append(sqliteexception1.getMessage()).toString());
        if (cursor1 == null) goto _L8; else goto _L7
_L7:
        cursor1.close();
        return arraylist1;
        Exception exception;
        exception;
_L20:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
_L6:
        Object aobj[] = new Object[1];
        aobj[0] = Long.valueOf(((Hit)arraylist2.get(j)).getHitId());
        Log.w(String.format("HitString for hitId %d too large.  Hit will be deleted.", aobj));
          goto _L9
        SQLiteException sqliteexception3;
        sqliteexception3;
        cursor3 = cursor4;
_L19:
        ArrayList arraylist3;
        Iterator iterator;
        Log.w((new StringBuilder("Error in peekHits fetching hitString: ")).append(sqliteexception3.getMessage()).toString());
        arraylist3 = new ArrayList();
        iterator = arraylist2.iterator();
        boolean flag1 = false;
_L15:
        if (!iterator.hasNext()) goto _L11; else goto _L10
_L10:
        Hit hit = (Hit)iterator.next();
        if (!TextUtils.isEmpty(hit.getHitParams())) goto _L13; else goto _L12
_L12:
        if (flag1) goto _L11; else goto _L14
_L14:
        flag1 = true;
_L13:
        arraylist3.add(hit);
          goto _L15
        Exception exception1;
        exception1;
_L17:
        if (cursor3 != null)
        {
            cursor3.close();
        }
        throw exception1;
_L11:
        if (cursor3 != null)
        {
            cursor3.close();
        }
        return arraylist3;
        exception1;
        cursor3 = cursor4;
        if (true) goto _L17; else goto _L16
_L16:
        sqliteexception3;
        if (true) goto _L19; else goto _L18
_L18:
        exception;
        cursor = cursor3;
          goto _L20
        exception;
        cursor = cursor1;
          goto _L20
        SQLiteException sqliteexception4;
        sqliteexception4;
        sqliteexception1 = sqliteexception4;
        cursor1 = cursor3;
        arraylist1 = arraylist;
          goto _L21
        SQLiteException sqliteexception2;
        sqliteexception2;
        sqliteexception1 = sqliteexception2;
        cursor1 = cursor3;
        arraylist1 = arraylist2;
          goto _L21
        j = k;
          goto _L22
    }

    public void putHit(Map map, long l, String s, Collection collection)
    {
        deleteStaleHits();
        removeOldHitIfFull();
        fillVersionParameter(map, collection);
        writeHitToDatabase(map, l, s);
    }

    public void setClock(Clock clock)
    {
        mClock = clock;
    }

    public void setDispatch(boolean flag)
    {
        Object obj;
        if (flag)
        {
            obj = new SimpleNetworkDispatcher(new DefaultHttpClient(), mContext);
        } else
        {
            obj = new NoopDispatcher();
        }
        mDispatcher = ((Dispatcher) (obj));
    }

    void setDispatcher(Dispatcher dispatcher)
    {
        mDispatcher = dispatcher;
    }

    void setLastDeleteStaleHitsTime(long l)
    {
        mLastDeleteStaleHitsTime = l;
    }






    private class _cls1
        implements Clock
    {

        final PersistentAnalyticsStore this$0;

        public long currentTimeMillis()
        {
            return System.currentTimeMillis();
        }

        _cls1()
        {
            this$0 = PersistentAnalyticsStore.this;
            super();
        }
    }


    private class AnalyticsDatabaseHelper extends SQLiteOpenHelper
    {

        private boolean mBadDatabase;
        private long mLastDatabaseCheckTime;
        final PersistentAnalyticsStore this$0;

        private boolean tablePresent(String s, SQLiteDatabase sqlitedatabase)
        {
            Cursor cursor = null;
            Cursor cursor2 = sqlitedatabase.query("SQLITE_MASTER", new String[] {
                "name"
            }, "name=?", new String[] {
                s
            }, null, null, null);
            boolean flag = cursor2.moveToFirst();
            if (cursor2 != null)
            {
                cursor2.close();
            }
            return flag;
            SQLiteException sqliteexception;
            sqliteexception;
            Cursor cursor1 = null;
_L4:
            Log.w((new StringBuilder("Error querying for table ")).append(s).toString());
            if (cursor1 != null)
            {
                cursor1.close();
            }
            return false;
            Exception exception;
            exception;
_L2:
            if (cursor != null)
            {
                cursor.close();
            }
            throw exception;
            exception;
            cursor = cursor2;
            continue; /* Loop/switch isn't completed */
            Exception exception1;
            exception1;
            cursor = cursor1;
            exception = exception1;
            if (true) goto _L2; else goto _L1
_L1:
            SQLiteException sqliteexception1;
            sqliteexception1;
            cursor1 = cursor2;
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void validateColumnsPresent(SQLiteDatabase sqlitedatabase)
        {
            Cursor cursor;
            HashSet hashset;
            cursor = sqlitedatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
            hashset = new HashSet();
            String as[] = cursor.getColumnNames();
            int i = 0;
_L2:
            if (i >= as.length)
            {
                break; /* Loop/switch isn't completed */
            }
            hashset.add(as[i]);
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            cursor.close();
            if (!hashset.remove("hit_id") || !hashset.remove("hit_url") || !hashset.remove("hit_string") || !hashset.remove("hit_time"))
            {
                throw new SQLiteException("Database column missing");
            }
            break MISSING_BLOCK_LABEL_124;
            Exception exception;
            exception;
            cursor.close();
            throw exception;
            boolean flag = hashset.remove("hit_app_id");
            boolean flag1 = false;
            if (!flag)
            {
                flag1 = true;
            }
            if (!hashset.isEmpty())
            {
                throw new SQLiteException("Database has extra columns");
            }
            if (flag1)
            {
                sqlitedatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
            }
            return;
        }

        public SQLiteDatabase getWritableDatabase()
        {
            if (mBadDatabase && 0x36ee80L + mLastDatabaseCheckTime > mClock.currentTimeMillis())
            {
                throw new SQLiteException("Database creation failed");
            }
            mBadDatabase = true;
            mLastDatabaseCheckTime = mClock.currentTimeMillis();
            SQLiteDatabase sqlitedatabase1 = super.getWritableDatabase();
            SQLiteDatabase sqlitedatabase = sqlitedatabase1;
_L2:
            if (sqlitedatabase == null)
            {
                sqlitedatabase = super.getWritableDatabase();
            }
            mBadDatabase = false;
            return sqlitedatabase;
            SQLiteException sqliteexception;
            sqliteexception;
            mContext.getDatabasePath(mDatabaseName).delete();
            sqlitedatabase = null;
            if (true) goto _L2; else goto _L1
_L1:
        }

        boolean isBadDatabase()
        {
            return mBadDatabase;
        }

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            FutureApis.setOwnerOnlyReadWrite(sqlitedatabase.getPath());
        }

        public void onOpen(SQLiteDatabase sqlitedatabase)
        {
            Cursor cursor;
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                break MISSING_BLOCK_LABEL_29;
            }
            cursor = sqlitedatabase.rawQuery("PRAGMA journal_mode=memory", null);
            cursor.moveToFirst();
            cursor.close();
            Exception exception;
            if (!tablePresent("hits2", sqlitedatabase))
            {
                sqlitedatabase.execSQL(PersistentAnalyticsStore.CREATE_HITS_TABLE);
                return;
            } else
            {
                validateColumnsPresent(sqlitedatabase);
                return;
            }
            exception;
            cursor.close();
            throw exception;
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
        }

        void setBadDatabase(boolean flag)
        {
            mBadDatabase = flag;
        }

        AnalyticsDatabaseHelper(Context context, String s)
        {
            this$0 = PersistentAnalyticsStore.this;
            super(context, s, null, 1);
            mLastDatabaseCheckTime = 0L;
        }
    }

}
