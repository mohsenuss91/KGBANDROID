// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

// Referenced classes of package com.google.android.gms.maps.internal:
//            ICameraUpdateFactoryDelegate

class ko
    implements ICameraUpdateFactoryDelegate
{

    private IBinder ko;

    public IBinder asBinder()
    {
        return ko;
    }

    public d newCameraPosition(CameraPosition cameraposition)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (cameraposition == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        parcel.writeInt(1);
        cameraposition.writeToParcel(parcel, 0);
_L1:
        d d;
        ko.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        d = com.google.android.gms.dynamic.e.a.a.ko(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d;
        parcel.writeInt(0);
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public d newLatLng(LatLng latlng)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (latlng == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        parcel.writeInt(1);
        latlng.writeToParcel(parcel, 0);
_L1:
        d d;
        ko.transact(8, parcel, parcel1, 0);
        parcel1.readException();
        d = com.google.android.gms.dynamic.e.a.a.ko(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d;
        parcel.writeInt(0);
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public d newLatLngBounds(LatLngBounds latlngbounds, int i)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (latlngbounds == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        parcel.writeInt(1);
        latlngbounds.writeToParcel(parcel, 0);
_L1:
        d d;
        parcel.writeInt(i);
        ko.transact(10, parcel, parcel1, 0);
        parcel1.readException();
        d = com.google.android.gms.dynamic.e.a.a.ko(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d;
        parcel.writeInt(0);
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public d newLatLngBoundsWithSize(LatLngBounds latlngbounds, int i, int j, int k)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (latlngbounds == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        parcel.writeInt(1);
        latlngbounds.writeToParcel(parcel, 0);
_L1:
        d d;
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeInt(k);
        ko.transact(11, parcel, parcel1, 0);
        parcel1.readException();
        d = com.google.android.gms.dynamic.e.a.a.ko(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d;
        parcel.writeInt(0);
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public d newLatLngZoom(LatLng latlng, float f)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (latlng == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        parcel.writeInt(1);
        latlng.writeToParcel(parcel, 0);
_L1:
        d d;
        parcel.writeFloat(f);
        ko.transact(9, parcel, parcel1, 0);
        parcel1.readException();
        d = com.google.android.gms.dynamic.e.a.a.ko(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d;
        parcel.writeInt(0);
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public d scrollBy(float f, float f1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        d d;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        parcel.writeFloat(f);
        parcel.writeFloat(f1);
        ko.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        d = com.google.android.gms.dynamic.e.a.a.ko(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public d zoomBy(float f)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        d d;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        parcel.writeFloat(f);
        ko.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        d = com.google.android.gms.dynamic.e.a.a.ko(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public d zoomByWithFocus(float f, int i, int j)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        d d;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        parcel.writeFloat(f);
        parcel.writeInt(i);
        parcel.writeInt(j);
        ko.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        d = com.google.android.gms.dynamic.e.a.a.ko(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public d zoomIn()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        d d;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        ko.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        d = com.google.android.gms.dynamic.e.a.a.ko(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public d zoomOut()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        d d;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        ko.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        d = com.google.android.gms.dynamic.e.a.a.ko(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public d zoomTo(float f)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        d d;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        parcel.writeFloat(f);
        ko.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        d = com.google.android.gms.dynamic.e.a.a.ko(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    (IBinder ibinder)
    {
        ko = ibinder;
    }
}
