// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.common.api.Status;

final class yG
    implements ateResult
{

    final Status yG;

    public final ateConflictResult getConflictResult()
    {
        return null;
    }

    public final ateLoadedResult getLoadedResult()
    {
        return null;
    }

    public final Status getStatus()
    {
        return yG;
    }

    public final void release()
    {
    }

    ateLoadedResult(Status status)
    {
        yG = status;
        super();
    }
}
