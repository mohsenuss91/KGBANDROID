// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.Locale;

public class CapitalizingTextView extends TextView
{

    private static final boolean IS_GINGERBREAD;
    private static final int R_styleable_TextView[] = {
        0x101038c
    };
    private static final int R_styleable_TextView_textAllCaps;
    private static final boolean SANS_ICE_CREAM;
    private boolean mAllCaps;

    public CapitalizingTextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CapitalizingTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, R_styleable_TextView, i, 0);
        mAllCaps = typedarray.getBoolean(0, true);
        typedarray.recycle();
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
