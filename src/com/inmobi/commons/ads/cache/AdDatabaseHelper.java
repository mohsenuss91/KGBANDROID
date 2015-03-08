// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.ads.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.inmobi.commons.internal.Log;

public class AdDatabaseHelper extends SQLiteOpenHelper
{

    public static final String COLUMN_ADTYPE = "adtype";
    public static final String COLUMN_AD_CONTENT = "content";
    public static final String COLUMN_AD_ID = "adid";
    public static final String COLUMN_APPID = "appid";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String DATABASE_NAME = "adcache.db";
    public static final String TABLE_AD = "ad";

    public AdDatabaseHelper(Context context)
    {
        super(context, "adcache.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        Log.internal("[InMobi]-4.4.1", "CREATE TABLE IF NOT EXISTS ad (adid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, timestamp INTEGER NOT NULL, appid VARCHAR NOT NULL, content VARCHAR NOT NULL, adtype VARCHAR NOT NULL);");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS ad (adid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, timestamp INTEGER NOT NULL, appid VARCHAR NOT NULL, content VARCHAR NOT NULL, adtype VARCHAR NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        Log.internal("[InMobi]-4.4.1", (new StringBuilder("Upgrading database from version ")).append(i).append(" to ").append(j).append(", which will destroy all old data").toString());
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS ad;");
        onCreate(sqlitedatabase);
    }
}
