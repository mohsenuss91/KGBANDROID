// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.media.MediaPlayer;
import android.view.View;
import com.appyet.d.d;

// Referenced classes of package com.appyet.manager:
//            as

final class av
    implements android.view.View.OnClickListener
{

    final as a;

    av(as as1)
    {
        a = as1;
        super();
    }

    public final void onClick(View view)
    {
        try
        {
            if (as.f(a) != null && as.f(a).isPlaying())
            {
                a.a(-30);
            }
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
    }
}
