// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.a;

import android.content.ComponentName;
import android.content.Intent;

// Referenced classes of package android.support.v4.a:
//            f, e, d, c

public final class b
{

    private static final c a;

    public static Intent a(ComponentName componentname)
    {
        return a.a(componentname);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 15)
        {
            a = new f();
        } else
        if (i >= 11)
        {
            a = new e();
        } else
        {
            a = new d();
        }
    }
}
