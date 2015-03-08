// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMAdImpl, RequestListener

final class val.adImpl
    implements Runnable
{

    final MMAdImpl val$adImpl;

    public final void run()
    {
        if (val$adImpl == null || val$adImpl.requestListener == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        val$adImpl.requestListener.requestCompleted(val$adImpl.getCallingAd());
        return;
        Exception exception;
        exception;
        llingAd("Exception raised in your MMAdListener: ", new Object[] {
            exception
        });
        return;
    }

    r()
    {
        val$adImpl = mmadimpl;
        super();
    }
}
