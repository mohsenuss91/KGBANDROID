// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


class s
{

    static void executeUrl(final String url)
    {
        class _cls1
            implements Runnable
        {

            final String val$url;

            public final void run()
            {
                try
                {
                    (new DefaultHttpClient()).execute(new HttpGet(url));
                    MMSDK.Log.d((new StringBuilder("Executed Url :\"")).append(url).append("\"").toString());
                    return;
                }
                catch (IOException ioexception)
                {
                    MMSDK.Log.e(ioexception);
                }
            }

            _cls1()
            {
                url = s;
                super();
            }
        }

        s.execute(new _cls1());
    }

    s()
    {
    }
}
