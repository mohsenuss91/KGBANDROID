// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import java.util.ArrayList;

// Referenced classes of package com.google.analytics.tracking.android:
//            StandardExceptionParser, Log, ExceptionParser, MapBuilder, 
//            Tracker, ServiceManager

public class ExceptionReporter
    implements Thread.UncaughtExceptionHandler
{

    static final String DEFAULT_DESCRIPTION = "UncaughtException";
    private ExceptionParser mExceptionParser;
    private final Thread.UncaughtExceptionHandler mOriginalHandler;
    private final ServiceManager mServiceManager;
    private final Tracker mTracker;

    public ExceptionReporter(Tracker tracker, ServiceManager servicemanager, Thread.UncaughtExceptionHandler uncaughtexceptionhandler, Context context)
    {
        if (tracker == null)
        {
            throw new NullPointerException("tracker cannot be null");
        }
        if (servicemanager == null)
        {
            throw new NullPointerException("serviceManager cannot be null");
        }
        mOriginalHandler = uncaughtexceptionhandler;
        mTracker = tracker;
        mServiceManager = servicemanager;
        mExceptionParser = new StandardExceptionParser(context, new ArrayList());
        StringBuilder stringbuilder = new StringBuilder("ExceptionReporter created, original handler is ");
        String s;
        if (uncaughtexceptionhandler == null)
        {
            s = "null";
        } else
        {
            s = uncaughtexceptionhandler.getClass().getName();
        }
        Log.v(stringbuilder.append(s).toString());
    }

    public ExceptionParser getExceptionParser()
    {
        return mExceptionParser;
    }

    public void setExceptionParser(ExceptionParser exceptionparser)
    {
        mExceptionParser = exceptionparser;
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        String s = "UncaughtException";
        if (mExceptionParser != null)
        {
            String s1;
            if (thread != null)
            {
                s1 = thread.getName();
            } else
            {
                s1 = null;
            }
            s = mExceptionParser.getDescription(s1, throwable);
        }
        Log.v((new StringBuilder("Tracking Exception: ")).append(s).toString());
        mTracker.send(MapBuilder.createException(s, Boolean.valueOf(true)).build());
        mServiceManager.dispatchLocalHits();
        if (mOriginalHandler != null)
        {
            Log.v("Passing exception to original handler.");
            mOriginalHandler.uncaughtException(thread, throwable);
        }
    }
}
