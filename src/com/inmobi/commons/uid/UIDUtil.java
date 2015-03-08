// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.uid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.net.AnalyticsCommon;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.uid:
//            UIDHelper, UID

public class UIDUtil
{

    private static Random a = new Random();

    public UIDUtil()
    {
    }

    static String a(String s)
    {
        if (s == null)
        {
            return "";
        }
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new UnsupportedOperationException(unsupportedencodingexception);
        }
        return s1;
    }

    public static void bindToConnection(Map map, URLConnection urlconnection)
    {
        String s;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); urlconnection.addRequestProperty(s, (String)map.get(s)))
        {
            s = (String)iterator.next();
        }

    }

    public static void bindToEncodedJSON(Map map, JSONObject jsonobject)
    {
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            try
            {
                jsonobject.put(AnalyticsCommon.getURLEncoded(s), AnalyticsCommon.getURLEncoded((String)map.get(s)));
            }
            catch (JSONException jsonexception)
            {
                Log.internal("[InMobi]-4.4.1", (new StringBuilder("UIDUtil: Unable to bind to JSON for key ")).append(s).toString());
            }
        }

    }

    public static String bindToGetParam(Map map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Object aobj[];
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); stringbuilder.append(String.format("%s=%s", aobj)))
        {
            String s = (String)iterator.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            aobj = new Object[2];
            aobj[0] = a(s);
            aobj[1] = a((String)map.get(s));
        }

        return stringbuilder.toString();
    }

    public static void bindToJSON(Map map, JSONObject jsonobject)
    {
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            try
            {
                jsonobject.put(s, map.get(s));
            }
            catch (JSONException jsonexception)
            {
                Log.internal("[InMobi]-4.4.1", (new StringBuilder("UIDUtil: Unable to bind to JSON for key ")).append(s).toString());
            }
        }

    }

    public static String getEncryptedJSON(Map map)
    {
        JSONObject jsonobject = new JSONObject();
        bindToJSON(map, jsonobject);
        return UIDHelper.encryptRSA(jsonobject.toString());
    }

    public static String getEncryptedUid(String s)
    {
        return UID.getCommonsUid().getDefaultUidMap(1, s, null);
    }

    public static String getJSON(Map map)
    {
        JSONObject jsonobject = new JSONObject();
        bindToJSON(map, jsonobject);
        return jsonobject.toString();
    }

    public static Map getMap(Context context, UID uid)
    {
        Map map;
        String s;
        String s1;
        map = getUid(uid);
        s = context.getPackageName();
        s1 = "";
        String s3 = Integer.valueOf(context.getPackageManager().getPackageInfo(s, 0).versionCode).toString();
        s1 = s3;
_L2:
        map.put("u-appbid", s);
        map.put("u-appver", s1);
        String s2 = InMobi.getAppId();
        if (s2 == null)
        {
            s2 = "";
        }
        map.put("mk-siteid", s2);
        map.put("mk-version", (new StringBuilder("pr-SAND-")).append(InternalSDKUtil.getInMobiInternalVersion("4.4.1")).append("-20140613").toString());
        map.put("ua", InternalSDKUtil.getSavedUserAgent());
        return map;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.internal("[InMobi]-4.4.1", "Unable to get app version", namenotfoundexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Map getUid(UID uid)
    {
        HashMap hashmap = new HashMap();
        String s = Integer.toString(a.nextInt());
        hashmap.put("u-id-key", s);
        hashmap.put("u-key-ver", UIDHelper.getRSAKeyVersion());
        if (uid == null)
        {
            hashmap.put("u-id-map", UID.getCommonsUid().getDefaultUidMap(1, s, null));
            return hashmap;
        } else
        {
            hashmap.put("u-id-map", uid.getUidMap(1, s, null));
            return hashmap;
        }
    }

}
