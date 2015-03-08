// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.net;

import com.inmobi.androidsdk.impl.SDKUtil;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class HttpRequestBuilder
{

    public HttpRequestBuilder()
    {
    }

    private static String a(UserInfo userinfo)
    {
label0:
        {
            String s;
            String s1;
            try
            {
                StringBuilder stringbuilder = new StringBuilder();
                if (userinfo.getScreenDensity() != null)
                {
                    stringbuilder.append("d-device-screen-density=").append(getURLEncoded(userinfo.getScreenDensity()));
                }
                if (userinfo.getScreenSize() != null)
                {
                    stringbuilder.append("&d-device-screen-size=").append(getURLEncoded(userinfo.getScreenSize()));
                }
                s = stringbuilder.toString();
                if (s.charAt(0) != '&')
                {
                    break label0;
                }
                s1 = s.substring(1);
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Couldn't build post string in IMHttpRequestBuilder", exception);
                return null;
            }
            s = s1;
        }
        return s;
    }

    private static String a(UserInfo userinfo, WifiInfo wifiinfo)
    {
        StringBuilder stringbuilder;
        Exception exception;
        String s;
        stringbuilder = new StringBuilder();
        if (userinfo.getPostalCode() != null)
        {
            stringbuilder.append("u-postalCode=");
            stringbuilder.append(getURLEncoded(userinfo.getPostalCode()));
        }
        if (SDKUtil.getQAMode())
        {
            stringbuilder.append("&mk-carrier=117.97.87.6");
            stringbuilder.append("&x-real-ip=117.97.87.6");
        }
        if (userinfo.getRequestParams() != null)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = userinfo.getRequestParams().entrySet().iterator(); iterator.hasNext(); stringbuilder.append("&").append(getURLEncoded(((String)entry.getKey()).toString())).append("=").append(getURLEncoded(((String)entry.getValue()).toString())))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
          goto _L1
_L3:
        return s;
_L1:
        if (userinfo.getAreaCode() != null)
        {
            stringbuilder.append("&u-areaCode=");
            stringbuilder.append(getURLEncoded(userinfo.getAreaCode()));
        }
        if (userinfo.getDateOfBirth() != null)
        {
            stringbuilder.append("&u-dateOfBirth=");
            stringbuilder.append(getURLEncoded(userinfo.getDateOfBirth()));
        }
        if (userinfo.getGender() != null)
        {
            stringbuilder.append("&u-gender=");
            stringbuilder.append(userinfo.getGender().toString().toLowerCase());
        }
        if (userinfo.getKeywords() != null)
        {
            stringbuilder.append("&p-keywords=");
            stringbuilder.append(getURLEncoded(userinfo.getKeywords()));
        }
        if (userinfo.getSearchString() != null)
        {
            stringbuilder.append("&p-type=");
            stringbuilder.append(getURLEncoded(userinfo.getSearchString()));
        }
        if (userinfo.getIncome() > 0)
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
        if (userinfo.getAge() > 0)
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
        Calendar calendar = Calendar.getInstance();
        System.currentTimeMillis();
        stringbuilder.append((new StringBuilder("&ts=")).append(calendar.getTimeInMillis()).toString());
        stringbuilder.append("&tz=").append(calendar.get(15) + calendar.get(16));
        if (wifiinfo == null)
        {
            break MISSING_BLOCK_LABEL_656;
        }
        stringbuilder.append((new StringBuilder("&c-ap-bssid=")).append(wifiinfo.bssid).toString());
        String s1 = CellUtil.getCurrentCellTower(InternalSDKUtil.getContext()).id;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_706;
        }
        if (!"".equals(s1))
        {
            stringbuilder.append((new StringBuilder("&c-sid=")).append(s1).toString());
        }
