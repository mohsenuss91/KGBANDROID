// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.a.a.b.d:
//            c, b, d

public final class a
    implements c
{

    protected final Context a;
    protected final int b = 5000;
    protected final int c = 20000;

    public a(Context context)
    {
        a = context.getApplicationContext();
    }

    private HttpURLConnection a(String s)
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(Uri.encode(s, "@#&=*+-_.,:!?()/~'%"))).openConnection();
        httpurlconnection.setConnectTimeout(b);
        httpurlconnection.setReadTimeout(c);
        return httpurlconnection;
    }

    public final InputStream a(String s, Object obj)
    {
        int i = 0;
        switch (b.a[d.a(s).ordinal()])
        {
        default:
            throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[] {
                s
            }));

        case 1: // '\001'
        case 2: // '\002'
            HttpURLConnection httpurlconnection;
            for (httpurlconnection = a(s); httpurlconnection.getResponseCode() / 100 == 3 && i < 5; i++)
            {
                httpurlconnection = a(httpurlconnection.getHeaderField("Location"));
            }

            return new BufferedInputStream(httpurlconnection.getInputStream(), 32768);

        case 3: // '\003'
            return new BufferedInputStream(new FileInputStream(d.c.c(s)), 32768);

        case 4: // '\004'
            return a.getContentResolver().openInputStream(Uri.parse(s));

        case 5: // '\005'
            String s1 = d.e.c(s);
            return a.getAssets().open(s1);

        case 6: // '\006'
            int j = Integer.parseInt(d.f.c(s));
            Bitmap bitmap = ((BitmapDrawable)a.getResources().getDrawable(j)).getBitmap();
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 0, bytearrayoutputstream);
            return new ByteArrayInputStream(bytearrayoutputstream.toByteArray());
        }
    }
}
