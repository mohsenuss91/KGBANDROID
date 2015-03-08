// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.data;

import android.content.Context;
import android.location.Location;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.IMIDType;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.commons.data:
//            DeviceInfo, AppInfo, LocationInfo

public final class UserInfo
{

    private static UserInfo a = new UserInfo();
    private static int c = 1;
    private boolean b;
    private Location d;
    private boolean e;
    private String f;
    private EducationType g;
    private EthnicityType h;
    private GenderType i;
    private Calendar j;
    private Integer k;
    private Integer l;
    private String m;
    private String n;
    private String o;
    private String p;
    private HasChildren q;
    private MaritalStatus r;
    private String s;
    private SexualOrientation t;
    private Map u;

    private UserInfo()
    {
        e = true;
        k = Integer.valueOf(0);
        l = Integer.valueOf(0);
        u = new HashMap();
    }

    public static UserInfo getInstance()
    {
        return a;
    }

    public final void addIDType(IMIDType imidtype, String s1)
    {
        if (u != null)
        {
            u.put(imidtype, s1);
        }
    }

    public final Integer getAge()
    {
        return l;
    }

    public final String getAreaCode()
    {
        return p;
    }

    public final Location getCurrentLocation()
    {
        return d;
    }

    public final Calendar getDateOfBirth()
    {
        return j;
    }

    public final int getDeviceIDMask()
    {
        return c;
    }

    public final EducationType getEducation()
    {
        return g;
    }

    public final EthnicityType getEthnicity()
    {
        return h;
    }

    public final GenderType getGender()
    {
        return i;
    }

    public final HasChildren getHasChildren()
    {
        return q;
    }

    public final String getIDType(IMIDType imidtype)
    {
        if (u != null)
        {
            return (String)u.get(imidtype);
        } else
        {
            return null;
        }
    }

    public final Integer getIncome()
    {
        return k;
    }

    public final String getInterests()
    {
        return m;
    }

    public final String getLanguage()
    {
        return s;
    }

    public final String getLocationWithCityStateCountry()
    {
        return n;
    }

    public final MaritalStatus getMaritalStatus()
    {
        return r;
    }

    public final String getPostalCode()
    {
        return o;
    }

    public final String getSearchString()
    {
        return f;
    }

    public final SexualOrientation getSexualOrientation()
    {
        return t;
    }

    public final boolean isLocationInquiryAllowed()
    {
        return e;
    }

    public final boolean isTestMode()
    {
        return b;
    }

    public final void removeIDType(IMIDType imidtype)
    {
        if (u != null)
        {
            u.remove(imidtype);
        }
    }

    public final void setAge(Integer integer)
    {
        l = integer;
    }

    public final void setAreaCode(String s1)
    {
        p = s1;
    }

    public final void setCurrentLocation(Location location)
    {
        d = location;
    }

    public final void setDateOfBirth(Calendar calendar)
    {
        j = calendar;
    }

    public final void setDeviceIDMask(int i1)
    {
        c = i1;
    }

    public final void setEducation(EducationType educationtype)
    {
        g = educationtype;
    }

    public final void setEthnicity(EthnicityType ethnicitytype)
    {
        h = ethnicitytype;
    }

    public final void setGender(GenderType gendertype)
    {
        i = gendertype;
    }

    public final void setHasChildren(HasChildren haschildren)
    {
        q = haschildren;
    }

    public final void setIncome(Integer integer)
    {
        k = integer;
    }

    public final void setInterests(String s1)
    {
        m = s1;
    }

    public final void setLanguage(String s1)
    {
        s = s1;
    }

    public final void setLocationInquiryAllowed(boolean flag)
    {
        e = flag;
    }

    public final void setLocationWithCityStateCountry(String s1, String s2, String s3)
    {
        if (s1 != null && !"".equals(s1.trim()))
        {
            n = s1;
        }
        if (s2 != null && !"".equals(s2.trim()))
        {
            n = (new StringBuilder()).append(n).append("-").append(s2).toString();
        }
        if (s3 != null && !"".equals(s3.trim()))
        {
            n = (new StringBuilder()).append(n).append("-").append(s3).toString();
        }
    }

    public final void setMaritalStatus(MaritalStatus maritalstatus)
    {
        r = maritalstatus;
    }

    public final void setPostalCode(String s1)
    {
        o = s1;
    }

    public final void setSexualOrientation(SexualOrientation sexualorientation)
    {
        t = sexualorientation;
    }

    public final void setTestMode(boolean flag)
    {
        b = flag;
    }

    public final void updateDeviceInfo()
    {
        try
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            Display display = ((WindowManager)InternalSDKUtil.getContext().getSystemService("window")).getDefaultDisplay();
            display.getMetrics(displaymetrics);
            float f1 = displaymetrics.density;
            int i1 = (int)((float)WrapperFunctions.getDisplayWidth(display) / f1);
            int j1 = (int)((float)WrapperFunctions.getDisplayHeight(display) / f1);
            DeviceInfo.setScreenDensity(String.valueOf(f1));
            DeviceInfo.setScreenSize((new StringBuilder()).append(i1).append("X").append(j1).toString());
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Exception setting device info", exception);
        }
    }

    public final void updateInfo()
    {
        this;
        JVM INSTR monitorenter ;
        updateDeviceInfo();
        DeviceInfo.setPhoneDefaultUserAgent(InternalSDKUtil.getUserAgent(InternalSDKUtil.getContext()));
        DeviceInfo.getInstance().fillDeviceInfo();
        AppInfo.fillAppInfo();
        LocationInfo.b(false);
        if (!isLocationInquiryAllowed())
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (getCurrentLocation() == null) goto _L2; else goto _L1
_L1:
        LocationInfo.a(getCurrentLocation());
        LocationInfo.b(true);
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        LocationInfo.verifyLocationPermission();
        if (!LocationInfo.isLocationDeniedByUser())
        {
            LocationInfo.updateBestKnownLocation();
        }
          goto _L3
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Exception updating user info", exception1);
          goto _L3
        Exception exception;
        exception;
        throw exception;
        LocationInfo.a(true);
          goto _L3
    }

}
