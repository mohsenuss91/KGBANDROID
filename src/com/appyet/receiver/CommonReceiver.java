// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.manager.as;
import com.appyet.manager.bl;
import com.appyet.manager.bo;
import com.appyet.manager.bp;
import com.appyet.manager.bq;

public class CommonReceiver extends BroadcastReceiver
{

    public CommonReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        ApplicationContext applicationcontext = (ApplicationContext)context.getApplicationContext();
        if (!intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) goto _L2; else goto _L1
_L1:
        bo bo1 = applicationcontext.g.a();
        if (applicationcontext.c() <= 0) goto _L4; else goto _L3
_L3:
        if (bo1 == bo.a || bo1 == bo.c && applicationcontext.d.m())
        {
            applicationcontext.t.b();
            return;
        }
          goto _L5
_L4:
        if (!applicationcontext.f()) goto _L5; else goto _L6
_L6:
        if (!applicationcontext.d.m()) goto _L8; else goto _L7
_L7:
        if (bo1 == bo.b)
        {
            return;
        }
          goto _L5
_L2:
        if (!"android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) goto _L10; else goto _L9
_L9:
        if (!applicationcontext.d.L()) goto _L5; else goto _L11
_L11:
        keyevent = (KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyevent == null) goto _L5; else goto _L12
_L12:
        i = keyevent.getKeyCode();
        keyevent.getAction();
        keyevent.getEventTime();
        i;
        JVM INSTR lookupswitch 3: default 428
    //                   79: 204
    //                   85: 204
    //                   86: 230;
           goto _L13 _L14 _L14 _L15
_L14:
        if (applicationcontext.c.g())
        {
            applicationcontext.c.h();
            return;
        }
          goto _L16
_L8:
        KeyEvent keyevent;
        int i;
        try
        {
            bo.a;
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
        return;
_L15:
        if (applicationcontext.c.g())
        {
            applicationcontext.c.h();
            return;
        }
          goto _L5
_L16:
        if (applicationcontext.c.m())
        {
            applicationcontext.c.a(false);
            return;
        }
          goto _L5
_L10:
        if (!"android.intent.action.HEADSET_PLUG".equals(intent.getAction())) goto _L18; else goto _L17
_L17:
        if (applicationcontext.d.M() && intent.getIntExtra("state", -1) == 0 && applicationcontext.c.g())
        {
            applicationcontext.c.h();
            return;
        }
          goto _L5
_L18:
        if (!"android.intent.action.ACTION_POWER_DISCONNECTED".equals(intent.getAction())) goto _L20; else goto _L19
_L19:
        if (applicationcontext.d.N() && applicationcontext.c.g())
        {
            applicationcontext.c.h();
            return;
        }
          goto _L5
_L20:
        if (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) goto _L5; else goto _L21
_L21:
        intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0x80000000);
        JVM INSTR tableswitch 12 13: default 429
    //                   12 427
    //                   13 408;
           goto _L22 _L23 _L24
_L23:
        break; /* Loop/switch isn't completed */
_L24:
        if (applicationcontext.c.g())
        {
            applicationcontext.c.h();
        }
_L5:
        return;
_L13:
        return;
_L22:
    }
}
