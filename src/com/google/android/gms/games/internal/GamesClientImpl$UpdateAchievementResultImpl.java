// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;

final class OQ
    implements com.google.android.gms.games.achievement._06_
{

    private final String OQ;
    private final Status yw;

    public final String getAchievementId()
    {
        return OQ;
    }

    public final Status getStatus()
    {
        return yw;
    }

    (int i, String s)
    {
        yw = new Status(i);
        OQ = s;
    }
}
