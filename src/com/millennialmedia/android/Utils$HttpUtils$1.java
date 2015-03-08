// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

final class val.url
    implements Runnable
{

    final String val$url;

    public final void run()
    {
        try
        {
            (new DefaultHttpClient()).execute(new HttpGet(val$url));
            val.url((new StringBuilder("Executed Url :\"")).append(val$url).append("\"").toString());
            return;
        }
        catch (IOException ioexception)
        {
            val.url(ioexception);
        }
    }

    ()
    {
        val$url = s;
        super();
    }
}
