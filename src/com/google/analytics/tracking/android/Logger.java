// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;


public interface Logger
{

    public abstract void error(Exception exception);

    public abstract void error(String s);

    public abstract LogLevel getLogLevel();

    public abstract void info(String s);

    public abstract void setLogLevel(LogLevel loglevel);

    public abstract void verbose(String s);

    public abstract void warn(String s);
}
