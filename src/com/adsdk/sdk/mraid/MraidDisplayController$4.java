// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.Handler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidDisplayController, HttpClientFactory, ResponseHeader, HttpResponses, 
//            Streams

class val.pictureStoragePath
    implements Runnable
{

    private MediaScannerConnection mediaScannerConnection;
    private InputStream pictureInputStream;
    private OutputStream pictureOutputStream;
    final MraidDisplayController this$0;
    private URI uri;
    private final File val$pictureStoragePath;
    private final String val$uriString;

    private void loadPictureIntoGalleryApp(String s)
    {
        PubMediaScannerConnectionClient pubmediascannerconnectionclient = new PubMediaScannerConnectionClient(MraidDisplayController.this, s, null, null);
        mediaScannerConnection = new MediaScannerConnection(MraidDisplayController.access$5(MraidDisplayController.this).getApplicationContext(), pubmediascannerconnectionclient);
        PubMediaScannerConnectionClient.access._mth1(pubmediascannerconnectionclient, mediaScannerConnection);
        mediaScannerConnection.connect();
    }

    public void run()
    {
        HttpResponse httpresponse;
        String s;
        uri = URI.create(val$uriString);
        httpresponse = HttpClientFactory.create().execute(new HttpGet(uri));
        pictureInputStream = httpresponse.getEntity().getContent();
        s = HttpResponses.extractHeader(httpresponse, ResponseHeader.LOCATION);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        uri = URI.create(s);
        String s1 = MraidDisplayController.access$6(MraidDisplayController.this, uri, httpresponse);
        File file = new File(val$pictureStoragePath, s1);
        String s2 = file.toString();
        pictureOutputStream = new FileOutputStream(file);
        Streams.copyContent(pictureInputStream, pictureOutputStream);
        loadPictureIntoGalleryApp(s2);
        Streams.closeStream(pictureInputStream);
        Streams.closeStream(pictureOutputStream);
        return;
        Exception exception1;
        exception1;
        class _cls1
            implements Runnable
        {

            final MraidDisplayController._cls4 this$1;

            public void run()
            {
                MraidDisplayController.access$7(this$0, "Image failed to download.");
                getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.STORE_PICTURE, "Error downloading and saving image file.");
                Log.d("MoPub", "Error downloading and saving image file.");
            }

            _cls1()
            {
                this$1 = MraidDisplayController._cls4.this;
                super();
            }
        }

        MraidDisplayController.access$2(MraidDisplayController.this).post(new _cls1());
        Streams.closeStream(pictureInputStream);
        Streams.closeStream(pictureOutputStream);
        return;
        Exception exception;
        exception;
        Streams.closeStream(pictureInputStream);
        Streams.closeStream(pictureOutputStream);
        throw exception;
    }


    _cls1()
    {
        this$0 = final_mraiddisplaycontroller;
        val$uriString = s;
        val$pictureStoragePath = File.this;
        super();
    }
}
