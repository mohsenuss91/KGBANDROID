// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.text.ClipboardManager;
import java.util.HashMap;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            MMJSResponse, BridgeMMPasteboard

class val.arguments
    implements Callable
{

    final BridgeMMPasteboard this$0;
    final HashMap val$arguments;
    final Context val$context;

    public MMJSResponse call()
    {
        MMJSResponse mmjsresponse;
        try
        {
            ((ClipboardManager)val$context.getSystemService("clipboard")).setText((String)val$arguments.get("data"));
            mmjsresponse = MMJSResponse.responseWithSuccess();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return mmjsresponse;
    }

    public volatile Object call()
    {
        return call();
    }

    ()
    {
        this$0 = final_bridgemmpasteboard;
        val$context = context1;
        val$arguments = HashMap.this;
        super();
    }
}
