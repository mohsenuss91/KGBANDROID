// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;

import com.google.a.b.a.i;
import com.google.a.d.a;
import com.google.a.d.d;
import java.io.IOException;

// Referenced classes of package com.google.a:
//            x, w

public abstract class ak
{

    public ak()
    {
    }

    public final w a(Object obj)
    {
        w w;
        try
        {
            i j = new i();
            a(((d) (j)), obj);
            w = j.a();
        }
        catch (IOException ioexception)
        {
            throw new x(ioexception);
        }
        return w;
    }

    public abstract Object a(a a1);

    public abstract void a(d d, Object obj);
}
