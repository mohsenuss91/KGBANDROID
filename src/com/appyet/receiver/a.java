// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.receiver;

import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.manager.bq;

// Referenced classes of package com.appyet.receiver:
//            AlarmReceiver

final class a extends com.appyet.f.a
{

    final AlarmReceiver a;

    private a(AlarmReceiver alarmreceiver)
    {
        a = alarmreceiver;
        super();
    }

    a(AlarmReceiver alarmreceiver, byte byte0)
    {
        this(alarmreceiver);
    }

    private transient Void f()
    {
        try
        {
            AlarmReceiver.a(a).t.a(null, false);
        }
        catch (Exception exception)
        {
            d.a(exception);
            return null;
        }
        return null;
    }

    protected final volatile void a(Object obj)
    {
    }

    protected final Object b()
    {
        return f();
    }
}
