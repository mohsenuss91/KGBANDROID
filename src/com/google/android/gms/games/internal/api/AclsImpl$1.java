// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;

final class yG
    implements com.google.android.gms.games.internal.game.lResult
{

    final Status yG;

    public final Status getStatus()
    {
        return yG;
    }

    public final void release()
    {
    }

    clResult(Status status)
    {
        yG = status;
        super();
    }
}
