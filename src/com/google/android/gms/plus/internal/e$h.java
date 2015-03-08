// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.plus.internal:
//            e

final class yw extends com.google.android.gms.internal.
{

    final e abJ;
    private final Status yw;

    protected final void d(Object obj)
    {
        n((com.google.android.gms.common.api.)obj);
    }

    protected final void fp()
    {
    }

    protected final void n(com.google.android.gms.common.api..h h)
    {
        abJ.disconnect();
        if (h != null)
        {
            h.a(yw);
        }
    }

    public (e e1, com.google.android.gms.common.api. , Status status)
    {
        abJ = e1;
        super(e1, );
        yw = status;
    }
}
