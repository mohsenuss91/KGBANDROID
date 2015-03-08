// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.a.a.b.a.a;
import com.a.a.b.a.b;
import com.a.a.b.a.l;

// Referenced classes of package com.appyet.c:
//            at, ax

final class av extends l
{

    final at a;

    av(at at1)
    {
        a = at1;
        super();
    }

    public final void a()
    {
        com.appyet.c.at.b(a).setVisibility(0);
    }

    public final void a(a a1)
    {
        int i;
        Object obj;
        i = com.appyet.c.ax.a[a1.a().ordinal()];
        obj = null;
        i;
        JVM INSTR tableswitch 1 5: default 48
    //                   1 76
    //                   2 82
    //                   3 88
    //                   4 94
    //                   5 100;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        Toast.makeText(at.c(a), ((CharSequence) (obj)), 0).show();
        com.appyet.c.at.b(a).setVisibility(8);
        return;
_L2:
        obj = "Input/Output error";
        continue; /* Loop/switch isn't completed */
_L3:
        obj = "Image can't be decoded";
        continue; /* Loop/switch isn't completed */
_L4:
        obj = "Downloads are denied";
        continue; /* Loop/switch isn't completed */
_L5:
        obj = "Out Of Memory error";
        continue; /* Loop/switch isn't completed */
_L6:
        obj = "Unknown error";
        if (true) goto _L1; else goto _L7
_L7:
    }

    public final void a(String s, View view, Bitmap bitmap)
    {
        com.appyet.c.at.b(a).setVisibility(8);
    }
}
