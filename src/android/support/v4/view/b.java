// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.support.v4.view.a.a;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.support.v4.view:
//            g, i, c, a

class b extends g
{

    b()
    {
    }

    public final Object a()
    {
        return new android.view.View.AccessibilityDelegate();
    }

    public Object a(android.support.v4.view.a a1)
    {
        return new i(new c(this, a1));
    }

    public final void a(Object obj, View view, int j)
    {
        ((android.view.View.AccessibilityDelegate)obj).sendAccessibilityEvent(view, j);
    }

    public final void a(Object obj, View view, a a1)
    {
        Object obj1 = a1.a();
        ((android.view.View.AccessibilityDelegate)obj).onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo)obj1);
    }

    public final boolean a(Object obj, View view, AccessibilityEvent accessibilityevent)
    {
        return ((android.view.View.AccessibilityDelegate)obj).dispatchPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public final boolean a(Object obj, ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return ((android.view.View.AccessibilityDelegate)obj).onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
    }

    public final void b(Object obj, View view, AccessibilityEvent accessibilityevent)
    {
        ((android.view.View.AccessibilityDelegate)obj).onInitializeAccessibilityEvent(view, accessibilityevent);
    }

    public final void c(Object obj, View view, AccessibilityEvent accessibilityevent)
    {
        ((android.view.View.AccessibilityDelegate)obj).onPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public final void d(Object obj, View view, AccessibilityEvent accessibilityevent)
    {
        ((android.view.View.AccessibilityDelegate)obj).sendAccessibilityEventUnchecked(view, accessibilityevent);
    }
}
