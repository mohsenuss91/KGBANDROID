// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;

class right
    implements Runnable
{

    int bottom;
    private final Button closeButton;
    int left;
    int right;
    int top;

    public void run()
    {
        Rect rect = new Rect();
        closeButton.getHitRect(rect);
        rect.top = rect.top + top;
        rect.right = rect.right + right;
        rect.bottom = rect.bottom + bottom;
        rect.left = rect.left + left;
        TouchDelegate touchdelegate = new TouchDelegate(rect, closeButton);
        if (android/view/View.isInstance(closeButton.getParent()))
        {
            ((View)closeButton.getParent()).setTouchDelegate(touchdelegate);
        }
    }

    (Button button, int i, int j, int k, int l)
    {
        closeButton = button;
        top = i;
        left = j;
        bottom = k;
        right = l;
    }
}
