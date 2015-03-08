// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gb;

final class <init> extends <init>
{

    final int yH;

    protected final volatile void a(com.google.android.gms.common.api.nit> nit>)
    {
        a((gb)nit>);
    }

    protected final void a(gb gb1)
    {
        gb1.a(this, yH);
    }

    public final Result c(Status status)
    {
        return g(status);
    }

    public final ateDeletedResult g(Status status)
    {
        class _cls1
            implements AppStateManager.StateDeletedResult
        {

            final Status yG;
            final AppStateManager._cls5 yJ;

            public int getStateKey()
            {
                return yJ.yH;
            }

            public Status getStatus()
            {
                return yG;
            }

            _cls1(Status status)
            {
                yJ = AppStateManager._cls5.this;
                yG = status;
                super();
            }
        }

        return new _cls1(status);
    }

    ateDeletedResult(int i)
    {
        yH = i;
        super(null);
    }
}
