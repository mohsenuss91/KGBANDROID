// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.media.MediaPlayer;
import com.appyet.d.d;

// Referenced classes of package com.appyet.manager:
//            as

final class be
    implements android.media.MediaPlayer.OnErrorListener
{

    final as a;

    be(as as1)
    {
        a = as1;
        super();
    }

    public final boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        try
        {
            as.o(a);
            a.d();
            as _tmp = a;
            as.e();
            as.q(a);
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
        return false;
    }
}
