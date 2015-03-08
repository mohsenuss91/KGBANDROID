// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;


public final class aa
{

    public static String a(String s)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.length() != 0) goto _L3; else goto _L2
_L3:
        int i;
        int j;
        int k;
        int l;
        try
        {
            i = s.indexOf("//");
        }
        catch (Exception exception)
        {
            return null;
        }
        j = 0;
        if (i != -1)
        {
            j = i + 2;
        }
        k = s.indexOf('/', j);
        if (k < 0) goto _L5; else goto _L4
_L4:
        return s.substring(0, k);
_L5:
        l = s.length();
        k = l;
        if (true) goto _L4; else goto _L2
_L2:
        return "";
    }
}
