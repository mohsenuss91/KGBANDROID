// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.bq;

// Referenced classes of package com.appyet.receiver:
//            b

public final class c extends BroadcastReceiver
{

    private ApplicationContext a;
    private b b;

    public c(b b1)
    {
        b = b1;
    }

    public final void onReceive(Context context, Intent intent)
    {
        a = (ApplicationContext)context.getApplicationContext();
        if (a.a)
        {
            b.b();
            boolean flag;
            Long long1;
            if (intent.getExtras() != null && intent.getExtras().containsKey("moduleid"))
            {
                long1 = Long.valueOf(intent.getLongExtra("moduleid", -1L));
                flag = intent.getBooleanExtra("forced", false);
            } else
            {
                flag = false;
                long1 = null;
            }
            if (long1 == null && (flag || a.a) && a.t.a() > 0)
            {
                ApplicationContext applicationcontext = a;
                String s = a.getString(0x7f080056);
                Object aobj[] = new Object[1];
                aobj[0] = Integer.valueOf(a.t.a());
                Toast.makeText(applicationcontext, String.format(s, aobj), 1).show();
            }
        }
    }
}
