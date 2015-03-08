// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.inmobi.commons.internal.Base64;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageProcessing
{

    public ImageProcessing()
    {
    }

    public static String convertMediaUriToPath(Uri uri, Context context)
    {
        String as[] = {
            "_data"
        };
        Cursor cursor = context.getContentResolver().query(uri, as, null, null, null);
        int i = cursor.getColumnIndexOrThrow("_data");
        cursor.moveToFirst();
        String s = cursor.getString(i);
        cursor.close();
        return s;
    }

    public static String getBase64EncodedImage(Bitmap bitmap, Context context)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        int i = getDefaultImgQuality(context);
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, i, bytearrayoutputstream);
        return Base64.encodeToString(bytearrayoutputstream.toByteArray(), 2);
    }

    public static Bitmap getCompressedBitmap(String s, Context context)
    {
        int i;
        android.graphics.BitmapFactory.Options options;
        int j;
        FileInputStream fileinputstream1;
        Bitmap bitmap;
        Bitmap bitmap1;
        int k;
        android.graphics.BitmapFactory.Options options1;
        Bitmap bitmap2;
        int l;
        int i1;
        double d;
        try
        {
            i = getDefaultImgWidth(context) * getDefaultImgHeight(context);
            FileInputStream fileinputstream = new FileInputStream(s);
            options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(fileinputstream, null, options);
            fileinputstream.close();
        }
        catch (IOException ioexception)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", ioexception.getMessage(), ioexception);
            return null;
        }
        j = 1;
        while ((double)(options.outWidth * options.outHeight) * (1.0D / Math.pow(j, 2D)) > (double)i) 
        {
            j++;
        }
        fileinputstream1 = new FileInputStream(s);
        if (j <= 1) goto _L2; else goto _L1
_L1:
        k = j - 1;
        options1 = new android.graphics.BitmapFactory.Options();
        options1.inSampleSize = k;
        bitmap2 = BitmapFactory.decodeStream(fileinputstream1, null, options1);
        l = bitmap2.getHeight();
        i1 = bitmap2.getWidth();
        d = Math.sqrt((double)i / ((double)i1 / (double)l));
        bitmap1 = Bitmap.createScaledBitmap(bitmap2, (int)((d / (double)l) * (double)i1), (int)d, true);
        bitmap2.recycle();
        System.gc();
_L3:
        fileinputstream1.close();
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("bitmap size - width: ")).append(bitmap1.getWidth()).append(", height: ").append(bitmap1.getHeight()).toString());
        return bitmap1;
_L2:
        bitmap = BitmapFactory.decodeStream(fileinputstream1);
        bitmap1 = bitmap;
          goto _L3
    }

    public static int getDefaultImgHeight(Context context)
    {
        return Initializer.getConfigParams().getPicHeight();
    }

    public static int getDefaultImgQuality(Context context)
    {
        return Initializer.getConfigParams().getPicQuality();
    }

    public static int getDefaultImgWidth(Context context)
    {
        return Initializer.getConfigParams().getPicWidth();
    }
}
