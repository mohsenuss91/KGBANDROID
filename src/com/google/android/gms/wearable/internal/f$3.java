// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemBuffer;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            d, au, f

class nit> extends d
{

    final f alz;

    protected volatile void a(com.google.android.gms.common.api.a a1)
    {
        a((au)a1);
    }

    protected void a(au au1)
    {
        au1.o(this);
    }

    protected DataItemBuffer ar(Status status)
    {
        return new DataItemBuffer(DataHolder.af(status.getStatusCode()));
    }

    protected Result c(Status status)
    {
        return ar(status);
    }

    r(f f)
    {
        alz = f;
        super();
    }
}
