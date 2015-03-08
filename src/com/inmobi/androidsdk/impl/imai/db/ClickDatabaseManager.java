// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.imai.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.inmobi.androidsdk.impl.imai.IMAIClickEventList;
import com.inmobi.commons.db.ColumnData;
import com.inmobi.commons.db.DatabaseHandler;
import com.inmobi.commons.db.TableData;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

// Referenced classes of package com.inmobi.androidsdk.impl.imai.db:
//            ClickData

public class ClickDatabaseManager extends DatabaseHandler
{

    public static final String COLUMN_CLICK_ID = "clickid";
    public static final String COLUMN_CLICK_URL = "clickurl";
    public static final String COLUMN_FOLLOW_REDIRECT = "followredirect";
    public static final String COLUMN_PINGWV = "pingwv";
    public static final String COLUMN_RETRY_COUNT = "retrycount";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String TABLE_CLICK = "clickevent";
    private static ClickDatabaseManager a;
    private int b;

    protected ClickDatabaseManager(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
        b = 1000;
    }

    private static TableData a()
    {
        TableData tabledata = new TableData();
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        ColumnData columndata = new ColumnData();
        columndata.setPrimaryKey(true);
        columndata.setDataType(com.inmobi.commons.db.ColumnData.ColumnType.INTEGER);
        columndata.setMandatory(true);
        linkedhashmap.put("clickid", columndata);
        ColumnData columndata1 = new ColumnData();
        columndata1.setDataType(com.inmobi.commons.db.ColumnData.ColumnType.VARCHAR);
        columndata1.setMandatory(true);
        linkedhashmap.put("clickurl", columndata1);
        ColumnData columndata2 = new ColumnData();
        columndata2.setDataType(com.inmobi.commons.db.ColumnData.ColumnType.INTEGER);
        columndata2.setMandatory(true);
        linkedhashmap.put("pingwv", columndata2);
        ColumnData columndata3 = new ColumnData();
        columndata3.setDataType(com.inmobi.commons.db.ColumnData.ColumnType.INTEGER);
        columndata3.setMandatory(true);
        linkedhashmap.put("followredirect", columndata3);
        ColumnData columndata4 = new ColumnData();
        columndata4.setDataType(com.inmobi.commons.db.ColumnData.ColumnType.INTEGER);
        columndata4.setMandatory(true);
        linkedhashmap.put("retrycount", columndata4);
        ColumnData columndata5 = new ColumnData();
        columndata5.setDataType(com.inmobi.commons.db.ColumnData.ColumnType.INTEGER);
        columndata5.setMandatory(true);
        linkedhashmap.put("timestamp", columndata5);
        tabledata.setmColumns(linkedhashmap);
        tabledata.setmTableName("clickevent");
        return tabledata;
    }

    public static ClickDatabaseManager getInstance()
    {
        com/inmobi/androidsdk/impl/imai/db/ClickDatabaseManager;
        JVM INSTR monitorenter ;
        ClickDatabaseManager clickdatabasemanager;
        if (a == null)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(a());
            a = new ClickDatabaseManager(InternalSDKUtil.getContext(), arraylist);
        }
        clickdatabasemanager = a;
_L2:
        com/inmobi/androidsdk/impl/imai/db/ClickDatabaseManager;
        JVM INSTR monitorexit ;
        return clickdatabasemanager;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[Network]-4.4.1", "Exception getting DB Manager Instance", exception1);
        clickdatabasemanager = null;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean deleteClickEvents(ArrayList arraylist)
    {
        this;
        JVM INSTR monitorenter ;
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        if (arraylist.isEmpty()) goto _L2; else goto _L3
_L3:
        open();
        long l;
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); delete("clickevent", (new StringBuilder("clickid = ")).append(l).toString(), null))
        {
            l = ((Long)iterator.next()).longValue();
        }

          goto _L4
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[Network]-4.4.1", "Exception deleting click events", exception1);
        boolean flag = false;
