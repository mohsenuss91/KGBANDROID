// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.bootstrapper.NativeConfigParams;
import com.inmobi.androidsdk.bootstrapper.PkInitilaizer;
import com.inmobi.androidsdk.bootstrapper.PkParams;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.Base64;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.internal.abstraction.INativeAdController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.monetization.internal:
//            NativeAdResponse, NativeAdRequest

public class NativeAdRequestTask
    implements Runnable
{

    byte a[];
    String b;
    String c;
    String d;
    private NativeAdRequest e;
    private INativeAdController f;
    private HttpURLConnection g;
    private final int h = 8;
    private final int i = 16;
    private byte j[];
    private byte k[];

    NativeAdRequestTask(NativeAdRequest nativeadrequest, INativeAdController inativeadcontroller)
    {
        b = "";
        c = "";
        d = "";
        e = nativeadrequest;
        f = inativeadcontroller;
    }

    private String a(String s, INativeAdController inativeadcontroller)
    {
        a();
        j = InternalSDKUtil.keag();
        b = PkInitilaizer.getConfigParams().getExponent();
        c = PkInitilaizer.getConfigParams().getModulus();
        d = PkInitilaizer.getConfigParams().getVersion();
        if (b.equals("") || c.equals("") || d.equals(""))
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Exception retreiving Ad due to key problem");
            return null;
        } else
        {
            String s1 = InternalSDKUtil.SeMeGe(s, j, k, a, c, b);
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("sm=");
            stringbuilder.append(s1);
            stringbuilder.append("&sn=");
            stringbuilder.append(d);
            String s2 = stringbuilder.toString();
            Log.debug("[InMobi]-[Network]-4.4.1", s2);
            return s2;
        }
    }

    private HttpURLConnection a(String s)
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
        a(httpurlconnection);
        return httpurlconnection;
    }

    private void a()
    {
        try
        {
            a = new byte[8];
            SecureRandom securerandom = new SecureRandom();
            securerandom.nextBytes(a);
            k = new byte[16];
            securerandom.nextBytes(k);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        IOException ioexception;
        ioexception;
        Log.debug("[InMobi]-[Network]-4.4.1", (new StringBuilder("Exception closing resource: ")).append(closeable).toString(), ioexception);
        return;
    }

    private static void a(HttpURLConnection httpurlconnection)
    {
        int l = Initializer.getConfigParams().getFetchTimeOut();
        httpurlconnection.setConnectTimeout(l);
        httpurlconnection.setReadTimeout(l);
        httpurlconnection.setRequestProperty("user-agent", DeviceInfo.getPhoneDefaultUserAgent());
        httpurlconnection.setUseCaches(false);
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setDoInput(true);
        httpurlconnection.setRequestMethod("POST");
        httpurlconnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
    }

    private void b()
    {
        int l;
        String s1;
        Log.debug("[InMobi]-[Network]-4.4.1", (new StringBuilder("Http Status Code: ")).append(g.getResponseCode()).toString());
        l = g.getResponseCode();
        String s = g.getHeaderField("im-id");
        Log.debug("[InMobi]-[Network]-4.4.1", (new StringBuilder("Im Id: ")).append(s).toString());
        s1 = g.getHeaderField("im-ec");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        Log.debug("[InMobi]-[Network]-4.4.1", (new StringBuilder("Sandbox error Id: ")).append(s1).toString());
        if (l != 200) goto _L2; else goto _L1
_L1:
        BufferedReader bufferedreader;
        StringBuilder stringbuilder;
        bufferedreader = new BufferedReader(new InputStreamReader(g.getInputStream(), "UTF-8"));
        stringbuilder = new StringBuilder();
_L3:
        String s2 = bufferedreader.readLine();
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        stringbuilder.append(s2);
          goto _L3
        Exception exception1;
        exception1;
        String s3;
        String s4;
        JSONArray jsonarray;
        try
        {
            g.disconnect();
            a(((Closeable) (null)));
            throw exception1;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Monetization]", "Failed to retrieve native ad", exception);
            if (f != null)
            {
                f.onAdRequestFailed(e, IMErrorCode.INTERNAL_ERROR);
            }
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            Log.internal("[InMobi]-[Monetization]", "Out of memory error received while retieving ad", outofmemoryerror);
            if (f != null)
            {
                f.onAdRequestFailed(e, IMErrorCode.INTERNAL_ERROR);
                return;
            }
        }
        return;
        s3 = stringbuilder.toString();
        s4 = new String(InternalSDKUtil.DeAe(Base64.decode(s3.getBytes(), 0), j, k));
_L10:
        if (s4 == null) goto _L5; else goto _L4
_L4:
        jsonarray = (new JSONObject(s4)).getJSONArray("ads");
        if (jsonarray == null) goto _L7; else goto _L6
_L6:
        if (jsonarray.length() != 0) goto _L9; else goto _L8
_L8:
        Log.debug("[InMobi]-[Network]-4.4.1", "Server returned No Fill ");
        if (f != null)
        {
            f.onAdRequestFailed(e, IMErrorCode.NO_FILL);
        }
_L7:
        g.disconnect();
        a(((Closeable) (null)));
        return;
        Exception exception3;
        exception3;
        exception3.printStackTrace();
        s4 = null;
          goto _L10
_L5:
        if (f == null) goto _L12; else goto _L11
_L11:
        f.onAdRequestFailed(e, IMErrorCode.INTERNAL_ERROR);
        g.disconnect();
        a(((Closeable) (null)));
        return;
_L9:
        ArrayList arraylist;
        int i1;
        int j1;
        arraylist = new ArrayList();
        i1 = jsonarray.length();
        j1 = Initializer.getConfigParams().getNativeSdkConfigParams().getmFetchLimit();
        int l1;
        int k1 = j1;
        l1 = 0;
        Exception exception2;
        JSONObject jsonobject;
        String s5;
        String s6;
        String s7;
        if (i1 <= k1)
        {
            k1 = i1;
            l1 = 0;
        }
_L16:
        if (l1 >= k1) goto _L14; else goto _L13
_L13:
        jsonobject = jsonarray.getJSONObject(l1);
        s5 = jsonobject.optString("pubContent");
        s6 = jsonobject.optString("contextCode");
        s7 = jsonobject.optString("namespace");
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_750;
        }
        if ("".equals(s5.trim()) || s6 == null)
        {
            break MISSING_BLOCK_LABEL_750;
        }
        if ("".equals(s6.trim()) || s7 == null)
        {
            break MISSING_BLOCK_LABEL_750;
        }
        if (!"".equals(s7.trim()))
        {
            arraylist.add(jsonobject.toString());
        }
        break MISSING_BLOCK_LABEL_750;
        exception2;
        Log.internal("[InMobi]-[Monetization]", "JSON Exception", exception2);
        break MISSING_BLOCK_LABEL_750;
