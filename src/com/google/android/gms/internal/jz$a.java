// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

// Referenced classes of package com.google.android.gms.internal:
//            jz

public abstract class taHolder extends Binder
    implements jz
{

    public static jz au(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
        class a
            implements jz
        {

            private IBinder ko;

            public void V(DataHolder dataholder)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                if (dataholder == null)
                {
                    break MISSING_BLOCK_LABEL_44;
                }
                parcel.writeInt(1);
                dataholder.writeToParcel(parcel, 0);
_L1:
                ko.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void W(DataHolder dataholder)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                if (dataholder == null)
                {
                    break MISSING_BLOCK_LABEL_44;
                }
                parcel.writeInt(1);
                dataholder.writeToParcel(parcel, 0);
_L1:
                ko.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void X(DataHolder dataholder)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                if (dataholder == null)
                {
                    break MISSING_BLOCK_LABEL_44;
                }
                parcel.writeInt(1);
                dataholder.writeToParcel(parcel, 0);
_L1:
                ko.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public IBinder asBinder()
            {
                return ko;
            }

            a(IBinder ibinder)
            {
                ko = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof jz))
        {
            return (jz)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        int k;
        DataHolder dataholder;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            int i1 = parcel.readInt();
            DataHolder dataholder2 = null;
            if (i1 != 0)
            {
                dataholder2 = DataHolder.CREATOR.x(parcel);
            }
            V(dataholder2);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            int l = parcel.readInt();
            DataHolder dataholder1 = null;
            if (l != 0)
            {
                dataholder1 = DataHolder.CREATOR.x(parcel);
            }
            W(dataholder1);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            k = parcel.readInt();
            dataholder = null;
            break;
        }
        if (k != 0)
        {
            dataholder = DataHolder.CREATOR.x(parcel);
        }
        X(dataholder);
        return true;
    }
}
