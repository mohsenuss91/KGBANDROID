// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.actionbarsherlock.app.SherlockListFragment;
import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataTheme;
import java.util.List;

// Referenced classes of package com.appyet.c:
//            az, bc, ba

public final class ay extends SherlockListFragment
{

    ApplicationContext a;
    MainActivity b;
    List c;
    ba d;
    List e;
    private boolean f;
    private android.widget.AdapterView.OnItemClickListener g;

    public ay()
    {
        e = null;
        f = false;
        g = new az(this);
    }

    static boolean a(ay ay1)
    {
        return ay1.f;
    }

    static boolean b(ay ay1)
    {
        ay1.f = true;
        return true;
    }

    public final void a()
    {
        (new bc(this)).a(new Void[0]);
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        getListView().setBackgroundColor(Color.parseColor(a.m.a.LeftMenuBgColor));
        getListView().setCacheColorHint(0);
        d = new ba(this, getActivity());
        getListView().setDividerHeight(0);
        getListView().setOnItemClickListener(g);
        a();
    }

    public final void onCreate(Bundle bundle)
    {
        a = (ApplicationContext)getActivity().getApplication();
        b = (MainActivity)getActivity();
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030053, null);
    }

    public final void onPause()
    {
        super.onPause();
    }

    public final void onResume()
    {
        super.onResume();
    }
}
