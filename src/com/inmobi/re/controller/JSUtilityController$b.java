// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.ImageProcessing;
import com.inmobi.re.controller.util.StartActivityForResultCallback;

// Referenced classes of package com.inmobi.re.controller:
//            JSUtilityController

class a
    implements StartActivityForResultCallback
{

    final Uri a;
    final JSUtilityController b;

    public void onActivityResult(int i, Intent intent)
    {
        if (i == -1)
        {
            String s;
            Bitmap bitmap;
            int j;
            int k;
            String s1;
            if (intent == null)
            {
                s = ImageProcessing.convertMediaUriToPath(a, b.mContext);
            } else
            {
                s = ImageProcessing.convertMediaUriToPath(intent.getData(), b.mContext);
            }
            bitmap = ImageProcessing.getCompressedBitmap(s, b.mContext);
            j = bitmap.getWidth();
            k = bitmap.getHeight();
            s1 = ImageProcessing.getBase64EncodedImage(bitmap, b.mContext);
            b.imWebView.raiseCameraPictureCapturedEvent(s1, j, k);
            return;
        } else
        {
            b.imWebView.raiseError("User did not take a picture", "takeCameraPicture");
            return;
        }
    }

    esultCallback(JSUtilityController jsutilitycontroller, Uri uri)
    {
        b = jsutilitycontroller;
        a = uri;
        super();
    }
}
