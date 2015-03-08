// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.preference.Preference;

// Referenced classes of package com.appyet.activity:
//            SettingsActivity

final class z
    implements android.preference.Preference.OnPreferenceChangeListener
{

    final SettingsActivity a;

    z(SettingsActivity settingsactivity)
    {
        a = settingsactivity;
        super();
    }

    public final boolean onPreferenceChange(Preference preference, Object obj)
    {
        a.findPreference("SETTINGS_UPDATES_UPDATEINTERVALV3").setEnabled(((Boolean)obj).booleanValue());
        return true;
    }
}
