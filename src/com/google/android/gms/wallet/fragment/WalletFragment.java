// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            WalletFragmentOptions, WalletFragmentInitParams

public final class WalletFragment extends Fragment
{

    private final Fragment Mg = this;
    private WalletFragmentOptions akh;
    private WalletFragmentInitParams aki;
    private MaskedWalletRequest akj;
    private MaskedWallet akk;
    private Boolean akl;
    private b akq;
    private final com.google.android.gms.dynamic.b akr = com.google.android.gms.dynamic.b.a(this);
    private final c aks = new c(null);
    private a akt;
    private boolean mCreated;

    public WalletFragment()
    {
        mCreated = false;
        akt = new a();
    }

    static Fragment a(WalletFragment walletfragment)
    {
        return walletfragment.Mg;
    }

    static MaskedWallet a(WalletFragment walletfragment, MaskedWallet maskedwallet)
    {
        walletfragment.akk = maskedwallet;
        return maskedwallet;
    }

    static MaskedWalletRequest a(WalletFragment walletfragment, MaskedWalletRequest maskedwalletrequest)
    {
        walletfragment.akj = maskedwalletrequest;
        return maskedwalletrequest;
    }

    static b a(WalletFragment walletfragment, b b1)
    {
        walletfragment.akq = b1;
        return b1;
    }

    static WalletFragmentInitParams a(WalletFragment walletfragment, WalletFragmentInitParams walletfragmentinitparams)
    {
        walletfragment.aki = walletfragmentinitparams;
        return walletfragmentinitparams;
    }

    static WalletFragmentOptions a(WalletFragment walletfragment, WalletFragmentOptions walletfragmentoptions)
    {
        walletfragment.akh = walletfragmentoptions;
        return walletfragmentoptions;
    }

    static Boolean a(WalletFragment walletfragment, Boolean boolean1)
    {
        walletfragment.akl = boolean1;
        return boolean1;
    }

    static b b(WalletFragment walletfragment)
    {
        return walletfragment.akq;
    }

    static boolean c(WalletFragment walletfragment)
    {
        return walletfragment.mCreated;
    }

    static b d(WalletFragment walletfragment)
    {
        return walletfragment.akr;
    }

    static WalletFragmentOptions e(WalletFragment walletfragment)
    {
        return walletfragment.akh;
    }

    static a f(WalletFragment walletfragment)
    {
        return walletfragment.akt;
    }

    static WalletFragmentInitParams g(WalletFragment walletfragment)
    {
        return walletfragment.aki;
    }

    static MaskedWalletRequest h(WalletFragment walletfragment)
    {
        return walletfragment.akj;
    }

    static MaskedWallet i(WalletFragment walletfragment)
    {
        return walletfragment.akk;
    }

    static Boolean j(WalletFragment walletfragment)
    {
        return walletfragment.akl;
    }

    public static WalletFragment newInstance(WalletFragmentOptions walletfragmentoptions)
    {
        WalletFragment walletfragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", walletfragmentoptions);
        walletfragment.Mg.setArguments(bundle);
        return walletfragment;
    }

    public final int getState()
    {
        if (akq != null)
        {
            return com.google.android.gms.wallet.fragment.b.a(akq);
        } else
        {
            return 0;
        }
    }

