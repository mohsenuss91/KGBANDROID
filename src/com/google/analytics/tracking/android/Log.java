// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;


// Referenced classes of package com.google.analytics.tracking.android:
//            Logger, GoogleAnalytics

public class Log
{

    private static GoogleAnalytics sGaInstance;

    private Log()
    {
    }

    static void clearGaInstance()
    {
        sGaInstance = null;
    }

    public static void e(Exception exception)
    {
        Logger logger = getLogger();
        if (logger != null)
        {
            logger.error(exception);
        }
    }

    public static void e(String s)
    {
        Logger logger = getLogger();
        if (logger != null)
        {
            logger.error(s);
        }
    }

    private static Logger getLogger()
    {
        if (sGaInstance == null)
        {
            sGaInstance = GoogleAnalytics.getInstance();
        }
        if (sGaInstance != null)
        {
            return sGaInstance.getLogger();
        } else
        {
            return null;
        }
    }

    public static void i(String s)
    {
        Logger logger = getLogger();
        if (logger != null)
        {
            logger.info(s);
        }
    }

    public static boolean isVerbose()
    {
        if (getLogger() != null)
        {
            return Logger.LogLevel.VERBOSE.equals(getLogger().getLogLevel());
        } else
        {
            return false;
        }
    }

    public static void v(String s)
    {
        Logger logger = getLogger();
        if (logger != null)
        {
            logger.verbose(s);
        }
    }

    public static void w(String s)
    {
        Logger logger = getLogger();
        if (logger != null)
        {
            logger.warn(s);
        }
    }
}
