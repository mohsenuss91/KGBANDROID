// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

// Referenced classes of package com.google.android.gms.internal:
//            gu

final class FK extends android.graphics.drawable.ble.ConstantState
{

    int FJ;
    int FK;

    public final int getChangingConfigurations()
    {
        return FJ;
    }

    public final Drawable newDrawable()
    {
        return new gu(this);
    }

    nstantState(nstantState nstantstate)
    {
        if (nstantstate != null)
        {
            FJ = nstantstate.FJ;
            FK = nstantstate.FK;
        }
    }
}
