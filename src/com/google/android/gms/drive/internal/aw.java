// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            c

public class aw extends c
{

    private final com.google.android.gms.common.api.a.d yO;

    public aw(com.google.android.gms.common.api.a.d d)
    {
        yO = d;
    }

    public void o(Status status)
    {
        yO.a(status);
    }

    public void onSuccess()
    {
        yO.a(Status.Ek);
    }
}
