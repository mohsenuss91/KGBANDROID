// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobfox.adapter;

import com.google.ads.mediation.j;

public final class MobFoxExtras
    implements j
{

    private boolean animation;
    private boolean location;

    public MobFoxExtras()
    {
        animation = false;
        location = false;
    }

    public final boolean getAnimation()
    {
        return animation;
    }

    public final boolean getLocation()
    {
        return location;
    }

    public final void setAnimation(boolean flag)
    {
        animation = flag;
    }

    public final void setLocation(boolean flag)
    {
        location = flag;
    }
}
