// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Handler;
import com.inmobi.commons.analytics.net.AnalyticsNetworkManager;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsEvent, AnalyticsSQLiteHelper

public final class AnalyticsDatabaseManager
{

    private static AnalyticsDatabaseManager c;
    private static final String d[] = {
        "_id", "eventid", "type", "sid", "ts", "ssts", "am"
    };
    private static final String e[] = {
        "_id", "levelid", "levelname"
    };
    private static final String f[] = {
        "_id", "levelid", "levelname", "levelstatus", "timetaken", "attemptcount", "attempttime"
    };
    private static final String g[] = {
        "_id", "eventname"
    };
    private static final String h[] = {
        "_id", "levelid", "begintime", "totalcount", "totaltime"
    };
    private static final String i[] = {
        "_id", "itemName", "itemType", "itemCount", "itemDescription", "itemPrice", "currencyCode", "productId", "transactionId", "transactionStatus"
    };
    private AnalyticsSQLiteHelper a;
    private SQLiteDatabase b;

    private AnalyticsDatabaseManager()
    {
    }

    private AnalyticsEvent a(Cursor cursor)
    {
        AnalyticsEvent analyticsevent;
        long l;
        String s;
        analyticsevent = new AnalyticsEvent(cursor.getString(2));
        analyticsevent.setEventSessionId(cursor.getString(3));
        analyticsevent.setEventId(cursor.getLong(0));
        analyticsevent.setEventTimeStamp(cursor.getLong(4));
        analyticsevent.setEventSessionTimeStamp(cursor.getLong(5));
        analyticsevent.setEventAttributeMap(cursor.getString(6));
        l = cursor.getLong(1);
        s = Long.toString(l);
        Log.debug("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("IMAppDatabaseManager->")).append(analyticsevent.getEventType()).append("-").append(l).toString());
        if (l <= -1L) goto _L2; else goto _L1
_L1:
        if (!analyticsevent.getEventType().equals("lb")) goto _L4; else goto _L3
_L3:
        Cursor cursor1;
        cursor1 = b.query("levelbegin", e, "_id = ?", new String[] {
            s
        }, null, null, null);
        cursor1.moveToFirst();
        analyticsevent.setEventLevelId(cursor1.getString(1));
        analyticsevent.setEventLevelName(cursor1.getString(2));
_L6:
        if (cursor1 != null)
        {
            cursor1.close();
        }
_L2:
        return analyticsevent;
_L4:
        if (analyticsevent.getEventType().equals("le"))
        {
            cursor1 = b.query("levelend", f, "_id = ?", new String[] {
                s
            }, null, null, null);
            cursor1.moveToFirst();
            analyticsevent.setEventLevelId(cursor1.getString(1));
            analyticsevent.setEventLevelName(cursor1.getString(2));
            analyticsevent.setEventLevelStatus(cursor1.getString(3));
            analyticsevent.setEventTimeTaken(cursor1.getString(4));
            analyticsevent.setEventAttemptCount(cursor1.getString(5));
            analyticsevent.setEventAttemptTime(cursor1.getString(6));
        } else
        if (analyticsevent.getEventType().equals("ce"))
        {
            cursor1 = b.query("customevent", g, "_id = ?", new String[] {
                s
            }, null, null, null);
            cursor1.moveToFirst();
            analyticsevent.setEventCustomName(cursor1.getString(1));
        } else
        {
            boolean flag = analyticsevent.getEventType().equals("pi");
            cursor1 = null;
            if (flag)
            {
                cursor1 = b.query("transactiondetail", i, "_id = ?", new String[] {
                    s
                }, null, null, null);
                cursor1.moveToFirst();
                analyticsevent.setTransactionItemName(cursor1.getString(1));
                analyticsevent.setTransactionItemType(cursor1.getInt(2));
                analyticsevent.setTransactionItemCount(cursor1.getInt(3));
                analyticsevent.setTransactionItemDescription(cursor1.getString(4));
                analyticsevent.setTransactionItemPrice(cursor1.getDouble(5));
                analyticsevent.setTransactionCurrencyCode(cursor1.getString(6));
                analyticsevent.setTransactionProductId(cursor1.getString(7));
                analyticsevent.setTransactionId(cursor1.getString(8));
                analyticsevent.setTransactionStatus(cursor1.getInt(9));
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a()
    {
        b = a.getWritableDatabase();
    }

    private void a(AnalyticsEvent analyticsevent, long l)
    {
        Log.debug("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("IMAppDatabaseManager->insertEvents-")).append(analyticsevent.getEventType()).toString());
        if (l < AnalyticsUtils.getMaxdbcount())
        {
            ContentValues contentvalues = new ContentValues();
            long l1 = -1L;
            long l2 = analyticsevent.getEventTimeStamp();
            ContentValues contentvalues2;
            if (analyticsevent.getEventType().equals("lb"))
            {
                ContentValues contentvalues1 = new ContentValues();
                contentvalues1.put("begintime", Long.valueOf(l2));
                SQLiteDatabase sqlitedatabase = b;
                String as[] = new String[1];
                as[0] = analyticsevent.getEventLevelId();
                if (sqlitedatabase.update("attemptdata", contentvalues1, "levelid = ?", as) <= 0)
                {
                    contentvalues1.put("levelid", analyticsevent.getEventLevelId());
                    contentvalues1.put("totalcount", Integer.toString(0));
                    contentvalues1.put("totaltime", Integer.toString(0));
                    b.insert("attemptdata", null, contentvalues1);
                }
                contentvalues.put("levelid", analyticsevent.getEventLevelId());
                contentvalues.put("levelname", analyticsevent.getEventLevelName());
                l1 = b.insert("levelbegin", null, contentvalues);
            } else
            if (analyticsevent.getEventType().equals("le"))
            {
                SQLiteDatabase sqlitedatabase1 = b;
                String as1[] = h;
                String as2[] = new String[1];
                as2[0] = analyticsevent.getEventLevelId();
                Cursor cursor = sqlitedatabase1.query("attemptdata", as1, "levelid = ?", as2, null, null, null, "1");
                int j;
                int k;
                int i1;
                String s;
                String s1;
                String s2;
                if (cursor.getCount() > 0)
                {
                    cursor.moveToFirst();
                    long l3 = l2 - Long.parseLong(cursor.getString(2));
                    s2 = Long.toString(l3);
                    s = Long.toString(l3 + Long.parseLong(cursor.getString(4)));
                    s1 = Integer.toString(1 + Integer.parseInt(cursor.getString(3)));
                    ContentValues contentvalues3 = new ContentValues();
                    contentvalues3.put("totalcount", s1);
                    contentvalues3.put("totaltime", s);
                    SQLiteDatabase sqlitedatabase2 = b;
                    String as3[] = new String[1];
                    as3[0] = analyticsevent.getEventLevelId();
                    sqlitedatabase2.update("attemptdata", contentvalues3, "levelid = ?", as3);
                } else
                {
                    s = "0";
                    s1 = "0";
                    s2 = "0";
                }
                cursor.close();
                contentvalues.put("levelid", analyticsevent.getEventLevelId());
                contentvalues.put("levelstatus", analyticsevent.getEventLevelStatus());
                contentvalues.put("levelname", analyticsevent.getEventLevelName());
                contentvalues.put("timetaken", s2);
                contentvalues.put("attemptcount", s1);
                contentvalues.put("attempttime", s);
                l1 = b.insert("levelend", null, contentvalues);
            } else
            if (analyticsevent.getEventType().equals("pi"))
            {
                contentvalues.put("itemName", analyticsevent.getTransactionItemName());
                j = analyticsevent.getTransactionItemType();
                if (AnalyticsEvent.TRANSACTION_ITEM_TYPE.INVALID.getValue() != j)
                {
                    contentvalues.put("itemType", Integer.valueOf(j));
                }
                k = analyticsevent.getTransactionItemCount();
                if (k > 0)
                {
                    contentvalues.put("itemCount", Integer.valueOf(k));
                }
                contentvalues.put("itemDescription", analyticsevent.getTransactionItemDescription());
                contentvalues.put("itemPrice", Double.valueOf(analyticsevent.getTransactionItemPrice()));
                contentvalues.put("currencyCode", analyticsevent.getTransactionCurrencyCode());
                contentvalues.put("productId", analyticsevent.getTransactionProductId());
                contentvalues.put("transactionId", analyticsevent.getTransactionId());
                i1 = analyticsevent.getTransactionStatus();
                if (AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.INVALID.getValue() != i1)
                {
                    contentvalues.put("transactionStatus", Integer.valueOf(i1));
                }
                l1 = b.insert("transactiondetail", null, contentvalues);
            } else
            if (analyticsevent.getEventType().equals("ce"))
            {
                contentvalues.put("eventname", analyticsevent.getEventCustomName());
                l1 = b.insert("customevent", null, contentvalues);
            }
            contentvalues2 = new ContentValues();
            contentvalues2.put("eventid", Long.valueOf(l1));
            contentvalues2.put("type", analyticsevent.getEventType());
            contentvalues2.put("sid", analyticsevent.getEventSessionId());
            contentvalues2.put("ts", Long.valueOf(analyticsevent.getEventTimeStamp()));
            contentvalues2.put("ssts", Long.valueOf(analyticsevent.getEventSessionTimeStamp()));
            contentvalues2.put("am", analyticsevent.getEventAttributeMap());
            b.insert("eventlist", null, contentvalues2);
        } else
        {
            Log.debug("[InMobi]-[Analytics]-4.4.1", "Database full");
        }
        if (!AnalyticsUtils.getStartHandle() && AnalyticsNetworkManager.getHandler() != null)
        {
            AnalyticsUtils.setStartHandle(true);
            AnalyticsNetworkManager.getHandler().sendEmptyMessageDelayed(1001, AnalyticsUtils.getTimeinterval());
        }
    }

    private void a(List list)
    {
        Log.debug("[InMobi]-[Analytics]-4.4.1", "IMAppDatabaseManager->deleteEvents");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            String s = ((Long)iterator.next()).toString();
            Cursor cursor = b.query("eventlist", d, "_id=?", new String[] {
                s
            }, null, null, null, "1");
            cursor.moveToFirst();
            Long long1 = Long.valueOf(cursor.getLong(1));
            String s1 = long1.toString();
            String s2 = cursor.getString(2);
            if (long1.longValue() > -1L)
            {
                if (s2.equals("lb"))
                {
                    b.delete("levelbegin", "_id = ?", new String[] {
                        s1
                    });
                } else
                if (s2.equals("le"))
                {
                    b.delete("levelend", "_id = ?", new String[] {
                        s1
                    });
                } else
                if (s2.equals("ce"))
                {
                    b.delete("customevent", "_id = ?", new String[] {
                        s1
                    });
                } else
                if (s2.equals("pi"))
                {
                    b.delete("transactiondetail", "_id = ?", new String[] {
                        s1
                    });
                }
            }
            cursor.close();
            b.delete("eventlist", "_id = ?", new String[] {
                s
            });
        }
    }

    private void b()
    {
        a.close();
    }

    private List c()
    {
        Log.debug("[InMobi]-[Analytics]-4.4.1", "IMAppDatabaseManager->getEvents");
        ArrayList arraylist = new ArrayList();
        if (!b.isOpen())
        {
            android.util.Log.v("[InMobi]-[Analytics]-4.4.1", "IMAppDatabaseManager->getEvents()-database is not open");
            return arraylist;
        }
        Cursor cursor = b.query("eventlist", d, null, null, null, null, null, AnalyticsUtils.getMaxevents());
        cursor.moveToFirst();
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            AnalyticsEvent analyticsevent = a(cursor);
            analyticsevent.setEventTableId(cursor.getLong(0));
            arraylist.add(analyticsevent);
        }

        cursor.close();
        return arraylist;
    }

    public static AnalyticsDatabaseManager getInstance()
    {
        com/inmobi/commons/analytics/db/AnalyticsDatabaseManager;
        JVM INSTR monitorenter ;
        AnalyticsDatabaseManager analyticsdatabasemanager;
        if (c == null)
        {
            c = new AnalyticsDatabaseManager();
            File file = InternalSDKUtil.getContext().getDatabasePath("appengage.db");
            if (file.isFile())
            {
                file.renameTo(InternalSDKUtil.getContext().getDatabasePath("ltvp.db"));
                SessionInfo.updatedFromOldSDK(InternalSDKUtil.getContext());
            }
            c.a = new AnalyticsSQLiteHelper(InternalSDKUtil.getContext());
        }
        analyticsdatabasemanager = c;
        com/inmobi/commons/analytics/db/AnalyticsDatabaseManager;
        JVM INSTR monitorexit ;
        return analyticsdatabasemanager;
        Exception exception;
        exception;
        throw exception;
    }

    public final void deleteEvents(List list)
    {
        this;
        JVM INSTR monitorenter ;
        a();
        a(list);
        a.close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[Analytics]-4.4.1", "Error deleting from DB.");
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public final List getEvents()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        a();
        obj = c();
        a.close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[Analytics]-4.4.1", "Error reading events from DB.");
        obj = new ArrayList();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public final void insertEvents(AnalyticsEvent analyticsevent)
    {
        this;
        JVM INSTR monitorenter ;
        a();
        a(analyticsevent, b.compileStatement("SELECT COUNT(*) FROM eventlist").simpleQueryForLong());
        a.close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[Analytics]-4.4.1", "Error in inserting into DB.", exception1);
        exception1.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

}
