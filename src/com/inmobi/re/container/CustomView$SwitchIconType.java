// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;


public final class  extends Enum
{

    public static final a BACK;
    public static final a CLOSE_BUTTON;
    public static final a CLOSE_ICON;
    public static final a CLOSE_TRANSPARENT;
    public static final a FORWARD_ACTIVE;
    public static final a FORWARD_INACTIVE;
    public static final a REFRESH;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/re/container/CustomView$SwitchIconType, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        CLOSE_BUTTON = new <init>("CLOSE_BUTTON", 0);
        CLOSE_TRANSPARENT = new <init>("CLOSE_TRANSPARENT", 1);
        CLOSE_ICON = new <init>("CLOSE_ICON", 2);
        REFRESH = new <init>("REFRESH", 3);
        BACK = new <init>("BACK", 4);
        FORWARD_ACTIVE = new <init>("FORWARD_ACTIVE", 5);
        FORWARD_INACTIVE = new <init>("FORWARD_INACTIVE", 6);
        e_3B_.clone aclone[] = new <init>[7];
        aclone[0] = CLOSE_BUTTON;
        aclone[1] = CLOSE_TRANSPARENT;
        aclone[2] = CLOSE_ICON;
        aclone[3] = REFRESH;
        aclone[4] = BACK;
        aclone[5] = FORWARD_ACTIVE;
        aclone[6] = FORWARD_INACTIVE;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
