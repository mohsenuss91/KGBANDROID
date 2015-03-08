// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package uk.co.senab.a.b:
//            w

final class o extends android.widget.FrameLayout.LayoutParams
{

    private final String a;

    o(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, w.PullToRefreshView);
        a = typedarray.getString(0);
        typedarray.recycle();
    }

    final String a()
    {
        return a;
    }
}
