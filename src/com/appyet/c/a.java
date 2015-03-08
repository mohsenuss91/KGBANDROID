// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.bb;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.appyet.activity.MainActivity;
import com.appyet.activity.TranslateActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import com.appyet.d.d;
import com.appyet.data.Feed;
import com.appyet.data.FeedItem;
import com.appyet.data.Module;
import com.appyet.f.h;
import com.appyet.f.w;
import com.appyet.manager.ap;
import com.appyet.manager.b;
import com.appyet.manager.bl;
import com.appyet.manager.bo;
import com.appyet.manager.bp;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataModuleFeed;
import com.appyet.metadata.MetadataTheme;
import com.viewpagerindicator.UnderlinePageIndicator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import net.simonvt.menudrawer.MenuDrawer;

// Referenced classes of package com.appyet.c:
//            c, d, g, i, 
//            b, j, f, h

public final class a extends SherlockFragment
    implements bb, com.actionbarsherlock.widget.ShareActionProvider.OnShareTargetSelectedListener
{

    private g a;
    private ApplicationContext b;
    private int c;
    private Long d;
    private ViewPager e;
    private UnderlinePageIndicator f;
    private i g;

    public a()
    {
        g = null;
    }

    static int a(a a1, int k)
    {
        a1.c = k;
        return k;
    }

    private Intent a()
    {
        Intent intent;
        try
        {
            FeedItem feeditem = (FeedItem)b.n.b.get(c);
            intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", feeditem.getTitle());
            intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(feeditem.getTitle()).append(" ").append(feeditem.getLink().toString()).toString());
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return null;
        }
        return intent;
    }

    static ApplicationContext a(a a1)
    {
        return a1.b;
    }

    static g b(a a1)
    {
        return a1.a;
    }

    static int c(a a1)
    {
        return a1.c;
    }

    private void c(int k)
    {
        c = k;
        if (b.n.b == null || k < 0)
        {
            break MISSING_BLOCK_LABEL_287;
        }
        if (k >= b.n.b.size())
        {
            break MISSING_BLOCK_LABEL_287;
        }
        FeedItem feeditem = (FeedItem)b.n.b.get(k);
        b.n.f = feeditem.getFeedItemId();
        if (!feeditem.getIsRead())
        {
            if (!b.d.b() || !feeditem.getIsStar())
            {
                feeditem.setIsRead(true);
            }
            feeditem.setFlag(com.appyet.data.FeedItem.FlagEnum.Update);
        }
        getSherlockActivity().supportInvalidateOptionsMenu();
_L2:
        b.e.a("FeedArticleDetail");
        if (!b.d.V())
        {
            b.d.i(1 + b.d.U());
            if (b.d.U() > 200 && b.g.a() != bo.a)
            {
                AlertDialog alertdialog = (new android.app.AlertDialog.Builder(getActivity())).create();
                alertdialog.setTitle(0x7f0800be);
                alertdialog.setMessage(getString(0x7f0800c1));
                alertdialog.setButton(-1, getString(0x7f0800bf), new c(this));
                alertdialog.setButton(-2, getString(0x7f080062), new com.appyet.c.d(this));
                alertdialog.show();
                return;
            }
        }
        break MISSING_BLOCK_LABEL_323;
        getSherlockActivity().getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        getSherlockActivity().getSupportFragmentManager().popBackStack();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
    }

    static ViewPager d(a a1)
    {
        return a1.e;
    }

    static Long e(a a1)
    {
        return a1.d;
    }

    static void f(a a1)
    {
        int k;
        String s;
        k = 0x7f0a0041;
        s = "";
        if (a1.a != null)
        {
            if (!a1.b.n.j)
            {
                break MISSING_BLOCK_LABEL_201;
            }
            s = (new StringBuilder(" (")).append(a1.a.getCount()).append(")").toString();
        }
_L1:
        int i1;
        if (a1.b.n.g != com.appyet.context.d.b)
        {
            break MISSING_BLOCK_LABEL_256;
        }
        a1.getSherlockActivity().getSupportActionBar().setTitle((new StringBuilder()).append(a1.b.n.h).append(s).toString());
        i1 = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int l;
        TextView textview;
        TextView textview1;
        if (i1 != 0)
        {
            k = i1;
        }
        textview1 = (TextView)a1.getSherlockActivity().getWindow().findViewById(k);
        textview1.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        textview1.setSelected(true);
        textview1.setMarqueeRepeatLimit(-1);
        if (a1.b.m.a.ActionBarFgColor)
        {
            textview1.setTextColor(a1.getResources().getColor(0x7f09004d));
            return;
        }
        break MISSING_BLOCK_LABEL_234;
        s = (new StringBuilder(" (")).append(a1.a.getCount()).append("+)").toString();
          goto _L1
        try
        {
            textview1.setTextColor(a1.getResources().getColor(0x7f09004f));
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return;
        if (a1.b.n.a == null)
        {
            break MISSING_BLOCK_LABEL_422;
        }
        a1.getSherlockActivity().getSupportActionBar().setTitle((new StringBuilder()).append(w.a(a1.b, a1.b.n.a.getName())).append(s).toString());
        l = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        if (l != 0)
        {
            k = l;
        }
        textview = (TextView)a1.getSherlockActivity().getWindow().findViewById(k);
        textview.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        textview.setSelected(true);
        textview.setMarqueeRepeatLimit(-1);
        if (a1.b.m.a.ActionBarFgColor)
        {
            textview.setTextColor(a1.getResources().getColor(0x7f09004d));
            return;
        }
        textview.setTextColor(a1.getResources().getColor(0x7f09004f));
        return;
        a1.getSherlockActivity().getSupportActionBar().setTitle(0x7f080116);
        return;
    }

    public final void a(int k)
    {
        c(k);
        if (a != null && !b.n.j && k + 1 == b.n.b.size() && (g == null || g.d() == h.a || g.d() == h.c))
        {
            g = new i(this);
            g.a(new Void[0]);
        }
    }

    public final void a(int k, float f1, int l)
    {
    }

    public final void b(int k)
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
        c = getArguments().getInt("ARG_POSITION");
        d = Long.valueOf(getArguments().getLong("ARG_MODULE_ID"));
        setHasOptionsMenu(true);
        getActivity();
    }

    public final void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
    }

    public final void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f0f0003, menu);
        ShareActionProvider shareactionprovider = (ShareActionProvider)menu.findItem(0x7f0a00fc).getActionProvider();
        shareactionprovider.setShareHistoryFileName("share_history.xml");
        shareactionprovider.setOnShareTargetSelectedListener(this);
        shareactionprovider.setShareIntent(a());
        FeedItem feeditem;
        MenuItem menuitem;
        feeditem = (FeedItem)b.n.b.get(c);
        menuitem = menu.findItem(0x7f0a00fd);
        if (!b.m.a.ActionBarFgColor) goto _L2; else goto _L1
