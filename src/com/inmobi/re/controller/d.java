// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.AudioTriggerCallback;

// Referenced classes of package com.inmobi.re.controller:
//            JSUtilityController

class d
    implements AudioTriggerCallback
{

    final JSUtilityController a;

    d(JSUtilityController jsutilitycontroller)
    {
        a = jsutilitycontroller;
        super();
    }

    public void audioLevel(double d1)
    {
        a.imWebView.raiseMicEvent(d1);
    }
}
