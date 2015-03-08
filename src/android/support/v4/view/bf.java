// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

// Referenced classes of package android.support.v4.view:
//            ay

final class bf
    implements Comparator
{

    bf()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        View view = (View)obj;
        View view1 = (View)obj1;
        ay ay1 = (ay)view.getLayoutParams();
        ay ay2 = (ay)view1.getLayoutParams();
        if (ay1.a != ay2.a)
        {
            return !ay1.a ? -1 : 1;
        } else
        {
            return ay1.e - ay2.e;
        }
    }
}
