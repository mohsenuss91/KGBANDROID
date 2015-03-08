// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.c;

import android.widget.ImageView;
import java.lang.reflect.Field;

// Referenced classes of package com.a.a.c:
//            d

public final class a
{

    public static int a(Object obj, String s)
    {
        int i;
        Field field = android/widget/ImageView.getDeclaredField(s);
        field.setAccessible(true);
        i = ((Integer)field.get(obj)).intValue();
        if (i > 0 && i < 0x7fffffff)
        {
            return i;
        }
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        d.a(exception);
        return 0;
    }
}
