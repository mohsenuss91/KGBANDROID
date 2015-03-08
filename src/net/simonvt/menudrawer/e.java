// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

// Referenced classes of package net.simonvt.menudrawer:
//            d

final class e extends android.graphics.drawable.Drawable.ConstantState
{

    int a;
    int b;
    int c;

    e(e e1)
    {
        if (e1 != null)
        {
            a = e1.a;
            b = e1.b;
        }
    }

    public final int getChangingConfigurations()
    {
        return c;
    }

    public final Drawable newDrawable()
    {
        return new d(this, (byte)0);
    }

    public final Drawable newDrawable(Resources resources)
    {
        return new d(this, (byte)0);
    }
}
