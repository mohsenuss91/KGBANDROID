// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;

final class HJ
    implements com.google.android.gms.games.sultImpl
{

    private final Bundle HJ;
    private final Status yw;

    public final Status getStatus()
    {
        return yw;
    }

    (int i, Bundle bundle)
    {
        yw = new Status(i);
        HJ = bundle;
    }
}
