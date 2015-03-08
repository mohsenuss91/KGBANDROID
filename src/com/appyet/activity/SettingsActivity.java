// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.provider.SearchRecentSuggestions;
import android.util.DisplayMetrics;
import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.manager.bp;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataApplication;
import com.appyet.metadata.MetadataLanguage;
import com.appyet.metadata.MetadataSetting;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.appyet.activity:
//            z, aa, AboutActivity, WebBrowserActivity

public class SettingsActivity extends SherlockPreferenceActivity
{

    private PreferenceScreen a;
    private PreferenceScreen b;
    private PreferenceScreen c;
    private PreferenceScreen d;
    private ApplicationContext e;

    public SettingsActivity()
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        ar.a(this);
    }

    protected void onCreate(Bundle bundle)
    {
        e = (ApplicationContext)getApplicationContext();
        super.onCreate(bundle);
        addPreferencesFromResource(0x7f050003);
        a = (PreferenceScreen)findPreference("SETTINGS_ABOUT");
        b = (PreferenceScreen)findPreference("SETTINGS_FEEDBACK");
        if (e.q.MetadataSetting.FeedbackEmail == null || e.q.MetadataSetting.FeedbackEmail.trim().equals(""))
        {
            ((PreferenceScreen)findPreference("SETTING_ROOT")).removePreference(b);
        }
        c = (PreferenceScreen)findPreference("SETTINGS_HELP");
        if (e.q.MetadataSetting.HelpLink == null || e.q.MetadataSetting.HelpLink.trim().equals(""))
        {
            ((PreferenceScreen)findPreference("SETTING_ROOT")).removePreference(c);
        }
        d = (PreferenceScreen)findPreference("SETTINGS_CLEARSEARCHHISTORY");
        ListPreference listpreference = (ListPreference)findPreference("SETTINGS_DISPLAY_LANGUAGEV3");
        String as[] = new String[e.q.MetadataLanguages.size()];
        String as1[] = new String[e.q.MetadataLanguages.size()];
        Iterator iterator = e.q.MetadataLanguages.iterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            MetadataLanguage metadatalanguage = (MetadataLanguage)iterator.next();
            as[i] = metadatalanguage.Name;
            as1[i] = metadatalanguage.LocaleCode;
        }

        listpreference.setEntries(as);
        listpreference.setEntryValues(as1);
        findPreference("SETTINGS_UPDATES_UPDATEINTERVALV3").setEnabled(e.d.h());
        findPreference("SETTINGS_UPDATES_AUTOV3").setOnPreferenceChangeListener(new z(this));
        findPreference("SETTINGS_NOTIFICATIONS_RINGTONEV3").setEnabled(e.d.n());
        findPreference("SETTINGS_NOTIFICATIONS_VIBRATEV3").setEnabled(e.d.n());
        findPreference("SETTINGS_NOTIFICATIONS_FLASHLIGHTV3").setEnabled(e.d.n());
        findPreference("SETTINGS_NOTIFICATIONS_NOTIFICATIONV3").setOnPreferenceChangeListener(new aa(this));
        e.e.a("Settings");
    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferencescreen, Preference preference)
    {
        if (preference != a) goto _L2; else goto _L1
_L1:
        startActivityForResult(new Intent(this, com/appyet/activity/AboutActivity), 0);
_L5:
        return super.onPreferenceTreeClick(preferencescreen, preference);
_L2:
        if (preference != b) goto _L4; else goto _L3
_L3:
        PackageManager packagemanager = getPackageManager();
        PackageInfo packageinfo1 = packagemanager.getPackageInfo(getPackageName(), 0);
        PackageInfo packageinfo = packageinfo1;
_L6:
        String s1;
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss_zzz");
        String s = (new StringBuilder()).append("\n\n\n-------- Environment --------\n").append("Time\t= ").append(simpledateformat.format(date)).append("\n").toString();
        s1 = (new StringBuilder()).append(s).append("Device\t= ").append(Build.FINGERPRINT).append("\n").toString();
        String s9;
        Field field = android/os/Build.getField("MANUFACTURER");
        s9 = (new StringBuilder()).append(s1).append("Make\t=").append(field.get(null)).append("\n").toString();
        s1 = s9;
_L7:
        String s2 = (new StringBuilder()).append(s1).append("Model\t= ").append(Build.MODEL).append("\n").toString();
        String s3 = (new StringBuilder()).append(s2).append("Product\t= ").append(Build.PRODUCT).append("\n").toString();
        String s4 = (new StringBuilder()).append(s3).append("App\t\t= ").append(getPackageName()).append(", version ").append(packageinfo.versionName).append(" (build ").append(packageinfo.versionCode).append(")\n").toString();
        String s5 = (new StringBuilder()).append(s4).append("Locale\t= ").append(getResources().getConfiguration().locale.getDisplayName()).append("\n").toString();
        String s6 = (new StringBuilder()).append(s5).append("Res\t\t= ").append(getResources().getDisplayMetrics().toString()).append("\n").toString();
        String s7 = (new StringBuilder()).append(s6).append("Source Version Name: ").append(e.q.MetadataApplication.BuildTemplateVersionName).append("\n").toString();
        String s8 = (new StringBuilder()).append(s7).append("-----------------------------\n\n").toString();
        Intent intent1 = new Intent("android.intent.action.SEND");
        intent1.setType("plain/text");
        String as[] = new String[1];
        as[0] = e.q.MetadataSetting.FeedbackEmail;
        intent1.putExtra("android.intent.extra.EMAIL", as);
        intent1.putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append(getString(0x7f080116)).append(" (").append(e.b()).append(") ").append(getString(0x7f0800ae)).toString());
        intent1.putExtra("android.intent.extra.TEXT", s8);
        startActivity(Intent.createChooser(intent1, getString(0x7f0800ae)));
          goto _L5
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        packageinfo = new PackageInfo();
        packageinfo.versionName = "unknown";
        packageinfo.versionCode = 69;
          goto _L6
_L4:
        if (preference == c)
        {
            Intent intent = new Intent(e, com/appyet/activity/WebBrowserActivity);
            intent.putExtra("URL", e.q.MetadataSetting.HelpLink);
            e.startActivity(intent);
        } else
        if (preference == d)
        {
            (new SearchRecentSuggestions(this, (new StringBuilder()).append(e.getPackageName()).append(".suggestion.provider").toString(), 1)).clearHistory();
            d.setEnabled(false);
        }
          goto _L5
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
          goto _L7
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
          goto _L7
        NoSuchFieldException nosuchfieldexception;
        nosuchfieldexception;
          goto _L7
        SecurityException securityexception;
        securityexception;
          goto _L7
    }

    protected void onResume()
    {
        ar.a(this);
        super.onResume();
    }
}
