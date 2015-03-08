// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

public class PopupWindowCompat extends PopupWindow
{

    private static final android.view.ViewTreeObserver.OnScrollChangedListener NOP = new _cls1();
    private static final Field superListenerField;
    private android.view.ViewTreeObserver.OnScrollChangedListener mSuperScrollListener;
    private ViewTreeObserver mViewTreeObserver;

    public PopupWindowCompat()
    {
        init();
    }

    public PopupWindowCompat(int i, int j)
    {
        super(i, j);
        init();
    }

    public PopupWindowCompat(Context context)
    {
        super(context);
        init();
    }

    public PopupWindowCompat(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public PopupWindowCompat(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    public PopupWindowCompat(Context context, AttributeSet attributeset, int i, int j)
    {
        super(context, attributeset, i, j);
        init();
    }

    public PopupWindowCompat(View view)
    {
        super(view);
        init();
    }

    public PopupWindowCompat(View view, int i, int j)
    {
        super(view, i, j);
        init();
    }

    public PopupWindowCompat(View view, int i, int j, boolean flag)
    {
        super(view, i, j, flag);
        init();
    }

    private void init()
    {
        if (superListenerField == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        mSuperScrollListener = (android.view.ViewTreeObserver.OnScrollChangedListener)superListenerField.get(this);
        superListenerField.set(this, NOP);
        return;
        Exception exception;
        exception;
        mSuperScrollListener = null;
        return;
    }

    private void registerListener(View view)
    {
        if (mSuperScrollListener != null)
        {
            ViewTreeObserver viewtreeobserver;
            if (view.getWindowToken() != null)
            {
                viewtreeobserver = view.getViewTreeObserver();
            } else
            {
                viewtreeobserver = null;
            }
            if (viewtreeobserver != mViewTreeObserver)
            {
                if (mViewTreeObserver != null && mViewTreeObserver.isAlive())
                {
                    mViewTreeObserver.removeOnScrollChangedListener(mSuperScrollListener);
                }
                mViewTreeObserver = viewtreeobserver;
                if (viewtreeobserver != null)
                {
                    viewtreeobserver.addOnScrollChangedListener(mSuperScrollListener);
                }
            }
        }
    }

    private void unregisterListener()
    {
        if (mSuperScrollListener != null && mViewTreeObserver != null)
        {
            if (mViewTreeObserver.isAlive())
            {
                mViewTreeObserver.removeOnScrollChangedListener(mSuperScrollListener);
            }
            mViewTreeObserver = null;
        }
    }

    public void dismiss()
    {
        super.dismiss();
        unregisterListener();
    }

    public void showAsDropDown(View view, int i, int j)
    {
        super.showAsDropDown(view, i, j);
        registerListener(view);
    }

    public void showAtLocation(View view, int i, int j, int k)
    {
        super.showAtLocation(view, i, j, k);
        unregisterListener();
    }

    public void update(View view, int i, int j)
    {
        super.update(view, i, j);
        registerListener(view);
    }

    public void update(View view, int i, int j, int k, int l)
    {
        super.update(view, i, j, k, l);
        registerListener(view);
    }

    static 
    {
        Field field = null;
        try
        {
            field = android/widget/PopupWindow.getDeclaredField("mOnScrollChangedListener");
            field.setAccessible(true);
        }
        catch (NoSuchFieldException nosuchfieldexception) { }
        superListenerField = field;
    }

    private class _cls1
        implements android.view.ViewTreeObserver.OnScrollChangedListener
    {

        public final void onScrollChanged()
        {
        }

        _cls1()
        {
        }
    }

}
