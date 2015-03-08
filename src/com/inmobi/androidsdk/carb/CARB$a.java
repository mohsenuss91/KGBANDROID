// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.carb;

import android.os.Handler;
import android.os.Looper;
import com.inmobi.androidsdk.bootstrapper.PkInitilaizer;
import com.inmobi.androidsdk.bootstrapper.PkParams;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;
import org.json.JSONArray;

// Referenced classes of package com.inmobi.androidsdk.carb:
//            CarbInitializer, CarbConfigParams, CARB, CarbInfo

class a
    implements Runnable
{

    int a;
    final ArrayList b;
    final String c;
    final int d;
    final CARB e;

    private int a(String s)
    {
        if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
        {
            return -1;
        }
        URL url;
        HttpURLConnection httpurlconnection;
        url = new URL(CarbInitializer.getConfigParams().getCarbPostpoint());
        httpurlconnection = (HttpURLConnection)url.openConnection();
        InternalSDKUtil.addCommonPropertiesToConnection(httpurlconnection);
        long l = 1000L * CarbInitializer.getConfigParams().getTimeoutInterval();
        httpurlconnection.setConnectTimeout((int)l);
        httpurlconnection.setReadTimeout((int)l);
        httpurlconnection.setRequestProperty("user-agent", DeviceInfo.getPhoneDefaultUserAgent());
        httpurlconnection.setUseCaches(false);
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setDoInput(true);
        httpurlconnection.setRequestMethod("POST");
        httpurlconnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
        httpurlconnection.setRequestProperty("Content-Length", Integer.toString(s.length()));
        BufferedWriter bufferedwriter;
        try
        {
            InetAddress.getByName(url.getHost());
        }
        catch (UnknownHostException unknownhostexception)
        {
            IOException ioexception2;
            try
            {
                throw new MalformedURLException((new StringBuilder("Malformed URL: ")).append(url.toString()).toString());
            }
            catch (MalformedURLException malformedurlexception)
            {
                Log.internal("[InMobi]-[CARB]-4.4.1", "Malformed URL");
            }
            catch (IOException ioexception) { }
            return -1;
        }
        bufferedwriter = new BufferedWriter(new OutputStreamWriter(httpurlconnection.getOutputStream()));
        bufferedwriter.write(s);
        bufferedwriter.close();
_L2:
        if (httpurlconnection.getResponseCode() == 200)
        {
            return 200;
        }
        break; /* Loop/switch isn't completed */
        ioexception2;
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Exception closing resource: ")).append(bufferedwriter).toString(), ioexception2);
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        BufferedWriter bufferedwriter1 = null;
_L5:
        if (bufferedwriter1 == null)
        {
            break MISSING_BLOCK_LABEL_268;
        }
        bufferedwriter1.close();
_L3:
        throw exception;
        IOException ioexception1;
        ioexception1;
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Exception closing resource: ")).append(bufferedwriter1).toString(), ioexception1);
          goto _L3
_L1:
        int i = httpurlconnection.getResponseCode();
        return i;
        exception;
        bufferedwriter1 = bufferedwriter;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private String a(ArrayList arraylist, String s, int i)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("req_id=");
        stringbuffer.append(CARB.getURLEncoded(s));
        JSONArray jsonarray = new JSONArray();
        int j = arraylist.size();
        for (int k = 0; k < j; k++)
        {
            jsonarray.put(((CarbInfo)arraylist.get(k)).getInmId());
        }

        stringbuffer.append("&p_a_apps=");
        stringbuffer.append(CARB.getURLEncoded(jsonarray.toString()));
        stringbuffer.append("&i_till=");
        stringbuffer.append(i);
        String s1 = Integer.toString((new Random()).nextInt());
        String s2 = CarbInitializer.getConfigParams().getUID().getUidMapWitoutXOR(1, s1, null);
        stringbuffer.append("&u-id-map=");
        stringbuffer.append(CARB.getURLEncoded(s2));
        return stringbuffer.toString();
    }

    public void run()
    {
        CARB.g(e);
        CARB.b(e, InternalSDKUtil.keag());
        e.c = PkInitilaizer.getConfigParams().getExponent();
        e.d = PkInitilaizer.getConfigParams().getModulus();
        e.e = PkInitilaizer.getConfigParams().getVersion();
        if (e.c.equals("") || e.d.equals("") || e.e.equals(""))
        {
            Log.internal("[InMobi]-[CARB]-4.4.1", "Exception retreiving Ad due to key problem");
            CARB.h(e);
            return;
        }
        String s = a(b, c, d);
        Log.internal("[InMobi]-[CARB]-4.4.1", (new StringBuilder("PostBody Before encryption: ")).append(s).toString());
        String s1 = CARB.a(e, s, CARB.i(e), CARB.j(e), e.b, e.d, e.c);
        if (s1 == null)
        {
            Log.internal("[InMobi]-[CARB]-4.4.1", "POST message cannot be encrypted");
            CARB.b(e);
            return;
        }
        int i = a(s1);
        Log.internal("[InMobi]-[CARB]-4.4.1", (new StringBuilder("Post Response to CARB server: ")).append(i).toString());
        if (200 == i)
        {
            if (e.f != null)
            {
                e.f.postSuccess();
            }
            CARB.h(e);
            return;
        }
        if (e.f != null)
        {
            e.f.postFailed();
        }
        int j = CarbInitializer.getConfigParams().getRetryCount();
        long l = 1000L * CarbInitializer.getConfigParams().getRetryInterval();
        if (a <= j)
        {
            try
            {
                Thread.sleep(l * (long)a);
            }
            catch (InterruptedException interruptedexception) { }
            Log.internal("[InMobi]-[CARB]-4.4.1", (new StringBuilder("POSt to carb failed. Retrying count: ")).append(a).toString());
            a = 1 + a;
            if (Looper.myLooper() == null)
            {
                Looper.prepare();
            }
            (new Handler()).postDelayed(this, 0L);
            Looper.loop();
            Looper.myLooper().quit();
            return;
        } else
        {
            a = 0;
            CARB.h(e);
            return;
        }
    }

    rbCallback(CARB carb, ArrayList arraylist, String s, int i)
    {
        e = carb;
        b = arraylist;
        c = s;
        d = i;
        super();
        a = 1;
    }
}
