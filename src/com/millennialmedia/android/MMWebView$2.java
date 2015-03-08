// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.view.MotionEvent;

// Referenced classes of package com.millennialmedia.android:
//            MMWebView

class  extends android.view.tor.SimpleOnGestureListener
{

    final MMWebView this$0;
    final Context val$context;

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        overlayTap(val$context, creatorAdImplId);
        return false;
    }

    tureListener()
    {
        this$0 = final_mmwebview;
        val$context = Context.this;
        super();
    }
}
