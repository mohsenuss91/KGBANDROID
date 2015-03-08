// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.android.compat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.j256.ormlite.android.compat:
//            BasicApiCompatibility

public class JellyBeanApiCompatibility extends BasicApiCompatibility
{

    public JellyBeanApiCompatibility()
    {
    }

    public ApiCompatibility.CancellationHook createCancellationHook()
    {
        return new JellyBeanCancellationHook();
    }

    public Cursor rawQuery(SQLiteDatabase sqlitedatabase, String s, String as[], ApiCompatibility.CancellationHook cancellationhook)
    {
        if (cancellationhook == null)
        {
            return sqlitedatabase.rawQuery(s, as);
        } else
        {
            return sqlitedatabase.rawQuery(s, as, ((JellyBeanCancellationHook)cancellationhook).cancellationSignal);
        }
    }

    private class JellyBeanCancellationHook
        implements ApiCompatibility.CancellationHook
    {

        private final CancellationSignal cancellationSignal = new CancellationSignal();

        public void cancel()
        {
            cancellationSignal.cancel();
        }


        public JellyBeanCancellationHook()
        {
        }
    }

}
