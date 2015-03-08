// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.actionbarsherlock.app.ActionBar;
import com.appyet.d.d;

public final class b extends FrameLayout
{

    private ActionBar a;
    private boolean b;

    protected final void onMeasure(int i, int j)
    {
        boolean flag = b;
        int k;
        k = 0;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        ActionBar actionbar = a;
        k = 0;
        if (actionbar == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        boolean flag1 = a.isShowing();
        k = 0;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        k = a.getHeight();
        setPadding(0, k, 0, 0);
_L2:
        super.onMeasure(i, j);
        return;
        Exception exception;
        exception;
        d.a(exception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void setActionBar(ActionBar actionbar)
    {
        a = actionbar;
        requestLayout();
    }

    public final void setEnablePadding(boolean flag)
    {
        b = flag;
        requestLayout();
    }

    public (Context context)
    {
        this(context, null);
    }

    public <init>(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public <init>(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = true;
    }
}
