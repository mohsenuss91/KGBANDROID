// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.os.Handler;

// Referenced classes of package com.adsdk.sdk.video:
//            NavIcon

class val.url
    implements Runnable
{

    final NavIcon this$0;
    private final String val$url;

    public void run()
    {
        final Drawable image = NavIcon.access$0(NavIcon.this, val$url);
        class _cls1
            implements Runnable
        {

            final NavIcon._cls1 this$1;
            private final Drawable val$image;

            public void run()
            {
                setImageDrawable(image);
                setVisibility(0);
                requestLayout();
            }

            _cls1()
            {
                this$1 = NavIcon._cls1.this;
                image = drawable;
                super();
            }
        }

        if (image != null)
        {
            NavIcon.access$1(NavIcon.this).post(new _cls1());
        }
    }


    _cls1()
    {
        this$0 = final_navicon;
        val$url = String.this;
        super();
    }
}
