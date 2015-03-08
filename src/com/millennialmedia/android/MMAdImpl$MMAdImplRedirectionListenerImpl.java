// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.net.Uri;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            MMAdImpl, HandShake

class creatorAdImplInternalId extends creatorAdImplInternalId
{

    final MMAdImpl this$0;

    public JSONObject getAdProperties()
    {
        return MMAdImpl.this.getAdProperties();
    }

    public boolean isActivityStartable(Uri uri)
    {
        android.content.Context context = getContext();
        return context == null || !(context instanceof Activity) || !((Activity)context).isFinishing();
    }

    public void startingActivity(Uri uri)
    {
        super.tartingActivity(uri);
        if (uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https"))
        {
            tartingActivity(MMAdImpl.this);
        }
    }

    public void updateLastVideoViewedTime()
    {
        if (adType != null)
        {
            HandShake.sharedHandShake(getContext()).updateLastVideoViewedTime(getContext(), adType);
        }
    }

    public ()
    {
        this$0 = MMAdImpl.this;
        super();
        creatorAdImplInternalId = internalId;
    }
}
