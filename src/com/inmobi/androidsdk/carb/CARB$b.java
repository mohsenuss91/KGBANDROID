// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.carb;

import android.content.SharedPreferences;
import com.inmobi.androidsdk.bootstrapper.PkInitilaizer;
import com.inmobi.androidsdk.bootstrapper.PkParams;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.Base64;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.uid.UID;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.androidsdk.carb:
//            CarbInitializer, CarbConfigParams, CARB, CarbInfo

class a
    implements Runnable
{

    final CARB a;

    private int a(String s)
    {
        if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
        {
            return -1;
        }
        URL url;
        HttpURLConnection httpurlconnection;
        url = new URL(CarbInitializer.getConfigParams().getCarbEndpoint());
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
        InetAddress.getByName(url.getHost());
        BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(httpurlconnection.getOutputStream()));
        bufferedwriter.write(s);
        bufferedwriter.close();
_L8:
        Log.internal("[InMobi]-[CARB]-4.4.1", (new StringBuilder("Get CARB list status: ")).append(httpurlconnection.getResponseCode()).toString());
        if (httpurlconnection.getResponseCode() != 200) goto _L2; else goto _L1
_L1:
        BufferedReader bufferedreader;
        StringBuilder stringbuilder;
        bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream(), "UTF-8"));
        stringbuilder = new StringBuilder();
_L5:
        String s1 = bufferedreader.readLine();
        if (s1 == null) goto _L4; else goto _L3
_L3:
        MalformedURLException malformedurlexception;
        stringbuilder.append(s1).append("\n");
          goto _L5
