// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            hz, kp

public final class ko extends hz
    implements SafeParcelable, ItemScope
{

    public static final kp CREATOR = new kp();
    private static final HashMap aco;
    private String Mm;
    private double Va;
    private double Vb;
    private List acA;
    private String acB;
    private String acC;
    private ko acD;
    private String acE;
    private String acF;
    private List acG;
    private String acH;
    private String acI;
    private String acJ;
    private String acK;
    private String acL;
    private String acM;
    private String acN;
    private String acO;
    private ko acP;
    private String acQ;
    private String acR;
    private String acS;
    private ko acT;
    private ko acU;
    private ko acV;
    private List acW;
    private String acX;
    private String acY;
    private String acZ;
    private final Set acp;
    private ko acq;
    private List acr;
    private ko acs;
    private String act;
    private String acu;
    private String acv;
    private List acw;
    private int acx;
    private List acy;
    private ko acz;
    private String ada;
    private ko adb;
    private String adc;
    private String add;
    private String ade;
    private ko adf;
    private String adg;
    private String adh;
    private String adi;
    private String adj;
    private String mName;
    private String mi;
    private String qU;
    private String qV;
    private String xD;
    private final int xJ;

    public ko()
    {
        xJ = 1;
        acp = new HashSet();
    }

    ko(Set set, int i, ko ko1, List list, ko ko2, String s, String s1, 
            String s2, List list1, int j, List list2, ko ko3, List list3, String s3, 
            String s4, ko ko4, String s5, String s6, String s7, List list4, String s8, 
            String s9, String s10, String s11, String s12, String s13, String s14, String s15, 
            String s16, ko ko5, String s17, String s18, String s19, String s20, ko ko6, 
            double d, ko ko7, double d1, String s21, ko ko8, 
            List list5, String s22, String s23, String s24, String s25, ko ko9, String s26, 
            String s27, String s28, ko ko10, String s29, String s30, String s31, String s32, 
            String s33, String s34)
    {
        acp = set;
        xJ = i;
        acq = ko1;
        acr = list;
        acs = ko2;
        act = s;
        acu = s1;
        acv = s2;
        acw = list1;
        acx = j;
        acy = list2;
        acz = ko3;
        acA = list3;
        acB = s3;
        acC = s4;
        acD = ko4;
        acE = s5;
        acF = s6;
        mi = s7;
        acG = list4;
        acH = s8;
        acI = s9;
        acJ = s10;
        Mm = s11;
        acK = s12;
        acL = s13;
        acM = s14;
        acN = s15;
        acO = s16;
        acP = ko5;
        acQ = s17;
        acR = s18;
        xD = s19;
        acS = s20;
        acT = ko6;
        Va = d;
        acU = ko7;
        Vb = d1;
        mName = s21;
        acV = ko8;
        acW = list5;
        acX = s22;
        acY = s23;
        acZ = s24;
        ada = s25;
        adb = ko9;
        adc = s26;
        add = s27;
        ade = s28;
        adf = ko10;
        adg = s29;
        adh = s30;
        qU = s31;
        qV = s32;
        adi = s33;
        adj = s34;
    }

    public ko(Set set, ko ko1, List list, ko ko2, String s, String s1, String s2, 
            List list1, int i, List list2, ko ko3, List list3, String s3, String s4, 
            ko ko4, String s5, String s6, String s7, List list4, String s8, String s9, 
            String s10, String s11, String s12, String s13, String s14, String s15, String s16, 
            ko ko5, String s17, String s18, String s19, String s20, ko ko6, double d, ko ko7, double d1, String s21, ko ko8, List list5, 
            String s22, String s23, String s24, String s25, ko ko9, String s26, String s27, 
            String s28, ko ko10, String s29, String s30, String s31, String s32, String s33, 
            String s34)
    {
        acp = set;
        xJ = 1;
        acq = ko1;
        acr = list;
        acs = ko2;
        act = s;
        acu = s1;
        acv = s2;
        acw = list1;
        acx = i;
        acy = list2;
        acz = ko3;
        acA = list3;
        acB = s3;
        acC = s4;
        acD = ko4;
        acE = s5;
        acF = s6;
        mi = s7;
        acG = list4;
        acH = s8;
        acI = s9;
        acJ = s10;
        Mm = s11;
        acK = s12;
        acL = s13;
        acM = s14;
        acN = s15;
        acO = s16;
        acP = ko5;
        acQ = s17;
        acR = s18;
        xD = s19;
        acS = s20;
        acT = ko6;
        Va = d;
        acU = ko7;
        Vb = d1;
        mName = s21;
        acV = ko8;
        acW = list5;
        acX = s22;
        acY = s23;
        acZ = s24;
        ada = s25;
        adb = ko9;
        adc = s26;
        add = s27;
        ade = s28;
        adf = ko10;
        adg = s29;
        adh = s30;
        qU = s31;
        qV = s32;
        adi = s33;
        adj = s34;
    }

    protected final boolean a(hz.a a1)
    {
        return acp.contains(Integer.valueOf(a1.fI()));
    }

    protected final Object aF(String s)
    {
        return null;
    }

    protected final boolean aG(String s)
    {
        return false;
    }

    protected final Object b(hz.a a1)
    {
        switch (a1.fI())
        {
        case 35: // '#'
        default:
            throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(a1.fI()).toString());

        case 2: // '\002'
            return acq;

        case 3: // '\003'
            return acr;

        case 4: // '\004'
            return acs;

        case 5: // '\005'
            return act;

        case 6: // '\006'
            return acu;

        case 7: // '\007'
            return acv;

        case 8: // '\b'
            return acw;

        case 9: // '\t'
            return Integer.valueOf(acx);

        case 10: // '\n'
            return acy;

        case 11: // '\013'
            return acz;

        case 12: // '\f'
            return acA;

        case 13: // '\r'
            return acB;

        case 14: // '\016'
            return acC;

        case 15: // '\017'
            return acD;

        case 16: // '\020'
            return acE;

        case 17: // '\021'
            return acF;

        case 18: // '\022'
            return mi;

        case 19: // '\023'
            return acG;

        case 20: // '\024'
            return acH;

        case 21: // '\025'
            return acI;

        case 22: // '\026'
            return acJ;

        case 23: // '\027'
            return Mm;

        case 24: // '\030'
            return acK;

        case 25: // '\031'
            return acL;

        case 26: // '\032'
            return acM;

        case 27: // '\033'
            return acN;

        case 28: // '\034'
            return acO;

        case 29: // '\035'
            return acP;

        case 30: // '\036'
            return acQ;

        case 31: // '\037'
            return acR;

        case 32: // ' '
            return xD;

        case 33: // '!'
            return acS;

        case 34: // '"'
            return acT;

        case 36: // '$'
            return Double.valueOf(Va);

        case 37: // '%'
            return acU;

        case 38: // '&'
            return Double.valueOf(Vb);

        case 39: // '\''
            return mName;

        case 40: // '('
            return acV;

        case 41: // ')'
            return acW;

        case 42: // '*'
            return acX;

        case 43: // '+'
            return acY;

        case 44: // ','
            return acZ;

        case 45: // '-'
            return ada;

        case 46: // '.'
            return adb;

        case 47: // '/'
            return adc;

        case 48: // '0'
            return add;

        case 49: // '1'
            return ade;

        case 50: // '2'
            return adf;

        case 51: // '3'
            return adg;

        case 52: // '4'
            return adh;

        case 53: // '5'
            return qU;

        case 54: // '6'
            return qV;

        case 55: // '7'
            return adi;

        case 56: // '8'
            return adj;
        }
    }

    public final int describeContents()
    {
        kp _tmp = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof ko))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            ko ko1 = (ko)obj;
            hz.a a1;
