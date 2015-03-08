// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.MomentBuffer;

// Referenced classes of package com.google.android.gms.plus.internal:
//            e

final class abK extends com.google.android.gms.internal.
    implements com.google.android.gms.plus.nts.LoadMomentsResult
{

    private final String HP;
    final e abJ;
    private final String abK;
    private MomentBuffer abL;
    private final Status yw;

    protected final void a(com.google.android.gms.common.api..c c, DataHolder dataholder)
    {
        MomentBuffer momentbuffer;
        if (dataholder != null)
        {
            momentbuffer = new MomentBuffer(dataholder);
        } else
        {
            momentbuffer = null;
        }
        abL = momentbuffer;
        c.a(this);
    }

    protected final volatile void a(Object obj, DataHolder dataholder)
    {
        a((com.google.android.gms.common.api.)obj, dataholder);
    }

    public final MomentBuffer getMomentBuffer()
    {
        return abL;
    }

    public final String getNextPageToken()
    {
        return HP;
    }

    public final Status getStatus()
    {
        return yw;
    }

    public final String getUpdated()
    {
        return abK;
    }

    public final void release()
    {
        if (abL != null)
        {
            abL.close();
        }
    }

    public lder(e e, com.google.android.gms.common.api. , Status status, DataHolder dataholder, String s, String s1)
    {
        abJ = e;
        super(e, , dataholder);
        yw = status;
        HP = s;
        abK = s1;
    }
}
