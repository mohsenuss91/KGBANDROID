// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.media.MediaPlayer;
import android.view.View;
import com.appyet.d.d;

// Referenced classes of package com.appyet.manager:
//            as

final class au
    implements android.view.View.OnClickListener
{

    final as a;

    au(as as1)
    {
        a = as1;
        super();
    }

    public final void onClick(View view)
    {
        if (as.f(a) == null || !as.f(a).isPlaying())
        {
            break MISSING_BLOCK_LABEL_38;
        }
        a.h();
_L1:
        as.p(a);
        return;
        try
        {
            if (as.f(a).getCurrentPosition() == as.f(a).getDuration())
            {
                as.f(a).seekTo(0);
            }
            a.j();
        }
        catch (Exception exception)
        {
            d.a(exception);
            return;
        }
          goto _L1
    }
}
