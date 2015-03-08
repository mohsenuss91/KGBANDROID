// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            BridgeMMNotification, MMWebView, MMJSResponse

class val.arguments
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
            HashMap hashmap = val$arguments;
            if (activity != null)
            {
                if (!activity.isFinishing())
                {
                    AlertDialog alertdialog = (new android.app.it>(activity)).ate();
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
                mmjsresponse.response = Integer.valueOf(BridgeMMNotification.access$000(BridgeMMNotification.this));
                return mmjsresponse;
            }
        }
        return null;
    }

    public volatile Object call()
    {
        return call();
    }

    ()
    {
        this$0 = final_bridgemmnotification;
        val$arguments = HashMap.this;
        super();
    }
}
