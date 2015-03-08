// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// Referenced classes of package com.appyet.f:
//            p

public final class z
{

    public static String a(String s)
    {
        String s2 = URLDecoder.decode(URLDecoder.decode(p.e.a(s), "UTF-8"), "UTF-8");
        String s1 = s2;
_L2:
        return s1.replace("\n", "");
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        s1 = "";
        if (true) goto _L2; else goto _L1
_L1:
    }
}
