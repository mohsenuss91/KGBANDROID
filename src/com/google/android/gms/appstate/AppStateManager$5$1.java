// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.common.api.Status;

class yG
    implements eDeletedResult
{

    final Status yG;
    final yG yJ;

    public int getStateKey()
    {
        return yJ.;
    }

    public Status getStatus()
    {
        return yG;
    }

    eDeletedResult(eDeletedResult edeletedresult, Status status)
    {
        yJ = edeletedresult;
        yG = status;
        super();
    }
}
