// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import com.adsdk.sdk.Log;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;

// Referenced classes of package com.adsdk.sdk.video:
//            AspectRatioImageViewWidth, NavIconData, RichMediaActivity

public class NavIcon extends AspectRatioImageViewWidth
    implements android.view.View.OnClickListener
{

    private Context mContext;
    private Handler mHandler;
    private NavIconData mIcon;

    public NavIcon(Context context, NavIconData navicondata)
    {
        super(context);
        int i = (int)TypedValue.applyDimension(1, 4F, getResources().getDisplayMetrics());
        mContext = context;
        mIcon = navicondata;
        setPadding(i, 0, i, 0);
        mHandler = new Handler();
        setVisibility(8);
        setImageDrawable(navicondata.iconUrl);
        setOnClickListener(this);
    }

    private Drawable fetchImage(String s)
    {
        InputStream inputstream = null;
        InputStream inputstream1 = (InputStream)(new URL(s)).getContent();
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream1);
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
            break MISSING_BLOCK_LABEL_280;
        }
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, k, l, false);
_L7:
        BitmapDrawable bitmapdrawable = new BitmapDrawable(mContext.getResources(), bitmap1);
        Exception exception;
        Exception exception2;
        Exception exception4;
        Drawable drawable;
        Exception exception8;
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            catch (Exception exception7) { }
        }
        return bitmapdrawable;
        exception2;
        inputstream1 = null;
_L6:
        Log.d((new StringBuilder("NavIcon cannot load resource ")).append(s).toString());
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            catch (Exception exception5) { }
        }
        try
        {
            drawable = Drawable.createFromStream((InputStream)(new URL(s)).getContent(), "src");
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception4)
        {
            Log.e((new StringBuilder("Cannot fetch image:")).append(s).toString(), exception4);
            return null;
        }
        return drawable;
        exception;
_L4:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (Exception exception1) { }
        }
        throw exception;
_L2:
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception8) { }
        }
        break MISSING_BLOCK_LABEL_171;
        Exception exception3;
        exception3;
        inputstream = inputstream1;
        exception = exception3;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception6;
        exception6;
        if (true) goto _L6; else goto _L5
_L5:
        bitmap1 = bitmap;
          goto _L7
    }

    private void setImageDrawable(final String url)
    {
        (new Thread(new _cls1())).start();
    }

    public void onClick(View view)
    {
        RichMediaActivity richmediaactivity;
        if (!(mContext instanceof RichMediaActivity))
        {
            break MISSING_BLOCK_LABEL_358;
        }
        richmediaactivity = (RichMediaActivity)mContext;
        if (mIcon.openType == 1)
        {
            richmediaactivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(mIcon.clickUrl)));
            return;
        }
        String s;
        try
        {
            s = mIcon.clickUrl;
            if (s.startsWith("market:") || s.startsWith("http://market.android.com") || s.startsWith("sms:") || s.startsWith("tel:") || s.startsWith("mailto:") || s.startsWith("voicemail:") || s.startsWith("geo:") || s.startsWith("google.streetview:"))
            {
                richmediaactivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                return;
            }
        }
        catch (Exception exception)
        {
            Log.w((new StringBuilder("Couldn't open URL: ")).append(mIcon.clickUrl).toString());
            return;
        }
        if (s.startsWith("mfox:external:"))
        {
            richmediaactivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s.substring(16))));
            return;
        }
        boolean flag = s.startsWith("mfox:replayvideo");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        richmediaactivity.getClass().getMethod("replayVideo", new Class[0]).invoke(richmediaactivity, new Object[0]);
        return;
        NoSuchMethodException nosuchmethodexception1;
        nosuchmethodexception1;
        Log.d("Your activity class has no replayVideo method");
        return;
        Exception exception2;
        exception2;
        Log.d("Couldn't run replayVideo method in your Activity");
        return;
        boolean flag1 = s.startsWith("mfox:playvideo");
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_331;
        }
        richmediaactivity.getClass().getMethod("playVideo", new Class[0]).invoke(richmediaactivity, new Object[0]);
        return;
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        Log.d("Your activity class has no playVideo method");
        return;
        Exception exception1;
        exception1;
        Log.d("Couldn't run replayVideo method in your Activity");
        return;
        if (s.startsWith("mfox:skip"))
        {
            richmediaactivity.finish();
            return;
        }
        richmediaactivity.navigate(mIcon.clickUrl);
    }



    private class _cls1
        implements Runnable
    {

        final NavIcon this$0;
        private final String val$url;

        public void run()
        {
            final Drawable image = fetchImage(url);
            class _cls1
                implements Runnable
            {

                final _cls1 this$1;
                private final Drawable val$image;

                public void run()
                {
                    setImageDrawable(image);
                    setVisibility(0);
                    requestLayout();
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    image = drawable;
                    super();
                }
            }

            if (image != null)
            {
                mHandler.post(new _cls1());
            }
        }


        _cls1()
        {
            this$0 = NavIcon.this;
            url = s;
            super();
        }
    }

}
