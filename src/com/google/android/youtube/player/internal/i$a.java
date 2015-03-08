// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.youtube.player.internal:
//            i, c

public abstract class a extends Binder
    implements i
{

    public static i a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.youtube.player.internal.IServiceBroker");
        class a
            implements i
        {

            private IBinder a;

            public final void a(c c1, int j, String s, String s1, String s2, Bundle bundle)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IServiceBroker");
                if (c1 == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder1 = c1.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder1);
                parcel.writeInt(j);
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeString(s2);
                if (bundle == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L6:
                a.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                ibinder1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public final IBinder asBinder()
            {
                return a;
            }

            a(IBinder ibinder)
            {
                a = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof i))
        {
            return (i)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int j, Parcel parcel, Parcel parcel1, int k)
    {
        IBinder ibinder;
        switch (j)
        {
        default:
            return super.onTransact(j, parcel, parcel1, k);

        case 1598968902: 
            parcel1.writeString("com.google.android.youtube.player.internal.IServiceBroker");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IServiceBroker");
            ibinder = parcel.readStrongBinder();
            break;
        }
        Object obj;
        int l;
        String s;
        String s1;
        String s2;
        int i1;
        Bundle bundle;
        if (ibinder == null)
        {
            obj = null;
        } else
        {
            android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.youtube.player.internal.IConnectionCallbacks");
            if (iinterface != null && (iinterface instanceof c))
            {
                obj = (c)iinterface;
            } else
            {
                obj = new a(ibinder);
            }
        }
        l = parcel.readInt();
        s = parcel.readString();
        s1 = parcel.readString();
        s2 = parcel.readString();
        i1 = parcel.readInt();
        bundle = null;
        if (i1 != 0)
        {
            bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        }
        a(((c) (obj)), l, s, s1, s2, bundle);
        parcel1.writeNoException();
        return true;
    }
}
