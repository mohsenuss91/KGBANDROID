// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Method;

// Referenced classes of package org.simpleframework.xml.core:
//            Context, Session

class Function
{

    private final boolean contextual;
    private final Method method;

    public Function(Method method1)
    {
        this(method1, false);
    }

    public Function(Method method1, boolean flag)
    {
        contextual = flag;
        method = method1;
    }

    public Object call(Context context, Object obj)
    {
        if (obj != null)
        {
            java.util.Map map = context.getSession().getMap();
            if (contextual)
            {
                return method.invoke(obj, new Object[] {
                    map
                });
            } else
            {
                return method.invoke(obj, new Object[0]);
            }
        } else
        {
            return null;
        }
    }
}
