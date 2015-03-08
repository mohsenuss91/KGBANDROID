// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import java.util.Map;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidCommand, MraidView, MraidBrowserController

class MraidCommandOpen extends MraidCommand
{

    MraidCommandOpen(Map map, MraidView mraidview)
    {
        super(map, mraidview);
    }

    void execute()
    {
        String s = getStringFromParamsForKey("url");
        if (s == null)
        {
            mView.fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.OPEN, "Url can not be null.");
            return;
        } else
        {
            mView.getBrowserController().open(s);
            return;
        }
    }

    protected boolean isCommandDependentOnUserClick(MraidView.PlacementType placementtype)
    {
        return true;
    }
}
