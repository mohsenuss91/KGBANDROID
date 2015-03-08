// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller.util;


public final class  extends Enum
{

    public static final a COMPLETED;
    public static final a HIDDEN;
    public static final a INIT;
    public static final a PAUSED;
    public static final a PLAYING;
    public static final a RELEASED;
    public static final a SHOWING;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/re/controller/util/AVPlayer$playerState, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        INIT = new <init>("INIT", 0);
        PLAYING = new <init>("PLAYING", 1);
        PAUSED = new <init>("PAUSED", 2);
        HIDDEN = new <init>("HIDDEN", 3);
        SHOWING = new <init>("SHOWING", 4);
        COMPLETED = new <init>("COMPLETED", 5);
        RELEASED = new <init>("RELEASED", 6);
        e_3B_.clone aclone[] = new <init>[7];
        aclone[0] = INIT;
        aclone[1] = PLAYING;
        aclone[2] = PAUSED;
        aclone[3] = HIDDEN;
        aclone[4] = SHOWING;
        aclone[5] = COMPLETED;
        aclone[6] = RELEASED;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
