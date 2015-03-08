// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;

import android.net.Uri;
import android.text.TextUtils;
import com.adsdk.sdk.Gender;
import java.util.List;
import java.util.Random;

public class NativeAdRequest
{

    private static final String IMAGE_TYPES = "icon,main";
    private static final String REQUEST_TYPE = "native";
    private static final String REQUEST_TYPE_ANDROID = "android_app";
    private static final String RESPONSE_TYPE = "json";
    private static final String TEXT_TYPES = "headline,description,cta,advertiser,rating";
    private List adTypes;
    private String androidAdId;
    private String androidID;
    private String androidIMEI;
    private Gender gender;
    private List keywords;
    private double latitude;
    private double longitude;
    private String protocolVersion;
    private String publisherId;
    private String request_url;
    private int userAge;
    private String userAgent;
    private String userAgent2;

    public NativeAdRequest()
    {
        androidIMEI = "";
        androidID = "";
        androidAdId = "";
        longitude = 0.0D;
        latitude = 0.0D;
    }

    public List getAdTypes()
    {
        return adTypes;
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

    public Gender getGender()
    {
        return gender;
    }

    public List getKeywords()
    {
        return keywords;
    }

    public double getLatitude()
    {
        return latitude;
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
        return publisherId;
    }

    public int getUserAge()
    {
        return userAge;
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

    public void setAdTypes(List list)
    {
        adTypes = list;
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

    public void setGender(Gender gender1)
    {
        gender = gender1;
    }

    public void setKeywords(List list)
    {
        keywords = list;
    }

    public void setLatitude(double d)
    {
        latitude = d;
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

    public void setRequestUrl(String s)
    {
        request_url = s;
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

    public String toString()
    {
        return toUri().toString();
    }

    public Uri toUri()
    {
        android.net.Uri.Builder builder = Uri.parse(request_url).buildUpon();
        int i = (new Random()).nextInt(50000);
        builder.appendQueryParameter("rt", "android_app");
        builder.appendQueryParameter("r_type", "native");
        builder.appendQueryParameter("r_resp", "json");
        builder.appendQueryParameter("n_img", "icon,main");
        builder.appendQueryParameter("n_txt", "headline,description,cta,advertiser,rating");
        if (adTypes != null && !adTypes.isEmpty())
        {
            builder.appendQueryParameter("n_type", TextUtils.join(", ", adTypes));
        }
        builder.appendQueryParameter("s", getPublisherId());
        builder.appendQueryParameter("u", getUserAgent());
        builder.appendQueryParameter("u2", getUserAgent2());
        builder.appendQueryParameter("r_random", Integer.toString(i));
        builder.appendQueryParameter("o_androidid", androidID);
        builder.appendQueryParameter("o_androidimei", androidIMEI);
        builder.appendQueryParameter("o_andadvid", androidAdId);
        builder.appendQueryParameter("v", getProtocolVersion());
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
        return builder.build();
    }
}
