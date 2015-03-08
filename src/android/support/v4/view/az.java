// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.a.u;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            a, ViewPager, aa

final class az extends android.support.v4.view.a
{

    final ViewPager b;

    az(ViewPager viewpager)
    {
        b = viewpager;
        super();
    }

    private boolean b()
    {
        return ViewPager.access$200(b) != null && ViewPager.access$200(b).getCount() > 1;
    }

    public final void a(View view, a a1)
    {
        super.a(view, a1);
        a1.a(android/support/v4/view/ViewPager.getName());
        a1.a(b());
        if (b.canScrollHorizontally(1))
        {
            a1.a(4096);
        }
        if (b.canScrollHorizontally(-1))
        {
            a1.a(8192);
        }
    }

    public final boolean a(View view, int i, Bundle bundle)
    {
        if (super.a(view, i, bundle))
        {
            return true;
        }
        switch (i)
        {
        default:
            return false;

        case 4096: 
            if (b.canScrollHorizontally(1))
            {
                b.setCurrentItem(1 + ViewPager.access$300(b));
                return true;
            } else
            {
                return false;
            }

        case 8192: 
            break;
        }
        if (b.canScrollHorizontally(-1))
        {
            b.setCurrentItem(-1 + ViewPager.access$300(b));
            return true;
        } else
        {
            return false;
        }
    }

    public final void d(View view, AccessibilityEvent accessibilityevent)
    {
        super.d(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v4/view/ViewPager.getName());
        u u1 = u.a();
        u1.a(b());
        if (accessibilityevent.getEventType() == 4096 && ViewPager.access$200(b) != null)
        {
            u1.a(ViewPager.access$200(b).getCount());
            u1.b(ViewPager.access$300(b));
            u1.c(ViewPager.access$300(b));
        }
    }
}
