// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

// Referenced classes of package com.google.android.gms.drive.internal:
//            DeleteCustomPropertyRequest

public class m
    implements android.os.Parcelable.Creator
{

    public m()
    {
    }

    static void a(DeleteCustomPropertyRequest deletecustompropertyrequest, Parcel parcel, int i)
    {
        int j = b.C(parcel);
        b.c(parcel, 1, deletecustompropertyrequest.xJ);
        b.a(parcel, 2, deletecustompropertyrequest.Hw, i, false);
        b.a(parcel, 3, deletecustompropertyrequest.IG, i, false);
        b.G(parcel, j);
    }

    public DeleteCustomPropertyRequest[] aW(int i)
    {
        return new DeleteCustomPropertyRequest[i];
    }

    public DeleteCustomPropertyRequest aa(Parcel parcel)
    {
        int i = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        DriveId driveid = null;
        int j = 0;
        CustomPropertyKey custompropertykey = null;
        do
        {
            if (parcel.dataPosition() < i)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.ar(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, DriveId.CREATOR);
                    break;

                case 3: // '\003'
                    custompropertykey = (CustomPropertyKey)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, CustomPropertyKey.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != i)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(i).toString(), parcel);
            } else
            {
                return new DeleteCustomPropertyRequest(j, driveid, custompropertykey);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aa(parcel);
    }

    public Object[] newArray(int i)
    {
        return aW(i);
    }
}
