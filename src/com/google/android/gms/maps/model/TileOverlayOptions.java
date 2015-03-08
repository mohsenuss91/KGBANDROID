// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import com.google.android.gms.maps.model.internal.i;

// Referenced classes of package com.google.android.gms.maps.model:
//            TileOverlayOptionsCreator, j, TileProvider

public final class TileOverlayOptions
    implements SafeParcelable
{

    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private float aau;
    private boolean aav;
    private i aba;
    private TileProvider abb;
    private boolean abc;
    private final int xJ;

    public TileOverlayOptions()
    {
        aav = true;
        abc = true;
        xJ = 1;
    }

    TileOverlayOptions(int k, IBinder ibinder, boolean flag, float f, boolean flag1)
    {
        aav = true;
        abc = true;
        xJ = k;
        aba = com.google.android.gms.maps.model.internal.i.a.bg(ibinder);
        Object obj;
        if (aba == null)
        {
            obj = null;
        } else
        {
            obj = new _cls1();
        }
        abb = ((TileProvider) (obj));
        aav = flag;
        aau = f;
        abc = flag1;
    }

    static i a(TileOverlayOptions tileoverlayoptions)
    {
        return tileoverlayoptions.aba;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final TileOverlayOptions fadeIn(boolean flag)
    {
        abc = flag;
        return this;
    }

    public final boolean getFadeIn()
    {
        return abc;
    }

    public final TileProvider getTileProvider()
    {
        return abb;
    }

    final int getVersionCode()
    {
        return xJ;
    }

    public final float getZIndex()
    {
        return aau;
    }

    public final boolean isVisible()
    {
        return aav;
    }

    final IBinder jL()
    {
        return aba.asBinder();
    }

    public final TileOverlayOptions tileProvider(TileProvider tileprovider)
    {
        abb = tileprovider;
        Object obj;
        if (abb == null)
        {
            obj = null;
        } else
        {
            obj = new _cls2(tileprovider);
        }
        aba = ((i) (obj));
        return this;
    }

    public final TileOverlayOptions visible(boolean flag)
    {
        aav = flag;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int k)
    {
        if (v.jG())
        {
            j.a(this, parcel, k);
            return;
        } else
        {
            TileOverlayOptionsCreator.a(this, parcel, k);
            return;
        }
    }

    public final TileOverlayOptions zIndex(float f)
    {
        aau = f;
        return this;
    }


    private class _cls1
        implements TileProvider
    {

        private final i abd;
        final TileOverlayOptions abe;

        public Tile getTile(int k, int l, int i1)
        {
            Tile tile;
            try
            {
                tile = abd.getTile(k, l, i1);
            }
            catch (RemoteException remoteexception)
            {
                return null;
            }
            return tile;
        }

        _cls1()
        {
            abe = TileOverlayOptions.this;
            super();
            abd = TileOverlayOptions.a(abe);
        }
    }


    private class _cls2 extends com.google.android.gms.maps.model.internal.i.a
    {

        final TileOverlayOptions abe;
        final TileProvider abf;

        public Tile getTile(int k, int l, int i1)
        {
            return abf.getTile(k, l, i1);
        }

        _cls2(TileProvider tileprovider)
        {
            abe = TileOverlayOptions.this;
            abf = tileprovider;
            super();
        }
    }

}
