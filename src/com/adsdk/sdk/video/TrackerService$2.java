// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;


// Referenced classes of package com.adsdk.sdk.video:
//            TrackerService

class dler
    implements ceptionHandler
{

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        TrackerService.access$7(false);
        TrackerService.access$8(null);
        TrackerService.startTracking();
    }

    dler()
    {
    }
}
