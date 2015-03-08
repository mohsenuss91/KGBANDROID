// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            hz, ku, hw

public final class kt extends hz
    implements SafeParcelable, Person
{

    public static final ku CREATOR = new ku();
    private static final HashMap aco;
    private String Ao;
    private String Lk;
    private final Set acp;
    private List adA;
    private int adB;
    private int adC;
    private String adD;
    private List adE;
    private boolean adF;
    private String adn;
    private a ado;
    private String adp;
    private String adq;
    private int adr;
    private b ads;
    private String adt;
    private c adu;
    private boolean adv;
    private d adw;
    private String adx;
    private int ady;
    private List adz;
    private int mj;
    private String qV;
    private String xD;
    private final int xJ;

    public kt()
    {
        xJ = 2;
        acp = new HashSet();
    }

    public kt(String s, String s1, c c, int j, String s2)
    {
        xJ = 2;
        acp = new HashSet();
        Lk = s;
        acp.add(Integer.valueOf(9));
        xD = s1;
        acp.add(Integer.valueOf(14));
        adu = c;
        acp.add(Integer.valueOf(15));
        ady = j;
        acp.add(Integer.valueOf(21));
        qV = s2;
        acp.add(Integer.valueOf(27));
    }

    kt(Set set, int j, String s, a a1, String s1, String s2, int k, 
            b b1, String s3, String s4, int l, String s5, c c, boolean flag, 
            String s6, d d, String s7, int i1, List list, List list1, int j1, 
            int k1, String s8, String s9, List list2, boolean flag1)
    {
        acp = set;
        xJ = j;
        adn = s;
        ado = a1;
        adp = s1;
        adq = s2;
        adr = k;
        ads = b1;
        adt = s3;
        Lk = s4;
        mj = l;
        xD = s5;
        adu = c;
        adv = flag;
        Ao = s6;
        adw = d;
        adx = s7;
        ady = i1;
        adz = list;
        adA = list1;
        adB = j1;
        adC = k1;
        adD = s8;
        qV = s9;
        adE = list2;
        adF = flag1;
    }

    public static kt i(byte abyte0[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        kt kt1 = CREATOR.bG(parcel);
        parcel.recycle();
        return kt1;
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
        case 10: // '\n'
        case 11: // '\013'
        case 13: // '\r'
        case 17: // '\021'
        default:
            throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(a1.fI()).toString());

        case 2: // '\002'
            return adn;

        case 3: // '\003'
            return ado;

        case 4: // '\004'
            return adp;

        case 5: // '\005'
            return adq;

        case 6: // '\006'
            return Integer.valueOf(adr);

        case 7: // '\007'
            return ads;

        case 8: // '\b'
            return adt;

        case 9: // '\t'
            return Lk;

        case 12: // '\f'
            return Integer.valueOf(mj);

        case 14: // '\016'
            return xD;

        case 15: // '\017'
            return adu;

        case 16: // '\020'
            return Boolean.valueOf(adv);

        case 18: // '\022'
            return Ao;

        case 19: // '\023'
            return adw;

        case 20: // '\024'
            return adx;

        case 21: // '\025'
            return Integer.valueOf(ady);

        case 22: // '\026'
            return adz;

        case 23: // '\027'
            return adA;

        case 24: // '\030'
            return Integer.valueOf(adB);

        case 25: // '\031'
            return Integer.valueOf(adC);

        case 26: // '\032'
            return adD;

        case 27: // '\033'
            return qV;

        case 28: // '\034'
            return adE;

        case 29: // '\035'
            return Boolean.valueOf(adF);
        }
    }

    public final int describeContents()
    {
        ku _tmp = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof kt))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            kt kt1 = (kt)obj;
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
                    if (kt1.a(a1))
                    {
                        if (!b(a1).equals(kt1.b(a1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!kt1.a(a1));
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
        return kH();
    }

    public final String getAboutMe()
    {
        return adn;
    }

    public final com.google.android.gms.plus.model.people.Person.AgeRange getAgeRange()
    {
        return ado;
    }

    public final String getBirthday()
    {
        return adp;
    }

    public final String getBraggingRights()
    {
        return adq;
    }

    public final int getCircledByCount()
    {
        return adr;
    }

    public final com.google.android.gms.plus.model.people.Person.Cover getCover()
    {
        return ads;
    }

    public final String getCurrentLocation()
    {
        return adt;
    }

    public final String getDisplayName()
    {
        return Lk;
    }

    public final int getGender()
    {
        return mj;
    }

    public final String getId()
    {
        return xD;
    }

    public final com.google.android.gms.plus.model.people.Person.Image getImage()
    {
        return adu;
    }

    public final String getLanguage()
    {
        return Ao;
    }

    public final com.google.android.gms.plus.model.people.Person.Name getName()
    {
        return adw;
    }

    public final String getNickname()
    {
        return adx;
    }

    public final int getObjectType()
    {
        return ady;
    }

    public final List getOrganizations()
    {
        return (ArrayList)adz;
    }

    public final List getPlacesLived()
    {
        return (ArrayList)adA;
    }

    public final int getPlusOneCount()
    {
        return adB;
    }

    public final int getRelationshipStatus()
    {
        return adC;
    }

    public final String getTagline()
    {
        return adD;
    }

    public final String getUrl()
    {
        return qV;
    }

    public final List getUrls()
    {
        return (ArrayList)adE;
    }

    final int getVersionCode()
    {
        return xJ;
    }

    public final boolean hasAboutMe()
    {
        return acp.contains(Integer.valueOf(2));
    }

    public final boolean hasAgeRange()
    {
        return acp.contains(Integer.valueOf(3));
    }

    public final boolean hasBirthday()
    {
        return acp.contains(Integer.valueOf(4));
    }

    public final boolean hasBraggingRights()
    {
        return acp.contains(Integer.valueOf(5));
    }

    public final boolean hasCircledByCount()
    {
        return acp.contains(Integer.valueOf(6));
    }

    public final boolean hasCover()
    {
        return acp.contains(Integer.valueOf(7));
    }

    public final boolean hasCurrentLocation()
    {
        return acp.contains(Integer.valueOf(8));
    }

    public final boolean hasDisplayName()
    {
        return acp.contains(Integer.valueOf(9));
    }

    public final boolean hasGender()
    {
        return acp.contains(Integer.valueOf(12));
    }

    public final boolean hasId()
    {
        return acp.contains(Integer.valueOf(14));
    }

    public final boolean hasImage()
    {
        return acp.contains(Integer.valueOf(15));
    }

    public final boolean hasIsPlusUser()
    {
        return acp.contains(Integer.valueOf(16));
    }

    public final boolean hasLanguage()
    {
        return acp.contains(Integer.valueOf(18));
    }

    public final boolean hasName()
    {
        return acp.contains(Integer.valueOf(19));
    }

    public final boolean hasNickname()
    {
        return acp.contains(Integer.valueOf(20));
    }

    public final boolean hasObjectType()
    {
        return acp.contains(Integer.valueOf(21));
    }

    public final boolean hasOrganizations()
    {
        return acp.contains(Integer.valueOf(22));
    }

    public final boolean hasPlacesLived()
    {
        return acp.contains(Integer.valueOf(23));
    }

    public final boolean hasPlusOneCount()
    {
        return acp.contains(Integer.valueOf(24));
    }

    public final boolean hasRelationshipStatus()
    {
        return acp.contains(Integer.valueOf(25));
    }

    public final boolean hasTagline()
    {
        return acp.contains(Integer.valueOf(26));
    }

    public final boolean hasUrl()
    {
        return acp.contains(Integer.valueOf(27));
    }

    public final boolean hasUrls()
    {
        return acp.contains(Integer.valueOf(28));
    }

    public final boolean hasVerified()
    {
        return acp.contains(Integer.valueOf(29));
    }

    public final int hashCode()
    {
        Iterator iterator = aco.values().iterator();
        int j = 0;
        while (iterator.hasNext()) 
        {
            hz.a a1 = (hz.a)iterator.next();
            int k;
            if (a(a1))
            {
                k = j + a1.fI() + b(a1).hashCode();
            } else
            {
                k = j;
            }
            j = k;
        }
        return j;
    }

    public final boolean isDataValid()
    {
        return true;
    }

    public final boolean isPlusUser()
    {
        return adv;
    }

    public final boolean isVerified()
    {
        return adF;
    }

    final a kA()
    {
        return ado;
    }

    final b kB()
    {
        return ads;
    }

    final c kC()
    {
        return adu;
    }

    final d kD()
    {
        return adw;
    }

    final List kE()
    {
        return adz;
    }

    final List kF()
    {
        return adA;
    }

    final List kG()
    {
        return adE;
    }

    public final kt kH()
    {
        return this;
    }

    final Set kf()
    {
        return acp;
    }

    public final void writeToParcel(Parcel parcel, int j)
    {
        ku _tmp = CREATOR;
        ku.a(this, parcel, j);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        aco = hashmap;
        hashmap.put("aboutMe", hz.a.j("aboutMe", 2));
        aco.put("ageRange", hz.a.a("ageRange", 3, com/google/android/gms/internal/kt$a));
        aco.put("birthday", hz.a.j("birthday", 4));
        aco.put("braggingRights", hz.a.j("braggingRights", 5));
        aco.put("circledByCount", hz.a.g("circledByCount", 6));
        aco.put("cover", hz.a.a("cover", 7, com/google/android/gms/internal/kt$b));
        aco.put("currentLocation", hz.a.j("currentLocation", 8));
        aco.put("displayName", hz.a.j("displayName", 9));
        aco.put("gender", hz.a.a("gender", 12, (new hw()).f("male", 0).f("female", 1).f("other", 2), false));
        aco.put("id", hz.a.j("id", 14));
        aco.put("image", hz.a.a("image", 15, com/google/android/gms/internal/kt$c));
        aco.put("isPlusUser", hz.a.i("isPlusUser", 16));
        aco.put("language", hz.a.j("language", 18));
        aco.put("name", hz.a.a("name", 19, com/google/android/gms/internal/kt$d));
        aco.put("nickname", hz.a.j("nickname", 20));
        aco.put("objectType", hz.a.a("objectType", 21, (new hw()).f("person", 0).f("page", 1), false));
        aco.put("organizations", hz.a.b("organizations", 22, com/google/android/gms/internal/kt$f));
        aco.put("placesLived", hz.a.b("placesLived", 23, com/google/android/gms/internal/kt$g));
        aco.put("plusOneCount", hz.a.g("plusOneCount", 24));
        aco.put("relationshipStatus", hz.a.a("relationshipStatus", 25, (new hw()).f("single", 0).f("in_a_relationship", 1).f("engaged", 2).f("married", 3).f("its_complicated", 4).f("open_relationship", 5).f("widowed", 6).f("in_domestic_partnership", 7).f("in_civil_union", 8), false));
        aco.put("tagline", hz.a.j("tagline", 26));
        aco.put("url", hz.a.j("url", 27));
        aco.put("urls", hz.a.b("urls", 28, com/google/android/gms/internal/kt$h));
        aco.put("verified", hz.a.i("verified", 29));
    }
}
