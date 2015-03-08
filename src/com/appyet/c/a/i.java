// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c.a;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.bb;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.appyet.a.a.e;
import com.appyet.activity.MainActivity;
import com.appyet.activity.forum.ForumReplyPostActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.context.g;
import com.appyet.d.d;
import com.appyet.data.Module;
import com.appyet.manager.an;
import com.appyet.manager.ap;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataTheme;
import com.viewpagerindicator.UnderlinePageIndicator;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import net.simonvt.menudrawer.MenuDrawer;
import uk.co.senab.a.b.a;
import uk.co.senab.a.b.a.b;
import uk.co.senab.a.b.h;

// Referenced classes of package com.appyet.c.a:
//            k, j

public final class i extends SherlockFragment
    implements bb, com.actionbarsherlock.widget.ShareActionProvider.OnShareTargetSelectedListener, b
{

    private k a;
    private ApplicationContext b;
    private int c;
    private Long d;
    private Module e;
    private String f;
    private String g;
    private com.appyet.a.a.d h;
    private ViewPager i;
    private e j;
    private UnderlinePageIndicator k;
    private uk.co.senab.a.a.a.e l;

    public i()
    {
    }

    private Intent a()
    {
        Intent intent;
        try
        {
            intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", j.c);
            StringBuilder stringbuilder = (new StringBuilder()).append(j.c).append(" ");
            com.appyet.a.a.d d1 = h;
            String s = g;
            String _tmp = j.c;
            String _tmp1 = j.a;
            intent.putExtra("android.intent.extra.TEXT", stringbuilder.append(an.a(d1, s, j.m)).toString());
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return null;
        }
        return intent;
    }

    static ViewPager a(i i1)
    {
        return i1.i;
    }

    static Long b(i i1)
    {
        return i1.d;
    }

    static e c(i i1)
    {
        return i1.j;
    }

    private void c(int i1)
    {
        try
        {
            c = i1;
            b.e.a("ForumThread");
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void a(int i1)
    {
        c(i1);
    }

    public final void a(int i1, float f1, int j1)
    {
    }

    public final void b(int i1)
    {
    }

    public final void e()
    {
        l.a();
        if (a != null)
        {
            a.notifyDataSetChanged();
        }
    }

    public final void onActivityResult(int i1, int j1, Intent intent)
    {
        if (i1 == 0 && j1 == 1 && a != null)
        {
            a.notifyDataSetChanged();
        }
        super.onActivityResult(i1, j1, intent);
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
        e = b.h.g(d.longValue());
        h = b.p.a(d.longValue());
        f = getArguments().getString("ARG_FORUM_ID");
        g = getArguments().getString("ARG_TOPIC_ID");
        j = b.o.b;
        setHasOptionsMenu(true);
        getActivity();
    }

    public final void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
    }

    public final void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f0f0008, menu);
        ShareActionProvider shareactionprovider = (ShareActionProvider)menu.findItem(0x7f0a00f3).getActionProvider();
        shareactionprovider.setShareHistoryFileName("share_history.xml");
        shareactionprovider.setOnShareTargetSelectedListener(this);
        shareactionprovider.setShareIntent(a());
        MenuItem menuitem;
        MenuItem menuitem1;
        MenuItem menuitem2;
        menuitem = menu.findItem(0x7f0a00f5);
        menuitem1 = menu.findItem(0x7f0a0112);
        menuitem2 = menu.findItem(0x7f0a0111);
        if (!b.m.a.ActionBarFgColor)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        menuitem.setIcon(0x7f0200c7);
        menuitem1.setIcon(0x7f0200c2);
        menuitem2.setIcon(0x7f0200bd);
_L1:
        boolean flag;
        if (!j.e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            menuitem2.setVisible(flag);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        break MISSING_BLOCK_LABEL_193;
        menuitem.setIcon(0x7f0200d9);
        menuitem1.setIcon(0x7f0200d4);
        menuitem2.setIcon(0x7f0200ce);
          goto _L1
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030049, null);
    }

    public final void onDestroy()
    {
        b.f.c();
        super.onDestroy();
    }

    public final boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i1 = menuitem.getItemId();
        i1;
        JVM INSTR lookupswitch 3: default 44
    //                   2131362037: 297
    //                   2131362065: 314
    //                   2131362066: 50;
           goto _L1 _L2 _L3 _L4
_L1:
        return super.onOptionsItemSelected(menuitem);
_L4:
        ArrayList arraylist;
        int j1;
        arraylist = new ArrayList();
        j1 = 1 + j.h / 10;
        int k1 = 0;
