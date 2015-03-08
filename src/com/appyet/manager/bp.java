// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import com.appyet.a.a.d;
import com.appyet.context.ApplicationContext;
import com.appyet.context.b;
import com.appyet.context.c;
import com.appyet.context.e;
import com.appyet.f.o;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataSetting;
import com.appyet.metadata.MetadataTheme;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.appyet.manager:
//            bw

public final class bp
{

    private static String b = "y<6+R&A!;sD2v}h";
    private ApplicationContext a;

    public bp(ApplicationContext applicationcontext)
    {
        a = applicationcontext;
    }

    public final int A()
    {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_DISPLAY_SKIPIMAGESIZEV3", "1500"));
    }

    public final int B()
    {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_DISPLAY_SKIPIMAGEDIMENSIONV3", "100"));
    }

    public final int C()
    {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_DISPLAY_SKIPIMAGETHUMBNAILDIMENSIONV3", "60"));
    }

    public final int D()
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(a);
        if ((0xf & a.getResources().getConfiguration().screenLayout) == 3)
        {
            return Integer.parseInt(sharedpreferences.getString("SETTINGS_DISPLAY_THUMBNAILDIMENSIONV3", "85"));
        }
        if ((0xf & a.getResources().getConfiguration().screenLayout) == 4)
        {
            return Integer.parseInt(sharedpreferences.getString("SETTINGS_DISPLAY_THUMBNAILDIMENSIONV3", "100"));
        } else
        {
            return Integer.parseInt(sharedpreferences.getString("SETTINGS_DISPLAY_THUMBNAILDIMENSIONV3", "75"));
        }
    }

    public final c E()
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(a);
        if (sharedpreferences.getString("SETTINGS_DISPLAY_ARTICLELISTITEMLAYOUTV3", "CLASSIC_RICH").equals("CLASSIC_RICH"))
        {
            return c.a;
        }
        if (sharedpreferences.getString("SETTINGS_DISPLAY_ARTICLELISTITEMLAYOUTV3", "CLASSIC_RICH").equals("CLASSIC_SIMPLE"))
        {
            return c.b;
        } else
        {
            return c.a;
        }
    }

    public final String F()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_DISPLAY_CURRENTTHEMEGUID", a.q.MetadataSetting.DefaultThemeGuid);
    }

    public final int G()
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(a);
        int i1;
        if (a.m.a.PrimaryBgColor.equals("DARK"))
        {
            i1 = a.getResources().getColor(0x7f090041);
        } else
        {
            i1 = a.getResources().getColor(0x7f090043);
        }
        return sharedpreferences.getInt("SETTINGS_DISPLAY_FONTCOLOR_PRIMARYV3", i1);
    }

    public final int H()
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(a);
        int i1;
        if (a.m.a.PrimaryBgColor.equals("DARK"))
        {
            i1 = a.getResources().getColor(0x7f090042);
        } else
        {
            i1 = a.getResources().getColor(0x7f090044);
        }
        return sharedpreferences.getInt("SETTINGS_DISPLAY_FONTCOLOR_SECONDARYV3", i1);
    }

    public final boolean I()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_DISPLAY_CONFIRMBULKACTIONSV3", true);
    }

    public final int J()
    {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_TRANSLATE_LANGUAGEV3", "16"));
    }

    public final int K()
    {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_DISPLAY_ARTICLE_FONTSIZEV3", "2"));
    }

    public final boolean L()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_MEDIA_REACT_TO_HEADSETV3", false);
    }

    public final boolean M()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_MEDIA_PAUSE_HEADSET_DISCONNECTEDV3", true);
    }

    public final boolean N()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_MEDIA_PAUSE_POWER_REMOVALV3", false);
    }

    public final boolean O()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_UPDATES_UPDATE_ON_STARTUPV3", false);
    }

    public final int P()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getInt("APPLICATION_LAST_VERSION_CODEV3", -1);
    }

    public final long Q()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getLong("APPLICATION_LAST_MODULE_IDV3", -1L);
    }

    public final int R()
    {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_DISPLAY_DOWNLOAD_FILE_SORT_BYV3", "0"));
    }

    public final boolean S()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("USER_LEARNED_LEFTMENUV3", false);
    }

    public final void T()
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putBoolean("USER_LEARNED_LEFTMENUV3", true);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final int U()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getInt("STATISTIC_READ_ARTICLE_COUNT3", 0);
    }

    public final boolean V()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("HAS_RATTING_REMINDER_SHOWN3", false);
    }

    public final void W()
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putBoolean("HAS_RATTING_REMINDER_SHOWN3", true);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final int X()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getInt("NEW_ARTICLE_COUNT3", 0);
    }

    public final long a()
    {
        long l1 = PreferenceManager.getDefaultSharedPreferences(a).getLong("SETTING_LASTCLEARCACHEV3", 0L);
        if (l1 == 0L)
        {
            Date date = new Date();
            a(date.getTime());
            l1 = date.getTime();
        }
        return l1;
    }

    public final String a(d d1)
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getString((new StringBuilder("SETTINGS_FORUMSITE_USERNAME_")).append(d1.c).toString(), null);
    }

    public final void a(int i1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putInt("SETTINGS_DISPLAY_SORTARTICLEBYV3", i1);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void a(long l1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putLong("SETTING_LASTCLEARCACHEV3", l1);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void a(d d1, String s1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putString((new StringBuilder("SETTINGS_FORUMSITE_USERNAME_")).append(d1.c).toString(), s1);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void a(String s1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putString("SETTINGS_DISPLAY_LANGUAGEV3", s1);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void a(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putBoolean("SETTINGS_DISPLAY_AUTO_HIDE_READV3", flag);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final String b(d d1)
    {
        String s1;
        try
        {
            s1 = (new o(b)).a(PreferenceManager.getDefaultSharedPreferences(a).getString((new StringBuilder("SETTINGS_FORUMSITE_Password_")).append(d1.c).toString(), null));
        }
        catch (Exception exception)
        {
            return null;
        }
        return s1;
    }

    public final void b(int i1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putString("SETTINGS_UPDATES_UPDATEINTERVALV3", String.valueOf(i1));
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void b(long l1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putLong("SETTING_LASTSYNCV3", l1);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void b(d d1, String s1)
    {
        o o1 = new o(b);
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putString((new StringBuilder("SETTINGS_FORUMSITE_Password_")).append(d1.c).toString(), o1.b(s1));
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void b(String s1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putString("SETTINGS_DISPLAY_CURRENTTHEMEGUID", s1);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void b(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putBoolean("SETTINGS_UPDATES_WIFIONLYV3", flag);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final boolean b()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_DISPLAY_KEEPSTARREDUNREADV3", false);
    }

    public final void c(int i1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putString("SETTINGS_MESSAGE_AUTO_CLEANUP_READV3", String.valueOf(i1));
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void c(long l1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putLong("APPLICATION_LAST_MODULE_IDV3", l1);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void c(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putBoolean("SETTINGS_UPDATES_WIFIONLY_IMAGEV3", flag);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final boolean c()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_DISPLAY_AUTO_HIDE_READV3", false);
    }

    public final void d(int i1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putString("SETTINGS_MESSAGE_AUTO_CLEANUP_UNREADV3", String.valueOf(i1));
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void d(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putBoolean("SETTINGS_UPDATES_WIFIONLY_PODCASTV3", flag);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final boolean d()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_DISPLAY_KEEPSTARTOPV3", false);
    }

    public final int e()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getInt("SETTINGS_DISPLAY_SORTARTICLEBYV3", 3);
    }

    public final void e(int i1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putString("SETTINGS_TRANSLATE_LANGUAGEV3", String.valueOf(i1));
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void e(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putBoolean("SETTINGS_UPDATES_AUTOV3", flag);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final e f()
    {
        switch (PreferenceManager.getDefaultSharedPreferences(a).getInt("SETTINGS_DISPLAY_SORTARTICLEBYV3", 3))
        {
        default:
            return e.d;

        case 0: // '\0'
            return e.a;

        case 1: // '\001'
            return e.b;

        case 2: // '\002'
            return e.c;

        case 3: // '\003'
            return e.d;

        case 4: // '\004'
            return e.e;

        case 5: // '\005'
            return e.f;

        case 6: // '\006'
            return e.g;
        }
    }

    public final void f(int i1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putString("SETTINGS_DISPLAY_ARTICLE_FONTSIZEV3", String.valueOf(i1));
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void f(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putBoolean("SETTINGS_UPDATES_UPDATE_ON_STARTUPV3", flag);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final String g()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_ADVANCED_USERAGENTV3", "");
    }

    public final void g(int i1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putInt("APPLICATION_LAST_VERSION_CODEV3", i1);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final void h(int i1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putString("SETTINGS_DISPLAY_DOWNLOAD_FILE_SORT_BYV3", String.valueOf(i1));
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final boolean h()
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(a);
        boolean flag;
        if (a.q.MetadataSetting.DefaultUpdateInterval != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return sharedpreferences.getBoolean("SETTINGS_UPDATES_AUTOV3", flag);
    }

    public final int i()
    {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_MESSAGE_CLEARCACHEINTERVALV3", String.valueOf(2)));
    }

    public final void i(int i1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putInt("STATISTIC_READ_ARTICLE_COUNT3", i1);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final String j()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_DISPLAY_DATETIMEFORMATV3", "");
    }

    public final void j(int i1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a).edit();
        editor.putInt("NEW_ARTICLE_COUNT3", i1);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
        }
        editor.commit();
    }

    public final long k()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getLong("SETTING_LASTSYNCV3", 0L);
    }

    public final int l()
    {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_UPDATES_UPDATEINTERVALV3", String.valueOf(a.q.MetadataSetting.DefaultUpdateInterval)));
    }

    public final boolean m()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_UPDATES_WIFIONLYV3", false);
    }

    public final boolean n()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_NOTIFICATIONS_NOTIFICATIONV3", true);
    }

    public final boolean o()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_NOTIFICATIONS_PROGRESSV3", false);
    }

    public final String p()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_NOTIFICATIONS_RINGTONEV3", "");
    }

    public final String q()
    {
        SharedPreferences sharedpreferences;
        String s1;
        String s2;
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(a);
        s1 = Locale.getDefault().getLanguage();
        s2 = Locale.getDefault().getCountry();
        if (s1 == null || s2 == null) goto _L2; else goto _L1
_L1:
        if (!s1.equalsIgnoreCase("zh")) goto _L4; else goto _L3
_L3:
        if (!s2.equalsIgnoreCase("HK")) goto _L6; else goto _L5
_L5:
        s2 = "TW";
_L7:
        return sharedpreferences.getString("SETTINGS_DISPLAY_LANGUAGEV3", (new StringBuilder()).append(s1).append("_").append(s2).toString());
_L6:
        if (s2.equalsIgnoreCase("SG"))
        {
            s2 = "CN";
        } else
        if (!s2.equalsIgnoreCase("CN") && !s2.equalsIgnoreCase("TW"))
        {
            s2 = "CN";
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (s1.equalsIgnoreCase("sr"))
        {
            if (s2.equalsIgnoreCase("BA"))
            {
                s2 = "ME";
            } else
            if (!s2.equalsIgnoreCase("RS") && !s2.equalsIgnoreCase("ME"))
            {
                s2 = "RS";
            }
        }
        if (true) goto _L7; else goto _L2
_L2:
        return sharedpreferences.getString("SETTINGS_DISPLAY_LANGUAGEV3", s1);
    }

    public final boolean r()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_UPDATES_WIFIONLY_IMAGEV3", false);
    }

    public final boolean s()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_UPDATES_WIFIONLY_PODCASTV3", false);
    }

    public final boolean t()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_MESSAGE_SDCARDFORSTORAGEV3", true);
    }

    public final boolean u()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_NOTIFICATIONS_VIBRATEV3", false);
    }

    public final boolean v()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_NOTIFICATIONS_FLASHLIGHTV3", false);
    }

    public final int w()
    {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_MESSAGE_AUTO_CLEANUP_READV3", String.valueOf(a.q.MetadataSetting.AutoCleanUpRead)));
    }

    public final boolean x()
    {
        return PreferenceManager.getDefaultSharedPreferences(a).getBoolean("SETTINGS_MESSAGE_AUTO_CLEANUP_KEEP_STARV3", true);
    }

    public final int y()
    {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_MESSAGE_AUTO_CLEANUP_UNREADV3", String.valueOf(a.q.MetadataSetting.AutoCleanUpUnread)));
    }

    public final b z()
    {
        if (PreferenceManager.getDefaultSharedPreferences(a).getString("SETTINGS_PLAYLIST_SHUFFLEV3", "INSTAPAPER_MOBILIZER").equals("GOOGLE_MOBILIZER"))
        {
            return b.b;
        } else
        {
            return b.a;
        }
    }

}