_L4:
        try
        {
            s = stringbuilder.toString();
            if (s.charAt(0) == '&')
            {
                return s.substring(1);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Couldn't build post string in IMHttpRequestBuilder", exception);
            s = null;
        }
        if (true) goto _L3; else goto _L2
_L2:
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[Network]-4.4.1", "Exception getting cell tower id", exception1);
          goto _L4
    }

    private static String b(UserInfo userinfo)
    {
        String s;
        try
        {
            StringBuilder stringbuilder = new StringBuilder();
            if (userinfo.getSiteId() != null)
            {
                stringbuilder.append("mk-siteid=");
                stringbuilder.append(getURLEncoded(userinfo.getSiteId()));
            }
            stringbuilder.append("&u-id-adt=");
            String s1;
            if (InternalSDKUtil.isLimitAdTrackingEnabled())
            {
                stringbuilder.append(1);
            } else
            {
                stringbuilder.append(0);
            }
            if (userinfo.getPlainUidMap() != null)
            {
                stringbuilder.append("&u-id-map=");
                stringbuilder.append(getURLEncoded(userinfo.getPlainUidMap()));
            }
            if (userinfo.getAid() != null)
            {
                stringbuilder.append("&aid=");
                stringbuilder.append(getURLEncoded(userinfo.getAid()));
            }
            stringbuilder.append("&mk-version=");
            s1 = (new StringBuilder("pr-SAND-")).append(InternalSDKUtil.getInMobiInternalVersion("4.4.1")).append("-20140613").toString();
            stringbuilder.append(getURLEncoded(s1));
            stringbuilder.append("&mk-rel-version=");
            stringbuilder.append(getURLEncoded(s1));
            stringbuilder.append("&format=imai");
            stringbuilder.append("&mk-ads=1");
            stringbuilder.append("&h-user-agent=");
            stringbuilder.append(getURLEncoded(userinfo.getPhoneDefaultUserAgent()));
            stringbuilder.append("&u-appbid=");
            stringbuilder.append(getURLEncoded(userinfo.getAppBId()));
            stringbuilder.append("&u-appDNM=");
            stringbuilder.append(getURLEncoded(userinfo.getAppDisplayName()));
            stringbuilder.append("&u-appver=");
            stringbuilder.append(getURLEncoded(userinfo.getAppVer()));
            stringbuilder.append("&d-localization=");
            stringbuilder.append(getURLEncoded(userinfo.getLocalization()));
            if (userinfo.getNetworkType() != null)
            {
                stringbuilder.append("&d-netType=");
                stringbuilder.append(getURLEncoded(userinfo.getNetworkType()));
            }
            if (userinfo.getOrientation() != 0)
            {
                stringbuilder.append("&d-orientation=");
                stringbuilder.append(userinfo.getOrientation());
            }
            stringbuilder.append("&mk-ad-slot=");
            stringbuilder.append(getURLEncoded(userinfo.getAdUnitSlot()));
            if (userinfo.getSlotId() != null)
            {
                stringbuilder.append("&mk-site-slotid=");
                stringbuilder.append(getURLEncoded(userinfo.getSlotId()));
            }
            if (userinfo.isValidGeoInfo())
            {
                stringbuilder.append("&u-latlong-accu=");
                stringbuilder.append(getURLEncoded(currentLocationStr(userinfo)));
                stringbuilder.append("&u-ll-ts=");
                stringbuilder.append(userinfo.getGeoTS());
            }
            if (userinfo.getRefTagKey() != null && userinfo.getRefTagValue() != null)
            {
                stringbuilder.append("&").append(getURLEncoded(userinfo.getRefTagKey())).append("=").append(getURLEncoded(userinfo.getRefTagValue()));
            }
            s = stringbuilder.toString();
            if (s.charAt(0) == '&')
            {
                return s.substring(1);
            }
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Couldn't build post string in IMHttpRequestBuilder", exception);
            s = null;
        }
        return s;
    }

    public static String buildPostBody(UserInfo userinfo, WifiInfo wifiinfo, RequestResponseManager.ActionType actiontype)
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s = a(userinfo, wifiinfo);
        if (RequestResponseManager.ActionType.AdRequest != actiontype) goto _L2; else goto _L1
_L1:
        stringbuffer.append("requestactivity=AdRequest");
_L4:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        if (!s.equalsIgnoreCase(""))
        {
            stringbuffer.append((new StringBuilder("&")).append(s).toString());
        }
        String s1 = a(userinfo);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        if (!"".equals(s1))
        {
            stringbuffer.append((new StringBuilder("&")).append(s1).toString());
        }
        String s2 = b(userinfo);
        if (s2 != null)
        {
            try
            {
                if (!"".equals(s2))
                {
                    stringbuffer.append((new StringBuilder("&")).append(s2).toString());
                }
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Exception occured in an ad request")).append(exception).toString());
            }
        }
        return stringbuffer.toString();
_L2:
        if (RequestResponseManager.ActionType.AdRequest_Interstitial != actiontype) goto _L4; else goto _L3
_L3:
        stringbuffer.append("adtype=int");
          goto _L4
    }

    public static String currentLocationStr(UserInfo userinfo)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (userinfo.isValidGeoInfo())
        {
            stringbuilder.append(userinfo.getLat());
            stringbuilder.append(",");
            stringbuilder.append(userinfo.getLon());
            stringbuilder.append(",");
            stringbuilder.append((int)userinfo.getLocAccuracy());
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
}