_L7:
        return -1;
        UnknownHostException unknownhostexception;
        unknownhostexception;
        Exception exception;
        BufferedWriter bufferedwriter1;
        IOException ioexception1;
        IOException ioexception2;
        String s2;
        String s3;
        String s4;
        JSONObject jsonobject;
        String s5;
        JSONArray jsonarray;
        int i;
        int j;
        JSONObject jsonobject2;
        JSONException jsonexception1;
        String s6;
        String s7;
        Exception exception1;
        int i1;
        try
        {
            throw new MalformedURLException((new StringBuilder("Malformed URL: ")).append(url.toString()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (MalformedURLException malformedurlexception)
        {
            Log.internal("[InMobi]-[CARB]-4.4.1", "Malformed URL");
        }
        catch (IOException ioexception) { }
        catch (JSONException jsonexception)
        {
            Log.internal("[InMobi]-[CARB]-4.4.1", "Invalid JSON response");
        }
        if (true) goto _L7; else goto _L6
_L6:
        ioexception2;
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Exception closing resource: ")).append(bufferedwriter).toString(), ioexception2);
          goto _L8
        exception;
        bufferedwriter1 = null;
_L17:
        if (bufferedwriter1 == null)
        {
            break MISSING_BLOCK_LABEL_356;
        }
        bufferedwriter1.close();
_L9:
        throw exception;
        ioexception1;
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Exception closing resource: ")).append(bufferedwriter1).toString(), ioexception1);
          goto _L9
_L4:
        s2 = stringbuilder.toString();
        Log.internal("[InMobi]-[CARB]-4.4.1", (new StringBuilder("RESPONSE: ")).append(s2).toString());
        s3 = new String(InternalSDKUtil.DeAe(Base64.decode(s2.getBytes(), 0), CARB.c(a), CARB.d(a)));
        s4 = s3;
_L16:
        if (s4 == null) goto _L11; else goto _L10
_L10:
        Log.internal("[InMobi]-[CARB]-4.4.1", (new StringBuilder("Get list after decryption: ")).append(s4).toString());
        jsonobject = new JSONObject(s4);
        if (!jsonobject.getBoolean("success")) goto _L13; else goto _L12
_L12:
        JSONObject jsonobject1 = jsonobject.getJSONObject("data");
        s5 = jsonobject1.getString("req_id");
        jsonobject1.getInt("count");
        jsonarray = jsonobject1.getJSONArray("p_apps");
        if (jsonarray.length() != 0) goto _L15; else goto _L14
_L14:
        android.content.references.Editor editor1 = CARB.a().edit();
        editor1.putLong(CARB.e(a), System.currentTimeMillis());
        editor1.commit();
        CARB.b(a);
        return -1;
        exception1;
        Log.internal("[InMobi]-[CARB]-4.4.1", "Exception in carb ", exception1);
        s4 = null;
          goto _L16
_L11:
        Log.internal("[InMobi]-[CARB]-4.4.1", "Unable to decrypt response or response not encrypted");
        CARB.b(a);
        return -1;
_L18:
        if (i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_749;
        }
        jsonobject2 = jsonarray.getJSONObject(i);
        s6 = jsonobject2.getString("bid");
        s7 = jsonobject2.getString("inm_id");
        if (s7 == null)
        {
            break MISSING_BLOCK_LABEL_849;
        }
        if (!"".equals(s7))
        {
            CarbInfo carbinfo = new CarbInfo();
            carbinfo.setBid(s6);
            carbinfo.setInmId(s7);
            if (!CARB.a(a, s6))
            {
                CARB.f(a).add(carbinfo);
            }
        }
        break MISSING_BLOCK_LABEL_849;
        jsonexception1;
        Log.internal("[InMobi]-[CARB]-4.4.1", "BID or INM missing");
        break MISSING_BLOCK_LABEL_849;
        android.content.references.Editor editor = CARB.a().edit();
        editor.putLong(CARB.e(a), System.currentTimeMillis());
        editor.commit();
        CARB.a(a, CARB.f(a), s5, j + 1);
_L13:
        CARB.b(a);
        return 200;
_L2:
        i1 = httpurlconnection.getResponseCode();
        return i1;
        exception;
        bufferedwriter1 = bufferedwriter;
          goto _L17
_L15:
        i = 0;
        j = 0;
          goto _L18
        int k = i + 1;
        j = i;
        i = k;
          goto _L18
    }

    private void a()
    {
        CARB.a(a);
        CARB.a(a, InternalSDKUtil.keag());
        a.c = PkInitilaizer.getConfigParams().getExponent();
        a.d = PkInitilaizer.getConfigParams().getModulus();
        a.e = PkInitilaizer.getConfigParams().getVersion();
        if (a.c.equals("") || a.d.equals("") || a.e.equals(""))
        {
            Log.internal("[InMobi]-[CARB]-4.4.1", "Exception retreiving Ad due to key problem");
            CARB.b(a);
        } else
        {
            String s = b();
            Log.internal("[InMobi]-[CARB]-4.4.1", (new StringBuilder("Unencrypted postbody :")).append(s).toString());
            String s1 = CARB.a(a, s, CARB.c(a), CARB.d(a), a.a, a.d, a.c);
            if (s1 == null)
            {
                CARB.b(a);
                return;
            }
            if (a(s1) != 200)
            {
                CARB.b(a);
                return;
            }
        }
    }

    private String b()
    {
        StringBuffer stringbuffer;
        stringbuffer = new StringBuffer();
        CARB.fillCarbInfo();
        stringbuffer.append("mk-siteid=");
        stringbuffer.append(CARB.getURLEncoded(InMobi.getAppId()));
        String s = (new StringBuilder("pr-SAND-")).append(InternalSDKUtil.getInMobiInternalVersion("4.4.1")).append("-20140613").toString();
        stringbuffer.append("&mk-version=");
        stringbuffer.append(CARB.getURLEncoded(s));
        String s1 = Integer.toString((new Random()).nextInt());
        String s2 = CarbInitializer.getConfigParams().getUID().getUidMapWitoutXOR(1, s1, null);
        stringbuffer.append("&u-id-map=");
        stringbuffer.append(CARB.getURLEncoded(s2));
        stringbuffer.append("&u-appbid=");
        stringbuffer.append(CARB.getURLEncoded(CARB.getAppBid()));
        stringbuffer.append("&u-appver=");
        stringbuffer.append(CARB.getURLEncoded(CARB.getAppVer()));
        stringbuffer.append("&h-user-agent=");
        stringbuffer.append(CARB.getURLEncoded(DeviceInfo.getPhoneDefaultUserAgent()));
        stringbuffer.append("&d-localization=");
        stringbuffer.append(CARB.getURLEncoded(DeviceInfo.getLocalization()));
        stringbuffer.append("&d-nettype=");
        stringbuffer.append(CARB.getURLEncoded(DeviceInfo.getNetworkType()));
        WifiInfo wifiinfo1 = IceDataCollector.getConnectedWifiInfo(InternalSDKUtil.getContext());
        WifiInfo wifiinfo = wifiinfo1;
_L2:
        if (wifiinfo != null)
        {
            stringbuffer.append("&c-ap-bssid=");
            stringbuffer.append(Long.toString(wifiinfo.bssid));
        }
        return stringbuffer.toString();
        Exception exception;
        exception;
        Log.internal("[InMobi]-4.4.1", "No wifi permissions set, unable to send wifi data");
        wifiinfo = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void run()
    {
        a();
    }

    fiInfo(CARB carb)
    {
        a = carb;
        super();
    }
}
