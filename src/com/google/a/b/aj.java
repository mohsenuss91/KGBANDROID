// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import java.lang.reflect.Method;

// Referenced classes of package com.google.a.b:
//            ah

final class aj extends ah
{

    final Method a;

    aj(Method method)
    {
        a = method;
        super();
    }

    public final Object a(Class class1)
    {
        return a.invoke(null, new Object[] {
            class1, java/lang/Object
        });
    }
}
