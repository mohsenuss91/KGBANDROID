// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;

// Referenced classes of package com.google.android.gms.internal:
//            fw

public abstract class attachInterface extends Binder
    implements fw
{

    public static fw B(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
        class a
            implements fw
        {

            private IBinder ko;

            public void a(Status status)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                if (status == null)
                {
                    break MISSING_BLOCK_LABEL_44;
                }
                parcel.writeInt(1);
                status.writeToParcel(parcel, 0);
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

            public void a(Status status, ParcelFileDescriptor parcelfiledescriptor)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                if (status == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                status.writeToParcel(parcel, 0);
_L3:
                if (parcelfiledescriptor == null)
                {
                    break MISSING_BLOCK_LABEL_76;
                }
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
_L4:
                ko.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public void a(Status status, boolean flag)
            {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                if (status == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                status.writeToParcel(parcel, 0);
                  goto _L3
_L5:
                parcel.writeInt(i);
                ko.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                break; /* Loop/switch isn't completed */
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
_L6:
                i = 0;
                if (true) goto _L4; else goto _L3
_L4:
                break; /* Loop/switch isn't completed */
_L3:
                if (!flag) goto _L6; else goto _L5
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

        if (iinterface != null && (iinterface instanceof fw))
        {
            return (fw)iinterface;
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
        Status status;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            int i1 = parcel.readInt();
            Status status2 = null;
            if (i1 != 0)
            {
                status2 = Status.CREATOR.createFromParcel(parcel);
            }
            a(status2);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            Status status1;
            int l;
            ParcelFileDescriptor parcelfiledescriptor;
            if (parcel.readInt() != 0)
            {
                status1 = Status.CREATOR.createFromParcel(parcel);
            } else
            {
                status1 = null;
            }
            l = parcel.readInt();
            parcelfiledescriptor = null;
            if (l != 0)
            {
                parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            }
            a(status1, parcelfiledescriptor);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            k = parcel.readInt();
            status = null;
            break;
        }
        if (k != 0)
        {
            status = Status.CREATOR.createFromParcel(parcel);
        }
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(status, flag);
        return true;
    }

    public tusCreator()
    {
        attachInterface(this, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
    }
}
