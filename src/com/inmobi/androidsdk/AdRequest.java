// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import android.location.Location;
import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AdRequest
{

    private boolean a;
    private Location b;
    private String c;
    private boolean d;
    private String e;
    private String f;
    private Calendar g;
    private GenderType h;
    private String i;
    private String j;
    private int k;
    private EducationType l;
    private EthnicityType m;
    private int n;
    private String o;
    private Map p;
    private MaritalStatus q;
    private String r;
    private SexualOrientation s;
    private HasChildren t;

    public AdRequest()
    {
        a = true;
        b = null;
        c = null;
        d = false;
        e = null;
        f = null;
        g = null;
        i = null;
        j = null;
        k = 0;
        n = 0;
        o = null;
        p = null;
    }

    public int getAge()
    {
        return n;
    }

    public String getAreaCode()
    {
        return f;
    }

    public Location getCurrentLocation()
    {
        return b;
    }

    public Calendar getDateOfBirth()
    {
        return g;
    }

    public EducationType getEducation()
    {
        return l;
    }

    public EthnicityType getEthnicity()
    {
        return m;
    }

    public GenderType getGender()
    {
        return h;
    }

    public HasChildren getHasChildren()
    {
        return t;
    }

    public int getIncome()
    {
        return k;
    }

    public String getInterests()
    {
        return o;
    }

    public String getKeywords()
    {
        return i;
    }

    public String getLanguage()
    {
        return r;
    }

    public String getLocationWithCityStateCountry()
    {
        return c;
    }

    public MaritalStatus getMaritalStatus()
    {
        return q;
    }

    public String getPostalCode()
    {
        return e;
    }

    public Map getRequestParams()
    {
        return p;
    }

    public String getSearchString()
    {
        return j;
    }

    public SexualOrientation getSexualOrientation()
    {
        return s;
    }

    public boolean isLocationInquiryAllowed()
    {
        return a;
    }

    public boolean isTestMode()
    {
        return d;
    }

    public void setAge(int i1)
    {
        if (i1 >= 0)
        {
            n = i1;
        }
    }

    public void setAreaCode(String s1)
    {
        if (s1 != null && !"".equals(s1.trim()))
        {
            f = s1;
        }
    }

    public void setCurrentLocation(Location location)
    {
        if (location != null)
        {
            b = location;
        }
    }

    public void setDateOfBirth(Calendar calendar)
    {
        if (calendar != null)
        {
            g = calendar;
        }
    }

    public void setDateOfBirth(Date date)
    {
        if (date == null)
        {
            return;
        }
        if (g == null)
        {
            g = Calendar.getInstance();
        }
        g.setTime(date);
    }

    public void setEducation(EducationType educationtype)
    {
        l = educationtype;
    }

    public void setEthnicity(EthnicityType ethnicitytype)
    {
        m = ethnicitytype;
    }

    public void setGender(GenderType gendertype)
    {
        h = gendertype;
    }

    public void setHasChildren(HasChildren haschildren)
    {
        t = haschildren;
    }

    public void setIncome(int i1)
    {
        k = i1;
    }

    public void setInterests(String s1)
    {
        if (s1 != null && !"".equals(s1.trim()))
        {
            o = s1;
        }
    }

    public void setKeywords(String s1)
    {
        if (s1 != null && !"".equals(s1.trim()))
        {
            i = s1;
        }
    }

    public void setLanguage(String s1)
    {
        if (s1 != null && !"".equals(s1.trim()))
        {
            r = s1;
        }
    }

    public void setLocationInquiryAllowed(boolean flag)
    {
        a = flag;
    }

    public void setLocationOfCityStateAndCountry(String s1)
    {
        if (s1 != null && !"".equals(s1.trim()))
        {
            c = s1;
        }
    }

    public void setLocationWithCityStateCountry(String s1, String s2, String s3)
    {
        if (s1 != null && !"".equals(s1.trim()))
        {
            c = s1;
        }
        if (s2 != null && !"".equals(s2.trim()))
        {
            c = (new StringBuilder()).append(c).append("-").append(s2).toString();
        }
        if (s3 != null && !"".equals(s3.trim()))
        {
            c = (new StringBuilder()).append(c).append("-").append(s3).toString();
        }
    }

    public void setMaritalStatus(MaritalStatus maritalstatus)
    {
        q = maritalstatus;
    }

    public void setPostalCode(String s1)
    {
        if (s1 != null && !"".equals(s1.trim()))
        {
            e = s1;
        }
    }

    public void setRequestParams(Map map)
    {
        if (map != null)
        {
            if (p == null)
            {
                p = new HashMap();
            }
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) 
            {
                String s1 = (String)iterator.next();
                p.put(s1, map.get(s1));
            }
        }
    }

    public void setSearchString(String s1)
    {
        if (s1 != null && !"".equals(s1.trim()))
        {
            j = s1;
        }
    }

    public void setSexualOrientation(SexualOrientation sexualorientation)
    {
        s = sexualorientation;
    }

    public void setTestMode(boolean flag)
    {
        d = flag;
    }
}
