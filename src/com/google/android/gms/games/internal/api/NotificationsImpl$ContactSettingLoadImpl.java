// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class _cls1 extends com.google.android.gms.games.tingLoadImpl
{

    public com.google.android.gms.games.tingLoadImpl M(Status status)
    {
        class _cls1
            implements com.google.android.gms.games.Notifications.ContactSettingLoadResult
        {

            final NotificationsImpl.ContactSettingLoadImpl PY;
            final Status yG;

            public Status getStatus()
            {
                return yG;
            }

            _cls1(Status status)
            {
                PY = NotificationsImpl.ContactSettingLoadImpl.this;
                yG = status;
                super();
            }
        }

        return new _cls1(status);
    }

    public Result c(Status status)
    {
        return M(status);
    }

    private _cls1()
    {
    }
}
