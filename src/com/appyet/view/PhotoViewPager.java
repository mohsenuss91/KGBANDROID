// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class PhotoViewPager extends ViewPager
{

    public PhotoViewPager(Context context)
    {
        super(context);
    }

    public PhotoViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        try
        {
            flag = super.onInterceptTouchEvent(motionevent);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception.printStackTrace();
            return false;
        }
        catch (ArrayIndexOutOfBoundsException arrayindexoutofboundsexception)
        {
            arrayindexoutofboundsexception.printStackTrace();
            return false;
        }
        return flag;
    }
}
