// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            q, s

abstract class <init> extends q
{

    final s IZ;

    public Result c(Status status)
    {
        return q(status);
    }

    public com.google.android.gms.drive.eApi.ContentsResult q(Status status)
    {
        return new <init>(status, null);
    }

    private entsResult(s s)
    {
        IZ = s;
        super();
    }

    nit>(s s, nit> nit>)
    {
        this(s);
    }
}
