// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.internal.hn;
import java.util.concurrent.LinkedBlockingDeque;

// Referenced classes of package com.google.android.gms.drive.events:
//            DriveEvent, ChangeEvent, FileConflictEvent

public abstract class DriveEventService extends IntentService
{

    private static final LinkedBlockingDeque Ie = new LinkedBlockingDeque();
    private final String mName;

    protected DriveEventService()
    {
        this("DriveEventService");
    }

    protected DriveEventService(String s)
    {
        super(s);
        mName = s;
    }

    private void a(DriveEvent driveevent)
    {
        driveevent.getType();
        JVM INSTR tableswitch 1 2: default 28
    //                   1 53
    //                   2 113;
           goto _L1 _L2 _L3
_L1:
        Log.w(mName, (new StringBuilder("Unrecognized event: ")).append(driveevent).toString());
        return;
_L2:
        try
        {
            hn.a(driveevent instanceof ChangeEvent, "Unexpected event type: %s", new Object[] {
                driveevent
            });
            onChangeEvent((ChangeEvent)driveevent);
            return;
        }
        catch (ClassCastException classcastexception)
        {
            Log.wtf(mName, (new StringBuilder("Service does not implement listener for type:")).append(driveevent.getType()).toString(), classcastexception);
            return;
        }
        catch (Exception exception)
        {
            Log.w(mName, (new StringBuilder("Error handling event: ")).append(driveevent).toString(), exception);
        }
        break; /* Loop/switch isn't completed */
_L3:
        hn.a(driveevent instanceof FileConflictEvent, "Unexpected event type: %s", new Object[] {
            driveevent
        });
        a((FileConflictEvent)driveevent);
        return;
    }

    static LinkedBlockingDeque gi()
    {
        return Ie;
    }

    public void a(FileConflictEvent fileconflictevent)
    {
        Log.w("DriveEventService", (new StringBuilder("Unhandled FileConflictEvent: ")).append(fileconflictevent).toString());
    }

    public IBinder onBind(Intent intent)
    {
        return new _cls1();
    }

    public void onChangeEvent(ChangeEvent changeevent)
    {
        Log.w("DriveEventService", (new StringBuilder("Unhandled ChangeEvent: ")).append(changeevent).toString());
    }

    protected final void onHandleIntent(Intent intent)
    {
        intent.setExtrasClassLoader(getClassLoader());
        DriveEvent driveevent = (DriveEvent)intent.getParcelableExtra("event");
        if (driveevent == null)
        {
            driveevent = (DriveEvent)Ie.poll();
        }
        if (driveevent != null)
        {
            a(driveevent);
            return;
        } else
        {
            Log.e("DriveEventService", "The event queue is unexpectedly empty.");
            return;
        }
    }


    private class _cls1 extends Binder
    {

        final DriveEventService If;

        protected boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        {
            Log.d("DriveEventService", "onTransact");
            DriveEvent driveevent = (DriveEvent)parcel.readParcelable(If.getClassLoader());
            DriveEventService.gi().add(driveevent);
            If.startService(new Intent(If, If.getClass()));
            return true;
        }

        _cls1()
        {
            If = DriveEventService.this;
            super();
        }
    }

}
