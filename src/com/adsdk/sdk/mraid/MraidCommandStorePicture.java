// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.util.Log;
import java.util.Map;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidCommand, MraidView, MraidDisplayController

class MraidCommandStorePicture extends MraidCommand
{

    public static final String MIME_TYPE_HEADER = "Content-Type";

    public MraidCommandStorePicture(Map map, MraidView mraidview)
    {
        super(map, mraidview);
    }

    void execute()
    {
        String s = getStringFromParamsForKey("uri");
        if (s != null && !s.equals(""))
        {
            mView.getDisplayController().showUserDownloadImageAlert(s);
            return;
        } else
        {
            mView.fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.STORE_PICTURE, "Image can't be stored with null or empty URL");
            Log.d("MoPub", "Invalid URI for Mraid Store Picture.");
            return;
        }
    }

    protected boolean isCommandDependentOnUserClick(MraidView.PlacementType placementtype)
    {
        return true;
    }
}
