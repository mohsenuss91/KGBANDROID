// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.media.MediaPlayer;
import com.appyet.d.d;
import com.appyet.data.FeedItem;

// Referenced classes of package com.appyet.manager:
//            as, bi

final class bd
    implements android.media.MediaPlayer.OnCompletionListener
{

    final as a;

    bd(as as1)
    {
        a = as1;
        super();
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        a.h();
        as.p(a);
        try
        {
            if (as.f(a) != null && as.h(a) != null)
            {
                int i = -1 + as.f(a).getDuration();
                (new bi(a, i)).a(new Void[0]);
                as.h(a).setEnclosureCurrentPosition(Integer.valueOf(i));
            }
            return;
        }
        catch (Exception exception1)
        {
            try
            {
                d.a(exception1);
                return;
            }
            catch (Exception exception)
            {
                d.a(exception);
            }
        }
        return;
    }
}
