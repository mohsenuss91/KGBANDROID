// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            Scope

public final class Api
{

    private final b Dj;
    private final c Dk;
    private final ArrayList Dl;

    public transient Api(b b, c c, Scope ascope[])
    {
        Dj = b;
        Dk = c;
        Dl = new ArrayList(Arrays.asList(ascope));
    }

    public final b eu()
    {
        return Dj;
    }

    public final List ev()
    {
        return Dl;
    }

    public final c ew()
    {
        return Dk;
    }
}
