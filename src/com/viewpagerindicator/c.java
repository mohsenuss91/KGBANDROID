// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.viewpagerindicator;

import android.support.v4.view.ViewPager;
import android.support.v4.view.bb;

public interface c
    extends bb
{

    public abstract void setCurrentItem(int i);

    public abstract void setOnPageChangeListener(bb bb1);

    public abstract void setViewPager(ViewPager viewpager);
}
