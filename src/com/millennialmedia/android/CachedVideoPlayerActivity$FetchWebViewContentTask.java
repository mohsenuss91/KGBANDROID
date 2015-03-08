// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.AsyncTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

// Referenced classes of package com.millennialmedia.android:
//            HttpGetRequest, CachedVideoPlayerActivity, MMWebView

class baseUrl extends AsyncTask
{

    private String baseUrl;
    private boolean cancelVideo;
    final CachedVideoPlayerActivity this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        HttpResponse httpresponse;
        StatusLine statusline;
        httpresponse = (new HttpGetRequest()).get(baseUrl);
        statusline = httpresponse.getStatusLine();
        if (httpresponse == null || statusline == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        HttpEntity httpentity;
        if (statusline.getStatusCode() == 404)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        httpentity = httpresponse.getEntity();
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        return HttpGetRequest.convertStreamToString(httpentity.getContent());
        cancelVideo = true;
_L2:
        return null;
        Exception exception;
        exception;
        exception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        if (cancelVideo)
        {
            dismiss();
        }
        if (s != null)
        {
            CachedVideoPlayerActivity.access$100(CachedVideoPlayerActivity.this).setWebViewContent(s, baseUrl, activity);
            hasLoadedCompletionUrl = true;
        }
    }

    public (String s)
    {
        this$0 = CachedVideoPlayerActivity.this;
        super();
        baseUrl = s;
    }
}
