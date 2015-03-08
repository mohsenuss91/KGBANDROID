// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.view.View;
import android.webkit.WebView;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidBrowser

class this._cls0
    implements android.view.tener
{

    final MraidBrowser this$0;

    public void onClick(View view)
    {
        if (MraidBrowser.access$2(MraidBrowser.this).canGoBack())
        {
            MraidBrowser.access$2(MraidBrowser.this).goBack();
        }
    }

    ()
    {
        this$0 = MraidBrowser.this;
        super();
    }
}
