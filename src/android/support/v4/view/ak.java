// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

// Referenced classes of package android.support.v4.view:
//            aj, a

class ak extends aj
{

    ak()
    {
    }

    public final void a(View view, a a1)
    {
        view.setAccessibilityDelegate((android.view.View.AccessibilityDelegate)a1.a());
    }

    public final boolean a(View view, int i)
    {
        return view.canScrollHorizontally(i);
    }
}
