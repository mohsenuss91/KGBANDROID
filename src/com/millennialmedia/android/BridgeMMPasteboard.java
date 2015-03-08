// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMJSResponse

class BridgeMMPasteboard extends MMJSObject
{

    BridgeMMPasteboard()
    {
    }

    public MMJSResponse getPasteboardContents(HashMap hashmap)
    {
        final Context context = (Context)contextRef.get();
        if (context != null)
        {
            return runOnUiThreadFuture(new _cls1());
        } else
        {
            return null;
        }
    }

    public MMJSResponse writeToPasteboard(final HashMap arguments)
    {
        final Context context = (Context)contextRef.get();
        if (context != null)
        {
            return runOnUiThreadFuture(new _cls2());
        } else
        {
            return null;
        }
    }

    private class _cls1
        implements Callable
    {

        final BridgeMMPasteboard this$0;
        final Context val$context;

        public MMJSResponse call()
        {
            CharSequence charsequence = ((ClipboardManager)context.getSystemService("clipboard")).getText();
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

        _cls1()
        {
            this$0 = BridgeMMPasteboard.this;
            context = context1;
            super();
        }
    }


    private class _cls2
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
                ((ClipboardManager)context.getSystemService("clipboard")).setText((String)arguments.get("data"));
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

        _cls2()
        {
            this$0 = BridgeMMPasteboard.this;
            context = context1;
            arguments = hashmap;
            super();
        }
    }

}