_L1:
        if (!feeditem.getIsStar()) goto _L4; else goto _L3
_L3:
        menuitem.setIcon(0x7f0200fb);
_L5:
        MetadataModuleFeed metadatamodulefeed = (MetadataModuleFeed)b.n.d.get(feeditem.getFeed().getFeedId());
        menu.findItem(0x7f0a00ff).setVisible(metadatamodulefeed.IsShowTransalte);
        menu.findItem(0x7f0a0101).setVisible(metadatamodulefeed.IsShowCopyLink);
        return;
_L4:
        try
        {
            menuitem.setIcon(0x7f0200fa);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
          goto _L5
_L2:
label0:
        {
            if (!feeditem.getIsStar())
            {
                break label0;
            }
            menuitem.setIcon(0x7f0200fb);
        }
          goto _L5
        menuitem.setIcon(0x7f0200f9);
          goto _L5
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03003e, null);
    }

    public final void onDestroy()
    {
        b.f.c();
        super.onDestroy();
    }

    public final boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int k = menuitem.getItemId();
        k;
        JVM INSTR tableswitch 2131362045 2131362049: default 44
    //                   2131362045 143
    //                   2131362046 50
    //                   2131362047 284
    //                   2131362048 485
    //                   2131362049 352;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return super.onOptionsItemSelected(menuitem);
_L3:
        try
        {
            CharSequence acharsequence[] = getResources().getTextArray(0x7f0e0004);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
            builder.setTitle(getString(0x7f08006f));
            builder.setSingleChoiceItems(acharsequence, b.d.K(), new com.appyet.c.b(this));
            builder.create().show();
        }
        catch (Exception exception3)
        {
            try
            {
                com.appyet.d.d.a(exception3);
            }
            catch (Exception exception)
            {
                com.appyet.d.d.a(exception);
            }
        }
          goto _L1
_L2:
        FeedItem feeditem3 = (FeedItem)b.n.b.get(c);
        if (feeditem3 == null) goto _L1; else goto _L7
