// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.dynamic:
//            LifecycleDelegate, f

public abstract class a
{

    private LifecycleDelegate LU;
    private Bundle LV;
    private LinkedList LW;
    private final f LX = new _cls1();

    public a()
    {
    }

    static Bundle a(a a1, Bundle bundle)
    {
        a1.LV = bundle;
        return bundle;
    }

    static LifecycleDelegate a(a a1, LifecycleDelegate lifecycledelegate)
    {
        a1.LU = lifecycledelegate;
        return lifecycledelegate;
    }

    static LinkedList a(a a1)
    {
        return a1.LW;
    }

    private void a(Bundle bundle, a a1)
    {
        if (LU != null)
        {
            a1.b(LU);
            return;
        }
        if (LW == null)
        {
            LW = new LinkedList();
        }
        LW.add(a1);
        if (bundle != null)
        {
            if (LV == null)
            {
                LV = (Bundle)bundle.clone();
            } else
            {
                LV.putAll(bundle);
            }
        }
        a(LX);
    }

    static LifecycleDelegate b(com.google.android.gms.dynamic.a a1)
    {
        return a1.LU;
    }

    public static void b(FrameLayout framelayout)
    {
        Context context = framelayout.getContext();
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String s = GooglePlayServicesUtil.d(context, i);
        String s1 = GooglePlayServicesUtil.e(context, i);
        LinearLayout linearlayout = new LinearLayout(framelayout.getContext());
        linearlayout.setOrientation(1);
        linearlayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
        framelayout.addView(linearlayout);
        TextView textview = new TextView(framelayout.getContext());
        textview.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
        textview.setText(s);
        linearlayout.addView(textview);
        if (s1 != null)
        {
            Button button = new Button(context);
            button.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
            button.setText(s1);
            linearlayout.addView(button);
            button.setOnClickListener(new _cls5(context, i));
        }
    }

    private void ca(int i)
    {
        for (; !LW.isEmpty() && ((a)LW.getLast()).getState() >= i; LW.removeLast()) { }
    }

    protected void a(FrameLayout framelayout)
    {
        b(framelayout);
    }

    protected abstract void a(f f);

    public LifecycleDelegate gC()
    {
        return LU;
    }

    public void onCreate(Bundle bundle)
    {
        a(bundle, new _cls3(bundle));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        FrameLayout framelayout = new FrameLayout(layoutinflater.getContext());
        a(bundle, new _cls4(framelayout, layoutinflater, viewgroup, bundle));
        if (LU == null)
        {
            a(framelayout);
        }
        return framelayout;
    }

    public void onDestroy()
    {
        if (LU != null)
        {
            LU.onDestroy();
            return;
        } else
        {
            ca(1);
            return;
        }
    }

    public void onDestroyView()
    {
        if (LU != null)
        {
            LU.onDestroyView();
            return;
        } else
        {
            ca(2);
            return;
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
    {
        a(bundle1, new _cls2(activity, bundle, bundle1));
    }

    public void onLowMemory()
    {
        if (LU != null)
        {
            LU.onLowMemory();
        }
    }

    public void onPause()
    {
        if (LU != null)
        {
            LU.onPause();
            return;
        } else
        {
            ca(5);
            return;
        }
    }

    public void onResume()
    {
        a(((Bundle) (null)), new _cls7());
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (LU != null)
        {
            LU.onSaveInstanceState(bundle);
        } else
        if (LV != null)
        {
            bundle.putAll(LV);
            return;
        }
    }

    public void onStart()
    {
        a(((Bundle) (null)), new _cls6());
    }

    public void onStop()
    {
        if (LU != null)
        {
            LU.onStop();
            return;
        } else
        {
            ca(4);
            return;
        }
    }

    private class _cls1
        implements f
    {

        final com.google.android.gms.dynamic.a LY;

        public void a(LifecycleDelegate lifecycledelegate)
        {
            com.google.android.gms.dynamic.a.a(LY, lifecycledelegate);
            for (Iterator iterator = com.google.android.gms.dynamic.a.a(LY).iterator(); iterator.hasNext(); ((a)iterator.next()).b(com.google.android.gms.dynamic.a.b(LY))) { }
            com.google.android.gms.dynamic.a.a(LY).clear();
            com.google.android.gms.dynamic.a.a(LY, null);
        }

        _cls1()
        {
            LY = a.this;
            super();
        }
    }


    private class a
    {

        public abstract void b(LifecycleDelegate lifecycledelegate);

        public abstract int getState();
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final int Mf;
        final Context qr;

        public final void onClick(View view)
        {
            qr.startActivity(GooglePlayServicesUtil.c(qr, Mf));
        }

        _cls5(Context context, int i)
        {
            qr = context;
            Mf = i;
            super();
        }
    }


    private class _cls3
        implements a
    {

        final com.google.android.gms.dynamic.a LY;
        final Bundle Mb;

        public void b(LifecycleDelegate lifecycledelegate)
        {
            com.google.android.gms.dynamic.a.b(LY).onCreate(Mb);
        }

        public int getState()
        {
            return 1;
        }

        _cls3(Bundle bundle)
        {
            LY = com.google.android.gms.dynamic.a.this;
            Mb = bundle;
            super();
        }
    }


    private class _cls4
        implements a
    {

        final com.google.android.gms.dynamic.a LY;
        final Bundle Mb;
        final FrameLayout Mc;
        final LayoutInflater Md;
        final ViewGroup Me;

        public void b(LifecycleDelegate lifecycledelegate)
        {
            Mc.removeAllViews();
            Mc.addView(com.google.android.gms.dynamic.a.b(LY).onCreateView(Md, Me, Mb));
        }

        public int getState()
        {
            return 2;
        }

        _cls4(FrameLayout framelayout, LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            LY = com.google.android.gms.dynamic.a.this;
            Mc = framelayout;
            Md = layoutinflater;
            Me = viewgroup;
            Mb = bundle;
            super();
        }
    }


    private class _cls2
        implements a
    {

        final com.google.android.gms.dynamic.a LY;
        final Activity LZ;
        final Bundle Ma;
        final Bundle Mb;

        public void b(LifecycleDelegate lifecycledelegate)
        {
            com.google.android.gms.dynamic.a.b(LY).onInflate(LZ, Ma, Mb);
        }

        public int getState()
        {
            return 0;
        }

        _cls2(Activity activity, Bundle bundle, Bundle bundle1)
        {
            LY = com.google.android.gms.dynamic.a.this;
            LZ = activity;
            Ma = bundle;
            Mb = bundle1;
            super();
        }
    }


    private class _cls7
        implements a
    {

        final com.google.android.gms.dynamic.a LY;

        public void b(LifecycleDelegate lifecycledelegate)
        {
            com.google.android.gms.dynamic.a.b(LY).onResume();
        }

        public int getState()
        {
            return 5;
        }

        _cls7()
        {
            LY = com.google.android.gms.dynamic.a.this;
            super();
        }
    }


    private class _cls6
        implements a
    {

        final com.google.android.gms.dynamic.a LY;

        public void b(LifecycleDelegate lifecycledelegate)
        {
            com.google.android.gms.dynamic.a.b(LY).onStart();
        }

        public int getState()
        {
            return 4;
        }

        _cls6()
        {
            LY = com.google.android.gms.dynamic.a.this;
            super();
        }
    }

}
