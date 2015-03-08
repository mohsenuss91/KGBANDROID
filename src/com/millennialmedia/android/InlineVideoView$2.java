// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            InlineVideoView, MMLayout

class this._cls0
    implements android.view.er
{

    final InlineVideoView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            MMLayout mmlayout = (MMLayout)mmLayoutRef.get();
            if (mmlayout == null)
            {
                LayoutRef("MMLayout weak reference broken");
                return false;
            }
            if (!TextUtils.isEmpty(inlineParams.touchCallBack))
            {
                String s = (new StringBuilder("javascript:")).append(inlineParams.touchCallBack).append("(%f,%f)").toString();
                Object aobj[] = new Object[2];
                aobj[0] = Float.valueOf(motionevent.getX());
                aobj[1] = Float.valueOf(motionevent.getY());
                mmlayout.loadUrl(String.format(s, aobj));
            }
            if (inlineParams.showControls && mediaController != null && !mediaController.isShowing())
            {
                mediaController.show();
                return true;
            }
        }
        return true;
    }

    diaController()
    {
        this$0 = InlineVideoView.this;
        super();
    }
}
