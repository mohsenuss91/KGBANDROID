// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g.b;

import com.appyet.g.c.b;
import com.appyet.g.r;
import java.math.BigDecimal;

// Referenced classes of package com.appyet.g.b:
//            i

public final class e
    implements i
{

    public e()
    {
    }

    public final b a(Object obj)
    {
        return r.a("double", BigDecimal.valueOf(((Number)obj).doubleValue()).toPlainString());
    }
}