    public final void initialize(WalletFragmentInitParams walletfragmentinitparams)
    {
        if (akq != null)
        {
            com.google.android.gms.wallet.fragment.b.a(akq, walletfragmentinitparams);
            aki = null;
        } else
        if (aki == null)
        {
            aki = walletfragmentinitparams;
            if (akj != null)
            {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (akk != null)
            {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
                return;
            }
        } else
        {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
            return;
        }
    }

    public final void onActivityResult(int k, int l, Intent intent)
    {
        super.onActivityResult(k, l, intent);
        if (akq != null)
        {
            com.google.android.gms.wallet.fragment.b.a(akq, k, l, intent);
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        bundle.setClassLoader(com/google/android/gms/wallet/fragment/WalletFragmentOptions.getClassLoader());
        WalletFragmentInitParams walletfragmentinitparams = (WalletFragmentInitParams)bundle.getParcelable("walletFragmentInitParams");
        if (walletfragmentinitparams != null)
        {
            if (aki != null)
            {
                Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
            }
            aki = walletfragmentinitparams;
        }
        if (akj == null)
        {
            akj = (MaskedWalletRequest)bundle.getParcelable("maskedWalletRequest");
        }
        if (akk == null)
        {
            akk = (MaskedWallet)bundle.getParcelable("maskedWallet");
        }
        if (bundle.containsKey("walletFragmentOptions"))
        {
            akh = (WalletFragmentOptions)bundle.getParcelable("walletFragmentOptions");
        }
        if (bundle.containsKey("enabled"))
        {
            akl = Boolean.valueOf(bundle.getBoolean("enabled"));
        }
_L4:
        mCreated = true;
        aks.onCreate(bundle);
        return;
_L2:
        if (Mg.getArguments() != null)
        {
            WalletFragmentOptions walletfragmentoptions = (WalletFragmentOptions)Mg.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletfragmentoptions != null)
            {
                walletfragmentoptions.N(Mg.getActivity());
                akh = walletfragmentoptions;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return aks.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public final void onDestroy()
    {
        super.onDestroy();
        mCreated = false;
    }

    public final void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        if (akh == null)
        {
            akh = com.google.android.gms.wallet.fragment.WalletFragmentOptions.a(activity, attributeset);
        }
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("attrKeyWalletFragmentOptions", akh);
        aks.onInflate(activity, bundle1, bundle);
    }

    public final void onPause()
    {
        super.onPause();
        aks.onPause();
    }

    public final void onResume()
    {
        super.onResume();
        aks.onResume();
        FragmentManager fragmentmanager = Mg.getActivity().getFragmentManager();
        Fragment fragment = fragmentmanager.findFragmentByTag("GooglePlayServicesErrorDialog");
        if (fragment != null)
        {
            fragmentmanager.beginTransaction().remove(fragment).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(Mg.getActivity()), Mg.getActivity(), -1);
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(com/google/android/gms/wallet/fragment/WalletFragmentOptions.getClassLoader());
        aks.onSaveInstanceState(bundle);
        if (aki != null)
        {
            bundle.putParcelable("walletFragmentInitParams", aki);
            aki = null;
        }
        if (akj != null)
        {
            bundle.putParcelable("maskedWalletRequest", akj);
            akj = null;
        }
        if (akk != null)
        {
            bundle.putParcelable("maskedWallet", akk);
            akk = null;
        }
        if (akh != null)
        {
            bundle.putParcelable("walletFragmentOptions", akh);
            akh = null;
        }
        if (akl != null)
        {
            bundle.putBoolean("enabled", akl.booleanValue());
            akl = null;
        }
    }

    public final void onStart()
    {
        super.onStart();
        aks.onStart();
    }

    public final void onStop()
    {
        super.onStop();
        aks.onStop();
    }

    public final void setEnabled(boolean flag)
    {
        if (akq != null)
        {
            com.google.android.gms.wallet.fragment.b.a(akq, flag);
            akl = null;
            return;
        } else
        {
            akl = Boolean.valueOf(flag);
            return;
        }
    }

    public final void setOnStateChangedListener(OnStateChangedListener onstatechangedlistener)
    {
        akt.a(onstatechangedlistener);
    }

    public final void updateMaskedWallet(MaskedWallet maskedwallet)
    {
        if (akq != null)
        {
            com.google.android.gms.wallet.fragment.b.a(akq, maskedwallet);
            akk = null;
            return;
        } else
        {
            akk = maskedwallet;
            return;
        }
    }

    public final void updateMaskedWalletRequest(MaskedWalletRequest maskedwalletrequest)
    {
        if (akq != null)
        {
            com.google.android.gms.wallet.fragment.b.a(akq, maskedwalletrequest);
            akj = null;
            return;
        } else
        {
            akj = maskedwalletrequest;
            return;
        }
    }

    private class c extends com.google.android.gms.dynamic.a
        implements android.view.View.OnClickListener
    {

        final WalletFragment akw;

        protected void a(FrameLayout framelayout)
        {
            int k = -1;
            int l = -2;
            Button button = new Button(com.google.android.gms.wallet.fragment.WalletFragment.a(akw).getActivity());
            button.setText(com.google.android.gms.R.string.wallet_buy_button_place_holder);
            if (com.google.android.gms.wallet.fragment.WalletFragment.e(akw) != null)
            {
                WalletFragmentStyle walletfragmentstyle = com.google.android.gms.wallet.fragment.WalletFragment.e(akw).getFragmentStyle();
                if (walletfragmentstyle != null)
                {
                    android.util.DisplayMetrics displaymetrics = com.google.android.gms.wallet.fragment.WalletFragment.a(akw).getResources().getDisplayMetrics();
                    k = walletfragmentstyle.a("buyButtonWidth", displaymetrics, k);
                    l = walletfragmentstyle.a("buyButtonHeight", displaymetrics, l);
                }
            }
            button.setLayoutParams(new android.view.ViewGroup.LayoutParams(k, l));
            button.setOnClickListener(this);
            framelayout.addView(button);
        }

        protected void a(f f1)
        {
            Activity activity = com.google.android.gms.wallet.fragment.WalletFragment.a(akw).getActivity();
            if (com.google.android.gms.wallet.fragment.WalletFragment.b(akw) == null && WalletFragment.c(akw) && activity != null)
            {
                try
                {
                    ll ll = lt.a(activity, WalletFragment.d(akw), com.google.android.gms.wallet.fragment.WalletFragment.e(akw), com.google.android.gms.wallet.fragment.WalletFragment.f(akw));
                    com.google.android.gms.wallet.fragment.WalletFragment.a(akw, new b(ll, null));
                    com.google.android.gms.wallet.fragment.WalletFragment.a(akw, null);
                }
                catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
                {
                    return;
                }
                f1.a(com.google.android.gms.wallet.fragment.WalletFragment.b(akw));
                if (WalletFragment.g(akw) != null)
                {
                    com.google.android.gms.wallet.fragment.b.a(com.google.android.gms.wallet.fragment.WalletFragment.b(akw), WalletFragment.g(akw));
                    com.google.android.gms.wallet.fragment.WalletFragment.a(akw, null);
                }
                if (WalletFragment.h(akw) != null)
                {
                    com.google.android.gms.wallet.fragment.b.a(com.google.android.gms.wallet.fragment.WalletFragment.b(akw), WalletFragment.h(akw));
                    com.google.android.gms.wallet.fragment.WalletFragment.a(akw, null);
                }
                if (WalletFragment.i(akw) != null)
                {
                    com.google.android.gms.wallet.fragment.b.a(com.google.android.gms.wallet.fragment.WalletFragment.b(akw), WalletFragment.i(akw));
                    com.google.android.gms.wallet.fragment.WalletFragment.a(akw, null);
                }
                if (WalletFragment.j(akw) != null)
                {
                    com.google.android.gms.wallet.fragment.b.a(com.google.android.gms.wallet.fragment.WalletFragment.b(akw), WalletFragment.j(akw).booleanValue());
                    com.google.android.gms.wallet.fragment.WalletFragment.a(akw, null);
                }
            }
        }

        public void onClick(View view)
        {
            Activity activity = com.google.android.gms.wallet.fragment.WalletFragment.a(akw).getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        private c()
        {
            akw = WalletFragment.this;
            super();
        }

        c(_cls1 _pcls1)
        {
            this();
        }
    }


    private class a extends com.google.android.gms.internal.lm.a
    {

        private OnStateChangedListener aku;
        private final WalletFragment akv;

        public void a(int k, int l, Bundle bundle)
        {
            if (aku != null)
            {
                aku.onStateChanged(akv, k, l, bundle);
            }
        }

        public void a(OnStateChangedListener onstatechangedlistener)
        {
            aku = onstatechangedlistener;
        }

        a()
        {
            akv = WalletFragment.this;
        }

        private class OnStateChangedListener
        {

            public abstract void onStateChanged(WalletFragment walletfragment, int k, int l, Bundle bundle);
        }

    }


    private class b
        implements LifecycleDelegate
    {

        private final ll ako;

        static int a(b b1)
        {
            return b1.getState();
        }

        static void a(b b1, int k, int l, Intent intent)
        {
            b1.onActivityResult(k, l, intent);
        }

        static void a(b b1, MaskedWallet maskedwallet)
        {
            b1.updateMaskedWallet(maskedwallet);
        }

        static void a(b b1, MaskedWalletRequest maskedwalletrequest)
        {
            b1.updateMaskedWalletRequest(maskedwalletrequest);
        }

        static void a(b b1, WalletFragmentInitParams walletfragmentinitparams)
        {
            b1.initialize(walletfragmentinitparams);
        }

        static void a(b b1, boolean flag)
        {
            b1.setEnabled(flag);
        }

        private int getState()
        {
            int k;
            try
            {
                k = ako.getState();
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
            return k;
        }

        private void initialize(WalletFragmentInitParams walletfragmentinitparams)
        {
            try
            {
                ako.initialize(walletfragmentinitparams);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        private void onActivityResult(int k, int l, Intent intent)
        {
            try
            {
                ako.onActivityResult(k, l, intent);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        private void setEnabled(boolean flag)
        {
            try
            {
                ako.setEnabled(flag);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        private void updateMaskedWallet(MaskedWallet maskedwallet)
        {
            try
            {
                ako.updateMaskedWallet(maskedwallet);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest maskedwalletrequest)
        {
            try
            {
                ako.updateMaskedWalletRequest(maskedwalletrequest);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        public void onCreate(Bundle bundle)
        {
            try
            {
                ako.onCreate(bundle);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            View view;
            try
            {
                view = (View)com.google.android.gms.dynamic.e.e(ako.onCreateView(com.google.android.gms.dynamic.e.h(layoutinflater), com.google.android.gms.dynamic.e.h(viewgroup), bundle));
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
            return view;
        }

        public void onDestroy()
        {
        }

        public void onDestroyView()
        {
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
        {
            WalletFragmentOptions walletfragmentoptions = (WalletFragmentOptions)bundle.getParcelable("extraWalletFragmentOptions");
            try
            {
                ako.a(com.google.android.gms.dynamic.e.h(activity), walletfragmentoptions, bundle1);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        public void onLowMemory()
        {
        }

        public void onPause()
        {
            try
            {
                ako.onPause();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        public void onResume()
        {
            try
            {
                ako.onResume();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        public void onSaveInstanceState(Bundle bundle)
        {
            try
            {
                ako.onSaveInstanceState(bundle);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        public void onStart()
        {
            try
            {
                ako.onStart();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        public void onStop()
        {
            try
            {
                ako.onStop();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeException(remoteexception);
            }
        }

        private b(ll ll1)
        {
            ako = ll1;
        }

        b(ll ll1, _cls1 _pcls1)
        {
            this(ll1);
        }
    }

}
