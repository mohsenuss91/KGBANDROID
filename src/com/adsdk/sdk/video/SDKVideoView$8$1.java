// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;


class val.time
    implements Runnable
{

    final val.time this$1;
    private final meEventListener val$l;
    private final int val$time;

    public void run()
    {
        val$l.onTimeEvent(val$time);
    }

    meEventListener()
    {
        this$1 = final_meeventlistener;
        val$l = meeventlistener1;
        val$time = I.this;
        super();
    }
}
