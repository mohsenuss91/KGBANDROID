// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.request;

import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;

// Referenced classes of package com.google.android.gms.games.internal.request:
//            RequestUpdateOutcomes

public final class CQ
{

    private int CQ;
    private HashMap Sl;

    public final CQ cw(int i)
    {
        CQ = i;
        return this;
    }

    public final RequestUpdateOutcomes it()
    {
        return new RequestUpdateOutcomes(CQ, Sl, null);
    }

    public final Sl v(String s, int i)
    {
        if (RequestUpdateResultOutcome.isValid(i))
        {
            Sl.put(s, Integer.valueOf(i));
        }
        return this;
    }

    public Q()
    {
        Sl = new HashMap();
        CQ = 0;
    }
}
