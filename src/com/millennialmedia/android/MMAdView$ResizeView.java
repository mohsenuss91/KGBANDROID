// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.millennialmedia.android:
//            MMAdView

class this._cls0 extends View
{

    final MMAdView this$0;

    void attachToContext(View view)
    {
        this;
        JVM INSTR monitorenter ;
        MMAdView.access$100(MMAdView.this, view);
        if (getParent() != null && (getParent() instanceof ViewGroup))
        {
            ((ViewGroup)getParent()).addView(view);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        getParent("onRestoreInstanceState");
        MMAdView.access$000(MMAdView.this, MMAdView.this);
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState()
    {
        com.millennialmedia.android.this._mth0("onSaveInstanceState");
        attachToContext(MMAdView.this);
        return super.onSaveInstanceState();
    }

    public (Context context)
    {
        this$0 = MMAdView.this;
        super(context);
    }
}
