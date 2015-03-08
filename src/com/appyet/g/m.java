// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g;


// Referenced classes of package com.appyet.g:
//            l

public final class m extends l
{

    private String a;
    private int b;

    public m(String s, int i)
    {
        super((new StringBuilder("XMLRPC Fault: ")).append(s).append(" [code ").append(i).append("]").toString());
        a = s;
        b = i;
    }
}
