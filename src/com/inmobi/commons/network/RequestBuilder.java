// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.network;

import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.data.AppInfo;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.data.LocationInfo;
import com.inmobi.commons.data.UserInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.uid.UID;
import com.inmobi.commons.uid.UIDHelper;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RequestBuilder
{

    public RequestBuilder()
    {
    }

    private String a(Calendar calendar)
    {
        String s = null;
        if (calendar != null)
        {
            s = (new StringBuilder()).append(calendar.get(1)).append("-").append(1 + calendar.get(2)).append("-").append(calendar.get(5)).toString();
        }
        return s;
    }

    public static String currentLocationStr()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (LocationInfo.isValidGeoInfo())
        {
            stringbuilder.append(LocationInfo.getLat());
            stringbuilder.append(",");
            stringbuilder.append(LocationInfo.getLon());
            stringbuilder.append(",");
            stringbuilder.append((int)LocationInfo.getLocAccuracy());
            return stringbuilder.toString();
        } else
        {
            return "";
        }
    }

    public static String getURLDecoded(String s, String s1)
    {
        String s2;
        try
        {
            s2 = URLDecoder.decode(s, s1);
        }
        catch (Exception exception)
        {
            return "";
        }
        return s2;
    }

    public static String getURLEncoded(String s)
    {
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8");
        }
        catch (Exception exception)
        {
            return "";
        }
        return s1;
    }

    public String buildPostBody()
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        s = getSDKDelegatePostBody();
        s1 = getDevicePostBody();
        s2 = getApplicationPostBody();
        s3 = getPublisherPostBody();
        s4 = getAdFormatPostBody();
        s5 = getUidMapPostBody();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        if (!"".equals(s.trim()))
        {
            stringbuffer.append(s);
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if ("".equals(s1.trim()))
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (!"".equals(s.trim()))
        {
            break MISSING_BLOCK_LABEL_271;
        }
        stringbuffer.append(s1);
_L1:
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        if (!"".equals(s2.trim()))
        {
            stringbuffer.append((new StringBuilder("&")).append(s2).toString());
        }
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        if (!"".equals(s3.trim()))
        {
            stringbuffer.append((new StringBuilder("&")).append(s3).toString());
        }
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        if (!"".equals(s4.trim()))
        {
            stringbuffer.append((new StringBuilder("&")).append(s4).toString());
        }
        if (s5 != null)
        {
            try
            {
                if (!"".equals(s5.trim()))
                {
                    stringbuffer.append((new StringBuilder("&")).append(s5).toString());
                }
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-4.4.1", (new StringBuilder("Exception occured in an ad request")).append(exception).toString());
            }
        }
        return stringbuffer.toString();
        stringbuffer.append((new StringBuilder("&")).append(s1).toString());
          goto _L1
    }

    public String getAdFormatPostBody()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("format=imai");
        stringbuilder.append("&mk-ads=1");
        return stringbuilder.toString();
    }

    public String getApplicationPostBody()
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        if (AppInfo.getAppId() == null)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        stringbuilder.append("mk-siteid=");
        stringbuilder.append(getURLEncoded(AppInfo.getAppId()));
