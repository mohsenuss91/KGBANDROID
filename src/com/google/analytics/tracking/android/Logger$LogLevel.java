// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;


public final class  extends Enum
{

    private static final .VALUES $VALUES[];
    public static final .VALUES ERROR;
    public static final .VALUES INFO;
    public static final .VALUES VERBOSE;
    public static final .VALUES WARNING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/analytics/tracking/android/Logger$LogLevel, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        VERBOSE = new <init>("VERBOSE", 0);
        INFO = new <init>("INFO", 1);
        WARNING = new <init>("WARNING", 2);
        ERROR = new <init>("ERROR", 3);
        l_3B_.clone aclone[] = new <init>[4];
        aclone[0] = VERBOSE;
        aclone[1] = INFO;
        aclone[2] = WARNING;
        aclone[3] = ERROR;
        $VALUES = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
