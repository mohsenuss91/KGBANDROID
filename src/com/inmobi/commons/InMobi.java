// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.inmobi.commons.analytics.androidsdk.IMAdTracker;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper;
import com.inmobi.commons.cache.LocalCache;
import com.inmobi.commons.data.UserInfo;
import com.inmobi.commons.internal.ActivityRecognitionManager;
import com.inmobi.commons.internal.ApplicationFocusManager;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.commons.uid.UIDHelper;
import java.util.Calendar;

// Referenced classes of package com.inmobi.commons:
//            IMIDType, EducationType, EthnicityType, GenderType, 
//            HasChildren, MaritalStatus, SexualOrientation

public final class InMobi
{

    public static final int EXCLUDE_FB_ID = 4;
    public static final int EXCLUDE_ODIN1 = 2;
    public static final int EXCLUDE_UM5_ID = 8;
    public static final int ID_DEVICE_NONE = 0;
    public static final int INCLUDE_DEFAULT = 1;
    private static String a = null;

    private InMobi()
    {
    }

    static String a()
    {
        return a;
    }

    private static void a(Context context, String s)
    {
        Context context1;
        if (context == null)
        {
            Log.debug("[InMobi]-4.4.1", "Application Context NULL");
            Log.debug("[InMobi]-4.4.1", "context cannot be null");
            return;
        }
        context1 = context.getApplicationContext();
        InternalSDKUtil.setContext(context1);
        if (!InternalSDKUtil.isPlatformIdEnabled() && !InternalSDKUtil.isGooglePlayServicesJarIncluded())
        {
            throw new RuntimeException("Integration Issue. Please include Google Play services in your project or update your playstore app and google play services in the phone");
        }
        UIDHelper.setAdvertisingId();
        try
        {
            if (FileOperations.getPreferences(context.getApplicationContext(), "impref", "version") != getVersion())
            {
                FileOperations.setPreferences(context.getApplicationContext(), "impref", "version", getVersion());
                LocalCache.reset();
            }
            InternalSDKUtil.getUserAgent(context.getApplicationContext());
            if (a != null)
            {
                ThinICE.start(context);
                return;
            }
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Exception in initialize", exception);
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        if (!"".equals(s.trim()))
        {
            break MISSING_BLOCK_LABEL_141;
        }
        Log.debug("[InMobi]-4.4.1", "appId cannot be blank");
        return;
        Log.debug("[InMobi]-4.4.1", "InMobi init successful");
        a = s.trim();
        ThinICE.start(context);
        IMAdTracker.getInstance().init(context1, s);
        IMAdTracker.getInstance().reportAppDownloadGoal();
        ApplicationFocusManager.init(context);
        ApplicationFocusManager.addFocusChangedListener(new a());
        AnalyticsEventsWrapper.getInstance().startSession(a, null);
        ActivityRecognitionManager.init(context.getApplicationContext());
        UserInfo.getInstance().updateInfo();
        return;
    }

    public static void addIDType(IMIDType imidtype, String s)
    {
        UserInfo.getInstance().addIDType(imidtype, s);
    }

    public static String getAppId()
    {
        return a;
    }

    public static String getVersion()
    {
        return "4.4.1";
    }

    public static void initialize(Activity activity, String s)
    {
        a(activity, s);
    }

    public static void initialize(Context context, String s)
    {
        a(context, s);
    }

    public static void removeIDType(IMIDType imidtype)
    {
        UserInfo.getInstance().removeIDType(imidtype);
    }

    public static void setAge(int i)
    {
        UserInfo.getInstance().setAge(Integer.valueOf(i));
    }

    public static void setAreaCode(String s)
    {
        if (s != null && !"".equals(s.trim()))
        {
            UserInfo.getInstance().setAreaCode(s);
            return;
        } else
        {
            Log.debug("[InMobi]-4.4.1", "Area code cannot be null");
            return;
        }
    }

    public static void setCurrentLocation(Location location)
    {
        if (location != null)
        {
            UserInfo.getInstance().setCurrentLocation(location);
            return;
        } else
        {
            Log.debug("[InMobi]-4.4.1", "Location cannot be null");
            return;
        }
    }

    public static void setDateOfBirth(Calendar calendar)
    {
        if (calendar != null)
        {
            UserInfo.getInstance().setDateOfBirth(calendar);
            return;
        } else
        {
            Log.debug("[InMobi]-4.4.1", "Date Of Birth cannot be null");
            return;
        }
    }

    public static void setDeviceIDMask(int i)
    {
        UserInfo.getInstance().setDeviceIDMask(i);
    }

    public static void setEducation(EducationType educationtype)
    {
        if (educationtype != null)
        {
            UserInfo.getInstance().setEducation(educationtype);
        }
    }

    public static void setEthnicity(EthnicityType ethnicitytype)
    {
        if (ethnicitytype != null)
        {
            UserInfo.getInstance().setEthnicity(ethnicitytype);
        }
    }

    public static void setGender(GenderType gendertype)
    {
        if (gendertype != null)
        {
            UserInfo.getInstance().setGender(gendertype);
        }
    }

    public static void setHasChildren(HasChildren haschildren)
    {
        if (haschildren != null)
        {
            UserInfo.getInstance().setHasChildren(haschildren);
        }
    }

    public static void setIncome(int i)
    {
        UserInfo.getInstance().setIncome(Integer.valueOf(i));
    }

    public static void setInterests(String s)
    {
        if (s != null && !"".equals(s.trim()))
        {
            UserInfo.getInstance().setInterests(s);
            return;
        } else
        {
            Log.debug("[InMobi]-4.4.1", "Interests cannot be null");
            return;
        }
    }

    public static void setLanguage(String s)
    {
        if (s != null && !"".equals(s.trim()))
        {
            UserInfo.getInstance().setLanguage(s);
            return;
        } else
        {
            Log.debug("[InMobi]-4.4.1", "Language cannot be null");
            return;
        }
    }

    public static void setLocationInquiryAllowed(boolean flag)
    {
        UserInfo.getInstance().setLocationInquiryAllowed(flag);
    }

    public static void setLocationWithCityStateCountry(String s, String s1, String s2)
    {
        UserInfo.getInstance().setLocationWithCityStateCountry(s, s1, s2);
    }

    public static void setLogLevel(LOG_LEVEL log_level)
    {
        if (log_level == LOG_LEVEL.NONE)
        {
            Log.setInternalLogLevel(com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL.NONE);
            return;
        }
        if (log_level == LOG_LEVEL.DEBUG)
        {
            Log.setInternalLogLevel(com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL.DEBUG);
            return;
        }
        if (log_level == LOG_LEVEL.VERBOSE)
        {
            Log.setInternalLogLevel(com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL.VERBOSE);
            return;
        } else
        {
            Log.setInternalLogLevel(com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL.INTERNAL);
            return;
        }
    }

    public static void setMaritalStatus(MaritalStatus maritalstatus)
    {
        if (maritalstatus != null)
        {
            UserInfo.getInstance().setMaritalStatus(maritalstatus);
        }
    }

    public static void setPostalCode(String s)
    {
        if (s != null && !"".equals(s.trim()))
        {
            UserInfo.getInstance().setPostalCode(s);
            return;
        } else
        {
            Log.debug("[InMobi]-4.4.1", "Postal Code cannot be null");
            return;
        }
    }

    public static void setSexualOrientation(SexualOrientation sexualorientation)
    {
        if (sexualorientation != null)
        {
            UserInfo.getInstance().setSexualOrientation(sexualorientation);
        }
    }


    private class a
        implements com.inmobi.commons.internal.ApplicationFocusManager.FocusChangedListener
    {

        public final void onFocusChanged(boolean flag)
        {
            if (flag)
            {
                UIDHelper.setAdvertisingId();
                AnalyticsEventsWrapper.getInstance().startSession(InMobi.a(), null);
                return;
            } else
            {
                AnalyticsEventsWrapper.getInstance().endSession(null);
                return;
            }
        }

        a()
        {
        }
    }


    private class LOG_LEVEL extends Enum
    {

        public static final LOG_LEVEL DEBUG;
        public static final LOG_LEVEL NONE;
        public static final LOG_LEVEL VERBOSE;
        private static final LOG_LEVEL b[];
        private final int a;

        public static LOG_LEVEL valueOf(String s)
        {
            return (LOG_LEVEL)Enum.valueOf(com/inmobi/commons/InMobi$LOG_LEVEL, s);
        }

        public static LOG_LEVEL[] values()
        {
            return (LOG_LEVEL[])b.clone();
        }

        public final int getValue()
        {
            return a;
        }

        static 
        {
            NONE = new LOG_LEVEL("NONE", 0, 0);
            DEBUG = new LOG_LEVEL("DEBUG", 1, 1);
            VERBOSE = new LOG_LEVEL("VERBOSE", 2, 2);
            LOG_LEVEL alog_level[] = new LOG_LEVEL[3];
            alog_level[0] = NONE;
            alog_level[1] = DEBUG;
            alog_level[2] = VERBOSE;
            b = alog_level;
        }

        private LOG_LEVEL(String s, int i, int j)
        {
            super(s, i);
            a = j;
        }
    }

}
