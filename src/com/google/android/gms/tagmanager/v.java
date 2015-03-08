// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.internal.ik;
import com.google.android.gms.internal.im;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.tagmanager:
//            bh

class v
    implements DataLayer.c
{

    private static final String afg = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[] {
        "datalayer", "ID", "key", "value", "expires"
    });
    private ik aec;
    private final Executor afh;
    private a afi;
    private int afj;
    private final Context mContext;

    public v(Context context)
    {
        this(context, im.fW(), "google_tagmanager.db", 2000, ((Executor) (Executors.newSingleThreadExecutor())));
    }

    v(Context context, ik ik1, String s, int i, Executor executor)
    {
        mContext = context;
        aec = ik1;
        afj = i;
        afh = executor;
        afi = new a(mContext, s);
    }

    private SQLiteDatabase S(String s)
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = afi.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            bh.D(s);
            return null;
        }
        return sqlitedatabase;
    }

    static List a(v v1)
    {
        return v1.lx();
    }

    static void a(v v1, String s)
    {
        v1.bQ(s);
    }

    static void a(v v1, List list, long l)
    {
        v1.b(list, l);
    }

    static Context b(v v1)
    {
        return v1.mContext;
    }

    private void b(List list, long l)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = aec.currentTimeMillis();
        x(l1);
        _mthdo(list.size());
        c(list, l1 + l);
        lA();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        lA();
        throw exception;
        Exception exception1;
        exception1;
        this;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    private void bQ(String s)
    {
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = S("Error opening database for clearKeysWithPrefix.");
        if (sqlitedatabase == null)
        {
            return;
        }
        String as[] = new String[2];
        as[0] = s;
        as[1] = (new StringBuilder()).append(s).append(".%").toString();
        int i = sqlitedatabase.delete("datalayer", "key = ? OR key LIKE ?", as);
        bh.C((new StringBuilder("Cleared ")).append(i).append(" items").toString());
        lA();
        return;
        SQLiteException sqliteexception;
        sqliteexception;
        bh.D((new StringBuilder("Error deleting entries with key prefix: ")).append(s).append(" (").append(sqliteexception).append(").").toString());
        lA();
        return;
        Exception exception;
        exception;
        lA();
        throw exception;
    }

    private void c(List list, long l)
    {
        SQLiteDatabase sqlitedatabase = S("Error opening database for writeEntryToDatabase.");
        if (sqlitedatabase != null)
        {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) 
            {
                b b1 = (b)iterator.next();
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("expires", Long.valueOf(l));
                contentvalues.put("key", b1.JI);
                contentvalues.put("value", b1.afp);
                sqlitedatabase.insert("datalayer", null, contentvalues);
            }
        }
    }

    private void _mthdo(int i)
    {
        int k = i + (lz() - afj);
        if (k > 0)
        {
            List list = dp(k);
            bh.B((new StringBuilder("DataLayer store full, deleting ")).append(list.size()).append(" entries to make room.").toString());
            g((String[])list.toArray(new String[0]));
        }
    }

    private List dp(int i)
    {
        ArrayList arraylist;
        SQLiteDatabase sqlitedatabase;
        arraylist = new ArrayList();
        if (i <= 0)
        {
            bh.D("Invalid maxEntries specified. Skipping.");
            return arraylist;
        }
        sqlitedatabase = S("Error opening database for peekEntryIds.");
        if (sqlitedatabase == null)
        {
            return arraylist;
        }
        Cursor cursor1 = sqlitedatabase.query("datalayer", new String[] {
            "ID"
        }, null, null, null, null, String.format("%s ASC", new Object[] {
            "ID"
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
        bh.D((new StringBuilder("Error in peekEntries fetching entryIds: ")).append(sqliteexception.getMessage()).toString());
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

    private List e(List list)
    {
        ArrayList arraylist = new ArrayList();
        b b1;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(new DataLayer.a(b1.JI, j(b1.afp))))
        {
            b1 = (b)iterator.next();
        }

        return arraylist;
    }

    private List f(List list)
    {
        ArrayList arraylist = new ArrayList();
        DataLayer.a a1;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(new b(a1.JI, j(a1.afe))))
        {
            a1 = (DataLayer.a)iterator.next();
        }

        return arraylist;
    }

    private void g(String as[])
    {
        SQLiteDatabase sqlitedatabase;
        if (as != null && as.length != 0)
        {
            if ((sqlitedatabase = S("Error opening database for deleteEntries.")) != null)
            {
                Object aobj[] = new Object[2];
                aobj[0] = "ID";
                aobj[1] = TextUtils.join(",", Collections.nCopies(as.length, "?"));
                String s = String.format("%s in (%s)", aobj);
                try
                {
                    sqlitedatabase.delete("datalayer", s, as);
                    return;
                }
                catch (SQLiteException sqliteexception)
                {
                    bh.D((new StringBuilder("Error deleting entries ")).append(Arrays.toString(as)).toString());
                }
                return;
            }
        }
    }

    private Object j(byte abyte0[])
    {
        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
        ObjectInputStream objectinputstream = new ObjectInputStream(bytearrayinputstream);
        Object obj = objectinputstream.readObject();
        IOException ioexception;
        IOException ioexception1;
        ClassNotFoundException classnotfoundexception;
        IOException ioexception2;
        Exception exception;
        IOException ioexception3;
        Exception exception1;
        ClassNotFoundException classnotfoundexception1;
        IOException ioexception5;
        try
        {
            objectinputstream.close();
            bytearrayinputstream.close();
        }
        catch (IOException ioexception4)
        {
            return obj;
        }
        return obj;
        ioexception5;
        objectinputstream = null;
_L8:
        if (objectinputstream == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        objectinputstream.close();
        bytearrayinputstream.close();
        return null;
        ioexception1;
        return null;
        classnotfoundexception1;
        objectinputstream = null;
_L6:
        if (objectinputstream == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        objectinputstream.close();
        bytearrayinputstream.close();
        return null;
        ioexception2;
        return null;
        exception1;
        objectinputstream = null;
        exception = exception1;
_L4:
        if (objectinputstream == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        objectinputstream.close();
        bytearrayinputstream.close();
_L2:
        throw exception;
        ioexception3;
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        if (true) goto _L4; else goto _L3
_L3:
        classnotfoundexception;
        if (true) goto _L6; else goto _L5
_L5:
        ioexception;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private byte[] j(Object obj)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(bytearrayoutputstream);
        byte abyte0[];
        objectoutputstream.writeObject(obj);
        abyte0 = bytearrayoutputstream.toByteArray();
        IOException ioexception;
        IOException ioexception1;
        Exception exception;
        IOException ioexception2;
        Exception exception1;
        IOException ioexception4;
        try
        {
            objectoutputstream.close();
            bytearrayoutputstream.close();
        }
        catch (IOException ioexception3)
        {
            return abyte0;
        }
        return abyte0;
        ioexception4;
        objectoutputstream = null;
_L6:
        if (objectoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        objectoutputstream.close();
        bytearrayoutputstream.close();
        return null;
        ioexception1;
        return null;
        exception1;
        objectoutputstream = null;
        exception = exception1;
_L4:
        if (objectoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        objectoutputstream.close();
        bytearrayoutputstream.close();
_L2:
        throw exception;
        ioexception2;
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        if (true) goto _L4; else goto _L3
_L3:
        ioexception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void lA()
    {
        try
        {
            afi.close();
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            return;
        }
    }

    static String lB()
    {
        return afg;
    }

    private List lx()
    {
        List list;
        x(aec.currentTimeMillis());
        list = e(ly());
        lA();
        return list;
        Exception exception;
        exception;
        lA();
        throw exception;
    }

    private List ly()
    {
        ArrayList arraylist;
        Cursor cursor;
        SQLiteDatabase sqlitedatabase = S("Error opening database for loadSerialized.");
        arraylist = new ArrayList();
        if (sqlitedatabase == null)
        {
            return arraylist;
        }
        cursor = sqlitedatabase.query("datalayer", new String[] {
            "key", "value"
        }, null, null, null, null, "ID", null);
        while (cursor.moveToNext()) 
        {
            arraylist.add(new b(cursor.getString(0), cursor.getBlob(1)));
        }
        break MISSING_BLOCK_LABEL_101;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
        cursor.close();
        return arraylist;
    }

    private int lz()
    {
        Cursor cursor;
        SQLiteDatabase sqlitedatabase;
        int i;
        cursor = null;
        sqlitedatabase = S("Error opening database for getNumStoredEntries.");
        i = 0;
        if (sqlitedatabase != null) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        boolean flag;
        cursor = sqlitedatabase.rawQuery("SELECT COUNT(*) from datalayer", null);
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
        bh.D("Error getting numStoredEntries");
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

    private void x(long l)
    {
        SQLiteDatabase sqlitedatabase = S("Error opening database for deleteOlderThan.");
        if (sqlitedatabase == null)
        {
            return;
        }
        try
        {
            String as[] = new String[1];
            as[0] = Long.toString(l);
            int i = sqlitedatabase.delete("datalayer", "expires <= ?", as);
            bh.C((new StringBuilder("Deleted ")).append(i).append(" expired items").toString());
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            bh.D("Error deleting old entries.");
        }
    }

    public void a(DataLayer.c.a a1)
    {
        afh.execute(new _cls2(a1));
    }

    public void a(List list, long l)
    {
        List list1 = f(list);
        afh.execute(new _cls1(list1, l));
    }

    public void bP(String s)
    {
        afh.execute(new _cls3(s));
    }


    private class a extends SQLiteOpenHelper
    {

        final v afm;

        private void a(SQLiteDatabase sqlitedatabase)
        {
            Cursor cursor;
            HashSet hashset;
            cursor = sqlitedatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
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
            if (!hashset.remove("key") || !hashset.remove("value") || !hashset.remove("ID") || !hashset.remove("expires"))
            {
                throw new SQLiteException("Database column missing");
            }
            break MISSING_BLOCK_LABEL_124;
            Exception exception;
            exception;
            cursor.close();
            throw exception;
            if (!hashset.isEmpty())
            {
                throw new SQLiteException("Database has extra columns");
            } else
            {
                return;
            }
        }

        private boolean a(String s, SQLiteDatabase sqlitedatabase)
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
            bh.D((new StringBuilder("Error querying for table ")).append(s).toString());
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

        public SQLiteDatabase getWritableDatabase()
        {
            SQLiteDatabase sqlitedatabase1 = super.getWritableDatabase();
            SQLiteDatabase sqlitedatabase = sqlitedatabase1;
_L2:
            if (sqlitedatabase == null)
            {
                sqlitedatabase = super.getWritableDatabase();
            }
            return sqlitedatabase;
            SQLiteException sqliteexception;
            sqliteexception;
            v.b(afm).getDatabasePath("google_tagmanager.db").delete();
            sqlitedatabase = null;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            ak.N(sqlitedatabase.getPath());
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
            if (!a("datalayer", sqlitedatabase))
            {
                sqlitedatabase.execSQL(v.lB());
                return;
            } else
            {
                a(sqlitedatabase);
                return;
            }
            exception;
            cursor.close();
            throw exception;
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int k)
        {
        }

        a(Context context, String s)
        {
            afm = v.this;
            super(context, s, null, 1);
        }
    }


    private class b
    {

        final String JI;
        final byte afp[];

        public String toString()
        {
            return (new StringBuilder("KeyAndSerialized: key = ")).append(JI).append(" serialized hash = ").append(Arrays.hashCode(afp)).toString();
        }

        b(String s, byte abyte0[])
        {
            JI = s;
            afp = abyte0;
        }
    }


    private class _cls2
        implements Runnable
    {

        final v afm;
        final DataLayer.c.a afn;

        public void run()
        {
            afn.d(v.a(afm));
        }

        _cls2(DataLayer.c.a a1)
        {
            afm = v.this;
            afn = a1;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final List afk;
        final long afl;
        final v afm;

        public void run()
        {
            v.a(afm, afk, afl);
        }

        _cls1(List list, long l)
        {
            afm = v.this;
            afk = list;
            afl = l;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final v afm;
        final String afo;

        public void run()
        {
            v.a(afm, afo);
        }

        _cls3(String s)
        {
            afm = v.this;
            afo = s;
            super();
        }
    }

}
