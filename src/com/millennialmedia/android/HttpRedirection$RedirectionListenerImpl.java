// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.net.Uri;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            OverlaySettings

class I
    implements I
{

    long creatorAdImplInternalId;
    Uri destinationUri;
    String orientation;
    String url;
    WeakReference weakContext;

    public boolean canOpenOverlay()
    {
        return false;
    }

    public JSONObject getAdProperties()
    {
        return null;
    }

    public OverlaySettings getOverlaySettings()
    {
        return null;
    }

    public boolean isActivityStartable(Uri uri)
    {
        return true;
    }

    public boolean isExpandingToUrl()
    {
        return false;
    }

    public boolean isHandlingMMVideo(Uri uri)
    {
        return false;
    }

    public void startingActivity(Uri uri)
    {
        I("Starting activity for %s", new Object[] {
            uri
        });
    }

    public void startingVideo()
    {
    }

    public void updateLastVideoViewedTime()
    {
    }

    I()
    {
    }
}
