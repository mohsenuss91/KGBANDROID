// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import java.util.Locale;

public class CapitalizingButton extends Button
{

    private static final boolean IS_GINGERBREAD;
    private static final int R_styleable_Button[] = {
        0x1010034
    };
    private static final int R_styleable_Button_textAppearance;
    private static final int R_styleable_TextAppearance[] = {
        0x101038c
    };
    private static final int R_styleable_TextAppearance_textAllCaps;
    private static final boolean SANS_ICE_CREAM;
    private boolean mAllCaps;

    public CapitalizingButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, R_styleable_Button);
        int i = typedarray.getResourceId(0, -1);
        typedarray.recycle();
        if (i != -1)
        {
            TypedArray typedarray1 = context.obtainStyledAttributes(i, R_styleable_TextAppearance);
            if (typedarray1 != null)
            {
                mAllCaps = typedarray1.getBoolean(0, true);
                typedarray1.recycle();
            }
        }
    }

    public void setTextCompat(CharSequence charsequence)
    {
        if (SANS_ICE_CREAM && mAllCaps && charsequence != null)
        {
            if (IS_GINGERBREAD)
            {
                try
                {
                    setText(charsequence.toString().toUpperCase(Locale.ROOT));
                    return;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    setText(charsequence.toString().toUpperCase());
                }
                return;
            } else
            {
                setText(charsequence.toString().toUpperCase());
                return;
            }
        } else
        {
            setText(charsequence);
            return;
        }
    }

    static 
    {
        boolean flag;
        boolean flag1;
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SANS_ICE_CREAM = flag;
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        IS_GINGERBREAD = flag1;
    }
}
