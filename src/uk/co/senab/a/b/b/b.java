// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.b.b;

import android.view.View;
import android.widget.ScrollView;

// Referenced classes of package uk.co.senab.a.b.b:
//            c

public class b
    implements c
{

    public static final Class a[] = {
        android/widget/ScrollView
    };

    public b()
    {
    }

    public final boolean a(View view, float f)
    {
        return view.getScrollY() <= 0;
    }

}
