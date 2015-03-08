// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.query.Query;

// Referenced classes of package com.google.android.gms.drive.internal:
//            r, QueryRequest, aa, p

class <init> extends <init>
{

    final Query IH;
    final p II;

    protected volatile void a(com.google.android.gms.common.api.a a1)
    {
        a((r)a1);
    }

    protected void a(r r1)
    {
        r1.gk().a(new QueryRequest(IH), new <init>(this));
    }

    yRequest(p p, Query query)
    {
        II = p;
        IH = query;
        super(p);
    }
}
