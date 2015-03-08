// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.millennialmedia.android:
//            MMWebView

class this._cls0
    implements android.view.Listener
{

    final MMWebView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return motionevent.getAction() == 2 && MMWebView.access$000(MMWebView.this);
    }

    ()
    {
        this$0 = MMWebView.this;
        super();
    }
}
