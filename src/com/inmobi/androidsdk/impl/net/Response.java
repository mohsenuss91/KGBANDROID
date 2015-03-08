// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.net;


public class Response
{

    String a;
    String b;

    public Response(String s, String s1)
    {
        a = null;
        b = null;
        a = s;
        b = s1;
    }

    public String getAdResponse()
    {
        return b;
    }

    public String getImpressionId()
    {
        return a;
    }
}
