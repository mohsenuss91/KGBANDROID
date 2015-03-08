// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;

import com.google.ads.mediation.j;

public final class MillennialAdapterExtras
    implements j
{

    private Boolean children;
    private Education education;
    private Ethnicity ethnicity;
    private Integer income;
    private InterstitialTime interstitialTime;
    private MaritalStatus maritalStatus;
    private Orientation orientation;
    private Politics politics;
    private String postalCode;

    public MillennialAdapterExtras()
    {
        interstitialTime = InterstitialTime.UNKNOWN;
        income = null;
        maritalStatus = null;
        ethnicity = null;
        orientation = null;
        politics = null;
        education = null;
        children = null;
        postalCode = null;
    }

    public final MillennialAdapterExtras clearChildren()
    {
        return setChildren(null);
    }

    public final MillennialAdapterExtras clearEducation()
    {
        return setEducation(null);
    }

    public final MillennialAdapterExtras clearEthnicity()
    {
        return setEthnicity(null);
    }

    public final MillennialAdapterExtras clearIncomeInUsDollars()
    {
        return setIncomeInUsDollars(null);
    }

    public final MillennialAdapterExtras clearInterstitialTime()
    {
        return setInterstitialTime(null);
    }

    public final MillennialAdapterExtras clearMaritalStatus()
    {
        return setMaritalStatus(null);
    }

    public final MillennialAdapterExtras clearOrientation()
    {
        return setOrientation(null);
    }

    public final MillennialAdapterExtras clearPolitics()
    {
        return setPolitics(null);
    }

    public final MillennialAdapterExtras clearPostalCode()
    {
        return setPostalCode(null);
    }

    public final Boolean getChildren()
    {
        return children;
    }

    public final Education getEducation()
    {
        return education;
    }

    public final Ethnicity getEthnicity()
    {
        return ethnicity;
    }

    public final Integer getIncomeInUsDollars()
    {
        return income;
    }

    public final InterstitialTime getInterstitialTime()
    {
        return interstitialTime;
    }

    public final MaritalStatus getMaritalStatus()
    {
        return maritalStatus;
    }

    public final Orientation getOrientation()
    {
        return orientation;
    }

    public final Politics getPolitics()
    {
        return politics;
    }

    public final String getPostalCode()
    {
        return postalCode;
    }

    public final MillennialAdapterExtras setChildren(Boolean boolean1)
    {
        children = boolean1;
        return this;
    }

    public final MillennialAdapterExtras setEducation(Education education1)
    {
        education = education1;
        return this;
    }

    public final MillennialAdapterExtras setEthnicity(Ethnicity ethnicity1)
    {
        ethnicity = ethnicity1;
        return this;
    }

    public final MillennialAdapterExtras setIncomeInUsDollars(Integer integer)
    {
        income = integer;
        return this;
    }

    public final MillennialAdapterExtras setInterstitialTime(InterstitialTime interstitialtime)
    {
        interstitialTime = interstitialtime;
        return this;
    }

    public final MillennialAdapterExtras setMaritalStatus(MaritalStatus maritalstatus)
    {
        maritalStatus = maritalstatus;
        return this;
    }

    public final MillennialAdapterExtras setOrientation(Orientation orientation1)
    {
        orientation = orientation1;
        return this;
    }

    public final MillennialAdapterExtras setPolitics(Politics politics1)
    {
        politics = politics1;
        return this;
    }

    public final MillennialAdapterExtras setPostalCode(String s)
    {
        postalCode = s;
        return this;
    }

    private class InterstitialTime extends Enum
    {

        public static final InterstitialTime APP_LAUNCH;
        private static final InterstitialTime ENUM$VALUES[];
        public static final InterstitialTime TRANSITION;
        public static final InterstitialTime UNKNOWN;

        public static InterstitialTime valueOf(String s)
        {
            return (InterstitialTime)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$InterstitialTime, s);
        }

        public static InterstitialTime[] values()
        {
            InterstitialTime ainterstitialtime[] = ENUM$VALUES;
            int i = ainterstitialtime.length;
            InterstitialTime ainterstitialtime1[] = new InterstitialTime[i];
            System.arraycopy(ainterstitialtime, 0, ainterstitialtime1, 0, i);
            return ainterstitialtime1;
        }

        static 
        {
            UNKNOWN = new InterstitialTime("UNKNOWN", 0);
            APP_LAUNCH = new InterstitialTime("APP_LAUNCH", 1);
            TRANSITION = new InterstitialTime("TRANSITION", 2);
            InterstitialTime ainterstitialtime[] = new InterstitialTime[3];
            ainterstitialtime[0] = UNKNOWN;
            ainterstitialtime[1] = APP_LAUNCH;
            ainterstitialtime[2] = TRANSITION;
            ENUM$VALUES = ainterstitialtime;
        }

        private InterstitialTime(String s, int i)
        {
            super(s, i);
        }
    }

}
