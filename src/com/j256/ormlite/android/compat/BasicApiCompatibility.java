// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.android.compat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.j256.ormlite.android.compat:
//            ApiCompatibility

public class BasicApiCompatibility
    implements ApiCompatibility
{

    public BasicApiCompatibility()
    {
    }

    public ApiCompatibility.CancellationHook createCancellationHook()
    {
        return null;
    }

    public Cursor rawQuery(SQLiteDatabase sqlitedatabase, String s, String as[], ApiCompatibility.CancellationHook cancellationhook)
    {
        return sqlitedatabase.rawQuery(s, as);
    }
}
