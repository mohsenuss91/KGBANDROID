// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons;


public final class AnimationType extends Enum
{

    public static final AnimationType ANIMATION_ALPHA;
    public static final AnimationType ANIMATION_OFF;
    public static final AnimationType ROTATE_HORIZONTAL_AXIS;
    public static final AnimationType ROTATE_VERTICAL_AXIS;
    private static final AnimationType a[];

    private AnimationType(String s, int i)
    {
        super(s, i);
    }

    public static AnimationType valueOf(String s)
    {
        return (AnimationType)Enum.valueOf(com/inmobi/commons/AnimationType, s);
    }

    public static AnimationType[] values()
    {
        return (AnimationType[])a.clone();
    }

    static 
    {
        ANIMATION_OFF = new AnimationType("ANIMATION_OFF", 0);
        ROTATE_HORIZONTAL_AXIS = new AnimationType("ROTATE_HORIZONTAL_AXIS", 1);
        ANIMATION_ALPHA = new AnimationType("ANIMATION_ALPHA", 2);
        ROTATE_VERTICAL_AXIS = new AnimationType("ROTATE_VERTICAL_AXIS", 3);
        AnimationType aanimationtype[] = new AnimationType[4];
        aanimationtype[0] = ANIMATION_OFF;
        aanimationtype[1] = ROTATE_HORIZONTAL_AXIS;
        aanimationtype[2] = ANIMATION_ALPHA;
        aanimationtype[3] = ROTATE_VERTICAL_AXIS;
        a = aanimationtype;
    }
}
