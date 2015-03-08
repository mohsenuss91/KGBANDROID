// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataLanguage;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.appyet.manager:
//            bp

public final class ar
{

    public static Locale a = null;
    public static Locale b = Locale.getDefault();
    public static String c = null;
    public static String d = "ayL3u28KfLxUQx8c9";

    private static String a(ApplicationContext applicationcontext, String s)
    {
        List list;
        String s1;
        list = applicationcontext.q.MetadataLanguages;
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            MetadataLanguage metadatalanguage1 = (MetadataLanguage)iterator.next();
            if (metadatalanguage1.LocaleCode.equalsIgnoreCase(s))
            {
                return metadatalanguage1.LocaleCode;
            }
        }

        String as[] = s.split("_");
        if (as.length <= 0)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        s1 = as[0];
_L1:
        String s2;
        for (Iterator iterator1 = list.iterator(); iterator1.hasNext();)
        {
            MetadataLanguage metadatalanguage = (MetadataLanguage)iterator1.next();
            if (metadatalanguage.LocaleCode.equalsIgnoreCase(s1))
            {
                return metadatalanguage.LocaleCode;
            }
        }

        s2 = Locale.ENGLISH.getLanguage();
        return s2;
        Exception exception;
        exception;
        return Locale.ENGLISH.getLanguage();
        s1 = null;
          goto _L1
    }

    private static Locale a(String s)
    {
        String as[] = s.split("_");
        if (as.length <= 0) goto _L2; else goto _L1
_L1:
        String s1 = as[0];
_L6:
        if (as.length <= 1) goto _L4; else goto _L3
_L3:
        String s2 = as[1];
_L5:
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        return new Locale(s1, s2);
        Locale locale = new Locale(s1);
        return locale;
        Exception exception;
        exception;
        return Locale.ENGLISH;
_L4:
        s2 = null;
        if (true) goto _L5; else goto _L2
_L2:
        s1 = null;
          goto _L6
    }

    public static void a(Context context)
    {
        a((ApplicationContext)context.getApplicationContext());
    }

    public static void a(ApplicationContext applicationcontext)
    {
        if (a == null)
        {
            String s = a(applicationcontext, applicationcontext.d.q());
            a = a(s);
            applicationcontext.d.a(s);
        }
        Locale.setDefault(a);
        Configuration configuration = new Configuration();
        configuration.locale = a;
        applicationcontext.getBaseContext().getResources().updateConfiguration(configuration, applicationcontext.getBaseContext().getResources().getDisplayMetrics());
    }

    public static Locale b(ApplicationContext applicationcontext)
    {
        if (a == null)
        {
            return a(a(applicationcontext, applicationcontext.d.q()));
        } else
        {
            return a;
        }
    }

    public static String c(ApplicationContext applicationcontext)
    {
        if (c != null) goto _L2; else goto _L1
_L1:
        Locale locale = b(applicationcontext);
        if (locale.getCountry() == null || locale.getCountry().trim().length() <= 0)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        if (!locale.toString().equalsIgnoreCase("sr_RS")) goto _L4; else goto _L3
_L3:
        c = "sr-cyrl, sr_RS, sr;q=0.5";
_L2:
        String s;
        Exception exception1;
        try
        {
            s = c;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return "";
        }
        return s;
_L4:
        if (!locale.toString().equalsIgnoreCase("sr_ME"))
        {
            break MISSING_BLOCK_LABEL_94;
        }
        c = "sr-latn, sr_ME, sr;q=0.5";
          goto _L2
        exception1;
        c = locale.getLanguage();
          goto _L2
        c = (new StringBuilder()).append(locale.getLanguage()).append(", ").append(locale.toString()).append(";q=0.8").toString();
          goto _L2
        c = (new StringBuilder()).append(locale.getLanguage()).append(";q=0.8").toString();
          goto _L2
    }

}
