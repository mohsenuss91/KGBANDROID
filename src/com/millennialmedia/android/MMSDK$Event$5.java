// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMAdImpl, RequestListener, MMException

final class val.error
    implements Runnable
{

    final MMAdImpl val$adImpl;
    final MMException val$error;

    public final void run()
    {
        if (val$adImpl == null || val$adImpl.requestListener == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        val$adImpl.requestListener.requestFailed(val$adImpl.getCallingAd(), val$error);
        return;
        Exception exception;
        exception;
        val.error("Exception raised in your MMAdListener: ", new Object[] {
            exception
        });
        return;
    }

    r()
    {
        val$adImpl = mmadimpl;
        val$error = mmexception;
        super();
    }
}
