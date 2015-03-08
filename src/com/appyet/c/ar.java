// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.bb;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.appyet.activity.ImageViewerActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.manager.ap;
import com.appyet.view.PhotoViewPager;
import com.viewpagerindicator.LinePageIndicator;
import com.viewpagerindicator.c;
import java.util.ArrayList;

// Referenced classes of package com.appyet.c:
//            as

public final class ar extends SherlockFragment
    implements bb, com.actionbarsherlock.widget.ShareActionProvider.OnShareTargetSelectedListener
{

    private as a;
    private ApplicationContext b;
    private int c;
    private String d;
    private String e;
    private PhotoViewPager f;
    private c g;
    private ArrayList h;

    public ar()
    {
    }

    private Intent a()
    {
        Intent intent;
        intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        if (d != null)
        {
            intent.putExtra("android.intent.extra.SUBJECT", d);
        }
        if (d == null || e == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(d).append(" ").append(e).toString());
        return intent;
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        intent.putExtra("android.intent.extra.TEXT", e);
        return intent;
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        intent = null;
        return intent;
    }

    static ArrayList a(ar ar1)
    {
        return ar1.h;
    }

    public final void a(int i)
    {
        c = i;
        c = i;
    }

    public final void a(int i, float f1, int j)
    {
    }

    public final void b(int i)
    {
    }

    public final boolean onContextItemSelected(android.view.MenuItem menuitem)
    {
        return super.onContextItemSelected(menuitem);
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b = (ApplicationContext)getSherlockActivity().getApplicationContext();
        setHasOptionsMenu(true);
        Bundle bundle1;
        try
        {
            bundle1 = getActivity().getIntent().getExtras();
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        if (bundle1 == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        if (bundle1.containsKey("SHARE_TITLE"))
        {
            d = bundle1.getString("SHARE_TITLE");
        }
        if (bundle1.containsKey("SHARE_URL"))
        {
            e = bundle1.getString("SHARE_URL");
        }
        if (bundle1.containsKey("SELECTED_POSITION"))
        {
            c = bundle1.getInt("SELECTED_POSITION");
        }
        if (bundle1.containsKey("IMAGE_LINKS"))
        {
            h = bundle1.getStringArrayList("IMAGE_LINKS");
        }
    }

    public final void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
    }

    public final void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f0f000a, menu);
        ShareActionProvider shareactionprovider = (ShareActionProvider)menu.findItem(0x7f0a00f3).getActionProvider();
        shareactionprovider.setShareHistoryFileName("share_history.xml");
        shareactionprovider.setOnShareTargetSelectedListener(this);
        shareactionprovider.setShareIntent(a());
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03004e, null);
    }

    public final boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i = menuitem.getItemId();
        i;
        JVM INSTR tableswitch 16908332 16908332: default 28
    //                   16908332 34;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        try
        {
            getActivity().finish();
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void onResume()
    {
        super.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("pageItem", f.getCurrentItem());
    }

    public final boolean onShareTargetSelected(ShareActionProvider shareactionprovider, Intent intent)
    {
        if (b.y == 3 || b.y == 4)
        {
            return false;
        } else
        {
            b.startActivity(intent);
            b.e.a("Share", intent.getAction(), "Image");
            return true;
        }
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        f = (PhotoViewPager)getView().findViewById(0x7f0a0085);
        if (a == null)
        {
            a = new as(this, getChildFragmentManager());
        }
        f.setAdapter(a);
        f.setCurrentItem(c);
        if (bundle != null)
        {
            f.setCurrentItem(bundle.getInt("pageItem", 0));
        }
        g = (LinePageIndicator)getView().findViewById(0x7f0a0086);
        g.setViewPager(f);
        g.setOnPageChangeListener(this);
        g.setCurrentItem(c);
        ActionBar actionbar = ((ImageViewerActivity)getSherlockActivity()).getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);
        super.onViewCreated(view, bundle);
    }
}
