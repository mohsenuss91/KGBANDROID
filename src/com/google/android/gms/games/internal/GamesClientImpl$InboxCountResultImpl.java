// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;

final class NK
    implements com.google.android.gms.games.sultImpl
{

    private final Bundle NK;
    private final Status yw;

    public final Status getStatus()
    {
        return yw;
    }

    (Status status, Bundle bundle)
    {
        yw = status;
        NK = bundle;
    }
}
