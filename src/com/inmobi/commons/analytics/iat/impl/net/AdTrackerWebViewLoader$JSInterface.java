// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerRequestResponseBuilder

public class 
{

    public String getParams()
    {
        String s = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
        String s1 = AdTrackerRequestResponseBuilder.getWebViewRequestParam();
        if (s != null)
        {
            s1 = (new StringBuilder()).append(s1).append("&referrer=").append(s).toString();
        }
        Log.debug("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Request param for webview")).append(s1).toString());
        return s1;
    }

    protected ()
    {
    }
}
