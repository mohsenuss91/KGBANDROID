// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.internal.gi;

class zW extends zW
{

    final N zT;
    final String zU;
    final String zW;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((gi));
    }

    protected void a(gi gi1)
    {
        try
        {
            gi1.b(zU, zW, this);
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            N(2001);
        }
    }

    ( , String s, String s1)
    {
        zT = ;
        zU = s;
        zW = s1;
        super(null);
    }
}
