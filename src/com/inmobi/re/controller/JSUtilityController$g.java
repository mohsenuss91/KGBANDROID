// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;
import java.util.TimerTask;

// Referenced classes of package com.inmobi.re.controller:
//            JSUtilityController

class a extends TimerTask
{

    final JSUtilityController a;

    public void run()
    {
        try
        {
            a.imWebView.raiseVibrateCompleteEvent();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "Vibrate callback execption", exception);
        }
    }

    (JSUtilityController jsutilitycontroller)
    {
        a = jsutilitycontroller;
        super();
    }
}
