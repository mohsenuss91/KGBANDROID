// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import java.util.Map;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidView

abstract class MraidCommand
{

    protected static final String URI_KEY = "uri";
    protected Map mParams;
    protected MraidView mView;

    MraidCommand(Map map, MraidView mraidview)
    {
        mParams = map;
        mView = mraidview;
    }

    abstract void execute();

    protected boolean getBooleanFromParamsForKey(String s)
    {
        return "true".equals(mParams.get(s));
    }

    protected float getFloatFromParamsForKey(String s)
    {
        if ((String)mParams.get(s) == null)
        {
            return 0.0F;
        }
        float f;
        try
        {
            f = Float.parseFloat(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            return 0.0F;
        }
        return f;
    }

    protected int getIntFromParamsForKey(String s)
    {
        String s1 = (String)mParams.get(s);
        if (s1 == null)
        {
            return -1;
        }
        int i;
        try
        {
            i = Integer.parseInt(s1, 10);
        }
        catch (NumberFormatException numberformatexception)
        {
            return -1;
        }
        return i;
    }

    protected String getStringFromParamsForKey(String s)
    {
        return (String)mParams.get(s);
    }

    protected boolean isCommandDependentOnUserClick(MraidView.PlacementType placementtype)
    {
        return false;
    }
}
