// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.metric;


// Referenced classes of package com.inmobi.commons.metric:
//            EventLog

public interface 
{

    public abstract void dataCollected(EventLog eventlog);

    public abstract void movedMetricDataToFileMemory(String s);

    public abstract void reportingFailure();

    public abstract void reportingStartedWithRequest(String s);

    public abstract void reportingSuccess();
}
