// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;

final class NH
    implements com.google.android.gms.games.snapshot.NH
{

    private final String NH;
    private final Status yw;

    public final String getSnapshotId()
    {
        return NH;
    }

    public final Status getStatus()
    {
        return yw;
    }

    (int i, String s)
    {
        yw = new Status(i);
        NH = s;
    }
}
