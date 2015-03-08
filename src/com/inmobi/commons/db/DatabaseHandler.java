// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package com.inmobi.commons.db:
//            TableData, ColumnData

public abstract class DatabaseHandler extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "im.db";
    private static String c = "CREATE TABLE IF NOT EXISTS ";
    private static String d = "DROP TABLE IF EXISTS ";
    private static String e = " PRIMARY KEY ";
    private static String f = " AUTOINCREMENT ";
    private static String g = " NOT NULL ";
    private static String h = "SELECT * FROM ";
    private static String i = " WHERE ";
    private static String j = " ORDER BY ";
    private static String k = "; ";
    private static String l = " Limit ?";
    private ArrayList a;
    private SQLiteDatabase b;

    public DatabaseHandler(Context context, ArrayList arraylist)
    {
        super(context, "im.db", null, 1);
        a = arraylist;
    }

    private void a(SQLiteDatabase sqlitedatabase)
    {
        if (a == null || a.isEmpty()) goto _L2; else goto _L1
_L1:
        Iterator iterator = a.iterator();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        StringBuilder stringbuilder;
        TableData tabledata = (TableData)iterator.next();
        String s = tabledata.getmTableName();
        LinkedHashMap linkedhashmap = tabledata.getmColumns();
        stringbuilder = new StringBuilder((new StringBuilder()).append(c).append(s).append(" (").toString());
        for (Iterator iterator1 = linkedhashmap.keySet().iterator(); iterator1.hasNext(); stringbuilder.append(","))
        {
            String s4 = (String)iterator1.next();
            ColumnData columndata = (ColumnData)linkedhashmap.get(s4);
            stringbuilder.append((new StringBuilder(" ")).append(s4).append(" ").append(columndata.getDataType().toString()).toString());
            if (columndata.isPrimaryKey())
            {
                stringbuilder.append(e);
            }
            if (columndata.isAutoIncrement())
            {
                stringbuilder.append(f);
            }
            if (columndata.isMandatory())
            {
                stringbuilder.append(g);
            }
        }

          goto _L4
        Exception exception;
        exception;
        Log.internal("[InMobi]-4.4.1", "Exception creating table", exception);
_L2:
        return;
_L4:
        if (',' != stringbuilder.charAt(-1 + stringbuilder.length())) goto _L6; else goto _L5
_L5:
        String s2 = stringbuilder.substring(0, -2 + stringbuilder.length());
_L8:
        String s3 = s2.concat(" );");
        Log.internal("[InMobi]-4.4.1", (new StringBuilder("Table: ")).append(s3).toString());
        sqlitedatabase.execSQL(s3);
          goto _L7
_L6:
        String s1 = stringbuilder.toString();
        s2 = s1;
          goto _L8
    }

    public void close()
    {
        try
        {
            b.close();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Failed to close  db", exception);
        }
    }

    public int delete(String s, String s1, String as[])
    {
        this;
        JVM INSTR monitorenter ;
        int j1 = b.delete(s, s1, as);
        int i1 = j1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to insert to db", exception1);
        i1 = -1;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public Cursor executeQuery(String s, String as[])
    {
        this;
        JVM INSTR monitorenter ;
        Cursor cursor1 = b.rawQuery(s, as);
        Cursor cursor = cursor1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return cursor;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to execute db query", exception1);
        cursor = null;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public Cursor getAll(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (!"".equals(s1.trim())) goto _L3; else goto _L2
_L2:
        Cursor cursor1 = b.rawQuery((new StringBuilder()).append(h).append(s).append(k).toString(), null);
_L4:
        cursor1.moveToFirst();
        Cursor cursor = cursor1;
_L5:
        this;
        JVM INSTR monitorexit ;
        return cursor;
_L3:
        Cursor cursor2 = b.rawQuery((new StringBuilder()).append(h).append(s).append(j).append(s1).append(k).toString(), null);
        cursor1 = cursor2;
          goto _L4
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to all rows", exception1);
        cursor = null;
          goto _L5
        Exception exception;
        exception;
        throw exception;
          goto _L4
    }

    public Cursor getNRows(String s, String s1, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (!"".equals(s1.trim())) goto _L3; else goto _L2
_L2:
        Cursor cursor1 = b.rawQuery((new StringBuilder()).append(h).append(s).append(k).toString(), null);
_L4:
        cursor1.moveToFirst();
        Cursor cursor = cursor1;
_L5:
        this;
        JVM INSTR monitorexit ;
        return cursor;
_L3:
        Cursor cursor2;
        SQLiteDatabase sqlitedatabase = b;
        String s2 = (new StringBuilder()).append(h).append(s).append(j).append(s1).append(l).append(k).toString();
        String as[] = new String[1];
        as[0] = String.valueOf(i1);
        cursor2 = sqlitedatabase.rawQuery(s2, as);
        cursor1 = cursor2;
          goto _L4
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to all rows", exception1);
        cursor = null;
          goto _L5
        Exception exception;
        exception;
        throw exception;
          goto _L4
    }

    public int getNoOfRows(String s, String s1, String as[])
    {
        this;
        JVM INSTR monitorenter ;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if ("".equals(s1.trim())) goto _L2; else goto _L3
_L3:
        Cursor cursor1 = b.rawQuery((new StringBuilder()).append(h).append(s).append(i).append(s1).toString(), as);
_L4:
        int i1;
        i1 = cursor1.getCount();
        cursor1.close();
_L5:
        this;
        JVM INSTR monitorexit ;
        return i1;
_L2:
        Cursor cursor = b.rawQuery((new StringBuilder()).append(h).append(s).append(k).toString(), null);
        cursor1 = cursor;
          goto _L4
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to get number of rows", exception1);
        i1 = 0;
          goto _L5
        Exception exception;
        exception;
        throw exception;
          goto _L4
    }

    public Cursor getRow(String s, String s1, String as[])
    {
        this;
        JVM INSTR monitorenter ;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (!"".equals(s1.trim())) goto _L3; else goto _L2
_L2:
        Cursor cursor1 = b.rawQuery((new StringBuilder()).append(h).append(s).append(k).toString(), null);
_L4:
        cursor1.moveToFirst();
        Cursor cursor = cursor1;
_L5:
        this;
        JVM INSTR monitorexit ;
        return cursor;
_L3:
        Cursor cursor2 = b.rawQuery((new StringBuilder()).append(h).append(s).append(i).append(s1).append(k).toString(), as);
        cursor1 = cursor2;
          goto _L4
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to all rows", exception1);
        cursor = null;
          goto _L5
        Exception exception;
        exception;
        throw exception;
          goto _L4
    }

    protected int getTableSize(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        Cursor cursor = b.rawQuery((new StringBuilder()).append(h).append(s).append(k).toString(), null);
        i1 = cursor.getCount();
        cursor.close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to table size ", exception1);
        i1 = 0;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public long insert(String s, ContentValues contentvalues)
    {
        this;
        JVM INSTR monitorenter ;
        long l2 = b.insert(s, null, contentvalues);
        long l1 = l2;
_L2:
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to insert to db", exception1);
        l1 = -1L;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        try
        {
            a(sqlitedatabase);
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Exception Creating table", exception);
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i1, int j1)
    {
        try
        {
            String s;
            for (Iterator iterator = a.iterator(); iterator.hasNext(); sqlitedatabase.execSQL((new StringBuilder()).append(d).append(s).toString()))
            {
                s = ((TableData)iterator.next()).getmTableName();
            }

        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Exception Deleting table", exception);
            return;
        }
        onCreate(sqlitedatabase);
        return;
    }

    public void open()
    {
        try
        {
            b = getWritableDatabase();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Failed to open  db", exception);
        }
    }

    public long update(String s, ContentValues contentvalues, String s1, String as[])
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = b.update(s, contentvalues, s1, as);
        long l1 = i1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to insert to db", exception1);
        l1 = -1L;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

}
