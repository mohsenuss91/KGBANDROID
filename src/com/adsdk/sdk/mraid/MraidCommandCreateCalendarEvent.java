// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import java.util.Map;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidCommand, MraidView, MraidDisplayController

class MraidCommandCreateCalendarEvent extends MraidCommand
{

    MraidCommandCreateCalendarEvent(Map map, MraidView mraidview)
    {
        super(map, mraidview);
    }

    void execute()
    {
        mView.getDisplayController().createCalendarEvent(mParams);
    }

    protected boolean isCommandDependentOnUserClick(MraidView.PlacementType placementtype)
    {
        return true;
    }
}
