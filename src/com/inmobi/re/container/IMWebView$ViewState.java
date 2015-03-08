// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;


public final class  extends Enum
{

    public static final a DEFAULT;
    public static final a EXPANDED;
    public static final a EXPANDING;
    public static final a HIDDEN;
    public static final a LOADING;
    public static final a RESIZED;
    public static final a RESIZING;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/re/container/IMWebView$ViewState, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        LOADING = new <init>("LOADING", 0);
        DEFAULT = new <init>("DEFAULT", 1);
        RESIZED = new <init>("RESIZED", 2);
        EXPANDED = new <init>("EXPANDED", 3);
        EXPANDING = new <init>("EXPANDING", 4);
        HIDDEN = new <init>("HIDDEN", 5);
        RESIZING = new <init>("RESIZING", 6);
        e_3B_.clone aclone[] = new <init>[7];
        aclone[0] = LOADING;
        aclone[1] = DEFAULT;
        aclone[2] = RESIZED;
        aclone[3] = EXPANDED;
        aclone[4] = EXPANDING;
        aclone[5] = HIDDEN;
        aclone[6] = RESIZING;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
