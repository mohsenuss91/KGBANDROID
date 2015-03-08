// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.text.ClipboardManager;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            MMJSResponse, BridgeMMPasteboard

class val.context
    implements Callable
{

    final BridgeMMPasteboard this$0;
    final Context val$context;

    public MMJSResponse call()
    {
        CharSequence charsequence = ((ClipboardManager)val$context.getSystemService("clipboard")).getText();
        if (charsequence == null) goto _L2; else goto _L1
_L1:
        String s = charsequence.toString();
_L4:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        MMJSResponse mmjsresponse = MMJSResponse.responseWithSuccess(s);
        return mmjsresponse;
        Exception exception;
        exception;
        exception.printStackTrace();
        return null;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile Object call()
    {
        return call();
    }

    ()
    {
        this$0 = final_bridgemmpasteboard;
        val$context = Context.this;
        super();
    }
}
