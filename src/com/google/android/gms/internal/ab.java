// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            ew

public final class ab
{

    private final String lm;
    private final JSONObject ln;
    private final String lo;
    private final String lp;

    public ab(String s, ew ew1, String s1, JSONObject jsonobject)
    {
        lp = ew1.st;
        ln = jsonobject;
        lo = s;
        lm = s1;
    }

    public final String am()
    {
        return lm;
    }

    public final String an()
    {
        return lp;
    }

    public final JSONObject ao()
    {
        return ln;
    }

    public final String ap()
    {
        return lo;
    }
}
