// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            StreetViewPanoramaOptions

class aaa extends a
{

    protected f ZC;
    private final ViewGroup ZH;
    private final StreetViewPanoramaOptions aaa;
    private final Context mContext;

    protected void a(f f1)
    {
        ZC = f1;
        ju();
    }

    public void ju()
    {
        if (ZC == null || gC() != null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate istreetviewpanoramaviewdelegate = u.E(mContext).a(e.h(mContext), aaa);
        ZC.a(new <init>(ZH, istreetviewpanoramaviewdelegate));
        return;
        RemoteException remoteexception;
        remoteexception;
        throw new RuntimeRemoteException(remoteexception);
        GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception;
        googleplayservicesnotavailableexception;
    }

    (ViewGroup viewgroup, Context context, StreetViewPanoramaOptions streetviewpanoramaoptions)
    {
        ZH = viewgroup;
        mContext = context;
        aaa = streetviewpanoramaoptions;
    }
}
