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
import android.webkit.URLUtil;
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
import com.appyet.activity.MainActivity;
import com.appyet.activity.WebBrowserActivity;
import com.appyet.activity.forum.ForumSignInActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.data.Module;
import com.appyet.f.h;
import com.appyet.f.w;
import com.appyet.manager.an;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataTheme;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import net.simonvt.menudrawer.MenuDrawer;
import uk.co.senab.a.a.a.e;
import uk.co.senab.a.b.a.b;
import uk.co.senab.a.b.i;

// Referenced classes of package com.appyet.c.a:
//            f, c, e, g, 
//            b, h

public final class a extends SherlockFragment
    implements b
{

    protected ApplicationContext a;
    protected long b;
    public List c;
    private com.appyet.c.a.e d;
    private c e;
    private ListView f;
    private TextView g;
    private com.a.a.b.d h;
    private f i;
    private com.appyet.a.a.d j;
    private Module k;
    private int l;
    private String m;
    private com.appyet.a.a.a n;
    private g o;
    private e p;

    public a()
    {
        i = com.a.a.b.f.a();
        l = -1;
        m = "-1";
        n = null;
    }

    static int a(a a1, int i1)
    {
        a1.l = i1;
        return i1;
    }

    static com.appyet.a.a.d a(a a1)
    {
        return a1.j;
    }

    static c a(a a1, c c1)
    {
        a1.e = c1;
        return c1;
    }

    static String a(a a1, String s)
    {
        a1.m = s;
        return s;
    }

    static void b(a a1)
    {
        try
        {
            ProgressBar progressbar = (ProgressBar)a1.getActivity().findViewById(0x7f0a0073);
            Animation animation = AnimationUtils.loadAnimation(a1.getActivity(), 0x7f040011);
            animation.setAnimationListener(new com.appyet.c.a.f(a1, progressbar));
            progressbar.startAnimation(animation);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    static void b(a a1, int i1)
    {
        com.appyet.a.a.a a2 = (com.appyet.a.a.a)a1.e.getItem(i1);
        if (a2.j != null && a2.j.length() > 0 && URLUtil.isValidUrl(a2.j))
        {
            Intent intent = new Intent(a1.getActivity(), com/appyet/activity/WebBrowserActivity);
            intent.putExtra("URL", a2.j);
            a1.getActivity().startActivity(intent);
            return;
        }
        try
        {
            a1.d.a(Long.valueOf(a1.b), a2.a, a1.m);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return;
    }

    static com.appyet.a.a.a c(a a1)
    {
        return a1.n;
    }

    static String d(a a1)
    {
        return a1.m;
    }

    static c e(a a1)
    {
        return a1.e;
    }

    static ListView f(a a1)
    {
        return a1.f;
    }

    static TextView g(a a1)
    {
        return a1.g;
    }

    static int h(a a1)
    {
        return a1.l;
    }

    static void i(a a1)
    {
        try
        {
            ((ProgressBar)a1.getActivity().findViewById(0x7f0a0073)).setVisibility(0);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    static com.a.a.b.d j(a a1)
    {
        return a1.h;
    }

    static f k(a a1)
    {
        return a1.i;
    }

    public final void e()
    {
        p.a();
        try
        {
            if (o != null && (o.d() == h.a || o.d() == h.b))
            {
                o.e();
            }
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        Bundle bundle1;
        bundle1 = getArguments();
        b = bundle1.getLong("ModuleId");
        k = a.h.g(b);
        j = a.p.a(b);
        if (!bundle1.containsKey("ForumId")) goto _L2; else goto _L1
_L1:
        m = bundle1.getString("ForumId");
        n = a.p.a(b, m);
_L8:
        View view = getView();
        f = (ListView)view.findViewById(0x7f0a0071);
        f.setVisibility(8);
        g = (TextView)view.findViewById(0x7f0a0070);
        g.setVisibility(8);
        if (!a.m.a.PrimaryBgColor.equals("DARK")) goto _L4; else goto _L3
_L3:
        g.setTextColor(getResources().getColor(0x7f09003f));
_L6:
        f.setOnItemClickListener(new com.appyet.c.a.b(this));
        MainActivity mainactivity = (MainActivity)getActivity();
        if (mainactivity.a() != null)
        {
            mainactivity.a().setTouchMode(2);
            return;
        }
          goto _L5
_L2:
        try
        {
            m = "-1";
            n = null;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        g.setTextColor(getResources().getColor(0x7f09003e));
          goto _L6
_L5:
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            d = (com.appyet.c.a.e)activity;
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
        h = (new com.a.a.b.e()).a().a(0x7f0200e6).b(0x7f0200e8).c().e().a(android.graphics.Bitmap.Config.RGB_565).f();
        setHasOptionsMenu(true);
    }

    public final void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        menuinflater.inflate(0x7f0f0005, menu);
        MenuItem menuitem;
        menuitem = menu.findItem(0x7f0a00f5);
        if (a.m.a.ActionBarFgColor)
        {
            menuitem.setIcon(0x7f0200c7);
            return;
        }
        try
        {
            menuitem.setIcon(0x7f0200d9);
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
        return layoutinflater.inflate(0x7f030045, null);
    }

    public final boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 3: default 40
    //                   2131362037: 46
    //                   2131362058: 94
    //                   2131362059: 132;
           goto _L1 _L2 _L3 _L4
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        if (o == null || o.d() == h.c)
        {
            o = new g(this, (byte)0);
            o.a(new Void[0]);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        Intent intent = new Intent(a, com/appyet/activity/forum/ForumSignInActivity);
        intent.putExtra("ARG_MODULE_ID", b);
        a.startActivity(intent);
        continue; /* Loop/switch isn't completed */
_L4:
        (new com.appyet.c.a.h(this, (byte)0)).a(new Void[0]);
        if (true) goto _L1; else goto _L5
_L5:
    }

    public final void onPause()
    {
        try
        {
            if (o != null && (o.d() == h.a || o.d() == h.b))
            {
                o.e();
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
        boolean flag = true;
        menu.findItem(0x7f0a00f5);
        MenuItem menuitem = menu.findItem(0x7f0a010a);
        MenuItem menuitem1 = menu.findItem(0x7f0a010b);
        if (j != null)
        {
            boolean flag1;
            if ((j.e == null || !j.e.a) && j.d != null)
            {
                flag1 = flag;
            } else
            {
                flag1 = false;
            }
            menuitem.setVisible(flag1);
            if (j.e == null || !j.e.a)
            {
                flag = false;
            }
            menuitem1.setVisible(flag);
        } else
        {
            menuitem.setVisible(false);
            menuitem1.setVisible(false);
        }
        super.onPrepareOptionsMenu(menu);
    }

    public final void onResume()
    {
        TextView textview;
        InputStream inputstream;
        InputStream inputstream1;
        IOException ioexception1;
        super.onResume();
        String s;
        int i1;
        IOException ioexception2;
        InputStream inputstream2;
        Bitmap bitmap;
        DisplayMetrics displaymetrics;
        int j1;
        int k1;
        float f1;
        float f2;
        Matrix matrix;
        Bitmap bitmap1;
        BitmapDrawable bitmapdrawable;
        try
        {
            s = k.getIcon();
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        inputstream = null;
        inputstream2 = getResources().getAssets().open((new StringBuilder("module/")).append(k.getIcon()).toString());
        inputstream1 = inputstream2;
        bitmap = BitmapFactory.decodeStream(inputstream1);
        displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        j1 = bitmap.getWidth();
        k1 = bitmap.getHeight();
        f1 = displaymetrics.scaledDensity;
        f2 = displaymetrics.scaledDensity;
        matrix = new Matrix();
        matrix.postScale(f1, f2);
        bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, j1, k1, matrix, true);
        bitmapdrawable = new BitmapDrawable(getResources(), bitmap1);
        getSherlockActivity().getSupportActionBar().setIcon(bitmapdrawable);
        if (inputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        inputstream1.close();
_L8:
        if (o == null || o.d() == h.c)
        {
            o = new g(this, (byte)0);
            o.a(new Void[0]);
        }
        if (n != null) goto _L4; else goto _L3
_L3:
        getSherlockActivity().getSupportActionBar().setTitle(w.a(a, k.getName()));
_L9:
        i1 = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        if (i1 == 0)
        {
            i1 = 0x7f0a0041;
        }
        textview = (TextView)getSherlockActivity().getWindow().findViewById(i1);
        textview.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        textview.setSelected(true);
        textview.setMarqueeRepeatLimit(-1);
        if (!a.m.a.ActionBarFgColor) goto _L6; else goto _L5
_L5:
        textview.setTextColor(getResources().getColor(0x7f09004d));
_L11:
        return;
        ioexception1;
_L14:
        com.appyet.d.d.a(ioexception1);
        getSherlockActivity().getSupportActionBar().setIcon(0x7f020116);
        if (inputstream == null) goto _L8; else goto _L7
_L7:
        inputstream.close();
          goto _L8
        ioexception2;
        com.appyet.d.d.a(ioexception2);
        getSherlockActivity().getSupportActionBar().setIcon(0x7f020116);
          goto _L8
        Exception exception2;
        exception2;
        inputstream1 = null;
_L13:
        if (inputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_440;
        }
        inputstream1.close();
_L12:
        throw exception2;
_L2:
        getSherlockActivity().getSupportActionBar().setIcon(0x7f020116);
          goto _L8
_L4:
        getSherlockActivity().getSupportActionBar().setTitle(w.a(a, n.b));
          goto _L9
        Exception exception1;
        exception1;
        if (exception1.getMessage() == null) goto _L11; else goto _L10
_L10:
        com.appyet.d.d.a(exception1);
        return;
_L6:
        textview.setTextColor(getResources().getColor(0x7f09004f));
        return;
        IOException ioexception;
        ioexception;
        com.appyet.d.d.a(ioexception);
        getSherlockActivity().getSupportActionBar().setIcon(0x7f020116);
          goto _L12
        IOException ioexception3;
        ioexception3;
        com.appyet.d.d.a(ioexception3);
        getSherlockActivity().getSupportActionBar().setIcon(0x7f020116);
          goto _L8
        exception2;
          goto _L13
        exception2;
        inputstream1 = inputstream;
          goto _L13
        ioexception1;
        inputstream = inputstream1;
          goto _L14
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ViewGroup viewgroup = (ViewGroup)view;
        p = new e(viewgroup.getContext());
        uk.co.senab.a.b.b b1 = uk.co.senab.a.b.a.a(getActivity());
        b1.a = uk.co.senab.a.b.h.a().a;
        b1.c = viewgroup;
        uk.co.senab.a.b.b b2 = b1.a(new int[] {
            0x7f0a0071, 0x7f0a0070
        });
        b2.b = this;
        b2.a(p);
    }
}
