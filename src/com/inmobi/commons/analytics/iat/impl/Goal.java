// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl;

import java.io.Serializable;

public class Goal
    implements Serializable
{

    private int a;
    private String b;
    private long c;
    private int d;
    private boolean e;

    public Goal()
    {
        setGoalCount(0);
        setGoalName(null);
        setRetryTime(0L);
        setRetryCount(0);
        setDuplicateGoal(false);
    }

    public Goal(String s, int i, long l, int j, boolean flag)
    {
        if (i < 0)
        {
            setGoalCount(0);
        } else
        {
            setGoalCount(i);
        }
        if (l < 0L)
        {
            setRetryTime(0L);
        } else
        {
            setRetryTime(l);
        }
        if (j < 0)
        {
            setRetryCount(0);
        } else
        {
            setRetryCount(j);
        }
        setGoalName(s);
        setDuplicateGoal(flag);
    }

    public int getGoalCount()
    {
        return a;
    }

    public String getGoalName()
    {
        return b;
    }

    public int getRetryCount()
    {
        return d;
    }

    public long getRetryTime()
    {
        return c;
    }

    public boolean isDuplicateGoal()
    {
        return e;
    }

    public final void setDuplicateGoal(boolean flag)
    {
        e = flag;
    }

    public final void setGoalCount(int i)
    {
        a = i;
    }

    public final void setGoalName(String s)
    {
        b = s;
    }

    public final void setRetryCount(int i)
    {
        d = i;
    }

    public final void setRetryTime(long l)
    {
        c = l;
    }
}