_L1:
        String s1;
        stringbuilder.append("&mk-version=");
        String s = (new StringBuilder("pr-SAND-")).append(InternalSDKUtil.getInMobiInternalVersion("4.4.1")).append("-20140613").toString();
        stringbuilder.append(getURLEncoded(s));
        stringbuilder.append("&mk-rel-version=");
        stringbuilder.append(getURLEncoded(s));
        stringbuilder.append("&h-user-agent=");
        stringbuilder.append(getURLEncoded(DeviceInfo.getPhoneDefaultUserAgent()));
        stringbuilder.append("&u-appbid=");
        stringbuilder.append(getURLEncoded(AppInfo.getAppBId()));
        stringbuilder.append("&u-appDNM=");
        stringbuilder.append(getURLEncoded(AppInfo.getAppDisplayName()));
        stringbuilder.append("&u-appver=");
        stringbuilder.append(getURLEncoded(AppInfo.getAppVer()));
        s1 = stringbuilder.toString();
        String s2 = s1;
        String s3;
        if (s2.charAt(0) != '&')
        {
            break MISSING_BLOCK_LABEL_198;
        }
        s3 = s2.substring(1);
        s2 = s3;
        return s2;
        try
        {
            stringbuilder.append("mk-siteid=");
            stringbuilder.append(getURLEncoded(InMobi.getAppId()));
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Couldn't build post string in Request Builder", exception);
            return null;
        }
          goto _L1
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Couldn't build post string in Request Builder", exception1);
        return s2;
    }

    public String getDevicePostBody()
    {
        StringBuilder stringbuilder;
        Exception exception1;
        WifiInfo wifiinfo;
        Exception exception2;
        String s;
        String s1;
        String s2;
        String s3;
        WifiInfo wifiinfo1;
        try
        {
            stringbuilder = new StringBuilder();
            if (DeviceInfo.getScreenDensity() != null)
            {
                stringbuilder.append("d-device-screen-density=").append(getURLEncoded(DeviceInfo.getScreenDensity()));
            }
            if (DeviceInfo.getScreenSize() != null)
            {
                stringbuilder.append("&d-device-screen-size=").append(getURLEncoded(DeviceInfo.getScreenSize()));
            }
            if (DeviceInfo.getOrientation() != 0)
            {
                stringbuilder.append("&d-orientation=");
                stringbuilder.append(DeviceInfo.getOrientation());
            }
            if (DeviceInfo.getAid() != null)
            {
                stringbuilder.append("&aid=");
                stringbuilder.append(getURLEncoded(DeviceInfo.getAid()));
            }
            if (DeviceInfo.getNetworkType() != null)
            {
                stringbuilder.append("&d-netType=");
                stringbuilder.append(getURLEncoded(DeviceInfo.getNetworkType()));
            }
            stringbuilder.append("&d-localization=");
            stringbuilder.append(getURLEncoded(DeviceInfo.getLocalization()));
            Calendar calendar = Calendar.getInstance();
            System.currentTimeMillis();
            stringbuilder.append((new StringBuilder("&ts=")).append(calendar.getTimeInMillis()).toString());
            stringbuilder.append("&tz=").append(calendar.get(15) + calendar.get(16));
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Couldn't build post string in Request Builder", exception);
            return null;
        }
        wifiinfo1 = IceDataCollector.getConnectedWifiInfo(InternalSDKUtil.getContext());
        wifiinfo = wifiinfo1;
_L4:
        if (wifiinfo == null)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        stringbuilder.append((new StringBuilder("&c-ap-bssid=")).append(wifiinfo.bssid).toString());
        s3 = CellUtil.getCurrentCellTower(InternalSDKUtil.getContext()).id;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_290;
        }
        if (!"".equals(s3))
        {
            stringbuilder.append((new StringBuilder("&c-sid=")).append(s3).toString());
        }
