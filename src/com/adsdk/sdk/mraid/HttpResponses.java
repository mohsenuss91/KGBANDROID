// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import java.text.NumberFormat;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

// Referenced classes of package com.adsdk.sdk.mraid:
//            ResponseHeader

public class HttpResponses
{

    public HttpResponses()
    {
    }

    public static boolean extractBooleanHeader(HttpResponse httpresponse, ResponseHeader responseheader, boolean flag)
    {
        String s = extractHeader(httpresponse, responseheader);
        if (s == null)
        {
            return flag;
        } else
        {
            return s.equals("1");
        }
    }

    public static String extractHeader(HttpResponse httpresponse, ResponseHeader responseheader)
    {
        Header header = httpresponse.getFirstHeader(responseheader.getKey());
        if (header != null)
        {
            return header.getValue();
        } else
        {
            return null;
        }
    }

    public static int extractIntHeader(HttpResponse httpresponse, ResponseHeader responseheader, int i)
    {
        Integer integer = extractIntegerHeader(httpresponse, responseheader);
        if (integer == null)
        {
            return i;
        } else
        {
            return integer.intValue();
        }
    }

    public static Integer extractIntegerHeader(HttpResponse httpresponse, ResponseHeader responseheader)
    {
        NumberFormat numberformat = NumberFormat.getInstance(Locale.US);
        numberformat.setParseIntegerOnly(true);
        String s = extractHeader(httpresponse, responseheader);
        Integer integer;
        try
        {
            integer = Integer.valueOf(numberformat.parse(s.trim()).intValue());
        }
        catch (Exception exception)
        {
            return null;
        }
        return integer;
    }
}
