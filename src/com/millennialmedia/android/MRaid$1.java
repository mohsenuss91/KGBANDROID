// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.millennialmedia.android:
//            MRaid

final class val.context
    implements Runnable
{

    final Context val$context;
    final String val$url;

    public final void run()
    {
        HttpGet httpget = new HttpGet(val$url);
        HttpResponse httpresponse = (new DefaultHttpClient()).execute(httpget);
        if (MRaid.saveMRaid(val$context, httpresponse.getEntity().getContent()))
        {
            MRaid.storeMraidUrl(val$context, val$url);
        }
        return;
        MalformedURLException malformedurlexception;
        malformedurlexception;
        malformedurlexception.printStackTrace();
        return;
        Exception exception;
        exception;
        throw exception;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        illegalstateexception.printStackTrace();
        return;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        return;
    }

    ttpClient()
    {
        val$url = s;
        val$context = context1;
        super();
    }
}
