// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.util.List;
import java.util.Random;

// Referenced classes of package com.adsdk.sdk:
//            Gender

public class AdRequest
{

    private static final String REQUEST_TYPE_ANDROID = "android_app";
    private int adspaceHeight;
    private boolean adspaceStrict;
    private int adspaceWidth;
    private String androidAdId;
    private String androidID;
    private String androidIMEI;
    private String connectionType;
    private String deviceId;
    private String deviceId2;
    private Gender gender;
    private String headers;
    private String ipAddress;
    private boolean isVideoRequest;
    private List keywords;
    private double latitude;
    private String listAds;
    private double longitude;
    private String protocolVersion;
    private String publisherId;
    private String requestURL;
    private long timestamp;
    private int userAge;
    private String userAgent;
    private String userAgent2;
    private int videoMaxDuration;
    private int videoMinDuration;

    public AdRequest()
    {
        longitude = 0.0D;
        latitude = 0.0D;
        androidIMEI = "";
        androidID = "";
        androidAdId = "";
    }

    public int getAdspaceHeight()
    {
        return adspaceHeight;
    }

    public int getAdspaceWidth()
    {
        return adspaceWidth;
    }

    public String getAndroidAdId()
    {
        return androidAdId;
    }

    public String getAndroidID()
    {
        return androidID;
    }

    public String getAndroidIMEI()
    {
        return androidIMEI;
    }

    public String getAndroidVersion()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    public String getConnectionType()
    {
        return connectionType;
    }

    public String getDeviceId()
    {
        if (deviceId == null)
        {
            return "";
        } else
        {
            return deviceId;
        }
    }

    public String getDeviceId2()
    {
        return deviceId2;
    }

    public String getDeviceMode()
    {
        return Build.MODEL;
    }

    public String getHeaders()
    {
        if (headers == null)
        {
            return "";
        } else
        {
            return headers;
        }
    }

    public String getIpAddress()
    {
        if (ipAddress == null)
        {
            return "";
        } else
        {
            return ipAddress;
        }
    }

    public double getLatitude()
    {
        return latitude;
    }

    public String getListAds()
    {
        if (listAds != null)
        {
            return listAds;
        } else
        {
            return "";
        }
    }

    public double getLongitude()
    {
        return longitude;
    }

    public String getProtocolVersion()
    {
        if (protocolVersion == null)
        {
            return "5.2.0";
        } else
        {
            return protocolVersion;
        }
    }

    public String getPublisherId()
    {
        if (publisherId == null)
        {
            return "";
        } else
        {
            return publisherId;
        }
    }

    public String getRequestType()
    {
        return "android_app";
    }

