// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class c extends ViewGroup
{

    private int a;

    public c(Context context)
    {
        super(context);
        a = 48;
        setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
    }

    public int getGravity()
    {
        return a;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        View view = getChildAt(0);
        if (view == null)
        {
            return;
        }
        if (a == 48)
        {
            view.layout(0, 0, getMeasuredWidth(), view.getMeasuredHeight());
            return;
        } else
        {
            view.layout(0, getMeasuredHeight() - view.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getSize(j);
        int l = android.view.View.MeasureSpec.getSize(i);
        int i1 = android.view.View.MeasureSpec.getMode(j);
        View view = getChildAt(0);
        if (view == null)
        {
            setMeasuredDimension(0, l);
            return;
        }
        if (view.isLayoutRequested())
        {
            measureChild(view, i, android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (i1 == 0)
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            if (layoutparams.height > 0)
            {
                k = layoutparams.height;
            } else
            {
                k = view.getMeasuredHeight();
            }
        }
        setMeasuredDimension(l, k);
    }

    public void setGravity(int i)
    {
        a = i;
    }
}
