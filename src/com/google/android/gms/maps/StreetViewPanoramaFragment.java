// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            StreetViewPanorama, StreetViewPanoramaOptions

public class StreetViewPanoramaFragment extends Fragment
{

    private final b ZP = new b(this);
    private StreetViewPanorama ZQ;

    public StreetViewPanoramaFragment()
    {
    }

    public static StreetViewPanoramaFragment newInstance()
    {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions streetviewpanoramaoptions)
    {
        StreetViewPanoramaFragment streetviewpanoramafragment = new StreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetviewpanoramaoptions);
        streetviewpanoramafragment.setArguments(bundle);
        return streetviewpanoramafragment;
    }

    public final StreetViewPanorama getStreetViewPanorama()
    {
        IStreetViewPanoramaFragmentDelegate istreetviewpanoramafragmentdelegate = jx();
        if (istreetviewpanoramafragmentdelegate != null)
        {
            IStreetViewPanoramaDelegate istreetviewpanoramadelegate;
            try
            {
                istreetviewpanoramadelegate = istreetviewpanoramafragmentdelegate.getStreetViewPanorama();
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
            if (istreetviewpanoramadelegate != null)
            {
                if (ZQ == null || ZQ.jw().asBinder() != istreetviewpanoramadelegate.asBinder())
                {
                    ZQ = new StreetViewPanorama(istreetviewpanoramadelegate);
                }
                return ZQ;
            }
        }
        return null;
    }

    protected IStreetViewPanoramaFragmentDelegate jx()
    {
        ZP.ju();
        if (ZP.gC() == null)
        {
            return null;
        } else
        {
            return ((a)ZP.gC()).jx();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/StreetViewPanoramaFragment.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        com.google.android.gms.maps.b.a(ZP, activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ZP.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return ZP.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onDestroy()
    {
        ZP.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView()
    {
        ZP.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        com.google.android.gms.maps.b.a(ZP, activity);
        Bundle bundle1 = new Bundle();
        ZP.onInflate(activity, bundle1, bundle);
    }

    public void onLowMemory()
    {
        ZP.onLowMemory();
        super.onLowMemory();
    }

    public void onPause()
    {
        ZP.onPause();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        ZP.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/StreetViewPanoramaFragment.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        ZP.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle)
    {
        super.setArguments(bundle);
    }

    private class b extends com.google.android.gms.dynamic.a
    {

        private final Fragment Mg;
        protected f ZC;
        private Activity oe;

        static void a(b b1, Activity activity)
        {
            b1.setActivity(activity);
        }

        private void setActivity(Activity activity)
        {
            oe = activity;
            ju();
        }

        protected void a(f f1)
        {
            ZC = f1;
            ju();
        }

        public void ju()
        {
            if (oe == null || ZC == null || gC() != null)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            MapsInitializer.initialize(oe);
            IStreetViewPanoramaFragmentDelegate istreetviewpanoramafragmentdelegate = u.E(oe).j(e.h(oe));
            ZC.a(new a(Mg, istreetviewpanoramafragmentdelegate));
            return;
            RemoteException remoteexception;
            remoteexception;
            throw new RuntimeRemoteException(remoteexception);
            GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception;
            googleplayservicesnotavailableexception;
        }

        b(Fragment fragment)
        {
            Mg = fragment;
        }
    }


    private class a
        implements LifecycleDelegate
    {

        private final Fragment Mg;
        private final IStreetViewPanoramaFragmentDelegate ZR;

        public IStreetViewPanoramaFragmentDelegate jx()
        {
            return ZR;
        }

        public void onCreate(Bundle bundle)
        {
            if (bundle != null)
            {
                break MISSING_BLOCK_LABEL_12;
            }
            bundle = new Bundle();
            Bundle bundle1 = Mg.getArguments();
            if (bundle1 == null)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            if (bundle1.containsKey("StreetViewPanoramaOptions"))
            {
                t.a(bundle, "StreetViewPanoramaOptions", bundle1.getParcelable("StreetViewPanoramaOptions"));
            }
            ZR.onCreate(bundle);
            return;
            RemoteException remoteexception;
            remoteexception;
            throw new RuntimeRemoteException(remoteexception);
        }

        public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            com.google.android.gms.dynamic.d d;
            try
            {
                d = ZR.onCreateView(e.h(layoutinflater), e.h(viewgroup), bundle);
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
            return (View)e.e(d);
        }

        public void onDestroy()
        {
            try
            {
                ZR.onDestroy();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onDestroyView()
        {
            try
            {
                ZR.onDestroyView();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
        {
            try
            {
                ZR.onInflate(e.h(activity), null, bundle1);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onLowMemory()
        {
            try
            {
                ZR.onLowMemory();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onPause()
        {
            try
            {
                ZR.onPause();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onResume()
        {
            try
            {
                ZR.onResume();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onSaveInstanceState(Bundle bundle)
        {
            try
            {
                ZR.onSaveInstanceState(bundle);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onStart()
        {
        }

        public void onStop()
        {
        }

        public a(Fragment fragment, IStreetViewPanoramaFragmentDelegate istreetviewpanoramafragmentdelegate)
        {
            ZR = (IStreetViewPanoramaFragmentDelegate)hn.f(istreetviewpanoramafragmentdelegate);
            Mg = (Fragment)hn.f(fragment);
        }
    }

}