_L2:
        s = stringbuilder.toString();
        s1 = s;
        if (s1.charAt(0) != '&')
        {
            break MISSING_BLOCK_LABEL_323;
        }
        s2 = s1.substring(1);
        s1 = s2;
        return s1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "No wifi permissions set, unable to send wifi data");
        wifiinfo = null;
        continue; /* Loop/switch isn't completed */
        exception2;
        Log.internal("[InMobi]-4.4.1", "Couldn't get cell tower info in Request Builder", exception2);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception3;
        exception3;
        Log.internal("[InMobi]-4.4.1", "Couldn't build post string in Request Builder", exception3);
        return s1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected String getPublisherPostBody()
    {
        return null;
    }

    public String getSDKDelegatePostBody()
    {
        StringBuilder stringbuilder;
        UserInfo userinfo;
        String s;
        String s1;
        String s2;
        Exception exception1;
        String s3;
        try
        {
            stringbuilder = new StringBuilder();
            userinfo = UserInfo.getInstance();
            if (userinfo.getPostalCode() != null)
            {
                stringbuilder.append("u-postalCode=");
                stringbuilder.append(getURLEncoded(userinfo.getPostalCode()));
            }
            if (userinfo.getAreaCode() != null)
            {
                stringbuilder.append("&u-areaCode=");
                stringbuilder.append(getURLEncoded(userinfo.getAreaCode()));
            }
            s = a(userinfo.getDateOfBirth());
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Couldn't build post string in Request Builder", exception);
            return null;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        stringbuilder.append("&u-dateOfBirth=");
        stringbuilder.append(getURLEncoded(s));
        if (userinfo.getGender() != null)
        {
            stringbuilder.append("&u-gender=");
            stringbuilder.append(userinfo.getGender().toString().toLowerCase());
        }
        if (userinfo.getSearchString() != null)
        {
            stringbuilder.append("&p-type=");
            stringbuilder.append(getURLEncoded(userinfo.getSearchString()));
        }
        if (userinfo.getIncome().intValue() > 0)
        {
            stringbuilder.append("&u-income=");
            stringbuilder.append(userinfo.getIncome());
        }
        if (userinfo.getEducation() != null)
        {
            stringbuilder.append("&u-education=");
            stringbuilder.append(userinfo.getEducation().toString().toLowerCase());
        }
        if (userinfo.getEthnicity() != null)
        {
            stringbuilder.append("&u-ethnicity=");
            stringbuilder.append(userinfo.getEthnicity().toString().toLowerCase());
        }
        if (userinfo.getAge().intValue() > 0)
        {
            stringbuilder.append("&u-age=");
            stringbuilder.append(userinfo.getAge());
        }
        if (userinfo.getInterests() != null)
        {
            stringbuilder.append("&u-interests=");
            stringbuilder.append(getURLEncoded(userinfo.getInterests()));
        }
        if (userinfo.getLocationWithCityStateCountry() != null)
        {
            stringbuilder.append("&u-location=");
            stringbuilder.append(getURLEncoded(userinfo.getLocationWithCityStateCountry()));
        }
        if (userinfo.getMaritalStatus() != null)
        {
            stringbuilder.append("&u-marital=");
            stringbuilder.append(userinfo.getMaritalStatus().toString().toLowerCase());
        }
        if (userinfo.getHasChildren() != null)
        {
            stringbuilder.append("&u-haschildren=");
            stringbuilder.append(userinfo.getHasChildren().toString().toLowerCase());
        }
        if (userinfo.getLanguage() != null)
        {
            stringbuilder.append("&u-language=");
            stringbuilder.append(getURLEncoded(userinfo.getLanguage()));
        }
        if (userinfo.getSexualOrientation() != null)
        {
            stringbuilder.append("&u-sexualorientation=");
            stringbuilder.append(userinfo.getSexualOrientation().toString().toLowerCase());
        }
        if (LocationInfo.isValidGeoInfo())
        {
            stringbuilder.append("&u-latlong-accu=");
            stringbuilder.append(getURLEncoded(currentLocationStr()));
            stringbuilder.append("&u-ll-ts=");
            stringbuilder.append(LocationInfo.getGeoTS());
        }
        s1 = stringbuilder.toString();
        s2 = s1;
        if (s2.charAt(0) != '&')
        {
            break MISSING_BLOCK_LABEL_515;
        }
        s3 = s2.substring(1);
        s2 = s3;
        return s2;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Couldn't build post string in Request Builder", exception1);
        return s2;
    }

    public String getUidMapPostBody()
    {
        HashMap hashmap = new HashMap();
        Long long2 = AnalyticsInitializer.getConfigParams().getLTVId();
        Long long1 = long2;
_L1:
label0:
        {
            if (long1 != null)
            {
                hashmap.put("LTVID", (new StringBuilder()).append(long1).toString());
            }
            String s = Integer.toString((new Random()).nextInt());
            String s1 = UID.getCommonsUid().getUidMap(UserInfo.getInstance().getDeviceIDMask(), s, hashmap);
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("u-id-adt=");
            Exception exception;
            String s2;
            String s3;
            if (InternalSDKUtil.isLimitAdTrackingEnabled())
            {
                stringbuilder.append(1);
            } else
            {
                stringbuilder.append(0);
            }
            s2 = null;
            if (s1 == null)
            {
                break label0;
            }
            stringbuilder.append("&u-id-map=");
            stringbuilder.append(getURLEncoded(s1));
            stringbuilder.append("&u-id-key=");
            stringbuilder.append(s);
            stringbuilder.append("&u-key-ver=");
            stringbuilder.append(UIDHelper.getRSAKeyVersion());
            s2 = stringbuilder.toString();
            try
            {
                if (s2.charAt(0) != '&')
                {
                    break label0;
                }
                s3 = s2.substring(1);
            }
            catch (Exception exception1)
            {
                Log.internal("[InMobi]-4.4.1", "Couldn't build post string in Request Builder", exception1);
                return s2;
            }
            s2 = s3;
        }
        return s2;
        exception;
        Log.internal("[InMobi]-4.4.1", "LTVID not available yet in configs");
        long1 = null;
          goto _L1
    }
}
