// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.d;

// Referenced classes of package com.google.android.gms.internal:
//            hk

class ko
    implements hk
{

    private IBinder ko;

    public d a(d d1, int i, int j)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (d1 == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        IBinder ibinder = d1.asBinder();
_L1:
        d d2;
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        parcel.writeInt(j);
        ko.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        d2 = com.google.android.gms.dynamic..ko(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d2;
        ibinder = null;
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public IBinder asBinder()
    {
        return ko;
    }

    (IBinder ibinder)
    {
        ko = ibinder;
    }
}
