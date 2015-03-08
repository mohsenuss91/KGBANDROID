// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.ImageProcessing;
import com.inmobi.re.controller.util.StartActivityForResultCallback;

// Referenced classes of package com.inmobi.re.controller:
//            JSUtilityController

class a
    implements StartActivityForResultCallback
{

    final JSUtilityController a;

    public void onActivityResult(int i, Intent intent)
    {
        if (i == -1)
        {
            Bitmap bitmap = ImageProcessing.getCompressedBitmap(ImageProcessing.convertMediaUriToPath(intent.getData(), a.mContext), a.mContext);
            int j = bitmap.getWidth();
            int k = bitmap.getHeight();
            String s = ImageProcessing.getBase64EncodedImage(bitmap, a.mContext);
            a.imWebView.raiseGalleryImageSelectedEvent(s, j, k);
            return;
        } else
        {
            a.imWebView.raiseError("User did not select a picture", "getGalleryImage");
            return;
        }
    }

    esultCallback(JSUtilityController jsutilitycontroller)
    {
        a = jsutilitycontroller;
        super();
    }
}