_L6:
        int l1;
        int i2;
        if (k1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = 1 + k1 * 10;
        i2 = 10 * (k1 + 1);
        if (i2 > 1 + j.h)
        {
            i2 = 1 + j.h;
        }
        arraylist.add((new StringBuilder()).append(getResources().getString(0x7f080109)).append(" ").append(k1 + 1).append(" (").append(l1).append("-").append(i2).append(")").toString());
        k1++;
        if (true) goto _L6; else goto _L5
_L5:
        try
        {
            CharSequence acharsequence[] = (CharSequence[])arraylist.toArray(new CharSequence[arraylist.size()]);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
            builder.setTitle(getString(0x7f0800f3));
            builder.setSingleChoiceItems(acharsequence, i.getCurrentItem(), new j(this));
            builder.create().show();
        }
        catch (Exception exception1)
        {
            try
            {
                com.appyet.d.d.a(exception1);
            }
            catch (Exception exception)
            {
                com.appyet.d.d.a(exception);
            }
        }
          goto _L1
_L2:
        if (a == null) goto _L1; else goto _L7
_L7:
        a.notifyDataSetChanged();
          goto _L1
_L3:
        Intent intent = new Intent(b, com/appyet/activity/forum/ForumReplyPostActivity);
        intent.putExtra("ARG_MODULE_ID", d);
        intent.putExtra("ARG_FORUM_ID", f);
        intent.putExtra("ARG_TOPIC_ID", g);
        startActivityForResult(intent, 0);
          goto _L1
    }

    public final void onPause()
    {
        b.f.a();
        super.onPause();
    }

    public final void onResume()
    {
        String s = e.getIcon();
        if (s == null) goto _L2; else goto _L1
_L1:
        InputStream inputstream = null;
        InputStream inputstream2 = getResources().getAssets().open((new StringBuilder("module/")).append(e.getIcon()).toString());
        InputStream inputstream1 = inputstream2;
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream1);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int j1 = bitmap.getWidth();
        int k1 = bitmap.getHeight();
        float f1 = displaymetrics.scaledDensity;
        float f2 = displaymetrics.scaledDensity;
        Matrix matrix = new Matrix();
        matrix.postScale(f1, f2);
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, j1, k1, matrix, true);
        BitmapDrawable bitmapdrawable = new BitmapDrawable(getResources(), bitmap1);
        getSherlockActivity().getSupportActionBar().setIcon(bitmapdrawable);
        if (inputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        inputstream1.close();
_L6:
        int i1;
        getSherlockActivity().getSupportActionBar().setTitle(b.o.b.c);
        i1 = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        if (i1 == 0)
        {
            i1 = 0x7f0a0041;
        }
        TextView textview;
        textview = (TextView)getSherlockActivity().getWindow().findViewById(i1);
        textview.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        textview.setSelected(true);
        textview.setMarqueeRepeatLimit(-1);
        if (!b.m.a.ActionBarFgColor) goto _L4; else goto _L3
_L3:
        textview.setTextColor(getResources().getColor(0x7f09004d));
_L7:
        super.onResume();
        b.f.b();
        return;
        IOException ioexception1;
        ioexception1;
_L10:
        com.appyet.d.d.a(ioexception1);
        getSherlockActivity().getSupportActionBar().setIcon(0x7f020116);
        if (inputstream == null) goto _L6; else goto _L5
_L5:
        inputstream.close();
          goto _L6
        IOException ioexception2;
        ioexception2;
        Exception exception;
        com.appyet.d.d.a(ioexception2);
        getSherlockActivity().getSupportActionBar().setIcon(0x7f020116);
          goto _L6
        Exception exception2;
        exception2;
        inputstream1 = null;
_L9:
        if (inputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_399;
        }
        inputstream1.close();
_L8:
        throw exception2;
_L2:
        getSherlockActivity().getSupportActionBar().setIcon(0x7f020116);
          goto _L6
_L4:
        try
        {
            textview.setTextColor(getResources().getColor(0x7f09004f));
        }
        catch (Exception exception1)
        {
            try
            {
                com.appyet.d.d.a(exception1);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                com.appyet.d.d.a(exception);
            }
        }
          goto _L7
        IOException ioexception;
        ioexception;
        com.appyet.d.d.a(ioexception);
        getSherlockActivity().getSupportActionBar().setIcon(0x7f020116);
          goto _L8
        IOException ioexception3;
        ioexception3;
        com.appyet.d.d.a(ioexception3);
        getSherlockActivity().getSupportActionBar().setIcon(0x7f020116);
          goto _L6
        exception2;
          goto _L9
        exception2;
        inputstream1 = inputstream;
          goto _L9
        ioexception1;
        inputstream = inputstream1;
          goto _L10
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("pageItem", i.getCurrentItem());
    }

    public final boolean onShareTargetSelected(ShareActionProvider shareactionprovider, Intent intent)
    {
        if (b.y == 3 || b.y == 4)
        {
            return false;
        } else
        {
            b.startActivity(intent);
            b.e.a("Share", intent.getAction(), "ForumThread");
            return true;
        }
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        ViewGroup viewgroup = (ViewGroup)view;
        l = new uk.co.senab.a.a.a.e(viewgroup.getContext());
        uk.co.senab.a.b.b b1 = uk.co.senab.a.b.a.a(getActivity());
        b1.a = uk.co.senab.a.b.h.a().a;
        b1.c = viewgroup;
        uk.co.senab.a.b.b b2 = b1.a(new int[] {
            0x7f0a0085, 0x7f0a0088
        });
        b2.b = this;
        b2.a(l);
        i = (ViewPager)getView().findViewById(0x7f0a0085);
        if (a == null)
        {
            a = new k(this, getChildFragmentManager());
        }
        i.setAdapter(a);
        i.setCurrentItem(c);
        c(c);
        if (bundle != null)
        {
            i.setCurrentItem(bundle.getInt("pageItem", 0));
        }
        k = (UnderlinePageIndicator)getView().findViewById(0x7f0a0086);
        k.setViewPager(i);
        k.setThumbWidth(130);
        k.setCurrentItem(c);
        k.setOnPageChangeListener(this);
        k.setSelectedColor(getResources().getColor(0x7f09005e));
        MainActivity mainactivity = (MainActivity)getSherlockActivity();
        if (mainactivity.a() != null)
        {
            mainactivity.a().setTouchMode(1);
        }
        ActionBar actionbar = mainactivity.getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);
        ViewGroup viewgroup1 = (ViewGroup)getView().findViewById(0x7f0a00a6);
        b.f.a(getSherlockActivity(), viewgroup1);
        super.onViewCreated(view, bundle);
    }
}
