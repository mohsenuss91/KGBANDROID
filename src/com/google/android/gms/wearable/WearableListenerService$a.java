// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.af;
import com.google.android.gms.wearable.internal.ai;

// Referenced classes of package com.google.android.gms.wearable:
//            WearableListenerService

class <init> extends com.google.android.gms.wearable.internal.
{

    final WearableListenerService alr;

    public void Y(DataHolder dataholder)
    {
label0:
        {
            if (Log.isLoggable("WearableLS", 3))
            {
                Log.d("WearableLS", (new StringBuilder("onDataItemChanged: ")).append(WearableListenerService.a(alr)).append(": ").append(dataholder).toString());
            }
            WearableListenerService.b(alr);
            class _cls1
                implements Runnable
            {

                final DataHolder als;
                final WearableListenerService.a alt;

                public void run()
                {
                    DataEventBuffer dataeventbuffer = new DataEventBuffer(als);
                    alt.alr.onDataChanged(dataeventbuffer);
                    dataeventbuffer.release();
                    return;
                    Exception exception1;
                    exception1;
                    dataeventbuffer.release();
                    throw exception1;
                }

            _cls1(DataHolder dataholder)
            {
                alt = WearableListenerService.a.this;
                als = dataholder;
                super();
            }
            }

            synchronized (WearableListenerService.c(alr))
            {
                if (!WearableListenerService.d(alr))
                {
                    break label0;
                }
                dataholder.close();
            }
            return;
        }
        WearableListenerService.e(alr).post(new _cls1(dataholder));
        obj;
        JVM INSTR monitorexit ;
    }

    public void a(af af)
    {
label0:
        {
            if (Log.isLoggable("WearableLS", 3))
            {
                Log.d("WearableLS", (new StringBuilder("onMessageReceived: ")).append(af).toString());
            }
            WearableListenerService.b(alr);
            class _cls2
                implements Runnable
            {

                final WearableListenerService.a alt;
                final af alu;

                public void run()
                {
                    alt.alr.onMessageReceived(alu);
                }

            _cls2(af af)
            {
                alt = WearableListenerService.a.this;
                alu = af;
                super();
            }
            }

            synchronized (WearableListenerService.c(alr))
            {
                if (!WearableListenerService.d(alr))
                {
                    break label0;
                }
            }
            return;
        }
        WearableListenerService.e(alr).post(new _cls2(af));
        obj;
        JVM INSTR monitorexit ;
    }

    public void a(ai ai)
    {
label0:
        {
            if (Log.isLoggable("WearableLS", 3))
            {
                Log.d("WearableLS", (new StringBuilder("onPeerConnected: ")).append(WearableListenerService.a(alr)).append(": ").append(ai).toString());
            }
            WearableListenerService.b(alr);
            class _cls3
                implements Runnable
            {

                final WearableListenerService.a alt;
                final ai alv;

                public void run()
                {
                    alt.alr.onPeerConnected(alv);
                }

            _cls3(ai ai)
            {
                alt = WearableListenerService.a.this;
                alv = ai;
                super();
            }
            }

            synchronized (WearableListenerService.c(alr))
            {
                if (!WearableListenerService.d(alr))
                {
                    break label0;
                }
            }
            return;
        }
        WearableListenerService.e(alr).post(new _cls3(ai));
        obj;
        JVM INSTR monitorexit ;
    }

    public void b(ai ai)
    {
label0:
        {
            if (Log.isLoggable("WearableLS", 3))
            {
                Log.d("WearableLS", (new StringBuilder("onPeerDisconnected: ")).append(WearableListenerService.a(alr)).append(": ").append(ai).toString());
            }
            WearableListenerService.b(alr);
            class _cls4
                implements Runnable
            {

                final WearableListenerService.a alt;
                final ai alv;

                public void run()
                {
                    alt.alr.onPeerDisconnected(alv);
                }

            _cls4(ai ai)
            {
                alt = WearableListenerService.a.this;
                alv = ai;
                super();
            }
            }

            synchronized (WearableListenerService.c(alr))
            {
                if (!WearableListenerService.d(alr))
                {
                    break label0;
                }
            }
            return;
        }
        WearableListenerService.e(alr).post(new _cls4(ai));
        obj;
        JVM INSTR monitorexit ;
    }

    private _cls4(WearableListenerService wearablelistenerservice)
    {
        alr = wearablelistenerservice;
        super();
    }

    alr(WearableListenerService wearablelistenerservice, alr alr1)
    {
        this(wearablelistenerservice);
    }
}
