// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            BridgeMMInlineVideo, MMWebView, MMLayout, MMJSResponse

class val.parameters
    implements Callable
{

    final BridgeMMInlineVideo this$0;
    final HashMap val$parameters;

    public MMJSResponse call()
    {
        MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
        if (mmwebview != null && mmwebview != null && mmwebview.getMMLayout().adjustVideo(new Params(val$parameters, mmwebview.getContext())))
        {
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return MMJSResponse.responseWithError();
        }
    }

    public volatile Object call()
    {
        return call();
    }

    Params()
    {
        this$0 = final_bridgemminlinevideo;
        val$parameters = HashMap.this;
        super();
    }
}
