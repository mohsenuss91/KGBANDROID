// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import java.util.Map;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidCommand, MraidView, MraidDisplayController

class MraidCommandExpand extends MraidCommand
{

    private static int $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidView$PlacementType[];

    static int[] $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidView$PlacementType()
    {
        int ai[] = $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidView$PlacementType;
        if (ai != null)
        {
            return ai;
        }
        int ai1[] = new int[MraidView.PlacementType.values().length];
        try
        {
            ai1[MraidView.PlacementType.INLINE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            ai1[MraidView.PlacementType.INTERSTITIAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidView$PlacementType = ai1;
        return ai1;
    }

    MraidCommandExpand(Map map, MraidView mraidview)
    {
        super(map, mraidview);
    }

    void execute()
    {
        int i = getIntFromParamsForKey("w");
        int j = getIntFromParamsForKey("h");
        String s = getStringFromParamsForKey("url");
        boolean flag = getBooleanFromParamsForKey("shouldUseCustomClose");
        boolean flag1 = getBooleanFromParamsForKey("lockOrientation");
        if (i <= 0)
        {
            i = mView.getDisplayController().mScreenWidth;
        }
        if (j <= 0)
        {
            j = mView.getDisplayController().mScreenHeight;
        }
        mView.getDisplayController().expand(s, i, j, flag, flag1);
    }

    protected boolean isCommandDependentOnUserClick(MraidView.PlacementType placementtype)
    {
        switch ($SWITCH_TABLE$com$adsdk$sdk$mraid$MraidView$PlacementType()[placementtype.ordinal()])
        {
        default:
            return super.isCommandDependentOnUserClick(placementtype);

        case 1: // '\001'
            return true;

        case 2: // '\002'
            return false;
        }
    }
}
