// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.util.HashMap;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMJSResponse

class BridgeMMInlineVideo extends MMJSObject
{

    BridgeMMInlineVideo()
    {
    }

    public MMJSResponse adjustVideo(final HashMap parameters)
    {
        return runOnUiThreadFuture(new _cls4());
    }

    public MMJSResponse insertVideo(final HashMap parameters)
    {
        return runOnUiThreadFuture(new _cls1());
    }

    public MMJSResponse pauseVideo(HashMap hashmap)
    {
        return runOnUiThreadFuture(new _cls6());
    }

    public MMJSResponse playVideo(HashMap hashmap)
    {
        return runOnUiThreadFuture(new _cls3());
    }

    public MMJSResponse removeVideo(HashMap hashmap)
    {
        return runOnUiThreadFuture(new _cls2());
    }

    public MMJSResponse resumeVideo(HashMap hashmap)
    {
        return runOnUiThreadFuture(new _cls7());
    }

    public MMJSResponse setStreamVideoSource(final HashMap parameters)
    {
        return runOnUiThreadFuture(new _cls8());
    }

    public MMJSResponse stopVideo(HashMap hashmap)
    {
        return runOnUiThreadFuture(new _cls5());
    }

    private class _cls4
        implements Callable
    {

        final BridgeMMInlineVideo this$0;
        final HashMap val$parameters;

        public MMJSResponse call()
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview != null && mmwebview != null && mmwebview.getMMLayout().adjustVideo(new InlineVideoView.InlineParams(parameters, mmwebview.getContext())))
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

        _cls4()
        {
            this$0 = BridgeMMInlineVideo.this;
            parameters = hashmap;
            super();
        }
    }


    private class _cls1
        implements Callable
    {

        final BridgeMMInlineVideo this$0;
        final HashMap val$parameters;

        public MMJSResponse call()
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview != null)
            {
                MMLayout mmlayout = mmwebview.getMMLayout();
                mmlayout.initInlineVideo(new InlineVideoView.InlineParams(parameters, mmwebview.getContext()));
                return MMJSResponse.responseWithSuccess((new StringBuilder("usingStreaming=")).append(mmlayout.isVideoPlayingStreaming()).toString());
            } else
            {
                return MMJSResponse.responseWithError();
            }
        }

        public volatile Object call()
        {
            return call();
        }

        _cls1()
        {
            this$0 = BridgeMMInlineVideo.this;
            parameters = hashmap;
            super();
        }
    }


    private class _cls6
        implements Callable
    {

        final BridgeMMInlineVideo this$0;

        public MMJSResponse call()
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview != null)
            {
                MMLayout mmlayout = mmwebview.getMMLayout();
                if (mmlayout != null)
                {
                    mmlayout.pauseVideo();
                    return MMJSResponse.responseWithSuccess();
                }
            }
            return MMJSResponse.responseWithError();
        }

        public volatile Object call()
        {
            return call();
        }

        _cls6()
        {
            this$0 = BridgeMMInlineVideo.this;
            super();
        }
    }


    private class _cls3
        implements Callable
    {

        final BridgeMMInlineVideo this$0;

        public MMJSResponse call()
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview != null)
            {
                MMLayout mmlayout = mmwebview.getMMLayout();
                if (mmlayout != null)
                {
                    mmlayout.playVideo();
                    return MMJSResponse.responseWithSuccess();
                }
            }
            return MMJSResponse.responseWithError();
        }

        public volatile Object call()
        {
            return call();
        }

        _cls3()
        {
            this$0 = BridgeMMInlineVideo.this;
            super();
        }
    }


    private class _cls2
        implements Callable
    {

        final BridgeMMInlineVideo this$0;

        public MMJSResponse call()
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview != null)
            {
                MMLayout mmlayout = mmwebview.getMMLayout();
                if (mmlayout != null)
                {
                    mmlayout.removeVideo();
                    return MMJSResponse.responseWithSuccess();
                }
            }
            return MMJSResponse.responseWithError();
        }

        public volatile Object call()
        {
            return call();
        }

        _cls2()
        {
            this$0 = BridgeMMInlineVideo.this;
            super();
        }
    }


    private class _cls7
        implements Callable
    {

        final BridgeMMInlineVideo this$0;

        public MMJSResponse call()
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview != null)
            {
                MMLayout mmlayout = mmwebview.getMMLayout();
                if (mmlayout != null)
                {
                    mmlayout.resumeVideo();
                    return MMJSResponse.responseWithSuccess();
                }
            }
            return MMJSResponse.responseWithError();
        }

        public volatile Object call()
        {
            return call();
        }

        _cls7()
        {
            this$0 = BridgeMMInlineVideo.this;
            super();
        }
    }


    private class _cls8
        implements Callable
    {

        final BridgeMMInlineVideo this$0;
        final HashMap val$parameters;

        public MMJSResponse call()
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview != null)
            {
                MMLayout mmlayout = mmwebview.getMMLayout();
                String s = (String)parameters.get("streamVideoURI");
                if (mmlayout != null && s != null)
                {
                    mmlayout.setVideoSource(s);
                    return MMJSResponse.responseWithSuccess();
                }
            }
            return MMJSResponse.responseWithError();
        }

        public volatile Object call()
        {
            return call();
        }

        _cls8()
        {
            this$0 = BridgeMMInlineVideo.this;
            parameters = hashmap;
            super();
        }
    }


    private class _cls5
        implements Callable
    {

        final BridgeMMInlineVideo this$0;

        public MMJSResponse call()
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview != null)
            {
                MMLayout mmlayout = mmwebview.getMMLayout();
                if (mmlayout != null)
                {
                    mmlayout.stopVideo();
                    return MMJSResponse.responseWithSuccess();
                }
            }
            return MMJSResponse.responseWithError();
        }

        public volatile Object call()
        {
            return call();
        }

        _cls5()
        {
            this$0 = BridgeMMInlineVideo.this;
            super();
        }
    }

}
