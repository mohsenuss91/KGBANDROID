// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.a.a;

import android.app.Activity;
import android.content.Context;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockExpandableListActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.app.SherlockPreferenceActivity;
import uk.co.senab.a.b.e;

public final class d
    implements e
{

    public d()
    {
    }

    public final Context a(Activity activity)
    {
        ActionBar actionbar;
        Context context;
        if (activity instanceof SherlockActivity)
        {
            actionbar = ((SherlockActivity)activity).getSupportActionBar();
        } else
        if (activity instanceof SherlockListActivity)
        {
            actionbar = ((SherlockListActivity)activity).getSupportActionBar();
        } else
        if (activity instanceof SherlockFragmentActivity)
        {
            actionbar = ((SherlockFragmentActivity)activity).getSupportActionBar();
        } else
        if (activity instanceof SherlockExpandableListActivity)
        {
            actionbar = ((SherlockExpandableListActivity)activity).getSupportActionBar();
        } else
        if (activity instanceof SherlockPreferenceActivity)
        {
            actionbar = ((SherlockPreferenceActivity)activity).getSupportActionBar();
        } else
        {
            actionbar = null;
        }
        if (actionbar != null)
        {
            context = actionbar.getThemedContext();
        } else
        {
            context = null;
        }
        if (context == null)
        {
            return activity;
        } else
        {
            return context;
        }
    }
}
