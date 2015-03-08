// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

// Referenced classes of package com.google.android.gms.internal:
//            kq, kr

public final class ks extends d
    implements Moment
{

    private kq adm;

    public ks(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    private kq kz()
    {
        this;
        JVM INSTR monitorenter ;
        if (adm == null)
        {
            byte abyte0[] = getByteArray("momentImpl");
            Parcel parcel = Parcel.obtain();
            parcel.unmarshall(abyte0, 0, abyte0.length);
            parcel.setDataPosition(0);
            adm = kq.CREATOR.bF(parcel);
            parcel.recycle();
        }
        this;
        JVM INSTR monitorexit ;
        return adm;
        Exception exception;
        exception;
        throw exception;
    }

    public final Object freeze()
    {
        return ky();
    }

    public final String getId()
    {
        return kz().getId();
    }

    public final ItemScope getResult()
    {
        return kz().getResult();
    }

    public final String getStartDate()
    {
        return kz().getStartDate();
    }

    public final ItemScope getTarget()
    {
        return kz().getTarget();
    }

    public final String getType()
    {
        return kz().getType();
    }

    public final boolean hasId()
    {
        return kz().hasId();
    }

    public final boolean hasResult()
    {
        return kz().hasId();
    }

    public final boolean hasStartDate()
    {
        return kz().hasStartDate();
    }

    public final boolean hasTarget()
    {
        return kz().hasTarget();
    }

    public final boolean hasType()
    {
        return kz().hasType();
    }

    public final kq ky()
    {
        return kz();
    }
}
