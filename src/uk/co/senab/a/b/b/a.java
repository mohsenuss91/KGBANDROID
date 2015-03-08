// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.b.b;

import android.view.View;
import android.widget.AbsListView;

// Referenced classes of package uk.co.senab.a.b.b:
//            c

public class a
    implements c
{

    public static final Class a[] = {
        android/widget/AbsListView
    };

    public a()
    {
    }

    public final boolean a(View view, float f)
    {
        boolean flag = true;
        AbsListView abslistview = (AbsListView)view;
        boolean flag1;
        boolean flag2;
        int i;
        if (abslistview.getCount() == 0)
        {
            flag1 = flag;
        } else
        if (abslistview.getFirstVisiblePosition() == 0)
        {
            View view1 = abslistview.getChildAt(0);
            if (view1 != null && view1.getTop() >= 0)
            {
                flag1 = flag;
            } else
            {
                flag1 = false;
            }
        } else
        {
            flag1 = false;
        }
        if (!flag1 || !abslistview.isFastScrollEnabled()) goto _L2; else goto _L1
_L1:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag2 = abslistview.isFastScrollAlwaysVisible();
        } else
        {
            flag2 = false;
        }
        if (!flag2) goto _L2; else goto _L3
_L3:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            i = abslistview.getVerticalScrollbarPosition();
        } else
        {
            i = 2;
        }
        i;
        JVM INSTR tableswitch 1 2: default 92
    //                   1 169
    //                   2 150;
           goto _L2 _L4 _L5
_L2:
        flag = flag1;
_L7:
        return flag;
_L5:
        if (f >= (float)(abslistview.getRight() - abslistview.getVerticalScrollbarWidth()))
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (f <= (float)abslistview.getVerticalScrollbarWidth())
        {
            return false;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

}
