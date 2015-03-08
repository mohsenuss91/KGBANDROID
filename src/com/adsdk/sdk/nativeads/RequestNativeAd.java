// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.RequestException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.adsdk.sdk.nativeads:
//            NativeAd, NativeAdRequest

public class RequestNativeAd
{

    public RequestNativeAd()
    {
    }

    private Bitmap loadBitmap(String s)
    {
        Bitmap bitmap;
        try
        {
            bitmap = BitmapFactory.decodeStream((new URL(s)).openStream());
        }
        catch (Exception exception)
        {
            Log.e("Decoding bitmap failed!");
            return null;
        }
        return bitmap;
    }

    protected NativeAd parse(InputStream inputstream)
    {
        NativeAd nativead = new NativeAd();
        BufferedReader bufferedreader;
        StringBuilder stringbuilder;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"), 8);
        stringbuilder = new StringBuilder();
_L14:
        String s = bufferedreader.readLine();
        if (s != null) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        JSONObject jsonobject1;
        Iterator iterator;
        JSONObject jsonobject2;
        Iterator iterator1;
        JSONArray jsonarray;
        int i;
        try
        {
            jsonobject = new JSONObject(stringbuilder.toString());
            jsonobject1 = jsonobject.optJSONObject("imageassets");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RequestException("Cannot parse Response", unsupportedencodingexception);
        }
        catch (IOException ioexception)
        {
            throw new RequestException("Cannot parse Response", ioexception);
        }
        catch (JSONException jsonexception)
        {
            throw new RequestException("Cannot parse Response", jsonexception);
        }
        if (jsonobject1 == null) goto _L4; else goto _L3
_L3:
        iterator = jsonobject1.keys();
_L10:
        if (iterator.hasNext()) goto _L5; else goto _L4
_L4:
        jsonobject2 = jsonobject.optJSONObject("textassets");
        if (jsonobject2 == null) goto _L7; else goto _L6
_L6:
        iterator1 = jsonobject2.keys();
_L11:
        if (iterator1.hasNext()) goto _L8; else goto _L7
_L7:
        nativead.setClickUrl(jsonobject.optString("click_url", null));
        jsonarray = jsonobject.optJSONArray("trackers");
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_421;
        }
        i = 0;
_L12:
        if (i >= jsonarray.length())
        {
            return nativead;
        }
          goto _L9
_L2:
        stringbuilder.append((new StringBuilder(String.valueOf(s))).append("\n").toString());
        continue; /* Loop/switch isn't completed */
_L5:
        NativeAd.ImageAsset imageasset = new NativeAd.ImageAsset();
        String s2 = (String)iterator.next();
        JSONObject jsonobject4 = jsonobject1.getJSONObject(s2);
        String s3 = jsonobject4.getString("url");
        imageasset.url = s3;
        imageasset.bitmap = loadBitmap(s3);
        imageasset.width = jsonobject4.getInt("width");
        imageasset.height = jsonobject4.getInt("height");
        nativead.addImageAsset(s2, imageasset);
          goto _L10
_L8:
        String s1 = (String)iterator1.next();
        nativead.addTextAsset(s1, jsonobject2.getString(s1));
          goto _L11
_L9:
        JSONObject jsonobject3 = jsonarray.optJSONObject(i);
        if (jsonobject3 == null)
        {
            break MISSING_BLOCK_LABEL_415;
        }
        NativeAd.Tracker tracker = new NativeAd.Tracker();
        tracker.type = jsonobject3.getString("type");
        tracker.url = jsonobject3.getString("url");
        nativead.getTrackers().add(tracker);
        i++;
          goto _L12
        return nativead;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public NativeAd sendRequest(NativeAdRequest nativeadrequest)
    {
        String s = nativeadrequest.toString();
        Log.d((new StringBuilder("Ad RequestPerform HTTP Get Url: ")).append(s).toString());
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        HttpConnectionParams.setSoTimeout(defaulthttpclient.getParams(), 10000);
        HttpConnectionParams.setConnectionTimeout(defaulthttpclient.getParams(), 10000);
        HttpProtocolParams.setUserAgent(defaulthttpclient.getParams(), nativeadrequest.getUserAgent());
        HttpGet httpget = new HttpGet(s);
        httpget.setHeader("User-Agent", System.getProperty("http.agent"));
        HttpResponse httpresponse;
        int i;
        try
        {
            httpresponse = defaulthttpclient.execute(httpget);
            i = httpresponse.getStatusLine().getStatusCode();
        }
        catch (RequestException requestexception)
        {
            throw requestexception;
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            throw new RequestException("Error in HTTP request", clientprotocolexception);
        }
        catch (IOException ioexception)
        {
            throw new RequestException("Error in HTTP request", ioexception);
        }
        catch (Throwable throwable)
        {
            throw new RequestException("Error in HTTP request", throwable);
        }
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        return parse(httpresponse.getEntity().getContent());
        throw new RequestException((new StringBuilder("Server Error. Response code:")).append(i).toString());
    }
}
