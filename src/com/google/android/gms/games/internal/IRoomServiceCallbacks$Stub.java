// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

// Referenced classes of package com.google.android.gms.games.internal:
//            IRoomServiceCallbacks, ConnectionInfo, ConnectionInfoCreator

public abstract class attachInterface extends Binder
    implements IRoomServiceCallbacks
{

    public static IRoomServiceCallbacks am(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        class Proxy
            implements IRoomServiceCallbacks
        {

            private IBinder ko;

            public void a(ParcelFileDescriptor parcelfiledescriptor, int i)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                if (parcelfiledescriptor == null)
                {
                    break MISSING_BLOCK_LABEL_51;
                }
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                ko.transact(1024, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void a(ConnectionInfo connectioninfo)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                if (connectioninfo == null)
                {
                    break MISSING_BLOCK_LABEL_46;
                }
                parcel.writeInt(1);
                connectioninfo.writeToParcel(parcel, 0);
_L1:
                ko.transact(1022, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void a(String s, byte abyte0[], int i)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                parcel.writeByteArray(abyte0);
                parcel.writeInt(i);
                ko.transact(1002, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void a(String s, String as[])
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                parcel.writeStringArray(as);
                ko.transact(1008, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void al(IBinder ibinder1)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeStrongBinder(ibinder1);
                ko.transact(1021, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public IBinder asBinder()
            {
                return ko;
            }

            public void b(String s, String as[])
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                parcel.writeStringArray(as);
                ko.transact(1009, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void bg(String s)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                ko.transact(1003, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void bh(String s)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                ko.transact(1004, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void bi(String s)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                ko.transact(1005, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void bj(String s)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                ko.transact(1006, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void bk(String s)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                ko.transact(1007, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void bl(String s)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                ko.transact(1018, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void bm(String s)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                ko.transact(1019, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void c(int i, int j, String s)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeString(s);
                ko.transact(1001, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void c(String s, String as[])
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                parcel.writeStringArray(as);
                ko.transact(1010, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void ck(int i)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeInt(i);
                ko.transact(1020, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void d(String s, String as[])
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                parcel.writeStringArray(as);
                ko.transact(1011, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void e(String s, String as[])
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                parcel.writeStringArray(as);
                ko.transact(1012, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void f(String s, String as[])
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                parcel.writeStringArray(as);
                ko.transact(1013, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void g(String s, String as[])
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                parcel.writeStringArray(as);
                ko.transact(1017, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void hE()
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                ko.transact(1016, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void hF()
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                ko.transact(1023, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onP2PConnected(String s)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                ko.transact(1014, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onP2PDisconnected(String s)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                ko.transact(1015, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void t(String s, int i)
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                parcel.writeString(s);
                parcel.writeInt(i);
                ko.transact(1025, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            Proxy(IBinder ibinder)
            {
                ko = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof IRoomServiceCallbacks))
        {
            return (IRoomServiceCallbacks)iinterface;
        } else
        {
            return new Proxy(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            return true;

        case 1001: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            c(parcel.readInt(), parcel.readInt(), parcel.readString());
            return true;

        case 1002: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            a(parcel.readString(), parcel.createByteArray(), parcel.readInt());
            return true;

        case 1003: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            bg(parcel.readString());
            return true;

        case 1004: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            bh(parcel.readString());
            return true;

        case 1005: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            bi(parcel.readString());
            return true;

        case 1006: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            bj(parcel.readString());
            return true;

        case 1007: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            bk(parcel.readString());
            return true;

        case 1008: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            a(parcel.readString(), parcel.createStringArray());
            return true;

        case 1009: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            b(parcel.readString(), parcel.createStringArray());
            return true;

        case 1010: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            c(parcel.readString(), parcel.createStringArray());
            return true;

        case 1011: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            d(parcel.readString(), parcel.createStringArray());
            return true;

        case 1012: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            e(parcel.readString(), parcel.createStringArray());
            return true;

        case 1013: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            f(parcel.readString(), parcel.createStringArray());
            return true;

        case 1014: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            onP2PConnected(parcel.readString());
            return true;

        case 1015: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            onP2PDisconnected(parcel.readString());
            return true;

        case 1016: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            hE();
            return true;

        case 1017: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            g(parcel.readString(), parcel.createStringArray());
            return true;

        case 1018: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            bl(parcel.readString());
            return true;

        case 1019: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            bm(parcel.readString());
            return true;

        case 1020: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            ck(parcel.readInt());
            return true;

        case 1021: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            al(parcel.readStrongBinder());
            return true;

        case 1022: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            int l = parcel.readInt();
            ConnectionInfo connectioninfo = null;
            if (l != 0)
            {
                connectioninfo = ConnectionInfo.CREATOR.bf(parcel);
            }
            a(connectioninfo);
            return true;

        case 1023: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            hF();
            return true;

        case 1024: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            int k = parcel.readInt();
            ParcelFileDescriptor parcelfiledescriptor = null;
            if (k != 0)
            {
                parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.omParcel(parcel);
            }
            a(parcelfiledescriptor, parcel.readInt());
            return true;

        case 1025: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            t(parcel.readString(), parcel.readInt());
            return true;
        }
    }

    public Proxy()
    {
        attachInterface(this, "com.google.android.gms.games.internal.IRoomServiceCallbacks");
    }
}
