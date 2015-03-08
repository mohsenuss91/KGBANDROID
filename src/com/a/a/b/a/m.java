// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.a;

import android.widget.ImageView;

// Referenced classes of package com.a.a.b.a:
//            n

public final class m extends Enum
{

    public static final m a;
    public static final m b;
    private static final m c[];

    private m(String s, int i)
    {
        super(s, i);
    }

    public static m a(ImageView imageview)
    {
        switch (n.a[imageview.getScaleType().ordinal()])
        {
        default:
            return b;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return a;
        }
    }

    public static m valueOf(String s)
    {
        return (m)Enum.valueOf(com/a/a/b/a/m, s);
    }

    public static m[] values()
    {
        return (m[])c.clone();
    }

    static 
    {
        a = new m("FIT_INSIDE", 0);
        b = new m("CROP", 1);
        m am[] = new m[2];
        am[0] = a;
        am[1] = b;
        c = am;
    }
}
