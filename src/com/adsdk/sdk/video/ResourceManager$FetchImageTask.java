// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.TypedValue;
import com.adsdk.sdk.Log;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

// Referenced classes of package com.adsdk.sdk.video:
//            ResourceManager

class mUrl extends AsyncTask
{

    Context mContext;
    int mResourceId;
    String mUrl;
    final ResourceManager this$0;

    private Drawable fetchImage(String s)
    {
        Bitmap bitmap = BitmapFactory.decodeStream((InputStream)(new URL(s)).getContent());
        if (bitmap == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        int k;
        int l;
        android.util.DisplayMetrics displaymetrics = mContext.getResources().getDisplayMetrics();
        i = bitmap.getWidth();
        j = bitmap.getHeight();
        k = (int)TypedValue.applyDimension(1, i, displaymetrics);
        l = (int)TypedValue.applyDimension(1, j, displaymetrics);
        if (k == i && l == j)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, k, l, false);
_L3:
        BitmapDrawable bitmapdrawable = new BitmapDrawable(mContext.getResources(), bitmap1);
        return bitmapdrawable;
        Exception exception;
        exception;
        Log.e((new StringBuilder("Cannot fetch image:")).append(s).toString(), exception);
_L2:
        return null;
        bitmap1 = bitmap;
          goto _L3
    }

    protected transient Boolean doInBackground(Void avoid[])
    {
        String s = mUrl;
        Drawable drawable = null;
        if (s != null)
        {
            int i = mUrl.length();
            drawable = null;
            if (i > 0)
            {
                drawable = fetchImage(mUrl);
            }
        }
        if (drawable != null)
        {
            ResourceManager.access$1(ResourceManager.this).put(Integer.valueOf(mResourceId), drawable);
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Boolean boolean1)
    {
        super.onPostExecute(boolean1);
        Log.i((new StringBuilder("Fetched: ")).append(mUrl).toString());
        android.os.Message message = ResourceManager.access$0(ResourceManager.this).obtainMessage(100, mResourceId, 0);
        ResourceManager.access$0(ResourceManager.this).sendMessage(message);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    public (Context context, String s, int i)
    {
        this$0 = ResourceManager.this;
        super();
        mContext = context;
        mUrl = s;
        mResourceId = i;
        Log.i((new StringBuilder("Fetching: ")).append(mUrl).toString());
    }
}
