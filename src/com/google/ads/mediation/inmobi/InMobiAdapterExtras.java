// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.inmobi;

import com.google.ads.mediation.j;
import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.IMIDType;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class InMobiAdapterExtras
    implements j
{

    private String areaCode;
    private String cities;
    private String countries;
    private EducationType education;
    private EthnicityType ethnicity;
    private HasChildren hasChildren;
    private Map idtypeParams;
    private Integer income;
    private Set interests;
    private boolean isLocationInquiryAllowed;
    private String keywords;
    private String languages;
    private MaritalStatus martialStatus;
    private String postalCode;
    private String reftagKey;
    private String reftagValue;
    private Map requestParams;
    private String searchString;
    private SexualOrientation sexualOrientations;
    private String states;
    private int uidMapFlag;

    public InMobiAdapterExtras()
    {
        areaCode = null;
        reftagKey = null;
        reftagValue = null;
        education = null;
        ethnicity = null;
        income = null;
        interests = null;
        postalCode = null;
        searchString = null;
        hasChildren = null;
        sexualOrientations = null;
        martialStatus = null;
        languages = null;
        keywords = null;
        states = null;
        cities = null;
        countries = null;
        isLocationInquiryAllowed = false;
        idtypeParams = new HashMap();
    }

    public final void addIDType(IMIDType imidtype, String s)
    {
        if (idtypeParams != null)
        {
            idtypeParams.put(imidtype, s);
        }
    }

    public final void addInterests(String s)
    {
        if (interests == null)
        {
            interests = new HashSet();
        }
        interests.add(s);
    }

    public final InMobiAdapterExtras clearAreaCode()
    {
        return setAreaCode(null);
    }

    public final InMobiAdapterExtras clearCityStateCountry()
    {
        return setCityStateCountry(null, null, null);
    }

    public final InMobiAdapterExtras clearDeviceIdMask()
    {
        uidMapFlag = 1;
        return this;
    }

    public final InMobiAdapterExtras clearEducation()
    {
        return setEducation(null);
    }

    public final InMobiAdapterExtras clearEthnicity()
    {
        return setEthnicity(null);
    }

    public final InMobiAdapterExtras clearIncome()
    {
        return setIncome(null);
    }

    public final InMobiAdapterExtras clearInterests()
    {
        return setInterests(null);
    }

    public final InMobiAdapterExtras clearKeywords()
    {
        return setKeywords(null);
    }

    public final InMobiAdapterExtras clearLanguage()
    {
        return setlanguage(null);
    }

    public final InMobiAdapterExtras clearLocationInquiryAllowed()
    {
        isLocationInquiryAllowed = false;
        return this;
    }

    public final InMobiAdapterExtras clearMartialStatus()
    {
        return setMartialStatus(null);
    }

    public final InMobiAdapterExtras clearPostalCode()
    {
        return setPostalCode(null);
    }

    public final InMobiAdapterExtras clearRefTag()
    {
        return setRefTag(null, null);
    }

    public final InMobiAdapterExtras clearRequestParams()
    {
        return setRequestParams(null);
    }

    public final InMobiAdapterExtras clearSearchString()
    {
        return setSearchString(null);
    }

    public final InMobiAdapterExtras clearhasChildren()
    {
        return setHasChildren(null);
    }

    public final InMobiAdapterExtras clearsexualOrientations()
    {
        return setSexualOrientation(null);
    }

    public final String getAreaCode()
    {
        return areaCode;
    }

    public final String getCity()
    {
        return cities;
    }

    public final String getCountry()
    {
        return countries;
    }

    public final int getDeviceIdMask()
    {
        return uidMapFlag;
    }

    public final EducationType getEducation()
    {
        return education;
    }

    public final EthnicityType getEthnicity()
    {
        return ethnicity;
    }

    public final HasChildren getHasChildren()
    {
        return hasChildren;
    }

    public final String getIDType(IMIDType imidtype)
    {
        if (idtypeParams != null)
        {
            return (String)idtypeParams.get(imidtype);
        } else
        {
            return null;
        }
    }

    public final Integer getIncome()
    {
        return income;
    }

    public final Set getInterests()
    {
        if (interests == null)
        {
            return null;
        } else
        {
            return Collections.unmodifiableSet(interests);
        }
    }

    public final String getKeywords()
    {
        return keywords;
    }

    public final String getLangauge()
    {
        return languages;
    }

    public final MaritalStatus getMartialStatus()
    {
        return martialStatus;
    }

    public final String getPostalCode()
    {
        return postalCode;
    }

    public final String getRefTagKey()
    {
        return reftagKey;
    }

    public final String getRefTagValue()
    {
        return reftagValue;
    }

    public final Map getRequestParams()
    {
        return requestParams;
    }

    public final String getSearchString()
    {
        return searchString;
    }

    public final SexualOrientation getSexualOrientations()
    {
        return sexualOrientations;
    }

    public final String getState()
    {
        return states;
    }

    public final boolean isLocationInquiryAllowed()
    {
        return isLocationInquiryAllowed;
    }

    public final void removeIDType(IMIDType imidtype)
    {
        if (idtypeParams != null)
        {
            idtypeParams.remove(imidtype);
        }
    }

    public final InMobiAdapterExtras setAreaCode(String s)
    {
        areaCode = s;
        return this;
    }

    public final InMobiAdapterExtras setCityStateCountry(String s, String s1, String s2)
    {
        states = s1;
        cities = s;
        countries = s2;
        return this;
    }

    public final void setDeviceIDMask(int i)
    {
        uidMapFlag = i;
    }

    public final InMobiAdapterExtras setEducation(EducationType educationtype)
    {
        education = educationtype;
        return this;
    }

    public final InMobiAdapterExtras setEthnicity(EthnicityType ethnicitytype)
    {
        ethnicity = ethnicitytype;
        return this;
    }

    public final InMobiAdapterExtras setHasChildren(HasChildren haschildren)
    {
        hasChildren = haschildren;
        return this;
    }

    public final InMobiAdapterExtras setIncome(Integer integer)
    {
        income = integer;
        return this;
    }

    public final InMobiAdapterExtras setInterests(Collection collection)
    {
        if (collection == null)
        {
            interests = new HashSet();
            return this;
        } else
        {
            interests = new HashSet(collection);
            return this;
        }
    }

    public final InMobiAdapterExtras setKeywords(String s)
    {
        keywords = s;
        return this;
    }

    public final void setLocationInquiryAllowed(boolean flag)
    {
        isLocationInquiryAllowed = flag;
    }

    public final InMobiAdapterExtras setMartialStatus(MaritalStatus maritalstatus)
    {
        martialStatus = maritalstatus;
        return this;
    }

    public final InMobiAdapterExtras setPostalCode(String s)
    {
        postalCode = s;
        return this;
    }

    public final InMobiAdapterExtras setRefTag(String s, String s1)
    {
        reftagKey = s;
        reftagValue = s1;
        return this;
    }

    public final InMobiAdapterExtras setRequestParams(Map map)
    {
        requestParams = map;
        return this;
    }

    public final InMobiAdapterExtras setSearchString(String s)
    {
        searchString = s;
        return this;
    }

    public final InMobiAdapterExtras setSexualOrientation(SexualOrientation sexualorientation)
    {
        sexualOrientations = sexualorientation;
        return this;
    }

    public final InMobiAdapterExtras setlanguage(String s)
    {
        languages = s;
        return this;
    }
}
