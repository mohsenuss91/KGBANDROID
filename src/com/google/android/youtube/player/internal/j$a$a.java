// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.youtube.player.internal:
//            j

final class a
    implements j
{

    private IBinder a;

    public final void a(Bitmap bitmap, String s, boolean flag, boolean flag1)
    {
        int i;
        Parcel parcel;
        Parcel parcel1;
        i = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        parcel.writeInt(1);
        bitmap.writeToParcel(parcel, 0);
_L1:
        parcel.writeString(s);
        Exception exception;
        int k;
        if (flag)
        {
            k = i;
        } else
        {
            k = 0;
        }
        parcel.writeInt(k);
        if (!flag1)
        {
            i = 0;
        }
        parcel.writeInt(i);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public final void a(String s, boolean flag, boolean flag1)
    {
        int i;
        Parcel parcel;
        Parcel parcel1;
        i = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
        parcel.writeString(s);
        int k;
        if (flag)
        {
            k = i;
        } else
        {
            k = 0;
        }
        parcel.writeInt(k);
        if (!flag1)
        {
            i = 0;
        }
        parcel.writeInt(i);
        a.transact(2, parcel, parcel1, 0);
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

    public final IBinder asBinder()
    {
        return a;
    }

    (IBinder ibinder)
    {
        a = ibinder;
    }
}
