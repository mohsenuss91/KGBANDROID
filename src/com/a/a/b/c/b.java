// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.c;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

// Referenced classes of package com.a.a.b.c:
//            a

public final class b
    implements a
{

    private final int a = 300;

    public b()
    {
    }

    public static void a(ImageView imageview, int i)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(i);
        alphaanimation.setInterpolator(new DecelerateInterpolator());
        imageview.startAnimation(alphaanimation);
    }

    public final Bitmap a(Bitmap bitmap, ImageView imageview)
    {
        imageview.setImageBitmap(bitmap);
        a(imageview, a);
        return bitmap;
    }
}
