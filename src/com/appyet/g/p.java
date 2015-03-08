// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g;


// Referenced classes of package com.appyet.g:
//            l

public final class p extends l
{

    private int a;

    public final String getMessage()
    {
        return (new StringBuilder()).append(super.getMessage()).append(" [").append(a).append("]").toString();
    }
}
