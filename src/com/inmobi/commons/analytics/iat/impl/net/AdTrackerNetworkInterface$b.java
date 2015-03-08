// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;


// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerNetworkInterface

final class 
    implements com.inmobi.commons.cache.
{

    public final void completed()
    {
        AdTrackerNetworkInterface.notifyThread();
    }

    public final void run()
    {
        AdTrackerNetworkInterface.f();
    }

    ()
    {
    }
}
