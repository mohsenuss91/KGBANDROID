// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.internal.hn;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnEventResponse

public class x extends ac.a
{

    private final int In;
    private final com.google.android.gms.drive.events.DriveEvent.Listener Jk;
    private final a Jl;

    public x(Looper looper, int i, com.google.android.gms.drive.events.DriveEvent.Listener listener)
    {
        In = i;
        Jk = listener;
        Jl = new a(looper, null);
    }

    public void a(OnEventResponse oneventresponse)
    {
        boolean flag;
        if (In == oneventresponse.getEventType())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hn.A(flag);
        switch (oneventresponse.getEventType())
        {
        default:
            Log.w("EventCallback", (new StringBuilder("Unexpected event type:")).append(oneventresponse.getEventType()).toString());
            return;

        case 1: // '\001'
            Jl.a(Jk, oneventresponse.gr());
            return;

        case 2: // '\002'
            Jl.a(Jk, oneventresponse.gs());
            break;
        }
    }

    private class a extends Handler
    {

        public void a(com.google.android.gms.drive.events.DriveEvent.Listener listener, DriveEvent driveevent)
        {
            sendMessage(obtainMessage(1, new Pair(listener, driveevent)));
        }

        public void handleMessage(Message message)
        {
            Pair pair;
            switch (message.what)
            {
            default:
                Log.wtf("EventCallback", "Don't know how to handle this event");
                return;

            case 1: // '\001'
                pair = (Pair)message.obj;
                break;
            }
            ((com.google.android.gms.drive.events.DriveEvent.Listener)pair.first).onEvent((DriveEvent)pair.second);
        }

        private a(Looper looper)
        {
            super(looper);
        }

        a(Looper looper, _cls1 _pcls1)
        {
            this(looper);
        }
    }

}
