// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import com.a.a.b.c.b;
import com.a.a.b.e;
import com.a.a.b.f;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.manager.ar;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.i;

// Referenced classes of package com.appyet.c:
//            aw, au, av

public final class at extends SherlockFragment
    implements i
{

    private int a;
    private ApplicationContext b;
    private PhotoView c;
    private ProgressBar d;
    private Handler e;
    private Runnable f;
    private String g;
    private boolean h;
    private f i;
    private com.a.a.b.d j;

    public at()
    {
        i = com.a.a.b.f.a();
    }

    static void a(at at1)
    {
        if (at1.e == null)
        {
            at1.e = new Handler();
        }
        if (at1.f == null)
        {
            at1.f = new aw(at1);
        }
        at1.e.removeCallbacks(at1.f);
        at1.e.postDelayed(at1.f, 4000L);
    }

    static boolean a(at at1, boolean flag)
    {
        at1.h = flag;
        return flag;
    }

    static ProgressBar b(at at1)
    {
        return at1.d;
    }

    static ApplicationContext c(at at1)
    {
        return at1.b;
    }

    static boolean d(at at1)
    {
        return at1.h;
    }

    public final void a()
    {
        if (getSherlockActivity().getSupportActionBar().isShowing())
        {
            getSherlockActivity().getSupportActionBar().hide();
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                getActivity().getWindow().getDecorView().setSystemUiVisibility(1);
            }
            if (e != null && f != null)
            {
                e.removeCallbacks(f);
            }
        } else
        {
            getSherlockActivity().getSupportActionBar().show();
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                getActivity().getWindow().getDecorView().setSystemUiVisibility(0);
                return;
            }
        }
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public final void onCreate(Bundle bundle)
    {
        if (bundle != null)
        {
            if (bundle.containsKey("POSITION"))
            {
                a = bundle.getInt("POSITION", 0);
            }
            if (bundle.containsKey("IMAGE_LINK"))
            {
                g = bundle.getString("IMAGE_LINK");
            }
        }
        b = (ApplicationContext)getActivity().getApplicationContext();
        if (getArguments() != null && getArguments().containsKey("IMAGE_LINK"))
        {
            g = getArguments().getString("IMAGE_LINK");
        }
        getSherlockActivity().getSupportActionBar().addOnMenuVisibilityListener(new au(this));
        j = (new e()).a(0x7f0200e5).b(0x7f0200e7).b().d().a(com.a.a.b.a.e.c).a(new b()).f();
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030050, null);
    }

    public final void onDestroy()
    {
        super.onDestroy();
    }

    public final void onDestroyView()
    {
        super.onDestroyView();
    }

    public final void onDetach()
    {
        c.setImageBitmap(null);
        super.onDetach();
    }

    public final void onPause()
    {
        super.onPause();
        if (e != null && f != null)
        {
            e.removeCallbacks(f);
        }
    }

    public final void onResume()
    {
        ar.a(getActivity());
        super.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("POSITION", a);
        bundle.putString("IMAGE_LINK", g);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        try
        {
            View view1 = getView();
            c = (PhotoView)view1.findViewById(0x7f0a00bf);
            c.setImageBitmap(null);
            c.setOnViewTapListener(this);
            d = (ProgressBar)view1.findViewById(0x7f0a0073);
            i.a(g, c, j, new av(this));
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        super.onViewCreated(view, bundle);
    }
}
