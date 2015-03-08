// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.ImageButton;
import com.appyet.activity.MediaPlayerActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.data.DatabaseHelper;
import com.appyet.data.FeedItem;
import com.appyet.service.MediaService;
import com.j256.ormlite.misc.TransactionManager;

// Referenced classes of package com.appyet.manager:
//            as, MediaProgressNotification, d, l

final class bb
    implements android.media.MediaPlayer.OnPreparedListener
{

    final as a;

    bb(as as1)
    {
        a = as1;
        super();
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        as.e(a);
        if (as.f(a) == null) goto _L2; else goto _L1
_L1:
        as.a(a, new MediaProgressNotification(as.g(a), as.f(a).getDuration()));
        if (as.h(a) == null) goto _L4; else goto _L3
_L3:
        if (as.h(a).getEnclosureDuration() != null && as.h(a).getEnclosureDuration().intValue() != 0 && (float)as.h(a).getEnclosureDuration().intValue() < (float)as.f(a).getDuration() + (float)as.f(a).getDuration() / 200F && (float)as.h(a).getEnclosureDuration().intValue() > (float)as.f(a).getDuration() - (float)as.f(a).getDuration() / 200F) goto _L6; else goto _L5
_L5:
        com.appyet.manager.d d1;
        Long long1;
        Integer integer;
        d1 = as.g(a).h;
        long1 = as.h(a).getFeedItemId();
        integer = Integer.valueOf(as.f(a).getDuration());
        TransactionManager.callInTransaction(d1.b.getConnectionSource(), new l(d1, integer, long1));
_L9:
        as.h(a).setEnclosureDuration(Integer.valueOf(as.f(a).getDuration()));
_L6:
        if (as.h(a).getEnclosureCurrentPosition() == null || (float)as.h(a).getEnclosureCurrentPosition().intValue() >= (float)as.f(a).getDuration() - (float)as.f(a).getDuration() / 200F) goto _L8; else goto _L7
_L7:
        as.f(a).seekTo(as.h(a).getEnclosureCurrentPosition().intValue());
        as.f(a).start();
_L10:
        if (as.j(a) != null)
        {
            ((ImageButton)as.j(a).findViewById(0x7f0a00cb)).setImageResource(0x7f0200ea);
        }
        a.i();
        as.k(a);
        a.l();
        as.l(a);
        as.m(a);
        as.a(a, new Intent(as.g(a), com/appyet/service/MediaService));
        as.g(a).startService(as.n(a));
        as.o(a);
_L2:
        return;
        Exception exception2;
        exception2;
        d.a(exception2);
          goto _L9
        Exception exception1;
        exception1;
        try
        {
            throw exception1;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
        return;
_L8:
        as.f(a).start();
          goto _L10
_L4:
        if (as.i(a) == null) goto _L10; else goto _L11
_L11:
        as.f(a).start();
          goto _L10
    }
}
