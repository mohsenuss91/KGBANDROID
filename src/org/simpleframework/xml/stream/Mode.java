// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


public final class Mode extends Enum
{

    private static final Mode $VALUES[];
    public static final Mode DATA;
    public static final Mode ESCAPE;
    public static final Mode INHERIT;

    private Mode(String s, int i)
    {
        super(s, i);
    }

    public static Mode valueOf(String s)
    {
        return (Mode)Enum.valueOf(org/simpleframework/xml/stream/Mode, s);
    }

    public static Mode[] values()
    {
        return (Mode[])$VALUES.clone();
    }

    static 
    {
        DATA = new Mode("DATA", 0);
        ESCAPE = new Mode("ESCAPE", 1);
        INHERIT = new Mode("INHERIT", 2);
        Mode amode[] = new Mode[3];
        amode[0] = DATA;
        amode[1] = ESCAPE;
        amode[2] = INHERIT;
        $VALUES = amode;
    }
}