_L6:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        close();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public IMAIClickEventList getClickEvents(int i)
    {
        this;
        JVM INSTR monitorenter ;
        IMAIClickEventList imaiclickeventlist = new IMAIClickEventList();
        Cursor cursor;
        open();
        cursor = getNRows("clickevent", "timestamp", i);
        cursor.moveToFirst();
_L4:
        ClickData clickdata;
        clickdata = new ClickData();
        clickdata.setClickId(cursor.getLong(0));
        clickdata.setClickUrl(cursor.getString(1));
        if (1 != cursor.getInt(2)) goto _L2; else goto _L1
_L1:
        clickdata.setPingWv(true);
_L5:
        if (1 != cursor.getInt(3))
        {
            break MISSING_BLOCK_LABEL_190;
        }
        clickdata.setFollowRedirect(true);
_L7:
        clickdata.setRetryCount(cursor.getInt(4));
        clickdata.setTimestamp(cursor.getLong(5));
        imaiclickeventlist.add(clickdata);
        if (cursor.moveToNext()) goto _L4; else goto _L3
_L3:
        cursor.close();
        close();
_L6:
        this;
        JVM INSTR monitorexit ;
        return imaiclickeventlist;
_L2:
        clickdata.setPingWv(false);
          goto _L5
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to get clicks from db", exception1);
          goto _L6
        Exception exception;
        exception;
        throw exception;
        clickdata.setFollowRedirect(false);
          goto _L7
    }

    public int getNoOfEvents()
    {
        int i;
        try
        {
            open();
            i = getInstance().getNoOfRows("clickevent", null, null);
            close();
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Exception getting no of click events", exception);
            return 0;
        }
        return i;
    }

    public void insertClick(ClickData clickdata)
    {
        this;
        JVM INSTR monitorenter ;
        open();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("timestamp", Long.valueOf(clickdata.getTimestamp()));
        contentvalues.put("clickurl", clickdata.getClickUrl());
        contentvalues.put("pingwv", Boolean.valueOf(clickdata.isPingWv()));
        contentvalues.put("retrycount", Integer.valueOf(clickdata.getRetryCount()));
        contentvalues.put("followredirect", Boolean.valueOf(clickdata.isFollowRedirects()));
        if (getTableSize("clickevent") >= b)
        {
            Cursor cursor = executeQuery("SELECT clickid FROM clickevent WHERE timestamp= (SELECT MIN(timestamp) FROM clickevent Limit 1);", null);
            cursor.moveToFirst();
            long l = cursor.getLong(0);
            cursor.close();
            delete("clickevent", (new StringBuilder("clickid = ")).append(l).toString(), null);
        }
        insert("clickevent", contentvalues);
        close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to insert click event to db", exception1);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public void setDBLimit(int i)
    {
        if (i > 0)
        {
            b = i;
        }
    }

    public boolean updateRetryCount(ArrayList arraylist)
    {
        this;
        JVM INSTR monitorenter ;
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        if (arraylist.isEmpty()) goto _L2; else goto _L3
_L3:
        open();
        ContentValues contentvalues;
        String as[];
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); update("clickevent", contentvalues, "clickid= ?", as))
        {
            ClickData clickdata = (ClickData)iterator.next();
            contentvalues = new ContentValues();
            contentvalues.put("clickid", Long.valueOf(clickdata.getClickId()));
            contentvalues.put("clickurl", clickdata.getClickUrl());
            contentvalues.put("followredirect", Boolean.valueOf(clickdata.isFollowRedirects()));
            contentvalues.put("pingwv", Boolean.valueOf(clickdata.isPingWv()));
            contentvalues.put("retrycount", Integer.valueOf(1 + clickdata.getRetryCount()));
            contentvalues.put("timestamp", Long.valueOf(clickdata.getTimestamp()));
            as = new String[1];
            as[0] = String.valueOf(clickdata.getClickId());
        }

          goto _L4
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[Network]-4.4.1", "Exception updating retry count", exception1);
        boolean flag = false;
_L6:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        close();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }
}
