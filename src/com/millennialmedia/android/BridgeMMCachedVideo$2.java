// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            VideoPlayerActivity, MMJSResponse, BridgeMMCachedVideo

class val.vpa
    implements Callable
{

    final BridgeMMCachedVideo this$0;
    final VideoPlayerActivity val$vpa;

    public MMJSResponse call()
    {
        val$vpa.resumeVideo();
        return MMJSResponse.responseWithSuccess();
    }

    public volatile Object call()
    {
        return call();
    }

    ()
    {
        this$0 = final_bridgemmcachedvideo;
        val$vpa = VideoPlayerActivity.this;
        super();
    }
}
