// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class Ax
    implements diaChannelResult
{

    private final JSONObject Ax;
    private final Status yw;

    public final JSONObject getCustomData()
    {
        return Ax;
    }

    public final Status getStatus()
    {
        return yw;
    }

    diaChannelResult(Status status, JSONObject jsonobject)
    {
        yw = status;
        Ax = jsonobject;
    }
}
