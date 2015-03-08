// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            d, au, ah

class it> extends d
{

    final ah alU;
    final com.google.android.gms.wearable.pi.NodeListener alV;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((au));
    }

    protected void a(au au1)
    {
        au1.b(this, alV);
    }

    public Result c(Status status)
    {
        return d(status);
    }

    public Status d(Status status)
    {
        return new Status(13);
    }

    r(ah ah, com.google.android.gms.wearable.pi.NodeListener nodelistener)
    {
        alU = ah;
        alV = nodelistener;
        super();
    }
}
