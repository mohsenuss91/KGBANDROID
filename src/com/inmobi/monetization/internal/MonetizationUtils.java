// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.view.View;
import com.inmobi.androidsdk.AdRequest;
import com.inmobi.commons.data.UserInfo;
import com.inmobi.commons.internal.ActivityRecognitionManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.internal.objects.LtvpRuleCache;
import java.util.HashMap;
import java.util.Map;

public class MonetizationUtils
{

    public MonetizationUtils()
    {
    }

    public static Map buildLtvpRequestMap(View view)
    {
        HashMap hashmap = new HashMap();
        String s = LtvpRuleCache.getInstance(InternalSDKUtil.getContext()).getLtvpRuleId();
        if (s != null)
        {
            hashmap.put("rule-id", s);
        }
        if (view != null)
        {
            hashmap.put("placement-size", (new StringBuilder()).append(view.getWidth()).append("x").append(view.getHeight()).toString());
        }
        int i = ActivityRecognitionManager.getDetectedActivity();
        if (i != -1)
        {
            hashmap.put("u-activity-type", (new StringBuilder()).append(i).toString());
        }
        return hashmap;
    }

    public static IMErrorCode getErrorCode(com.inmobi.androidsdk.AdRequest.ErrorCode errorcode)
    {
        switch (a.a[errorcode.ordinal()])
        {
        default:
            return IMErrorCode.INTERNAL_ERROR;

        case 1: // '\001'
            return IMErrorCode.INTERNAL_ERROR;

        case 2: // '\002'
            return IMErrorCode.INTERNAL_ERROR;

        case 3: // '\003'
            return IMErrorCode.INTERNAL_ERROR;

        case 4: // '\004'
            return IMErrorCode.INTERNAL_ERROR;

        case 5: // '\005'
            return IMErrorCode.INTERNAL_ERROR;

        case 6: // '\006'
            return IMErrorCode.INVALID_REQUEST;

        case 7: // '\007'
            return IMErrorCode.INVALID_REQUEST;

        case 8: // '\b'
            return IMErrorCode.NETWORK_ERROR;

        case 9: // '\t'
            return IMErrorCode.NO_FILL;
        }
    }

    public static void updateIMAdRequest(AdRequest adrequest)
    {
        UserInfo userinfo = UserInfo.getInstance();
        Integer integer = userinfo.getAge();
        if (integer != null)
        {
            adrequest.setAge(integer.intValue());
        }
        adrequest.setAreaCode(userinfo.getAreaCode());
        adrequest.setCurrentLocation(userinfo.getCurrentLocation());
        adrequest.setDateOfBirth(userinfo.getDateOfBirth());
        adrequest.setEducation(userinfo.getEducation());
        adrequest.setEthnicity(userinfo.getEthnicity());
        adrequest.setGender(userinfo.getGender());
        Integer integer1 = userinfo.getIncome();
        if (integer1 != null)
        {
            adrequest.setIncome(integer1.intValue());
        }
        adrequest.setInterests(userinfo.getInterests());
        adrequest.setLocationInquiryAllowed(userinfo.isLocationInquiryAllowed());
        adrequest.setLocationOfCityStateAndCountry(userinfo.getLocationWithCityStateCountry());
        adrequest.setPostalCode(userinfo.getPostalCode());
        adrequest.setSearchString(userinfo.getSearchString());
        adrequest.setHasChildren(userinfo.getHasChildren());
        adrequest.setLanguage(userinfo.getLanguage());
        adrequest.setMaritalStatus(userinfo.getMaritalStatus());
        adrequest.setSexualOrientation(userinfo.getSexualOrientation());
    }

    private class a
    {

        static final int a[];

        static 
        {
            a = new int[com.inmobi.androidsdk.AdRequest.ErrorCode.values().length];
            try
            {
                a[com.inmobi.androidsdk.AdRequest.ErrorCode.AD_CLICK_IN_PROGRESS.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                a[com.inmobi.androidsdk.AdRequest.ErrorCode.AD_DOWNLOAD_IN_PROGRESS.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[com.inmobi.androidsdk.AdRequest.ErrorCode.AD_FETCH_TIMEOUT.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[com.inmobi.androidsdk.AdRequest.ErrorCode.AD_RENDERING_TIMEOUT.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                a[com.inmobi.androidsdk.AdRequest.ErrorCode.INTERNAL_ERROR.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                a[com.inmobi.androidsdk.AdRequest.ErrorCode.INVALID_APP_ID.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                a[com.inmobi.androidsdk.AdRequest.ErrorCode.INVALID_REQUEST.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                a[com.inmobi.androidsdk.AdRequest.ErrorCode.NETWORK_ERROR.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                a[com.inmobi.androidsdk.AdRequest.ErrorCode.NO_FILL.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror8)
            {
                return;
            }
        }
    }

}
