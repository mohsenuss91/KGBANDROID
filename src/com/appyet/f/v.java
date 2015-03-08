// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import android.webkit.MimeTypeMap;

public final class v
{

    public static String a(String s)
    {
        String s1 = MimeTypeMap.getFileExtensionFromUrl(s.substring(s.lastIndexOf('.')));
        String s2 = null;
        if (s1 != null)
        {
            s2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s1);
        }
        return s2;
    }
}
