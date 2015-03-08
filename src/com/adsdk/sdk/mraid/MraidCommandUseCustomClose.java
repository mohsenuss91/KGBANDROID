// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import java.util.Map;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidCommand, MraidView, MraidDisplayController

class MraidCommandUseCustomClose extends MraidCommand
{

    MraidCommandUseCustomClose(Map map, MraidView mraidview)
    {
        super(map, mraidview);
    }

    void execute()
    {
        boolean flag = getBooleanFromParamsForKey("shouldUseCustomClose");
        mView.getDisplayController().useCustomClose(flag);
    }
}