label1:
            do
            {
                for (Iterator iterator = aco.values().iterator(); iterator.hasNext();)
                {
                    a1 = (hz.a)iterator.next();
                    if (!a(a1))
                    {
                        continue label1;
                    }
                    if (ko1.a(a1))
                    {
                        if (!b(a1).equals(ko1.b(a1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!ko1.a(a1));
            return false;
        }
        return true;
    }

    public final HashMap fB()
    {
        return aco;
    }

    public final Object freeze()
    {
        return kv();
    }

    public final ItemScope getAbout()
    {
        return acq;
    }

    public final List getAdditionalName()
    {
        return acr;
    }

    public final ItemScope getAddress()
    {
        return acs;
    }

    public final String getAddressCountry()
    {
        return act;
    }

    public final String getAddressLocality()
    {
        return acu;
    }

    public final String getAddressRegion()
    {
        return acv;
    }

    public final List getAssociated_media()
    {
        return (ArrayList)acw;
    }

    public final int getAttendeeCount()
    {
        return acx;
    }

    public final List getAttendees()
    {
        return (ArrayList)acy;
    }

    public final ItemScope getAudio()
    {
        return acz;
    }

    public final List getAuthor()
    {
        return (ArrayList)acA;
    }

    public final String getBestRating()
    {
        return acB;
    }

    public final String getBirthDate()
    {
        return acC;
    }

    public final ItemScope getByArtist()
    {
        return acD;
    }

    public final String getCaption()
    {
        return acE;
    }

    public final String getContentSize()
    {
        return acF;
    }

    public final String getContentUrl()
    {
        return mi;
    }

    public final List getContributor()
    {
        return (ArrayList)acG;
    }

    public final String getDateCreated()
    {
        return acH;
    }

    public final String getDateModified()
    {
        return acI;
    }

    public final String getDatePublished()
    {
        return acJ;
    }

    public final String getDescription()
    {
        return Mm;
    }

    public final String getDuration()
    {
        return acK;
    }

    public final String getEmbedUrl()
    {
        return acL;
    }

    public final String getEndDate()
    {
        return acM;
    }

    public final String getFamilyName()
    {
        return acN;
    }

    public final String getGender()
    {
        return acO;
    }

    public final ItemScope getGeo()
    {
        return acP;
    }

    public final String getGivenName()
    {
        return acQ;
    }

    public final String getHeight()
    {
        return acR;
    }

    public final String getId()
    {
        return xD;
    }

    public final String getImage()
    {
        return acS;
    }

    public final ItemScope getInAlbum()
    {
        return acT;
    }

    public final double getLatitude()
    {
        return Va;
    }

    public final ItemScope getLocation()
    {
        return acU;
    }

    public final double getLongitude()
    {
        return Vb;
    }

    public final String getName()
    {
        return mName;
    }

    public final ItemScope getPartOfTVSeries()
    {
        return acV;
    }

    public final List getPerformers()
    {
        return (ArrayList)acW;
    }

    public final String getPlayerType()
    {
        return acX;
    }

    public final String getPostOfficeBoxNumber()
    {
        return acY;
    }

    public final String getPostalCode()
    {
        return acZ;
    }

    public final String getRatingValue()
    {
        return ada;
    }

    public final ItemScope getReviewRating()
    {
        return adb;
    }

    public final String getStartDate()
    {
        return adc;
    }

    public final String getStreetAddress()
    {
        return add;
    }

    public final String getText()
    {
        return ade;
    }

    public final ItemScope getThumbnail()
    {
        return adf;
    }

    public final String getThumbnailUrl()
    {
        return adg;
    }

    public final String getTickerSymbol()
    {
        return adh;
    }

    public final String getType()
    {
        return qU;
    }

    public final String getUrl()
    {
        return qV;
    }

    final int getVersionCode()
    {
        return xJ;
    }

    public final String getWidth()
    {
        return adi;
    }

    public final String getWorstRating()
    {
        return adj;
    }

    public final boolean hasAbout()
    {
        return acp.contains(Integer.valueOf(2));
    }

    public final boolean hasAdditionalName()
    {
        return acp.contains(Integer.valueOf(3));
    }

    public final boolean hasAddress()
    {
        return acp.contains(Integer.valueOf(4));
    }

    public final boolean hasAddressCountry()
    {
        return acp.contains(Integer.valueOf(5));
    }

    public final boolean hasAddressLocality()
    {
        return acp.contains(Integer.valueOf(6));
    }

    public final boolean hasAddressRegion()
    {
        return acp.contains(Integer.valueOf(7));
    }

    public final boolean hasAssociated_media()
    {
        return acp.contains(Integer.valueOf(8));
    }

    public final boolean hasAttendeeCount()
    {
        return acp.contains(Integer.valueOf(9));
    }

    public final boolean hasAttendees()
    {
        return acp.contains(Integer.valueOf(10));
    }

    public final boolean hasAudio()
    {
        return acp.contains(Integer.valueOf(11));
    }

    public final boolean hasAuthor()
    {
        return acp.contains(Integer.valueOf(12));
    }

    public final boolean hasBestRating()
    {
        return acp.contains(Integer.valueOf(13));
    }

    public final boolean hasBirthDate()
    {
        return acp.contains(Integer.valueOf(14));
    }

    public final boolean hasByArtist()
    {
        return acp.contains(Integer.valueOf(15));
    }

    public final boolean hasCaption()
    {
        return acp.contains(Integer.valueOf(16));
    }

    public final boolean hasContentSize()
    {
        return acp.contains(Integer.valueOf(17));
    }

    public final boolean hasContentUrl()
    {
        return acp.contains(Integer.valueOf(18));
    }

    public final boolean hasContributor()
    {
        return acp.contains(Integer.valueOf(19));
    }

    public final boolean hasDateCreated()
    {
        return acp.contains(Integer.valueOf(20));
    }

    public final boolean hasDateModified()
    {
        return acp.contains(Integer.valueOf(21));
    }

    public final boolean hasDatePublished()
    {
        return acp.contains(Integer.valueOf(22));
    }

    public final boolean hasDescription()
    {
        return acp.contains(Integer.valueOf(23));
    }

    public final boolean hasDuration()
    {
        return acp.contains(Integer.valueOf(24));
    }

    public final boolean hasEmbedUrl()
    {
        return acp.contains(Integer.valueOf(25));
    }

    public final boolean hasEndDate()
    {
        return acp.contains(Integer.valueOf(26));
    }

    public final boolean hasFamilyName()
    {
        return acp.contains(Integer.valueOf(27));
    }

    public final boolean hasGender()
    {
        return acp.contains(Integer.valueOf(28));
    }

    public final boolean hasGeo()
    {
        return acp.contains(Integer.valueOf(29));
    }

    public final boolean hasGivenName()
    {
        return acp.contains(Integer.valueOf(30));
    }

    public final boolean hasHeight()
    {
        return acp.contains(Integer.valueOf(31));
    }

    public final boolean hasId()
    {
        return acp.contains(Integer.valueOf(32));
    }

    public final boolean hasImage()
    {
        return acp.contains(Integer.valueOf(33));
    }

    public final boolean hasInAlbum()
    {
        return acp.contains(Integer.valueOf(34));
    }

    public final boolean hasLatitude()
    {
        return acp.contains(Integer.valueOf(36));
    }

    public final boolean hasLocation()
    {
        return acp.contains(Integer.valueOf(37));
    }

    public final boolean hasLongitude()
    {
        return acp.contains(Integer.valueOf(38));
    }

    public final boolean hasName()
    {
        return acp.contains(Integer.valueOf(39));
    }

    public final boolean hasPartOfTVSeries()
    {
        return acp.contains(Integer.valueOf(40));
    }

    public final boolean hasPerformers()
    {
        return acp.contains(Integer.valueOf(41));
    }

    public final boolean hasPlayerType()
    {
        return acp.contains(Integer.valueOf(42));
    }

    public final boolean hasPostOfficeBoxNumber()
    {
        return acp.contains(Integer.valueOf(43));
    }

    public final boolean hasPostalCode()
    {
        return acp.contains(Integer.valueOf(44));
    }

    public final boolean hasRatingValue()
    {
        return acp.contains(Integer.valueOf(45));
    }

    public final boolean hasReviewRating()
    {
        return acp.contains(Integer.valueOf(46));
    }

    public final boolean hasStartDate()
    {
        return acp.contains(Integer.valueOf(47));
    }

    public final boolean hasStreetAddress()
    {
        return acp.contains(Integer.valueOf(48));
    }

    public final boolean hasText()
    {
        return acp.contains(Integer.valueOf(49));
    }

    public final boolean hasThumbnail()
    {
        return acp.contains(Integer.valueOf(50));
    }

    public final boolean hasThumbnailUrl()
    {
        return acp.contains(Integer.valueOf(51));
    }

    public final boolean hasTickerSymbol()
    {
        return acp.contains(Integer.valueOf(52));
    }

    public final boolean hasType()
    {
        return acp.contains(Integer.valueOf(53));
    }

    public final boolean hasUrl()
    {
        return acp.contains(Integer.valueOf(54));
    }

    public final boolean hasWidth()
    {
        return acp.contains(Integer.valueOf(55));
    }

    public final boolean hasWorstRating()
    {
        return acp.contains(Integer.valueOf(56));
    }

    public final int hashCode()
    {
        Iterator iterator = aco.values().iterator();
        int i = 0;
        while (iterator.hasNext()) 
        {
            hz.a a1 = (hz.a)iterator.next();
            int j;
            if (a(a1))
            {
                j = i + a1.fI() + b(a1).hashCode();
            } else
            {
                j = i;
            }
            i = j;
        }
        return i;
    }

    public final boolean isDataValid()
    {
        return true;
    }

    final Set kf()
    {
        return acp;
    }

    final ko kg()
    {
        return acq;
    }

    final ko kh()
    {
        return acs;
    }

    final List ki()
    {
        return acw;
    }

    final List kj()
    {
        return acy;
    }

    final ko kk()
    {
        return acz;
    }

    final List kl()
    {
        return acA;
    }

    final ko km()
    {
        return acD;
    }

    final List kn()
    {
        return acG;
    }

    final ko ko()
    {
        return acP;
    }

    final ko kp()
    {
        return acT;
    }

    final ko kq()
    {
        return acU;
    }

    final ko kr()
    {
        return acV;
    }

    final List ks()
    {
        return acW;
    }

    final ko kt()
    {
        return adb;
    }

    final ko ku()
    {
        return adf;
    }

    public final ko kv()
    {
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        kp _tmp = CREATOR;
        com.google.android.gms.internal.kp.a(this, parcel, i);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        aco = hashmap;
        hashmap.put("about", hz.a.a("about", 2, com/google/android/gms/internal/ko));
        aco.put("additionalName", hz.a.k("additionalName", 3));
        aco.put("address", hz.a.a("address", 4, com/google/android/gms/internal/ko));
        aco.put("addressCountry", hz.a.j("addressCountry", 5));
        aco.put("addressLocality", hz.a.j("addressLocality", 6));
        aco.put("addressRegion", hz.a.j("addressRegion", 7));
        aco.put("associated_media", hz.a.b("associated_media", 8, com/google/android/gms/internal/ko));
        aco.put("attendeeCount", hz.a.g("attendeeCount", 9));
        aco.put("attendees", hz.a.b("attendees", 10, com/google/android/gms/internal/ko));
        aco.put("audio", hz.a.a("audio", 11, com/google/android/gms/internal/ko));
        aco.put("author", hz.a.b("author", 12, com/google/android/gms/internal/ko));
        aco.put("bestRating", hz.a.j("bestRating", 13));
        aco.put("birthDate", hz.a.j("birthDate", 14));
        aco.put("byArtist", hz.a.a("byArtist", 15, com/google/android/gms/internal/ko));
        aco.put("caption", hz.a.j("caption", 16));
        aco.put("contentSize", hz.a.j("contentSize", 17));
        aco.put("contentUrl", hz.a.j("contentUrl", 18));
        aco.put("contributor", hz.a.b("contributor", 19, com/google/android/gms/internal/ko));
        aco.put("dateCreated", hz.a.j("dateCreated", 20));
        aco.put("dateModified", hz.a.j("dateModified", 21));
        aco.put("datePublished", hz.a.j("datePublished", 22));
        aco.put("description", hz.a.j("description", 23));
        aco.put("duration", hz.a.j("duration", 24));
        aco.put("embedUrl", hz.a.j("embedUrl", 25));
        aco.put("endDate", hz.a.j("endDate", 26));
        aco.put("familyName", hz.a.j("familyName", 27));
        aco.put("gender", hz.a.j("gender", 28));
        aco.put("geo", hz.a.a("geo", 29, com/google/android/gms/internal/ko));
        aco.put("givenName", hz.a.j("givenName", 30));
        aco.put("height", hz.a.j("height", 31));
        aco.put("id", hz.a.j("id", 32));
        aco.put("image", hz.a.j("image", 33));
        aco.put("inAlbum", hz.a.a("inAlbum", 34, com/google/android/gms/internal/ko));
        aco.put("latitude", hz.a.h("latitude", 36));
        aco.put("location", hz.a.a("location", 37, com/google/android/gms/internal/ko));
        aco.put("longitude", hz.a.h("longitude", 38));
        aco.put("name", hz.a.j("name", 39));
        aco.put("partOfTVSeries", hz.a.a("partOfTVSeries", 40, com/google/android/gms/internal/ko));
        aco.put("performers", hz.a.b("performers", 41, com/google/android/gms/internal/ko));
        aco.put("playerType", hz.a.j("playerType", 42));
        aco.put("postOfficeBoxNumber", hz.a.j("postOfficeBoxNumber", 43));
        aco.put("postalCode", hz.a.j("postalCode", 44));
        aco.put("ratingValue", hz.a.j("ratingValue", 45));
        aco.put("reviewRating", hz.a.a("reviewRating", 46, com/google/android/gms/internal/ko));
        aco.put("startDate", hz.a.j("startDate", 47));
        aco.put("streetAddress", hz.a.j("streetAddress", 48));
        aco.put("text", hz.a.j("text", 49));
        aco.put("thumbnail", hz.a.a("thumbnail", 50, com/google/android/gms/internal/ko));
        aco.put("thumbnailUrl", hz.a.j("thumbnailUrl", 51));
        aco.put("tickerSymbol", hz.a.j("tickerSymbol", 52));
        aco.put("type", hz.a.j("type", 53));
        aco.put("url", hz.a.j("url", 54));
        aco.put("width", hz.a.j("width", 55));
        aco.put("worstRating", hz.a.j("worstRating", 56));
    }
}
