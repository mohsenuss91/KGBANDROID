// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

class setBaseContext extends MutableContextWrapper
{

    private Context lx;
    private Activity sD;

    public Context ca()
    {
        return sD;
    }

    public void setBaseContext(Context context)
    {
        lx = context.getApplicationContext();
        Activity activity;
        if (context instanceof Activity)
        {
            activity = (Activity)context;
        } else
        {
            activity = null;
        }
        sD = activity;
        super.setBaseContext(lx);
    }

    public void startActivity(Intent intent)
    {
        if (sD != null)
        {
            sD.startActivity(intent);
            return;
        } else
        {
            intent.setFlags(0x10000000);
            lx.startActivity(intent);
            return;
        }
    }

    public (Context context)
    {
        super(context);
        setBaseContext(context);
    }
}
