// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.gi;

class zW extends zW
{

    final N zT;
    final String zW;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((gi));
    }

    protected void a(gi gi1)
    {
        if (TextUtils.isEmpty(zW))
        {
            c(2001, "IllegalArgument: sessionId cannot be null or empty");
            return;
        }
        try
        {
            gi1.a(zW, this);
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            N(2001);
        }
    }

    ( , String s)
    {
        zT = ;
        zW = s;
        super(null);
    }
}
