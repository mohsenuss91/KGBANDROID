// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.internal.gi;

class zS extends zS
{

    final String zR;
    final String zS;
    final N zT;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((gi));
    }

    protected void a(gi gi1)
    {
        try
        {
            gi1.a(zR, zS, this);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            N(2001);
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
        zR = s;
        zS = s1;
        super(null);
    }
}
