// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package android.support.v4.widget:
//            DrawerLayout

public final class h extends android.view.ViewGroup.MarginLayoutParams
{

    public int a;
    float b;
    boolean c;
    boolean d;

    public h()
    {
        super(-1, -1);
        a = 0;
    }

    public h(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 0;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, DrawerLayout.e());
        a = typedarray.getInt(0, 0);
        typedarray.recycle();
    }

    public h(h h1)
    {
        super(h1);
        a = 0;
        a = h1.a;
    }

    public h(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(layoutparams);
        a = 0;
    }

    public h(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        super(marginlayoutparams);
        a = 0;
    }
}
