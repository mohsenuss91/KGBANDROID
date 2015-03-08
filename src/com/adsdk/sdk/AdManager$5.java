// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;

import com.adsdk.sdk.customevents.CustomEvent;
import com.adsdk.sdk.customevents.CustomEventFullscreen;

// Referenced classes of package com.adsdk.sdk:
//            AdManager, Log

class .CustomEvent
    implements Runnable
{

    final AdManager this$0;
    private final CustomEvent val$event;

    public void run()
    {
        try
        {
            AdManager.access$17(AdManager.this).loadFullscreen(AdManager.access$19(), AdManager.access$20(AdManager.this), val$event.getOptionalParameter(), val$event.getPixelUrl());
            return;
        }
        catch (Exception exception)
        {
            AdManager.access$21(AdManager.this, null);
        }
        Log.d("Failed to create Custom Event Fullscreen.");
    }

    .CustomEvent()
    {
        this$0 = final_admanager;
        val$event = CustomEvent.this;
        super();
    }
}
