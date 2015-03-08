// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.graphics.Rect;
import android.view.View;

// Referenced classes of package net.simonvt.menudrawer:
//            MenuDrawer

final class m
    implements android.view.ViewTreeObserver.OnScrollChangedListener
{

    final MenuDrawer a;

    m(MenuDrawer menudrawer)
    {
        a = menudrawer;
        super();
    }

    public final void onScrollChanged()
    {
        if (a.z != null && a.a(a.z))
        {
            a.z.getDrawingRect(MenuDrawer.b(a));
            a.offsetDescendantRectToMyCoords(a.z, MenuDrawer.b(a));
            if (MenuDrawer.b(a).left != a.B.left || MenuDrawer.b(a).top != a.B.top || MenuDrawer.b(a).right != a.B.right || MenuDrawer.b(a).bottom != a.B.bottom)
            {
                a.invalidate();
            }
        }
    }
}