    public String getRequestURL()
    {
        return requestURL;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public String getUserAgent()
    {
        if (userAgent == null)
        {
            return "";
        } else
        {
            return userAgent;
        }
    }

    public String getUserAgent2()
    {
        if (userAgent2 == null)
        {
            return "";
        } else
        {
            return userAgent2;
        }
    }

    public int getVideoMaxDuration()
    {
        return videoMaxDuration;
    }

    public int getVideoMinDuration()
    {
        return videoMinDuration;
    }

    public boolean isAdspaceStrict()
    {
        return adspaceStrict;
    }

    public boolean isVideoRequest()
    {
        return isVideoRequest;
    }

    public void setAdspaceHeight(int i)
    {
        adspaceHeight = i;
    }

    public void setAdspaceStrict(boolean flag)
    {
        adspaceStrict = flag;
    }

    public void setAdspaceWidth(int i)
    {
        adspaceWidth = i;
    }

    public void setAndroidAdId(String s)
    {
        androidAdId = s;
    }

    public void setAndroidID(String s)
    {
        androidID = s;
    }

    public void setAndroidIMEI(String s)
    {
        androidIMEI = s;
    }

    public void setConnectionType(String s)
    {
        connectionType = s;
    }

    public void setDeviceId(String s)
    {
        deviceId = s;
    }

    public void setDeviceId2(String s)
    {
        deviceId2 = s;
    }

    public void setGender(Gender gender1)
    {
        gender = gender1;
    }

    public void setHeaders(String s)
    {
        headers = s;
    }

    public void setIpAddress(String s)
    {
        ipAddress = s;
    }

    public void setKeywords(List list)
    {
        keywords = list;
    }

    public void setLatitude(double d)
    {
        latitude = d;
    }

    public void setListAds(String s)
    {
        listAds = s;
    }

    public void setLongitude(double d)
    {
        longitude = d;
    }

    public void setProtocolVersion(String s)
    {
        protocolVersion = s;
    }

    public void setPublisherId(String s)
    {
        publisherId = s;
    }

    public void setRequestURL(String s)
    {
        requestURL = s;
    }

    public void setTimestamp(long l)
    {
        timestamp = l;
    }

    public void setUserAge(int i)
    {
        userAge = i;
    }

    public void setUserAgent(String s)
    {
        userAgent = s;
    }

    public void setUserAgent2(String s)
    {
        userAgent2 = s;
    }

    public void setVideoMaxDuration(int i)
    {
        videoMaxDuration = i;
    }

    public void setVideoMinDuration(int i)
    {
        videoMinDuration = i;
    }

    public void setVideoRequest(boolean flag)
    {
        isVideoRequest = flag;
    }

    public String toString()
    {
        return toUri().toString();
    }

    public Uri toUri()
    {
        android.net.Uri.Builder builder = Uri.parse(getRequestURL()).buildUpon();
        int i = (new Random()).nextInt(50000);
        builder.appendQueryParameter("rt", getRequestType());
        builder.appendQueryParameter("v", getProtocolVersion());
        builder.appendQueryParameter("i", getIpAddress());
        builder.appendQueryParameter("u", getUserAgent());
        builder.appendQueryParameter("u2", getUserAgent2());
        builder.appendQueryParameter("s", getPublisherId());
        builder.appendQueryParameter("o", getDeviceId());
        builder.appendQueryParameter("o_androidimei", androidIMEI);
        builder.appendQueryParameter("o_androidid", androidID);
        builder.appendQueryParameter("o_andadvid", androidAdId);
        builder.appendQueryParameter("r_random", Integer.toString(i));
        builder.appendQueryParameter("o2", getDeviceId2());
        builder.appendQueryParameter("t", Long.toString(getTimestamp()));
        builder.appendQueryParameter("connection_type", getConnectionType());
        builder.appendQueryParameter("listads", getListAds());
        builder.appendQueryParameter("c_customevents", "1");
        builder.appendQueryParameter("c.mraid", "1");
        if (isVideoRequest)
        {
            builder.appendQueryParameter("r_type", "video");
            builder.appendQueryParameter("r_resp", "vast20");
            if (videoMaxDuration != 0)
            {
                builder.appendQueryParameter("v_dur_max", Integer.toString(videoMaxDuration));
            }
            if (videoMinDuration != 0)
            {
                builder.appendQueryParameter("v_dur_min", Integer.toString(videoMinDuration));
            }
        } else
        {
            builder.appendQueryParameter("r_type", "banner");
        }
        if (userAge != 0)
        {
            builder.appendQueryParameter("demo.age", Integer.toString(userAge));
        }
        if (gender != null)
        {
            builder.appendQueryParameter("demo.gender", gender.getServerParam());
        }
        if (keywords != null && !keywords.isEmpty())
        {
            builder.appendQueryParameter("demo.keywords", TextUtils.join(", ", keywords));
        }
        builder.appendQueryParameter("u_wv", getUserAgent());
        builder.appendQueryParameter("u_br", getUserAgent());
        if (longitude != 0.0D && latitude != 0.0D)
        {
            builder.appendQueryParameter("longitude", Double.toString(longitude));
            builder.appendQueryParameter("latitude", Double.toString(latitude));
        }
        if (adspaceHeight != 0 && adspaceWidth != 0)
        {
            if (adspaceStrict)
            {
                builder.appendQueryParameter("adspace.strict", "1");
            } else
            {
                builder.appendQueryParameter("adspace.strict", "0");
            }
            builder.appendQueryParameter("adspace.width", Integer.toString(adspaceWidth));
            builder.appendQueryParameter("adspace.height", Integer.toString(adspaceHeight));
        }
        return builder.build();
    }
}
