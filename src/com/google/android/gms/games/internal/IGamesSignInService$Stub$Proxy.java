// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.games.internal:
//            IGamesSignInService, IGamesSignInCallbacks

class 
    implements IGamesSignInService
{

    private IBinder ko;

    public void a(IGamesSignInCallbacks igamessignincallbacks, String s, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
        if (igamessignincallbacks == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        IBinder ibinder = igamessignincallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s);
        parcel.writeString(s1);
        ko.transact(5006, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ibinder = null;
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void a(IGamesSignInCallbacks igamessignincallbacks, String s, String s1, String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
        if (igamessignincallbacks == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        IBinder ibinder = igamessignincallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeString(s2);
        ko.transact(5005, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ibinder = null;
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void a(IGamesSignInCallbacks igamessignincallbacks, String s, String s1, String as[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
        if (igamessignincallbacks == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        IBinder ibinder = igamessignincallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeStringArray(as);
        ko.transact(5004, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ibinder = null;
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void a(IGamesSignInCallbacks igamessignincallbacks, String s, String s1, String as[], String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
        if (igamessignincallbacks == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        IBinder ibinder = igamessignincallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeStringArray(as);
        parcel.writeString(s2);
        ko.transact(5003, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
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

    public void b(IGamesSignInCallbacks igamessignincallbacks, String s, String s1, String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
        if (igamessignincallbacks == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        IBinder ibinder = igamessignincallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeString(s2);
        ko.transact(5007, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ibinder = null;
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void b(IGamesSignInCallbacks igamessignincallbacks, String s, String s1, String as[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
        if (igamessignincallbacks == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        IBinder ibinder = igamessignincallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeStringArray(as);
        ko.transact(5008, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ibinder = null;
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public String bc(String s)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
        parcel.writeString(s);
        ko.transact(5001, parcel, parcel1, 0);
        parcel1.readException();
        s1 = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public String bd(String s)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
        parcel.writeString(s);
        ko.transact(5002, parcel, parcel1, 0);
        parcel1.readException();
        s1 = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public String f(String s, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
        parcel.writeString(s);
        int i;
        i = 0;
        if (flag)
        {
            i = 1;
        }
        String s1;
        parcel.writeInt(i);
        ko.transact(5009, parcel, parcel1, 0);
        parcel1.readException();
        s1 = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void o(String s, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
        parcel.writeString(s);
        parcel.writeString(s1);
        ko.transact(9001, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }
}