_L7:
        if (!b.m.a.ActionBarFgColor) goto _L9; else goto _L8
_L8:
        if (!feeditem3.getIsStar()) goto _L11; else goto _L10
_L10:
        menuitem.setIcon(0x7f0200fa);
_L12:
        (new j(this, feeditem3)).a(new Void[0]);
          goto _L1
        Exception exception2;
        exception2;
        com.appyet.d.d.a(exception2);
          goto _L1
_L11:
        menuitem.setIcon(0x7f0200fb);
          goto _L12
_L9:
        if (!feeditem3.getIsStar()) goto _L14; else goto _L13
_L13:
        menuitem.setIcon(0x7f0200f9);
          goto _L12
_L14:
        menuitem.setIcon(0x7f0200fb);
          goto _L12
_L4:
        FeedItem feeditem2 = (FeedItem)b.n.b.get(c);
        if (feeditem2 == null) goto _L1; else goto _L15
_L15:
        Intent intent = new Intent(getSherlockActivity(), com/appyet/activity/TranslateActivity);
        intent.putExtra("URL", feeditem2.getLink());
        startActivity(intent);
          goto _L1
_L6:
        FeedItem feeditem1 = (FeedItem)b.n.b.get(c);
        if (feeditem1 == null) goto _L1; else goto _L16
_L16:
        if (feeditem1.getLink() == null) goto _L1; else goto _L17
_L17:
        ((ClipboardManager)b.getSystemService("clipboard")).setText(feeditem1.getLink().toString());
        ApplicationContext applicationcontext = b;
        String s = getString(0x7f080082);
        Object aobj[] = new Object[1];
        aobj[0] = feeditem1.getLink().toString();
        Toast.makeText(applicationcontext, String.format(s, aobj), 1).show();
          goto _L1
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
          goto _L1
        Error error;
        error;
        com.appyet.d.d.a(error);
          goto _L1
_L5:
        FeedItem feeditem = (FeedItem)b.n.b.get(c);
        if (feeditem == null || feeditem == null) goto _L1; else goto _L18
_L18:
        if (feeditem.getIsDeleted()) goto _L1; else goto _L19
_L19:
        feeditem.setIsDeleted(true);
        (new com.appyet.c.f(this, feeditem)).a(new Void[0]);
          goto _L1
    }

    public final void onPause()
    {
        try
        {
            (new com.appyet.c.h(this)).a(new Void[0]);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        if (b.n.b != null)
        {
            FeedItem feeditem;
            for (Iterator iterator = b.n.b.iterator(); iterator.hasNext(); feeditem.setDescription(null))
            {
                feeditem = (FeedItem)iterator.next();
                feeditem.setArticle(null);
            }

        }
        b.f.a();
        super.onPause();
    }

    public final void onResume()
    {
        try
        {
            if (b.n.b == null || b.n.b.size() == 0)
            {
                getSherlockActivity().getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
                getSherlockActivity().getSupportFragmentManager().popBackStack();
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        super.onResume();
        b.f.b();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("pageItem", e.getCurrentItem());
    }

    public final boolean onShareTargetSelected(ShareActionProvider shareactionprovider, Intent intent)
    {
        if (b.y == 3 || b.y == 4)
        {
            return false;
        } else
        {
            b.startActivity(intent);
            b.e.a("Share", intent.getAction(), "FeedArticle");
            return true;
        }
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        e = (ViewPager)getView().findViewById(0x7f0a0085);
        if (a == null)
        {
            a = new g(this, getChildFragmentManager());
        }
        e.setAdapter(a);
        e.setCurrentItem(c);
        c(c);
        if (bundle != null)
        {
            e.setCurrentItem(bundle.getInt("pageItem", 0));
        }
        f = (UnderlinePageIndicator)getView().findViewById(0x7f0a0086);
        f.setViewPager(e);
        f.setThumbWidth(130);
        f.setCurrentItem(c);
        f.setOnPageChangeListener(this);
        f.setSelectedColor(getResources().getColor(0x7f09005e));
        MainActivity mainactivity = (MainActivity)getSherlockActivity();
        if (mainactivity.a() != null)
        {
            mainactivity.a().setTouchMode(1);
        }
        ActionBar actionbar = mainactivity.getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);
        ViewGroup viewgroup = (ViewGroup)getView().findViewById(0x7f0a0084);
        b.f.a(getSherlockActivity(), viewgroup);
        super.onViewCreated(view, bundle);
    }
}
