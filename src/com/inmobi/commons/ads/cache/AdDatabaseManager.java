// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.ads.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.commons.ads.cache:
//            AdDatabaseHelper, AdData

public class AdDatabaseManager
{

    private static AdDatabaseManager c;
    private AdDatabaseHelper a;
    private SQLiteDatabase b;
    private int d;

    protected AdDatabaseManager()
    {
        d = 1000;
    }

    public static AdDatabaseManager getInstance()
    {
        com/inmobi/commons/ads/cache/AdDatabaseManager;
        JVM INSTR monitorenter ;
        AdDatabaseManager addatabasemanager1;
        if (c == null)
        {
            AdDatabaseManager addatabasemanager = new AdDatabaseManager();
            c = addatabasemanager;
            addatabasemanager.a = new AdDatabaseHelper(InternalSDKUtil.getContext());
        }
        addatabasemanager1 = c;
        com/inmobi/commons/ads/cache/AdDatabaseManager;
        JVM INSTR monitorexit ;
        return addatabasemanager1;
        Exception exception;
        exception;
        throw exception;
    }

    protected void close()
    {
        try
        {
            b.close();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Failed to close ads db", exception);
        }
    }

    public AdData getAd(String s)
    {
        this;
        JVM INSTR monitorenter ;
        AdData addata;
        open();
        Cursor cursor = b.rawQuery("SELECT * FROM ad WHERE appid = ? Order by timestamp Limit 1;", new String[] {
            s
        });
        cursor.moveToFirst();
        addata = new AdData();
        addata.setAdId(cursor.getLong(0));
        addata.setTimestamp(cursor.getLong(1));
        addata.setAppId(cursor.getString(2));
        addata.setContent(cursor.getString(3));
        cursor.close();
        b.delete("ad", (new StringBuilder("adid = ")).append(addata.getAdId()).toString(), null);
        close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return addata;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to get native ads from db", exception1);
        addata = null;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    protected int getDBSize()
    {
        int i;
        try
        {
            open();
            i = b.rawQuery("SELECT * FROM ad; ", null).getCount();
            close();
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Failed to get native ads from db", exception);
            return 0;
        }
        return i;
    }

    public int getNoOfAds(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        open();
        i = b.rawQuery("SELECT * FROM ad WHERE appid = ?; ", new String[] {
            s
        }).getCount();
        close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to get native ads from db", exception1);
        i = 0;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public void insertAd(AdData addata)
    {
        this;
        JVM INSTR monitorenter ;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("timestamp", Long.valueOf(addata.getTimestamp()));
        contentvalues.put("appid", addata.getAppId());
        contentvalues.put("content", addata.getContent());
        contentvalues.put("adtype", addata.getAdType());
        if (getDBSize() >= d)
        {
            open();
            Cursor cursor = b.rawQuery("SELECT adid FROM ad WHERE timestamp= (SELECT MIN(timestamp) FROM ad Limit 1);", null);
            cursor.moveToFirst();
            long l = cursor.getLong(0);
            cursor.close();
            b.delete("ad", (new StringBuilder("adid = ")).append(l).toString(), null);
            close();
        }
        open();
        b.insert("ad", null, contentvalues);
        close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Failed to insert native ads to db", exception1);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    protected void open()
    {
        try
        {
            b = a.getWritableDatabase();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Failed to open ads db", exception);
        }
    }

    public void setDBLimit(int i)
    {
        if (i > 0)
        {
            d = i;
        }
    }
}
