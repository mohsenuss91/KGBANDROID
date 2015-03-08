// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;


public final class A extends Enum
{

    public static final a CHROMELESS;
    public static final a DEFAULT;
    public static final a MINIMAL;
    private static final a a[];

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/google/android/youtube/player/YouTubePlayer$PlayerStyle, s);
    }

    public static A[] values()
    {
        return (A[])a.clone();
    }

    static 
    {
        DEFAULT = new <init>("DEFAULT", 0);
        MINIMAL = new <init>("MINIMAL", 1);
        CHROMELESS = new <init>("CHROMELESS", 2);
        e_3B_.clone aclone[] = new <init>[3];
        aclone[0] = DEFAULT;
        aclone[1] = MINIMAL;
        aclone[2] = CHROMELESS;
        a = aclone;
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