_L14:
        if (f == null) goto _L7; else goto _L15
_L15:
        if (arraylist.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_631;
        }
        f.onAdRequestSucceded(e, new NativeAdResponse(arraylist));
          goto _L7
        Log.debug("[InMobi]-[Network]-4.4.1", "Server Error");
        f.onAdRequestFailed(e, IMErrorCode.INTERNAL_ERROR);
          goto _L7
_L2:
        if (l != 400)
        {
            break MISSING_BLOCK_LABEL_699;
        }
        Log.debug("[InMobi]-[Network]-4.4.1", "Invalid App Id.Please check the app Id in the adrequest is valid and in active state");
        if (f != null)
        {
            f.onAdRequestFailed(e, IMErrorCode.INVALID_REQUEST);
        }
          goto _L7
        Log.debug("[InMobi]-[Network]-4.4.1", "Server Error");
        if (f != null)
        {
            f.onAdRequestFailed(e, IMErrorCode.INTERNAL_ERROR);
        }
          goto _L7
_L12:
        s4 = s3;
          goto _L4
        l1++;
          goto _L16
    }

    private void b(String s)
    {
        g.setRequestProperty("Content-Length", Integer.toString(s.length()));
        BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(g.getOutputStream()));
        bufferedwriter.write(s);
        a(bufferedwriter);
        return;
        Exception exception;
        exception;
        bufferedwriter = null;
_L2:
        a(bufferedwriter);
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void run()
    {
        String s1;
        Log.internal("[InMobi]-[Network]-4.4.1", "Ad Serving URL: http://i.w.inmobi.com/showad.asm");
        String s = e.buildPostBody();
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Native Unencrypted Postbody")).append(s).toString());
        s1 = a(s, f);
        g = a("http://i.w.inmobi.com/showad.asm");
        if (s1 != null)
        {
            try
            {
                b(s1);
                b();
                return;
            }
            catch (Exception exception)
            {
                if (f != null)
                {
                    f.onAdRequestFailed(e, IMErrorCode.NETWORK_ERROR);
                }
                Log.debug("[InMobi]-[Monetization]", "Failed to get native ads", exception);
            }
            break MISSING_BLOCK_LABEL_130;
        }
        if (f != null)
        {
            f.onAdRequestFailed(e, IMErrorCode.INTERNAL_ERROR);
            return;
        }
    }
}
