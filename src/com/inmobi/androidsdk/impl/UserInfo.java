// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import com.inmobi.androidsdk.AdRequest;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.commons.uid.UID;
import com.inmobi.commons.uid.UIDHelper;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

public final class UserInfo
{

    private Random A;
    private String B;
    private int C;
    private long D;
    private Activity E;
    boolean a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private LocationManager m;
    private double n;
    private double o;
    private double p;
    private boolean q;
    private Context r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private AdRequest z;

    public UserInfo(Activity activity)
    {
        t = null;
        u = null;
        v = null;
        w = null;
        x = null;
        y = null;
        E = activity;
        r = activity.getApplicationContext();
        A = new Random();
    }

    private String a()
    {
        return k;
    }

    private void a(double d1)
    {
        n = d1;
    }

    private void a(int i1)
    {
        g = Integer.toString(i1);
    }

    private void a(long l1)
    {
        D = l1;
    }

    private void a(Context context)
    {
        try
        {
            if (B == null)
            {
                B = context.getSharedPreferences("inmobisdkaid", 0).getString("A_ID", null);
            }
            if (B == null)
            {
                B = UUID.randomUUID().toString();
                android.content.SharedPreferences.Editor editor = context.getSharedPreferences("inmobisdkaid", 0).edit();
                editor.putString("A_ID", B);
                editor.commit();
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void a(Location location)
    {
        if (location != null)
        {
            q = true;
            n = location.getLatitude();
            o = location.getLongitude();
            p = location.getAccuracy();
            D = location.getTime();
        }
    }

    private void a(LocationManager locationmanager)
    {
        this;
        JVM INSTR monitorenter ;
        m = locationmanager;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void a(AdRequest adrequest)
    {
        z = adrequest;
    }

    private void a(String s1)
    {
        b = s1;
    }

    private void a(boolean flag)
    {
        a = flag;
    }

    private LocationManager b()
    {
        this;
        JVM INSTR monitorenter ;
        LocationManager locationmanager = m;
        this;
        JVM INSTR monitorexit ;
        return locationmanager;
        Exception exception;
        exception;
        throw exception;
    }

    private void b(double d1)
    {
        o = d1;
    }

    private void b(int i1)
    {
        C = i1;
    }

    private void b(String s1)
    {
        c = s1;
    }

    private void b(boolean flag)
    {
        q = flag;
    }

    private void c(double d1)
    {
        p = d1;
    }

    private void c(String s1)
    {
        d = s1;
    }

    private boolean c()
    {
        if (z != null)
        {
            return z.isLocationInquiryAllowed();
        } else
        {
            return true;
        }
    }

    private void d(String s1)
    {
        e = s1;
    }

    private boolean d()
    {
        return a;
    }

    private void e()
    {
        LocationManager locationmanager;
        Criteria criteria;
        if (b() == null)
        {
            a((LocationManager)getApplicationContext().getSystemService("location"));
        }
        if (b() == null)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        locationmanager = b();
        criteria = new Criteria();
        if (getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto _L2; else goto _L1
_L1:
        criteria.setAccuracy(1);
_L4:
        String s1;
        criteria.setCostAllowed(false);
        s1 = locationmanager.getBestProvider(criteria, true);
        if (isValidGeoInfo() || s1 == null)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        Location location;
        location = locationmanager.getLastKnownLocation(s1);
        Log.debug("[InMobi]-[Network]-4.4.1", (new StringBuilder("lastBestKnownLocation: ")).append(location).toString());
        if (location != null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        location = f();
        Log.debug("[InMobi]-[Network]-4.4.1", (new StringBuilder("lastKnownLocation: ")).append(location).toString());
        a(location);
        return;
_L2:
        if (getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) goto _L4; else goto _L3
_L3:
        criteria.setAccuracy(2);
          goto _L4
        Exception exception;
        exception;
        Log.debug("[InMobi]-[Network]-4.4.1", "Error getting the Location Info ", exception);
    }

    private void e(String s1)
    {
        i = s1;
    }

    private Location f()
    {
        if (b() == null)
        {
            a((LocationManager)getApplicationContext().getSystemService("location"));
        }
        if (b() != null)
        {
            LocationManager locationmanager = b();
            List list = locationmanager.getProviders(true);
            for (int i1 = -1 + list.size(); i1 >= 0; i1--)
            {
                String s1 = (String)list.get(i1);
                if (!locationmanager.isProviderEnabled(s1))
                {
                    continue;
                }
                Location location = locationmanager.getLastKnownLocation(s1);
                if (location != null)
                {
                    return location;
                }
            }

        }
        return null;
    }

    private void f(String s1)
    {
        j = s1;
    }

    private void g()
    {
        int i1 = getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
        int j1 = getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        if (i1 != 0 && j1 != 0)
        {
            a = true;
            return;
        } else
        {
            a = false;
            return;
        }
    }

    private void g(String s1)
    {
        k = s1;
    }

    private void h()
    {
        if (a() != null) goto _L2; else goto _L1
_L1:
        k = Build.BRAND;
        Locale locale = Locale.getDefault();
        String s1 = locale.getLanguage();
        AdRequest adrequest;
        int i1;
        HashMap hashmap;
        Long long1;
        int j1;
        Long long2;
        String s4;
        Context context;
        PackageManager packagemanager;
        ApplicationInfo applicationinfo;
        PackageInfo packageinfo;
        String s5;
        if (s1 != null)
        {
            s4 = s1.toLowerCase(Locale.ENGLISH);
            String s6 = locale.getCountry();
            if (s6 != null)
            {
                s4 = (new StringBuilder()).append(s4).append("_").append(s6.toLowerCase(Locale.ENGLISH)).toString();
            }
        } else
        {
            String s2 = (String)System.getProperties().get("user.language");
            String s3 = (String)System.getProperties().get("user.region");
            Exception exception;
            Exception exception1;
            Exception exception2;
            if (s2 != null && s3 != null)
            {
                s4 = (new StringBuilder()).append(s2).append("_").append(s3).toString();
            } else
            {
                s4 = s1;
            }
            if (s4 == null)
            {
                s4 = "en";
            }
        }
        f(s4);
        context = getApplicationContext();
        packagemanager = context.getPackageManager();
        applicationinfo = packagemanager.getApplicationInfo(context.getPackageName(), 128);
        if (applicationinfo == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        a(applicationinfo.packageName);
        b(applicationinfo.loadLabel(packagemanager).toString());
        packageinfo = packagemanager.getPackageInfo(context.getPackageName(), 128);
        if (packageinfo == null) goto _L4; else goto _L3
_L3:
        s5 = packageinfo.versionName;
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        if (!s5.equals(""))
        {
            break MISSING_BLOCK_LABEL_212;
        }
        s5 = (new StringBuilder()).append(packageinfo.versionCode).toString();
_L8:
        if (s5 != null)
        {
            try
            {
                if (!s5.equals(""))
                {
                    c(s5);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception2) { }
        }
_L2:
        a(A.nextInt());
        adrequest = z;
        i1 = 0;
        if (adrequest != null)
        {
            i1 = com.inmobi.commons.data.UserInfo.getInstance().getDeviceIDMask();
        }
        hashmap = new HashMap();
        long2 = AnalyticsInitializer.getConfigParams().getLTVId();
        long1 = long2;
_L6:
        if (long1 != null)
        {
            hashmap.put("LTVID", (new StringBuilder()).append(long1).toString());
        }
        e(Initializer.getConfigParams().getUID().getUidMapWitoutXOR(i1, getRandomKey(), hashmap));
        if (r != null)
        {
            a(r);
        }
        d(InternalSDKUtil.getConnectivityType(getApplicationContext()));
        j1 = WrapperFunctions.getCurrentOrientationInFixedValues(i());
        {
            if (j1 != 9)
            {
                break; /* Loop/switch isn't completed */
            }
            try
            {
                b(2);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception1)
            {
                Log.debug("[InMobi]-[Network]-4.4.1", "Error getting the orientation info ", exception1);
            }
            break MISSING_BLOCK_LABEL_500;
        }
        exception;
        Log.internal("[InMobi]-[Network]-4.4.1", "LTVID not available yet in configs");
        long1 = null;
        if (true) goto _L6; else goto _L5
_L5:
        if (j1 != 8)
        {
            break MISSING_BLOCK_LABEL_501;
        }
        b(4);
        return;
        return;
        if (j1 != 0)
        {
            break MISSING_BLOCK_LABEL_512;
        }
        b(3);
        return;
        b(1);
        return;
_L4:
        s5 = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void h(String s1)
    {
        l = s1;
    }

    private Activity i()
    {
        return E;
    }

    public final String getAdUnitSlot()
    {
        return v;
    }

    public final int getAge()
    {
        if (z != null)
        {
            return z.getAge();
        } else
        {
            return 0;
        }
    }

    public final String getAid()
    {
        return B;
    }

    public final String getAppBId()
    {
        return b;
    }

    public final String getAppDisplayName()
    {
        return c;
    }

    public final String getAppVer()
    {
        return d;
    }

    public final Context getApplicationContext()
    {
        return r;
    }

    public final String getAreaCode()
    {
        if (z != null)
        {
            return z.getAreaCode();
        } else
        {
            return null;
        }
    }

    public final String getDateOfBirth()
    {
        AdRequest adrequest = z;
        String s1 = null;
        if (adrequest != null)
        {
            Calendar calendar = z.getDateOfBirth();
            s1 = null;
            if (calendar != null)
            {
                Calendar calendar1 = z.getDateOfBirth();
                s1 = (new StringBuilder()).append(calendar1.get(1)).append("-").append(1 + calendar1.get(2)).append("-").append(calendar1.get(5)).toString();
            }
        }
        return s1;
    }

    public final EducationType getEducation()
    {
        if (z != null)
        {
            return z.getEducation();
        } else
        {
            return null;
        }
    }

    public final EthnicityType getEthnicity()
    {
        if (z != null)
        {
            return z.getEthnicity();
        } else
        {
            return null;
        }
    }

    public final GenderType getGender()
    {
        if (z != null)
        {
            return z.getGender();
        } else
        {
            return null;
        }
    }

    public final long getGeoTS()
    {
        return D;
    }

    public final HasChildren getHasChildren()
    {
        if (z != null)
        {
            return z.getHasChildren();
        } else
        {
            return null;
        }
    }

    public final int getIncome()
    {
        if (z != null)
        {
            return z.getIncome();
        } else
        {
            return 0;
        }
    }

    public final String getInterests()
    {
        if (z != null)
        {
            return z.getInterests();
        } else
        {
            return null;
        }
    }

    public final String getKeywords()
    {
        if (z != null)
        {
            return z.getKeywords();
        } else
        {
            return null;
        }
    }

    public final String getLanguage()
    {
        if (z != null)
        {
            return z.getLanguage();
        } else
        {
            return null;
        }
    }

    public final double getLat()
    {
        return n;
    }

    public final double getLocAccuracy()
    {
        return p;
    }

    public final String getLocalization()
    {
        return j;
    }

    public final String getLocationWithCityStateCountry()
    {
        if (z != null)
        {
            return z.getLocationWithCityStateCountry();
        } else
        {
            return null;
        }
    }

    public final double getLon()
    {
        return o;
    }

    public final MaritalStatus getMaritalStatus()
    {
        if (z != null)
        {
            return z.getMaritalStatus();
        } else
        {
            return null;
        }
    }

    public final String getNetworkType()
    {
        return e;
    }

    public final String getODINId()
    {
        return f;
    }

    public final int getOrientation()
    {
        return C;
    }

    public final String getPhoneDefaultUserAgent()
    {
        if (s == null)
        {
            return "";
        } else
        {
            return s;
        }
    }

    public final String getPlainUidMap()
    {
        return i;
    }

    public final String getPostalCode()
    {
        if (z != null)
        {
            return z.getPostalCode();
        } else
        {
            return null;
        }
    }

    public final String getRandomKey()
    {
        return g;
    }

    public final String getRefTagKey()
    {
        return t;
    }

    public final String getRefTagValue()
    {
        return u;
    }

    public final Map getRequestParams()
    {
        if (z != null)
        {
            return z.getRequestParams();
        } else
        {
            return null;
        }
    }

    public final String getRsakeyVersion()
    {
        return UIDHelper.getRSAKeyVersion();
    }

    public final String getScreenDensity()
    {
        return y;
    }

    public final String getScreenSize()
    {
        return x;
    }

    public final String getSearchString()
    {
        if (z != null)
        {
            return z.getSearchString();
        } else
        {
            return null;
        }
    }

    public final SexualOrientation getSexualOrientation()
    {
        if (z != null)
        {
            return z.getSexualOrientation();
        } else
        {
            return null;
        }
    }

    public final String getSiteId()
    {
        return l;
    }

    public final String getSlotId()
    {
        return w;
    }

    public final String getUIDMapEncrypted()
    {
        return h;
    }

    public final boolean isValidGeoInfo()
    {
        return q;
    }

    public final void setAdUnitSlot(String s1)
    {
        v = s1;
    }

    public final void setPhoneDefaultUserAgent(String s1)
    {
        s = s1;
    }

    public final void setRefTagKey(String s1)
    {
        t = s1;
    }

    public final void setRefTagValue(String s1)
    {
        u = s1;
    }

    public final void setScreenDensity(String s1)
    {
        y = s1;
    }

    public final void setScreenSize(String s1)
    {
        x = s1;
    }

    public final void setSlotId(String s1)
    {
        w = s1;
    }

    public final void updateInfo(String s1, AdRequest adrequest)
    {
        this;
        JVM INSTR monitorenter ;
        z = adrequest;
        h();
        l = s1;
        if (adrequest == null) goto _L2; else goto _L1
_L1:
        q = false;
        if (!c())
        {
            break MISSING_BLOCK_LABEL_78;
        }
        if (adrequest.getCurrentLocation() == null) goto _L4; else goto _L3
_L3:
        a(adrequest.getCurrentLocation());
        q = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        g();
        if (!d())
        {
            e();
        }
          goto _L2
        Exception exception;
        exception;
        throw exception;
        a = true;
          goto _L2
    }
}
