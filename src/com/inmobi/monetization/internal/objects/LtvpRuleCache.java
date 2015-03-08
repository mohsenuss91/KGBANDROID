// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.objects;

import android.content.Context;
import android.content.SharedPreferences;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.GetLtvpRulesResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class LtvpRuleCache
{

    static LtvpRuleCache a;
    private static String c = "IMAdMLtvpRuleCache";
    private static String d = "IMAdMLtvpRuleId";
    private static String e = "IMAdMLtvpHardExpiry";
    private static String f = "IMAdMLtvpSoftExpiry";
    private SharedPreferences b;

    private LtvpRuleCache(Context context)
    {
        b = null;
        b = context.getSharedPreferences(c, 0);
    }

    private void a(long l)
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        editor.putLong(e, l);
        editor.commit();
    }

    private void a(String s)
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        editor.putString(d, s);
        editor.commit();
    }

    private void a(HashMap hashmap)
    {
        android.content.SharedPreferences.Editor editor;
        try
        {
            editor = b.edit();
            String s;
            for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); editor.putInt(s, ((Integer)hashmap.get(s)).intValue()))
            {
                s = (String)iterator.next();
            }

        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Analytics]-4.4.1", "Exception saving rule map", exception);
            return;
        }
        editor.commit();
        return;
    }

    private void b(long l)
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        editor.putLong(f, l);
        editor.commit();
    }

    public static LtvpRuleCache getInstance(Context context)
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        com/inmobi/monetization/internal/objects/LtvpRuleCache;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new LtvpRuleCache(context);
        }
        com/inmobi/monetization/internal/objects/LtvpRuleCache;
        JVM INSTR monitorexit ;
_L2:
        return a;
        Exception exception;
        exception;
        throw exception;
    }

    public void clearLtvpRuleCache()
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        editor.clear();
        editor.commit();
    }

    public long getHardExpiryForLtvpRule()
    {
        return b.getLong(e, 0L);
    }

    public int getLtvpRule(long l)
    {
        return b.getInt(String.valueOf(l), 0);
    }

    public String getLtvpRuleId()
    {
        return b.getString(d, "");
    }

    public long getSoftExpiryForLtvpRule()
    {
        return b.getLong(f, 0L);
    }

    public void setLtvpRuleConfig(GetLtvpRulesResponse getltvprulesresponse)
    {
        a(getltvprulesresponse.getRuleId());
        a(getltvprulesresponse.getHardExpiry() + getltvprulesresponse.getTimeStamp());
        b(getltvprulesresponse.getSoftExpiry() + getltvprulesresponse.getTimeStamp());
        a(getltvprulesresponse.getRules());
    }

}
