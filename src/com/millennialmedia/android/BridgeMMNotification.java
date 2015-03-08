// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import java.lang.ref.WeakReference;
import java.util.HashMap;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMJSResponse

class BridgeMMNotification extends MMJSObject
    implements android.content.DialogInterface.OnClickListener
{

    private int index;

    BridgeMMNotification()
    {
    }

    public MMJSResponse alert(final HashMap arguments)
    {
        this;
        JVM INSTR monitorenter ;
        MMJSResponse mmjsresponse = runOnUiThreadFuture(new _cls1());
        this;
        JVM INSTR monitorexit ;
        return mmjsresponse;
        Exception exception;
        exception;
        throw exception;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i != -2)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        index = 0;
        if (i != -3)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        index = 1;
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        index = 2;
        dialoginterface.cancel();
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public MMJSResponse vibrate(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        long l;
        if (hashmap.containsKey("duration"))
        {
            l = (long)(1000D * (double)Float.parseFloat((String)hashmap.get("duration")));
        } else
        {
            l = 0L;
        }
        if (context != null && l > 0L)
        {
            if (context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0)
            {
                ((Vibrator)context.getSystemService("vibrator")).vibrate(l);
                return MMJSResponse.responseWithSuccess((new StringBuilder("Vibrating for ")).append(l).toString());
            } else
            {
                return MMJSResponse.responseWithError("The required permissions to vibrate are not set.");
            }
        } else
        {
            return null;
        }
    }


    private class _cls1
        implements Callable
    {

        final BridgeMMNotification this$0;
        final HashMap val$arguments;

        public MMJSResponse call()
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview != null)
            {
                Activity activity = mmwebview.getActivity();
                HashMap hashmap = arguments;
                if (activity != null)
                {
                    if (!activity.isFinishing())
                    {
                        AlertDialog alertdialog = (new android.app.AlertDialog.Builder(activity)).create();
                        if (hashmap.containsKey("title"))
                        {
                            alertdialog.setTitle((CharSequence)hashmap.get("title"));
                        }
                        if (hashmap.containsKey("message"))
                        {
                            alertdialog.setMessage((CharSequence)hashmap.get("message"));
                        }
                        if (hashmap.containsKey("cancelButton"))
                        {
                            alertdialog.setButton(-2, (CharSequence)hashmap.get("cancelButton"), BridgeMMNotification.this);
                        }
                        if (hashmap.containsKey("buttons"))
                        {
                            String as[] = ((String)hashmap.get("buttons")).split(",");
                            if (as.length > 0)
                            {
                                alertdialog.setButton(-3, as[0], BridgeMMNotification.this);
                            }
                            if (as.length > 1)
                            {
                                alertdialog.setButton(-1, as[1], BridgeMMNotification.this);
                            }
                        }
                        alertdialog.show();
                    }
                    MMJSResponse mmjsresponse = new MMJSResponse();
                    mmjsresponse.result = 1;
                    mmjsresponse.response = Integer.valueOf(index);
                    return mmjsresponse;
                }
            }
            return null;
        }

        public volatile Object call()
        {
            return call();
        }

        _cls1()
        {
            this$0 = BridgeMMNotification.this;
            arguments = hashmap;
            super();
        }
    }

}
