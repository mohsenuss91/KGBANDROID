// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;


final class  extends Enum
{

    public static final l a;
    public static final l b;
    public static final l c;
    public static final l d;
    public static final l e;
    public static final l f;
    public static final l g;
    public static final l h;
    public static final l i;
    public static final l j;
    public static final l k;
    private static final l l[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/re/container/IMWebView$f, s);
    }

    public static [] values()
    {
        return ([])l.clone();
    }

    static 
    {
        a = new <init>("UNKNOWN_ERROR", 0);
        b = new <init>("MISSING_PARAMETER", 1);
        c = new <init>("CONETNT_ID_ERROR", 2);
        d = new <init>("CONTENT_URL_ERROR", 3);
        e = new <init>("CONTENT_URL_NOT_FOUND", 4);
        f = new <init>("NOT_SUPPORTED_SDK", 5);
        g = new <init>("CONTENT_TYPE_NOT_SUPPORTED", 6);
        h = new <init>("CONTENT_SIZE_NOT_SUPPORTED", 7);
        i = new <init>("NETWORK_ERROR", 8);
        j = new <init>("PERMISSION_ERROR", 9);
        k = new <init>("SD_CARD_ERROR", 10);
        f_3B_.clone aclone[] = new <init>[11];
        aclone[0] = a;
        aclone[1] = b;
        aclone[2] = c;
        aclone[3] = d;
        aclone[4] = e;
        aclone[5] = f;
        aclone[6] = g;
        aclone[7] = h;
        aclone[8] = i;
        aclone[9] = j;
        aclone[10] = k;
        l = aclone;
    }

    private (String s, int i1)
    {
        super(s, i1);
    }
}
