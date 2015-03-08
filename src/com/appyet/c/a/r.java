// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c.a;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.a.a.b.f;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.appyet.a.a.a;
import com.appyet.a.a.e;
import com.appyet.activity.MainActivity;
import com.appyet.activity.forum.ForumNewTopicActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.context.g;
import com.appyet.d.d;
import com.appyet.data.Module;
import com.appyet.f.h;
import com.appyet.f.w;
import com.appyet.manager.an;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataTheme;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import net.simonvt.menudrawer.MenuDrawer;
import uk.co.senab.a.b.a.b;
import uk.co.senab.a.b.i;

// Referenced classes of package com.appyet.c.a:
//            u, w, x, y, 
//            s, t

public final class r extends SherlockFragment
    implements b
{

    protected ApplicationContext a;
    protected long b;
    private u c;
    private ListView d;
    private TextView e;
    private View f;
    private com.a.a.b.d g;
    private a h;
    private com.appyet.c.a.w i;
    private f j;
    private Module k;
    private String l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private y r;
    private com.appyet.a.a.d s;
    private uk.co.senab.a.a.a.e t;

    public r()
    {
        h = null;
        j = com.a.a.b.f.a();
        m = true;
        n = false;
        o = -1;
        p = 20;
        q = 0;
    }

    static u a(r r1, u u1)
    {
        r1.c = u1;
        return u1;
    }

    static y a(r r1, y y1)
    {
        r1.r = y1;
        return y1;
    }

    static void a(r r1, int i1)
    {
        e e1 = (e)r1.c.getItem(i1);
        r1.a.o.b = e1;
        r1.i.b(Long.valueOf(r1.b), e1.a, e1.b);
    }

    static boolean a(r r1)
    {
        return r1.m;
    }

    static boolean a(r r1, boolean flag)
    {
        r1.n = flag;
        return flag;
    }

    static boolean b(r r1)
    {
        return r1.n;
    }

    static y c(r r1)
    {
        return r1.r;
    }

    static int d(r r1)
    {
        return r1.o;
    }

    static String e(r r1)
    {
        return r1.l;
    }

    static int f(r r1)
    {
        return r1.p;
    }

    static int g(r r1)
    {
        int i1 = r1.o;
        r1.o = i1 + 1;
        return i1;
    }

    static u h(r r1)
    {
        return r1.c;
    }

    static ListView i(r r1)
    {
        return r1.d;
    }

    static void j(r r1)
    {
        try
        {
            ProgressBar progressbar = (ProgressBar)r1.getActivity().findViewById(0x7f0a0073);
            Animation animation = AnimationUtils.loadAnimation(r1.getActivity(), 0x7f040011);
            animation.setAnimationListener(new x(r1, progressbar));
            progressbar.startAnimation(animation);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    static boolean k(r r1)
    {
        r1.m = false;
        return false;
    }

    static View l(r r1)
    {
        return r1.f;
    }

    static TextView m(r r1)
    {
        return r1.e;
    }

    static void n(r r1)
    {
        try
        {
            ((ProgressBar)r1.getActivity().findViewById(0x7f0a0073)).setVisibility(0);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    static com.a.a.b.d o(r r1)
    {
        return r1.g;
    }

    static f p(r r1)
    {
        return r1.j;
    }

    public final void e()
    {
        t.a();
        if (r == null || r.d() == h.c)
        {
            if (c != null)
            {
                c.clear();
                c.notifyDataSetChanged();
                d.setVisibility(8);
                e.setVisibility(8);
            }
            o = -1;
            r = new y(this, (byte)0);
            r.a(new Void[0]);
        }
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        Bundle bundle1 = getArguments();
        b = bundle1.getLong("ARG_MODULE_ID");
        k = a.h.g(b);
        l = bundle1.getString("ARG_FORUM_ID");
        s = a.p.a(b);
        Iterator iterator = s.b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            a a1 = (a)iterator.next();
            if (a1.a.equals(l))
            {
                h = a1;
            }
        } while (true);
          goto _L1
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
_L3:
        return;
_L1:
        View view = getView();
        e = (TextView)view.findViewById(0x7f0a0070);
        d = (ListView)view.findViewById(0x7f0a0071);
        d.setVisibility(8);
        e.setVisibility(8);
        if (!a.m.a.PrimaryBgColor.equals("DARK"))
        {
            break MISSING_BLOCK_LABEL_367;
        }
        e.setTextColor(getResources().getColor(0x7f09003f));
_L4:
        MainActivity mainactivity;
        d.setOnItemClickListener(new s(this));
        d.setOnScrollListener(new t(this));
        if (m)
        {
            f = LayoutInflater.from(getActivity()).inflate(0x7f030044, d, false);
            d.addFooterView(f);
        }
        if (c != null && c.getCount() > 0)
        {
            d.setAdapter(c);
            d.setVisibility(0);
            e.setVisibility(8);
        }
        mainactivity = (MainActivity)getActivity();
        if (mainactivity.a() == null) goto _L3; else goto _L2
_L2:
        mainactivity.a().setTouchMode(2);
        return;
        e.setTextColor(getResources().getColor(0x7f09003e));
          goto _L4
    }

    public final void onActivityResult(int i1, int j1, Intent intent)
    {
        if (i1 == 0 && j1 == 1 && (r == null || r.d() == h.c))
        {
            r = new y(this, (byte)0);
            r.a(new Void[0]);
        }
        super.onActivityResult(i1, j1, intent);
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            i = (com.appyet.c.a.w)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement OnHeadlineSelectedListener").toString());
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = (ApplicationContext)getActivity().getApplicationContext();
        g = (new com.a.a.b.e()).a().a(0x7f0200e6).b(0x7f0200e8).c().e().a(android.graphics.Bitmap.Config.RGB_565).f();
        setHasOptionsMenu(true);
    }

    public final void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        menuinflater.inflate(0x7f0f0009, menu);
        MenuItem menuitem;
        MenuItem menuitem1;
        menuitem = menu.findItem(0x7f0a00f5);
        menuitem1 = menu.findItem(0x7f0a0115);
        if (a.m.a.ActionBarFgColor)
        {
            menuitem.setIcon(0x7f0200c7);
            menuitem1.setIcon(0x7f0200bd);
            return;
        }
        try
        {
            menuitem.setIcon(0x7f0200d9);
            menuitem1.setIcon(0x7f0200ce);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03004b, null);
    }

    public final boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 2: default 32
    //                   2131362037: 38
    //                   2131362069: 130;
           goto _L1 _L2 _L3
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        if (r == null || r.d() == h.c)
        {
            if (c != null)
            {
                c.clear();
                c.notifyDataSetChanged();
                d.setVisibility(8);
                e.setVisibility(8);
            }
            o = -1;
            r = new y(this, (byte)0);
            r.a(new Void[0]);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        Intent intent = new Intent(a, com/appyet/activity/forum/ForumNewTopicActivity);
        intent.putExtra("ARG_MODULE_ID", b);
        intent.putExtra("ARG_FORUM_ID", l);
        startActivityForResult(intent, 0);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void onPause()
    {
        try
        {
            if (r != null && (r.d() == h.a || r.d() == h.b))
            {
                r.e();
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        super.onPause();
    }

    public final void onPrepareOptionsMenu(Menu menu)
    {
        menu.findItem(0x7f0a00f5).setEnabled(true);
        super.onPrepareOptionsMenu(menu);
    }

    public final void onResume()
    {
        if (k.getIcon() == null) goto _L2; else goto _L1
_L1:
        InputStream inputstream = null;
        InputStream inputstream2 = getResources().getAssets().open((new StringBuilder("module/")).append(k.getIcon()).toString());
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
            break MISSING_BLOCK_LABEL_185;
        }
        inputstream1.close();
_L6:
        int i1;
        getSherlockActivity().getSupportActionBar().setTitle(w.a(a, h.b));
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
        if (!a.m.a.ActionBarFgColor) goto _L4; else goto _L3
_L3:
        textview.setTextColor(getResources().getColor(0x7f09004d));
_L7:
        super.onResume();
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
        ActionBar actionbar;
        com.appyet.d.d.a(ioexception2);
        actionbar = getSherlockActivity().getSupportActionBar();
_L8:
        actionbar.setIcon(0x7f020116);
          goto _L6
        Exception exception1;
        exception1;
        inputstream1 = null;
_L9:
        Exception exception;
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            catch (IOException ioexception)
            {
                com.appyet.d.d.a(ioexception);
                getSherlockActivity().getSupportActionBar().setIcon(0x7f020116);
            }
        }
        throw exception1;
_L2:
        getSherlockActivity().getSupportActionBar().setIcon(0x7f020116);
          goto _L6
_L4:
        try
        {
            textview.setTextColor(getResources().getColor(0x7f09004f));
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            if (exception.getMessage() != null)
            {
                com.appyet.d.d.a(exception);
            }
        }
          goto _L7
        IOException ioexception3;
        ioexception3;
        com.appyet.d.d.a(ioexception3);
        actionbar = getSherlockActivity().getSupportActionBar();
          goto _L8
        exception1;
          goto _L9
        exception1;
        inputstream1 = inputstream;
          goto _L9
        ioexception1;
        inputstream = inputstream1;
          goto _L10
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ViewGroup viewgroup = (ViewGroup)view;
        t = new uk.co.senab.a.a.a.e(viewgroup.getContext());
        uk.co.senab.a.b.b b1 = uk.co.senab.a.b.a.a(getActivity());
        b1.a = uk.co.senab.a.b.h.a().a;
        b1.c = viewgroup;
        uk.co.senab.a.b.b b2 = b1.a(new int[] {
            0x7f0a0071, 0x7f0a0070
        });
        b2.b = this;
        b2.a(t);
    }
}
