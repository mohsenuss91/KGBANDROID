// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

// Referenced classes of package com.google.android.gms.games.internal:
//            IGamesService, IGamesCallbacks

class ko
    implements IGamesService
{

    private IBinder ko;

    public void E(boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(5068, parcel, parcel1, 0);
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

    public void F(boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(12026, parcel, parcel1, 0);
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

    public int a(IGamesCallbacks igamescallbacks, byte abyte0[], String s1, String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        int i1;
        parcel.writeStrongBinder(ibinder);
        parcel.writeByteArray(abyte0);
        parcel.writeString(s1);
        parcel.writeString(s2);
        ko.transact(5033, parcel, parcel1, 0);
        parcel1.readException();
        i1 = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i1;
        ibinder = null;
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Intent a(int i1, int j1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeInt(i1);
        parcel.writeInt(j1);
        int k1;
        k1 = 0;
        if (flag)
        {
            k1 = 1;
        }
        parcel.writeInt(k1);
        ko.transact(9008, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Intent a(int i1, byte abyte0[], int j1, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeInt(i1);
        parcel.writeByteArray(abyte0);
        parcel.writeInt(j1);
        parcel.writeString(s1);
        ko.transact(10012, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Intent a(ZInvitationCluster zinvitationcluster, String s1, String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (zinvitationcluster == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zinvitationcluster.writeToParcel(parcel, 0);
_L3:
        Intent intent;
        parcel.writeString(s1);
        parcel.writeString(s2);
        ko.transact(10021, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        parcel.writeInt(0);
          goto _L3
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        intent = null;
          goto _L4
    }

    public Intent a(GameRequestCluster gamerequestcluster, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (gamerequestcluster == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        gamerequestcluster.writeToParcel(parcel, 0);
_L3:
        Intent intent;
        parcel.writeString(s1);
        ko.transact(10022, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        parcel.writeInt(0);
          goto _L3
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        intent = null;
          goto _L4
    }

    public Intent a(RoomEntity roomentity, int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (roomentity == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        roomentity.writeToParcel(parcel, 0);
_L3:
        Intent intent;
        parcel.writeInt(i1);
        ko.transact(9011, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        parcel.writeInt(0);
          goto _L3
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        intent = null;
          goto _L4
    }

    public Intent a(String s1, boolean flag, boolean flag1, int i1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        int k1;
        Intent intent;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        parcel.writeInt(i1);
        ko.transact(12001, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Intent a(int ai[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeIntArray(ai);
        ko.transact(12030, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Intent a(ParticipantEntity aparticipantentity[], String s1, String s2, Uri uri, Uri uri1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeTypedArray(aparticipantentity, 0);
        parcel.writeString(s1);
        parcel.writeString(s2);
        if (uri == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        uri.writeToParcel(parcel, 0);
_L5:
        if (uri1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        uri1.writeToParcel(parcel, 0);
_L6:
        Intent intent;
        ko.transact(9031, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L7:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        parcel.writeInt(0);
          goto _L5
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
_L4:
        parcel.writeInt(0);
          goto _L6
        intent = null;
          goto _L7
    }

    public void a(long l1, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeLong(l1);
        parcel.writeString(s1);
        ko.transact(8019, parcel, parcel1, 0);
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

    public void a(IBinder ibinder, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeStrongBinder(ibinder);
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L1:
        ko.transact(5005, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void a(Contents contents)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (contents == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        parcel.writeInt(1);
        contents.writeToParcel(parcel, 0);
_L1:
        ko.transact(12019, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void a(IGamesCallbacks igamescallbacks)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        ko.transact(5002, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i1);
        ko.transact(10016, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, int i1, int j1, int k1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i1);
        parcel.writeInt(j1);
        parcel.writeInt(k1);
        ko.transact(10009, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, int i1, int j1, boolean flag, boolean flag1)
    {
        int k1;
        Parcel parcel;
        Parcel parcel1;
        k1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i1);
        parcel.writeInt(j1);
        int l1;
        if (flag)
        {
            l1 = k1;
        } else
        {
            l1 = 0;
        }
        parcel.writeInt(l1);
        if (!flag1)
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        ko.transact(5044, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, int i1, int j1, String as[], Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
        IBinder ibinder = igamescallbacks.asBinder();
_L5:
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i1);
        parcel.writeInt(j1);
        parcel.writeStringArray(as);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        ko.transact(8004, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        ibinder = null;
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

    public void a(IGamesCallbacks igamescallbacks, int i1, boolean flag, boolean flag1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i1);
        int k1;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(5015, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, int i1, int ai[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i1);
        parcel.writeIntArray(ai);
        ko.transact(10018, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, long l1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeLong(l1);
        ko.transact(5058, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, long l1, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeLong(l1);
        parcel.writeString(s1);
        ko.transact(8018, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, Bundle bundle, int i1, int j1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
        IBinder ibinder = igamescallbacks.asBinder();
_L5:
        parcel.writeStrongBinder(ibinder);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        parcel.writeInt(i1);
        parcel.writeInt(j1);
        ko.transact(5021, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        ibinder = null;
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

    public void a(IGamesCallbacks igamescallbacks, IBinder ibinder, int i1, String as[], Bundle bundle, boolean flag, long l1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
        IBinder ibinder1 = igamescallbacks.asBinder();
_L5:
        parcel.writeStrongBinder(ibinder1);
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i1);
        parcel.writeStringArray(as);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
        break MISSING_BLOCK_LABEL_158;
_L6:
        parcel.writeInt(j1);
        parcel.writeLong(l1);
        ko.transact(5030, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        ibinder1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
        break MISSING_BLOCK_LABEL_158;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        while (!flag) 
        {
            j1 = 0;
            break;
        }
          goto _L6
    }

    public void a(IGamesCallbacks igamescallbacks, IBinder ibinder, String s1, boolean flag, long l1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        IBinder ibinder1 = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder1);
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        parcel.writeLong(l1);
        ko.transact(5031, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ibinder1 = null;
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void a(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(5014, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        ko.transact(10011, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, int i1, int j1, int k1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        parcel.writeInt(j1);
        parcel.writeInt(k1);
        int l1;
        l1 = 0;
        if (flag)
        {
            l1 = 1;
        }
        parcel.writeInt(l1);
        ko.transact(5019, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, int i1, IBinder ibinder, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
        IBinder ibinder1 = igamescallbacks.asBinder();
_L5:
        parcel.writeStrongBinder(ibinder1);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        parcel.writeStrongBinder(ibinder);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        ko.transact(5025, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, int i1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        int j1;
        j1 = 0;
        if (flag)
        {
            j1 = 1;
        }
        parcel.writeInt(j1);
        ko.transact(8023, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, int i1, boolean flag, boolean flag1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        int k1;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(5045, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, int i1, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        int k1;
        int l1;
        int i2;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (flag1)
        {
            l1 = j1;
        } else
        {
            l1 = 0;
        }
        parcel.writeInt(l1);
        if (flag2)
        {
            i2 = j1;
        } else
        {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!flag3)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(6501, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, int i1, int ai[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        parcel.writeIntArray(ai);
        ko.transact(10019, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, long l1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeLong(l1);
        ko.transact(5016, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, long l1, String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeLong(l1);
        parcel.writeString(s2);
        ko.transact(7002, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, IBinder ibinder, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
        IBinder ibinder1 = igamescallbacks.asBinder();
_L5:
        parcel.writeStrongBinder(ibinder1);
        parcel.writeString(s1);
        parcel.writeStrongBinder(ibinder);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        ko.transact(5023, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, SnapshotMetadataChange snapshotmetadatachange, Contents contents)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
        IBinder ibinder = igamescallbacks.asBinder();
_L5:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        if (snapshotmetadatachange == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        snapshotmetadatachange.writeToParcel(parcel, 0);
_L6:
        if (contents == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        parcel.writeInt(1);
        contents.writeToParcel(parcel, 0);
_L7:
        ko.transact(12007, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        ibinder = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        parcel.writeInt(0);
          goto _L7
    }

    public void a(IGamesCallbacks igamescallbacks, String s1, String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        ko.transact(5038, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, String s2, int i1, int j1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        parcel.writeInt(i1);
        parcel.writeInt(j1);
        ko.transact(8001, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, String s2, int i1, int j1, int k1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        parcel.writeInt(i1);
        parcel.writeInt(j1);
        parcel.writeInt(k1);
        ko.transact(10010, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, String s2, int i1, int j1, int k1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        parcel.writeInt(i1);
        parcel.writeInt(j1);
        parcel.writeInt(k1);
        int l1;
        l1 = 0;
        if (flag)
        {
            l1 = 1;
        }
        parcel.writeInt(l1);
        ko.transact(5039, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, String s2, int i1, boolean flag, boolean flag1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        parcel.writeInt(i1);
        int k1;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(9028, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, String s2, SnapshotMetadataChange snapshotmetadatachange, Contents contents)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
        IBinder ibinder = igamescallbacks.asBinder();
_L5:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        if (snapshotmetadatachange == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        snapshotmetadatachange.writeToParcel(parcel, 0);
_L6:
        if (contents == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        parcel.writeInt(1);
        contents.writeToParcel(parcel, 0);
_L7:
        ko.transact(12033, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        ibinder = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        parcel.writeInt(0);
          goto _L7
    }

    public void a(IGamesCallbacks igamescallbacks, String s1, String s2, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(6002, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, String s2, int ai[], int i1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        parcel.writeIntArray(ai);
        parcel.writeInt(i1);
        int j1;
        j1 = 0;
        if (flag)
        {
            j1 = 1;
        }
        parcel.writeInt(j1);
        ko.transact(12015, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, String s2, String as[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        parcel.writeStringArray(as);
        ko.transact(10008, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, String s2, String as[], boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        parcel.writeStringArray(as);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(12028, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(5054, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, byte abyte0[], String s2, ParticipantResult aparticipantresult[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeByteArray(abyte0);
        parcel.writeString(s2);
        parcel.writeTypedArray(aparticipantresult, 0);
        ko.transact(8007, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, byte abyte0[], ParticipantResult aparticipantresult[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeByteArray(abyte0);
        parcel.writeTypedArray(aparticipantresult, 0);
        ko.transact(8008, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, int ai[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeIntArray(ai);
        ko.transact(8017, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String s1, String as[], int i1, byte abyte0[], int j1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeStringArray(as);
        parcel.writeInt(i1);
        parcel.writeByteArray(abyte0);
        parcel.writeInt(j1);
        ko.transact(10005, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(6001, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, boolean flag, Bundle bundle)
    {
        int i1;
        Parcel parcel;
        Parcel parcel1;
        i1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
        IBinder ibinder = igamescallbacks.asBinder();
_L5:
        parcel.writeStrongBinder(ibinder);
        if (!flag)
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        ko.transact(5063, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        ibinder = null;
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

    public void a(IGamesCallbacks igamescallbacks, boolean flag, String as[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        parcel.writeStringArray(as);
        ko.transact(12031, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, int ai[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeIntArray(ai);
        ko.transact(8003, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, int ai[], int i1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeIntArray(ai);
        parcel.writeInt(i1);
        int j1;
        j1 = 0;
        if (flag)
        {
            j1 = 1;
        }
        parcel.writeInt(j1);
        ko.transact(12010, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String as[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeStringArray(as);
        ko.transact(10006, parcel, parcel1, 0);
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

    public void a(IGamesCallbacks igamescallbacks, String as[], boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeStringArray(as);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(12029, parcel, parcel1, 0);
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

    public Intent aR(String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        ko.transact(9004, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Intent aU(String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        ko.transact(12034, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public String aV(String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s2;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        ko.transact(5064, parcel, parcel1, 0);
        parcel1.readException();
        s2 = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s2;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public String aW(String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s2;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        ko.transact(5035, parcel, parcel1, 0);
        parcel1.readException();
        s2 = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s2;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void aX(String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        ko.transact(5050, parcel, parcel1, 0);
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

    public int aY(String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        ko.transact(5060, parcel, parcel1, 0);
        parcel1.readException();
        i1 = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Uri aZ(String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        ko.transact(5066, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Uri uri = (Uri)Uri.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return uri;
_L2:
        uri = null;
        if (true) goto _L4; else goto _L3
_L3:
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

    public int b(byte abyte0[], String s1, String as[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeByteArray(abyte0);
        parcel.writeString(s1);
        parcel.writeStringArray(as);
        ko.transact(5034, parcel, parcel1, 0);
        parcel1.readException();
        i1 = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Intent b(int i1, int j1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeInt(i1);
        parcel.writeInt(j1);
        int k1;
        k1 = 0;
        if (flag)
        {
            k1 = 1;
        }
        parcel.writeInt(k1);
        ko.transact(9009, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void b(long l1, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeLong(l1);
        parcel.writeString(s1);
        ko.transact(8021, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        ko.transact(5017, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, int i1, boolean flag, boolean flag1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i1);
        int k1;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(5046, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, long l1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeLong(l1);
        ko.transact(8012, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, long l1, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeLong(l1);
        parcel.writeString(s1);
        ko.transact(8020, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(5018, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, String s1, int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        ko.transact(12023, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, String s1, int i1, int j1, int k1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        parcel.writeInt(j1);
        parcel.writeInt(k1);
        int l1;
        l1 = 0;
        if (flag)
        {
            l1 = 1;
        }
        parcel.writeInt(l1);
        ko.transact(5020, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, String s1, int i1, IBinder ibinder, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
        IBinder ibinder1 = igamescallbacks.asBinder();
_L5:
        parcel.writeStrongBinder(ibinder1);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        parcel.writeStrongBinder(ibinder);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        ko.transact(7003, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, String s1, int i1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        int j1;
        j1 = 0;
        if (flag)
        {
            j1 = 1;
        }
        parcel.writeInt(j1);
        ko.transact(10017, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, String s1, int i1, boolean flag, boolean flag1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        int k1;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(5501, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, String s1, IBinder ibinder, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
        IBinder ibinder1 = igamescallbacks.asBinder();
_L5:
        parcel.writeStrongBinder(ibinder1);
        parcel.writeString(s1);
        parcel.writeStrongBinder(ibinder);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        ko.transact(5024, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, String s1, String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        ko.transact(5041, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, String s1, String s2, int i1, int j1, int k1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        parcel.writeInt(i1);
        parcel.writeInt(j1);
        parcel.writeInt(k1);
        int l1;
        l1 = 0;
        if (flag)
        {
            l1 = 1;
        }
        parcel.writeInt(l1);
        ko.transact(5040, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, String s1, String s2, int i1, boolean flag, boolean flag1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        parcel.writeInt(i1);
        int k1;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(12018, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, String s1, String s2, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(6506, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, String s1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(6502, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(6503, parcel, parcel1, 0);
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

    public void b(IGamesCallbacks igamescallbacks, String as[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeStringArray(as);
        ko.transact(10007, parcel, parcel1, 0);
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

    public void b(String s1, String s2, int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        parcel.writeString(s2);
        parcel.writeInt(i1);
        ko.transact(5051, parcel, parcel1, 0);
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

    public void ba(String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        ko.transact(8002, parcel, parcel1, 0);
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

    public ParcelFileDescriptor bb(String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        ko.transact(9030, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        ParcelFileDescriptor parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return parcelfiledescriptor;
_L2:
        parcelfiledescriptor = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void c(long l1, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeLong(l1);
        parcel.writeString(s1);
        ko.transact(10004, parcel, parcel1, 0);
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

    public void c(IGamesCallbacks igamescallbacks)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        ko.transact(5022, parcel, parcel1, 0);
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

    public void c(IGamesCallbacks igamescallbacks, int i1, boolean flag, boolean flag1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i1);
        int k1;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(5048, parcel, parcel1, 0);
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

    public void c(IGamesCallbacks igamescallbacks, long l1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeLong(l1);
        ko.transact(10001, parcel, parcel1, 0);
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

    public void c(IGamesCallbacks igamescallbacks, long l1, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeLong(l1);
        parcel.writeString(s1);
        ko.transact(10003, parcel, parcel1, 0);
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

    public void c(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(5032, parcel, parcel1, 0);
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

    public void c(IGamesCallbacks igamescallbacks, String s1, int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        ko.transact(12024, parcel, parcel1, 0);
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

    public void c(IGamesCallbacks igamescallbacks, String s1, int i1, boolean flag, boolean flag1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        int k1;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(9001, parcel, parcel1, 0);
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

    public void c(IGamesCallbacks igamescallbacks, String s1, String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        ko.transact(8011, parcel, parcel1, 0);
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

    public void c(IGamesCallbacks igamescallbacks, String s1, String s2, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(12003, parcel, parcel1, 0);
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

    public void c(IGamesCallbacks igamescallbacks, String s1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(6504, parcel, parcel1, 0);
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

    public void c(IGamesCallbacks igamescallbacks, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(8027, parcel, parcel1, 0);
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

    public void c(IGamesCallbacks igamescallbacks, String as[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeStringArray(as);
        ko.transact(10020, parcel, parcel1, 0);
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

    public void c(String s1, String s2, int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        parcel.writeString(s2);
        parcel.writeInt(i1);
        ko.transact(8026, parcel, parcel1, 0);
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

    public void ch(int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeInt(i1);
        ko.transact(5036, parcel, parcel1, 0);
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

    public void d(long l1, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeLong(l1);
        parcel.writeString(s1);
        ko.transact(12014, parcel, parcel1, 0);
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

    public void d(IGamesCallbacks igamescallbacks)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        ko.transact(5026, parcel, parcel1, 0);
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

    public void d(IGamesCallbacks igamescallbacks, int i1, boolean flag, boolean flag1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i1);
        int k1;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(6003, parcel, parcel1, 0);
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

    public void d(IGamesCallbacks igamescallbacks, long l1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeLong(l1);
        ko.transact(12011, parcel, parcel1, 0);
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

    public void d(IGamesCallbacks igamescallbacks, long l1, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeLong(l1);
        parcel.writeString(s1);
        ko.transact(12013, parcel, parcel1, 0);
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

    public void d(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(5037, parcel, parcel1, 0);
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

    public void d(IGamesCallbacks igamescallbacks, String s1, int i1, boolean flag, boolean flag1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        int k1;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(9020, parcel, parcel1, 0);
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

    public void d(IGamesCallbacks igamescallbacks, String s1, String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        ko.transact(8015, parcel, parcel1, 0);
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

    public void d(IGamesCallbacks igamescallbacks, String s1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(6505, parcel, parcel1, 0);
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

    public void d(IGamesCallbacks igamescallbacks, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(12002, parcel, parcel1, 0);
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

    public void e(IGamesCallbacks igamescallbacks)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        ko.transact(5027, parcel, parcel1, 0);
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

    public void e(IGamesCallbacks igamescallbacks, int i1, boolean flag, boolean flag1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i1);
        int k1;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(6004, parcel, parcel1, 0);
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

    public void e(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(5042, parcel, parcel1, 0);
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

    public void e(IGamesCallbacks igamescallbacks, String s1, int i1, boolean flag, boolean flag1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        int k1;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(12021, parcel, parcel1, 0);
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

    public void e(IGamesCallbacks igamescallbacks, String s1, String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        ko.transact(8016, parcel, parcel1, 0);
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

    public void e(IGamesCallbacks igamescallbacks, String s1, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(12006, parcel, parcel1, 0);
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

    public void e(IGamesCallbacks igamescallbacks, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(12032, parcel, parcel1, 0);
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

    public Bundle ea()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(5004, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Bundle bundle = (Bundle)Bundle.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return bundle;
_L2:
        bundle = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void f(IGamesCallbacks igamescallbacks)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        ko.transact(5047, parcel, parcel1, 0);
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

    public void f(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(5043, parcel, parcel1, 0);
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

    public void f(IGamesCallbacks igamescallbacks, String s1, int i1, boolean flag, boolean flag1)
    {
        int j1;
        Parcel parcel;
        Parcel parcel1;
        j1 = 1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i1);
        int k1;
        if (flag)
        {
            k1 = j1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!flag1)
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        ko.transact(12022, parcel, parcel1, 0);
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

    public void f(IGamesCallbacks igamescallbacks, String s1, String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeString(s2);
        ko.transact(12009, parcel, parcel1, 0);
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

    public void f(IGamesCallbacks igamescallbacks, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        int i1;
        i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
        ko.transact(12016, parcel, parcel1, 0);
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

    public ParcelFileDescriptor g(Uri uri)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (uri == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        uri.writeToParcel(parcel, 0);
_L3:
        ParcelFileDescriptor parcelfiledescriptor;
        ko.transact(6507, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return parcelfiledescriptor;
_L2:
        parcel.writeInt(0);
          goto _L3
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        parcelfiledescriptor = null;
          goto _L4
    }

    public void g(IGamesCallbacks igamescallbacks)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        ko.transact(5049, parcel, parcel1, 0);
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

    public void g(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(5052, parcel, parcel1, 0);
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

    public String gU()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(5007, parcel, parcel1, 0);
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

    public String gV()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(5012, parcel, parcel1, 0);
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

    public Intent gY()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(9003, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Intent gZ()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(9005, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public RoomEntity h(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        int i1;
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(5053, parcel, parcel1, 0);
        parcel1.readException();
        i1 = parcel1.readInt();
        RoomEntity roomentity;
        roomentity = null;
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        roomentity = (RoomEntity)RoomEntity.CREATOR.FromParcel(parcel1);
        parcel1.recycle();
        parcel.recycle();
        return roomentity;
        ibinder = null;
          goto _L1
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void h(IGamesCallbacks igamescallbacks)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        ko.transact(5056, parcel, parcel1, 0);
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

    public Intent ha()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(9006, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Intent hb()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(9007, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Intent hg()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(9010, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Intent hh()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(9012, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public int hi()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(9019, parcel, parcel1, 0);
        parcel1.readException();
        i1 = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public String hj()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(5003, parcel, parcel1, 0);
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

    public int hk()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(8024, parcel, parcel1, 0);
        parcel1.readException();
        i1 = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Intent hl()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(10015, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public int hm()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(10013, parcel, parcel1, 0);
        parcel1.readException();
        i1 = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public int hn()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(10023, parcel, parcel1, 0);
        parcel1.readException();
        i1 = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public int ho()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(12035, parcel, parcel1, 0);
        parcel1.readException();
        i1 = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public int hp()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(12036, parcel, parcel1, 0);
        parcel1.readException();
        i1 = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void hr()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(5006, parcel, parcel1, 0);
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

    public DataHolder ht()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(5013, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        DataHolder dataholder1 = DataHolder.CREATOR.x(parcel1);
        DataHolder dataholder = dataholder1;
_L4:
        parcel1.recycle();
        parcel.recycle();
        return dataholder;
_L2:
        dataholder = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean hu()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(5067, parcel, parcel1, 0);
        parcel1.readException();
        i1 = parcel1.readInt();
        boolean flag = false;
        if (i1 != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public DataHolder hv()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(5502, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        DataHolder dataholder1 = DataHolder.CREATOR.x(parcel1);
        DataHolder dataholder = dataholder1;
_L4:
        parcel1.recycle();
        parcel.recycle();
        return dataholder;
_L2:
        dataholder = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void hw()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(8022, parcel, parcel1, 0);
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

    public Intent hx()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(9013, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)Intent.CREATOR.FromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void hy()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(11002, parcel, parcel1, 0);
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

    public boolean hz()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i1;
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        ko.transact(12025, parcel, parcel1, 0);
        parcel1.readException();
        i1 = parcel1.readInt();
        boolean flag = false;
        if (i1 != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void i(IGamesCallbacks igamescallbacks)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        ko.transact(5062, parcel, parcel1, 0);
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

    public void i(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(5061, parcel, parcel1, 0);
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

    public void j(IGamesCallbacks igamescallbacks)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        ko.transact(11001, parcel, parcel1, 0);
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

    public void j(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(5057, parcel, parcel1, 0);
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

    public void k(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(7001, parcel, parcel1, 0);
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

    public void l(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(8005, parcel, parcel1, 0);
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

    public void l(String s1, int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        parcel.writeInt(i1);
        ko.transact(12017, parcel, parcel1, 0);
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

    public void m(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(8006, parcel, parcel1, 0);
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

    public void m(String s1, int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        parcel.writeInt(i1);
        ko.transact(5029, parcel, parcel1, 0);
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

    public void m(String s1, String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        parcel.writeString(s2);
        ko.transact(5065, parcel, parcel1, 0);
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

    public void n(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(8009, parcel, parcel1, 0);
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

    public void n(String s1, int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        parcel.writeInt(i1);
        ko.transact(5028, parcel, parcel1, 0);
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

    public void n(String s1, String s2)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        parcel.writeString(s2);
        ko.transact(8025, parcel, parcel1, 0);
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

    public void o(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(8010, parcel, parcel1, 0);
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

    public void p(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(8014, parcel, parcel1, 0);
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

    public void p(String s1, int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        parcel.writeInt(i1);
        ko.transact(5055, parcel, parcel1, 0);
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

    public void q(long l1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeLong(l1);
        ko.transact(5001, parcel, parcel1, 0);
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

    public void q(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(9002, parcel, parcel1, 0);
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

    public void q(String s1, int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeString(s1);
        parcel.writeInt(i1);
        ko.transact(10014, parcel, parcel1, 0);
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

    public void r(long l1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeLong(l1);
        ko.transact(5059, parcel, parcel1, 0);
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

    public void r(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(12020, parcel, parcel1, 0);
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

    public void s(long l1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeLong(l1);
        ko.transact(8013, parcel, parcel1, 0);
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

    public void s(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(12005, parcel, parcel1, 0);
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

    public void t(long l1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeLong(l1);
        ko.transact(10002, parcel, parcel1, 0);
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

    public void t(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(12027, parcel, parcel1, 0);
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

    public void u(long l1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        parcel.writeLong(l1);
        ko.transact(12012, parcel, parcel1, 0);
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

    public void u(IGamesCallbacks igamescallbacks, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (igamescallbacks == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        IBinder ibinder = igamescallbacks.asBinder();
_L1:
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        ko.transact(12008, parcel, parcel1, 0);
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

    r(IBinder ibinder)
    {
        ko = ibinder;
    }
}
