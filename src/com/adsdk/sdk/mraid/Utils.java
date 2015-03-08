// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Utils
{

    private Utils()
    {
    }

    public static boolean deviceCanHandleIntent(Context context, Intent intent)
    {
        int i = context.getPackageManager().queryIntentActivities(intent, 0).size();
        boolean flag = false;
        if (i > 0)
        {
            flag = true;
        }
        return flag;
    }

    public static String sha1(String s)
    {
        byte abyte0[];
        StringBuffer stringbuffer;
        int i;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            messagedigest.update(s.getBytes());
            abyte0 = messagedigest.digest();
            stringbuffer = new StringBuffer();
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            return "";
        }
        catch (NullPointerException nullpointerexception)
        {
            return "";
        }
        i = 0;
        if (i >= abyte0.length)
        {
            return stringbuffer.toString();
        }
        stringbuffer.append(Integer.toHexString(0x100 | 0xff & abyte0[i]).substring(1));
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_32;
        }
    }
}
